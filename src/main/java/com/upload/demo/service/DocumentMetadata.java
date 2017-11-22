package com.upload.demo.service;

	

	import java.io.Serializable;
	import java.util.Properties;
	import java.util.UUID;

	import org.apache.log4j.Logger;
	public class DocumentMetadata implements Serializable {
	    
	    static final long serialVersionUID = 7283287076019483950L;

	    private static final Logger LOG = Logger.getLogger(DocumentMetadata.class);
	    
	    public static final String PROP_UUID = "uuid";
	    public static final String PROP_FILE_NAME = "file-name";
	    
	    
	    protected String uuid;
	    protected String fileName;
	    
	    public DocumentMetadata() {
	        super();
	    }

	    public DocumentMetadata(String fileName) {
	        this(UUID.randomUUID().toString(), fileName);
	    }
	    
	    public DocumentMetadata(String uuid, String fileName) {
	        super();
	        this.uuid = uuid;
	        this.fileName = fileName;
	    }
	    
	    public DocumentMetadata(Properties properties) {
	        this(properties.getProperty(PROP_UUID),
	             properties.getProperty(PROP_FILE_NAME));
	    }

	    public String getUuid() {
	        return uuid;
	    }
	    public void setUuid(String uuid) {
	        this.uuid = uuid;
	    }

	    public String getFileName() {
	        return fileName;
	    }
	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }
	    
	    public Properties createProperties() {
	        Properties props = new Properties();
	        props.setProperty(PROP_UUID, getUuid());
	        props.setProperty(PROP_FILE_NAME, getFileName());
	        return props;
	    }
	    
	    
	}

