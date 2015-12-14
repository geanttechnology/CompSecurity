// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import android.util.Log;
import com.cyberlink.uma.internal.AlwaysLoggedException;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.uma.a:
//            f

class a
    implements Runnable
{

    private static final SSLSocketFactory c = null;
    private static final HostnameVerifier d = null;
    private final f a;
    private final String b;

    a(String s, f f1)
    {
        b = s;
        a = f1;
    }

    private static URLConnection a(URL url)
    {
        return url.openConnection();
    }

    URLConnection a(String s)
    {
        s = a(new URL((new StringBuilder()).append(b).append("/i?").append(s).toString()));
        s.setConnectTimeout(30000);
        s.setReadTimeout(30000);
        s.setUseCaches(false);
        s.setDoInput(true);
        s.setDoOutput(false);
        return s;
    }

    public void run()
    {
_L7:
        String as[] = a.a();
        if (as != null && as.length != 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s = as[0];
        URLConnection urlconnection = a(s);
        Object obj;
        urlconnection.connect();
        obj = new BufferedInputStream(urlconnection.getInputStream());
        Object obj1 = new ByteArrayOutputStream(256);
_L5:
        int i = ((BufferedInputStream) (obj)).read();
        if (i == -1) goto _L4; else goto _L3
_L3:
        ((ByteArrayOutputStream) (obj1)).write(i);
          goto _L5
        obj1;
_L11:
        Log.w("CountlyProcessor", "Failed to send data to server", new AlwaysLoggedException(((Throwable) (obj1))));
        Log.w("CountlyProcessor", (new StringBuilder()).append("Failed to send data to server eventData: ").append(s).toString());
        boolean flag;
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (urlconnection == null || !(urlconnection instanceof HttpURLConnection)) goto _L1; else goto _L6
_L6:
        ((HttpURLConnection)urlconnection).disconnect();
        return;
_L4:
        if (!(urlconnection instanceof HttpURLConnection))
        {
            break MISSING_BLOCK_LABEL_488;
        }
        i = ((HttpURLConnection)urlconnection).getResponseCode();
        boolean flag1;
        if (i >= 200 && i < 300)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag = flag1;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_232;
        }
        Log.w("CountlyProcessor", (new StringBuilder()).append("HTTP error response code was ").append(i).append(" from submitting event data: ").append(s).toString());
        flag = flag1;
_L12:
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        flag = (new JSONObject(((ByteArrayOutputStream) (obj1)).toString("UTF-8"))).optString("result").equalsIgnoreCase("success");
        flag1 = flag;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        Log.w("CountlyProcessor", (new StringBuilder()).append("Response from Countly server did not report success, it was: ").append(((ByteArrayOutputStream) (obj1)).toString("UTF-8")).toString());
        flag1 = flag;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        Log.d("CountlyProcessor", (new StringBuilder()).append("ok ->").append(s).toString());
        a.b(s);
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (urlconnection != null && (urlconnection instanceof HttpURLConnection))
        {
            ((HttpURLConnection)urlconnection).disconnect();
        }
          goto _L7
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (urlconnection == null || !(urlconnection instanceof HttpURLConnection)) goto _L1; else goto _L8
_L8:
        ((HttpURLConnection)urlconnection).disconnect();
        return;
        obj1;
        obj = null;
        urlconnection = null;
_L10:
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (urlconnection != null && (urlconnection instanceof HttpURLConnection))
        {
            ((HttpURLConnection)urlconnection).disconnect();
        }
        throw obj1;
        obj1;
        obj = null;
        continue; /* Loop/switch isn't completed */
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L10; else goto _L9
_L9:
        obj1;
        obj = null;
        urlconnection = null;
          goto _L11
        obj1;
        obj = null;
          goto _L11
        flag = false;
          goto _L12
    }

}
