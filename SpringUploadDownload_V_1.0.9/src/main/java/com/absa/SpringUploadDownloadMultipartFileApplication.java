package com.absa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringUploadDownloadMultipartFileApplication  {
	 
	/*@Resource
	FileStorage fileStorage;*/
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringUploadDownloadMultipartFileApplication.class, args);
    }
    
	/*@Override
	public void run(String... args) throws Exception {
		//fileStorage.deleteAll();
		//fileStorage.init();
	}*/
 
}