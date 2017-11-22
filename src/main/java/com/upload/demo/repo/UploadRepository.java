package com.upload.demo.repo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.stereotype.Repository;

import com.upload.demo.service.Files;

@Repository
public class UploadRepository {
	
    
    
    public void insert(Files file) {
        try {
            createDirectory(file);
            saveFileData(file);
            saveMetaData(file);
        } catch (IOException e) {
            String message = "Error while inserting document";
            throw new RuntimeException(message, e);
        }
    }
	
    private String createDirectory(Files file) {
        String path = getDirectoryPath(file);
        createDirectory(path);
        return path;
    }

    private String getDirectoryPath(Files file) {
       return getDirectoryPath(file.getUuid());
    }
    
    private String getDirectoryPath(String uuid) {
        StringBuilder sb = new StringBuilder();
        sb.append("file").append(File.separator).append(uuid);
        String path = sb.toString();
        return path;
    }

    private void createDirectory(String path) {
        File file = new File(path);
        System.out.println("file"+file);
        file.mkdirs();
    }
    
    private void saveFileData(Files document) throws IOException {
        String path = getDirectoryPath(document);
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(new File(path), document.getFileName())));
        stream.write(document.getFileData());
        stream.close();
    }
    
    public void saveMetaData(Files document) throws IOException {
        String path = getDirectoryPath(document);
        Properties props = document.createProperties();
        File f = new File(new File(path), "metadata");
        OutputStream out = new FileOutputStream( f );
        props.store(out, "Document meta data");       
}


}
