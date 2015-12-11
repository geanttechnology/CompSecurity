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
//            SearchSuggestionsClientApi, SearchSuggestionsServiceCall, SearchSuggestionsListener

public class SearchSuggestionsClient extends ServiceClient
    implements SearchSuggestionsClientApi
{
    public static class Builder
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
            return new SearchSuggestionsClient(this);
        }

        public Builder setClientId(String s)
        {
            clientId = s;
            return this;
        }

        public Builder setWebClient(WebClient webclient)
        {
            webClient = webclient;
            return this;
        }














        public Builder()
        {
            secure = true;
        }
    }


    private final String clientId;
    private final SearchRealm realm;
    private final Map weblabs;

    private SearchSuggestionsClient(Builder builder)
    {
        super(builder.webClientFactory, builder.secure, builder.method, builder.baseUrl, builder.parameters, builder.headers, builder.userAgent, builder.cookies, builder.serviceCallInterceptor, builder.objectParser);
        realm = builder.realm;
        clientId = builder.clientId;
        weblabs = builder.weblabs;
    }


    protected final String getClientId()
    {
        return clientId;
    }

    protected final SearchRealm getRealm()
    {
        return realm;
    }

    public SearchSuggestionsServiceCall searchSuggestions(String s, String s1, SearchSuggestionsListener searchsuggestionslistener)
    {
        s1 = new SearchSuggestionsRequest.Builder(s1);
        if (s != null && !s.equals(""))
        {
            s1.setSearchAlias(s);
        }
        return new SearchSuggestionsServiceCall(this, s1.build(), searchsuggestionslistener, null);
    }
}
