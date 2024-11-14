import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;

// BEGIN USER CODE
try {
    Code128Writer writer = new Code128Writer();
        BitMatrix matrix = writer.encode(text, BarcodeFormat.CODE_128, 500, 300);
        BufferedImage bufImage = MatrixToImageWriter.toBufferedImage(matrix);
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix,"png", pngOutputStream);
        try {
            ImageIO.write(bufImage, "png", pngOutputStream);
            Core.storeFileDocumentContent(getContext(), imageFile,
                new ByteArrayInputStream(pngOutputStream.toByteArray()));
            } 
    finally {
                pngOutputStream.close();
            }
        Core.getLogger("barcode").info("Barcode created...");
    } 
    catch(Exception e) {
            System.out.println("Error while creating barcode");
        }
    return null;
    // END USER CODE
