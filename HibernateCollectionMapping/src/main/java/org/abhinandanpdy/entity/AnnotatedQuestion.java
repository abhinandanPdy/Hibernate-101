package org.abhinandanpdy.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "questions")
public class AnnotatedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "QNAME")
    private String qname;

    @ElementCollection // Main annotation
    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "ID"))
    @Column(name = "OPTION_VALUE") // Changed the column name
    private List<String> options;

    @Column(name = "ANSWER")
    private String answer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
