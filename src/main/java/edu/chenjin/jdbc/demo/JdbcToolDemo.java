package edu.chenjin.jdbc.demo;

import edu.chenjin.jdbc.entity.College;
import edu.chenjin.jdbc.entity.Student;
import edu.chenjin.jdbc.util.DBUtil;
import edu.chenjin.jdbc.util.JDBCTool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

/**
 * 使用 JDBCTool 对 DateTest 库中的 student、college 两张表做增删改查演示。
 */
public class JdbcToolDemo {

    public static void main(String[] args) {
        System.out.println("========== JDBCTool 简易 ORM 演示 ==========");
        try (Connection connection = DBUtil.getConnection()) {
            demoCollege(connection);
            demoStudent(connection);
            System.out.println("========== 全部演示完成 ==========");
        } catch (Exception e) {
            System.err.println("演示过程中发生异常: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void demoCollege(Connection connection) {
        banner("学院表 college 增删改查");

        College computer = new College("C001", "计算机学院", "CS");
        College software = new College("C002", "软件学院", "SE");
        College math = new College("C003", "数学学院", "MATH");

        System.out.println("【新增】插入 3 条学院记录");
        JDBCTool.save(computer, connection);
        JDBCTool.save(software, connection);
        JDBCTool.save(math, connection);

        System.out.println("【查询全部】");
        printList(JDBCTool.findAll(College.class, connection));

        System.out.println("【按主键查询】id = C002");
        College one = JDBCTool.getOneById("C002", College.class, connection);
        System.out.println("  结果: " + one);

        System.out.println("【更新】将软件学院代码 SE 改为 SOFT");
        software.setCode("SOFT");
        JDBCTool.update(software, connection);
        System.out.println("  更新后: " + JDBCTool.getOneById("C002", College.class, connection));

        System.out.println("【删除】删除数学学院 C003");
        JDBCTool.delete(math, connection);
        System.out.println("【删除后全部学院】");
        printList(JDBCTool.findAll(College.class, connection));
    }

    private static void demoStudent(Connection connection) {
        banner("学生表 student 增删改查");

        Student s1 = new Student("S001", "张三", "软件工程", 20,
                LocalDate.of(2023, 9, 1), false, new BigDecimal("5800.00"));
        Student s2 = new Student("S002", "李四", "计算机科学与技术", 21,
                LocalDate.of(2022, 9, 1), false, new BigDecimal("6200.50"));
        Student s3 = new Student("S003", "王五", "数据科学", 22,
                LocalDate.of(2021, 9, 1), true, new BigDecimal("5000.00"));

        System.out.println("【新增】插入 3 名学生");
        JDBCTool.save(s1, connection);
        JDBCTool.save(s2, connection);
        JDBCTool.save(s3, connection);

        System.out.println("【查询全部】（resultSetToList 反射映射）");
        List<Student> all = JDBCTool.findAll(Student.class, connection);
        printList(all);

        System.out.println("【按主键查询】id = S001");
        Student one = JDBCTool.getOneById("S001", Student.class, connection);
        System.out.println("  结果: " + one);

        System.out.println("【更新】张三已毕业，学费调整为 6000.00");
        s1.setGraduated(true);
        s1.setTuition(new BigDecimal("6000.00"));
        JDBCTool.update(s1, connection);
        System.out.println("  更新后: " + JDBCTool.getOneById("S001", Student.class, connection));

        System.out.println("【删除】删除王五 S003");
        JDBCTool.delete(s3, connection);
        System.out.println("【删除后全部学生】");
        printList(JDBCTool.findAll(Student.class, connection));
    }

    private static void banner(String title) {
        System.out.println();
        System.out.println("---------- " + title + " ----------");
    }

    private static <T> void printList(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("  (空)");
            return;
        }
        for (T item : list) {
            System.out.println("  " + item);
        }
    }
}
