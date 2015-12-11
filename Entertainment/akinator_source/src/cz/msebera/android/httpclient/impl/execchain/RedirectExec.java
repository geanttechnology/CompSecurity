// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthState;
import cz.msebera.android.httpclient.client.RedirectException;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;
import java.util.List;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ClientExecChain, RequestEntityProxy

public class RedirectExec
    implements ClientExecChain
{

    public HttpClientAndroidLog log;
    private final RedirectStrategy redirectStrategy;
    private final ClientExecChain requestExecutor;
    private final HttpRoutePlanner routePlanner;

    public RedirectExec(ClientExecChain clientexecchain, HttpRoutePlanner httprouteplanner, RedirectStrategy redirectstrategy)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(clientexecchain, "HTTP client request executor");
        Args.notNull(httprouteplanner, "HTTP route planner");
        Args.notNull(redirectstrategy, "HTTP redirect strategy");
        requestExecutor = clientexecchain;
        routePlanner = httprouteplanner;
        redirectStrategy = redirectstrategy;
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        Object obj;
        CloseableHttpResponse closeablehttpresponse;
        int j;
        Args.notNull(httproute, "HTTP route");
        Args.notNull(httprequestwrapper, "HTTP request");
        Args.notNull(httpclientcontext, "HTTP context");
        obj = httpclientcontext.getRedirectLocations();
        if (obj != null)
        {
            ((List) (obj)).clear();
        }
        RequestConfig requestconfig = httpclientcontext.getRequestConfig();
        int i;
        if (requestconfig.getMaxRedirects() > 0)
        {
            i = requestconfig.getMaxRedirects();
        } else
        {
            i = 50;
        }
        obj = httprequestwrapper;
        j = 0;
_L1:
        closeablehttpresponse = requestExecutor.execute(httproute, ((HttpRequestWrapper) (obj)), httpclientcontext, httpexecutionaware);
        if (!requestconfig.isRedirectsEnabled() || !redirectStrategy.isRedirected(((HttpRequest) (obj)), closeablehttpresponse, httpclientcontext))
        {
            break MISSING_BLOCK_LABEL_507;
        }
        if (j >= i)
        {
            java.net.URI uri;
            HttpHost httphost;
            AuthScheme authscheme;
            try
            {
                throw new RedirectException((new StringBuilder()).append("Maximum redirects (").append(i).append(") exceeded").toString());
            }
            // Misplaced declaration of an exception variable
            catch (HttpRoute httproute)
            {
                closeablehttpresponse.close();
                throw httproute;
            }
            // Misplaced declaration of an exception variable
            catch (HttpRoute httproute)
            {
                closeablehttpresponse.close();
                throw httproute;
            }
            // Misplaced declaration of an exception variable
            catch (HttpRoute httproute) { }
            break MISSING_BLOCK_LABEL_457;
        }
        j++;
        obj = redirectStrategy.getRedirect(((HttpRequest) (obj)), closeablehttpresponse, httpclientcontext);
        if (!((HttpRequest) (obj)).headerIterator().hasNext())
        {
            ((HttpRequest) (obj)).setHeaders(httprequestwrapper.getOriginal().getAllHeaders());
        }
        obj = HttpRequestWrapper.wrap(((HttpRequest) (obj)));
        if (obj instanceof HttpEntityEnclosingRequest)
        {
            RequestEntityProxy.enhance((HttpEntityEnclosingRequest)obj);
        }
        uri = ((HttpRequestWrapper) (obj)).getURI();
        httphost = URIUtils.extractHost(uri);
        if (httphost != null)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        throw new ProtocolException((new StringBuilder()).append("Redirect URI does not specify a valid host name: ").append(uri).toString());
        if (httproute.getTargetHost().equals(httphost))
        {
            break MISSING_BLOCK_LABEL_375;
        }
        httproute = httpclientcontext.getTargetAuthState();
        if (httproute == null)
        {
            break MISSING_BLOCK_LABEL_332;
        }
        log.debug("Resetting target auth state");
        httproute.reset();
        httproute = httpclientcontext.getProxyAuthState();
        if (httproute == null)
        {
            break MISSING_BLOCK_LABEL_375;
        }
        authscheme = httproute.getAuthScheme();
        if (authscheme == null)
        {
            break MISSING_BLOCK_LABEL_375;
        }
        if (authscheme.isConnectionBased())
        {
            log.debug("Resetting proxy auth state");
            httproute.reset();
        }
        httproute = routePlanner.determineRoute(httphost, ((HttpRequest) (obj)), httpclientcontext);
        if (log.isDebugEnabled())
        {
            log.debug((new StringBuilder()).append("Redirecting to '").append(uri).append("' via ").append(httproute).toString());
        }
        EntityUtils.consume(closeablehttpresponse.getEntity());
        closeablehttpresponse.close();
          goto _L1
        EntityUtils.consume(closeablehttpresponse.getEntity());
        closeablehttpresponse.close();
_L3:
        throw httproute;
        httprequestwrapper;
        log.debug("I/O error while releasing connection", httprequestwrapper);
        closeablehttpresponse.close();
        if (true) goto _L3; else goto _L2
_L2:
        httproute;
        closeablehttpresponse.close();
        throw httproute;
        return closeablehttpresponse;
    }
}
