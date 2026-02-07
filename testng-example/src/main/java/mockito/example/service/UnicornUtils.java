package mockito.example.service;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class UnicornUtils {

  public static int averageSize(UnicornGender gender) {
    return switch (gender) {
      case MALE -> 135;
      case FEMALE -> 127;
    };
  }
}
