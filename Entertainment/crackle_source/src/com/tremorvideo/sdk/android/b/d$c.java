// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.b;

import android.os.AsyncTask;
import com.tremorvideo.sdk.android.richmedia.ae;
import com.tremorvideo.sdk.android.videoad.ad;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// Referenced classes of package com.tremorvideo.sdk.android.b:
//            d

class a extends AsyncTask
{

    final d a;

    private String a(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        BufferedReader bufferedreader;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        stringbuilder.append((new StringBuilder()).append(s).append("\n").toString());
          goto _L1
        IOException ioexception;
        ioexception;
        ioexception.printStackTrace();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
        }
        throw exception;
    }

    protected transient String a(String as[])
    {
        Object obj = new DefaultHttpClient();
        try
        {
            HttpGet httpget = new HttpGet(new URI(as[0]));
            ae.a(httpget, as[0]);
            as = ((HttpClient) (obj)).execute(httpget).getEntity();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            ad.a(as);
            return null;
        }
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        as = as.getContent();
        obj = a(((InputStream) (as)));
        as.close();
        return ((String) (obj));
        return null;
    }

    protected void a(String s)
    {
        a.b(s);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((String[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((String)obj);
    }

    d.ad(d d1)
    {
        a = d1;
        super();
    }
}
