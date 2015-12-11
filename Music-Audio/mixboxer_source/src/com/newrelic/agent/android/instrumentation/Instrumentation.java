// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.instrumentation.httpclient.ResponseHandlerImpl;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            TransactionStateUtil, TransactionState, HttpsURLConnectionExtension, HttpURLConnectionExtension

public final class Instrumentation
{

    private Instrumentation()
    {
    }

    private static HttpRequest _(HttpHost httphost, HttpRequest httprequest, TransactionState transactionstate)
    {
        return TransactionStateUtil.inspectAndInstrument(transactionstate, httphost, httprequest);
    }

    private static HttpResponse _(HttpResponse httpresponse, TransactionState transactionstate)
    {
        return TransactionStateUtil.inspectAndInstrument(transactionstate, httpresponse);
    }

    private static ResponseHandler _(ResponseHandler responsehandler, TransactionState transactionstate)
    {
        return ResponseHandlerImpl.wrap(responsehandler, transactionstate);
    }

    private static HttpUriRequest _(HttpUriRequest httpurirequest, TransactionState transactionstate)
    {
        return TransactionStateUtil.inspectAndInstrument(transactionstate, httpurirequest);
    }

    public static Object execute(HttpClient httpclient, HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = ((HttpClient) (httpclient.execute(httphost, _(httphost, httprequest, transactionstate), _(responsehandler, transactionstate))));
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    public static Object execute(HttpClient httpclient, HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = ((HttpClient) (httpclient.execute(httphost, _(httphost, httprequest, transactionstate), _(responsehandler, transactionstate), httpcontext)));
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    public static Object execute(HttpClient httpclient, HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = ((HttpClient) (httpclient.execute(_(httpurirequest, transactionstate), _(responsehandler, transactionstate))));
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    public static Object execute(HttpClient httpclient, HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = ((HttpClient) (httpclient.execute(_(httpurirequest, transactionstate), _(responsehandler, transactionstate), httpcontext)));
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    public static HttpResponse execute(HttpClient httpclient, HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = _(httpclient.execute(httphost, _(httphost, httprequest, transactionstate)), transactionstate);
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    public static HttpResponse execute(HttpClient httpclient, HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = _(httpclient.execute(httphost, _(httphost, httprequest, transactionstate), httpcontext), transactionstate);
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    public static HttpResponse execute(HttpClient httpclient, HttpUriRequest httpurirequest)
        throws IOException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = _(httpclient.execute(_(httpurirequest, transactionstate)), transactionstate);
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    public static HttpResponse execute(HttpClient httpclient, HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException
    {
        TransactionState transactionstate = new TransactionState();
        try
        {
            httpclient = _(httpclient.execute(_(httpurirequest, transactionstate), httpcontext), transactionstate);
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpClientError(transactionstate, httpclient);
            throw httpclient;
        }
        return httpclient;
    }

    private static void httpClientError(TransactionState transactionstate, Exception exception)
    {
        if (!transactionstate.isComplete())
        {
            TransactionStateUtil.setErrorCodeFromException(transactionstate, exception);
            Agent.addTransactionData(transactionstate.end());
        }
    }

    public static URLConnection openConnection(URLConnection urlconnection)
    {
        Object obj;
        if (urlconnection instanceof HttpsURLConnection)
        {
            obj = new HttpsURLConnectionExtension((HttpsURLConnection)urlconnection);
        } else
        {
            obj = urlconnection;
            if (urlconnection instanceof HttpURLConnection)
            {
                return new HttpURLConnectionExtension((HttpURLConnection)urlconnection);
            }
        }
        return ((URLConnection) (obj));
    }

    public static URLConnection openConnectionWithProxy(URLConnection urlconnection)
    {
        Object obj;
        if (urlconnection instanceof HttpsURLConnection)
        {
            obj = new HttpsURLConnectionExtension((HttpsURLConnection)urlconnection);
        } else
        {
            obj = urlconnection;
            if (urlconnection instanceof HttpURLConnection)
            {
                return new HttpURLConnectionExtension((HttpURLConnection)urlconnection);
            }
        }
        return ((URLConnection) (obj));
    }
}
