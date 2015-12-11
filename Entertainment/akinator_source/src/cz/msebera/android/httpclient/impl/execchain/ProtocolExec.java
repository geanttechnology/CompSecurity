// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.UsernamePasswordCredentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.BasicCredentialsProvider;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpProcessor;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ClientExecChain

public class ProtocolExec
    implements ClientExecChain
{

    private final HttpProcessor httpProcessor;
    public HttpClientAndroidLog log;
    private final ClientExecChain requestExecutor;

    public ProtocolExec(ClientExecChain clientexecchain, HttpProcessor httpprocessor)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(clientexecchain, "HTTP client request executor");
        Args.notNull(httpprocessor, "HTTP protocol processor");
        requestExecutor = clientexecchain;
        httpProcessor = httpprocessor;
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        Object obj;
        Object obj1;
        Args.notNull(httproute, "HTTP route");
        Args.notNull(httprequestwrapper, "HTTP request");
        Args.notNull(httpclientcontext, "HTTP context");
        obj1 = httprequestwrapper.getOriginal();
        obj = null;
        if (!(obj1 instanceof HttpUriRequest)) goto _L2; else goto _L1
_L1:
        obj1 = ((HttpUriRequest)obj1).getURI();
_L7:
        Object obj2;
        httprequestwrapper.setURI(((URI) (obj1)));
        rewriteRequestURI(httprequestwrapper, httproute);
        HttpHost httphost1 = (HttpHost)httprequestwrapper.getParams().getParameter("http.virtual-host");
        obj = httphost1;
        if (httphost1 != null)
        {
            obj = httphost1;
            if (httphost1.getPort() == -1)
            {
                int i = httproute.getTargetHost().getPort();
                HttpHost httphost = httphost1;
                if (i != -1)
                {
                    httphost = new HttpHost(httphost1.getHostName(), i, httphost1.getSchemeName());
                }
                obj = httphost;
                if (log.isDebugEnabled())
                {
                    log.debug((new StringBuilder()).append("Using virtual host").append(httphost).toString());
                    obj = httphost;
                }
            }
        }
        obj2 = null;
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj2 = obj;
        if (obj == null)
        {
            obj2 = httproute.getTargetHost();
        }
        if (obj1 != null)
        {
            String s = ((URI) (obj1)).getUserInfo();
            if (s != null)
            {
                obj1 = httpclientcontext.getCredentialsProvider();
                obj = obj1;
                if (obj1 == null)
                {
                    obj = new BasicCredentialsProvider();
                    httpclientcontext.setCredentialsProvider(((CredentialsProvider) (obj)));
                }
                ((CredentialsProvider) (obj)).setCredentials(new AuthScope(((HttpHost) (obj2))), new UsernamePasswordCredentials(s));
            }
        }
        httpclientcontext.setAttribute("http.target_host", obj2);
        httpclientcontext.setAttribute("http.route", httproute);
        httpclientcontext.setAttribute("http.request", httprequestwrapper);
        httpProcessor.process(httprequestwrapper, httpclientcontext);
        httproute = requestExecutor.execute(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        httpclientcontext.setAttribute("http.response", httproute);
        httpProcessor.process(httproute, httpclientcontext);
        return httproute;
_L2:
        obj2 = ((HttpRequest) (obj1)).getRequestLine().getUri();
        try
        {
            obj1 = URI.create(((String) (obj2)));
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            obj1 = obj;
            if (log.isDebugEnabled())
            {
                log.debug((new StringBuilder()).append("Unable to parse '").append(((String) (obj2))).append("' as a valid URI; ").append("request URI and Host header may be inconsistent").toString(), illegalargumentexception);
                obj1 = obj;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        obj = obj2;
        if (obj1 != null)
        {
            obj = obj2;
            if (((URI) (obj1)).isAbsolute())
            {
                obj = obj2;
                if (((URI) (obj1)).getHost() != null)
                {
                    obj = new HttpHost(((URI) (obj1)).getHost(), ((URI) (obj1)).getPort(), ((URI) (obj1)).getScheme());
                }
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
        httprequestwrapper;
        httproute.close();
        throw httprequestwrapper;
        httprequestwrapper;
        httproute.close();
        throw httprequestwrapper;
        httprequestwrapper;
        httproute.close();
        throw httprequestwrapper;
        if (true) goto _L7; else goto _L6
_L6:
    }

    void rewriteRequestURI(HttpRequestWrapper httprequestwrapper, HttpRoute httproute)
        throws ProtocolException
    {
        URI uri;
        try
        {
            uri = httprequestwrapper.getURI();
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            throw new ProtocolException((new StringBuilder()).append("Invalid URI: ").append(httprequestwrapper.getRequestLine().getUri()).toString(), httproute);
        }
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        if (httproute.getProxyHost() == null || httproute.isTunnelled()) goto _L2; else goto _L1
_L1:
        if (uri.isAbsolute()) goto _L4; else goto _L3
_L3:
        httproute = URIUtils.rewriteURI(uri, httproute.getTargetHost(), true);
_L5:
        httprequestwrapper.setURI(httproute);
        return;
_L4:
        httproute = URIUtils.rewriteURI(uri);
          goto _L5
_L2:
label0:
        {
            if (!uri.isAbsolute())
            {
                break label0;
            }
            httproute = URIUtils.rewriteURI(uri, null, true);
        }
          goto _L5
        httproute = URIUtils.rewriteURI(uri);
          goto _L5
    }
}
