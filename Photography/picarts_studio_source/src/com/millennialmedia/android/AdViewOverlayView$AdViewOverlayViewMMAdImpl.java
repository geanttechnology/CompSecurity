// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            AdViewOverlayView, OverlaySettings, MMLog, MMAdImpl, 
//            BannerExpandedWebViewClient, InterstitialWebViewClient, MMWebViewClient

class er extends er
{

    private AdViewOverlayView k;

    final void a()
    {
        AdViewOverlayView.a(k);
    }

    final boolean b()
    {
        if (k.b.b())
        {
            OverlaySettings overlaysettings = k.b;
            boolean flag;
            if (!overlaysettings.o)
            {
                overlaysettings.o = true;
                flag = false;
            } else
            {
                flag = true;
            }
            if (!flag)
            {
                return true;
            }
        }
        return false;
    }

    final MMWebViewClient c()
    {
        MMLog.b("AdViewOverlayView", (new StringBuilder("Returning a client for user: OverlayWebViewClient, adimpl=")).append(k.e).toString());
        if (k.e.j != 0L || k.b.b())
        {
            return new BannerExpandedWebViewClient(i, new Impl(this));
        } else
        {
            return new InterstitialWebViewClient(i, new Impl(this));
        }
    }

    public Impl(AdViewOverlayView adviewoverlayview, Context context)
    {
        k = adviewoverlayview;
        super(adviewoverlayview, context);
        i = new er(this);
    }
}
