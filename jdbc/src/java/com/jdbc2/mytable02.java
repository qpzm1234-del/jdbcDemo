package com.jdbc2;

public class mytable02 {
    private Integer id;
    private String name;
    private String cla;
    private Integer math;
    private Integer english;
    private Integer chinese;

    @Override
    public String toString() {
        return "mytable02{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cla='" + cla + '\'' +
                ", math=" + math +
                ", english=" + english +
                ", chinese=" + chinese +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getChinese() {
        return chinese;
    }

    public void setChinese(Integer chinese) {
        this.chinese = chinese;
    }
}
