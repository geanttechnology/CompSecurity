// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia.a;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.ad;
import java.net.URI;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia.a:
//            h

class e extends AsyncTask
{

    String a;
    final h b;
    private boolean c;
    private boolean d;
    private boolean e;

    protected transient String a(String as[])
    {
        DefaultHttpClient defaulthttpclient;
        a = null;
        BasicHttpParams basichttpparams = new BasicHttpParams();
        basichttpparams.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        defaulthttpclient = new DefaultHttpClient(basichttpparams);
        h.a(b, defaulthttpclient);
        if (!as[1].equals("POST")) goto _L2; else goto _L1
_L1:
        Object obj = as[0];
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = new HttpPost(new URI(((String) (obj))));
        ae.a(((HttpPost) (obj1)), ((String) (obj)));
        obj2 = new JSONObject(as[2]);
        obj3 = ((JSONObject) (obj2)).keys();
_L10:
        if (!((Iterator) (obj3)).hasNext()) goto _L4; else goto _L3
_L3:
        String s = (String)((Iterator) (obj3)).next();
        obj = ((JSONObject) (obj2)).getString(s);
_L5:
        if (obj != null)
        {
            try
            {
                ((HttpPost) (obj1)).addHeader(s, ((String) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                ad.a(as);
                d = true;
                e = true;
                return null;
            }
        }
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        ad.a(exception);
        exception = null;
        if (true) goto _L5; else goto _L4
_L4:
        ((HttpPost) (obj1)).setEntity(new StringEntity(as[3], "UTF-8"));
        as = defaulthttpclient.execute(((org.apache.http.client.methods.HttpUriRequest) (obj1)));
        a = EntityUtils.toString(as.getEntity());
        if (!d)
        {
            d = true;
        }
        return Integer.toString(as.getStatusLine().getStatusCode());
_L2:
        obj1 = as[0];
        exception = new HttpGet(new URI(((String) (obj1))));
        ae.a(exception, ((String) (obj1)));
        obj1 = new JSONObject(as[2]);
        obj2 = ((JSONObject) (obj1)).keys();
_L7:
        if (!((Iterator) (obj2)).hasNext())
        {
            break MISSING_BLOCK_LABEL_343;
        }
        obj3 = (String)((Iterator) (obj2)).next();
        as = ((JSONObject) (obj1)).getString(((String) (obj3)));
_L8:
        if (as == null) goto _L7; else goto _L6
_L6:
        exception.addHeader(((String) (obj3)), as);
          goto _L7
        as;
        ad.a(as);
        as = null;
          goto _L8
        as = defaulthttpclient.execute(exception);
        a = EntityUtils.toString(as.getEntity());
        if (!d)
        {
            d = true;
        }
        as = Integer.toString(as.getStatusLine().getStatusCode());
        return as;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void a()
    {
        d = true;
        c = true;
        b.a(this);
    }

    protected void a(String s)
    {
        if (!d)
        {
            d = true;
        }
        if (!isCancelled() && !c) goto _L2; else goto _L1
_L1:
        b.a(this);
        return;
_L2:
        if (s != null && Integer.parseInt(s) == 200)
        {
            b.b(a);
        } else
        if (!e)
        {
            b.c(a);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void b(String s)
    {
        if (!d)
        {
            d = true;
        }
        b.a(this);
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

    t(h h1)
    {
        b = h1;
        super();
        c = false;
        d = false;
        e = false;
    }
}
