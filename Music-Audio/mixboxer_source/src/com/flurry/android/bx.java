// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import com.mobclix.android.sdk.MobclixFullScreenAdView;

// Referenced classes of package com.flurry.android:
//            do, aj, FlurryAds, cw, 
//            AdUnit

final class bx extends do
{

    private static final String p = com/flurry/android/bx.getSimpleName();

    public bx(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        super(context, flurryads, cw, adunit);
    }

    static String d()
    {
        return p;
    }

    public final void M()
    {
        MobclixFullScreenAdView mobclixfullscreenadview = new MobclixFullScreenAdView((Activity)getContext());
        mobclixfullscreenadview.addMobclixAdViewListener(new aj(this));
        mobclixfullscreenadview.requestAndDisplayAd();
    }

}
