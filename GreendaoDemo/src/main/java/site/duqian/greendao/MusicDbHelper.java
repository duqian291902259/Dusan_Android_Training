package site.duqian.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * Description:使用过的音乐本地化存储
 *
 * @author 杜乾-duqian,Created on 2017/6/7 - 12:55.
 *         E-mail:duqian2010@gmail.com
 */
public class MusicDbHelper {
    private static final String TAG = MusicDbHelper.class.getSimpleName();
    private static MusicDbHelper instance;
    private Context context;

    public static MusicDbHelper init(Context context) {
        if (instance == null) {
            synchronized (MusicDbHelper.class) {
                if (instance == null) {
                    instance = new MusicDbHelper(context);
                }
            }
        }
        return instance;
    }

    private MusicDbHelper(Context context) {
        this.context = context;
        //dbManager = DBManager.getInstance();
        openHelper = new DBOpenHelper(context, dbName);
        Log.d(TAG,"openHelper "+openHelper);
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    private final static String dbName = "music_db";
    private DBOpenHelper openHelper;

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DBOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DBOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    //插入音乐文件
    public boolean insertMusic(Music music) {
        if (music == null) {
            return false;
        }
        MusicDao musicDao = getMusicWriteableDao();
        long insert = musicDao.insert(music);
        Log.d(TAG, "insert music " + insert);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    //更新音乐文件
    public void updateMusic(Music music) {
        if (music == null) {
            return ;
        }
        MusicDao musicDao = getMusicWriteableDao();
        musicDao.update(music);
        Log.d(TAG, "updateMusic  ");
    }

    /**
     * 更新使用过的状态，更新最新使用的时间
     */
    public void updateMusicById(String musicId) {
        // TODO: 2017/6/7 有问题?
        try {
            long addTime = System.currentTimeMillis();
            SQLiteDatabase db = getWritableDatabase();
            MusicDao musicDao = getMusicWriteableDao();
            String tablename = musicDao.getTablename();
            //MusicDao.Properties.AddTime 得到的是 org.greenrobot.greendao.Property@4218c6b8
           /* String[] allColumns = musicDao.getAllColumns();
            for (String col:allColumns){
                Log.d(TAG, "updateMusicById col " + col);
            }*/
            String set =  "ADD_TIME=" + addTime;
            String sql = "UPDATE " + tablename + " SET " + set + " WHERE MUSIC_ID=" + musicId;
            db.execSQL(sql);
            db.close();
            Log.d(TAG, "updateMusicById  " + sql);
        }catch (Exception e){
            Log.d(TAG, "updateMusicById  error " + e);
        }
    }

    /**
     * 删除音乐
     * @param music
     */
    public void deleteMusic(Music music) {
        if (music == null) {
            return ;
        }
        MusicDao musicDao = getMusicWriteableDao();
        musicDao.delete(music);
        Log.d(TAG, "deleteMusic  ");
    }

    /**
     * 根据musicID，删除music文件
     * @param musicID
     */
    public void deleteByMusicId(String musicID) {
        if (TextUtils.isEmpty(musicID)) {
            return;
        }
        MusicDao musicDao = getMusicWriteableDao();
        Music music = musicDao.queryBuilder()
                .where(MusicDao.Properties.Music_id.eq(musicID))
                .build().forCurrentThread().unique();
        musicDao.delete(music);
        Log.d(TAG, "deleteByMusicId  "+musicID);
    }

    /**
     * 获取部分音乐文件
     * @param offset 偏移量，从第offset个开始，不包含
     * @param limit 获取文件的个数
     * @return
     */
    public List<Music> getMusicListWithLimit(int offset, int limit) {
        MusicDao musicDao = getMusicReadableDao();
        List<Music> list = musicDao.queryBuilder().offset(offset).limit(limit)
                //.where(MusicDao.Properties.Music_id.eq(musicID))
                .orderDesc(MusicDao.Properties.AddTime)
                .build().listLazyUncached();
        Log.d(TAG, "getMusicListWithLimit  "+list +",limit="+limit);
        return (list!=null&&list.size()>0)?list:null;
    }

    /**
     * 获取所有已用音乐文件记录
     * @return
     */
    public List<Music> getAllMusicList() {
        MusicDao musicDao = getMusicReadableDao();
        List<Music> list = musicDao.queryBuilder()
                .orderDesc(MusicDao.Properties.AddTime)
                .build().listLazyUncached();
        Log.d(TAG, "getAllMusicList  "+list );
        if (list!=null&&list.size()>=100){
            // TODO: 2017/6/7 删除数据库100条后面的记录以及对应的文件,close
            return list.subList(0,100);
        }
        return (list!=null&&list.size()>0)?list:null;
    }

    public Music getMusicByID(String musicID) {
        if (TextUtils.isEmpty(musicID)) {
            return null;
        }
        MusicDao musicDao = getMusicReadableDao();
        Music music = musicDao.queryBuilder()
                .where(MusicDao.Properties.Music_id.eq(musicID))
                .build().forCurrentThread().unique();
        Log.d(TAG, "getMusicByID  "+music );
        return music;
    }


    public long getMusicTotalCount() {
        MusicDao musicDao = getMusicReadableDao();
        long count  = musicDao.queryBuilder().count();
        Log.d(TAG, "getMusicTotalCount  "+count );
        return count;
    }

    //可写数据库dao
    private MusicDao getMusicWriteableDao() {
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        return daoSession.getMusicDao();
    }

    //可读数据库dao
    private MusicDao getMusicReadableDao() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        return daoSession.getMusicDao();
    }

}
