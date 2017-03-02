package hibernate.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by kharkov on 30.01.17.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cat")
public class Cat {

    public Cat(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
