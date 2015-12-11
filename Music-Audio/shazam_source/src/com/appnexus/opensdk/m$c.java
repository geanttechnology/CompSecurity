// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.ProgressDialog;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.l;
import com.appnexus.opensdk.b.o;

// Referenced classes of package com.appnexus.opensdk:
//            m

private final class _cls1.c extends WebView
{

    final m a;

    public ent(m m1, Context context)
    {
        a = m1;
        super(context);
        o.a(this);
        setWebViewClient(new WebViewClient(m1) {

            final m a;
            final m.c b;
            private boolean c;

            public final void onPageFinished(WebView webview, String s)
            {
                com.appnexus.opensdk.b.b.a(b.j, (new StringBuilder("Opening URL: ")).append(s).toString());
                l.a(b);
                if (m.j(b.a) != null)
                {
                    m.j(b.a).dismiss();
                }
                if (c)
                {
                    c = false;
                    return;
                } else
                {
                    b.setVisibility(0);
                    m.a(b.a, b);
                    return;
                }
            }

            public final boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                com.appnexus.opensdk.b.b.a(b.j, (new StringBuilder("Redirecting to URL: ")).append(s).toString());
                c = com.appnexus.opensdk.m.b(b.a, s);
                if (c && m.j(b.a) != null)
                {
                    m.j(b.a).dismiss();
                }
                return c;
            }

            
            {
                b = m.c.this;
                a = m1;
                super();
                c = false;
            }
        });
    }
}
