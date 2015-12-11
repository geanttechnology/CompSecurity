// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;

import android.content.Context;
import com.google.ads.m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class j
    implements Runnable
{
    public static class a
    {

        private final String a;

        public JSONObject a()
        {
            JSONObject jsonobject = new JSONObject();
            try
            {
                jsonobject.put("debugHeader", a);
            }
            catch (JSONException jsonexception)
            {
                com.google.ads.util.b.b("Could not build ReportAdJson from inputs.", jsonexception);
                return jsonobject;
            }
            return jsonobject;
        }

        public a(String s)
        {
            a = s;
        }
    }


    private String a;
    private Context b;

    public j(String s, Context context)
    {
        a = s;
        b = context;
    }

    protected BufferedOutputStream a(HttpURLConnection httpurlconnection)
        throws IOException
    {
        return new BufferedOutputStream(httpurlconnection.getOutputStream());
    }

    protected HttpURLConnection a(URL url)
        throws IOException
    {
        url = (HttpURLConnection)url.openConnection();
        url.setDoOutput(true);
        url.setInstanceFollowRedirects(true);
        AdUtil.a(url, b);
        url.setRequestProperty("Accept", "application/json");
        url.setRequestProperty("Content-Type", "application/json");
        return url;
    }

    public void run()
    {
        Object obj = (String)((com.google.ads.m.a)m.a().b.a()).h.a();
        byte abyte0[];
        obj = a(new URL(((String) (obj))));
        abyte0 = (new a(a)).a().toString().getBytes();
        ((HttpURLConnection) (obj)).setFixedLengthStreamingMode(abyte0.length);
        BufferedOutputStream bufferedoutputstream = a(((HttpURLConnection) (obj)));
        bufferedoutputstream.write(abyte0);
        bufferedoutputstream.close();
        if (((HttpURLConnection) (obj)).getResponseCode() != 200)
        {
            com.google.ads.util.b.b((new StringBuilder()).append("Got error response from BadAd backend: ").append(((HttpURLConnection) (obj)).getResponseMessage()).toString());
        }
        Exception exception;
        try
        {
            ((HttpURLConnection) (obj)).disconnect();
            return;
        }
        catch (IOException ioexception)
        {
            com.google.ads.util.b.b("Error reporting bad ad.", ioexception);
        }
        break MISSING_BLOCK_LABEL_131;
        exception;
        ((HttpURLConnection) (obj)).disconnect();
        throw exception;
    }
}
