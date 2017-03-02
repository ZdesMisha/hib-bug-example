package hibernate.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kharkov on 30.01.17.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    public Person(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    @NotEmpty
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cat> cats = new ArrayList<Cat>();

    public void setCats(List<Cat> cats) {
        this.cats.clear();
        this.cats.addAll(cats);
    }
}
