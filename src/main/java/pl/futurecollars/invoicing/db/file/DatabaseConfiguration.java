package pl.futurecollars.invoicing.db.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.utils.FileService;
import pl.futurecollars.invoicing.utils.JsonService;

@Configuration
public class DatabaseConfiguration {

  private static final String DATABASE_LOCATION = "db";
  private static final String ID_FILE_NAME = "id.txt";
  private static final String INVOICES_FILE_NAME = "invoices.txt";

  @Bean
  public IdProvider idProvider(FileService filesService) throws IOException {
    Path idFilePath = Files.createTempFile(DATABASE_LOCATION, ID_FILE_NAME);
    return new IdProvider(idFilePath, filesService);
  }

  @Bean
  public Database fileBasedDatabase(IdProvider idProvider, FileService filesService, JsonService jsonService) throws IOException {
    Path databaseFilePath = Files.createTempFile(DATABASE_LOCATION, INVOICES_FILE_NAME);
    return new FileBasedDatabase(databaseFilePath, idProvider, filesService, jsonService);
  }

}
