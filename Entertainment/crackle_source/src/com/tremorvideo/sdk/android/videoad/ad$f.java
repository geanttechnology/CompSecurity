// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;
import java.net.URLEncoder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            ad, at

static class ient extends AsyncTask
{

    String a;

    protected transient String a(String as[])
    {
        Object obj;
        DefaultHttpClient defaulthttpclient;
        at at1;
        try
        {
            a = null;
            as = new BasicHttpParams();
            as.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
            HttpConnectionParams.setConnectionTimeout(as, 8000);
            HttpConnectionParams.setSoTimeout(as, 8000);
            HttpConnectionParams.setTcpNoDelay(as, true);
            defaulthttpclient = new DefaultHttpClient(as);
            at1 = at.a();
            as = ad.j();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            ad.d((new StringBuilder()).append("Exception pre config:").append(as).toString());
            return null;
        }
        if (as == null)
        {
            as = "";
        }
        if (ad.O() != null) goto _L2; else goto _L1
_L1:
        obj = "http://config.tremorhub.com/config";
_L4:
        obj = new StringBuilder(((String) (obj)));
        ((StringBuilder) (obj)).append("?cch=");
        ((StringBuilder) (obj)).append(ad.o());
        ((StringBuilder) (obj)).append("&v=");
        ((StringBuilder) (obj)).append(at1.a);
        ((StringBuilder) (obj)).append("&a=");
        ((StringBuilder) (obj)).append(ad.i());
        ((StringBuilder) (obj)).append("&av=");
        ((StringBuilder) (obj)).append(URLEncoder.encode(as, "UTF-8"));
        ((StringBuilder) (obj)).append("&p=android");
        ((StringBuilder) (obj)).append("&di=");
        ((StringBuilder) (obj)).append(at1.f);
        ((StringBuilder) (obj)).append("&lt=");
        ((StringBuilder) (obj)).append(at1.g);
        ((StringBuilder) (obj)).append("&dm=");
        ((StringBuilder) (obj)).append(URLEncoder.encode(at1.c, "UTF-8"));
        ((StringBuilder) (obj)).append("&nt=");
        ((StringBuilder) (obj)).append(at1.i);
        ((StringBuilder) (obj)).append("&nst=");
        ((StringBuilder) (obj)).append(at1.C);
        ((StringBuilder) (obj)).append("&osv=");
        ((StringBuilder) (obj)).append(URLEncoder.encode(at1.e, "UTF-8"));
        ((StringBuilder) (obj)).append("&mnc=");
        ((StringBuilder) (obj)).append(at1.A);
        ((StringBuilder) (obj)).append("&mcc=");
        ((StringBuilder) (obj)).append(at1.z);
        ((StringBuilder) (obj)).append("&ua=");
        ((StringBuilder) (obj)).append(URLEncoder.encode(at1.B, "UTF-8"));
        ad.d((new StringBuilder()).append("Debug: pre config URL: ").append(((StringBuilder) (obj)).toString()).toString());
        as = new HttpGet(((StringBuilder) (obj)).toString());
        as.setHeader("User-Agent", ad.x());
        a = EntityUtils.toString(defaulthttpclient.execute(as).getEntity());
        return a;
_L2:
        obj = ad.O();
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void a(String s)
    {
        try
        {
            ad.e(a);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        cancel(true);
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

    ient()
    {
    }
}
