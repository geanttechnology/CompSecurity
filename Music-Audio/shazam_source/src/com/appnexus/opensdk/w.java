// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.appnexus.opensdk.b.b;
import com.appnexus.opensdk.b.l;

// Referenced classes of package com.appnexus.opensdk:
//            k, x

final class w
    implements AdActivity.a
{

    private Activity a;
    private WebView b;
    private x c;

    public w(Activity activity)
    {
        c = null;
        a = activity;
    }

    public final void a()
    {
        if (k.m == null || k.n == null)
        {
            com.appnexus.opensdk.b.b.e(b.b, "Launched MRAID Fullscreen activity with invalid properties");
            a.finish();
        } else
        {
            l.a(k.m);
            a.setContentView(k.m);
            if (k.m.getChildAt(0) instanceof WebView)
            {
                b = (WebView)k.m.getChildAt(0);
            }
            c = k.n;
            c.j = a;
            if (k.o != null)
            {
                k.o.a();
                return;
            }
        }
    }

    public final void b()
    {
        if (c != null)
        {
            c.j = null;
            c.a();
        }
        c = null;
    }

    public final void c()
    {
    }

    public final void d()
    {
    }

    public final WebView e()
    {
        return b;
    }
}
