package site.duqian.greendao.demo1;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.util.Date;

/**
 * Description:
 *
 * @author 杜乾-duqian,Created on 2017/6/7 - 10:32.
 *         E-mail:duqian2010@gmail.com
 *         Error:Execution failed for task ':app:greendao'.
> Constructor (see Note:28) has been changed after generation.
Please either mark it with @Keep annotation instead of @Generated to keep it untouched,
or use @Generated (without hash) to allow to replace it.
 */
    @Entity(indexes = {
            @Index(value = "text, date DESC", unique = true)
    })
    public class Note {

        @Id//(autoincrement = true)
        private long id;

        @NotNull
        private String text;
        private Date date;

        @Generated(hash = 1899817729)
        public Note(long id, @NotNull String text, Date date) {
            this.id = id;
            this.text = text;
            this.date = date;
        }

        @Generated(hash = 1272611929)
        public Note() {
        }
        public long getId() {
            return this.id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getText() {
            return this.text;
        }
        public void setText(String text) {
            this.text = text;
        }
        public Date getDate() {
            return this.date;
        }
        public void setDate(Date date) {
            this.date = date;
        }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
