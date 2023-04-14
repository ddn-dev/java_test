package ddn.test.java_test;

import static org.hamcrest.Matchers.containsString;

import com.fasterxml.jackson.databind.ObjectMapper;
import ddn.test.java_test.controller.impl.PriceController;
import ddn.test.java_test.dto.PriceDTO;
import ddn.test.java_test.mocks.TestResults;
import ddn.test.java_test.repository.PriceRepository;
import ddn.test.java_test.service.PriceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

@WebMvcTest(PriceController.class)
class JavaTestApplicationTests {

  private static final String ENDPOINT_TEST1 =
      "/price?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00";
  private static final String ENDPOINT_TEST2 =
      "/price?productId=35455&brandId=1&applicationDate=2020-06-14T16:00:00";
  private static final String ENDPOINT_TEST3 =
      "/price?productId=35455&brandId=1&applicationDate=2020-06-14T21:00:00";
  private static final String ENDPOINT_TEST4 =
      "/price?productId=35455&brandId=1&applicationDate=2020-06-15T10:00:00";
  private static final String ENDPOINT_TEST5 =
      "/price?productId=35455&brandId=1&applicationDate=2020-06-16T21:00:00";
  private static final String ENDPOINT_TEST_FAIL = "/price?productId=35455&brandId=2";

  @Autowired private MockMvc mockMvc;

  @Autowired PriceController priceController;

  @MockBean PriceService priceService;

  @MockBean PriceRepository priceRepository;

  @Test
  void test1_shouldReturn200() throws Exception {
    List<PriceDTO> priceDTOList = TestResults.getTest1Results();
    when(priceService.findAllByParams(anyMap())).thenReturn(priceDTOList);
    ResultActions response = mockMvc.perform(get(ENDPOINT_TEST1));
    verify(priceService).findAllByParams(anyMap());

    response
        .andExpect(status().isOk())
        .andExpect(content().string(TestResults.TEST1_RESULT))
        .andDo(print());
  }

  @Test
  void test2_shouldReturn200() throws Exception {

    List<PriceDTO> priceDTOList = TestResults.getTest2Results();
    when(priceService.findAllByParams(anyMap())).thenReturn(priceDTOList);
    ResultActions response = mockMvc.perform(get(ENDPOINT_TEST2));
    verify(priceService).findAllByParams(anyMap());

    response
            .andExpect(status().isOk())
            .andExpect(content().string(TestResults.TEST2_RESULT))
            .andDo(print());
  }

  @Test
  void test3_shouldReturn200() throws Exception {
    List<PriceDTO> priceDTOList = TestResults.getTest3Results();
    when(priceService.findAllByParams(anyMap())).thenReturn(priceDTOList);
    ResultActions response = mockMvc.perform(get(ENDPOINT_TEST3));
    verify(priceService).findAllByParams(anyMap());

    response
            .andExpect(status().isOk())
            .andExpect(content().string(TestResults.TEST3_RESULT))
            .andDo(print());
  }

  @Test
  void test4_shouldReturn200() throws Exception {
    List<PriceDTO> priceDTOList = TestResults.getTest4Results();
    when(priceService.findAllByParams(anyMap())).thenReturn(priceDTOList);
    ResultActions response = mockMvc.perform(get(ENDPOINT_TEST4));
    verify(priceService).findAllByParams(anyMap());

    response
            .andExpect(status().isOk())
            .andExpect(content().string(TestResults.TEST4_RESULT))
            .andDo(print());
  }

  @Test
  void test5_shouldReturn200() throws Exception {
    List<PriceDTO> priceDTOList = TestResults.getTest5Results();
    when(priceService.findAllByParams(anyMap())).thenReturn(priceDTOList);
    ResultActions response = mockMvc.perform(get(ENDPOINT_TEST5));
    verify(priceService).findAllByParams(anyMap());

    response
            .andExpect(status().isOk())
            .andExpect(content().string(TestResults.TEST5_RESULT))
            .andDo(print());
  }

  @Test
  void test_shouldReturn204() throws Exception {
    this.mockMvc.perform(get(ENDPOINT_TEST_FAIL)).andExpect(status().isNoContent()).andDo(print());
  }
}
