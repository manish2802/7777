package com.absa.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.absa.bean.IbocBean;
import com.absa.exception.BusinessException;
import com.absa.filestorage.FileStorage;
import com.absa.mapper.UploadBeanMapper;
import com.absa.model.IbocDTO;
import com.absa.repository.IbocDTORepository;
import com.absa.service.IbocUploadBuildServiceImpl;
import com.absa.util.CommonUtil;

@RestController
@RequestMapping(value = "/ibocdetail")
public class UploadFileController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);
	private static String CLASS_NAME = UploadFileController.class.getName();

	@Autowired
	FileStorage fileStorage;

	@Autowired
	IbocUploadBuildServiceImpl ibocUploadBuildDAO;

	@Autowired
	IbocDTORepository ibocDTORepository;

	/**
	 * 
	 * @param bean
	 * @return
	 */
	@PostMapping(value = { "/uploadDetail" })
	public @ResponseBody Map<String, Object> uploadMultipartFile(@ModelAttribute IbocBean bean,
			BindingResult bindingResult) {
		final String METHOD_NAME = "uploadMultipartFile";
		LOGGER.debug("Enter into " + METHOD_NAME + " in " + CLASS_NAME);

		Map<String, Object> response = new HashMap<String, Object>();
		try {
			if (CommonUtil.isNotEmpty(bean.getEnvironment()) && CommonUtil.isNotEmpty(bean.getEnvironment())
					&& CommonUtil.isNotEmpty(bean.getAppName())) {
				IbocDTO ibocDTO = UploadBeanMapper.uploadBeanMapToDTO(bean);

				long time1 = System.currentTimeMillis();
				LOGGER.info("Time1: " + time1);
				IbocDTO iboc = ibocUploadBuildDAO.uploadFile(ibocDTO);
				long time2 = System.currentTimeMillis();
				LOGGER.info("Time1: " + time2);
				long time3 = time2 - time1;

				LOGGER.info("Difference: " + time3);
				if (null != iboc) {
					response.put("response_message", "File uploaded successfully");
					response.put("response.status", true);
				} else {
					response.put("response.status", false);
					response.put("response_message", "File is not being uploaded successfully");
				}
			} else {
				response.put("response.status", false);
				response.put("response_message", "Missing value");
			}

		} catch (BusinessException e) {
			LOGGER.error("Error in " + METHOD_NAME + " " + e);
			response.put("response.status", false);
			response.put("response_message", e.getMessage());
		}

		LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME);
		return response;

	}

}
