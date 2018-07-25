package com.csc.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.csc.model.Patient;
import com.csc.model.Treatment;
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
    
	public static void create(Patient patient, List<Treatment> lstTreatment) throws IOException {
		File file = new File("D:/PPM Project/PPM/src/main/resources/result.pdf");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		 try {
	            Document document = new Document();
	            PdfWriter.getInstance(document, new FileOutputStream(file));
	            document.open();
	            addInfo(document, patient, lstTreatment);
	            document.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	private static void addInfo(Document document, Patient patient, List<Treatment> lstTreatment) throws DocumentException {
		Paragraph preface = new Paragraph();
		
		preface.add(new Paragraph("Test Result", catFont));
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("Patient name: " + patient.getFullname(), smallBold));
		int i = 1;
		for(Treatment treatment : lstTreatment) {
			preface.add(new Paragraph("-Treatment No." + i, smallBold));
			preface.add(new Paragraph("  +History of diseases: " + treatment.getHistoryofdiseases(), smallBold));
			preface.add(new Paragraph("  +Prescription: " + treatment.getPrescription(), smallBold));
			preface.add(new Paragraph("  +Medicine used: " + treatment.getHistoryofdiseases(), smallBold));
			preface.add(new Paragraph("  +Medicaltest result: " + treatment.getMedicaltestresult(), smallBold));
			i++;
		}
		document.add(preface);
	}
	
	 private static void addEmptyLine(Paragraph paragraph, int number) {
	        for (int i = 0; i < number; i++) {
	            paragraph.add(new Paragraph(" "));
	     }
	}
}
