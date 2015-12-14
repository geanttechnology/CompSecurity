// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, bw, p, q

class o
{

    private final AppLovinSdkImpl a;
    private final AppLovinLogger b;

    o(AppLovinSdkImpl applovinsdkimpl)
    {
        a = applovinsdkimpl;
        b = applovinsdkimpl.getLogger();
    }

    private int a(Throwable throwable)
    {
        if (throwable instanceof SocketTimeoutException)
        {
            return -102;
        }
        if (throwable instanceof IOException)
        {
            throwable = throwable.getMessage();
            return throwable == null || !throwable.toLowerCase(Locale.ENGLISH).contains("authentication challenge") ? -100 : 401;
        }
        return !(throwable instanceof JSONException) ? -1 : -104;
    }

    private HttpURLConnection a(String s, String s1, int i)
    {
        s = (HttpURLConnection)(new URL(s)).openConnection();
        s.setRequestMethod(s1);
        int j;
        if (i < 0)
        {
            j = ((Integer)a.a(bw.t)).intValue();
        } else
        {
            j = i;
        }
        s.setConnectTimeout(j);
        j = i;
        if (i < 0)
        {
            j = ((Integer)a.a(bw.v)).intValue();
        }
        s.setReadTimeout(j);
        s.setDefaultUseCaches(false);
        s.setAllowUserInteraction(false);
        s.setUseCaches(false);
        s.setInstanceFollowRedirects(true);
        s.setDoInput(true);
        return s;
    }

    private static void a(InputStream inputstream)
    {
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        inputstream.close();
        return;
        inputstream;
    }

    private void a(String s, int i, String s1, p p1)
    {
        b.d("ConnectionManager", (new StringBuilder()).append(i).append(" received from from \"").append(s1).append("\": ").append(s).toString());
        if (i >= 200 && i < 300)
        {
            JSONObject jsonobject = new JSONObject();
            s1 = jsonobject;
            if (i != 204)
            {
                s1 = jsonobject;
                if (s != null)
                {
                    s1 = jsonobject;
                    if (s.length() > 2)
                    {
                        s1 = new JSONObject(s);
                    }
                }
            }
            p1.a(s1, i);
            return;
        } else
        {
            b.e("ConnectionManager", (new StringBuilder()).append(i).append(" error received from \"").append(s1).append("\"").toString());
            p1.a(i);
            return;
        }
    }

    private void a(String s, String s1, int i, long l)
    {
        b.i("ConnectionManager", (new StringBuilder()).append("Successful ").append(s).append(" returned ").append(i).append(" in ").append((float)(System.currentTimeMillis() - l) / 1000F).append(" s").append(" over ").append(q.a(a)).append(" to \"").append(s1).append("\"").toString());
    }

    private void a(String s, String s1, int i, long l, Throwable throwable)
    {
        b.e("ConnectionManager", (new StringBuilder()).append("Failed ").append(s).append(" returned ").append(i).append(" in ").append((float)(System.currentTimeMillis() - l) / 1000F).append(" s").append(" over ").append(q.a(a)).append(" to \"").append(s1).append("\"").toString(), throwable);
    }

    private static void a(HttpURLConnection httpurlconnection)
    {
        if (httpurlconnection == null)
        {
            break MISSING_BLOCK_LABEL_8;
        }
        httpurlconnection.disconnect();
        return;
        httpurlconnection;
    }

    void a(String s, int i, p p1)
    {
        a(s, "GET", i, null, true, p1);
    }

    void a(String s, int i, JSONObject jsonobject, boolean flag, p p1)
    {
        a(s, "POST", i, jsonobject, flag, p1);
    }

    void a(String s, int i, boolean flag, p p1)
    {
        a(s, "GET", i, null, flag, p1);
    }

    void a(String s, String s1, int i, JSONObject jsonobject, boolean flag, p p1)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("No endpoint specified");
        }
        if (s1 == null)
        {
            throw new IllegalArgumentException("No method specified");
        }
        if (p1 == null)
        {
            throw new IllegalArgumentException("No callback specified");
        }
        if (!s.toLowerCase().startsWith("http"))
        {
            b.userError("ConnectionManager", (new StringBuilder()).append("Requested postback submission to non HTTP endpoint ").append(s).append("; skipping...").toString());
            p1.a(-900);
            return;
        }
        HttpURLConnection httpurlconnection;
        Object obj;
        Object obj1;
        String s2;
        Object obj2;
        PrintWriter printwriter;
        int j;
        int k;
        int l;
        long l1;
        if (((Boolean)a.a(bw.bk)).booleanValue() && !s.contains("https://"))
        {
            a.getLogger().w("ConnectionManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
            s2 = s.replace("http://", "https://");
        } else
        {
            s2 = s;
        }
        l1 = System.currentTimeMillis();
        obj = null;
        obj2 = null;
        obj1 = null;
        j = -1;
        b.i("ConnectionManager", (new StringBuilder()).append("Sending ").append(s1).append(" request to \"").append(s2).append("\"...").toString());
        httpurlconnection = a(s2, s1, i);
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_445;
        }
        obj = obj2;
        s = httpurlconnection;
        l = j;
        jsonobject = jsonobject.toString();
        obj = obj2;
        s = httpurlconnection;
        l = j;
        b.d("ConnectionManager", (new StringBuilder()).append("Request to \"").append(s2).append("\" is ").append(jsonobject).toString());
        obj = obj2;
        s = httpurlconnection;
        l = j;
        httpurlconnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        obj = obj2;
        s = httpurlconnection;
        l = j;
        httpurlconnection.setDoOutput(true);
        obj = obj2;
        s = httpurlconnection;
        l = j;
        httpurlconnection.setFixedLengthStreamingMode(jsonobject.getBytes(Charset.forName("UTF-8")).length);
        obj = obj2;
        s = httpurlconnection;
        l = j;
        printwriter = new PrintWriter(new OutputStreamWriter(httpurlconnection.getOutputStream(), "UTF8"));
        obj = obj2;
        s = httpurlconnection;
        l = j;
        printwriter.print(jsonobject);
        obj = obj2;
        s = httpurlconnection;
        l = j;
        printwriter.close();
        k = j;
        obj = obj2;
        s = httpurlconnection;
        l = j;
        i = httpurlconnection.getResponseCode();
        if (i <= 0) goto _L2; else goto _L1
_L1:
        k = i;
        obj = obj2;
        s = httpurlconnection;
        l = i;
        a(s1, s2, i, l1);
        if (!flag) goto _L4; else goto _L3
_L3:
        k = i;
        obj = obj2;
        s = httpurlconnection;
        l = i;
        jsonobject = httpurlconnection.getInputStream();
        s = jsonobject;
        jsonobject = s;
        j = i;
        obj = s;
        a(q.a(s), httpurlconnection.getResponseCode(), s2, p1);
_L5:
        a(((InputStream) (s)));
        a(httpurlconnection);
        return;
_L4:
        k = i;
        obj = obj2;
        s = httpurlconnection;
        l = i;
        p1.a(new JSONObject(), i);
        s = null;
          goto _L5
_L2:
        k = i;
        obj = obj2;
        s = httpurlconnection;
        l = i;
        a(s1, s2, i, l1, ((Throwable) (null)));
        k = i;
        obj = obj2;
        s = httpurlconnection;
        l = i;
        p1.a(i);
        s = null;
          goto _L5
        s;
        s = null;
        i = k;
_L11:
        if (!flag) goto _L7; else goto _L6
_L6:
        jsonobject = s;
        j = i;
        obj = s;
        p1.a(-901);
          goto _L5
        s;
        obj1 = jsonobject;
        jsonobject = s;
        i = j;
_L10:
        j = i;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_706;
        }
        obj = obj1;
        s = httpurlconnection;
        j = a(((Throwable) (jsonobject)));
        obj = obj1;
        s = httpurlconnection;
        a(s1, s2, j, l1, ((Throwable) (jsonobject)));
        obj = obj1;
        s = httpurlconnection;
        p1.a(j);
        a(((InputStream) (obj1)));
        a(httpurlconnection);
        return;
_L7:
        jsonobject = s;
        j = i;
        obj = s;
        p1.a(new JSONObject(), -901);
          goto _L5
        s1;
        s = httpurlconnection;
_L9:
        a(((InputStream) (obj)));
        a(((HttpURLConnection) (s)));
        throw s1;
        s1;
        s = null;
        continue; /* Loop/switch isn't completed */
        s1;
        if (true) goto _L9; else goto _L8
_L8:
        jsonobject;
        httpurlconnection = null;
        i = j;
          goto _L10
        jsonobject;
        i = l;
          goto _L10
        jsonobject;
          goto _L11
    }

    void a(String s, JSONObject jsonobject, p p1)
    {
        a(s, "POST", -1, jsonobject, true, p1);
    }
}
