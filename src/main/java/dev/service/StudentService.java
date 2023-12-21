package dev.service;

import dev.domain.Student;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository StudentRepository;

    public StudentService(StudentRepository StudentRepository) {
        this.StudentRepository = StudentRepository;
    }

    public void create(Student Student) throws SQLException {
        Student.setEmail(Student.getEmail().toLowerCase());
        StudentRepository.create(Student);
    }
   public List<Student> showAllStudent() throws SQLException {
        return StudentRepository.showAllStudent();
   }


   // public Student get(String email) throws SQLException {
    //    return StudentRepository.get(email);
  //  }



    public Student StudentDetails(int id) throws SQLException {
        return StudentRepository.StudentDetails(id);
    }

    public void EditStudent(Student student) throws SQLException {
        StudentRepository.EditStudent(student);
    }

    public void deleteStudent(int id) throws SQLException {
        StudentRepository.deleteStudent(id);
    }
}
