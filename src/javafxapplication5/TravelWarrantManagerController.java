package javafxapplication5;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafxapplication5.Model.Bill;
import javafxapplication5.Model.Item;
import javafxapplication5.Model.TravelInfo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class TravelWarrantManagerController implements Initializable {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarManagerConn");
    @FXML
    private ComboBox cbWarrants;
    @FXML
    private Button btnIspis;
    @FXML
    private TextArea txtArea;

    private JAXBContext context;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void dohvatiPutneNaloge() {
        cbWarrants.getItems().clear();
        boolean useNativeQuery = false;
        txtArea.clear();
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            if (useNativeQuery) {
                Query dohvatiNalog = em.createNativeQuery("select * from TravelInfo", TravelInfo.class);
                List<TravelInfo> nalozi = dohvatiNalog.getResultList();
                for (TravelInfo t : nalozi) {
                    if (t.getDriver() != null) {
                        txtArea.insertText(0, "Status: " + t.getStatus() + " " + "Ime vozaca:" + t.getDriver().getIme() + " Id:" + t.getId() + "\n");
                        System.out.println("Ime vozaca:" + t.getDriver().getIme() + " Id:" + t.getId());
                    }

                }
                cbWarrants.getItems().addAll(nalozi);
                cbWarrants.getSelectionModel().selectFirst();

            } else {
                Query dohvatiNalog = em.createQuery("select travelInfo from TravelInfo as travelInfo", TravelInfo.class);
                List<TravelInfo> nalozi = dohvatiNalog.getResultList();
                for (TravelInfo t : nalozi) {
                    if (t.getDriver() != null) {
                        txtArea.insertText(0, "Status: " + t.getStatus() + " " + "Ime vozaca:" + t.getDriver().getIme() + " Id:" + t.getId() + "\n");
                        System.out.println("Ime vozaca:" + t.getDriver().getIme() + " Id:" + t.getId());
                    }

                }
                cbWarrants.getItems().addAll(nalozi);
                cbWarrants.getSelectionModel().selectFirst();
            }
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public void generirajPdf() {
        try {

            FileChooser choose = new FileChooser();
            choose.setInitialDirectory(new File("D:\\Algebra\\5.semestar\\PPPK\\Projekt\\JAVA\\JavaFXApplication5"));
            choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pdf document", "*.pdf"));
            File f = choose.showSaveDialog(new Stage());
            if (!f.getName().contains(".")) {
                f = new File(f.getAbsolutePath() + ".pdf");
            }
            TravelInfo travelInfo = (TravelInfo) cbWarrants.getSelectionModel().getSelectedItem();
            // String fileName = "TravelWarrant.pdf";
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();

            doc.addPage(page);

            PDPageContentStream content = new PDPageContentStream(doc, page);

            content.beginText();
            content.setFont(PDType1Font.TIMES_ROMAN, 15);
            content.newLineAtOffset(250, 750);
            content.showText("Travel warrant: " + travelInfo.getId());
            content.endText();

            content.beginText();
            content.newLineAtOffset(35, 700);
            content.setFont(PDType1Font.TIMES_ROMAN, 12);
            String line = "Status: " + travelInfo.getStatus();
            content.showText(line);
            content.endText();

            content.beginText();
            content.newLineAtOffset(35, 680);
            String lineDriver = "Driver: " + travelInfo.getDriver().getIme()
                    + " " + travelInfo.getDriver().getPrezime()
                    + ";Licence Number: " + travelInfo.getDriver().getLicenceNumber();
            content.showText(lineDriver);
            content.endText();

            content.beginText();
            content.newLineAtOffset(35, 660);
            String lineTravelLength = "Travel length: " + travelInfo.getTravelLength();
            content.showText(lineTravelLength);
            content.endText();

            content.beginText();
            content.newLineAtOffset(35, 640);
            String lineDaysExpected = "Days expected: " + travelInfo.getDaysExpected();
            content.showText(lineDaysExpected);
            content.endText();

            content.beginText();
            content.newLineAtOffset(35, 620);
            String lineStartCity = "Start city: " + travelInfo.getStartCity().getNaziv();
            content.showText(lineStartCity);
            content.endText();

            content.beginText();
            content.newLineAtOffset(35, 600);
            String lineStopCity = "Stop city: " + travelInfo.getStopCity().getNaziv();
            content.showText(lineStopCity);
            content.endText();

            content.beginText();
            content.newLineAtOffset(35, 580);
            String lineCar = "Car: Brand: " + travelInfo.getCar().getBrand()
                    + " Car type: " + travelInfo.getCar().getCarType();
            content.showText(lineCar);

            content.endText();
            content.close();
            doc.save(f);

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("PDF created!");
            alert.setHeaderText("Created succesful!");
            alert.setContentText("Exported travel warrant to pdf");
            alert.showAndWait();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errors!");
            alert.setHeaderText("Error!");
            alert.setContentText(e.getLocalizedMessage());
            alert.showAndWait();
        }
    }

    public void writeToXml() {
        try {
            FileChooser choose = new FileChooser();
            choose.setInitialDirectory(new File("D:\\Algebra\\5.semestar\\PPPK\\Projekt\\JAVA\\JavaFXApplication5"));
            choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Xml document", "*.xml"));
            File f = choose.showSaveDialog(new Stage());
            if (f != null) {
                if (!f.getName().contains(".")) {
                    f = new File(f.getAbsolutePath() + ".xml");
                }
                List<Item> items = new ArrayList<>();
                items.add(new Item("Zamjena ulja", 123));

                Bill bill = new Bill(new Date(), 123);
                context = JAXBContext.newInstance(Bill.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.marshal(bill, f);

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("XML created!");
                alert.setHeaderText("Created succesful!");
                alert.setContentText("Exported Bill to xml");
                alert.showAndWait();
            }

        } catch (JAXBException ex) {
            Logger.getLogger(TravelWarrantManagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readXmlAndInsert() {
        FileChooser choose = new FileChooser();
        choose.setInitialDirectory(new File("D:\\Algebra\\5.semestar\\PPPK\\Projekt\\JAVA\\JavaFXApplication5"));
        choose.getExtensionFilters().add(new FileChooser.ExtensionFilter("Xml document", "*.xml"));
        File f = choose.showOpenDialog(new Stage());

        if (f != null) {
            if (!f.getName().contains(".")) {
                f = new File(f.getAbsolutePath() + ".xml");
            }

            try {
                context = JAXBContext.newInstance(Bill.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Bill bill = (Bill) unmarshaller.unmarshal(f);
                System.out.println(bill.getPrice());

                EntityManager em = null;
                try {
                    em = emf.createEntityManager();
                    em.getTransaction().begin();
                    em.persist(bill);
                    em.getTransaction().commit();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (JAXBException ex) {
                System.out.println(ex.getMessage());
                Logger.getLogger(TravelWarrantManagerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
