package com.case_study.target.caseStudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.case_study.target.caseStudy.entity.Description;

public interface DescriptionRepository extends MongoRepository<Description, String> {
	public Description findByPid(String pid);
}
