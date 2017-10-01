package com.example.datajpa.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "PHONE")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Data
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "MODEL")
    private String model;

    public Phone(String model) {
        this.model = model;
    }

}
