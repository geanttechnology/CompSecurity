// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;

import com.amazon.searchapp.retailsearch.client.SearchConfiguration;
import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.ObjectParser;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallInterceptor;
import com.amazon.searchapp.retailsearch.client.web.ServiceClient;
import com.amazon.searchapp.retailsearch.client.web.WebClient;
import com.amazon.searchapp.retailsearch.client.web.WebClientFactory;
import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.suggestions:
//            SearchSuggestionsClient

public static class secure
{

    private String baseUrl;
    private String clientId;
    private CollectionMap cookies;
    private CollectionMap headers;
    private String method;
    private ObjectParser objectParser;
    private CollectionMap parameters;
    private SearchRealm realm;
    private boolean secure;
    private ServiceCallInterceptor serviceCallInterceptor;
    private String userAgent;
    private WebClient webClient;
    private WebClientFactory webClientFactory;
    private Map weblabs;

    public SearchSuggestionsClient build()
    {
        if (webClientFactory == null && webClient != null)
        {
            webClientFactory = ServiceClient.createWebClientFactory(webClient);
        }
        if (realm == null)
        {
            realm = SearchConfiguration.getConfiguration().getRealm();
        }
        if (baseUrl == null && realm != null)
        {
            String s;
            if (secure)
            {
                s = realm.getSecureCompletionServiceUrl();
            } else
            {
                s = realm.getCompletionServiceUrl();
            }
            baseUrl = s;
        }
        return new SearchSuggestionsClient(this, null);
    }

    public baseUrl setClientId(String s)
    {
        clientId = s;
        return this;
    }

    public clientId setWebClient(WebClient webclient)
    {
        webClient = webclient;
        return this;
    }














    public ()
    {
        secure = true;
    }
}
