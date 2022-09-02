import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
public class Logic {
    public static List<File> listOfFileOfGivenTypes = new ArrayList<>();

    USBDeviceDetectorManager driveDetector = new USBDeviceDetectorManager();
    // Display all the USB storage devices currently connected
    List<USBStorageDevice> usbStorageDeviceList = driveDetector.getRemovableDevices();

    public void searchAllFileOfGivenTypes() {
        for (USBStorageDevice usb : usbStorageDeviceList
        ) {
            USBSearcher usbSearcher = new USBSearcher();
            File folder = new File(usb.getRootDirectory().getPath());
            usbSearcher.findFiles(folder);
            System.out.println(usbSearcher.count);
            System.out.println(usbSearcher.count1);
        }
    }

    public void encryptAllFilesOfGivenType() throws Exception {

        LocalDateTime date = LocalDateTime.now();
       File [] list = File.listRoots();
       System.out.println(Arrays.toString(list));
       int count = 1;
        File directory = new File(list[0].getPath()+"/Sipher/"+date.toLocalDate()+"/" +date.getNano());
        FileUtils.forceMkdir(directory);
        System.out.println("New Directory created !");

        for (File fileOfGivenType : listOfFileOfGivenTypes
        ) {
            // програма сама повинна створювати папку + навзати її логіруванням. Тобто програму, яка визначає які постійні диски є і створює на них доки
            Encrypt.encryptFile(fileOfGivenType.getPath(), directory+"/" +fileOfGivenType.getName());
            count++;
        }
    }
}
