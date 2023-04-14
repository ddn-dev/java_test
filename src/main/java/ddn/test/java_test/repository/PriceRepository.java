package ddn.test.java_test.repository;

import ddn.test.java_test.model.PriceEntity;

import java.util.List;
import java.util.Map;

public interface PriceRepository {

  List<PriceEntity> findPriceByProductIdBrandIdAndApplicationDate(Map<String, String> params);
}
