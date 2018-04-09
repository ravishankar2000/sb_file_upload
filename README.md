# sb_file_upload
springboot_file_upload

creating a server application that can receive HTTP multi-part file uploads.

Spring Boot web application that accepts file uploads.
Simple HTML interface to upload a test file.

To start a Spring Boot MVC application, `spring-boot-starter-thymeleaf` and `spring-boot-starter-web` are already added as dependencies.
To upload files with Servlet containers, you need to register a `MultipartConfigElement` class (which would be `<multipart-config>` in web.xml).

All you need to get started with this application is the following `Application` class.

FileUploadApplication.java

As part of auto-configuring Spring MVC, Spring Boot will create a `MultipartConfigElement` bean and make itself ready for file uploads.

Create a file upload controller

The initial application already contains a few classes to deal with storing and loading the uploaded files on disk;

`FileUploadController.java`

This class is annotated with `@Controller` so Spring MVC can pick it up and look for routes. Each method is tagged with `@GetMapping`

`uploadForm.html`

This template has three parts:

* An optional message at the top where Spring MVC writes
* A form allowing the user to upload files
* A list of files supplied from the backend

With the server running, you need to open a browser and visit http://localhost:8080/ to see the upload form. Pick a (small) file and press "Upload" and you should see the success page from the controller.

You should then see something like this in your browser window:

....
You successfully uploaded <name of your file>!
....

Testing application

There are multiple ways to test this particular feature in our application. Here's one example that leverages `MockMvc`, so it does not require to start the Servlet container:

`src/test/java/springbootfileupload/FileUploadTests.java`

In those tests, we're using various mocks to set up the interactions with our Controller and the `StorageService` but also with the Servlet container itself by using `MockMultipartFile`.

