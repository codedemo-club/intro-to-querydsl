package club.codedemo.introtoquerydsl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 学生
 */
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 学号
     */
    private String no;

    /**
     * 体重
     */
    private Integer weight;

    /**
     * 所在班级
     */
    @ManyToOne
    private Klass klass;

    /**
     * 拥有的课程
     */
    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String no, Integer weight) {
        this.name = name;
        this.no = no;
        this.weight = weight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }
}
