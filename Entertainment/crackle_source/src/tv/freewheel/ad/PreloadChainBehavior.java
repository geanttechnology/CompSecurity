// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import tv.freewheel.ad.state.AdEndedState;
import tv.freewheel.ad.state.AdFailedState;
import tv.freewheel.ad.state.AdLoadedState;
import tv.freewheel.ad.state.AdState;
import tv.freewheel.ad.state.SlotPreloadingState;
import tv.freewheel.ad.state.SlotState;

// Referenced classes of package tv.freewheel.ad:
//            ChainBehavior, AdInstance

public class PreloadChainBehavior extends ChainBehavior
{

    public PreloadChainBehavior()
    {
    }

    public boolean isChainStopper(AdInstance adinstance)
    {
        return adinstance.imprSent || adinstance.state == AdLoadedState.Instance() && !adinstance.scheduledDrivingAd;
    }

    public boolean isDestState(AdState adstate)
    {
        return adstate == AdEndedState.Instance() || adstate == AdFailedState.Instance() || adstate == AdLoadedState.Instance();
    }

    public SlotState relatedSlotState()
    {
        return SlotPreloadingState.Instance();
    }

    public String toString()
    {
        return "PreloadChainBehavior";
    }
}
