// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.android.gms.b:
//            ck, bz, cc, cg, 
//            cj, y, u

public class cp extends ck
{

    public cp(cj cj1, boolean flag)
    {
        super(cj1, flag);
    }

    protected WebResourceResponse a(Context context, String s, String s1)
        throws IOException, ExecutionException, InterruptedException, TimeoutException
    {
        HashMap hashmap = new HashMap();
        hashmap.put("User-Agent", c.c().a(context, s));
        hashmap.put("Cache-Control", "max-stale=3600");
        context = (String)(new cc(context)).a(s1, hashmap).get(60L, TimeUnit.SECONDS);
        if (context == null)
        {
            return null;
        } else
        {
            return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(context.getBytes("UTF-8")));
        }
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        String s1;
label0:
        {
            if (!"mraid.js".equalsIgnoreCase((new File(s)).getName()))
            {
                return super.shouldInterceptRequest(webview, s);
            }
            if (!(webview instanceof cj))
            {
                b.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webview, s);
            }
            cj cj1 = (cj)webview;
            cj1.h().g();
            if (cj1.g().e)
            {
                s1 = (String)y.v.c();
            } else
            {
                if (!cj1.l())
                {
                    break label0;
                }
                s1 = (String)y.u.c();
            }
        }
_L1:
        b.d((new StringBuilder()).append("shouldInterceptRequest(").append(s1).append(")").toString());
        return a(cj1.getContext(), a.k().b, s1);
        s1 = (String)y.t.c();
          goto _L1
        Object obj;
        obj;
_L3:
        b.e((new StringBuilder()).append("Could not fetch MRAID JS. ").append(((Exception) (obj)).getMessage()).toString());
        return super.shouldInterceptRequest(webview, s);
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
