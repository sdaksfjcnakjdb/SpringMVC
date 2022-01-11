package selflearn.springmvc.first.Dao.userbook;

import org.springframework.stereotype.Repository;
import selflearn.springmvc.first.bean.UserBook;

@Repository
public interface userbookDao {
    public void add(UserBook userBook);

    public void delete(UserBook userBook);
}
