package edu.chenjin.jdbc.entity;

import edu.chenjin.jdbc.annotation.Column;
import edu.chenjin.jdbc.annotation.Id;
import edu.chenjin.jdbc.annotation.Table;

/**
 * 学院实体，对应 DateTest 库中的 college 表。
 */
@Table("college")
public class College {

    @Id
    @Column("id")
    private String id;

    @Column("name")
    private String name;

    @Column("code")
    private String code;

    public College() {
    }

    public College(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "College{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
