package ddn.test.java_test.mocks;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ddn.test.java_test.dto.PriceDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestResults {

  static ObjectMapper objectMapper = new ObjectMapper();

  public static final String TEST1_RESULT =
      "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5}]";
  public static final String TEST2_RESULT =
      "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5},{\"productId\":35455,\"brandId\":1,\"priceList\":2,\"startDate\":\"2020-06-14T15:00:00\",\"endDate\":\"2020-06-14T18:30:00\",\"price\":25.45}]";
  public static final String TEST3_RESULT =
      "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5}]";
  public static final String TEST4_RESULT =
      "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5},{\"productId\":35455,\"brandId\":1,\"priceList\":3,\"startDate\":\"2020-06-15T00:00:00\",\"endDate\":\"2020-06-15T11:00:00\",\"price\":30.5}]";
  public static final String TEST5_RESULT =
      "[{\"productId\":35455,\"brandId\":1,\"priceList\":1,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":35.5},{\"productId\":35455,\"brandId\":1,\"priceList\":4,\"startDate\":\"2020-06-15T16:00:00\",\"endDate\":\"2020-12-31T23:59:59\",\"price\":38.95}]";

  public static List<PriceDTO> getTest1Results() throws IOException {
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper.readValue(
        new File("src/test/resources/test1_result.json"), new TypeReference<List<PriceDTO>>() {});
  }

  public static List<PriceDTO> getTest2Results() throws IOException {
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper.readValue(
        new File("src/test/resources/test2_result.json"), new TypeReference<List<PriceDTO>>() {});
  }

  public static List<PriceDTO> getTest3Results() throws IOException {
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper.readValue(
        new File("src/test/resources/test3_result.json"), new TypeReference<List<PriceDTO>>() {});
  }

  public static List<PriceDTO> getTest4Results() throws IOException {
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper.readValue(
        new File("src/test/resources/test4_result.json"), new TypeReference<List<PriceDTO>>() {});
  }

  public static List<PriceDTO> getTest5Results() throws IOException {
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper.readValue(
        new File("src/test/resources/test5_result.json"), new TypeReference<List<PriceDTO>>() {});
  }
}
