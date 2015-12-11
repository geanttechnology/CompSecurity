// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.richmedia.ae;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aa, ad

class b extends AsyncTask
{

    final String a;
    final String b;

    protected transient Void a(String as[])
    {
        int i;
        i = aa.d();
        ad.d((new StringBuilder()).append("Sending Communication: ").append(i).toString());
        as = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(as, 18000);
        HttpConnectionParams.setSoTimeout(as, 18000);
        as.setBooleanParameter("http.protocol.expect-continue", false);
        as.setParameter("http.protocol.version", HttpVersion.HTTP_1_0);
        as = new DefaultHttpClient(as);
        HttpPost httppost = new HttpPost(a);
        ae.a(httppost, a);
        httppost.setEntity(new StringEntity(b));
        if (aa.e() != null)
        {
            as.setCookieStore(aa.e());
        }
        aa.a(httppost, b);
        as = as.execute(httppost);
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        as = as.getStatusLine();
        if (as != null)
        {
            try
            {
                ad.d((new StringBuilder()).append("Status: ").append(i).append(" : ").append(as.toString()).toString());
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                ad.a("Error Sending Response: Exectuing POST", as);
            }
        }
        return null;
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    ient(String s, String s1)
    {
        a = s;
        b = s1;
        super();
    }
}
