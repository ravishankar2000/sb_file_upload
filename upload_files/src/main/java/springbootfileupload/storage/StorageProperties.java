package springbootfileupload.storage;

/**
 * @author Ravishankar Subramaniam
 *
 */

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files (upload-dir)
     */
    private String location = "upload_file_location";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
