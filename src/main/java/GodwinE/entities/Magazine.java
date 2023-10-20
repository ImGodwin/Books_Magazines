package GodwinE.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "magazine")
public class Magazine {

    @Id
    @GeneratedValue
    private UUID id;
    private int isbn;
    private String title;
    private String yearPublished;
    private int pages;
    private Release releaseStyle;


}
