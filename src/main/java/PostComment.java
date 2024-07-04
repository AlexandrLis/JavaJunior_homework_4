import jakarta.persistence.*;

@Entity
@Table(name="postcomment")
public class PostComment {
    @Id
    @Column(name="id")
    private long id;

    @Column(name="text")
    private String text;

//  в таблице будет создан столбец - внешний ключ post_id
//  со связью Многие к Одному (у одного Post может быть много PostComment)
    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


    @Override
    public String toString() {
        return "id: " + id + ", text: " + text + ", post_id: " + post;
    }

}
