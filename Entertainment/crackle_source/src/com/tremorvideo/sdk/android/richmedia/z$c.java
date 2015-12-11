// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.videoad.ad;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            z, ae

class h extends AsyncTask
{

    String a;
    String b;
    String c;
    String d;
    String e;
    final String f = "http://data.tmsapi.com/v1/lineups?postalCode=__ZIP__&api_key=dn3gkyv4pzcmfcp5fakh7raz";
    final String g = "http://data.tmsapi.com/v1/stations/__STATION__?lineupId=__LINEUP__&api_key=dn3gkyv4pzcmfcp5fakh7raz";
    final z h;

    protected transient String a(String as[])
    {
        Object obj;
        a = null;
        obj = new BasicHttpParams();
        ((HttpParams) (obj)).setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
        HttpConnectionParams.setTcpNoDelay(((HttpParams) (obj)), true);
        obj = new DefaultHttpClient(((HttpParams) (obj)));
        e = as[0];
        b = as[1];
        if (!e.equals("provider")) goto _L2; else goto _L1
_L1:
        d = "http://data.tmsapi.com/v1/lineups?postalCode=__ZIP__&api_key=dn3gkyv4pzcmfcp5fakh7raz".replace("__ZIP__", (new StringBuilder()).append("").append(h.Q).toString());
_L4:
        as = new HttpGet(d);
        ae.a(as, d);
        a = EntityUtils.toString(((HttpClient) (obj)).execute(as).getEntity());
        return a;
_L2:
        if (e.equals("channel"))
        {
            c = as[2];
            d = "http://data.tmsapi.com/v1/stations/__STATION__?lineupId=__LINEUP__&api_key=dn3gkyv4pzcmfcp5fakh7raz".replace("__STATION__", (new StringBuilder()).append("").append(h.L).toString());
            d = d.replace("__LINEUP__", (new StringBuilder()).append("").append(c).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
        as;
        ad.a(as);
        return null;
    }

    protected void a(String s)
    {
        if (e.equals("provider"))
        {
            h.a(s, b);
        } else
        if (e.equals("channel"))
        {
            h.a(s);
            return;
        }
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

    public ent(z z1)
    {
        h = z1;
        super();
    }
}
