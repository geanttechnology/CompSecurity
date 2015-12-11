// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Ad, AdData, IAdLoaderCallback

interface AdWrapper
{

    public abstract Ad getAd();

    public abstract AdData getAdData();

    public abstract IAdLoaderCallback getAdLoaderCallback();

    public abstract int prepareAd(AdLoader.AdReadyToLoadListener adreadytoloadlistener);
}
