package dev.repository;

import dev.domain.Gender;
import dev.domain.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(Student Student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student (id, name, email, dob, gender, quata, country) VALUES (?, ?, ?, ?, ?, ?, ?)");
        preparedStatement.setInt(1, Student.getId());
        preparedStatement.setString(2, Student.getName());
        preparedStatement.setString(3, Student.getEmail());
        preparedStatement.setDate(4, Date.valueOf(Student.getDob()));
        preparedStatement.setString(5, String.valueOf(Student.getGender()));
        preparedStatement.setString(6, Student.getQuota());
        preparedStatement.setString(7, Student.getCountry());
        preparedStatement.execute();
    }


    public List<Student> showAllStudent() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT * FROM student";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Student student = new Student();
                student.setId((int) resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setEmail(resultSet.getString("email"));
                student.setDob(LocalDate.parse(resultSet.getString("dob")));
                Gender Gender = dev.domain.Gender.valueOf(resultSet.getString("gender"));
                student.setQuota(resultSet.getString("quota"));
                student.setCountry(resultSet.getString("country"));


                studentList.add(student);
            }
        }

        return studentList;

    }

    public void deleteStudent(int studentId) throws SQLException {
        String sql = "DELETE FROM student WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, studentId);
            preparedStatement.executeUpdate();
        }
    }
    public Student StudentDetails(int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id = ?";
        Student student = new Student();

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    student = new Student();
                    student.setId(resultSet.getInt("id"));
                    student.setName(resultSet.getString("full_name"));
                    student.setEmail(resultSet.getString("email"));
                    student.setDob(LocalDate.parse(resultSet.getString("date_of_birth")));
                    student.setGender(Gender.valueOf(resultSet.getString("gender")));
                    student.setQuota(resultSet.getString("quota"));
                    student.setCountry(resultSet.getString("country"));
                }
            }
        }

        return student;
    }
    public void EditStudent(Student student) throws SQLException {
        String sql = "UPDATE student SET name = ?, email = ?, dob = ?, gender = ?, quota = ?, country = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setDate(3, Date.valueOf(student.getDob()));
            preparedStatement.setString(4,student.getGender().toString());
            preparedStatement.setString(5, student.getQuota().toString());
            preparedStatement.setString(6, student.getCountry());

            preparedStatement.execute();
        }

    }
}