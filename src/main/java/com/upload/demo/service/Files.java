package com.upload.demo.service;

	

	import java.io.Serializable;
	import java.util.Properties;

	public class Files extends DocumentMetadata implements Serializable {

	    private static final long serialVersionUID = 2004955454853853315L;
	    
	    private byte[] fileData;
	    
	    public Files( byte[] fileData, String fileName) {
	        super(fileName);
	        this.fileData = fileData;
	    }

	    public Files(Properties properties) {
	        super(properties);
	    }
	    
	    public Files(DocumentMetadata metadata) {
	        super(metadata.getUuid(), metadata.getFileName());
	    }

	    public byte[] getFileData() {
	        return fileData;
	    }
	    public void setFileData(byte[] fileData) {
	        this.fileData = fileData;
	    }
	    
	    public DocumentMetadata getMetadata() {
	        return new DocumentMetadata(getUuid(), getFileName());
	    }
	    
	}


