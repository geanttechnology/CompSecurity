// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.a.k;
import com.tencent.open.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends b
{

    private String d;

    public d(WebView webview, long l, String s, String s1)
    {
        super(webview, l, s);
        d = s1;
    }

    private void b(String s)
    {
        WebView webview = (WebView)a.get();
        if (webview != null)
        {
            StringBuffer stringbuffer = new StringBuffer("javascript:");
            stringbuffer.append("if(!!").append(d).append("){");
            stringbuffer.append(d);
            stringbuffer.append("(");
            stringbuffer.append(s);
            stringbuffer.append(")}");
            s = stringbuffer.toString();
            k.b("openSDK_LOG", (new StringBuilder()).append("-->callback, callback: ").append(s).toString());
            webview.loadUrl(s);
        }
    }

    public void a()
    {
        k.b("openSDK_LOG.SL", "-->onNoMatchMethod...");
    }

    public void a(Object obj)
    {
        k.b("openSDK_LOG.SL", (new StringBuilder()).append("-->onComplete, result: ").append(obj).toString());
    }

    public void a(String s)
    {
        k.b("openSDK_LOG.SL", (new StringBuilder()).append("-->onCustomCallback, js: ").append(s).toString());
        JSONObject jsonobject = new JSONObject();
        byte byte0 = 0;
        if (!com.tencent.open.c.b.a)
        {
            byte0 = -4;
        }
        try
        {
            jsonobject.put("result", byte0);
            jsonobject.put("sn", b);
            jsonobject.put("data", s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        b(jsonobject.toString());
    }
}
