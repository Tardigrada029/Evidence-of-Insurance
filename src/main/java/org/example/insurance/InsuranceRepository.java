package org.example.insurance;

import org.springframework.data.repository.CrudRepository;

public interface InsuranceRepository extends CrudRepository<Insurance, Long> {
    public Long countByInsuranceId (Long insuranceId);
}
