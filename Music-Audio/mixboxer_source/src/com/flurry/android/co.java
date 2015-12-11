// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;

// Referenced classes of package com.flurry.android:
//            ft, fd, AdUnit, FlurryAds, 
//            dv, dt, ds

final class co extends WebChromeClient
{

    final ft dp;

    co(ft ft1)
    {
        this(ft1, (byte)0);
    }

    private co(ft ft1, byte byte0)
    {
        dp = ft1;
        super();
    }

    public final void onHideCustomView()
    {
        while (ft.n(dp) == null || ft.o(dp) == null) 
        {
            return;
        }
        if (ft.s(dp) != null)
        {
            ft.s(dp).show();
        }
        ((ViewGroup)ft.n(dp).getWindow().getDecorView()).removeView(ft.q(dp));
        ft.q(dp).removeView(ft.o(dp));
        if (ft.r(dp) != null && ft.r(dp).isShowing())
        {
            ft.r(dp).hide();
            ft.r(dp).setOnDismissListener(null);
            ft.r(dp).dismiss();
        }
        ft.a(dp, null);
        fd.a(ft.n(dp), ft.t(dp));
        ft.u(dp).onCustomViewHidden();
        ft.a(dp, null);
        ft.a(dp, null);
        ft.a(dp, null);
        dp.R.onCloseFullScreen(ft.m(dp), dp.T.getAdSpace().toString());
    }

    public final void onShowCustomView(View view, int i, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        if (ft.n(dp) == null)
        {
            return;
        }
        if (ft.o(dp) != null && ft.p(dp) != null)
        {
            ft.p(dp).onHideCustomView();
            return;
        }
        ft.a(dp, view);
        ft.a(dp, ft.n(dp).getRequestedOrientation());
        ft.a(dp, customviewcallback);
        ft.a(dp, new FrameLayout(ft.m(dp)));
        ft.q(dp).setBackgroundColor(0xff000000);
        ft.q(dp).addView(ft.o(dp), new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        ((ViewGroup)ft.n(dp).getWindow().getDecorView()).addView(ft.q(dp), -1, -1);
        if (ft.r(dp) == null)
        {
            ft.a(dp, new dv(this, ft.m(dp), 0x1030011));
            ft.r(dp).getWindow().setType(1000);
            ft.r(dp).setOnShowListener(new dt(this));
            ft.r(dp).setOnDismissListener(new ds(this));
            ft.r(dp).setCancelable(true);
            ft.r(dp).show();
        }
        fd.a(ft.n(dp), i, true);
        dp.R.onOpenFullScreen(ft.m(dp), dp.T.getAdSpace().toString());
    }

    public final void onShowCustomView(View view, android.webkit.WebChromeClient.CustomViewCallback customviewcallback)
    {
        if (ft.n(dp) == null)
        {
            return;
        } else
        {
            onShowCustomView(view, ft.n(dp).getRequestedOrientation(), customviewcallback);
            return;
        }
    }
}
