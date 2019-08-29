package com.hcl.einsurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.einsurance.dto.TrendingResponseDto;
import com.hcl.einsurance.entity.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	@Query("select New com.hcl.einsurance.dto.TrendingResponseDto (p.policyId,l.policyName, count(p.policyId) as count) from Purchase p,Policies l where p.status='P' and p.policyId=l.policyId group by p.policyId")
	List<TrendingResponseDto> getAllTrendings();

}
