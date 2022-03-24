package org.example.insurance;

import org.example.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class InsuranceService {
    @Autowired
    private InsuranceRepository insuranceRepository;

    public void save(Insurance insurance) {
        insuranceRepository.save(insurance);
    }

    public List<Insurance> listAllInsurances() {
        return (List<Insurance>) insuranceRepository.findAll();
    }

    public Insurance get(Long insuranceId){
        Optional<Insurance> result = insuranceRepository.findById(insuranceId);
        return result.get();
    }

    /*
    public List<Insurance> findInsuranceByUserId(Long userId) {
        Iterable<Insurance> allInsurances = new ArrayList<Insurance>();
        allInsurances = insuranceRepository.findAll();
    }
    */

    public void deleteInsurance(Long insuranceId) {
        insuranceRepository.deleteById(insuranceId);
    }

}