// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import tv.freewheel.hybrid.ad.state.AdEndedState;
import tv.freewheel.hybrid.ad.state.AdFailedState;
import tv.freewheel.hybrid.ad.state.AdState;
import tv.freewheel.hybrid.ad.state.SlotPlayingState;
import tv.freewheel.hybrid.ad.state.SlotState;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            ChainBehavior, AdInstance

public class PlayChainBehavior extends ChainBehavior
{

    public PlayChainBehavior()
    {
    }

    public boolean isChainStopper(AdInstance adinstance)
    {
        return adinstance.imprSent;
    }

    public boolean isDestState(AdState adstate)
    {
        return adstate == AdEndedState.Instance() || adstate == AdFailedState.Instance();
    }

    public SlotState relatedSlotState()
    {
        return SlotPlayingState.Instance();
    }

    public String toString()
    {
        return "PlayChainBehavior";
    }
}
