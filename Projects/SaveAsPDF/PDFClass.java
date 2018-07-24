/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSP;
import static DSP.ConnectionToDatabase.connectToDatabase;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;


import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

public class PDFClass {
    
    public static void generatePDF2() throws IOException, BadElementException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        List<Image> image = new ArrayList<>();
        try {
            SnapshotParameters parameters = new SnapshotParameters();
            WritableImage snapshot = RevisionLog.group.snapshot(parameters, null);
            
        
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", byteStream);
            image.add(Image.getInstance(byteStream.toByteArray()));
        } catch (IOException e) {
            Logger.getLogger(PDFClass.class.getName()).log(Level.SEVERE, null, e);
        }
        
        try {
            Document document = new Document(PageSize.LETTER_LANDSCAPE);
            PdfWriter.getInstance(document, new FileOutputStream("revisionLog " + new Date().getTime() + ".pdf"));
            document.open();
            System.out.println(document.getPageSize());
            //image.get(0).scaleToFit(1296.0f, 1728.0f);
            //image.get(0).scaleToFit(1728.0f, 1296.0f);
            image.get(0).scaleToFit(725.0f, 612.0f);
            document.add(image.get(0));
            document.close();   
            String sql = "SELECT SAVEPDF FROM mydb.revisionlog";           
            Connection connection = connectToDatabase();
            Statement stm = connection.createStatement();
            String query = "UPDATE mydb.revisionlog set SAVEPDF = ? WHERE REVISION_ID = ?";
			PreparedStatement ps = connection.prepareStatement(query);	        			
			ResultSet rst;
	        rst = stm.executeQuery(sql);
	        int numberOfRevisions = 0;		        
	        while (rst.next()){
	            numberOfRevisions += 1;  
	        }        
			
			ps.setInt(1, 1);
			ps.setInt(2, numberOfRevisions);
			ps.executeUpdate();
			connection.close();           
     
        } catch(Exception e) {
            System.err.println(e);
        }
    }





    
}
