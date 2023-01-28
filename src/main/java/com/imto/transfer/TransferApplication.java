package com.imto.transfer;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.imto.transfer.endpoint.TransferEndPoint;
import com.imto.transfer.webhook.TransferWebhook;





public class TransferApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new LinkedHashSet<Class<?>>();

        resources.add(TransferEndPoint.class);
        resources.add(TransferWebhook.class);

        return resources;
    }

    /*
     * Exception mapper handler here
     */
    
    @Override
    public Set<Object> getSingletons() {
        Set<Object> singleton = new LinkedHashSet<Object>();
//        singleton.add(new AuthenticationExceptionMapper());
//        singleton.add(new CallbackExceptionMapper());
//        singleton.add(new GeneralExceptionMapper());
        //singleton.add(new MissingRequiredParamsExceptionMapper());
        return singleton;
    }

}
