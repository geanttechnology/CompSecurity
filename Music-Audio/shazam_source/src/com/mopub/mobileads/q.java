// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.a.a;
import com.mopub.common.d.f;
import com.mopub.common.n;
import com.mopub.common.o;
import java.util.EnumSet;

// Referenced classes of package com.mopub.mobileads:
//            f, r, s

public final class q extends WebViewClient
{

    private final EnumSet a;
    private final Context b;
    private r c;
    private com.mopub.mobileads.f d;
    private final String e;
    private final String f;

    public q(r r, com.mopub.mobileads.f f1, String s, String s1)
    {
        a = EnumSet.of(n.a, new n[] {
            n.b, n.c, n.e, n.d, n.f, n.g, n.h, n.i
        });
        c = r;
        d = f1;
        e = s;
        f = s1;
        b = f1.getContext();
    }

    static com.mopub.mobileads.f a(q q1)
    {
        return q1.d;
    }

    static r b(q q1)
    {
        return q1.c;
    }

    public final void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (f == null || !s.startsWith(f))
        {
            break MISSING_BLOCK_LABEL_43;
        }
        webview.stopLoading();
        if (!d.a)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        com.mopub.common.d.f.a(b, Uri.parse(s));
        return;
        webview;
        com.mopub.common.c.a.b(webview.getMessage());
        return;
        com.mopub.common.c.a.b("Attempted to redirect without user interaction");
        return;
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = (new com.mopub.common.o.a()).a(a);
        webview.a = new com.mopub.common.o.c() {

            final q a;

            public final void a(String s1, n n1)
            {
                if (com.mopub.mobileads.q.a(a).a)
                {
                    q.b(a).b();
                    com.mopub.mobileads.q.a(a).a = false;
                }
            }

            
            {
                a = q.this;
                super();
            }
        };
        webview.b = new com.mopub.common.o.b() {

            final q a;

            public final void a()
            {
                q.b(a).a();
            }

            public final void b()
            {
                q.b(a).a(s.q);
            }

            
            {
                a = q.this;
                super();
            }
        };
        webview.a().a(b, s, d.a);
        return true;
    }
}
