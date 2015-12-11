// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.util.Pair;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            TimeHelper, InvalidArgumentException, SingularLog

class EventReporter
{

    private final SingularLog log;
    private final TimeHelper time_helper;

    public EventReporter(SingularLog singularlog, TimeHelper timehelper)
    {
        time_helper = timehelper;
        log = singularlog;
    }

    private JSONObject getBasicJsonObject(JSONObject jsonobject)
        throws JSONException
    {
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        jsonobject = JSONObjectInstrumentation.init(jsonobject);
        jsonobject.put("send_timestamp_s", time_helper.currentTimeSeconds());
        return jsonobject;
    }

    private Pair sendJsonObject(String s, JSONObject jsonobject)
        throws InvalidArgumentException
    {
        Object obj = new HttpPost(s);
        if (jsonobject instanceof JSONObject) goto _L2; else goto _L1
_L1:
        s = jsonobject.toString();
_L5:
        s = new ByteArrayEntity(s.getBytes("UTF8"));
        DefaultHttpClient defaulthttpclient;
        ((HttpPost) (obj)).setEntity(s);
        ((HttpPost) (obj)).setHeader("Accept", "application/json");
        ((HttpPost) (obj)).setHeader("Content-type", "application/json");
        s = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(s, 30000);
        HttpConnectionParams.setSoTimeout(s, 60000);
        defaulthttpclient = new DefaultHttpClient(s);
        if (defaulthttpclient instanceof HttpClient) goto _L4; else goto _L3
_L3:
        s = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
_L6:
        int i;
        int j;
        obj = EntityUtils.toString(s.getEntity());
        i = s.getStatusLine().getStatusCode();
        jsonobject = new JSONObject();
        j = ((String) (obj)).length();
        s = jsonobject;
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_158;
        }
        s = JSONObjectInstrumentation.init(((String) (obj)));
_L7:
        s = Pair.create(Integer.valueOf(i), s);
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
        return s;
_L2:
        try
        {
            s = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InvalidArgumentException("Invalid JSON in EventReporter", s);
        }
          goto _L5
_L4:
        s = HttpInstrumentation.execute((HttpClient)defaulthttpclient, ((org.apache.http.client.methods.HttpUriRequest) (obj)));
          goto _L6
        s;
        log.d("singular_sdk", "Invalid JSON response", s);
        s = jsonobject;
          goto _L7
        s;
        log.d("singular_sdk", "HttpHostConnectException in EventReporter", s);
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
_L9:
        return null;
        s;
        log.d("singular_sdk", "UnknownHostException in EventReporter", s);
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
        continue; /* Loop/switch isn't completed */
        s;
        log.e("singular_sdk", "ClientProtocolException in EventReporter", s);
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
        continue; /* Loop/switch isn't completed */
        s;
        log.e("singular_sdk", "IOException in EventReporter", s);
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
        continue; /* Loop/switch isn't completed */
        s;
        log.e("singular_sdk", "AssertionError in EventReporter", s);
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
        if (true) goto _L9; else goto _L8
_L8:
        s;
        if (defaulthttpclient.getConnectionManager() != null)
        {
            defaulthttpclient.getConnectionManager().shutdown();
        }
        throw s;
          goto _L5
    }

    public Pair sendPostEventsRequest(JSONObject jsonobject, JSONArray jsonarray)
        throws InvalidArgumentException
    {
        this;
        JVM INSTR monitorenter ;
        jsonobject = getBasicJsonObject(jsonobject);
        jsonobject.put("events", jsonarray);
        jsonobject = sendJsonObject("https://t.singular.net/v2/events", jsonobject);
        this;
        JVM INSTR monitorexit ;
        return jsonobject;
        jsonobject;
        throw new InvalidArgumentException("Invalid JSON in sendPostEventsRequest", jsonobject);
        jsonobject;
        this;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }

    public Pair sendVerboseLogsRequest(JSONObject jsonobject, JSONArray jsonarray)
        throws InvalidArgumentException
    {
        this;
        JVM INSTR monitorenter ;
        jsonobject = getBasicJsonObject(jsonobject);
        jsonobject.put("lines", jsonarray);
        jsonobject = sendJsonObject("https://t.singular.net/v2/logs", jsonobject);
        this;
        JVM INSTR monitorexit ;
        return jsonobject;
        jsonobject;
        throw new InvalidArgumentException("Invalid JSON in sendVerboseLogsRequest", jsonobject);
        jsonobject;
        this;
        JVM INSTR monitorexit ;
        throw jsonobject;
    }
}
