// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.richmedia.ae;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            bu, ad

class a extends AsyncTask
{

    final bu a;

    protected transient String a(String as[])
    {
        Object obj = null;
        Object obj1;
        Object obj2;
        try
        {
            obj2 = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(((HttpParams) (obj2)), 18000);
            HttpConnectionParams.setSoTimeout(((HttpParams) (obj2)), 18000);
            ((HttpParams) (obj2)).setBooleanParameter("http.protocol.expect-continue", false);
            ((HttpParams) (obj2)).setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
            obj1 = a.h.replace("__ZIP__", a.d).replace("__DATE__", bu.a(a));
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            ad.a("Error Sending Response: Exectuing POST", as);
            return null;
        }
        as = ((String []) (obj1));
        if (a.e.length() > 0)
        {
            as = ((String) (obj1)).replace("__ID__", a.e);
        }
        ad.d((new StringBuilder()).append("TMS Date: ").append(bu.a(a)).toString());
        ad.d((new StringBuilder()).append("TMS URL: ").append(as).toString());
        obj1 = new DefaultHttpClient(((HttpParams) (obj2)));
        obj2 = new HttpGet(as);
        ae.a(((HttpGet) (obj2)), as);
        obj1 = ((HttpClient) (obj1)).execute(((org.apache.http.client.methods.HttpUriRequest) (obj2)));
        as = obj;
        if (!isCancelled())
        {
            as = bu.a(a, ((HttpResponse) (obj1)).getEntity());
        }
        return as;
    }

    protected void a(String s)
    {
        if (!isCancelled() && a.f == this)
        {
            bu.a(a, s);
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    ient(bu bu1)
    {
        a = bu1;
        super();
    }
}
