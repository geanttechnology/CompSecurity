// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.client.BackoffManager;
import cz.msebera.android.httpclient.client.ConnectionBackoffStrategy;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpExecutionAware;
import cz.msebera.android.httpclient.client.methods.HttpRequestWrapper;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ClientExecChain

public class BackoffStrategyExec
    implements ClientExecChain
{

    private final BackoffManager backoffManager;
    private final ConnectionBackoffStrategy connectionBackoffStrategy;
    private final ClientExecChain requestExecutor;

    public BackoffStrategyExec(ClientExecChain clientexecchain, ConnectionBackoffStrategy connectionbackoffstrategy, BackoffManager backoffmanager)
    {
        Args.notNull(clientexecchain, "HTTP client request executor");
        Args.notNull(connectionbackoffstrategy, "Connection backoff strategy");
        Args.notNull(backoffmanager, "Backoff manager");
        requestExecutor = clientexecchain;
        connectionBackoffStrategy = connectionbackoffstrategy;
        backoffManager = backoffmanager;
    }

    public CloseableHttpResponse execute(HttpRoute httproute, HttpRequestWrapper httprequestwrapper, HttpClientContext httpclientcontext, HttpExecutionAware httpexecutionaware)
        throws IOException, HttpException
    {
        Args.notNull(httproute, "HTTP route");
        Args.notNull(httprequestwrapper, "HTTP request");
        Args.notNull(httpclientcontext, "HTTP context");
        try
        {
            httprequestwrapper = requestExecutor.execute(httproute, httprequestwrapper, httpclientcontext, httpexecutionaware);
        }
        // Misplaced declaration of an exception variable
        catch (HttpRequestWrapper httprequestwrapper)
        {
            if (false)
            {
                throw new NullPointerException();
            }
            if (connectionBackoffStrategy.shouldBackoff(httprequestwrapper))
            {
                backoffManager.backOff(httproute);
            }
            if (httprequestwrapper instanceof RuntimeException)
            {
                throw (RuntimeException)httprequestwrapper;
            }
            if (httprequestwrapper instanceof HttpException)
            {
                throw (HttpException)httprequestwrapper;
            }
            if (httprequestwrapper instanceof IOException)
            {
                throw (IOException)httprequestwrapper;
            } else
            {
                throw new UndeclaredThrowableException(httprequestwrapper);
            }
        }
        if (connectionBackoffStrategy.shouldBackoff(httprequestwrapper))
        {
            backoffManager.backOff(httproute);
            return httprequestwrapper;
        } else
        {
            backoffManager.probe(httproute);
            return httprequestwrapper;
        }
    }
}
