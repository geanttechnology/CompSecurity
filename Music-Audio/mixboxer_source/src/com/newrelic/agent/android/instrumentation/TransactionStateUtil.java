// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.api.common.ErrorData;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.httpclient.ContentBufferingResponseEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.HttpRequestEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.HttpResponseEntityImpl;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            TransactionState

public class TransactionStateUtil
{

    public static final String APP_DATA_HEADER = "X-NewRelic-App-Data";
    private static final String CONTENT_LENGTH_HEADER = "Content-Length";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CROSS_PROCESS_ID_HEADER = "X-NewRelic-ID";
    public static final int NSURLErrorBadServerResponse = -1011;
    public static final int NSURLErrorBadURL = -1000;
    public static final int NSURLErrorCannotConnectToHost = -1004;
    public static final int NSURLErrorDNSLookupFailed = -1006;
    public static final int NSURLErrorSecureConnectionFailed = -1200;
    public static final int NSURLErrorTimedOut = -1001;
    public static final int NSURLErrorUnknown = -1;
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public TransactionStateUtil()
    {
    }

    private static void addCrossProcessIdHeader(HttpRequest httprequest)
    {
        String s = Agent.getCrossProcessId();
        if (s != null)
        {
            httprequest.setHeader("X-NewRelic-ID", s);
        }
    }

    private static void addTransactionAndErrorData(TransactionState transactionstate, HttpResponse httpresponse)
    {
        TransactionData transactiondata = transactionstate.end();
        if (transactiondata != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Agent.addTransactionData(transactiondata);
        if ((long)transactionstate.getStatusCode() < 400L) goto _L1; else goto _L3
_L3:
        StringBuilder stringbuilder = new StringBuilder();
        java.io.InputStream inputstream;
        if (!(httpresponse.getEntity() instanceof HttpRequestEntityImpl))
        {
            httpresponse.setEntity(new ContentBufferingResponseEntityImpl(httpresponse.getEntity()));
        }
        inputstream = httpresponse.getEntity().getContent();
        if (!(inputstream instanceof CountingInputStream)) goto _L5; else goto _L4
_L4:
        stringbuilder.append(((CountingInputStream)inputstream).getBufferAsString());
_L7:
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        TreeMap treemap = null;
        httpresponse = treemap;
        if (aheader != null)
        {
            httpresponse = treemap;
            if (aheader.length > 0)
            {
                httpresponse = treemap;
                if (!"".equals(aheader[0].getValue()))
                {
                    httpresponse = aheader[0].getValue();
                }
            }
        }
        treemap = new TreeMap();
        if (httpresponse != null && httpresponse.length() > 0)
        {
            treemap.put("content_type", httpresponse);
        }
        treemap.put("content_length", Long.valueOf(transactionstate.getBytesReceived()));
        Agent.addErrorData(new ErrorData(transactiondata.getUrl(), transactiondata.getStatusCode(), stringbuilder.toString(), treemap));
        return;
_L5:
        try
        {
            log.error("Unable to wrap content stream for entity");
        }
        catch (IllegalStateException illegalstateexception)
        {
            log.error(illegalstateexception.toString());
        }
        catch (IOException ioexception)
        {
            log.error(ioexception.toString());
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static HttpRequest inspectAndInstrument(TransactionState transactionstate, HttpHost httphost, HttpRequest httprequest)
    {
        addCrossProcessIdHeader(httprequest);
        RequestLine requestline = httprequest.getRequestLine();
        if (requestline != null)
        {
            String s1 = requestline.getUri();
            boolean flag;
            if (s1 != null && s1.substring(0, 10).indexOf("://") >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && s1 != null && httphost != null)
            {
                String s = httphost.toURI().toString();
                StringBuilder stringbuilder = (new StringBuilder()).append(s);
                if (s.endsWith("/") || s1.startsWith("/"))
                {
                    s = "";
                } else
                {
                    s = "/";
                }
                transactionstate.setUrl(stringbuilder.append(s).append(s1).toString());
            } else
            if (flag)
            {
                transactionstate.setUrl(s1);
            }
        }
        if (transactionstate.getUrl() == null)
        {
            try
            {
                throw new Exception("TransactionData constructor was not provided with a valid URL or host");
            }
            // Misplaced declaration of an exception variable
            catch (TransactionState transactionstate)
            {
                AgentLogManager.getAgentLog().error(MessageFormat.format("TransactionStateUtil.inspectAndInstrument(...) for {0} could not determine request URL [host={1}, requestLine={2}]", new Object[] {
                    httprequest.getClass().getCanonicalName(), httphost, requestline
                }), transactionstate);
            }
            return httprequest;
        } else
        {
            transactionstate.setCarrier(Agent.getActiveNetworkCarrier());
            wrapRequestEntity(transactionstate, httprequest);
            return httprequest;
        }
    }

    public static HttpResponse inspectAndInstrument(TransactionState transactionstate, HttpResponse httpresponse)
    {
        transactionstate.setStatusCode(httpresponse.getStatusLine().getStatusCode());
        Header aheader[] = httpresponse.getHeaders("X-NewRelic-App-Data");
        if (aheader != null && aheader.length > 0 && !"".equals(aheader[0].getValue()))
        {
            transactionstate.setAppData(aheader[0].getValue());
        }
        aheader = httpresponse.getHeaders("Content-Length");
        if (aheader != null && aheader.length > 0)
        {
            try
            {
                transactionstate.setBytesReceived(Long.parseLong(aheader[0].getValue()));
                addTransactionAndErrorData(transactionstate, httpresponse);
            }
            // Misplaced declaration of an exception variable
            catch (TransactionState transactionstate)
            {
                log.warning((new StringBuilder()).append("Failed to parse content length: ").append(transactionstate.toString()).toString());
                return httpresponse;
            }
            return httpresponse;
        }
        if (httpresponse.getEntity() != null)
        {
            httpresponse.setEntity(new HttpResponseEntityImpl(httpresponse.getEntity(), transactionstate, -1L));
            return httpresponse;
        } else
        {
            transactionstate.setBytesReceived(0L);
            addTransactionAndErrorData(transactionstate, null);
            return httpresponse;
        }
    }

    public static HttpUriRequest inspectAndInstrument(TransactionState transactionstate, HttpUriRequest httpurirequest)
    {
        addCrossProcessIdHeader(httpurirequest);
        transactionstate.setUrl(httpurirequest.getURI().toString());
        transactionstate.setCarrier(Agent.getActiveNetworkCarrier());
        wrapRequestEntity(transactionstate, httpurirequest);
        return httpurirequest;
    }

    public static void inspectAndInstrument(TransactionState transactionstate, HttpURLConnection httpurlconnection)
    {
        transactionstate.setUrl(httpurlconnection.getURL().toString());
        transactionstate.setCarrier(Agent.getActiveNetworkCarrier());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionstate, HttpURLConnection httpurlconnection)
    {
        int i;
        String s = httpurlconnection.getHeaderField("X-NewRelic-App-Data");
        if (s != null && !"".equals(s))
        {
            transactionstate.setAppData(s);
        }
        i = httpurlconnection.getContentLength();
        if (i >= 0)
        {
            transactionstate.setBytesReceived(i);
        }
        i = 0;
        int j = httpurlconnection.getResponseCode();
        i = j;
_L2:
        transactionstate.setStatusCode(i);
        return;
        httpurlconnection;
        log.error("Failed to retrieve response code due to an I/O exception", httpurlconnection);
        continue; /* Loop/switch isn't completed */
        httpurlconnection;
        log.error("Failed to retrieve response code due to underlying (Harmony?) NPE", httpurlconnection);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void setCrossProcessHeader(HttpURLConnection httpurlconnection)
    {
        String s = Agent.getCrossProcessId();
        if (s != null)
        {
            httpurlconnection.setRequestProperty("X-NewRelic-ID".toLowerCase(Locale.ENGLISH), s);
        }
    }

    public static void setErrorCodeFromException(TransactionState transactionstate, Exception exception)
    {
        if (exception instanceof UnknownHostException)
        {
            transactionstate.setErrorCode(-1006);
            return;
        }
        if ((exception instanceof SocketTimeoutException) || (exception instanceof ConnectTimeoutException))
        {
            transactionstate.setErrorCode(-1001);
            return;
        }
        if (exception instanceof ConnectException)
        {
            transactionstate.setErrorCode(-1004);
            return;
        }
        if (exception instanceof MalformedURLException)
        {
            transactionstate.setErrorCode(-1000);
            return;
        }
        if (exception instanceof SSLException)
        {
            transactionstate.setErrorCode(-1200);
            return;
        }
        if (exception instanceof HttpResponseException)
        {
            transactionstate.setStatusCode(((HttpResponseException)exception).getStatusCode());
            return;
        }
        if (exception instanceof ClientProtocolException)
        {
            transactionstate.setErrorCode(-1011);
            return;
        } else
        {
            transactionstate.setErrorCode(-1);
            return;
        }
    }

    private static void wrapRequestEntity(TransactionState transactionstate, HttpRequest httprequest)
    {
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            httprequest = (HttpEntityEnclosingRequest)httprequest;
            if (httprequest.getEntity() != null)
            {
                httprequest.setEntity(new HttpRequestEntityImpl(httprequest.getEntity(), transactionstate));
            }
        }
    }

}
