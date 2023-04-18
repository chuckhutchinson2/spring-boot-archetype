package ${package}.pdf;

import java.io.File;
import java.util.Map;

public interface PdfGenerator {

    File generatePDF(String filename, String templateName, Map<String, Object> templateModel);
}
