package org.ui.oppenheimerqaassignment.common;

import org.openqa.selenium.WebDriver;
import org.ui.oppenheimerqaassignment.pages.*;

public class PageProvider extends BasePage{
    public PageProvider(WebDriver driver) {
        super(driver);
    }

    public DocumentPage getDocumentPage() {
        return new DocumentPage(driver);
    }

    public DispenseTaxPage getDispenseTaxPage (){return  new DispenseTaxPage(driver);}

    public CashDispensedPage getCashDispensedPage (){return  new CashDispensedPage(driver);}

    public FileUploadPage getFileUploadPage (){return  new FileUploadPage(driver);}

    public VisitSwaggerPage getVisitSwaggerPage (){return  new VisitSwaggerPage(driver);}

    public SwaggerPage getSwaggerPage (){return  new SwaggerPage(driver);}

    public TaxReliefTablePage getTaxReliefTablePage (){return  new TaxReliefTablePage(driver);}
}

