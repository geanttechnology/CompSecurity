// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.server;

import android.text.TextUtils;
import com.supersonic.mediationsdk.utils.SupersonicUtils;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class HttpFunctions
{

    private static final int SERVER_REQUEST_TIMEOUT = 15000;

    public HttpFunctions()
    {
    }

    public static boolean getStringFromPost(String s, String s1)
    {
        boolean flag = false;
        int i;
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            s = new HttpPost(s);
            s.setEntity(new StringEntity(s1, "UTF-8"));
            s.setHeader("Accept", "application/json");
            s.setHeader("Content-type", "application/json");
            i = defaulthttpclient.execute(s).getStatusLine().getStatusCode();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (i == 200)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean getStringFromPostWithAutho(String s, String s1, String s2, String s3)
    {
        boolean flag = false;
        int i;
        try
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            s = new HttpPost(s);
            s.setEntity(new StringEntity(s1, "UTF-8"));
            s.setHeader("Authorization", SupersonicUtils.getBase64Auth(s2, s3));
            i = defaulthttpclient.execute(s).getStatusLine().getStatusCode();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (i == 200)
        {
            flag = true;
        }
        return flag;
    }

    public static String getStringFromURL(String s)
        throws Exception
    {
        Object obj = new DefaultHttpClient();
        HttpGet httpget = new HttpGet();
        httpget.setURI(new URI(s));
        httpget.getParams().setIntParameter("http.socket.timeout", 15000);
        obj = EntityUtils.toString(((HttpClient) (obj)).execute(httpget).getEntity());
        s = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s = null;
        }
        return s;
    }
}
