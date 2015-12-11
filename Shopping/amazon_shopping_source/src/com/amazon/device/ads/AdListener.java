// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            Ad, AdError, AdProperties

public interface AdListener
{

    public abstract void onAdCollapsed(Ad ad);

    public abstract void onAdDismissed(Ad ad);

    public abstract void onAdExpanded(Ad ad);

    public abstract void onAdFailedToLoad(Ad ad, AdError aderror);

    public abstract void onAdLoaded(Ad ad, AdProperties adproperties);
}
