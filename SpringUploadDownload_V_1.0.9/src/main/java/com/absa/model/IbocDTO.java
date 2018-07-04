package com.absa.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "IBOC_BUILD_RELEASE")
public class IbocDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iboc_Sequence")
	@SequenceGenerator(name = "iboc_Sequence", sequenceName = "iboc_Sequence")
	private Long id;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "VERSION")
	private String version;

	@Column(name = "ENVIRONMENT")
	private String environment;

	@Column(name = "SUP_OS")
	private String supOs;

	@Column(name = "SUP_SM_PHONE")
	private String supSmPhone;

	@Column(name = "SUBTABLETS")
	private String subTablets;

	@Column(name = "REL_NOTES")
	private String realseNotes;

	@Column(name = "IPA_FILE_NAME")
	private String ipaFileName;

	@Column(name = "PLIST_FILE_NAME")
	private String plistFileName;

	@Column(name = "FILE_SIZE")
	private String fileSize;

	@Column(name = "FILE_INFO")
	private String fileInfo;

	@Lob
	@Basic(fetch = FetchType.EAGER)
	@JsonIgnore
	@Column(name = "PLIST_FILE_LOB", nullable = false)
	private byte[] pListFile;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "IPA_FILE_LOB", nullable = false)
	@Transient
	private byte[] ipaFile;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "REL_NOTES_LOB", nullable = false)
	private byte[] relNotes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dob")
	private Date date;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ibocDTO")
	private IpaDTO ipaDTO;

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

	public byte[] getpListFile() {
		return pListFile;
	}

	public void setpListFile(byte[] pListFile) {
		this.pListFile = pListFile;
	}

	public byte[] getIpaFile() {
		return ipaFile;
	}

	public void setIpaFile(byte[] ipaFile) {
		this.ipaFile = ipaFile;
	}

	public byte[] getRelNotes() {
		return relNotes;
	}

	public void setRelNotes(byte[] relNotes) {
		this.relNotes = relNotes;
	}

	public String getIpaFileName() {
		return ipaFileName;
	}

	public void setIpaFileName(String ipaFileName) {
		this.ipaFileName = ipaFileName;
	}

	public String getPlistFileName() {
		return plistFileName;
	}

	public void setPlistFileName(String plistFileName) {
		this.plistFileName = plistFileName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public IpaDTO getIpaDTO() {
		return ipaDTO;
	}

	public void setIpaDTO(IpaDTO ipaDTO) {
		this.ipaDTO = ipaDTO;
	}

	@Override
	public String toString() {
		return "IbocDTO [id=" + id + ", appName=" + appName + ", version=" + version + ", environment=" + environment
				+ ", supOs=" + supOs + ", supSmPhone=" + supSmPhone + ", subTablets=" + subTablets + ", realseNotes="
				+ realseNotes + ", ipaFileName=" + ipaFileName + ", plistFileName=" + plistFileName + ", fileSize="
				+ fileSize + ", fileInfo=" + fileInfo + ", date=" + date + ", ipaDTO=" + ipaDTO + "]";
	}

}
