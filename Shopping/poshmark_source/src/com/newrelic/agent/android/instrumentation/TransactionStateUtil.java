// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.instrumentation.httpclient.ContentBufferingResponseEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.HttpRequestEntityImpl;
import com.newrelic.agent.android.instrumentation.httpclient.HttpResponseEntityImpl;
import com.newrelic.agent.android.instrumentation.io.CountingInputStream;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            TransactionState

public class TransactionStateUtil
    implements HarvestErrorCodes
{

    public static final String APP_DATA_HEADER = "X-NewRelic-App-Data";
    public static final String CONTENT_LENGTH_HEADER = "Content-Length";
    public static final String CONTENT_TYPE_HEADER = "Content-Type";
    public static final String CROSS_PROCESS_ID_HEADER = "X-NewRelic-ID";
    private static final AgentLog log = AgentLogManager.getAgentLog();

    public TransactionStateUtil()
    {
    }

    private static void addCrossProcessIdHeader(HttpRequest httprequest)
    {
        String s = Agent.getCrossProcessId();
        if (s != null)
        {
            TraceMachine.setCurrentTraceParam("cross_process_data", s);
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
        TaskQueue.queue(new HttpTransactionMeasurement(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), transactiondata.getErrorCode(), transactiondata.getTimestamp(), transactiondata.getTime(), transactiondata.getBytesSent(), transactiondata.getBytesReceived(), transactiondata.getAppData()));
        if ((long)transactionstate.getStatusCode() < 400L) goto _L1; else goto _L3
_L3:
        StringBuilder stringbuilder;
        TreeMap treemap;
        stringbuilder = new StringBuilder();
        treemap = new TreeMap();
        if (httpresponse == null) goto _L5; else goto _L4
_L4:
        java.io.InputStream inputstream;
        if (httpresponse.getEntity() == null)
        {
            break MISSING_BLOCK_LABEL_325;
        }
        if (!(httpresponse.getEntity() instanceof HttpRequestEntityImpl))
        {
            httpresponse.setEntity(new ContentBufferingResponseEntityImpl(httpresponse.getEntity()));
        }
        inputstream = httpresponse.getEntity().getContent();
        if (!(inputstream instanceof CountingInputStream)) goto _L7; else goto _L6
_L6:
        stringbuilder.append(((CountingInputStream)inputstream).getBufferAsString());
_L8:
        Header aheader[] = httpresponse.getHeaders("Content-Type");
        Object obj = null;
        httpresponse = obj;
        if (aheader != null)
        {
            httpresponse = obj;
            if (aheader.length > 0)
            {
                httpresponse = obj;
                if (!"".equals(aheader[0].getValue()))
                {
                    httpresponse = aheader[0].getValue();
                }
            }
        }
        if (httpresponse != null && httpresponse.length() > 0)
        {
            treemap.put("content_type", httpresponse);
        }
_L5:
        treemap.put("content_length", (new StringBuilder()).append(transactionstate.getBytesReceived()).append("").toString());
        Measurements.addHttpError(transactiondata.getUrl(), transactiondata.getHttpMethod(), transactiondata.getStatusCode(), stringbuilder.toString(), treemap);
        return;
_L7:
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
          goto _L8
        log.debug("null response entity. response-body will be reported empty");
          goto _L8
    }

    public static HttpRequest inspectAndInstrument(TransactionState transactionstate, HttpHost httphost, HttpRequest httprequest)
    {
        String s;
        RequestLine requestline;
        addCrossProcessIdHeader(httprequest);
        s = null;
        requestline = httprequest.getRequestLine();
        if (requestline == null) goto _L2; else goto _L1
_L1:
        String s1;
        boolean flag;
        s1 = requestline.getUri();
        StringBuilder stringbuilder;
        if (s1 != null && s1.length() >= 10 && s1.substring(0, 10).indexOf("://") >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag || s1 == null || httphost == null) goto _L4; else goto _L3
_L3:
        s = httphost.toURI().toString();
        stringbuilder = (new StringBuilder()).append(s);
        if (s.endsWith("/") || s1.startsWith("/"))
        {
            s = "";
        } else
        {
            s = "/";
        }
        s = stringbuilder.append(s).append(s1).toString();
_L6:
        inspectAndInstrument(transactionstate, s, requestline.getMethod());
_L2:
        if (transactionstate.getUrl() == null || transactionstate.getHttpMethod() == null)
        {
            try
            {
                throw new Exception("TransactionData constructor was not provided with a valid URL, host or HTTP method");
            }
            // Misplaced declaration of an exception variable
            catch (TransactionState transactionstate)
            {
                AgentLogManager.getAgentLog().error(MessageFormat.format("TransactionStateUtil.inspectAndInstrument(...) for {0} could not determine request URL or HTTP method [host={1}, requestLine={2}]", new Object[] {
                    httprequest.getClass().getCanonicalName(), httphost, requestline
                }), transactionstate);
            }
            return httprequest;
        } else
        {
            wrapRequestEntity(transactionstate, httprequest);
            return httprequest;
        }
_L4:
        if (flag)
        {
            s = s1;
        }
        if (true) goto _L6; else goto _L5
_L5:
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
        inspectAndInstrument(transactionstate, httpurirequest.getURI().toString(), httpurirequest.getMethod());
        wrapRequestEntity(transactionstate, httpurirequest);
        return httpurirequest;
    }

    public static void inspectAndInstrument(TransactionState transactionstate, String s, String s1)
    {
        transactionstate.setUrl(s);
        transactionstate.setHttpMethod(s1);
        transactionstate.setCarrier(Agent.getActiveNetworkCarrier());
        transactionstate.setWanType(Agent.getActiveNetworkWanType());
    }

    public static void inspectAndInstrument(TransactionState transactionstate, HttpURLConnection httpurlconnection)
    {
        inspectAndInstrument(transactionstate, httpurlconnection.getURL().toString(), httpurlconnection.getRequestMethod());
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionstate, String s, int i, int j)
    {
        if (s != null && !s.equals(""))
        {
            transactionstate.setAppData(s);
        }
        if (i >= 0)
        {
            transactionstate.setBytesReceived(i);
        }
        transactionstate.setStatusCode(j);
    }

    public static void inspectAndInstrumentResponse(TransactionState transactionstate, HttpURLConnection httpurlconnection)
    {
        String s;
        int i;
        int k;
        s = httpurlconnection.getHeaderField("X-NewRelic-App-Data");
        k = httpurlconnection.getContentLength();
        i = 0;
        int j = httpurlconnection.getResponseCode();
        i = j;
_L2:
        inspectAndInstrumentResponse(transactionstate, s, k, i);
        return;
        httpurlconnection;
        log.debug((new StringBuilder()).append("Failed to retrieve response code due to an I/O exception: ").append(httpurlconnection.getMessage()).toString());
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
        int i = ExceptionHelper.exceptionToErrorCode(exception);
        log.error((new StringBuilder()).append("TransactionStateUtil: Attempting to convert network exception ").append(exception.getClass().getName()).append(" to error code.").toString());
        transactionstate.setErrorCode(i);
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
