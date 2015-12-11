// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            ae, gt, FlurryAds, cw, 
//            AdUnit

abstract class do extends ae
{

    private static final String p = com/flurry/android/do.getSimpleName();

    public do(Context context, FlurryAds flurryads, cw cw, AdUnit adunit)
    {
        super(context, flurryads, cw, adunit);
    }

    private void onEvent(String s, Map map)
    {
        (new StringBuilder()).append("onEvent: ").append(s).toString();
        if (L() != null)
        {
            J().onEvent(new gt(s, map, getContext(), L(), K(), 0), J(), 0);
        }
    }

    public final void onAdClicked(Map map)
    {
        onEvent("clicked", map);
    }

    public final void onAdClosed(Map map)
    {
        onEvent("adClosed", map);
    }

    public final void onAdShown(Map map)
    {
        onEvent("rendered", map);
    }

    public final void onRenderFailed(Map map)
    {
        onEvent("renderFailed", map);
    }

}
