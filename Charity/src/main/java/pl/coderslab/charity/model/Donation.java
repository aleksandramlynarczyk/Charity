package pl.coderslab.charity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name = "donation")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private Integer quantity;

    @OneToMany(mappedBy = "donation", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @NotBlank
    String street;

    @NotBlank
    String city;

    @NotBlank
    @Column(name = "zip_code")
    String zipCode;

    @NotBlank
    @Column(name = "pick_up_date")
    LocalDate pickUpDate;

    @NotBlank
    @Column(name = "pick_up_time")
    LocalTime pickUpTime;

    @NotBlank
    @Column(name = "pick_up_comment")
    String pickUpComment;











}
