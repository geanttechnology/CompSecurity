// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubAdRenderer, NativeAd

class NativeAdData
{

    private final MoPubAdRenderer adRenderer;
    private final NativeAd adResponse;
    private final String adUnitId;

    NativeAdData(String s, MoPubAdRenderer mopubadrenderer, NativeAd nativead)
    {
        adUnitId = s;
        adRenderer = mopubadrenderer;
        adResponse = nativead;
    }

    NativeAd getAd()
    {
        return adResponse;
    }

    MoPubAdRenderer getAdRenderer()
    {
        return adRenderer;
    }

    String getAdUnitId()
    {
        return adUnitId;
    }
}
