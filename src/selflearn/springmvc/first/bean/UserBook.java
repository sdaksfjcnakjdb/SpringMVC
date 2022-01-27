package selflearn.springmvc.first.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
@Component
public class UserBook {
    private int id;
    private int personid;
    private int bookid;
    private Data creattime;

    public UserBook() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public Data getCreattime() {
        return creattime;
    }

    public void setCreattime(Data creattime) {
        this.creattime = creattime;
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "id=" + id +
                ", personid=" + personid +
                ", bookid=" + bookid +
                ", creattime=" + creattime +
                '}';
    }
}
