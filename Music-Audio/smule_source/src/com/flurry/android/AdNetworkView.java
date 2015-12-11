// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import com.flurry.sdk.aw;
import com.flurry.sdk.ec;
import com.flurry.sdk.r;
import java.util.Map;

// Referenced classes of package com.flurry.android:
//            AdCreative

public abstract class AdNetworkView extends ec
{

    private final AdCreative a;

    public AdNetworkView(Context context, AdCreative adcreative)
    {
        super(context, null, null);
        a = adcreative;
    }

    public AdNetworkView(Context context, r r, AdCreative adcreative)
    {
        super(context, r, null);
        a = adcreative;
    }

    public AdCreative getAdCreative()
    {
        return a;
    }

    public void onAdClicked(Map map)
    {
        super.onEvent(aw.h, map);
    }

    public void onAdClosed(Map map)
    {
        super.onEvent(aw.t, map);
    }

    public void onAdFilled(Map map)
    {
        super.onEvent(aw.d, map);
    }

    public void onAdPrepared(Map map)
    {
        super.onEvent(aw.K, map);
    }

    public void onAdShown(Map map)
    {
        super.onEvent(aw.f, map);
    }

    public void onAdUnFilled(Map map)
    {
        super.onEvent(aw.e, map);
    }

    public void onRenderFailed(Map map)
    {
        super.onEvent(aw.g, map);
    }
}
