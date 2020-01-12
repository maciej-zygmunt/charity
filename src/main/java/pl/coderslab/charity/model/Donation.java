package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="donations")
public class Donation {
    /*

    id
    quantity (liczba worków)
    categories (lista obiektów typu Category), pamiętaj o odpowiedniej adnotacji
    institution (obiekt typu Institution), pamiętaj o odpowiedniej adnotacji.
    street
    city
    zipCode
    pickUpDate
    pickUpTime
    pickUpComment

     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Category> categories= new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Institution institution;
    private String street;
    private String city;
    private String zipCode;
    private Date pickupDate;
    private Time pickupTime;
    private String pickupComment;
}
