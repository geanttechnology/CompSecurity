// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.HarvestErrorCodes;
import com.newrelic.agent.android.harvest.type.Harvestable;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.stats.TicToc;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.newrelic.agent.android.harvest:
//            HarvestResponse, ConnectInformation

public class HarvestConnection
    implements HarvestErrorCodes
{

    private static final String APPLICATION_TOKEN_HEADER = "X-App-License-Key";
    private static final String COLLECTOR_CONNECT_URI = "/mobile/v3/connect";
    private static final String COLLECTOR_DATA_URI = "/mobile/v3/data";
    private static final String CONNECT_TIME_HEADER = "X-NewRelic-Connect-Time";
    private static final Boolean DISABLE_COMPRESSION_FOR_DEBUGGING = Boolean.valueOf(false);
    private String applicationToken;
    private final HttpClient collectorClient;
    private String collectorHost;
    private ConnectInformation connectInformation;
    private final AgentLog log = AgentLogManager.getAgentLog();
    private long serverTimestamp;
    private boolean useSsl;

    public HarvestConnection()
    {
        int i = (int)TimeUnit.MILLISECONDS.convert(20L, TimeUnit.SECONDS);
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basichttpparams, i);
        HttpConnectionParams.setSoTimeout(basichttpparams, i);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        collectorClient = new DefaultHttpClient(basichttpparams);
    }

    private byte[] deflate(String s)
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
                log.error("HTTP request contains an incomplete payload");
            }
        }

        deflater.end();
        return s.toByteArray();
    }

    private String getCollectorConnectUri()
    {
        return getCollectorUri("/mobile/v3/connect");
    }

    private String getCollectorDataUri()
    {
        return getCollectorUri("/mobile/v3/data");
    }

    private String getCollectorUri(String s)
    {
        String s1;
        if (useSsl)
        {
            s1 = "https://";
        } else
        {
            s1 = "http://";
        }
        return (new StringBuilder()).append(s1).append(collectorHost).append(s).toString();
    }

    public static String readResponse(HttpResponse httpresponse)
        throws IOException
    {
        char ac[];
        StringBuilder stringbuilder;
        ac = new char[8192];
        stringbuilder = new StringBuilder();
        httpresponse = httpresponse.getEntity().getContent();
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(httpresponse));
_L1:
        int i = bufferedreader.read(ac);
        if (i < 0)
        {
            httpresponse.close();
            return stringbuilder.toString();
        }
        stringbuilder.append(ac, 0, i);
          goto _L1
        Exception exception;
        exception;
        httpresponse.close();
        throw exception;
    }

    private void recordCollectorError(Exception exception)
    {
        log.error((new StringBuilder()).append("HarvestConnection: Attempting to convert network exception ").append(exception.getClass().getName()).append(" to error code.").toString());
        StatsEngine.get().inc((new StringBuilder()).append("Supportability/AgentHealth/Collector/ResponseErrorCodes/").append(ExceptionHelper.exceptionToErrorCode(exception)).toString());
    }

    public HttpPost createConnectPost(String s)
    {
        return createPost(getCollectorConnectUri(), s);
    }

    public HttpPost createDataPost(String s)
    {
        return createPost(getCollectorDataUri(), s);
    }

    public HttpPost createPost(String s, String s1)
    {
        String s2;
        if (s1.length() <= 512 || DISABLE_COMPRESSION_FOR_DEBUGGING.booleanValue())
        {
            s2 = "identity";
        } else
        {
            s2 = "deflate";
        }
        s = new HttpPost(s);
        s.addHeader("Content-Type", "application/json");
        s.addHeader("Content-Encoding", s2);
        s.addHeader("User-Agent", System.getProperty("http.agent"));
        if (applicationToken == null)
        {
            log.error("Cannot create POST without an Application Token.");
            return null;
        }
        s.addHeader("X-App-License-Key", applicationToken);
        if (serverTimestamp != 0L)
        {
            s.addHeader("X-NewRelic-Connect-Time", Long.valueOf(serverTimestamp).toString());
        }
        if ("deflate".equals(s2))
        {
            s.setEntity(new ByteArrayEntity(deflate(s1)));
            return s;
        }
        try
        {
            s.setEntity(new StringEntity(s1, "utf-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("UTF-8 is unsupported");
            throw new IllegalArgumentException(s);
        }
        return s;
    }

    public ConnectInformation getConnectInformation()
    {
        return connectInformation;
    }

    public HarvestResponse send(HttpPost httppost)
    {
        HarvestResponse harvestresponse = new HarvestResponse();
        try
        {
            TicToc tictoc = new TicToc();
            tictoc.tic();
            httppost = collectorClient.execute(httppost);
            harvestresponse.setResponseTime(tictoc.toc());
        }
        // Misplaced declaration of an exception variable
        catch (HttpPost httppost)
        {
            log.error((new StringBuilder()).append("Failed to send POST to collector: ").append(httppost.getMessage()).toString());
            recordCollectorError(httppost);
            return null;
        }
        harvestresponse.setStatusCode(httppost.getStatusLine().getStatusCode());
        try
        {
            harvestresponse.setResponseBody(readResponse(httppost));
        }
        // Misplaced declaration of an exception variable
        catch (HttpPost httppost)
        {
            httppost.printStackTrace();
            log.error((new StringBuilder()).append("Failed to retrieve collector response: ").append(httppost.getMessage()).toString());
            return harvestresponse;
        }
        return harvestresponse;
    }

    public HarvestResponse sendConnect()
    {
        if (connectInformation == null)
        {
            throw new IllegalArgumentException();
        }
        Object obj = createConnectPost(connectInformation.toJsonString());
        if (obj == null)
        {
            log.error("Failed to create connect POST");
            return null;
        } else
        {
            TicToc tictoc = new TicToc();
            tictoc.tic();
            obj = send(((HttpPost) (obj)));
            StatsEngine.get().sampleTimeMs("Supportability/AgentHealth/Collector/Connect", tictoc.toc());
            return ((HarvestResponse) (obj));
        }
    }

    public HarvestResponse sendData(Harvestable harvestable)
    {
        if (harvestable == null)
        {
            throw new IllegalArgumentException();
        }
        harvestable = createDataPost(harvestable.toJsonString());
        if (harvestable == null)
        {
            log.error("Failed to create data POST");
            return null;
        } else
        {
            return send(harvestable);
        }
    }

    public void setApplicationToken(String s)
    {
        applicationToken = s;
    }

    public void setCollectorHost(String s)
    {
        collectorHost = s;
    }

    public void setConnectInformation(ConnectInformation connectinformation)
    {
        connectInformation = connectinformation;
    }

    public void setServerTimestamp(long l)
    {
        log.debug((new StringBuilder()).append("Setting server timestamp: ").append(l).toString());
        serverTimestamp = l;
    }

    public void useSsl(boolean flag)
    {
        useSsl = flag;
    }

}
