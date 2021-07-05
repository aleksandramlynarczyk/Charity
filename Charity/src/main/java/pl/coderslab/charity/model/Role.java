package pl.coderslab.charity.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "roles")
@Entity
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}