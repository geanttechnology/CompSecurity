// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubStreamAdPlacer

class this._cls0
    implements eListener
{

    final MoPubStreamAdPlacer this$0;

    public void onAdsAvailable()
    {
        handleAdsAvailable();
    }

    eListener()
    {
        this$0 = MoPubStreamAdPlacer.this;
        super();
    }
}
