// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallInterceptor;
import com.amazon.searchapp.retailsearch.client.web.WebClientFactory;

// Referenced classes of package com.amazon.retailsearch.client:
//            AndroidWebClientFactory, SearchCallInterceptor

public class AndroidRetailSearchClient
{

    private static String appVersion;
    private static RetailSearchClient client;
    private static String clientId;
    private static ServiceCallInterceptor serviceCallInterceptor;
    private static String userAgent;
    private static AndroidWebClientFactory webClientFactory = new AndroidWebClientFactory();

    public AndroidRetailSearchClient()
    {
    }

    private static RetailSearchClient createClient()
    {
        com.amazon.searchapp.retailsearch.client.RetailSearchClient.Builder builder = (new com.amazon.searchapp.retailsearch.client.RetailSearchClient.Builder()).setWebClientFactory(getWebClientFactory()).setServiceCallInterceptor(getServiceCallInterceptor()).setUserAgent(getUserAgent());
        if (clientId != null)
        {
            builder.setClientId(getClientId());
        }
        return builder.build();
    }

    public static String getAppVersion()
    {
        return appVersion;
    }

    public static RetailSearchClient getClient()
    {
        com/amazon/retailsearch/client/AndroidRetailSearchClient;
        JVM INSTR monitorenter ;
        RetailSearchClient retailsearchclient;
        if (client == null)
        {
            client = createClient();
        }
        retailsearchclient = client;
        com/amazon/retailsearch/client/AndroidRetailSearchClient;
        JVM INSTR monitorexit ;
        return retailsearchclient;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getClientId()
    {
        return clientId;
    }

    public static ServiceCallInterceptor getServiceCallInterceptor()
    {
        com/amazon/retailsearch/client/AndroidRetailSearchClient;
        JVM INSTR monitorenter ;
        ServiceCallInterceptor servicecallinterceptor;
        if (serviceCallInterceptor == null)
        {
            serviceCallInterceptor = new SearchCallInterceptor();
        }
        servicecallinterceptor = serviceCallInterceptor;
        com/amazon/retailsearch/client/AndroidRetailSearchClient;
        JVM INSTR monitorexit ;
        return servicecallinterceptor;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getUserAgent()
    {
        return userAgent;
    }

    public static WebClientFactory getWebClientFactory()
    {
        return webClientFactory;
    }

    public static void resetClient()
    {
        com/amazon/retailsearch/client/AndroidRetailSearchClient;
        JVM INSTR monitorenter ;
        client = null;
        getClient();
        com/amazon/retailsearch/client/AndroidRetailSearchClient;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setAppVersion(String s)
    {
        appVersion = s;
    }

    public static void setClientId(String s)
    {
        clientId = s;
    }

    public static void setUserAgent(String s)
    {
        userAgent = s;
    }

}
