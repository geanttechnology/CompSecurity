// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import com.appnexus.opensdk.b.a;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.j;
import com.appnexus.opensdk.b.o;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.HttpHostConnectException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.appnexus.opensdk:
//            ar, h, ap, as, 
//            aq

final class g extends AsyncTask
{

    private static final ar b = new ar();
    private WeakReference a;

    public g(h h1)
    {
        a = new WeakReference(h1);
        h1 = h1.b();
        if (h1 == null) goto _L2; else goto _L1
_L1:
        Object obj;
        com.appnexus.opensdk.b.a.a(((ap) (h1)).m);
        obj = ((ap) (h1)).m;
        if (com.appnexus.opensdk.as.a == null)
        {
            com.appnexus.opensdk.as.a = new as(((Context) (obj)));
        }
        obj = com.appnexus.opensdk.as.a;
        h1 = ((ap) (h1)).m;
        if (!((as) (obj)).b) goto _L4; else goto _L3
_L3:
        h1 = ((ConnectivityManager)h1.getSystemService("connectivity")).getActiveNetworkInfo();
        if (h1 != null && h1.isConnected()) goto _L4; else goto _L5
_L5:
        boolean flag = false;
_L6:
        if (!flag)
        {
            a(aq.e);
            cancel(true);
        }
        return;
_L4:
        flag = true;
        if (true) goto _L6; else goto _L2
_L2:
        a(aq.f);
        cancel(true);
        return;
    }

    private transient ar a()
    {
        Object obj = (h)a.get();
        if (obj == null) goto _L2; else goto _L1
_L1:
        obj = ((h) (obj)).b();
        if (obj == null) goto _L2; else goto _L3
_L3:
        Object obj2;
        Object obj3;
        StatusLine statusline;
        obj3 = ((ap) (obj)).h();
        com.appnexus.opensdk.b.b.a(((String) (obj3)));
        com.appnexus.opensdk.b.b.b(b.e, com.appnexus.opensdk.b.b.a(an.d.fetch_url, ((String) (obj3))));
        obj2 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj2)), 15000);
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj2)), 20000);
        HttpConnectionParams.setSocketBufferSize(((org.apache.http.params.HttpParams) (obj2)), 8192);
        obj2 = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj2)));
        obj3 = new HttpGet(((String) (obj3)));
        ((HttpGet) (obj3)).setHeader("User-Agent", j.a().j);
        obj3 = ((DefaultHttpClient) (obj2)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj3)));
        statusline = ((HttpResponse) (obj3)).getStatusLine();
        if (statusline != null) goto _L5; else goto _L4
_L4:
        int i = 0;
_L11:
        if (i != 0) goto _L7; else goto _L6
_L6:
        return b;
_L5:
        i = statusline.getStatusCode();
        i;
        JVM INSTR tableswitch 200 200: default 385
    //                   200 388;
           goto _L8 _L9
_L8:
        com.appnexus.opensdk.b.b.b(b.f, com.appnexus.opensdk.b.b.a(an.d.http_bad_status, i));
        i = 0;
        continue; /* Loop/switch isn't completed */
_L7:
        String s = EntityUtils.toString(((HttpResponse) (obj3)).getEntity());
        o.a(((DefaultHttpClient) (obj2)).getCookieStore().getCookies());
        if (s.equals(""))
        {
            com.appnexus.opensdk.b.b.e(b.f, com.appnexus.opensdk.b.b.a(an.d.response_blank));
        }
        obj = new ar(s, ((HttpResponse) (obj3)).getAllHeaders(), ((ap) (obj)).a);
        return ((ar) (obj));
        Object obj1;
        obj1;
        com.appnexus.opensdk.b.b.e(b.e, com.appnexus.opensdk.b.b.a(an.d.http_unknown));
_L2:
        return null;
        obj1;
        com.appnexus.opensdk.b.b.e(b.e, com.appnexus.opensdk.b.b.a(an.d.http_timeout));
          goto _L2
        obj1;
        com.appnexus.opensdk.b.b.e(b.e, com.appnexus.opensdk.b.b.a(an.d.http_unreachable, ((HttpHostConnectException) (obj1)).getHost().getHostName(), ((HttpHostConnectException) (obj1)).getHost().getPort()));
          goto _L2
        obj1;
        com.appnexus.opensdk.b.b.e(b.e, com.appnexus.opensdk.b.b.a(an.d.http_io));
          goto _L2
        obj1;
        com.appnexus.opensdk.b.b.e(b.e, com.appnexus.opensdk.b.b.a(an.d.permissions_internet));
          goto _L2
        obj1;
        com.appnexus.opensdk.b.b.e(b.e, com.appnexus.opensdk.b.b.a(an.d.http_unknown));
          goto _L2
        obj1;
        ((Exception) (obj1)).printStackTrace();
        com.appnexus.opensdk.b.b.e(b.e, com.appnexus.opensdk.b.b.a(an.d.unknown_exception));
          goto _L2
_L9:
        i = 1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void a(aq aq1)
    {
        h h1 = (h)a.get();
        if (h1 != null)
        {
            h1.a(aq1);
        }
        com.appnexus.opensdk.b.b.a();
    }

    protected final Object doInBackground(Object aobj[])
    {
        return a();
    }

    protected final void onCancelled(Object obj)
    {
        super.onCancelled((ar)obj);
        com.appnexus.opensdk.b.b.d(b.f, com.appnexus.opensdk.b.b.a(an.d.cancel_request));
    }

    protected final void onPostExecute(Object obj)
    {
        obj = (ar)obj;
        if (obj == null)
        {
            com.appnexus.opensdk.b.b.a(b.f, com.appnexus.opensdk.b.b.a(an.d.no_response));
            a(aq.e);
        } else
        {
            if (((ar) (obj)).g)
            {
                a(aq.e);
                return;
            }
            h h1 = (h)a.get();
            if (h1 != null)
            {
                if (h1.b() != null)
                {
                    ((ar) (obj)).a("ORIENTATION", h1.b().r);
                }
                h1.a(((ar) (obj)));
                return;
            }
        }
    }

}
