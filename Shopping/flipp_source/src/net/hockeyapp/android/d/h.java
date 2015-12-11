// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android.d;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.hockeyapp.android.a;
import net.hockeyapp.android.e.b;
import net.hockeyapp.android.e.g;
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

public final class h extends AsyncTask
{

    public Context a;
    public ProgressDialog b;
    private Handler c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private boolean j;

    public h(Context context, String s, String s1, String s2, String s3, String s4, String s5, 
            Handler handler, boolean flag)
    {
        a = context;
        d = s;
        e = s1;
        f = s2;
        g = s3;
        h = s4;
        i = s5;
        c = handler;
        j = flag;
        if (context != null)
        {
            net.hockeyapp.android.a.a(context);
        }
    }

    private HashMap a(HttpClient httpclient)
    {
        HttpPost httppost;
        HashMap hashmap;
        httppost = null;
        hashmap = new HashMap();
        hashmap.put("type", "send");
        UrlEncodedFormEntity urlencodedformentity;
        ArrayList arraylist = new ArrayList();
        arraylist.add(new BasicNameValuePair("name", e));
        arraylist.add(new BasicNameValuePair("email", f));
        arraylist.add(new BasicNameValuePair("subject", g));
        arraylist.add(new BasicNameValuePair("text", h));
        arraylist.add(new BasicNameValuePair("bundle_identifier", a.d));
        arraylist.add(new BasicNameValuePair("bundle_short_version", a.c));
        arraylist.add(new BasicNameValuePair("bundle_version", a.b));
        arraylist.add(new BasicNameValuePair("os_version", a.e));
        arraylist.add(new BasicNameValuePair("oem", a.g));
        arraylist.add(new BasicNameValuePair("model", a.f));
        urlencodedformentity = new UrlEncodedFormEntity(arraylist, "UTF-8");
        urlencodedformentity.setContentEncoding("UTF-8");
        if (i == null) goto _L2; else goto _L1
_L1:
        HttpPut httpput;
        d = (new StringBuilder()).append(d).append(i).append("/").toString();
        httpput = new HttpPut(d);
_L8:
        if (httpput == null) goto _L4; else goto _L3
_L3:
        httpput.setEntity(urlencodedformentity);
        httpclient = httpclient.execute(httpput);
_L6:
        if (httpclient == null)
        {
            break; /* Loop/switch isn't completed */
        }
        hashmap.put("response", EntityUtils.toString(httpclient.getEntity()));
        hashmap.put("status", (new StringBuilder()).append(httpclient.getStatusLine().getStatusCode()).toString());
        return hashmap;
_L2:
        httppost = new HttpPost(d);
        httpput = null;
        continue; /* Loop/switch isn't completed */
_L4:
        httppost.setEntity(urlencodedformentity);
        httpclient = httpclient.execute(httppost);
        if (true) goto _L6; else goto _L5
        httpclient;
        httpclient.printStackTrace();
        return hashmap;
        httpclient;
        httpclient.printStackTrace();
        return hashmap;
        httpclient;
        httpclient.printStackTrace();
_L5:
        return hashmap;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private HashMap b(HttpClient httpclient)
    {
        Object obj = new StringBuilder();
        ((StringBuilder) (obj)).append((new StringBuilder()).append(d).append(net.hockeyapp.android.e.g.a(i)).toString());
        HttpGet httpget = new HttpGet(((StringBuilder) (obj)).toString());
        obj = new HashMap();
        ((HashMap) (obj)).put("type", "fetch");
        try
        {
            httpclient = httpclient.execute(httpget);
            ((HashMap) (obj)).put("response", EntityUtils.toString(httpclient.getEntity()));
            ((HashMap) (obj)).put("status", (new StringBuilder()).append(httpclient.getStatusLine().getStatusCode()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpclient.printStackTrace();
            return ((HashMap) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpclient.printStackTrace();
            return ((HashMap) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (HttpClient httpclient)
        {
            httpclient.printStackTrace();
            return ((HashMap) (obj));
        }
        return ((HashMap) (obj));
    }

    protected final Object doInBackground(Object aobj[])
    {
        aobj = b.a.a;
        if (j && i != null)
        {
            return b(((HttpClient) (aobj)));
        }
        if (!j)
        {
            return a(((HttpClient) (aobj)));
        } else
        {
            return null;
        }
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (HashMap)obj;
        if (b != null)
        {
            try
            {
                b.dismiss();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        if (c != null)
        {
            Message message = new Message();
            Bundle bundle = new Bundle();
            if (obj != null)
            {
                bundle.putString("request_type", (String)((HashMap) (obj)).get("type"));
                bundle.putString("feedback_response", (String)((HashMap) (obj)).get("response"));
                bundle.putString("feedback_status", (String)((HashMap) (obj)).get("status"));
            } else
            {
                bundle.putString("request_type", "unknown");
            }
            message.setData(bundle);
            c.sendMessage(message);
        }
    }

    protected final void onPreExecute()
    {
        String s = "Sending feedback..";
        if (j)
        {
            s = "Retrieving discussions...";
        }
        if (b == null || !b.isShowing())
        {
            b = ProgressDialog.show(a, "", s, true, false);
        }
    }
}
