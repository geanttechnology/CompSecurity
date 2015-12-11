// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.b;

import android.os.AsyncTask;
import android.webkit.CookieManager;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.appnexus.opensdk.b:
//            e, b, j, g

public abstract class d extends AsyncTask
{

    public d()
    {
    }

    private transient e b()
    {
        DefaultHttpClient defaulthttpclient;
        e e1;
        boolean flag1;
        flag1 = false;
        e1 = new e();
        defaulthttpclient = new DefaultHttpClient();
        Object obj;
        obj = new URI(a());
        if (((URI) (obj)).getHost() != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        com.appnexus.opensdk.b.b.a(b.e, "An HTTP request with an invalid URL was attempted.", new IllegalStateException("An HTTP request with an invalid URL was attempted."));
        e1.a = false;
        defaulthttpclient.getConnectionManager().shutdown();
        return e1;
        HttpGet httpget;
        httpget = new HttpGet();
        httpget.setHeader("User-Agent", j.a().j);
        httpget.setURI(((URI) (obj)));
        obj = CookieManager.getInstance();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        com.appnexus.opensdk.b.b.c(b.f, "Unable to find a CookieManager");
        obj = null;
_L1:
        httpget.addHeader("Cookie", ((String) (obj)));
        obj = defaulthttpclient.execute(httpget);
        e1.c = ((HttpResponse) (obj)).getAllHeaders();
        e1.b = EntityUtils.toString(((HttpResponse) (obj)).getEntity());
        boolean flag = flag1;
        if (((HttpResponse) (obj)).getStatusLine() == null)
        {
            break MISSING_BLOCK_LABEL_196;
        }
        flag = flag1;
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() == 200)
        {
            flag = true;
        }
        e1.a = flag;
        defaulthttpclient.getConnectionManager().shutdown();
        return e1;
        obj = ((CookieManager) (obj)).getCookie(j.y);
          goto _L1
        Object obj1;
        obj1;
        e1.a = false;
        e1.d = g.b;
        defaulthttpclient.getConnectionManager().shutdown();
        return e1;
        obj1;
        e1.a = false;
        e1.d = g.d;
        defaulthttpclient.getConnectionManager().shutdown();
        return e1;
        obj1;
        e1.a = false;
        e1.d = g.a;
        defaulthttpclient.getConnectionManager().shutdown();
        return e1;
        obj1;
        e1.a = false;
        e1.d = g.a;
        defaulthttpclient.getConnectionManager().shutdown();
        return e1;
        obj1;
        e1.a = false;
        e1.d = g.e;
        defaulthttpclient.getConnectionManager().shutdown();
        return e1;
        obj1;
        defaulthttpclient.getConnectionManager().shutdown();
        throw obj1;
    }

    public abstract String a();

    public abstract void a(e e1);

    protected Object doInBackground(Object aobj[])
    {
        return b();
    }

    protected volatile void onCancelled(Object obj)
    {
        super.onCancelled(null);
    }

    public void onPostExecute(Object obj)
    {
        a((e)obj);
    }
}
