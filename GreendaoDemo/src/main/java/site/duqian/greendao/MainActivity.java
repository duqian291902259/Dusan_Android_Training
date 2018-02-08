package site.duqian.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import site.duqian.greendao.demo1.Note;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tv_result;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private NoteDao noteDao;
    private Query query;
    private MusicDao musicDao;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result = (TextView) findViewById(R.id.tv_result);
        context = this;
        tv_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //testDB();
                    testMusic();
                }catch (Exception e){
                    Log.d(TAG,"db error "+e);
                }
            }
        });
        initDb();
    }

    private void testMusic() {
        MusicDbHelper dbHelper = MusicDbHelper.init(context);
        /*for (int i = 0; i<40; i++){
            Music musicItemInfo = new Music(1000+i+"","红尘情歌 afjadlfadfdfasdfdsf阿斯顿发"+i+".mp3",132112+i*1000, "haha");
            musicItemInfo.addTime = System.currentTimeMillis();
            dbHelper.insertMusic(musicItemInfo);
        }*/

        List<Music> allMusicList = dbHelper.getAllMusicList();
        Music music = allMusicList.get(0);
        Log.d(TAG,"music "+music+",allMusicList size="+allMusicList.size());
        Music music3 = allMusicList.get(4);
        music3.setAddTime(System.currentTimeMillis());
        Log.d(TAG,"music3 "+music3);

        tv_result.setText(music.toString());

        dbHelper.deleteByMusicId(music.getMusic_id());

        dbHelper.deleteMusic(allMusicList.get(1));

        List<Music> musicListWithLimit = dbHelper.getMusicListWithLimit(10, 5);
        Log.d(TAG,"musicListWithLimit "+musicListWithLimit.size()+"--"+musicListWithLimit.get(0));

        dbHelper.updateMusicById(music3.getMusic_id());
        dbHelper.updateMusic(music3);

        dbHelper.getMusicByID(music3.getMusic_id());
        long musicTotalCount = dbHelper.getMusicTotalCount();

        String msg = "music3 " + music3 + ",musicTotalCount=" + musicTotalCount;
        Log.d(TAG, msg);
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();

    }

    private void testDB() {
        addNote();
        search();
        delete();
        search();
    }

    private void initDb() {
        // 官方推荐将获取 DaoMaster 对象的方法放到 Application 层，这样将避免多次创建生成 Session 对象
        setupDatabase();
        // 获取 NoteDao 对象
        noteDao = getNoteDao();
    }

    private void setupDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    private NoteDao getNoteDao() {
        return daoSession.getNoteDao();
    }

    private int count = 0;
    private void addNote() {
        String noteText = "Test"+count;

        final DateFormat df = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
        String comment = "Added on " + df.format(new Date());

        // 插入操作，简单到只要你创建一个 Java 对象
        Note note = new Note(System.currentTimeMillis(),noteText, new Date());
        noteDao.insert(note);
        Log.d(TAG, "Inserted new note, ID: " + note.getId());
        count++;
    }

    private void search() {
        // Query 类代表了一个可以被重复执行的查询
        query = getNoteDao().queryBuilder()
                //.where(NoteDao.Properties.Text.eq("Test1"))
                .orderAsc(NoteDao.Properties.Date)
                .build();

//      查询结果以 List 返回
        List<Note> notes = query.list();
        Log.d(TAG, "searched num " + notes.size());
        // 在 QueryBuilder 类中内置两个 Flag 用于方便输出执行的 SQL 语句与传递参数的值
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;

        /*for (Note note:notes){
            Log.d(TAG, " note " + note.getText());
        }*/
    }

    protected void delete() {
        List<Note> note = noteDao.queryBuilder()
                //.where(NoteDao.Properties.Text.eq("Test1"))
                .build().list();
        // 删除操作，你可以通过「id」也可以一次性删除所有
        if (note ==null|| note.size()==0)return;
        long id = note.get(5).getId();
        noteDao.deleteByKey(id);
//        getNoteDao().deleteAll();
        Log.d(TAG, "Deleted note, ID: " + id);
    }

}
