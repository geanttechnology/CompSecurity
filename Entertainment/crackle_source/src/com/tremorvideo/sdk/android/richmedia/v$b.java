// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.videoad.ad;
import java.util.ArrayList;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            v

class c extends AsyncTask
{

    String a;
    String b;
    final v c;

    protected transient String a(String as[])
    {
        try
        {
            a = null;
            Object obj = new BasicHttpParams();
            ((HttpParams) (obj)).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj)), 10000);
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj)), 10000);
            HttpConnectionParams.setTcpNoDelay(((HttpParams) (obj)), true);
            obj = new DefaultHttpClient(((HttpParams) (obj)));
            b = as[0];
            as = new HttpPost(c.L);
            ArrayList arraylist = new ArrayList(2);
            arraylist.add(new BasicNameValuePair("email", b));
            arraylist.add(new BasicNameValuePair("movieId", c.M));
            as.setEntity(new UrlEncodedFormEntity(arraylist, "utf-8"));
            a = EntityUtils.toString(((HttpClient) (obj)).execute(as).getEntity());
            as = a;
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            ad.d((new StringBuilder()).append("Exception GoWatchit call: ").append(as).toString());
            return null;
        }
        return as;
    }

    protected void a(String s)
    {
        if (s == null) goto _L2; else goto _L1
_L1:
        if (s.length() <= 0) goto _L2; else goto _L3
_L3:
        c.a(s);
_L5:
        cancel(true);
        return;
_L2:
        try
        {
            c.O = "your email address";
            c.P = 0xff888888;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            ad.d((new StringBuilder()).append("Exception ").append(s).toString());
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void b(String s)
    {
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onCancelled(Object obj)
    {
        b((String)obj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    public rmEntity(v v1)
    {
        c = v1;
        super();
    }
}
