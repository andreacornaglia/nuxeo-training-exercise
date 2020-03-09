package org.nuxeo.training.andrea;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;
import org.nuxeo.ecm.platform.test.PlatformFeature;
import org.nuxeo.runtime.test.runner.Deploy;
import org.nuxeo.runtime.test.runner.Features;
import org.nuxeo.runtime.test.runner.FeaturesRunner;
import org.nuxeo.runtime.test.runner.TransactionalFeature;
import training.service.ReturnPrice;

import javax.inject.Inject;

@RunWith(FeaturesRunner.class)
@Features({PlatformFeature.class})
@Deploy("org.acornaglia.training.acornaglia-core")
@Deploy("studio.extensions.acornaglia-SANDBOX")

public class TestReturnPrice {

    @Inject
    protected ReturnPrice returnprice;

    @Inject
    protected CoreSession session;

    @Inject
    protected TransactionalFeature transactionalFeature;

    @Test
    public void testService() {
        DocumentModel documentModel = session.createDocumentModel("/", "product_2", "Product2");
        documentModel.setPropertyValue("ProductSchema:priceInDolars", 0d);
        documentModel.setPropertyValue("ProductSchema:name", "new product");
        documentModel = session.createDocument(documentModel);
        session.saveDocument(documentModel);

        transactionalFeature.nextTransaction();
        documentModel = session.getDocument(documentModel.getRef());
        assertEquals("Product2", documentModel.getType());
        assertEquals("new product", documentModel.getPropertyValue("ProductSchema:name"));
        assertEquals(0d, documentModel.getPropertyValue("ProductSchema:priceInDolars"));


       // assertNotNull(returnprice);
        //assertThat().isEqualTo(80);
    }
}
