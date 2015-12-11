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
//            SearchSuggestionsClientApi, SearchSuggestionsServiceCall, SearchSuggestionsRequest, SearchSuggestionsListener

public class SearchSuggestionsClient extends ServiceClient
    implements SearchSuggestionsClientApi
{
    public static class Builder
    {

        private String clientId;
        private CollectionMap cookies;
        private CollectionMap headers;
        private String insecureUrl;
        private String method;
        private ObjectParser objectParser;
        private CollectionMap parameters;
        private SearchRealm realm;
        private boolean secure;
        private String secureUrl;
        private ServiceCallInterceptor serviceCallInterceptor;
        private String userAgent;
        private boolean validateObjects;
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
            if (realm != null)
            {
                if (secureUrl == null)
                {
                    secureUrl = realm.getSecureCompletionServiceUrl();
                }
                if (insecureUrl == null)
                {
                    insecureUrl = realm.getCompletionServiceUrl();
                }
            }
            return new SearchSuggestionsClient(this);
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

        public SearchRealm getRealm()
        {
            return realm;
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

        public Builder setClientId(String s)
        {
            clientId = s;
            return this;
        }

        public Builder setCookies(CollectionMap collectionmap)
        {
            cookies = collectionmap;
            return this;
        }

        public Builder setCookies(Map map)
        {
            cookies = new CollectionMap(map);
            return this;
        }

        public Builder setHeaders(CollectionMap collectionmap)
        {
            headers = collectionmap;
            return this;
        }

        public Builder setHeaders(Map map)
        {
            headers = new CollectionMap(map);
            return this;
        }

        public Builder setInsecureUrl(String s)
        {
            insecureUrl = s;
            return this;
        }

        public Builder setMethod(String s)
        {
            method = s;
            return this;
        }

        public Builder setObjectParser(ObjectParser objectparser)
        {
            objectParser = objectparser;
            return this;
        }

        public Builder setParameters(CollectionMap collectionmap)
        {
            parameters = collectionmap;
            return this;
        }

        public Builder setRealm(SearchRealm searchrealm)
        {
            realm = searchrealm;
            return this;
        }

        public Builder setSecure(boolean flag)
        {
            secure = flag;
            return this;
        }

        public Builder setSecureUrl(String s)
        {
            secureUrl = s;
            return this;
        }

        public Builder setServiceCallInterceptor(ServiceCallInterceptor servicecallinterceptor)
        {
            serviceCallInterceptor = servicecallinterceptor;
            return this;
        }

        public Builder setUserAgent(String s)
        {
            userAgent = s;
            return this;
        }

        public Builder setValidateObjects(boolean flag)
        {
            validateObjects = flag;
            return this;
        }

        public Builder setWebClient(WebClient webclient)
        {
            webClient = webclient;
            return this;
        }

        public Builder setWebClientFactory(WebClientFactory webclientfactory)
        {
            webClientFactory = webclientfactory;
            return this;
        }

        public Builder setWeblabs(Map map)
        {
            weblabs = map;
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
        super(builder.webClientFactory, builder.secure, builder.method, builder.secureUrl, builder.insecureUrl, builder.parameters, builder.headers, builder.userAgent, builder.cookies, builder.serviceCallInterceptor, builder.validateObjects, builder.objectParser);
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

    protected final Map getWeblabs()
    {
        return weblabs;
    }

    public SearchSuggestionsServiceCall searchSuggestions(SearchSuggestionsRequest searchsuggestionsrequest)
    {
        return searchSuggestions(searchsuggestionsrequest, null);
    }

    public SearchSuggestionsServiceCall searchSuggestions(SearchSuggestionsRequest searchsuggestionsrequest, SearchSuggestionsListener searchsuggestionslistener)
    {
        return new SearchSuggestionsServiceCall(this, searchsuggestionsrequest, searchsuggestionslistener, null);
    }

    public SearchSuggestionsServiceCall searchSuggestions(String s)
    {
        return searchSuggestions(s, null);
    }

    public SearchSuggestionsServiceCall searchSuggestions(String s, SearchSuggestionsListener searchsuggestionslistener)
    {
        return searchSuggestions(null, s, searchsuggestionslistener);
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
