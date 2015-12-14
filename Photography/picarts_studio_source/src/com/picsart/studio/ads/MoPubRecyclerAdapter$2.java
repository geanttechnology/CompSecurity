// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads;

import com.mopub.nativeads.MoPubNativeAdLoadedListener;

// Referenced classes of package com.picsart.studio.ads:
//            MoPubRecyclerAdapter

final class a
    implements MoPubNativeAdLoadedListener
{

    private MoPubRecyclerAdapter a;

    public final void onAdLoaded(int i)
    {
        a.handleAdLoaded(MoPubRecyclerAdapter.access$200(a) + i);
    }

    public final void onAdRemoved(int i)
    {
        a.handleAdRemoved(MoPubRecyclerAdapter.access$200(a) + i);
    }

    r(MoPubRecyclerAdapter mopubrecycleradapter)
    {
        a = mopubrecycleradapter;
        super();
    }
}
