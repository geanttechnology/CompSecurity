// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            ed, dx, dp, en, 
//            dr

public final class ee extends ed
{

    private dp a;
    private dx b;
    private boolean c;
    private dr d;

    public ee(dp dp1, dx dx1, dr dr1)
    {
        this(dp1, dx1, false, dr1);
    }

    public ee(dp dp1, dx dx1, boolean flag, dr dr1)
    {
        a = dp1;
        b = dx1;
        c = flag;
        d = dr1;
    }

    public final void a()
    {
        Object obj;
        Object obj1 = null;
        HttpURLConnection httpurlconnection;
        BufferedReader bufferedreader;
        int i;
        int j;
        boolean flag;
        try
        {
            httpurlconnection = b.a();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        if (httpurlconnection != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        a.a(httpurlconnection.getOutputStream());
        i = httpurlconnection.getResponseCode();
        if (!c)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        obj = new StringBuilder();
        bufferedreader = new BufferedReader(new InputStreamReader(httpurlconnection.getInputStream()));
_L5:
        j = bufferedreader.read();
        if (j == -1) goto _L4; else goto _L3
_L3:
        ((StringBuilder) (obj)).append((char)j);
          goto _L5
        obj;
_L11:
        (new StringBuilder("UnsupportedEncodingException in proceed(): ")).append(((UnsupportedEncodingException) (obj)).getMessage());
        en.b();
        en.c();
        flag = false;
        obj = obj1;
_L7:
        httpurlconnection.disconnect();
        if (d == null) goto _L1; else goto _L6
_L6:
        d.a(flag, i, ((JSONObject) (obj)));
        return;
_L4:
        bufferedreader.close();
        obj = new JSONObject(((StringBuilder) (obj)).toString());
_L12:
        flag = false;
          goto _L7
        obj;
        i = -1;
_L10:
        (new StringBuilder("SocketTimeoutException in proceed(): ")).append(((SocketTimeoutException) (obj)).getMessage());
        en.b();
        flag = true;
        obj = obj1;
          goto _L7
        obj;
        i = -1;
_L9:
        (new StringBuilder("IOException in proceed(): ")).append(((IOException) (obj)).getMessage());
        en.b();
        en.c();
        flag = false;
        obj = obj1;
          goto _L7
        obj;
        i = -1;
_L8:
        (new StringBuilder("JSONException in proceed(): ")).append(((JSONException) (obj)).getMessage());
        en.b();
        flag = false;
        en.c();
        obj = obj1;
          goto _L7
        obj;
          goto _L8
        obj;
          goto _L9
        obj;
          goto _L10
        obj;
        i = -1;
          goto _L11
        obj = null;
          goto _L12
    }
}
