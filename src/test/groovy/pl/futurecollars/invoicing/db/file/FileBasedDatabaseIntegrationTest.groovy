package pl.futurecollars.invoicing.db.file

import pl.futurecollars.invoicing.db.AbstractDatabaseTest
import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.TestHelpers
import pl.futurecollars.invoicing.utils.FileService
import pl.futurecollars.invoicing.utils.JsonService

import java.nio.file.Files

class FileBasedDatabaseIntegrationTest extends AbstractDatabaseTest {

    def dbPath

    @Override
    Database getDatabaseInstance() {
        def fileService = new FileService()

        def idPath = File.createTempFile('ids', '.txt').toPath()
        def idService = new IdService(idPath, fileService)

        dbPath = File.createTempFile('invoices', '.txt').toPath()
        return new FileBasedDatabase(dbPath, idService, fileService, new JsonService())
    }

    def "file based database writes invoices to correct file"() {
        given:
        def db = getDatabaseInstance()

        when:
        db.save(TestHelpers.invoice(4))

        then:
        1 == Files.readAllLines(dbPath).size()
    }
}
