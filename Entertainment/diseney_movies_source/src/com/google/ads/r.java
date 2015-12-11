// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.internal.g;
import com.google.ads.util.b;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.google.ads:
//            o, am, n, al, 
//            ae

public class r
    implements o
{

    public r()
    {
    }

    public void a(d d1, HashMap hashmap, WebView webview)
    {
        String s;
        s = (String)hashmap.get("u");
        if (s == null)
        {
            b.e("Could not get URL from click gmsg.");
            return;
        }
        g g1 = d1.n();
        if (g1 != null)
        {
            hashmap = Uri.parse(s);
            webview = hashmap.getHost();
            if (webview != null && webview.toLowerCase(Locale.US).endsWith(".admob.com"))
            {
                webview = null;
                String s1 = hashmap.getPath();
                hashmap = webview;
                if (s1 != null)
                {
                    String as[] = s1.split("/");
                    hashmap = webview;
                    if (as.length >= 4)
                    {
                        hashmap = (new StringBuilder()).append(as[2]).append("/").append(as[3]).toString();
                    }
                }
                g1.a(hashmap);
            }
        }
        hashmap = d1.i();
        webview = (Context)((n) (hashmap)).f.a();
        d1 = Uri.parse(s);
        hashmap = (al)((n) (hashmap)).s.a();
        if (hashmap == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        if (!hashmap.a(d1))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        hashmap = hashmap.a(d1, webview);
        d1 = hashmap;
_L2:
        (new Thread(new ae(d1.toString(), webview))).start();
        return;
        hashmap;
        b.e((new StringBuilder()).append("Unable to append parameter to URL: ").append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }
}
