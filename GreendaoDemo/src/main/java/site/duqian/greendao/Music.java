package site.duqian.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;

/**
 * Description:
 *
 * @author 杜乾-duqian,Created on 2017/6/7 - 16:22.
 *         E-mail:duqian2010@gmail.com
 */
@Entity
public class Music {
    @Id(autoincrement = true)
    private Long id;

    @NotNull @Unique
    public String music_id;//音乐文件ID，唯一标示

    public String music_name;//音乐名称
    public int duration;//总时长
    public String res_url;//服务端下载地址

    public String localPath;//本地music文件路径
    public long addTime;//本地更新时间

    //不存入数据库的字段 //添加Transient标记
    @Transient
    private int currentPosition = 0;//当前播放进度
    @Transient
    private boolean isChecked;//是否选择
    @Transient
    private boolean isDownloaded;//是否下载

    @Generated(hash = 1027878192)
    public Music(Long id, @NotNull String music_id, String music_name, int duration,
            String res_url, String localPath, long addTime) {
        this.id = id;
        this.music_id = music_id;
        this.music_name = music_name;
        this.duration = duration;
        this.res_url = res_url;
        this.localPath = localPath;
        this.addTime = addTime;
    }
    @Generated(hash = 1263212761)
    public Music() {
    }


    //used or local
    public Music(String music_id, int duration, String music_name, String localPath) {
        this.music_id = music_id;
        this.duration = duration;
        this.music_name = music_name;
        this.localPath = localPath;
    }

    //网络
    public Music(String music_id, String music_name, int duration, String res_url) {
        this.music_id = music_id;
        this.music_name = music_name;
        this.duration = duration;
        this.res_url = res_url;
    }

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMusic_id() {
        return this.music_id;
    }
    public void setMusic_id(String music_id) {
        this.music_id = music_id;
    }
    public String getMusic_name() {
        return this.music_name;
    }
    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }
    public int getDuration() {
        return this.duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getRes_url() {
        return this.res_url;
    }
    public void setRes_url(String res_url) {
        this.res_url = res_url;
    }
    public String getLocalPath() {
        return this.localPath;
    }
    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
    public long getAddTime() {
        return this.addTime;
    }
    public void setAddTime(long addTime) {
        this.addTime = addTime;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isDownloaded() {
        return isDownloaded;
    }

    public void setDownloaded(boolean downloaded) {
        isDownloaded = downloaded;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", music_id='" + music_id + '\'' +
                ", music_name='" + music_name + '\'' +
                ", duration=" + duration +
                ", res_url='" + res_url + '\'' +
                ", localPath='" + localPath + '\'' +
                ", addTime='" + addTime + '\'' +
                ", currentPosition=" + currentPosition +
                ", isChecked=" + isChecked +
                ", isDownloaded=" + isDownloaded +
                '}';
    }
}
