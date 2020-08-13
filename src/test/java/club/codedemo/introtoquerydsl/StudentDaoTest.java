package club.codedemo.introtoquerydsl;

import com.querydsl.core.Tuple;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class StudentDaoTest {

    @Autowired
    StudentDao studentDao;

    @Test
    void findByName() {
        Assertions.assertEquals(1L,
                this.studentDao.findByName("zhangsan").getId());
    }

    @Test
    void findAllOrderByWeight() {
        List<Student> students = this.studentDao.findAllOrderByWeight();

        Assertions.assertEquals(56, students.get(0).getWeight());
        Assertions.assertEquals(65, students.get(students.size() - 1).getWeight());
    }

    @Test
    void groupByWeight() {
        List<Tuple>  students = this.studentDao.groupByWeightAndOrderById();
        Assertions.assertEquals(3, students.size());
        // 最低体重为60
        Assertions.assertEquals(60, students.get(0).get(0, Integer.class));
        // 60体重的学生有2个
        Assertions.assertEquals(2, students.get(0).get(1, Long.class));
    }

    @Test
    void findAllByCourseName() {
        Assertions.assertEquals(3,
                this.studentDao.findAllByCourseName("english").size());
    }

    @Test
    void findAllByKlassName() {
        Assertions.assertEquals(3,
                this.studentDao.findAllByKlassName("classOne").size());
    }

    @Test
    void updateNoByName() {
        this.studentDao.updateNoByName("888888", "zhangsan");
        Assertions.assertEquals("888888",
                this.studentDao.findByName("zhangsan").getNo());
    }

    @Test
    @Transactional
    void deleteByName() {
        this.studentDao.deleteByName("zhangsan");
        Assertions.assertNull(this.studentDao.findByName("zhangsan"));
    }

}