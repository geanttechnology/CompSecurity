// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.transport.http;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.transport.DisableAgentException;
import com.newrelic.agent.android.transport.DisconnectAgentException;
import com.newrelic.agent.android.transport.FlushTransactionDataException;
import com.newrelic.agent.android.transport.Transport;
import com.newrelic.agent.android.transport.TransportException;
import com.newrelic.agent.android.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import javax.net.ssl.SSLException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpJsonTransport
    implements Transport
{

    private static final int BUFFER_SIZE = 8192;
    public static final String CONNECT_TIME_HEADER = "X-NewRelic-Connect-Time";
    private static final String KILL_STRING = "DISABLE_NEW_RELIC";
    public static final String LICENSE_KEY_HEADER = "X-App-License-Key";
    private static final int TIMEOUT_IN_SECONDS = 20;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final HttpClient client;
    private final String endpoint;
    private final String licenseKey;

    public HttpJsonTransport(String s, String s1)
    {
        endpoint = s;
        licenseKey = s1;
        s = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(s, (int)TimeUnit.MILLISECONDS.convert(20L, TimeUnit.SECONDS));
        HttpConnectionParams.setSoTimeout(s, (int)TimeUnit.MILLISECONDS.convert(20L, TimeUnit.SECONDS));
        HttpConnectionParams.setTcpNoDelay(s, true);
        HttpConnectionParams.setSocketBufferSize(s, 8192);
        client = new DefaultHttpClient(s);
    }

    private byte[] deflate(String s)
        throws TransportException
    {
        Deflater deflater = new Deflater();
        deflater.setInput(s.getBytes());
        deflater.finish();
        s = new ByteArrayOutputStream();
        byte abyte0[] = new byte[8192];
        int i;
        for (; !deflater.finished(); s.write(abyte0, 0, i))
        {
            i = deflater.deflate(abyte0);
            if (i <= 0)
            {
                throw new TransportException("HTTP request contains an incomplete payload");
            }
        }

        deflater.end();
        return s.toByteArray();
    }

    private String getMessageEndpoint(com.newrelic.agent.android.transport.Transport.MessageType messagetype)
    {
        return MessageFormat.format("{0}/{1}", new Object[] {
            endpoint, messagetype.name().toLowerCase()
        });
    }

    private void recordCollectorError(int i)
    {
        StatsEngine.get().inc((new StringBuilder()).append("Supportability/MobileAgent/Collector/ResponseErrorCodes/").append(i).toString());
    }

    public String send(com.newrelic.agent.android.transport.Transport.MessageType messagetype, String s, long l)
        throws InterruptedIOException, DisableAgentException, DisconnectAgentException, FlushTransactionDataException, TransportException
    {
        String s1;
        TicToc tictoc;
        HttpPost httppost;
        if (s.length() <= 512)
        {
            s1 = "identity";
        } else
        {
            s1 = "deflate";
        }
        tictoc = new TicToc();
        tictoc.tic();
        httppost = new HttpPost(getMessageEndpoint(messagetype));
        httppost.addHeader("Content-Type", "application/json");
        httppost.addHeader("Content-Encoding", s1);
        httppost.addHeader("X-App-License-Key", licenseKey);
        httppost.addHeader("User-Agent", System.getProperty("http.agent"));
        if (l != 0L)
        {
            httppost.addHeader("X-NewRelic-Connect-Time", Long.valueOf(l).toString());
        }
        if ("deflate".equals(s1))
        {
            httppost.setEntity(new ByteArrayEntity(deflate(s)));
        } else
        {
            try
            {
                httppost.setEntity(new StringEntity(s, "utf-8"));
            }
            // Misplaced declaration of an exception variable
            catch (com.newrelic.agent.android.transport.Transport.MessageType messagetype)
            {
                log.error("UTF-8 is unsupported");
                throw new TransportException(messagetype);
            }
        }
        try
        {
            s = client.execute(httppost);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error((new StringBuilder()).append("HTTP protocol error during ").append(messagetype.name().toLowerCase()).toString());
            recordCollectorError(-1011);
            throw new TransportException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            if (s instanceof UnknownHostException)
            {
                recordCollectorError(-1006);
            } else
            if (s instanceof SocketTimeoutException)
            {
                recordCollectorError(-1001);
            } else
            if (s instanceof ConnectTimeoutException)
            {
                recordCollectorError(-1001);
            } else
            if (s instanceof ConnectException)
            {
                recordCollectorError(-1004);
            } else
            if (s instanceof MalformedURLException)
            {
                recordCollectorError(-1000);
            } else
            if (s instanceof SSLException)
            {
                recordCollectorError(-1200);
            } else
            {
                recordCollectorError(-1);
            }
            if (s.getClass() == java/io/InterruptedIOException)
            {
                log.warning("Interrupted during an I/O operation");
                throw (InterruptedIOException)s;
            } else
            {
                log.warning((new StringBuilder()).append("I/O error during ").append(messagetype.name().toLowerCase()).toString());
                throw new TransportException(s);
            }
        }
        if (s.getStatusLine().getStatusCode() < 400)
        {
            StatsEngine.reset();
        }
        StatsEngine.get().recordTimeMs((new StringBuilder()).append("Supportability/MobileAgent/Collector/ResponseStatusCodes/").append(s.getStatusLine().getStatusCode()).toString(), tictoc.toc());
        if (s.getStatusLine().getStatusCode() >= 400)
        {
            break MISSING_BLOCK_LABEL_572;
        }
        s = s.getEntity().getContent();
        s1 = Util.slurp(s);
        s.close();
        return s1;
        Exception exception;
        exception;
        try
        {
            s.close();
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.warning((new StringBuilder()).append("Failed to read JSON response during ").append(messagetype.name().toLowerCase()).toString());
        }
        throw new TransportException(s);
        switch (s.getStatusLine().getStatusCode())
        {
        default:
            throw new TransportException(s.getStatusLine().getStatusCode(), (new StringBuilder()).append(messagetype.name().toLowerCase()).append(" failed with status code ").append(s.getStatusLine().getStatusCode()).toString());

        case 401: 
        case 450: 
            throw new DisconnectAgentException();

        case 403: 
            try
            {
                messagetype = Util.slurp(s.getEntity().getContent()).trim();
            }
            // Misplaced declaration of an exception variable
            catch (com.newrelic.agent.android.transport.Transport.MessageType messagetype)
            {
                throw new TransportException(messagetype);
            }
            if (messagetype.equals("DISABLE_NEW_RELIC"))
            {
                throw new DisableAgentException();
            } else
            {
                throw new TransportException("Unexpected HTTP 403 from the collector");
            }

        case 413: 
        case 415: 
            throw new FlushTransactionDataException();
        }
    }

}
