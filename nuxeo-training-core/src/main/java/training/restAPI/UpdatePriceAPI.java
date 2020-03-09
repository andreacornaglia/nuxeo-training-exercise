package training.restAPI;

import org.nuxeo.ecm.webengine.WebEngine;
import org.nuxeo.ecm.webengine.model.WebObject;
import org.nuxeo.ecm.webengine.model.impl.ModuleRoot;
import org.nuxeo.runtime.api.Framework;
import training.service.ReturnPrice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@WebObject(type = "product")
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class UpdatePriceAPI extends ModuleRoot {

    protected ReturnPrice returnPrice;

    public UpdatePriceAPI(){
        super();
        this.returnPrice = Framework.getService(ReturnPrice.class);
    }

    @GET
    @Path("{id}")
    public Object getPriceByProductId(@PathParam("id") String id) {
        double price = returnPrice.computePrice(WebEngine.getActiveContext().getCoreSession(), id);
        return String.valueOf(price);
    }

}