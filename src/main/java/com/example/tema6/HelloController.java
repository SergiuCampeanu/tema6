package com.example.tema6;

import com.example.tema6.controller.MainController;
import com.example.tema6.controller.StudentController;
import com.example.tema6.domain.Student;
import com.example.tema6.domain.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class HelloController {
    private final MainController mainController;
    @FXML
    private Label welcomeText;
    @FXML
    private Label studentNotFound;
    @FXML
    private Label teacherNotFound;
    @FXML
    private TextField StudentLogIn;

    @FXML
    private TextField TeacherLogIn;

    public HelloController() {
        this.mainController = new MainController();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onStudentButtonClick() throws IOException {
        UniversityApplication.Menu("Student.fxml");
    }

    public void onTeacherButtonClick() throws IOException {
        UniversityApplication.Menu("Teacher.fxml");
    }

    public void onStudentLogInButtonClick() throws IOException {
        int tempId;
        boolean semafor = false;
        if (StudentLogIn.getText().isEmpty())
            tempId = -1;
        else
            tempId = parseInt(StudentLogIn.getText());
        for (Student student : mainController.getAllStudent()) {
            if (student.getStudentId() == tempId) {
                studentNotFound.setText("");
                UniversityApplication.Menu("StudentMenu.fxml");
                semafor = true;
            }
        }
        if (StudentLogIn.getText().isEmpty() || semafor == false) {
            studentNotFound.setText("Student Not Found!");
        }
    }

    public void onTeacherLogInButtonClick() throws IOException {
        int tempId;
        boolean semafor = false;
        if (StudentLogIn.getText().isEmpty())
            tempId = -1;
        else
            tempId = parseInt(TeacherLogIn.getText());
        for (Teacher teacher : mainController.getAllTeacher()) {
            if (teacher.getTeacherId() == tempId) {
                teacherNotFound.setText("");
                UniversityApplication.Menu("TeacherMenu.fxml");
                semafor = true;
            }
        }
        if (TeacherLogIn.getText().isEmpty() || semafor == false) {
            teacherNotFound.setText("Teacher Not Found!");
        }
    }

    public void onAddCourseButtonClick() {
    }

    public void onSeeTotalCreditsButtonClick() {

    }
}