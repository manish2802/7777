package com.absa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.absa.model.IbocDTO;

public interface IbocDTORepository extends JpaRepository<IbocDTO, Long> {

	@Query("SELECT t FROM IbocDTO t WHERE t.appName=:selectApp AND t.environment=:selectType")
	List<IbocDTO> findBySearch(@Param("selectApp") String selectApp, @Param("selectType") String selectType);

	@Query(value = "SELECT ID, APP_NAME, VERSION , ENVIRONMENT, FILE_SIZE,FILE_INFO,REL_NOTES , SUP_OS,PLIST_FILE_NAME,IPA_FILE_NAME  FROM IBOC_BUILD_RELEASE", nativeQuery = true)
	List<Object[]> findIbocTableAll();

	@Query(value = "SELECT ID, APP_NAME, VERSION , ENVIRONMENT, FILE_SIZE,FILE_INFO,REL_NOTES,SUP_OS,PLIST_FILE_NAME,IPA_FILE_NAME  FROM IBOC_BUILD_RELEASE WHERE APP_NAME=:selectApp AND ENVIRONMENT=:selectType", nativeQuery = true)
	List<Object[]> findIbocTableFilter(@Param("selectApp") String selectApp, @Param("selectType") String selectType);

	@Override
	IbocDTO findOne(Long id);

}
