package edu.chenjin.jdbc.entity;

import edu.chenjin.jdbc.annotation.Column;
import edu.chenjin.jdbc.annotation.Id;
import edu.chenjin.jdbc.annotation.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * 学生实体，对应 DateTest 库中的 student 表。
 */
@Table("student")
public class Student {

    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("major")
    private String major;

    @Column("age")
    private Integer age;

    /** 入学时间 */
    @Column("enrollment_time")
    private LocalDate enrollmentTime;

    /** 是否毕业 */
    @Column("graduated")
    private Boolean graduated;

    /** 学费 */
    @Column("tuition")
    private BigDecimal tuition;

    public Student() {
    }

    public Student(String id, String name, String major, Integer age,
                   LocalDate enrollmentTime, Boolean graduated, BigDecimal tuition) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.age = age;
        this.enrollmentTime = enrollmentTime;
        this.graduated = graduated;
        this.tuition = tuition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getEnrollmentTime() {
        return enrollmentTime;
    }

    public void setEnrollmentTime(LocalDate enrollmentTime) {
        this.enrollmentTime = enrollmentTime;
    }

    public Boolean getGraduated() {
        return graduated;
    }

    public void setGraduated(Boolean graduated) {
        this.graduated = graduated;
    }

    public BigDecimal getTuition() {
        return tuition;
    }

    public void setTuition(BigDecimal tuition) {
        this.tuition = tuition;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                ", enrollmentTime=" + enrollmentTime +
                ", graduated=" + graduated +
                ", tuition=" + tuition +
                '}';
    }
}
