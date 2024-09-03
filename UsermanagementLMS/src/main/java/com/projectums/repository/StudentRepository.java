package com.projectums.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.projectums.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>
{

    public Student findByEmail(String email);

    public Student findByUsername(String username);

    public Student findByEmailAndPassword(String email, String password);

    public List<Student> findProfileByEmail(String email);

    public boolean existsByUsername(String username);

}