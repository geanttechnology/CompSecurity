// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.android.gms.internal:
//            zzja, zziz, zzby, zzbu, 
//            zzid, zzih, zziq

public class zzjg extends zzja
{

    public zzjg(zziz zziz1, boolean flag)
    {
        super(zziz1, flag);
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
            if (!(webview instanceof zziz))
            {
                zzb.zzaH("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webview, s);
            }
            zziz zziz1 = (zziz)webview;
            zziz1.zzhe().zzeG();
            if (zziz1.zzaN().zztf)
            {
                s1 = (String)zzby.zzuP.get();
            } else
            {
                if (!zziz1.zzhi())
                {
                    break label0;
                }
                s1 = (String)zzby.zzuO.get();
            }
        }
_L1:
        zzb.v((new StringBuilder("shouldInterceptRequest(")).append(s1).append(")").toString());
        return zzd(zziz1.getContext(), zzoM.zzhh().zzJu, s1);
        s1 = (String)zzby.zzuN.get();
          goto _L1
        Object obj;
        obj;
_L3:
        zzb.zzaH((new StringBuilder("Could not fetch MRAID JS. ")).append(((Exception) (obj)).getMessage()).toString());
        return super.shouldInterceptRequest(webview, s);
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L3; else goto _L2
_L2:
    }

    protected WebResourceResponse zzd(Context context, String s, String s1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("User-Agent", zzp.zzbv().zzf(context, s));
        hashmap.put("Cache-Control", "max-stale=3600");
        context = (String)(new zzih(context)).zza(s1, hashmap).get(60L, TimeUnit.SECONDS);
        if (context == null)
        {
            return null;
        } else
        {
            return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(context.getBytes("UTF-8")));
        }
    }
}
