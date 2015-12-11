// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.web:
//            HttpMethod, WebClient, WebClientFactory, CollectionMap, 
//            ObjectParser, ServiceCallInterceptor

public abstract class ServiceClient
{

    private static final String WEB_CLIENT_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/web/ServiceClient.getPackage().getName()).append(".jnet.NetWebClient").toString();
    private final String baseUrl;
    private final CollectionMap cookies;
    private volatile ObjectParser defaultObjectParser;
    private final CollectionMap headers;
    private final String method;
    private final ObjectParser objectParser;
    private final CollectionMap parameters;
    private boolean secure;
    private final ServiceCallInterceptor serviceCallInterceptor;
    private final String userAgent;
    private final WebClientFactory webClientFactory;

    protected ServiceClient(WebClientFactory webclientfactory, boolean flag, String s, String s1, CollectionMap collectionmap, CollectionMap collectionmap1, String s2, 
            CollectionMap collectionmap2, ServiceCallInterceptor servicecallinterceptor, ObjectParser objectparser)
    {
        WebClientFactory webclientfactory1 = webclientfactory;
        if (webclientfactory == null)
        {
            webclientfactory1 = createWebClientFactory();
        }
        webClientFactory = webclientfactory1;
        secure = flag;
        webclientfactory = s;
        if (s == null)
        {
            webclientfactory = HttpMethod.GET.getName();
        }
        method = webclientfactory;
        baseUrl = s1;
        parameters = collectionmap;
        headers = collectionmap1;
        webclientfactory = s2;
        if (s2 == null)
        {
            webclientfactory = System.getProperty("http.agent");
        }
        userAgent = webclientfactory;
        cookies = collectionmap2;
        serviceCallInterceptor = servicecallinterceptor;
        objectParser = objectparser;
    }

    public static WebClient createWebClient()
    {
        WebClient webclient = (WebClient)Class.forName(WEB_CLIENT_CLASS).getConstructor(new Class[0]).newInstance(new Object[0]);
        return webclient;
        Object obj;
        obj;
_L2:
        return null;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static WebClientFactory createWebClientFactory()
    {
        return createWebClientFactory(createWebClient());
    }

    public static WebClientFactory createWebClientFactory(WebClient webclient)
    {
        return new WebClientFactory(webclient) {

            final WebClient val$webClient;

            public WebClient getWebClient()
            {
                return webClient;
            }

            
            {
                webClient = webclient;
                super();
            }
        };
    }

    protected ObjectParser buildDefaultObjectParser()
    {
        throw new IllegalStateException("No default object parser defined");
    }

    public final String getBaseUrl()
    {
        return baseUrl;
    }

    public final CollectionMap getCookies()
    {
        return cookies;
    }

    protected ObjectParser getDefaultObjectParser()
    {
        this;
        JVM INSTR monitorenter ;
        ObjectParser objectparser;
        if (defaultObjectParser == null)
        {
            defaultObjectParser = buildDefaultObjectParser();
        }
        objectparser = defaultObjectParser;
        this;
        JVM INSTR monitorexit ;
        return objectparser;
        Exception exception;
        exception;
        throw exception;
    }

    public final CollectionMap getHeaders()
    {
        return headers;
    }

    public final ObjectParser getObjectParser()
    {
        if (objectParser != null)
        {
            return objectParser;
        } else
        {
            return getDefaultObjectParser();
        }
    }

    public final CollectionMap getParameters()
    {
        return parameters;
    }

    public final boolean getSecure()
    {
        return secure;
    }

    public final ServiceCallInterceptor getServiceCallInterceptor()
    {
        return serviceCallInterceptor;
    }

    public final String getUserAgent()
    {
        return userAgent;
    }

    public final WebClient getWebClient()
    {
        return webClientFactory.getWebClient();
    }

}
