package com.example.tema6.controller;
import com.example.tema6.domain.Course;
import com.example.tema6.domain.Person;
import com.example.tema6.domain.Student;
import com.example.tema6.exceptions.ControllerExceptions.ControllerExceptions;
import com.example.tema6.exceptions.RepositoryExceptions.StudentRepoExceptions;
import com.example.tema6.repository.CrudRepository;
import com.example.tema6.repository.StudentJDBCRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sncam
 */
public class StudentController {
    private CrudRepository<Student> repository;

    public StudentController(CrudRepository<Student> studentRepo){
        this.repository = studentRepo;
    }

    public StudentController() {
        this.repository = new StudentJDBCRepository();
    }


    /**
     *
     * @param studentId id of the student
     * @return the student with the same id
     */
    public Student findStudentById(Long studentId){
        try{
            return this.repository.findOne(studentId);
        }
        catch (Exception e){
            throw new ControllerExceptions("Error");
        }
    }

    /**
     *
     * @param studentId id of the student
     * @param course object course
     * @return true or false if the course was added to the student or not
     */
    public Boolean addCourseToStudent(Long studentId, Course course) {
        try{
            Student updatedStudent= this.repository.findOne(studentId);
            updatedStudent.getEnrolledCourses().add(course.getCourseId());
            this.repository.update(updatedStudent);
        }
        catch (Exception e)
        {
            throw new ControllerExceptions("Error");
        }
        return true;
    }

    /**
     *
     * @param student object student
     * @return the updated student
     */
    public Student updateStudent(Student student) {
        return this.repository.update(student);
    }

    /**
     *
     * @return sorted list of student
     */
    public List<Student> getSortStudentsByName(){
        List<Student> studentList = (List<Student>) this.repository.findAll();
        return studentList.stream().sorted((Student s1, Student s2)->s1.getName().compareTo(s2.getName())).toList();
        //return studentList.stream().sorted(Comparator.comparing(Person::getName)).toList();

    }

    /**
     *
     * @param maxCredit maximum number of credits that a student can have
     * @return the filtered list of student
     */
    public List<Student> getFilteredStudentsByCreditsMax(int maxCredit){
        List<Student> studentList = (List<Student>) this.repository.findAll();
        return studentList.stream().filter(s1->s1.getTotalCredit()<maxCredit).toList();
    }

    /**
     *
     * @param minCredit minimum number of credits that a student can have
     * @return the filtered list of student
     */
    public List<Student> getFilteredStudentsByCreditsMin(int minCredit){
        List<Student> studentList = (List<Student>) this.repository.findAll();
        return studentList.stream().filter(s1->s1.getTotalCredit()>minCredit).toList();
    }

    public Iterable<Student> getAllStudents() {
        return this.repository.findAll();
    }
}
