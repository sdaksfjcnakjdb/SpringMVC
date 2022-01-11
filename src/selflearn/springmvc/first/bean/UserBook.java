package selflearn.springmvc.first.bean;

import javax.xml.crypto.Data;

public class UserBook {
    private int id;
    private int personid;
    private int bookid;
    private Data creattime;

    public UserBook(int id, int personid, int bookid, Data creattime) {
        this.id = id;
        this.personid = personid;
        this.bookid = bookid;
        this.creattime = creattime;
    }

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
