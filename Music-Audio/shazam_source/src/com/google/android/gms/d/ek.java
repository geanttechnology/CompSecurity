// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.client.b;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            ei, gm

public final class ek
    implements ei
{

    final Context a;
    final Set b = Collections.synchronizedSet(new HashSet());

    public ek(Context context)
    {
        a = context;
    }

    public final void a(String s, String s1)
    {
        com.google.android.gms.ads.internal.util.client.b.a(3);
        gm.a.post(new Runnable(s, s1) {

            final String a;
            final String b;
            final ek c;

            public final void run()
            {
                WebView webview = new WebView(c.a);
                webview.getSettings().setJavaScriptEnabled(true);
                webview.setWebViewClient(new WebViewClient(this, webview) {

                    final WebView a;
                    final _cls1 b;

                    public final void onPageFinished(WebView webview, String s)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(3);
                        b.c.b.remove(a);
                    }

                    public final void onReceivedError(WebView webview, int i, String s, String s1)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(5);
                        b.c.b.remove(a);
                    }

            
            {
                b = _pcls1;
                a = webview;
                super();
            }
                });
                c.b.add(webview);
                webview.loadDataWithBaseURL(a, b, "text/html", "UTF-8", null);
                com.google.android.gms.ads.internal.util.client.b.a(3);
            }

            
            {
                c = ek.this;
                a = s;
                b = s1;
                super();
            }
        });
    }
}
