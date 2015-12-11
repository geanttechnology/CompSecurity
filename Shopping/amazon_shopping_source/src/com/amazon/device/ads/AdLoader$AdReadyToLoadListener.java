// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.device.ads:
//            AdLoader, AdSlot, AdTargetingOptions, Ad

protected static class timeout
{

    private final AdSlot adSlots[];
    private final AdTargetingOptions requestOptions;
    private final int timeout;
    private final AtomicInteger waitCount;

    public void onAdReady(Ad ad)
    {
        AdLoader.decrementCount(timeout, waitCount, requestOptions, adSlots);
    }

    public transient (int i, AtomicInteger atomicinteger, AdTargetingOptions adtargetingoptions, AdSlot aadslot[])
    {
        waitCount = atomicinteger;
        requestOptions = adtargetingoptions;
        adSlots = aadslot;
        timeout = i;
    }
}
