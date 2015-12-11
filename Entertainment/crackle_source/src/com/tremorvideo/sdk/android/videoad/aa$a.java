// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.richmedia.ae;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aa, ad

class d extends AsyncTask
{

    final String a;
    final boolean b;
    final List c;
    final int d;

    protected transient Void a(String as[])
    {
        int i;
        i = aa.d();
        ad.d((new StringBuilder()).append("Sending Communication: ").append(i).append(a).toString());
        as = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(as, 18000);
        HttpConnectionParams.setSoTimeout(as, 18000);
        as.setBooleanParameter("http.protocol.expect-continue", false);
        as.setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
        as = new DefaultHttpClient(as);
        if (aa.e() != null)
        {
            as.setCookieStore(aa.e());
        }
        if (!b || c == null) goto _L2; else goto _L1
_L1:
        HttpPost httppost;
        String s;
        httppost = new HttpPost(a);
        s = ae.a(a, b, d);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        httppost.setHeader("User-Agent", s);
        if (c != null)
        {
            httppost.setEntity(new UrlEncodedFormEntity(c, "utf-8"));
        }
        as = as.execute(httppost);
_L3:
        aa.a();
        as = as.getStatusLine();
        HttpGet httpget;
        String s1;
        if (as != null)
        {
            try
            {
                ad.d((new StringBuilder()).append("Status: ").append(i).append(" : ").append(as.toString()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                ad.d((new StringBuilder()).append("Error Firing Tracking Pixel: ").append(a).append(" :: ").append(as.getMessage()).toString());
                ad.a(as);
            }
        }
        break MISSING_BLOCK_LABEL_327;
_L2:
        httpget = new HttpGet(a);
        s1 = ae.a(a, b, d);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_276;
        }
        httpget.setHeader("User-Agent", s1);
        as = as.execute(httpget);
          goto _L3
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    ormEntity(String s, boolean flag, List list, int i)
    {
        a = s;
        b = flag;
        c = list;
        d = i;
        super();
    }
}
