// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.google.a.a.b.a;
import com.google.a.d;

// Referenced classes of package com.smule.pianoandroid.ads:
//            c

public class FlurryDFPBanner
{

    public FlurryDFPBanner()
    {
    }

    public void destroy()
    {
    }

    public void requestBannerAd(a a, Activity activity, String s, String s1, d d, com.google.a.a.d d1, Object obj)
    {
        s = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(s);
        d = new android.widget.FrameLayout.LayoutParams((int)(320F * ((DisplayMetrics) (s)).density), (int)(((DisplayMetrics) (s)).density * 40F));
        s = new FrameLayout(activity);
        s.setLayoutParams(d);
        activity = new c(activity, s1);
        s.addView(activity, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        activity.a(10000L, a, s);
    }
}
