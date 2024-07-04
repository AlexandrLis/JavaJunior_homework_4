import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {


        Configuration configuration = new Configuration();
        configuration.configure();
        try(SessionFactory sessionFactory = configuration.buildSessionFactory()){
            myMethod(sessionFactory);
            deleteMethod(sessionFactory);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void myMethod(SessionFactory sessionFactory){
//      вывод в терминал моих таблиц-классов Базы Данных
        try(Session session = sessionFactory.openSession()){
            Post post = session.find(Post.class, 1L);
            PostComment postComment = session.find(PostComment.class, 1L);
            System.out.println("MyPost #1: " + post);
            System.out.println("MyPostComment #1: " + postComment);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteMethod(SessionFactory sessionFactory){
//      удаление таблиц-классов Базы Данных
        try(Session session = sessionFactory.openSession()){
            Post toDeletePost = session.find(Post.class, 1L);
            PostComment toDeletePostComment = session.find(PostComment.class, 1L);
            Transaction transaction = session.beginTransaction();
            session.remove(toDeletePost);
            session.remove(toDeletePostComment);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
