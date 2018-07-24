package com.csc.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.csc.model.User;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class CreatePdf {
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
	public static void create(User user) throws IOException {
		File file = new File("D:/PPM Project/PPM/src/main/resources/user.pdf");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		 try {
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(file));
	            document.open();
	            addInfo(document, user);
	            document.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	private static void addInfo(Document document, User user) throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Test Result", catFont));
		addEmptyLine(preface, 3);
		preface.add(new Paragraph("Full name " + user.getFullname(), smallBold));
		preface.add(new Paragraph("Address " + user.getAddress(), smallBold));
		preface.add(new Paragraph("Place of birth " + user.getDateofbirth(), smallBold));
		document.add(preface);
	}
	
	 private static void addEmptyLine(Paragraph paragraph, int number) {
	        for (int i = 0; i < number; i++) {
	            paragraph.add(new Paragraph(" "));
	     }
	}
}
