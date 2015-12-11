// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.ObjectParser;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallInterceptor;
import com.amazon.searchapp.retailsearch.client.web.ServiceClient;
import com.amazon.searchapp.retailsearch.client.web.WebClient;
import com.amazon.searchapp.retailsearch.client.web.WebClientFactory;
import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchClient, SearchConfiguration, SearchRealm

public static class secure
{

    private String apiVersion;
    private String appId;
    private String clientId;
    private CollectionMap cookies;
    private CollectionMap headers;
    private String insecureUrl;
    private String method;
    private ObjectParser objectParser;
    private CollectionMap parameters;
    private String platform;
    private SearchRealm realm;
    private String responseFormat;
    private boolean secure;
    private String secureUrl;
    private ServiceCallInterceptor serviceCallInterceptor;
    private String userAgent;
    private boolean validateObjects;
    private WebClient webClient;
    private WebClientFactory webClientFactory;
    private Map weblabs;

    public RetailSearchClient build()
    {
        if (webClientFactory == null && webClient != null)
        {
            webClientFactory = ServiceClient.createWebClientFactory(webClient);
        }
        if (realm == null)
        {
            realm = SearchConfiguration.getConfiguration().getRealm();
        }
        if (realm != null)
        {
            if (secureUrl == null)
            {
                secureUrl = realm.getSecureSearchServiceUrl();
            }
            if (insecureUrl == null)
            {
                insecureUrl = realm.getSearchServiceUrl();
            }
        }
        return new RetailSearchClient(this, null);
    }

    public String getApiVersion()
    {
        return apiVersion;
    }

    public String getAppId()
    {
        return appId;
    }

    public String getClientId()
    {
        return clientId;
    }

    public CollectionMap getCookies()
    {
        return cookies;
    }

    public CollectionMap getHeaders()
    {
        return headers;
    }

    public String getInsecureUrl()
    {
        return insecureUrl;
    }

    public String getMethod()
    {
        return method;
    }

    public ObjectParser getObjectParser()
    {
        return objectParser;
    }

    public CollectionMap getParameters()
    {
        return parameters;
    }

    public String getPlatform()
    {
        return platform;
    }

    public SearchRealm getRealm()
    {
        return realm;
    }

    public String getResponseFormat()
    {
        return responseFormat;
    }

    public boolean getSecure()
    {
        return secure;
    }

    public String getSecureUrl()
    {
        return secureUrl;
    }

    public ServiceCallInterceptor getServiceCallInterceptor()
    {
        return serviceCallInterceptor;
    }

    public String getUserAgent()
    {
        return userAgent;
    }

    public boolean getValidateObjects()
    {
        return validateObjects;
    }

    public WebClient getWebClient()
    {
        return webClient;
    }

    public WebClientFactory getWebClientFactory()
    {
        return webClientFactory;
    }

    public Map getWeblabs()
    {
        return weblabs;
    }

    public weblabs setApiVersion(String s)
    {
        apiVersion = s;
        return this;
    }

    public apiVersion setAppId(String s)
    {
        appId = s;
        return this;
    }

    public appId setAppId(String s, String s1, String s2)
    {
        appId = RetailSearchClient.createAppId(s, s1, s2);
        return this;
    }

    public pId setClientId(String s)
    {
        clientId = s;
        return this;
    }

    public clientId setCookies(CollectionMap collectionmap)
    {
        cookies = collectionmap;
        return this;
    }

    public cookies setCookies(Map map)
    {
        cookies = new CollectionMap(map);
        return this;
    }

    public cookies setHeaders(CollectionMap collectionmap)
    {
        headers = collectionmap;
        return this;
    }

    public headers setHeaders(Map map)
    {
        headers = new CollectionMap(map);
        return this;
    }

    public headers setInsecureUrl(String s)
    {
        insecureUrl = s;
        return this;
    }

    public insecureUrl setMethod(String s)
    {
        method = s;
        return this;
    }

    public method setObjectParser(ObjectParser objectparser)
    {
        objectParser = objectparser;
        return this;
    }

    public objectParser setParameters(CollectionMap collectionmap)
    {
        parameters = collectionmap;
        return this;
    }

    public parameters setPlatform(String s)
    {
        platform = s;
        return this;
    }

    public platform setRealm(SearchRealm searchrealm)
    {
        realm = searchrealm;
        return this;
    }

    public realm setResponseFormat(String s)
    {
        responseFormat = s;
        return this;
    }

    public responseFormat setSecure(boolean flag)
    {
        secure = flag;
        return this;
    }

    public secure setSecureUrl(String s)
    {
        secureUrl = s;
        return this;
    }

    public secureUrl setServiceCallInterceptor(ServiceCallInterceptor servicecallinterceptor)
    {
        serviceCallInterceptor = servicecallinterceptor;
        return this;
    }

    public serviceCallInterceptor setUserAgent(String s)
    {
        userAgent = s;
        return this;
    }

    public userAgent setValidateObjects(boolean flag)
    {
        validateObjects = flag;
        return this;
    }

    public validateObjects setWebClient(WebClient webclient)
    {
        webClient = webclient;
        return this;
    }

    public webClient setWebClientFactory(WebClientFactory webclientfactory)
    {
        webClientFactory = webclientfactory;
        return this;
    }

    public webClientFactory setWeblabs(Map map)
    {
        weblabs = map;
        return this;
    }




















    public I()
    {
        secure = true;
    }
}
