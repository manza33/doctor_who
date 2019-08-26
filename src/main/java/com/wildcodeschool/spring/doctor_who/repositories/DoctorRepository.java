package com.wildcodeschool.spring.doctor_who.repositories;

import com.wildcodeschool.spring.doctor_who.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
