package selflearn.springmvc.first.Dao.book;

import com.sun.xml.internal.bind.v2.model.core.ID;
import selflearn.springmvc.first.bean.Book;
import selflearn.springmvc.first.bean.User;

import java.util.ArrayList;
import java.util.List;

public interface BookDao {
    public ArrayList<Book> selectAll(User user);

    public int  add(Book bean);

    public void update(Book bean);

    public void  delete(Book bean);

    public void pontchange(Book bean);

    public Book selectById(Book bean);

    public List<Book> selectByName(Book bean);

    public List<Book> selectByauthor(Book bean);


    public List<Book> selectBy(Book bean);
}
