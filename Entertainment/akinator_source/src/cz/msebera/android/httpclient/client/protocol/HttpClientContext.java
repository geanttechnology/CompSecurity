// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.protocol;

import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.CookieStore;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.protocol.HttpCoreContext;
import java.util.List;

public class HttpClientContext extends HttpCoreContext
{

    public static final String AUTHSCHEME_REGISTRY = "http.authscheme-registry";
    public static final String AUTH_CACHE = "http.auth.auth-cache";
    public static final String COOKIESPEC_REGISTRY = "http.cookiespec-registry";
    public static final String COOKIE_ORIGIN = "http.cookie-origin";
    public static final String COOKIE_SPEC = "http.cookie-spec";
    public static final String COOKIE_STORE = "http.cookie-store";
    public static final String CREDS_PROVIDER = "http.auth.credentials-provider";
    public static final String HTTP_ROUTE = "http.route";
    public static final String PROXY_AUTH_STATE = "http.auth.proxy-scope";
    public static final String REDIRECT_LOCATIONS = "http.protocol.redirect-locations";
    public static final String REQUEST_CONFIG = "http.request-config";
    public static final String TARGET_AUTH_STATE = "http.auth.target-scope";
    public static final String USER_TOKEN = "http.user-token";

    public HttpClientContext()
    {
    }

    public HttpClientContext(HttpContext httpcontext)
    {
        super(httpcontext);
    }

    public static HttpClientContext adapt(HttpContext httpcontext)
    {
        if (httpcontext instanceof HttpClientContext)
        {
            return (HttpClientContext)httpcontext;
        } else
        {
            return new HttpClientContext(httpcontext);
        }
    }

    public static HttpClientContext create()
    {
        return new HttpClientContext(new BasicHttpContext());
    }

    private Lookup getLookup(String s, Class class1)
    {
        return (Lookup)getAttribute(s, cz/msebera/android/httpclient/config/Lookup);
    }

    public AuthCache getAuthCache()
    {
        return (AuthCache)getAttribute("http.auth.auth-cache", cz/msebera/android/httpclient/client/AuthCache);
    }

    public Lookup getAuthSchemeRegistry()
    {
        return getLookup("http.authscheme-registry", cz/msebera/android/httpclient/auth/AuthSchemeProvider);
    }

    public CookieOrigin getCookieOrigin()
    {
        return (CookieOrigin)getAttribute("http.cookie-origin", cz/msebera/android/httpclient/cookie/CookieOrigin);
    }

    public CookieSpec getCookieSpec()
    {
        return (CookieSpec)getAttribute("http.cookie-spec", cz/msebera/android/httpclient/cookie/CookieSpec);
    }

    public Lookup getCookieSpecRegistry()
    {
        return getLookup("http.cookiespec-registry", cz/msebera/android/httpclient/cookie/CookieSpecProvider);
    }

    public CookieStore getCookieStore()
    {
        return (CookieStore)getAttribute("http.cookie-store", cz/msebera/android/httpclient/client/CookieStore);
    }

    public CredentialsProvider getCredentialsProvider()
    {
        return (CredentialsProvider)getAttribute("http.auth.credentials-provider", cz/msebera/android/httpclient/client/CredentialsProvider);
    }

    public RouteInfo getHttpRoute()
    {
        return (RouteInfo)getAttribute("http.route", cz/msebera/android/httpclient/conn/routing/HttpRoute);
    }

    public AuthState getProxyAuthState()
    {
        return (AuthState)getAttribute("http.auth.proxy-scope", cz/msebera/android/httpclient/auth/AuthState);
    }

    public List getRedirectLocations()
    {
        return (List)getAttribute("http.protocol.redirect-locations", java/util/List);
    }

    public RequestConfig getRequestConfig()
    {
        RequestConfig requestconfig = (RequestConfig)getAttribute("http.request-config", cz/msebera/android/httpclient/client/config/RequestConfig);
        if (requestconfig != null)
        {
            return requestconfig;
        } else
        {
            return RequestConfig.DEFAULT;
        }
    }

    public AuthState getTargetAuthState()
    {
        return (AuthState)getAttribute("http.auth.target-scope", cz/msebera/android/httpclient/auth/AuthState);
    }

    public Object getUserToken()
    {
        return getAttribute("http.user-token");
    }

    public Object getUserToken(Class class1)
    {
        return getAttribute("http.user-token", class1);
    }

    public void setAuthCache(AuthCache authcache)
    {
        setAttribute("http.auth.auth-cache", authcache);
    }

    public void setAuthSchemeRegistry(Lookup lookup)
    {
        setAttribute("http.authscheme-registry", lookup);
    }

    public void setCookieSpecRegistry(Lookup lookup)
    {
        setAttribute("http.cookiespec-registry", lookup);
    }

    public void setCookieStore(CookieStore cookiestore)
    {
        setAttribute("http.cookie-store", cookiestore);
    }

    public void setCredentialsProvider(CredentialsProvider credentialsprovider)
    {
        setAttribute("http.auth.credentials-provider", credentialsprovider);
    }

    public void setRequestConfig(RequestConfig requestconfig)
    {
        setAttribute("http.request-config", requestconfig);
    }

    public void setUserToken(Object obj)
    {
        setAttribute("http.user-token", obj);
    }
}
