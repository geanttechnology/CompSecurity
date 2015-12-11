// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr;


// Referenced classes of package com.intentsoftware.addapptr:
//            Placement

interface PlacementListener
{

    public abstract void fallbackOnResumeFromAd(Placement placement);

    public abstract void onEmptyAdShown(Placement placement);

    public abstract void onPauseForAd(Placement placement);

    public abstract void onPlacementAdLoad(Placement placement);

    public abstract void onPlacementAdLoadFail(Placement placement);

    public abstract void onUserEarnedIncentive(Placement placement);
}
