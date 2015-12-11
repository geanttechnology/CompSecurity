// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.client.ServiceUnavailableRetryStrategy;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ClientExecChain

public class ServiceUnavailableRetryExec
    implements ClientExecChain
{

    public HttpClientAndroidLog log;
    private final ClientExecChain requestExecutor;
    private final ServiceUnavailableRetryStrategy retryStrategy;

    public ServiceUnavailableRetryExec(ClientExecChain clientexecchain, ServiceUnavailableRetryStrategy serviceunavailableretrystrategy)
    {
        log = new HttpClientAndroidLog(getClass());
        Args.notNull(clientexecchain, "HTTP request executor");
        Args.notNull(serviceunavailableretrystrategy, "Retry strategy");
        requestExecutor = clientexecchain;
        retryStrategy = serviceunavailableretrystrategy;
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        cz.msebera.android.httpclient.Header aheader[];
        int i;
        aheader = httprequestwrapper.getAllHeaders();
        i = 1;
_L2:
        CloseableHttpResponse closeablehttpresponse = requestExecutor.execute(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        long l;
        if (!retryStrategy.retryRequest(closeablehttpresponse, i, httpclientcontext))
        {
            break; /* Loop/switch isn't completed */
        }
        closeablehttpresponse.close();
        l = retryStrategy.getRetryInterval();
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        try
        {
            log.trace((new StringBuilder()).append("Wait for ").append(l).toString());
            Thread.sleep(l);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRoute httproute)
        {
            try
            {
                Thread.currentThread().interrupt();
                throw new InterruptedIOException();
            }
            // Misplaced declaration of an exception variable
            catch (HttpRoute httproute)
            {
                closeablehttpresponse.close();
            }
            throw httproute;
        }
        httprequestwrapper.setHeaders(aheader);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        return closeablehttpresponse;
    }
}
