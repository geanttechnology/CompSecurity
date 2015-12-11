// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class e extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    final HttpParams a;
    HttpResponse b;
    public Map c;
    private final HttpClient d = new DefaultHttpClient();
    private String e;
    private boolean f;
    private Context g;

    public e(Context context)
    {
        a = d.getParams();
        e = null;
        f = false;
        g = context;
    }

    private static String a(Map map)
        throws UnsupportedEncodingException
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) 
        {
            String s1 = (String)iterator.next();
            String s = (String)map.get(s1);
            if (s == null)
            {
                s = "";
            } else
            {
                s = URLEncoder.encode(s, "UTF-8");
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('&');
            }
            stringbuilder.append(s1).append('=').append(s);
        }
        return stringbuilder.toString();
    }

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected transient String a(String as[])
    {
        as = as[0];
        HttpClient httpclient;
        HttpConnectionParams.setSoTimeout(a, 30000);
        ConnManagerParams.setTimeout(a, 30000L);
        as = new HttpPost(as);
        as.setEntity(new StringEntity(a(c)));
        Log.i("body", a(c));
        httpclient = d;
        if (httpclient instanceof HttpClient) goto _L2; else goto _L1
_L1:
        as = httpclient.execute(as);
_L3:
        b = as;
        as = b.getStatusLine();
        if (as.getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        as = new ByteArrayOutputStream();
        b.getEntity().writeTo(as);
        as.close();
        e = as.toString();
_L4:
        return e;
_L2:
        as = HttpInstrumentation.execute((HttpClient)httpclient, as);
          goto _L3
        try
        {
            Log.w("HTTP1:", as.getReasonPhrase());
            b.getEntity().getContent().close();
            throw new IOException(as.getReasonPhrase());
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("HTTP2:", as);
            e = as.getMessage();
            f = true;
            cancel(true);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("HTTP3:", as);
            e = as.getMessage();
            f = true;
            cancel(true);
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            Log.w("HTTP4:", as);
            e = as.getMessage();
            f = true;
            cancel(true);
        }
          goto _L4
    }

    protected void a(String s)
    {
        if (f)
        {
            Log.i("AppsFlyer_1.18", "Connection error");
            return;
        } else
        {
            Log.i("AppsFlyer_1.18", "Connection call succeeded");
            return;
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "e#doInBackground", null);
_L1:
        aobj = a((String[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "e#doInBackground", null);
          goto _L1
    }

    protected void onCancelled()
    {
        Log.i("AppsFlyer_1.18", "Connection cancelled");
    }

    protected void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "e#onPostExecute", null);
_L1:
        a((String)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "e#onPostExecute", null);
          goto _L1
    }

    protected void onPreExecute()
    {
    }
}
