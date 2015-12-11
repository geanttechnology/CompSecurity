// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.wishabi.flipp.util.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.json.JSONException;
import org.json.JSONObject;

public final class ak
{

    public static int a(String s, List list)
    {
        if (TextUtils.isEmpty(s))
        {
            return -1;
        }
        UrlEncodedFormEntity urlencodedformentity;
        HttpURLConnection httpurlconnection;
        try
        {
            urlencodedformentity = new UrlEncodedFormEntity(list, "UTF-8");
            httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
            httpurlconnection.setDoInput(true);
            httpurlconnection.setDoOutput(true);
            httpurlconnection.setUseCaches(false);
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.setRequestProperty("Platform", "Android");
            s = g.a();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.toString();
            return -1;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        httpurlconnection.setRequestProperty("App-Version", s);
        if (!"".isEmpty())
        {
            httpurlconnection.setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString("".getBytes(), 2)).toString());
        }
        s = null;
        list = httpurlconnection.getOutputStream();
        s = list;
        urlencodedformentity.writeTo(list);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        list.close();
        return httpurlconnection.getResponseCode();
        list;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        s.close();
        throw list;
    }

    public static JSONObject a(Uri uri)
    {
        Object obj = g.a();
        URL url;
        HttpURLConnection httpurlconnection;
        url = new URL(uri.toString());
        httpurlconnection = (HttpURLConnection)url.openConnection();
        httpurlconnection.setDoInput(true);
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setRequestProperty("Content-Type", "application/json");
        httpurlconnection.setRequestProperty("Accept", "application/json");
        httpurlconnection.setRequestProperty("Platform", "Android");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        httpurlconnection.setRequestProperty("App-Version", ((String) (obj)));
        if (!"".isEmpty())
        {
            httpurlconnection.setRequestProperty("Authorization", (new StringBuilder("Basic ")).append(Base64.encodeToString("".getBytes(), 2)).toString());
        }
        (new StringBuilder("HTTP Request: ")).append(url.toString());
        if (httpurlconnection.getResponseCode() != 200) goto _L2; else goto _L1
_L1:
        char ac[];
        uri = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
        obj = new StringBuilder();
        ac = new char[4096];
_L5:
        int i = uri.read(ac);
        if (i == -1) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append(new String(ac, 0, i));
          goto _L5
        uri;
_L7:
        uri.toString();
        return null;
_L4:
        return new JSONObject(((StringBuilder) (obj)).toString());
_L2:
        uri.toString();
        return null;
        uri;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
