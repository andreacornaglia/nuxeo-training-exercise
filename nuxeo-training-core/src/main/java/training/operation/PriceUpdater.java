package training.operation;

import org.nuxeo.ecm.automation.core.Constants;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentModelList;
import training.service.ReturnPrice;

/**
 *
 */
@Operation(id = PriceUpdater.ID, category = Constants.CAT_DOCUMENT, label = "Price Updater", description = "receives a list of products and updates their price.")
public class PriceUpdater {

    public static final String ID = "Document.PriceUpdater";

    @Context
    protected ReturnPrice returnPrice;

    @OperationMethod
    public DocumentModelList run(DocumentModelList docs) {
        for (DocumentModel doc : docs) {
            returnPrice.computePrice(doc);
        }
        return docs;
    }

    @OperationMethod()
    public DocumentModel run(DocumentModel doc) {
        returnPrice.computePrice(doc);
        return doc;
    }
}