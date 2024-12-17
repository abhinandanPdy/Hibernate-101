package org.abhinandanpdy.entity;

import java.util.List;

public class Question {

    private int id;
    private String qname;

//    @ElementCollection // Main annotation
//    @CollectionTable(name = "question_options", joinColumns = @JoinColumn(name = "question_id"))
//    @Column(name = "option_value") // Changed the column name
    private List<String> options;

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
