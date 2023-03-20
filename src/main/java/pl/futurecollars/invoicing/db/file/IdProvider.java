package pl.futurecollars.invoicing.db.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import pl.futurecollars.invoicing.utils.FileService;

public class IdProvider {

  private final Path idFilePath;
  private final FileService fileService;

  private int nextId = 1;

  public IdProvider(Path idFilePath, FileService fileService) {
    this.idFilePath = idFilePath;
    this.fileService = fileService;

    try {
      List<String> lines = fileService.readAllLines(idFilePath);
      if (lines.isEmpty()) {
        fileService.writeToFile(idFilePath, "1");
      } else {
        nextId = Integer.parseInt(lines.get(0));
      }
    } catch (IOException ex) {
      throw new RuntimeException("Failed to initialize id database.", ex);
    }

  }

  public int getNextIdAndIncrement() {
    try {
      fileService.writeToFile(idFilePath, String.valueOf(nextId + 1));
      return nextId++;
    } catch (IOException ex) {
      throw new RuntimeException("Failed to read id file.", ex);
    }
  }

}
