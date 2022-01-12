package selflearn.springmvc.first.Dao.userbook;

import org.springframework.stereotype.Repository;
import selflearn.springmvc.first.bean.UserBook;

import java.util.List;

@Repository
public interface UserBookDao {
    public void add(UserBook userBook);

    public void delete(UserBook userBook);

    public List<UserBook> selectby(UserBook userBook);
}
