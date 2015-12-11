// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            gt, FlurryAds, AdUnit, AdFrame, 
//            AdSpaceLayout, cw

abstract class p extends RelativeLayout
{

    private Context Q;
    FlurryAds R;
    cw S;
    AdUnit T;
    int U;

    p(Context context, FlurryAds flurryads, cw cw)
    {
        super(context);
        Q = context;
        R = flurryads;
        S = cw;
    }

    public abstract void initLayout(Context context);

    final void onEvent(String s, Map map)
    {
        (new StringBuilder()).append("AppSpotBannerView.onEvent ").append(s).toString();
        if (T != null)
        {
            R.onEvent(new gt(s, map, Q, T, S, U), R, 0);
        }
    }

    boolean shouldRotate()
    {
        return !((AdFrame)T.getAdFrames().get(U)).getAdSpaceLayout().getFormat().toString().equals("takeover");
    }

    public void stop()
    {
    }
}
