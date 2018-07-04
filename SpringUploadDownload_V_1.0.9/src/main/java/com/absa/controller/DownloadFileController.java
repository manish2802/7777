package com.absa.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.absa.bean.IbocBean;
import com.absa.mapper.DownloadBeanMapper;
import com.absa.model.IbocDTO;
import com.absa.model.IpaDTO;
import com.absa.model.SearchDTO;
import com.absa.repository.IbocDTORepository;
import com.absa.repository.IpaDTORepository;
import com.absa.util.ApplicationUtil;

@RestController
@RequestMapping(value = "/ibocdetail")
public class DownloadFileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadFileController.class);
	private static String CLASS_NAME = DownloadFileController.class.getName();

	@Autowired
	IbocDTORepository ibocDTORepository;

	@Autowired
	IpaDTORepository ipaDTORepository;

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = { "/downloaded-file" })
	public @ResponseBody List<IbocBean> upLoadBulids(HttpServletRequest request) {
		final String METHOD_NAME = "upLoadBulids";
		LOGGER.debug("Enter into " + METHOD_NAME + " in " + CLASS_NAME);

		String ipaddress = "http://" + request.getServerName() + ":" + request.getServerPort();
		/*List<IbocDTO> listIbocDTO = (List<IbocDTO>) ibocDTORepository.findAll();
		List<IbocBean> uplodedBuildList = DownloadBeanMapper.downloadDtoToBean(listIbocDTO, ipaddress);*/
		List<Object[]> listIbocDTO = (List<Object[]>) ibocDTORepository.findIbocTableAll();
		List<IbocBean> uplodedBuildList = DownloadBeanMapper.downloadNativeDtoToBean(listIbocDTO, ipaddress);

		LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME);
		return uplodedBuildList;
	}

	/**
	 * 
	 * @return
	 */
	/*
	 * @PostMapping(value = { "/downloaded-file-search" }) public @ResponseBody
	 * List<IbocBean> getAlluploadedFile(@RequestBody SearchDTO dto,
	 * HttpServletRequest request) { final String METHOD_NAME =
	 * "getAlluploadedFile"; LOGGER.debug("Enter into " + METHOD_NAME + " in " +
	 * CLASS_NAME); List<IbocDTO> listIbocDTO = null;
	 * 
	 * if ("all".equalsIgnoreCase(dto.getSelectType())) { listIbocDTO =
	 * (List<IbocDTO>) ibocDTORepository.findAll(); } else { listIbocDTO =
	 * (List<IbocDTO>) ibocDTORepository.findBySearch(dto.getSelectApp(),
	 * dto.getSelectType());
	 * 
	 * } String ipaddress = "http://" + request.getServerName() + ":" +
	 * request.getServerPort(); List<IbocBean> uplodedBuildList =
	 * DownloadBeanMapper.downloadDtoToBean(listIbocDTO, ipaddress);
	 * 
	 * LOGGER.info("No of Recored: " + uplodedBuildList.size());
	 * LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME); return
	 * uplodedBuildList;
	 * 
	 * }
	 */
	
	

	@PostMapping(value = { "/downloaded-file-search" })
	public @ResponseBody List<IbocBean> getAlluploadedFileNative(@RequestBody SearchDTO dto,
			HttpServletRequest request) {
		final String METHOD_NAME = "getAlluploadedFile";
		LOGGER.debug("Enter into " + METHOD_NAME + " in " + CLASS_NAME);
		List<Object[]> listIbocDTO = null;

		if ("all".equalsIgnoreCase(dto.getSelectType())) {
			listIbocDTO = (List<Object[]>) ibocDTORepository.findIbocTableAll();
		} else {
			listIbocDTO = (List<Object[]>) ibocDTORepository.findIbocTableFilter(dto.getSelectApp(),
					dto.getSelectType());

		}
		String ipaddress = "http://" + request.getServerName() + ":" + request.getServerPort();
		List<IbocBean> uplodedBuildList = DownloadBeanMapper.downloadNativeDtoToBean(listIbocDTO, ipaddress);

		LOGGER.info("No of Recored: " + uplodedBuildList.size());
		LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME);
		return uplodedBuildList;

	}

	/**
	 * 
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value = { "/downloaded-file-document-{id}" })
	public void downloadDocument(@PathVariable long id, @RequestParam("fileName") String fileName,
			HttpServletResponse response)

			throws IOException {
		final String METHOD_NAME = "downloadDocument";
		LOGGER.debug("Enter into " + METHOD_NAME + " in " + CLASS_NAME);
		LOGGER.info("Id: " + id + " FileName: " + fileName);
		IbocDTO iboc = ibocDTORepository.findOne(id);
		IpaDTO ipaDTO = ipaDTORepository.findOne(id);
		String extFile = ApplicationUtil.getFileExtension(fileName);
		InputStream targetStream = null;
		response.setContentType("application/octet-stream");

		if ("ipa".equalsIgnoreCase(extFile)) {
			byte[] ipaStream = ipaDTO.getIpaFile();
			response.setHeader("Content-Disposition",
					String.format("inline; filename=\"" + ipaDTO.getIpaFileName() + "\""));
			response.setContentLength((int) ipaStream.length);
			targetStream = new ByteArrayInputStream(ipaStream);
		} else if ("plist".equalsIgnoreCase(extFile)) {
			byte[] iplistStream = iboc.getpListFile();
			response.setHeader("Content-Disposition",
					String.format("inline; filename=\"" + iboc.getPlistFileName() + "\""));
			response.setContentLength((int) iplistStream.length);
			targetStream = new ByteArrayInputStream(iplistStream);
		}

		FileCopyUtils.copy(targetStream, response.getOutputStream());

		LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME);

	}

	/**
	 * 
	 * @param id
	 * @param response
	 * @throws IOException
	 */
	@GetMapping(value = { "/downloaded-file-releasenotes-{id}" })
	public void downloadReleaseNotes(@PathVariable long id, HttpServletResponse response) throws IOException {
		final String METHOD_NAME = "downloadReleaseNotes";
		LOGGER.debug("Enter into " + METHOD_NAME + " in " + CLASS_NAME);

		IbocDTO iboc = ibocDTORepository.findOne(id);
		byte[] relNotesStream = iboc.getRelNotes();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + iboc.getRealseNotes() + "\""));
		response.setContentLength((int) relNotesStream.length);

		InputStream targetStream = new ByteArrayInputStream(relNotesStream);
		FileCopyUtils.copy(targetStream, response.getOutputStream());
		LOGGER.debug("Exit from " + METHOD_NAME + " in " + CLASS_NAME);
	}

}
