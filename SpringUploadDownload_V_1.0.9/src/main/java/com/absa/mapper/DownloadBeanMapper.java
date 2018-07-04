package com.absa.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.absa.bean.IbocBean;
import com.absa.constant.ApplicationConstant;
import com.absa.model.IbocDTO;

public class DownloadBeanMapper {
	
	
	
	
	
	public static List<IbocBean> downloadDtoToBean(List<IbocDTO> listIbocDTO, String hostAddress) {
		List<IbocBean> uplodedBuildList = new ArrayList<IbocBean>();

		for (IbocDTO id : listIbocDTO) {
			IbocBean ibocBean = new IbocBean();
			ibocBean.setId(id.getId());
			ibocBean.setAppName(id.getAppName());
			ibocBean.setEnvironment(id.getEnvironment());
			ibocBean.setFileInfo(id.getFileInfo());
			ibocBean.setSupOs(id.getSupOs());
			ibocBean.setFileSize(id.getFileSize());
			ibocBean.setVersion(id.getVersion());
			ibocBean.setRealseNotes(id.getRealseNotes());

			ibocBean.setPlistPathAddress(ApplicationConstant.FIXED_URL + hostAddress + ApplicationConstant.DOWNLOAD_URL
					+ id.getId() + "?fileName=" + id.getPlistFileName());
			ibocBean.setIpaPathAddress(
					ApplicationConstant.DOWNLOAD_URL + hostAddress + id.getId() + "?fileName=" + id.getIpaFileName());
			ibocBean.setReleasePathAddress(hostAddress + ApplicationConstant.RELNOTES_DOWNLOAD_URL + id.getId());
			uplodedBuildList.add(ibocBean);
		}

		return uplodedBuildList;

	}
	
	public static List<IbocBean> downloadNativeDtoToBean(List<Object[]> listIbocDTO, String hostAddress) {
		List<IbocBean> uplodedBuildList = new ArrayList<IbocBean>();

		for (Object[] id : listIbocDTO) {			
			IbocBean ibocBean = new IbocBean();
			//ibocBean.setId(id[0]);
			ibocBean.setAppName((String)id[1]);
			ibocBean.setVersion((String)id[2]);
			ibocBean.setEnvironment((String)id[3]);
			ibocBean.setFileSize((String)id[4]);
			ibocBean.setFileInfo((String)id[5]);
			ibocBean.setRealseNotes((String)id[6]);
			ibocBean.setSupOs((String)id[7]);
			
			ibocBean.setPlistPathAddress(ApplicationConstant.FIXED_URL + hostAddress + ApplicationConstant.DOWNLOAD_URL
					+ id[0] + "?fileName=" + id[8]);
			ibocBean.setIpaPathAddress(
					ApplicationConstant.DOWNLOAD_URL + hostAddress +id[0]  + "?fileName=" +  id[9]);
			ibocBean.setReleasePathAddress(hostAddress + ApplicationConstant.RELNOTES_DOWNLOAD_URL + id[0] );
			uplodedBuildList.add(ibocBean);
			
		}

		return uplodedBuildList;

	}

}
