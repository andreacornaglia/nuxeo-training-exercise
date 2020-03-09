package training.service;

import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.core.api.DocumentModelList;
import org.nuxeo.ecm.core.api.IdRef;
import org.nuxeo.ecm.core.api.impl.DocumentModelListImpl;
import org.nuxeo.runtime.model.DefaultComponent;

import java.util.Random;


public class ReturnPriceImpl extends DefaultComponent implements ReturnPrice {

    @Override
    public double computePrice(DocumentModel doc) {
        double price = new Random().nextDouble();
        doc.setPropertyValue("ProductSchema:priceInDolars", price);
        return price;
    }


    @Override
    public double computePrice(CoreSession coreSession, String id) {
       return computePrice(coreSession.getDocument(new IdRef(id)));
    }

    @Override
    public DocumentModelList getProducts(CoreSession coreSession) {
        return new DocumentModelListImpl();
    }
}