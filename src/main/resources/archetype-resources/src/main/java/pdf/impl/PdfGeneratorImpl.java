package ${package}.pdf.impl;

import com.lowagie.text.DocumentException;
import org.example.datecalculator.pdf.PdfGenerator;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;
import sun.security.action.GetPropertyAction;

import java.io.*;
import java.security.AccessController;
import java.util.Map;

@Component
public class PdfGeneratorImpl implements PdfGenerator {
    private SpringTemplateEngine thymeleafTemplateEngine;

    public PdfGeneratorImpl(SpringTemplateEngine thymeleafTemplateEngine) {
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
    }
    private static final File tmpdir = new File(AccessController
            .doPrivileged(new GetPropertyAction("java.io.tmpdir")));
    @Override
    public File generatePDF(String filename, String templateName, Map<String, Object> templateModel) {
        try {

            String html = generateHtml(templateName, templateModel);

            File file = new File(tmpdir, filename);

            OutputStream outputStream = new FileOutputStream(file);
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(html);
            renderer.layout();
            renderer.createPDF(outputStream);

            outputStream.close();

            return file;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String generateHtml(String templateName, Map<String, Object> templateModel) {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);
        return thymeleafTemplateEngine.process(templateName, thymeleafContext);
    }
}
