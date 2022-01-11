package selflearn.springmvc.first.bean;

import java.util.Date;

public class Book {
    private int id;
    private String name;//书名
    private String img;//图谱路径
    private String fileUrl;//文件路径
    private String author;//作者
    private int pont = 0;//下载次数
    private int loadperson;//上传人
    private Date loadtime;//上传时间


    public Book(int id, String name, String img, String fileUrl, String author, int pont, int loadperson, Date loadtime) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.fileUrl = fileUrl;
        this.author = author;
        this.pont = pont;
        this.loadperson = loadperson;
        this.loadtime = loadtime;
    }

    public Date getLoadtime() {
        return loadtime;
    }

    public void setLoadtime(Date loadtime) {
        this.loadtime = loadtime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", author='" + author + '\'' +
                ", pont=" + pont +
                ", loadperson=" + loadperson +
                ", loadtime=" + loadtime +
                '}';
    }

    public int getLoadperson() {
        return loadperson;
    }

    public void setLoadperson(int loadperson) {
        this.loadperson = loadperson;
    }

    public Book() {
    }

    public int getPont() {
        return pont;
    }

    public void setPont(int pont) {
        this.pont = pont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
