// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.util.ClassUtil;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.ObjectParser;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallInterceptor;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceClient;
import com.amazon.searchapp.retailsearch.client.web.WebClient;
import com.amazon.searchapp.retailsearch.client.web.WebClientFactory;
import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchClientApi, AssetsServiceCall, PersonalizedSuggestionsServiceCall, RefinementsServiceCall, 
//            SearchServiceCall, SimsServiceCall, SearchRealm, SearchRequest, 
//            SearchListener, SearchConfiguration

public class RetailSearchClient extends ServiceClient
    implements RetailSearchClientApi
{
    public static class Builder
    {

        private String apiVersion;
        private String appId;
        private String baseUrl;
        private String clientId;
        private CollectionMap cookies;
        private CollectionMap headers;
        private String method;
        private ObjectParser objectParser;
        private CollectionMap parameters;
        private String platform;
        private SearchRealm realm;
        private String responseFormat;
        private boolean secure;
        private ServiceCallInterceptor serviceCallInterceptor;
        private String userAgent;
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
            if (baseUrl == null && realm != null)
            {
                String s;
                if (secure)
                {
                    s = realm.getSecureSearchServiceUrl();
                } else
                {
                    s = realm.getSearchServiceUrl();
                }
                baseUrl = s;
            }
            return new RetailSearchClient(this);
        }

        public Builder setClientId(String s)
        {
            clientId = s;
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

        public Builder setWebClientFactory(WebClientFactory webclientfactory)
        {
            webClientFactory = webclientfactory;
            return this;
        }


















        public Builder()
        {
            secure = true;
        }
    }


    private static String PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/RetailSearchClient.getPackage().getName()).append(".jackson.StandardParser").toString();
    private final String apiVersion;
    private final String appId;
    private final String clientId;
    private final String platform;
    private final SearchRealm realm;
    private final String responseFormat;
    private final Map weblabs;

    private RetailSearchClient(Builder builder)
    {
        super(builder.webClientFactory, builder.secure, builder.method, builder.baseUrl, builder.parameters, builder.headers, builder.userAgent, builder.cookies, builder.serviceCallInterceptor, builder.objectParser);
        realm = builder.realm;
        String s;
        if (builder.apiVersion == null)
        {
            s = "v0.1";
        } else
        {
            s = builder.apiVersion;
        }
        apiVersion = s;
        clientId = builder.clientId;
        if (builder.responseFormat == null)
        {
            s = "json";
        } else
        {
            s = builder.responseFormat;
        }
        responseFormat = s;
        appId = builder.appId;
        platform = builder.platform;
        weblabs = builder.weblabs;
    }


    public AssetsServiceCall assets(ServiceCallListener servicecalllistener)
    {
        return new AssetsServiceCall(this, servicecalllistener);
    }

    public ObjectParser buildDefaultObjectParser()
    {
        return (ObjectParser)ClassUtil.createInstance(PARSER_CLASS);
    }

    public final String getApiVersion()
    {
        return apiVersion;
    }

    public final String getAppId()
    {
        return appId;
    }

    public final String getClientId()
    {
        return clientId;
    }

    public final String getPlatform()
    {
        return platform;
    }

    public final SearchRealm getRealm()
    {
        return realm;
    }

    public final String getResponseFormat()
    {
        return responseFormat;
    }

    protected final Map getWeblabs()
    {
        return weblabs;
    }

    public PersonalizedSuggestionsServiceCall personalizedSuggestions(ServiceCallListener servicecalllistener)
    {
        return new PersonalizedSuggestionsServiceCall(this, servicecalllistener);
    }

    public PersonalizedSuggestionsServiceCall personalizedSuggestions(String s, String s1, ServiceCallListener servicecalllistener)
    {
        return new PersonalizedSuggestionsServiceCall(this, s, s1, servicecalllistener);
    }

    public RefinementsServiceCall refinements(ServiceCallListener servicecalllistener, String s)
    {
        return new RefinementsServiceCall(this, servicecalllistener, s);
    }

    public SearchServiceCall search(SearchRequest searchrequest, SearchListener searchlistener)
    {
        return new SearchServiceCall(this, searchrequest, searchlistener, null);
    }

    public SimsServiceCall similarities(ServiceCallListener servicecalllistener, String s)
    {
        return new SimsServiceCall(this, servicecalllistener, s);
    }

}
