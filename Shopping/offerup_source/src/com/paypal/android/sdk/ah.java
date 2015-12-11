// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.paypal.android.sdk:
//            ao, u, ax, dd, 
//            ap

public class ah extends ao
{

    private static final String a = com/paypal/android/sdk/ah.getSimpleName();
    private Handler b;
    private String c;
    private String d;
    private String e;
    private u f;

    public ah(String s, String s1, String s2, u u1, Handler handler)
    {
        b = handler;
        c = s;
        d = s1;
        e = s2;
        f = u1;
    }

    private String a(String s)
    {
        Object obj;
        Object obj2;
        obj2 = null;
        obj = null;
        Object obj1;
        obj1 = new URL(s);
        s = (HttpURLConnection)((URL) (obj1)).openConnection();
        s.setReadTimeout(60000);
        s.setConnectTimeout(60000);
        s.setRequestMethod("GET");
        s.setRequestProperty("User-Agent", String.format("%s/%s/%s/%s/Android", new Object[] {
            f.a(), f.b(), e, d
        }));
        s.setRequestProperty("Accept-Language", "en-us");
        int i = s.getResponseCode();
        (new StringBuilder("\nSending 'GET' request to URL : ")).append(obj1);
        ax.b();
        (new StringBuilder("Response Code : ")).append(i);
        ax.b();
        obj1 = new BufferedReader(new InputStreamReader(s.getInputStream()));
        obj = "";
_L2:
        obj2 = ((BufferedReader) (obj1)).readLine();
        if (obj2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = (new StringBuilder()).append(((String) (obj))).append(((String) (obj2))).toString();
        obj = obj2;
        if (true) goto _L2; else goto _L1
_L1:
        ((String) (obj)).toString();
        ax.b();
        dd.a(((java.io.Closeable) (obj1)));
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_334;
        }
        s.disconnect();
        obj1 = obj;
_L4:
        return ((String) (obj1));
        obj2;
        obj1 = null;
        s = "";
_L7:
        b.sendMessage(Message.obtain(b, 1, obj2));
        dd.a(((java.io.Closeable) (obj1)));
        obj1 = s;
        if (obj == null) goto _L4; else goto _L3
_L3:
        ((HttpURLConnection) (obj)).disconnect();
        return s;
        s;
        obj1 = null;
        obj = obj2;
_L6:
        dd.a(((java.io.Closeable) (obj1)));
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw s;
        obj2;
        obj1 = null;
        obj = s;
        s = ((String) (obj2));
        continue; /* Loop/switch isn't completed */
        obj2;
        obj = s;
        s = ((String) (obj2));
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L6; else goto _L5
_L5:
        obj2;
        obj1 = null;
        obj = s;
        s = "";
          goto _L7
        obj2;
        String s1 = s;
        s = ((String) (obj));
        obj = s1;
          goto _L7
        return ((String) (obj));
    }

    public void run()
    {
        if (b == null)
        {
            return;
        }
        b.sendMessage(Message.obtain(b, 20, c));
        String s = a(c);
        String.format("%s/%s/%s/%s/Android", new Object[] {
            f.a(), f.b(), e, d
        });
        ax.b();
        b.sendMessage(Message.obtain(b, 22, s.toString()));
        ap.a().b(this);
        return;
        Object obj;
        obj;
        b.sendMessage(Message.obtain(b, 21, obj));
        ap.a().b(this);
        return;
        obj;
        ap.a().b(this);
        throw obj;
    }

}
