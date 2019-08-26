package com.wildcodeschool.spring.doctor_who.utils;

import com.wildcodeschool.spring.doctor_who.entities.Doctor;
import com.wildcodeschool.spring.doctor_who.repositories.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("DoctorLog");

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD
        LOG.info("******************");
        LOG.info("Objects in DB : " + doctorRepository.count());

        // Crée un nouveau doctor et l'enregistre dans la BDD
        Doctor doctor1 = new Doctor(10, "David", "Tennant");
        LOG.info("******************");
        LOG.info(doctor1 + " has been created !");
        doctorRepository.save(doctor1);
        LOG.info(doctor1 + " has been saved !");


        // Crée un nouveau doctor et l'enregistre dans la BDD
        Doctor doctor2 = new Doctor(11, "Matt", "Smith");
        LOG.info("******************");
        LOG.info(doctor2 + " has been created !");
        doctorRepository.save(doctor2);
        LOG.info(doctor2 + " has been saved !");

        // Crée un nouveau doctor et l'enregistre dans la BDD
        Doctor doctor3 = new Doctor(12, "Peter", "Capaldi");
        LOG.info("******************");
        LOG.info(doctor3 + " has been created !");
        doctorRepository.save(doctor3);
        LOG.info(doctor3 + " has been saved !");

        LOG.info("******** Affichage des doctors ajoutés *********");
        LOG.info("Doctors in list are ");
        for (Doctor myDoctor : doctorRepository.findAll()) {
            LOG.info(myDoctor.toString());
        }
        ;


        // Lit les informations correspondant au 3eme doctor
        Doctor tempDoctor = doctorRepository.findById(3L).get();

        LOG.info("******************");
        LOG.info("thirth doctor's number is " + tempDoctor.getNumber());
        LOG.info("thirth doctor's firstName is " + tempDoctor.getFirstname());
        LOG.info("thirth doctor's lastName is " + tempDoctor.getLastname());


        // Update le 3eme doctor dans la base
        tempDoctor.setNumber(9);
        tempDoctor.setFirstname("Christopher");
        tempDoctor.setLastname("Eccleston");
        doctorRepository.save(tempDoctor);

        LOG.info("******** Affichage après mise a jour du doctor d'id 3 *********");
        LOG.info("Doctors in list are ");
        for (Doctor myDoctor : doctorRepository.findAll()) {
            LOG.info(myDoctor.toString());
        }
        ;

        // Suppression du deuxième doctor
        doctorRepository.deleteById(2L);
        LOG.info("Doctors d'id = 2 a été supprimé ");

        LOG.info("******** Affichage après suppression du doctor d'id 2 *********");
        LOG.info("Doctors in list are ");
        for (Doctor myDoctor : doctorRepository.findAll()) {
            LOG.info(myDoctor.toString());
        }
        ;
    }
}
