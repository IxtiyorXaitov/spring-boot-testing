package dev.ikhtiyor.springboottesting.controller;

import dev.ikhtiyor.springboottesting.payload.StudentDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Controller.
 *
 * @author IkhtiyorDev <br/> Date 11/04/22
 */
@RestController
@RequestMapping("/api/student")
public class Controller {

    /**
     * The Students.
     */
    List<StudentDTO> students = new ArrayList<>();

    /**
     * Add new student.
     *
     * @param studentDTO {@link StudentDTO}
     * @return the http entity
     */
    @PostMapping
    public HttpEntity<?> post(
            @RequestBody StudentDTO studentDTO
    ) {

        studentDTO.setId(generateId());
        students.add(studentDTO);

        return ResponseEntity.ok("Successfully added " + studentDTO.getUsername());
    }


    /**
     * Edit exists student by ID.
     *
     * @param id         the id
     * @param studentDTO {@link StudentDTO}
     * @return the http entity
     */
    @PutMapping(path = "/{id}")
    public HttpEntity<?> put(
            @PathVariable("id") Integer id,
            @RequestBody StudentDTO studentDTO
    ) {

        StudentDTO student = getStudentFromArray(id);

        student.setFirstName(studentDTO.getFirstName());
        student.setLsatName(studentDTO.getLsatName());
        student.setUsername(studentDTO.getUsername());
        student.setAddress(studentDTO.getAddress());
        student.setSchool(studentDTO.getSchool());

        return ResponseEntity.ok(student);
    }

    /**
     * Get student by ID.
     *
     * @param id the id
     * @return the http entity
     */
    @GetMapping(path = "/{id}")
    public HttpEntity<?> get(
            @PathVariable("id") Integer id
    ) {
        StudentDTO student = getStudentFromArray(id);
        return ResponseEntity.ok(student);
    }

    /**
     * Get all students.
     *
     * @return the http entity
     */
    @GetMapping(path = "/all")
    public HttpEntity<?> get() {
        return ResponseEntity.ok(students);
    }

    /**
     * Delete exists student by ID.
     *
     * @param id the id
     * @return the http entity
     */
    @DeleteMapping(path = "/{id}")
    public HttpEntity<?> delete(
            @PathVariable("id") Integer id
    ) {
        StudentDTO student = getStudentFromArray(id);
        students.remove(student);
        return ResponseEntity.ok().build();
    }

    private Integer generateId() {
        double random = Math.random() * 10;
        return (int) random;
    }

    private StudentDTO getStudentFromArray(Integer id) {
        return students
                .stream()
                .filter(s -> s.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

}
