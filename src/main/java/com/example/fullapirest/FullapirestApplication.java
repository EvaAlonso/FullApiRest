package com.example.fullapirest;

import com.example.fullapirest.dao.StudentDAO;
import com.example.fullapirest.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FullapirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullapirestApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			/*Student student1 = new Student("Eva", "Alonso");
			Student student2 = new Student("Miller", "Montaña");
			Student student3 = new Student("Antonio", "Cabrera");

			studentDAO.save(student1);
			studentDAO.save(student2);
			studentDAO.save(student3);

            for (Student student : studentDAO.findAll()) {
                System.out.println(student);
            }*/
        };
	}

}

