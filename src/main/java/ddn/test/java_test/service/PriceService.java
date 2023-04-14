package ddn.test.java_test.service;

import ddn.test.java_test.dto.PriceDTO;

import java.util.List;
import java.util.Map;

public interface PriceService {

    List<PriceDTO> findAllByParams(Map<String, String> params);
}
