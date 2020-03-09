package training.restAPI;

import org.nuxeo.ecm.webengine.app.WebEngineModule;

import java.util.HashSet;
import java.util.Set;

public class RestAPIModule extends WebEngineModule {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> result = new HashSet<>();
        result.add(UpdatePriceAPI.class);
        return result;
    }
}
