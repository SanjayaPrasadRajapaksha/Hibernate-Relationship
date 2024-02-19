import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import dto.StudentDto;
import entity.BatchEntity;
import repository.BatchRepository;
import service.StudentService;
import util.SessionFactoryConfiguration;

public class App {
    public static void main(String[] args) throws Exception {

        // StudentDto dto = new StudentDto("Stu 1", "Addrss 1", "HP", "ProBook", 1);
        // StudentService studentService = new StudentService();
        // String resp = studentService.saveStudent(dto);
        // System.out.println(resp);
        BatchRepository batchRepository = new BatchRepository();
        List<BatchEntity> batchEntities = batchRepository.getAll(SessionFactoryConfiguration.getInstance().getSession());
        batchEntities.forEach(e-> {
            System.out.println(e);
        });

        List<Object[]> batchEntiesByObjectArray = batchRepository.getAllBySQL(SessionFactoryConfiguration.getInstance().getSession());
        batchEntiesByObjectArray.forEach(e-> {
           System.out.println( Arrays.toString(e)); 
        });


        List<String> nameList = batchRepository.getAllNames(SessionFactoryConfiguration.getInstance().getSession());
        nameList.forEach(e-> {
            System.out.println(e);
        });

    }
}
