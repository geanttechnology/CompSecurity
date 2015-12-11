// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import com.mopub.common.c.a;
import java.util.EnumSet;

// Referenced classes of package com.mopub.common:
//            n, MoPubBrowser, o

final class e extends WebViewClient
{

    private static final EnumSet a;
    private MoPubBrowser b;

    public e(MoPubBrowser mopubbrowser)
    {
        b = mopubbrowser;
    }

    static MoPubBrowser a(e e1)
    {
        return e1.b;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (webview.canGoBack())
        {
            s = com.mopub.common.d.e.c.a(b);
        } else
        {
            s = com.mopub.common.d.e.d.a(b);
        }
        b.b.setImageDrawable(s);
        if (webview.canGoForward())
        {
            webview = com.mopub.common.d.e.e.a(b);
        } else
        {
            webview = com.mopub.common.d.e.f.a(b);
        }
        b.c.setImageDrawable(webview);
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        b.c.setImageDrawable(com.mopub.common.d.e.f.a(b));
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        com.mopub.common.c.a.b((new StringBuilder("MoPubBrowser error: ")).append(s).toString());
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            webview = (new o.a()).a(a);
            webview.c = true;
            webview.a = new o.c() {

                final e a;

                public final void a(String s1, n n1)
                {
                    if (n1.equals(n.f))
                    {
                        com.mopub.common.e.a(a).a.loadUrl(s1);
                        return;
                    } else
                    {
                        com.mopub.common.e.a(a).finish();
                        return;
                    }
                }

            
            {
                a = e.this;
                super();
            }
            };
            return webview.a().b(b.getApplicationContext(), s, true, null);
        }
    }

    static 
    {
        a = EnumSet.of(n.c, new n[] {
            n.e, n.f, n.g, n.h, n.i
        });
    }
}
