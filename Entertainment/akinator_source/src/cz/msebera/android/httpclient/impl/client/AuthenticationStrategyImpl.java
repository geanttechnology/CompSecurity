// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.auth.AuthOption;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.client.AuthCache;
import cz.msebera.android.httpclient.client.AuthenticationStrategy;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.config.Lookup;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            BasicAuthCache

abstract class AuthenticationStrategyImpl
    implements AuthenticationStrategy
{

    private static final List DEFAULT_SCHEME_PRIORITY = Collections.unmodifiableList(Arrays.asList(new String[] {
        "negotiate", "Kerberos", "NTLM", "Digest", "Basic"
    }));
    private final int challengeCode;
    private final String headerName;
    public HttpClientAndroidLog log;

    AuthenticationStrategyImpl(int i, String s)
    {
        log = new HttpClientAndroidLog(getClass());
        challengeCode = i;
        headerName = s;
    }

    public void authFailed(HttpHost httphost, AuthScheme authscheme, HttpContext httpcontext)
    {
        Args.notNull(httphost, "Host");
        Args.notNull(httpcontext, "HTTP context");
        authscheme = HttpClientContext.adapt(httpcontext).getAuthCache();
        if (authscheme != null)
        {
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Clearing cached auth scheme for ").append(httphost).toString());
            }
            authscheme.remove(httphost);
        }
    }

    public void authSucceeded(HttpHost httphost, AuthScheme authscheme, HttpContext httpcontext)
    {
        Args.notNull(httphost, "Host");
        Args.notNull(authscheme, "Auth scheme");
        Args.notNull(httpcontext, "HTTP context");
        HttpClientContext httpclientcontext = HttpClientContext.adapt(httpcontext);
        if (isCachable(authscheme))
        {
            AuthCache authcache = httpclientcontext.getAuthCache();
            httpcontext = authcache;
            if (authcache == null)
            {
                httpcontext = new BasicAuthCache();
                httpclientcontext.setAuthCache(httpcontext);
            }
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Caching '").append(authscheme.getSchemeName()).append("' auth scheme for ").append(httphost).toString());
            }
            httpcontext.put(httphost, authscheme);
        }
    }

    public Map getChallenges(HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException
    {
        Args.notNull(httpresponse, "HTTP response");
        httpresponse = httpresponse.getHeaders(headerName);
        httpcontext = new HashMap(httpresponse.length);
        int l = httpresponse.length;
        for (int k = 0; k < l; k++)
        {
            Header header = httpresponse[k];
            int i;
            if (header instanceof FormattedHeader)
            {
                httphost = ((FormattedHeader)header).getBuffer();
            } else
            {
                String s = header.getValue();
                if (s == null)
                {
                    throw new MalformedChallengeException("Header value is null");
                }
                httphost = new CharArrayBuffer(s.length());
                httphost.append(s);
                i = 0;
            }
            for (i = ((FormattedHeader)header).getValuePos(); i < httphost.length() && HTTP.isWhitespace(httphost.charAt(i)); i++) { }
            int j;
            for (j = i; j < httphost.length() && !HTTP.isWhitespace(httphost.charAt(j)); j++) { }
            httpcontext.put(httphost.substring(i, j).toLowerCase(Locale.ENGLISH), header);
        }

        return httpcontext;
    }

    abstract Collection getPreferredAuthSchemes(RequestConfig requestconfig);

    public boolean isAuthenticationRequested(HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
    {
        Args.notNull(httpresponse, "HTTP response");
        return httpresponse.getStatusLine().getStatusCode() == challengeCode;
    }

    protected boolean isCachable(AuthScheme authscheme)
    {
        if (authscheme != null && authscheme.isComplete())
        {
            if ((authscheme = authscheme.getSchemeName()).equalsIgnoreCase("Basic") || authscheme.equalsIgnoreCase("Digest"))
            {
                return true;
            }
        }
        return false;
    }

    public Queue select(Map map, HttpHost httphost, HttpResponse httpresponse, HttpContext httpcontext)
        throws MalformedChallengeException
    {
        Args.notNull(map, "Map of auth challenges");
        Args.notNull(httphost, "Host");
        Args.notNull(httpresponse, "HTTP response");
        Args.notNull(httpcontext, "HTTP context");
        httpresponse = HttpClientContext.adapt(httpcontext);
        LinkedList linkedlist = new LinkedList();
        Lookup lookup = httpresponse.getAuthSchemeRegistry();
        if (lookup == null)
        {
            log.debug("Auth scheme registry not set in the context");
        } else
        {
            CredentialsProvider credentialsprovider = httpresponse.getCredentialsProvider();
            if (credentialsprovider == null)
            {
                log.debug("Credentials provider not set in the context");
                return linkedlist;
            }
            Collection collection = getPreferredAuthSchemes(httpresponse.getRequestConfig());
            httpresponse = collection;
            if (collection == null)
            {
                httpresponse = DEFAULT_SCHEME_PRIORITY;
            }
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Authentication schemes in the order of preference: ").append(httpresponse).toString());
            }
            httpresponse = httpresponse.iterator();
            while (httpresponse.hasNext()) 
            {
                Object obj1 = (String)httpresponse.next();
                Object obj = (Header)map.get(((String) (obj1)).toLowerCase(Locale.ENGLISH));
                if (obj != null)
                {
                    AuthSchemeProvider authschemeprovider = (AuthSchemeProvider)lookup.lookup(((String) (obj1)));
                    if (authschemeprovider == null)
                    {
                        if (log.isWarnEnabled())
                        {
                            log.warn((new StringBuilder()).append("Authentication scheme ").append(((String) (obj1))).append(" not supported").toString());
                        }
                    } else
                    {
                        obj1 = authschemeprovider.create(httpcontext);
                        ((AuthScheme) (obj1)).processChallenge(((Header) (obj)));
                        obj = credentialsprovider.getCredentials(new AuthScope(httphost.getHostName(), httphost.getPort(), ((AuthScheme) (obj1)).getRealm(), ((AuthScheme) (obj1)).getSchemeName()));
                        if (obj != null)
                        {
                            linkedlist.add(new AuthOption(((AuthScheme) (obj1)), ((cz.msebera.android.httpclient.auth.Credentials) (obj))));
                        }
                    }
                } else
                if (log.isDebugEnabled())
                {
                    log.debug((new StringBuilder()).append("Challenge for ").append(((String) (obj1))).append(" authentication scheme not available").toString());
                }
            }
        }
        return linkedlist;
    }

}
