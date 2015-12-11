// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.p;
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

// Referenced classes of package com.google.android.gms.d:
//            hf, he, gm, ay, 
//            ax, gq, hz, ha

public final class hk extends hf
{

    public hk(he he1, boolean flag)
    {
        super(he1, flag);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        hf hf1;
        if (!"mraid.js".equalsIgnoreCase((new File(s)).getName()))
        {
            return super.shouldInterceptRequest(webview, s);
        }
        if (!(webview instanceof he))
        {
            b.a(5);
            return super.shouldInterceptRequest(webview, s);
        }
        obj1 = (he)webview;
        hf1 = ((he) (obj1)).i();
        synchronized (hf1.c)
        {
            hf1.f = false;
            hf1.g = true;
            gm.a(new hf._cls1(hf1));
        }
        if (!((he) (obj1)).h().e) goto _L2; else goto _L1
_L1:
        obj = ay.F;
        obj = (String)p.n().a(((au) (obj)));
_L3:
        (new StringBuilder("shouldInterceptRequest(")).append(((String) (obj))).append(")");
        b.a(2);
        Object obj2 = ((he) (obj1)).getContext();
        Object obj3 = a.l().b;
        obj1 = new HashMap();
        ((Map) (obj1)).put("User-Agent", p.e().a(((android.content.Context) (obj2)), ((String) (obj3))));
        ((Map) (obj1)).put("Cache-Control", "max-stale=3600");
        obj3 = new gq(((android.content.Context) (obj2)));
        obj2 = new gq.c(((gq) (obj3)), (byte)0);
        obj = new gq._cls3(((gq) (obj3)), ((String) (obj)), ((is.b) (obj2)), new gq._cls2(((gq) (obj3)), ((String) (obj)), ((gq.c) (obj2))), ((Map) (obj1)));
        gq.a.a(((hx) (obj)));
        obj = (String)((ha) (obj2)).get(60L, TimeUnit.SECONDS);
        if (obj == null)
        {
            return null;
        }
        break MISSING_BLOCK_LABEL_374;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        (new StringBuilder("Could not fetch MRAID JS. ")).append(((Exception) (obj)).getMessage());
        b.a(5);
        return super.shouldInterceptRequest(webview, s);
_L2:
label0:
        {
            if (!((he) (obj1)).m())
            {
                break label0;
            }
            obj = ay.E;
            obj = (String)p.n().a(((au) (obj)));
        }
          goto _L3
        obj = ay.D;
        obj = (String)p.n().a(((au) (obj)));
          goto _L3
        obj = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(((String) (obj)).getBytes("UTF-8")));
        return ((WebResourceResponse) (obj));
    }
}
