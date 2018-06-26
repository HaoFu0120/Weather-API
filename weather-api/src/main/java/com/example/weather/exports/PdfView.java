package com.example.weather.exports;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.stream.ImageInputStreamImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.weather.controller.IndexController;
import com.example.weather.domain.CityWeather;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

	public static final String DEST = "results/tables/simple_table.pdf";
//	private Map<String, ArrayList<CityWeather>> modelMap;
	private List<CityWeather> weathers;
	private PdfPTable table;
	
//	private Headers headers=new Headers();
	
	private static final List<String> HEADERS = new Headers().getHeaders();
	
//	@Autowired
//	private IndexController indexController;
//	

	 public PdfView(Map<String, Object> weatherMap) {
		 weathers = (List<CityWeather>) weatherMap.get("weathers");
	 }

//	public PdfView() {
//		weathers = (List<CityWeather>) weatherMap.get("weathers");
//	}

	@Override
	protected void buildPdfDocument(Map<String, Object> weatherMap, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		document.open();
//		document.add(new Chunk(""));
//		PdfPTable table = new PdfPTable(8); // 8 columns.
//
//		PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
//		PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
//		PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
//		PdfPCell cell4 = new PdfPCell(new Paragraph("Cell 4"));
//		PdfPCell cell5 = new PdfPCell(new Paragraph("Cell 5"));
//		PdfPCell cell6 = new PdfPCell(new Paragraph("Cell 6"));
//		PdfPCell cell7 = new PdfPCell(new Paragraph("Cell 7"));
//		PdfPCell cell8 = new PdfPCell(new Paragraph("Cell 8"));
//
//		table.addCell(cell1);
//		table.addCell(cell2);
//		table.addCell(cell3);
//		table.addCell(cell4);
//		table.addCell(cell5);
//		table.addCell(cell6);
//		table.addCell(cell7);
//		table.addCell(cell8);
//
//		document.add(table);

//		File file = new File(DEST);
//		file.getParentFile().mkdirs();
		createPdf(DEST,document);

	}

	public void createPdf(String dest, Document document) throws IOException, DocumentException {
//		weathers=indexController.getWeatherMap().get("weathers");
		//header'ların fontu daha küçük
		Font subtitleFont = FontFactory.getFont("Times Roman", 6, BaseColor.BLACK);
		document.open();
		document.add(new Chunk(""));
		//dosyayı proje dizininde istediğin yere koyabilirsin.
//		PdfWriter.getInstance(document, new FileOutputStream(dest));
		//15 sütun
		table = new PdfPTable(15);
		//pdf'in yüzde olarak kaçını kapsasın
		table.setWidthPercentage(105);
		// değerler sabit çak en yukarı. weather kaç data var 15 tane. oku ve çak yukarı
		
		
		for (int i = 0; i < 15; i++) {
//			PdfPCell cell = new PdfPCell(new Phrase(headers.getHeaders().get(i),subtitleFont));
			PdfPCell cell = new PdfPCell(new Phrase(HEADERS.get(i),subtitleFont));
			table.addCell(cell);
		}

		for (CityWeather cityWeather : weathers) {
			PdfPCell cell = new PdfPCell(new Phrase(cityWeather.getPlace().getCountry()));
			PdfPCell cell2 = new PdfPCell(new Phrase(cityWeather.getPlace().getCity()));
			PdfPCell cell3 = new PdfPCell(new Phrase(cityWeather.getBase()));
			PdfPCell cell4 = new PdfPCell(new Phrase(cityWeather.getCoordinates().getLat()));
			PdfPCell cell5 = new PdfPCell(new Phrase(cityWeather.getCoordinates().getLongitude()));
			PdfPCell cell6 = new PdfPCell(new Phrase(cityWeather.getWeather().getMain()));
			PdfPCell cell7 = new PdfPCell(new Phrase(cityWeather.getWeather().getDescription()));
			PdfPCell cell8 = new PdfPCell(new Phrase(cityWeather.getWeather().getIcon()));
			PdfPCell cell9 = new PdfPCell(new Phrase(String.valueOf(cityWeather.getMainInfo().getTemp())));
			PdfPCell cell10 = new PdfPCell(new Phrase(String.valueOf(cityWeather.getMainInfo().getPressure())));
			PdfPCell cell11 = new PdfPCell(new Phrase(String.valueOf(cityWeather.getMainInfo().getHumidity())));
			PdfPCell cell12 = new PdfPCell(new Phrase(String.valueOf(cityWeather.getMainInfo().getTemp_min())));
			PdfPCell cell13 = new PdfPCell(new Phrase(String.valueOf(cityWeather.getMainInfo().getTemp_max())));
			PdfPCell cell14 = new PdfPCell(new Phrase(String.valueOf(cityWeather.getVisibility())));
			PdfPCell cell15 = new PdfPCell(new Phrase(String.valueOf(cityWeather.getWind().getSpeed())));
			addToTableAndResize(cell);
			addToTableAndResize(cell2);
			addToTableAndResize(cell3);
			addToTableAndResize(cell4);
			addToTableAndResize(cell5);
			addToTableAndResize(cell6);
			addToTableAndResize(cell7);
			addToTableAndResize(cell8);
			addToTableAndResize(cell9);
			addToTableAndResize(cell10);
			addToTableAndResize(cell11);
			addToTableAndResize(cell12);
			addToTableAndResize(cell13);
			addToTableAndResize(cell14);
			addToTableAndResize(cell15);
//			for (int i = 0; i < 15; i++) {
				//ismi alıp 1 eklemeyi düşündüm. reflection ile oluyormuş.
//				addToTableAndResize(cell+String.valueOf(i+1));
//			}
			
			

		}
		document.add(table);
		document.close();
	}

	private void addToTableAndResize(PdfPCell cell) {
		cell.setFixedHeight(30);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
	}

}
