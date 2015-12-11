// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONObject;
import org.json.JSONTokener;

final class c
{

    private HttpClient a;

    public c()
    {
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(basichttpparams, "UTF-8");
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 60000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 60000);
        a = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }

    public final JSONObject a(String s, JSONObject jsonobject, boolean flag)
    {
        String s1 = null;
        if (jsonobject != null && jsonobject.length() != 0) goto _L2; else goto _L1
_L1:
        org.apache.http.Header header;
        try
        {
            jsonobject = a.execute(new HttpGet(s));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            if (flag)
            {
                Log.d("MobileAppTracker", (new StringBuilder("Request error with URL ")).append(s).toString());
            }
            jsonobject.printStackTrace();
            s = null;
            continue; /* Loop/switch isn't completed */
        }
        s = jsonobject;
_L15:
        if (s == null) goto _L4; else goto _L3
_L3:
        jsonobject = s.getStatusLine();
        header = s.getFirstHeader("X-MAT-Responder");
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Log.d("MobileAppTracker", (new StringBuilder("Request completed with status ")).append(jsonobject.getStatusCode()).toString());
        if (jsonobject.getStatusCode() < 200 || jsonobject.getStatusCode() > 299) goto _L6; else goto _L5
_L5:
        s = new BufferedReader(new InputStreamReader(s.getEntity().getContent(), "UTF-8"));
        jsonobject = new StringBuilder();
_L9:
        s1 = s.readLine();
        if (s1 == null) goto _L8; else goto _L7
_L7:
        jsonobject.append(s1).append("\n");
          goto _L9
        s;
        s.printStackTrace();
_L4:
        s = new JSONObject();
_L13:
        return s;
_L2:
        try
        {
            jsonobject = new StringEntity(jsonobject.toString());
            jsonobject.setContentType("application/json");
            s = new HttpPost(s);
            s.setEntity(jsonobject);
            s = a.execute(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = null;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        s.close();
        if (jsonobject.length() <= 0) goto _L4; else goto _L10
_L10:
        return new JSONObject(new JSONTokener(jsonobject.toString()));
_L6:
        if (jsonobject.getStatusCode() != 400 || header == null) goto _L4; else goto _L11
_L11:
        s = s1;
        if (!flag) goto _L13; else goto _L12
_L12:
        Log.d("MobileAppTracker", "Request received 400 error from MAT server, won't be retried");
        return null;
        if (true) goto _L15; else goto _L14
_L14:
    }
}
