package helsinque.spring;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class MultipartController {

  @PostMapping(path = "/multipart",
      consumes = MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Map<String, String> multipart(@RequestPart MultipartFile[] files) {
    return Map.of("fileName", String.join(": ", "File received is : ", files[0].getName()));
  }

}
