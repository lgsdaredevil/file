package com.example.export.file.service;

import com.example.export.file.util.ExportPDF;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gsliu
 * @date 2018-07-30 15:21
 */
@Service
public class ExportService {

    public void exportPdf(HttpServletResponse response, String fileName) throws Exception{
        String title = "";
        String[] titles = {};
        List<String[]> dataList = new ArrayList<>();
        ExportPDF.generatePdf(response, fileName + ".pdf", title, titles, dataList);
    }

}
