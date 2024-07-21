// FileServiceTest.java

import com.example.models.InputData;
import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;




import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {

    @Test
    void parseInputFile() {
        FileService fileService = new FileService();
        MultipartFile file = new MockMultipartFile("input.csv", "field1,field2,field3,field5,refkey1,refkey2\nvalue1,value2,value3,10.5,key1,key2".getBytes());

        List<InputData> result = fileService.parseInputFile(file);

        assertEquals(1, result.size());
        assertEquals("value1", result.get(0).getField1());
    }

    // Similar tests for other methods
}
