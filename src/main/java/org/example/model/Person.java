package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//=======
@Entity
@Table(name = "PERSON")
public class Person {
    public Person(){}
    public Person(String firstName, String lastName, int age, Rule rule, Rule ruleTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.rule = rule;
        this.ruleTitle = ruleTitle;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "rule")
    @Enumerated/* = @Enumerated(EnumType.ORDINAL)*/
    private Rule rule;
    @Column(name = "ruleTitle")
    @Enumerated(EnumType.STRING)
    private Rule ruleTitle;
}
