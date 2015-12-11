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
    private final CollectionMap headers;
    private final String insecureUrl;
    private final String method;
    private final ObjectParser objectParser;
    private final CollectionMap parameters;
    private boolean secure;
    private final String secureUrl;
    private final ServiceCallInterceptor serviceCallInterceptor;
    private final String userAgent;
    private final boolean validateObjects;
    private final WebClientFactory webClientFactory;

    protected ServiceClient(WebClientFactory webclientfactory, boolean flag, String s, String s1, String s2, CollectionMap collectionmap, CollectionMap collectionmap1, 
            String s3, CollectionMap collectionmap2, ServiceCallInterceptor servicecallinterceptor, boolean flag1, ObjectParser objectparser)
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
        if (flag)
        {
            webclientfactory = s1;
        } else
        {
            webclientfactory = s2;
        }
        baseUrl = webclientfactory;
        secureUrl = s1;
        insecureUrl = s2;
        parameters = collectionmap;
        headers = collectionmap1;
        webclientfactory = s3;
        if (s3 == null)
        {
            webclientfactory = "RetailSearchClient/1.x (Java/1.x/generic)";
        }
        userAgent = webclientfactory;
        cookies = collectionmap2;
        serviceCallInterceptor = servicecallinterceptor;
        validateObjects = flag1;
        if (objectparser == null)
        {
            objectparser = getDefaultObjectParser();
        }
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
        return null;
    }

    public final CollectionMap getHeaders()
    {
        return headers;
    }

    public final String getInsecureUrl()
    {
        return insecureUrl;
    }

    public final String getMethod()
    {
        return method;
    }

    public final ObjectParser getObjectParser()
    {
        return objectParser;
    }

    public final CollectionMap getParameters()
    {
        return parameters;
    }

    public final boolean getSecure()
    {
        return secure;
    }

    public final String getSecureUrl()
    {
        return secureUrl;
    }

    public final ServiceCallInterceptor getServiceCallInterceptor()
    {
        return serviceCallInterceptor;
    }

    public final String getUserAgent()
    {
        return userAgent;
    }

    public final boolean getValidateObjects()
    {
        return validateObjects;
    }

    public final WebClient getWebClient()
    {
        return webClientFactory.getWebClient();
    }

}
