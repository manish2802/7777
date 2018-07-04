package com.absa.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.absa.model.IbocDTO;
import com.absa.model.IpaDTO;
import com.absa.repository.IbocDTORepository;

@Service
@Transactional
public class IbocUploadBuildServiceImpl {

	private static final Logger LOGGER = LoggerFactory.getLogger(IbocUploadBuildServiceImpl.class);
	private static String CLASS_NAME = IbocUploadBuildServiceImpl.class.getName();

	@Autowired
	IbocDTORepository ibocDTORepository;

	public IbocDTO uploadFile(IbocDTO ibocDTO) {

		final String METHOD_NAME = "uploadFile";
		LOGGER.debug("Enter into " + METHOD_NAME + " in " + CLASS_NAME);
		IbocDTO iboc = null;
		try {
			IpaDTO ipaDTO = new IpaDTO();
			ipaDTO.setAppName(ibocDTO.getAppName());
			ipaDTO.setVersion(ibocDTO.getEnvironment());
			ipaDTO.setIpaFile(ibocDTO.getIpaFile());
			ipaDTO.setIpaFileName(ibocDTO.getIpaFileName());
			ibocDTO.setIpaDTO(ipaDTO);
			ipaDTO.setIbocDTO(ibocDTO);

			iboc = ibocDTORepository.save(ibocDTO);
		} catch (Exception e) {
			e.printStackTrace();

		}
		LOGGER.debug("Exit from" + METHOD_NAME + " in " + CLASS_NAME);
		return iboc;
	}

}