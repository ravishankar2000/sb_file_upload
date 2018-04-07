package springbootfileupload;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import springbootfileupload.storage.StorageProperties;
import springbootfileupload.storage.StorageService;

/**
 * @author Ravishankar Subramaniam
 *
 */

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class FileUploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(FileUploadApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
