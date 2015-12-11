// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            cq, ck, dg, ce, 
//            cg

public class cs extends cq
{

    private static final String a = crittercism/android/cs.getName();
    private ce b;
    private ck c;
    private boolean d;
    private cg e;

    public cs(ce ce1, ck ck1, cg cg1)
    {
        this(ce1, ck1, false, cg1);
    }

    public cs(ce ce1, ck ck1, boolean flag, cg cg1)
    {
        b = ce1;
        c = ck1;
        d = flag;
        e = cg1;
    }

    private static JSONObject a(URLConnection urlconnection)
    {
        StringBuilder stringbuilder = new StringBuilder();
        urlconnection = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
        do
        {
            int i = urlconnection.read();
            if (i != -1)
            {
                stringbuilder.append((char)i);
            } else
            {
                urlconnection.close();
                return new JSONObject(stringbuilder.toString());
            }
        } while (true);
    }

    public final void a()
    {
        Object obj1 = null;
        Object obj;
        HttpURLConnection httpurlconnection;
        obj = c;
        httpurlconnection = (HttpURLConnection)((ck) (obj)).a.openConnection();
        for (Iterator iterator = ((ck) (obj)).b.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Iterator iterator1 = ((List)entry.getValue()).iterator();
            while (iterator1.hasNext()) 
            {
                String s4 = (String)iterator1.next();
                httpurlconnection.addRequestProperty((String)entry.getKey(), s4);
            }
        }

        httpurlconnection.setConnectTimeout(((ck) (obj)).h);
        httpurlconnection.setReadTimeout(((ck) (obj)).h);
        httpurlconnection.setDoInput(((ck) (obj)).d);
        httpurlconnection.setDoOutput(((ck) (obj)).e);
        if (((ck) (obj)).g)
        {
            httpurlconnection.setChunkedStreamingMode(((ck) (obj)).c);
        }
        httpurlconnection.setRequestMethod(((ck) (obj)).f);
        if (httpurlconnection == null) goto _L2; else goto _L1
_L1:
        int i;
        obj = b;
        OutputStream outputstream = httpurlconnection.getOutputStream();
        dg.b();
        outputstream.write((new JSONObject(((ce) (obj)).a)).toString().getBytes("UTF8"));
        i = httpurlconnection.getResponseCode();
        if (!d) goto _L4; else goto _L3
_L3:
        obj = a(((URLConnection) (httpurlconnection)));
_L10:
        boolean flag = false;
_L5:
        httpurlconnection.disconnect();
        if (e != null)
        {
            e.a(flag, i, ((JSONObject) (obj)));
            return;
        }
        break; /* Loop/switch isn't completed */
        obj;
        i = -1;
_L9:
        String s = a;
        (new StringBuilder("UnsupportedEncodingException in proceed(): ")).append(((UnsupportedEncodingException) (obj)).getMessage());
        dg.b();
        dg.c();
        flag = false;
        obj = obj1;
          goto _L5
        obj;
        i = -1;
_L8:
        String s1 = a;
        (new StringBuilder("SocketTimeoutException in proceed(): ")).append(((SocketTimeoutException) (obj)).getMessage());
        dg.b();
        flag = true;
        obj = obj1;
          goto _L5
        obj;
        i = -1;
_L7:
        String s2 = a;
        (new StringBuilder("IOException in proceed(): ")).append(((IOException) (obj)).getMessage());
        dg.b();
        dg.c();
        flag = false;
        obj = obj1;
          goto _L5
        obj;
        i = -1;
_L6:
        String s3 = a;
        (new StringBuilder("JSONException in proceed(): ")).append(((JSONException) (obj)).getMessage());
        dg.b();
        flag = false;
        dg.c();
        obj = obj1;
          goto _L5
        obj;
          goto _L6
        obj;
          goto _L7
        obj;
          goto _L8
        obj;
          goto _L9
_L4:
        obj = null;
        if (true) goto _L10; else goto _L2
        IOException ioexception;
        ioexception;
_L2:
    }

}
