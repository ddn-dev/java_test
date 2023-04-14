package ddn.test.java_test.repository.impl;

import ddn.test.java_test.constant.ParamNameConstants;
import ddn.test.java_test.model.PriceEntity;
import ddn.test.java_test.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryImpl implements PriceRepository {

  private final EntityManager em;

  public List<PriceEntity> findPriceByProductIdBrandIdAndApplicationDate(
      Map<String, String> params) {

    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<PriceEntity> cq = cb.createQuery(PriceEntity.class);
    Root<PriceEntity> root = cq.from(PriceEntity.class);

    List<Predicate> predicates = new ArrayList<>();

    if (params.containsKey(ParamNameConstants.APPLICATION_DATE)) {
      LocalDateTime applicationDate =
          LocalDateTime.parse(
              params.get(ParamNameConstants.APPLICATION_DATE),
              DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
      predicates.add(
          cb.greaterThanOrEqualTo(root.get(ParamNameConstants.END_DATE), applicationDate));
      predicates.add(
          cb.lessThanOrEqualTo(root.get(ParamNameConstants.START_DATE), applicationDate));
    }

    if (params.containsKey(ParamNameConstants.BRAND_ID)) {
      predicates.add(
          cb.equal(root.get(ParamNameConstants.BRAND_ID), params.get(ParamNameConstants.BRAND_ID)));
    }

    if (params.containsKey(ParamNameConstants.PRODUCT_ID)) {
      predicates.add(
          cb.equal(
              root.get(ParamNameConstants.PRODUCT_ID), params.get(ParamNameConstants.PRODUCT_ID)));
    }

    cq.where(predicates.toArray(new Predicate[0]));

    TypedQuery<PriceEntity> query = em.createQuery(cq);
    return query.getResultList();
  }
}
