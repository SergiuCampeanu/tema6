package com.example.tema6.controller;
import com.example.tema6.domain.Teacher;
import com.example.tema6.exceptions.ControllerExceptions.ControllerExceptions;
import com.example.tema6.repository.CrudRepository;
import com.example.tema6.repository.TeacherJDBCRepository;


/**
 * @author sncam
 */
public class TeacherController {
    private CrudRepository<Teacher> repository;

    public TeacherController(CrudRepository<Teacher> teacherRepo) {
        this.repository = teacherRepo;
    }

    public TeacherController() {
        this.repository = new TeacherJDBCRepository();
    }

    public Teacher findById(long teacherId){
        try{
            return this.repository.findOne(teacherId);
        }
        catch (Exception e){
            throw new ControllerExceptions("Error");
        }
    }

    public Teacher updateTeacher(Teacher teacher) {
        return this.repository.update(teacher);
    }

    public Iterable<Teacher> getAllTeachers() {
        return this.repository.findAll();
    }
}
