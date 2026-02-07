package mockito.example.pojo;

import mockito.example.service.UnicornGender;

public record CreateUnicornRequest(String name, int size, UnicornGender gender) {}
