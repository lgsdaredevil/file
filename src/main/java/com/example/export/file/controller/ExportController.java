package com.example.export.file.controller;

import com.example.export.file.service.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author gsliu
 * @date 2018-07-30 15:20
 */
@RestController
@RequestMapping("/export")
public class ExportController {
    @Autowired
    ExportService exportService;

    @GetMapping("/{fileName}")
    public void export(HttpServletResponse response, @PathVariable String fileName) throws Exception{
        exportService.exportPdf(response, fileName);
    }



}
