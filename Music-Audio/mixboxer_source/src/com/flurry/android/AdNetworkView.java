// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            p, AdCreative, FlurryAds, cw

public abstract class AdNetworkView extends p
{

    private final AdCreative iB;

    public AdNetworkView(Context context, AdCreative adcreative)
    {
        super(context, null, null);
        iB = adcreative;
    }

    AdNetworkView(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative)
    {
        super(context, flurryads, cw);
        iB = adcreative;
    }

    public AdCreative getAdCreative()
    {
        return iB;
    }

    public void onAdClicked(Map map)
    {
        super.onEvent("clicked", map);
    }

    public void onAdClosed(Map map)
    {
        super.onEvent("adClosed", map);
    }

    public void onAdFilled(Map map)
    {
        super.onEvent("filled", map);
    }

    public void onAdShown(Map map)
    {
        super.onEvent("rendered", map);
    }

    public void onAdUnFilled(Map map)
    {
        super.onEvent("unfilled", map);
    }

    public void onRenderFailed(Map map)
    {
        super.onEvent("renderFailed", map);
    }

    public volatile void stop()
    {
        super.stop();
    }
}
