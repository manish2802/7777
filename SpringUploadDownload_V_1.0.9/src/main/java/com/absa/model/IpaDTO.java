package com.absa.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "IPA_BUILD_RELEASE")
public class IpaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "gen")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = {
			@Parameter(name = "property", value = "ibocDTO") })
	private Long id;

	@Column(name = "APP_NAME")
	private String appName;

	@Column(name = "VERSION")
	private String version;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "IPA_FILE_LOB", nullable = false)
	private byte[] ipaFile;

	@Column(name = "IPA_FILE_NAME")
	private String ipaFileName;

	@OneToOne
	@PrimaryKeyJoinColumn
	private IbocDTO ibocDTO;

	public Long getId() {
		return id;
	}

	public IbocDTO getIbocDTO() {
		return ibocDTO;
	}

	public String getIpaFileName() {
		return ipaFileName;
	}

	public void setIpaFileName(String ipaFileName) {
		this.ipaFileName = ipaFileName;
	}

	public void setIbocDTO(IbocDTO ibocDTO) {
		this.ibocDTO = ibocDTO;
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

	public byte[] getIpaFile() {
		return ipaFile;
	}

	public void setIpaFile(byte[] ipaFile) {
		this.ipaFile = ipaFile;
	}

}
