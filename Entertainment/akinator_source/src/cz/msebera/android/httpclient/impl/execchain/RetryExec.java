// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.NonRepeatableRequestException;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ClientExecChain, RequestEntityProxy

public class RetryExec
    implements ClientExecChain
{

    public HttpClientAndroidLog log;
    private final ClientExecChain requestExecutor;
    private final HttpRequestRetryHandler retryHandler;

    public RetryExec(ClientExecChain clientexecchain, HttpRequestRetryHandler httprequestretryhandler)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(clientexecchain, "HTTP request executor");
        Args.notNull(httprequestretryhandler, "HTTP request retry handler");
        requestExecutor = clientexecchain;
        retryHandler = httprequestretryhandler;
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        cz.msebera.android.httpclient.Header aheader[];
        int i;
        Args.notNull(httproute, "HTTP route");
        Args.notNull(httprequestwrapper, "HTTP request");
        Args.notNull(httpclientcontext, "HTTP context");
        aheader = httprequestwrapper.getAllHeaders();
        i = 1;
_L2:
        CloseableHttpResponse closeablehttpresponse = requestExecutor.execute(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        return closeablehttpresponse;
        IOException ioexception;
        ioexception;
        if (httpexecutionaware != null && httpexecutionaware.isAborted())
        {
            log.debug("Request has been aborted");
            throw ioexception;
        }
        if (!retryHandler.retryRequest(ioexception, i, httpclientcontext))
        {
            break; /* Loop/switch isn't completed */
        }
        if (log.isInfoEnabled())
        {
            log.info((new StringBuilder()).append("I/O exception (").append(ioexception.getClass().getName()).append(") caught when processing request to ").append(httproute).append(": ").append(ioexception.getMessage()).toString());
        }
        if (log.isDebugEnabled())
        {
            log.debug(ioexception.getMessage(), ioexception);
        }
        if (!RequestEntityProxy.isRepeatable(httprequestwrapper))
        {
            log.debug("Cannot retry non-repeatable request");
            throw new NonRepeatableRequestException("Cannot retry request with a non-repeatable request entity", ioexception);
        }
        httprequestwrapper.setHeaders(aheader);
        if (log.isInfoEnabled())
        {
            log.info((new StringBuilder()).append("Retrying request to ").append(httproute).toString());
        }
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (ioexception instanceof NoHttpResponseException)
        {
            httproute = new NoHttpResponseException((new StringBuilder()).append(httproute.getTargetHost().toHostString()).append(" failed to respond").toString());
            httproute.setStackTrace(ioexception.getStackTrace());
            throw httproute;
        } else
        {
            throw ioexception;
        }
    }
}
