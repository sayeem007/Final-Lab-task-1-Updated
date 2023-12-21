package dev.controller;

import dev.domain.Student;
import dev.service.StudentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class StudentController {

    private StudentService StudentService;

    public StudentController(StudentService StudentService) {
        this.StudentService = StudentService;
    }

    @InitBinder
    public void intiBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping("/create")
    public String registration(Model model) {
        model.addAttribute("Student", new Student());
        return "registration";
    }
    @RequestMapping("/Students")
    public String getAllStudents(Model model) throws SQLException {
        List<Student> student = StudentService.showAllStudent();
        model.addAttribute("Students", student);
        return "allStudent";
    }
    @RequestMapping("/store")
    public String CreateStudent(@Valid @ModelAttribute("Student") Student Student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        else {
            StudentService.create(Student);
            return "confirm";
        }
    }
    @RequestMapping("/students/{id}")
    public String showDetails(@PathVariable int id, Model model) throws SQLException {
        Student student = StudentService.StudentDetails(id);
        model.addAttribute("Students", student);
        return "studentDetails";
    }
    @RequestMapping(value = "/students/{id}/edit")
    public String EditStudent(@PathVariable int id, Model model) throws SQLException {

        Student student = StudentService.StudentDetails(id);
        if (student == null) {
            return "studentNotFound";
        }
        model.addAttribute("Students", student);
        return "studentEdit";

    }
    @RequestMapping(value = "/students/{id}/delete")
    public String deleteStudent(@PathVariable int id) throws SQLException {
        StudentService.deleteStudent(id);
        return "redirect:/Students";

    }
    @RequestMapping("/updateStudent")
    public String EditStudent(@ModelAttribute Student student) throws SQLException {
        StudentService.EditStudent(student);
        return "redirect:/Students";
    }


    @RequestMapping("/update")
    public String EditStudent(@Valid @ModelAttribute("Student") Student Student, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "update";
        }
        else {
           // StudentService.update(Student);
            return "/";
        }
    }
}
