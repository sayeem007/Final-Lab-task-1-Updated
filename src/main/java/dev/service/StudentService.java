package dev.service;

import dev.domain.Student;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student Student) throws SQLException {
        Student.setEmail(Student.getEmail().toLowerCase());
        studentRepository.create(Student);
    }
   public List<Student> showAllStudent() throws SQLException {
        return studentRepository.showAllStudent();
   }


   // public Student get(String email) throws SQLException {
    //    return StudentRepository.get(email);
  //  }



    public Student StudentDetails(int id) throws SQLException {
        return studentRepository.StudentDetails(id);
    }

    public void EditStudent(Student student) throws SQLException {
        studentRepository.EditStudent(student);
    }

    public void deleteStudent(int id) throws SQLException {
        studentRepository.deleteStudent(id);
    }
}
