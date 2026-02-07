package mockito.example.pojo;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import mockito.example.service.UnicornGender;

@Setter
@Getter
public class Unicorn {
  private UUID id;
  private String name;
  private int size;
  private UnicornGender gender;
}
