package com.absa.bean;

import org.springframework.web.multipart.MultipartFile;

public class IbocBean {
	private Long id;

	private String appName;

	private String version;

	private String environment;

	private String supOs;

	private String supSmPhone;

	private String subTablets;

	private String realseNotes;

	private String fileSize;

	private String fileInfo;

	private String plistFilePath;

	private String releaseFilePath;

	private String ipaPathAddress;

	private String plistPathAddress;

	private String releasePathAddress;
	private MultipartFile pListFile;

	private MultipartFile ipaFile;

	private MultipartFile relNotes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getSupOs() {
		return supOs;
	}

	public void setSupOs(String supOs) {
		this.supOs = supOs;
	}

	public String getSupSmPhone() {
		return supSmPhone;
	}

	public void setSupSmPhone(String supSmPhone) {
		this.supSmPhone = supSmPhone;
	}

	public String getSubTablets() {
		return subTablets;
	}

	public void setSubTablets(String subTablets) {
		this.subTablets = subTablets;
	}

	public String getRealseNotes() {
		return realseNotes;
	}

	public void setRealseNotes(String realseNotes) {
		this.realseNotes = realseNotes;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(String fileInfo) {
		this.fileInfo = fileInfo;
	}

	public String getPlistFilePath() {
		return plistFilePath;
	}

	public void setPlistFilePath(String plistFilePath) {
		this.plistFilePath = plistFilePath;
	}

	public String getReleaseFilePath() {
		return releaseFilePath;
	}

	public void setReleaseFilePath(String releaseFilePath) {
		this.releaseFilePath = releaseFilePath;
	}

	public MultipartFile getpListFile() {
		return pListFile;
	}

	public void setpListFile(MultipartFile pListFile) {
		this.pListFile = pListFile;
	}

	public MultipartFile getIpaFile() {
		return ipaFile;
	}

	public void setIpaFile(MultipartFile ipaFile) {
		this.ipaFile = ipaFile;
	}

	public MultipartFile getRelNotes() {
		return relNotes;
	}

	public void setRelNotes(MultipartFile relNotes) {
		this.relNotes = relNotes;
	}

	public String getPlistPathAddress() {
		return plistPathAddress;
	}

	public void setPlistPathAddress(String plistPathAddress) {
		this.plistPathAddress = plistPathAddress;
	}

	public String getIpaPathAddress() {
		return ipaPathAddress;
	}

	public void setIpaPathAddress(String ipaPathAddress) {
		this.ipaPathAddress = ipaPathAddress;
	}

	public String getReleasePathAddress() {
		return releasePathAddress;
	}

	public void setReleasePathAddress(String releasePathAddress) {
		this.releasePathAddress = releasePathAddress;
	}

	@Override
	public String toString() {
		return "IbocBean [id=" + id + ", appName=" + appName + ", version=" + version + ", environment=" + environment
				+ ", supOs=" + supOs + ", supSmPhone=" + supSmPhone + ", subTablets=" + subTablets + ", realseNotes="
				+ realseNotes + ", fileSize=" + fileSize + ", fileInfo=" + fileInfo + ", plistFilePath=" + plistFilePath
				+ ", releaseFilePath=" + releaseFilePath + ", ipaPathAddress=" + ipaPathAddress + ", plistPathAddress="
				+ plistPathAddress + ", releasePathAddress=" + releasePathAddress + ", pListFile=" + pListFile
				+ ", ipaFile=" + ipaFile + ", relNotes=" + relNotes + "]";
	}

}
