package com.absa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.absa.model.IpaDTO;

public interface IpaDTORepository extends JpaRepository<IpaDTO, Long> {


	@Override
	IpaDTO findOne(Long id);

}
