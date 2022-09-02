import net.samuelcampos.usbdrivedetector.USBDeviceDetectorManager;
import net.samuelcampos.usbdrivedetector.USBStorageDevice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

        for (File fileOfGivenType : listOfFileOfGivenTypes
        ) {
            Encrypt.encryptFile("C:/Users/Buhgalter2/Downloads/UsbCipher-FirstStep (1)/UsbCipher-FirstStep/src/Новий Документ Microsoft Word (3).docx", "C:/Help/Новий Документ Microsoft Word (3).docx");
        }

    }
}
