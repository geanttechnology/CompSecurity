// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubNativeAdLoadedListener, MoPubRecyclerAdapter

class this._cls0
    implements MoPubNativeAdLoadedListener
{

    final MoPubRecyclerAdapter this$0;

    public void onAdLoaded(int i)
    {
        handleAdLoaded(i);
    }

    public void onAdRemoved(int i)
    {
        handleAdRemoved(i);
    }

    ener()
    {
        this$0 = MoPubRecyclerAdapter.this;
        super();
    }
}
