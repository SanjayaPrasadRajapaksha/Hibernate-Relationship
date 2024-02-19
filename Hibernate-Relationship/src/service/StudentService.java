package service;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dto.StudentDto;
import entity.BatchEntity;
import entity.LaptopEntity;
import entity.StudentEntity;
import repository.BatchRepository;
import repository.LaptopRepository;
import repository.StudentRepository;
import util.SessionFactoryConfiguration;

public class StudentService {

    Session session = SessionFactoryConfiguration.getInstance().getSession();

    private BatchRepository batchRepository = new BatchRepository();
    private StudentRepository studentRepository = new StudentRepository();
    private LaptopRepository laptopRepository = new LaptopRepository();

    public String saveStudent(StudentDto studentDto) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            BatchEntity batchEntity = batchRepository.get(studentDto.getBatchId(), session);
            if (batchEntity != null) {
                LaptopEntity laptopEntity = new LaptopEntity();
                laptopEntity.setBrand(studentDto.getLapBrand());
                laptopEntity.setModel(studentDto.getLapModel());
                Integer lapId = laptopRepository.save(laptopEntity, session);

                if (lapId != null) {
                    laptopEntity.setId(lapId);

                    StudentEntity studentEntity = new StudentEntity();
                    studentEntity.setName(studentDto.getName());
                    studentEntity.setAddress(studentDto.getAddress());
                    studentEntity.setLaptopEntity(laptopEntity);
                    studentEntity.setBatchEntity(batchEntity);

                    Integer stuId = studentRepository.save(studentEntity, session);
                    if (stuId != null) {
                        transaction.commit();
                        return "Success";
                    } else {
                        transaction.rollback();
                        return "Student Save Error";
                    }

                } else {
                    transaction.rollback();
                    return "Laptop Save Error";
                }
            } else {
                transaction.rollback();
                return "Batch Not Found";
            }

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            throw e;
        }

    }

}
