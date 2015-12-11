// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics.social;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.umeng.analytics.social:
//            b

public abstract class c
{

    public c()
    {
    }

    private static String a(InputStream inputstream)
    {
        BufferedReader bufferedreader;
        StringBuilder stringbuilder;
        bufferedreader = new BufferedReader(new InputStreamReader(inputstream), 8192);
        stringbuilder = new StringBuilder();
_L1:
        String s = bufferedreader.readLine();
        if (s == null)
        {
            Object obj;
            try
            {
                inputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                b.b("MobclickAgent", "Caught IOException in convertStreamToString()", inputstream);
                return null;
            }
            return stringbuilder.toString();
        }
        stringbuilder.append((new StringBuilder(String.valueOf(s))).append("\n").toString());
          goto _L1
        obj;
        b.b("MobclickAgent", "Caught IOException in convertStreamToString()", ((Exception) (obj)));
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            b.b("MobclickAgent", "Caught IOException in convertStreamToString()", inputstream);
            return null;
        }
        return null;
        obj;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            b.b("MobclickAgent", "Caught IOException in convertStreamToString()", inputstream);
            return null;
        }
        throw obj;
    }

    protected static String a(String s)
    {
        int i = (new Random()).nextInt(1000);
        String s1;
        s1 = System.getProperty("line.separator");
        if (s.length() > 1)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        b.b("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tInvalid baseUrl.").toString());
        return null;
        Object obj;
        Object obj1;
        obj = new HttpGet(s);
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(": GET_URL: ").append(s).toString());
        obj1 = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj1)), 10000);
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj1)), 20000);
        obj1 = (new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj1)))).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
        if (((HttpResponse) (obj1)).getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_359;
        }
        obj = ((HttpResponse) (obj1)).getEntity();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_426;
        }
        try
        {
            obj = ((HttpEntity) (obj)).getContent();
            obj1 = ((HttpResponse) (obj1)).getFirstHeader("Content-Encoding");
        }
        catch (ClientProtocolException clientprotocolexception)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), clientprotocolexception);
            return null;
        }
        catch (Exception exception)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tIOException,Failed to send message.").append(s).toString(), exception);
            return null;
        }
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (!((Header) (obj1)).getValue().equalsIgnoreCase("gzip")) goto _L2; else goto _L3
_L3:
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append("  Use GZIPInputStream get data....").toString());
        obj = new GZIPInputStream(((InputStream) (obj)));
_L5:
        obj = a(((InputStream) (obj)));
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tresponse: ").append(s1).append(((String) (obj))).toString());
        if (obj != null)
        {
            return ((String) (obj));
        }
        break MISSING_BLOCK_LABEL_426;
_L2:
        if (obj1 == null) goto _L5; else goto _L4
_L4:
        if (!((Header) (obj1)).getValue().equalsIgnoreCase("deflate")) goto _L5; else goto _L6
_L6:
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append("  Use InflaterInputStream get data....").toString());
        obj = new InflaterInputStream(((InputStream) (obj)));
          goto _L5
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tFailed to get message.").append(s).toString());
        return null;
        return null;
    }

    protected static String a(String s, String s1)
    {
        String s2;
        Object obj;
        int i;
        i = (new Random()).nextInt(1000);
        s2 = System.getProperty("line.separator");
        obj = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), 10000);
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), 20000);
        obj = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj)));
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(": POST_URL: ").append(s).toString());
        HttpPost httppost = new HttpPost(s);
        if (!TextUtils.isEmpty(s1))
        {
            b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(": POST_BODY: ").append(s1).toString());
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(new BasicNameValuePair("data", s1));
            httppost.setEntity(new UrlEncodedFormEntity(arraylist, "UTF-8"));
        }
        obj = ((HttpClient) (obj)).execute(httppost);
        if (((HttpResponse) (obj)).getStatusLine().getStatusCode() != 200)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        s1 = ((HttpResponse) (obj)).getEntity();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        try
        {
            s1 = s1.getContent();
            obj = ((HttpResponse) (obj)).getFirstHeader("Content-Encoding");
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tClientProtocolException,Failed to send message.").append(s).toString(), s1);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tIOException,Failed to send message.").append(s).toString(), s1);
            return null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_251;
        }
        if (((Header) (obj)).getValue().equalsIgnoreCase("deflate"))
        {
            s1 = new InflaterInputStream(s1);
        }
        s1 = a(((InputStream) (s1)));
        b.a("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tresponse: ").append(s2).append(s1).toString());
        if (s1 == null)
        {
            return null;
        } else
        {
            return s1;
        }
        b.c("MobclickAgent", (new StringBuilder(String.valueOf(i))).append(":\tFailed to send message.").append(s).toString());
        return null;
        return null;
    }
}
