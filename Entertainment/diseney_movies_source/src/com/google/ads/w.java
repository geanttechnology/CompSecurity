// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.c;
import com.google.ads.internal.d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.google.ads:
//            o, n, m

public class w
    implements o
{

    public w()
    {
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        String s = (String)hashmap.get("url");
        webview = (String)hashmap.get("type");
        String s2 = (String)hashmap.get("afma_notify_dt");
        String s1 = (String)hashmap.get("activation_overlay_url");
        Object obj = (String)hashmap.get("check_packages");
        boolean flag = "1".equals(hashmap.get("drt_include"));
        String s3 = (String)hashmap.get("request_scenario");
        boolean flag1 = "1".equals(hashmap.get("use_webview_loadurl"));
        if (com.google.ads.internal.c.d.d.e.equals(s3))
        {
            hashmap = com.google.ads.internal.c.d.d;
        } else
        if (com.google.ads.internal.c.d.c.e.equals(s3))
        {
            hashmap = com.google.ads.internal.c.d.c;
        } else
        if (com.google.ads.internal.c.d.a.e.equals(s3))
        {
            hashmap = com.google.ads.internal.c.d.a;
        } else
        {
            hashmap = com.google.ads.internal.c.d.b;
        }
        b.c((new StringBuilder()).append("Received ad url: <url: \"").append(s).append("\" type: \"").append(webview).append("\" afmaNotifyDt: \"").append(s2).append("\" activationOverlayUrl: \"").append(s1).append("\" useWebViewLoadUrl: \"").append(flag1).append("\">").toString());
        webview = s;
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            webview = s;
            if (!TextUtils.isEmpty(s))
            {
                webview = new BigInteger(new byte[1]);
                String as[] = ((String) (obj)).split(",");
                for (int i = 0; i < as.length;)
                {
                    obj = webview;
                    if (AdUtil.a((Context)d1.i().c.a(), as[i]))
                    {
                        obj = webview.setBit(i);
                    }
                    i++;
                    webview = ((WebView) (obj));
                }

                obj = String.format(Locale.US, "%X", new Object[] {
                    webview
                });
                webview = s.replaceAll("%40installed_markets%40", ((String) (obj)));
                m.a().a.a(obj);
                b.c((new StringBuilder()).append("Ad url modified to ").append(webview).toString());
            }
        }
        d1 = d1.k();
        if (d1 != null)
        {
            d1.d(flag);
            d1.a(hashmap);
            d1.e(flag1);
            d1.e(s1);
            d1.d(webview);
        }
    }
}
