package com.crunchify.controller;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class AddContentToPDF {
	public static void writePDF()throws IOException, DocumentException {
		PdfReader pdfReader = new PdfReader("f1040nre.pdf");
		PdfStamper ps = new PdfStamper(pdfReader, new FileOutputStream(  
	            "f1040nre2.pdf")); 
		AcroFields asps=ps.getAcroFields();
		AcroFields acroFields = pdfReader.getAcroFields();
		Map<String, Item> fields = acroFields.getFields();
		Set<Entry<String, Item>> entrySet = fields.entrySet();
		int count=0;
		for (Entry<String, Item> entry : entrySet) {
			String key = entry.getKey();
			asps.setField(key, count+++"");
			if(count==10)System.out.println(asps.getFieldType(key));
		}
		 ps.setFormFlattening(true); // 这句不能少  
		    ps.close();  
		    pdfReader.close();  
	}
}