package com.implementacaoiii.praticaintegradora1.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_case;

    @Column (length = 50,nullable = false)
    private String description;

    private boolean tested;
    private boolean passed;

    private int number_of_tries;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date last_update;
}
