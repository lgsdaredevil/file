package com.example.export.file.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author gsliu
 * @date 2018-07-30 15:18
 */
public class ExportPDF {

    public static void generatePdf(HttpServletResponse response, String exportExcelFileName, String title, String[] titles, List<String[]> dataList) throws IOException, DocumentException {
        OutputStream os = response.getOutputStream();// 取得输出流
        response.reset();// 清空输出流
        response.setHeader("Content-disposition", "attachment; filename=" + new String(exportExcelFileName.getBytes(), "iso-8859-1"));// 设定输出文件头
//        response.setHeader("Content-disposition", "attachment; filename=" + exportExcelFileName);// 设定输出文件头

        response.setContentType("application/x-msexcel;charset=utf-8");// 定义输出类型

        createPdfFile(os);
        os.close();
    }

    public static void createPdfFile(OutputStream os) throws DocumentException, IOException  {

        // ①建立com.lowagie.text.Document对象的实例
        Document document = new Document();

        //②建立一个书写器(Writer)与document对象关联，通过书写器(Writer)可以将文档写入到磁盘中
        PdfWriter.getInstance(document, os);

        //③打开文档
        document.open();

        //④向文档中添加内容
        document.add(new Paragraph("hello world"));

//        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
//		com.lowagie.text.Font FontChinese = new com.lowagie.text.Font(bfChinese, 12, com.lowagie.text.Font.NORMAL);
//		Paragraph pragraph=new Paragraph("你好", FontChinese);

        //⑤关闭文档
        document.close();
    }
}
