// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.airstream.AirstreamFavoritesRequest;
import com.amazon.searchapp.retailsearch.client.airstream.AirstreamFavoritesServiceCall;
import com.amazon.searchapp.retailsearch.client.airstream.AirstreamRequest;
import com.amazon.searchapp.retailsearch.client.airstream.AirstreamServiceCall;
import com.amazon.searchapp.retailsearch.client.favorites.AddFavoritesRequest;
import com.amazon.searchapp.retailsearch.client.favorites.AddFavoritesServiceCall;
import com.amazon.searchapp.retailsearch.client.favorites.RemoveFavoritesRequest;
import com.amazon.searchapp.retailsearch.client.favorites.RemoveFavoritesServiceCall;
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
//            RetailSearchClientApi, AssetsServiceCall, LocationServiceCall, MetricsServiceCall, 
//            PersonalizedSuggestionsServiceCall, RefinementsServiceCall, SearchServiceCall, SimsServiceCall, 
//            SearchRealm, SearchListener, SearchRequest, SearchConfiguration

public class RetailSearchClient extends ServiceClient
    implements RetailSearchClientApi
{
    public static class Builder
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
            return new RetailSearchClient(this);
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

        public Builder setApiVersion(String s)
        {
            apiVersion = s;
            return this;
        }

        public Builder setAppId(String s)
        {
            appId = s;
            return this;
        }

        public Builder setAppId(String s, String s1, String s2)
        {
            appId = RetailSearchClient.createAppId(s, s1, s2);
            return this;
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

        public Builder setPlatform(String s)
        {
            platform = s;
            return this;
        }

        public Builder setRealm(SearchRealm searchrealm)
        {
            realm = searchrealm;
            return this;
        }

        public Builder setResponseFormat(String s)
        {
            responseFormat = s;
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


    private static String PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/RetailSearchClient.getPackage().getName()).append(".jackson.StandardParser").toString();
    private static String VALIDATING_PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/RetailSearchClient.getPackage().getName()).append(".jackson.ValidatingParser").toString();
    private final String apiVersion;
    private final String appId;
    private final String clientId;
    private final String platform;
    private final SearchRealm realm;
    private final String responseFormat;
    private final Map weblabs;

    private RetailSearchClient(Builder builder)
    {
        super(builder.webClientFactory, builder.secure, builder.method, builder.secureUrl, builder.insecureUrl, builder.parameters, builder.headers, builder.userAgent, builder.cookies, builder.serviceCallInterceptor, builder.validateObjects, builder.objectParser);
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


    public static String createAppId(String s, String s1, String s2)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (s != null)
        {
            stringbuilder.append(s);
        }
        stringbuilder.append('/');
        if (s1 != null)
        {
            stringbuilder.append(s1);
        }
        stringbuilder.append('/');
        if (s2 != null)
        {
            stringbuilder.append(s2);
        }
        return stringbuilder.toString();
    }

    public AddFavoritesServiceCall addFavorites(AddFavoritesRequest addfavoritesrequest)
    {
        return new AddFavoritesServiceCall(this, addfavoritesrequest, null);
    }

    public AddFavoritesServiceCall addFavorites(AddFavoritesRequest addfavoritesrequest, ServiceCallListener servicecalllistener)
    {
        return new AddFavoritesServiceCall(this, addfavoritesrequest, servicecalllistener);
    }

    public AirstreamServiceCall airstream(AirstreamRequest airstreamrequest)
    {
        return new AirstreamServiceCall(this, airstreamrequest, null);
    }

    public AirstreamServiceCall airstream(AirstreamRequest airstreamrequest, SearchListener searchlistener)
    {
        return new AirstreamServiceCall(this, airstreamrequest, searchlistener);
    }

    public AirstreamFavoritesServiceCall airstreamFavorites(AirstreamFavoritesRequest airstreamfavoritesrequest)
    {
        return new AirstreamFavoritesServiceCall(this, airstreamfavoritesrequest, null);
    }

    public AirstreamFavoritesServiceCall airstreamFavorites(AirstreamFavoritesRequest airstreamfavoritesrequest, SearchListener searchlistener)
    {
        return new AirstreamFavoritesServiceCall(this, airstreamfavoritesrequest, searchlistener);
    }

    public SearchServiceCall aliasKeywordSearch(String s, String s1)
    {
        return aliasKeywordSearch(s, s1, null);
    }

    public SearchServiceCall aliasKeywordSearch(String s, String s1, SearchListener searchlistener)
    {
        return search((new SearchRequest.Builder(s, s1)).build(), searchlistener);
    }

    public AssetsServiceCall assets()
    {
        return assets(null);
    }

    public AssetsServiceCall assets(ServiceCallListener servicecalllistener)
    {
        return new AssetsServiceCall(this, servicecalllistener);
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

    protected ObjectParser getDefaultObjectParser()
    {
        String s;
        if (getValidateObjects())
        {
            s = VALIDATING_PARSER_CLASS;
        } else
        {
            s = PARSER_CLASS;
        }
        return (ObjectParser)ClassUtil.createInstance(s);
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

    public SearchServiceCall keywordSearch(String s)
    {
        return keywordSearch(s, null);
    }

    public SearchServiceCall keywordSearch(String s, SearchListener searchlistener)
    {
        return search((new SearchRequest.Builder(s)).build(), searchlistener);
    }

    public LocationServiceCall location(ServiceCallListener servicecalllistener, String s)
    {
        return new LocationServiceCall(this, servicecalllistener, s);
    }

    public MetricsServiceCall metrics()
    {
        return metrics(null);
    }

    public MetricsServiceCall metrics(ServiceCallListener servicecalllistener)
    {
        return new MetricsServiceCall(this, servicecalllistener);
    }

    public PersonalizedSuggestionsServiceCall personalizedSuggestions()
    {
        return personalizedSuggestions(null);
    }

    public PersonalizedSuggestionsServiceCall personalizedSuggestions(ServiceCallListener servicecalllistener)
    {
        return new PersonalizedSuggestionsServiceCall(this, servicecalllistener);
    }

    public PersonalizedSuggestionsServiceCall personalizedSuggestions(String s, String s1, ServiceCallListener servicecalllistener)
    {
        return new PersonalizedSuggestionsServiceCall(this, s, s1, servicecalllistener);
    }

    public RefinementsServiceCall refinements()
    {
        return refinements(null, null);
    }

    public RefinementsServiceCall refinements(ServiceCallListener servicecalllistener, String s)
    {
        return new RefinementsServiceCall(this, servicecalllistener, s);
    }

    public RemoveFavoritesServiceCall removeFavorites(RemoveFavoritesRequest removefavoritesrequest)
    {
        return new RemoveFavoritesServiceCall(this, removefavoritesrequest, null);
    }

    public RemoveFavoritesServiceCall removeFavorites(RemoveFavoritesRequest removefavoritesrequest, ServiceCallListener servicecalllistener)
    {
        return new RemoveFavoritesServiceCall(this, removefavoritesrequest, servicecalllistener);
    }

    public SearchServiceCall search(SearchRequest searchrequest)
    {
        return search(searchrequest, null);
    }

    public SearchServiceCall search(SearchRequest searchrequest, SearchListener searchlistener)
    {
        return new SearchServiceCall(this, searchrequest, searchlistener, null);
    }

    public SimsServiceCall similarities(ServiceCallListener servicecalllistener, String s, int i, String s1)
    {
        return new SimsServiceCall(this, servicecalllistener, s, i, s1);
    }

}
