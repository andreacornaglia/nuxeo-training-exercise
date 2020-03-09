package training.service;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentModelList;

public interface ReturnPrice {
    double computePrice(DocumentModel doc);

    double computePrice(CoreSession coreSession, String id);

    DocumentModelList getProducts(CoreSession coreSession);
}
