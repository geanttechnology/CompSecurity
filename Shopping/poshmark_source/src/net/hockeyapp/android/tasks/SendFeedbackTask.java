// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.hockeyapp.android.Constants;
import net.hockeyapp.android.utils.ConnectionManager;
import net.hockeyapp.android.utils.Util;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class SendFeedbackTask extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    private Context context;
    private String email;
    private Handler handler;
    private boolean isFetchMessages;
    private String name;
    private ProgressDialog progressDialog;
    private String subject;
    private String text;
    private String token;
    private String urlString;

    public SendFeedbackTask(Context context1, String s, String s1, String s2, String s3, String s4, String s5, 
            Handler handler1, boolean flag)
    {
        context = context1;
        urlString = s;
        name = s1;
        email = s2;
        subject = s3;
        text = s4;
        token = s5;
        handler = handler1;
        isFetchMessages = flag;
        if (context1 != null)
        {
            Constants.loadFromContext(context1);
        }
    }

    private HashMap doGet(HttpClient httpclient)
    {
        Object obj;
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append((new StringBuilder()).append(urlString).append(Util.encodeParam(token)).toString());
        obj = new HttpGet(((StringBuilder) (obj)).toString());
        if (httpclient instanceof HttpClient)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        httpclient = httpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
_L1:
        HashMap hashmap;
        obj = httpclient.getEntity();
        hashmap = new HashMap();
        hashmap.put("type", "fetch");
        hashmap.put("response", EntityUtils.toString(((org.apache.http.HttpEntity) (obj))));
        hashmap.put("status", (new StringBuilder()).append("").append(httpclient.getStatusLine().getStatusCode()).toString());
        return hashmap;
        httpclient = HttpInstrumentation.execute((HttpClient)httpclient, ((org.apache.http.client.methods.HttpUriRequest) (obj)));
          goto _L1
        httpclient;
        httpclient.printStackTrace();
_L3:
        return null;
        httpclient;
        httpclient.printStackTrace();
        continue; /* Loop/switch isn't completed */
        httpclient;
        httpclient.printStackTrace();
        if (true) goto _L3; else goto _L2
_L2:
    }

    private HashMap doPostPut(HttpClient httpclient)
    {
        UrlEncodedFormEntity urlencodedformentity;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("name", name));
        arraylist.add(new BasicNameValuePair("email", email));
        arraylist.add(new BasicNameValuePair("subject", subject));
        arraylist.add(new BasicNameValuePair("text", text));
        arraylist.add(new BasicNameValuePair("bundle_identifier", Constants.APP_PACKAGE));
        arraylist.add(new BasicNameValuePair("bundle_short_version", Constants.APP_VERSION_NAME));
        arraylist.add(new BasicNameValuePair("bundle_version", Constants.APP_VERSION));
        arraylist.add(new BasicNameValuePair("os_version", Constants.ANDROID_VERSION));
        arraylist.add(new BasicNameValuePair("oem", Constants.PHONE_MANUFACTURER));
        arraylist.add(new BasicNameValuePair("model", Constants.PHONE_MODEL));
        urlencodedformentity = new UrlEncodedFormEntity(arraylist, "UTF-8");
        urlencodedformentity.setContentEncoding("UTF-8");
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (token == null) goto _L2; else goto _L1
_L1:
        urlString = (new StringBuilder()).append(urlString).append(token).append("/").toString();
        obj = new HttpPut(urlString);
_L12:
        Object obj2 = null;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((HttpPut) (obj)).setEntity(urlencodedformentity);
        if (httpclient instanceof HttpClient) goto _L6; else goto _L5
_L5:
        obj = httpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
_L8:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        httpclient = ((HttpResponse) (obj)).getEntity();
        obj1 = new HashMap();
        ((HashMap) (obj1)).put("type", "send");
        ((HashMap) (obj1)).put("response", EntityUtils.toString(httpclient));
        ((HashMap) (obj1)).put("status", (new StringBuilder()).append("").append(((HttpResponse) (obj)).getStatusLine().getStatusCode()).toString());
        return ((HashMap) (obj1));
_L2:
        obj1 = new HttpPost(urlString);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = HttpInstrumentation.execute((HttpClient)httpclient, ((org.apache.http.client.methods.HttpUriRequest) (obj)));
        continue; /* Loop/switch isn't completed */
_L4:
        obj = obj2;
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((HttpPost) (obj1)).setEntity(urlencodedformentity);
        if (!(httpclient instanceof HttpClient))
        {
            obj = httpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
            continue; /* Loop/switch isn't completed */
        }
        obj = HttpInstrumentation.execute((HttpClient)httpclient, ((org.apache.http.client.methods.HttpUriRequest) (obj1)));
        if (true) goto _L8; else goto _L7
_L7:
        return null;
        httpclient;
        httpclient.printStackTrace();
_L10:
        return null;
        httpclient;
        httpclient.printStackTrace();
        continue; /* Loop/switch isn't completed */
        httpclient;
        httpclient.printStackTrace();
        if (true) goto _L10; else goto _L9
_L9:
        if (true) goto _L12; else goto _L11
_L11:
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

    public void attach(Context context1)
    {
        context = context1;
    }

    public void detach()
    {
        context = null;
        progressDialog = null;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "SendFeedbackTask#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "SendFeedbackTask#doInBackground", null);
          goto _L1
    }

    protected transient HashMap doInBackground(Void avoid[])
    {
        avoid = ConnectionManager.getInstance().getHttpClient();
        if (isFetchMessages && token != null)
        {
            return doGet(avoid);
        }
        if (!isFetchMessages)
        {
            return doPostPut(avoid);
        } else
        {
            return null;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "SendFeedbackTask#onPostExecute", null);
_L1:
        onPostExecute((HashMap)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "SendFeedbackTask#onPostExecute", null);
          goto _L1
    }

    protected void onPostExecute(HashMap hashmap)
    {
        if (progressDialog != null)
        {
            try
            {
                progressDialog.dismiss();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if (handler != null)
        {
            Message message = new Message();
            Bundle bundle = new Bundle();
            bundle.putString("request_type", (String)hashmap.get("type"));
            bundle.putString("feedback_response", (String)hashmap.get("response"));
            bundle.putString("feedback_status", (String)hashmap.get("status"));
            message.setData(bundle);
            handler.sendMessage(message);
        }
    }

    protected void onPreExecute()
    {
        String s = "Sending feedback..";
        if (isFetchMessages)
        {
            s = "Retrieving discussions...";
        }
        if (progressDialog == null || !progressDialog.isShowing())
        {
            progressDialog = ProgressDialog.show(context, "", s, true, false);
        }
    }
}
