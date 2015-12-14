// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            InMobiBanner, InMobiAdRequestStatus

public static interface 
{

    public abstract void onAdDismissed(InMobiBanner inmobibanner);

    public abstract void onAdDisplayed(InMobiBanner inmobibanner);

    public abstract void onAdInteraction(InMobiBanner inmobibanner, Map map);

    public abstract void onAdLoadFailed(InMobiBanner inmobibanner, InMobiAdRequestStatus inmobiadrequeststatus);

    public abstract void onAdLoadSucceeded(InMobiBanner inmobibanner);

    public abstract void onAdRewardActionCompleted(InMobiBanner inmobibanner, Map map);

    public abstract void onUserLeftApplication(InMobiBanner inmobibanner);
}
