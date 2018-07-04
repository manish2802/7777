package com.absa.mapper;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.absa.bean.IbocBean;
import com.absa.controller.UploadFileController;
import com.absa.exception.BusinessException;
import com.absa.model.IbocDTO;
import com.absa.util.ApplicationUtil;

public class UploadBeanMapper {
	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileController.class);
	private static String CLASS_NAME = UploadFileController.class.getName();

	public static IbocDTO uploadBeanMapToDTO(IbocBean bean) throws BusinessException {
		final String METHOD_NAME = "uploadBeanMapToDTO";
		LOGGER.debug("Enter into " + METHOD_NAME + " in " + CLASS_NAME);

		IbocDTO ibocDTO = null;

		MultipartFile pListFile = bean.getpListFile();
		MultipartFile ipaFile = bean.getIpaFile();
		MultipartFile relNotes = bean.getRelNotes();

		if (null != pListFile && null != ipaFile && null != relNotes) {
			String ipaName = ipaFile.getOriginalFilename();
			String pListName = pListFile.getOriginalFilename();
			String relNotesName = relNotes.getOriginalFilename();

			if (!pListName.isEmpty() && !ipaName.isEmpty() && !relNotesName.isEmpty()) {
				if ("plist".equalsIgnoreCase(ApplicationUtil.getFileExtension(pListName))
						&& "ipa".equalsIgnoreCase(ApplicationUtil.getFileExtension(ipaName))
						&& ApplicationUtil.validateFileExtn(relNotesName)) {
					ibocDTO = new IbocDTO();
					byte[] pListBytes = null;
					byte[] ipaBytes = null;
					byte[] relNotesBytes = null;
					try {
						pListBytes = pListFile.getBytes();
						ipaBytes = ipaFile.getBytes();
						relNotesBytes = relNotes.getBytes();
					} catch (IOException e) {
						LOGGER.error("Error in file: " + e);
						throw new BusinessException("Error in File");
					}
					if (ipaBytes.length < (50 * 1024 * 1024) || pListBytes.length < (5 * 1024 * 1024)) {
						ibocDTO.setAppName(bean.getAppName());
						ibocDTO.setEnvironment(bean.getEnvironment());
						ibocDTO.setFileInfo(bean.getFileInfo());
						ibocDTO.setVersion(bean.getVersion());
						ibocDTO.setRealseNotes(relNotesName);
						ibocDTO.setIpaFileName(ipaName);
						ibocDTO.setPlistFileName(pListName);
						ibocDTO.setSupOs(bean.getSupOs());
						ibocDTO.setFileSize(ApplicationUtil.bytesToMeg(ipaBytes.length) + " MB");
						ibocDTO.setpListFile(pListBytes);
						ibocDTO.setIpaFile(ipaBytes);
						ibocDTO.setRelNotes(relNotesBytes);
						ibocDTO.setDate(new Date());
						LOGGER.info("Iboc DTO: " + ibocDTO);
						return ibocDTO;
					} else {
						LOGGER.error("File Size Limit Exceeded");
						throw new BusinessException("File Size Limit Exceeded");
					}
				} else {
					LOGGER.error("Type Mismatch in File Formate");
					throw new BusinessException("Given File Format is not allowed here");
				}
			}

		} else {
			LOGGER.error("Please Fill Details");
			throw new BusinessException("Please Fill Details");
		}
		LOGGER.debug("Exit From " + METHOD_NAME + " in " + CLASS_NAME);
		return ibocDTO;
	}
}
