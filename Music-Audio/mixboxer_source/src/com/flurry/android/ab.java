// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.view.View;
import android.webkit.WebChromeClient;

// Referenced classes of package com.flurry.android:
//            cf, aq, bo, FlurryFullscreenTakeoverActivity

final class ab extends WebChromeClient
{

    private cf bR;

    ab(cf cf1)
    {
        this(cf1, (byte)0);
    }

    private ab(cf cf1, byte byte0)
    {
        bR = cf1;
        super();
    }

    public final void onHideCustomView()
    {
        if (cf.d(bR) != null)
        {
            cf.d(bR).U();
        }
        cf.b(bR, false);
    }

    public final void onShowCustomView(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        cf.b(bR, true);
        if (cf.d(bR) != null)
        {
            cf.d(bR).a(bR, view, i, new bo(customviewcallback));
        }
    }

    public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        cf.b(bR, true);
        if (cf.d(bR) != null)
        {
            aq aq1 = cf.d(bR);
            cf cf1 = bR;
            customviewcallback = new bo(customviewcallback);
            aq1.a(cf1, view, aq1.u.getRequestedOrientation(), customviewcallback);
        }
    }
}
