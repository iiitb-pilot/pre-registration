package io.mosip.preregistration.core.util;

import java.io.*;
import java.io.IOException;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.multipart.MultipartFile;

public class CustomMultipartFile implements MultipartFile {

    private final String name;
    private final String originalFilename;
    private final String contentType;
    private final ByteArrayResource resource;

    public CustomMultipartFile(String name, String originalFilename, String contentType, ByteArrayResource resource) {
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
        this.resource = resource;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOriginalFilename() {
        return originalFilename;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return resource.contentLength() == 0;
    }

    @Override
    public long getSize() {
        return resource.contentLength();
    }

    @Override
    public byte[] getBytes() throws IOException {
        return resource.getInputStream().readAllBytes();
    }

    @Override
    public InputStream getInputStream() throws IOException {
    	
       return resource.getInputStream();

    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        throw new UnsupportedOperationException("Not implemented");
    }
}

