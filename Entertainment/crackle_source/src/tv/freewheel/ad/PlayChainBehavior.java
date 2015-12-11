// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import tv.freewheel.ad.state.AdEndedState;
import tv.freewheel.ad.state.AdFailedState;
import tv.freewheel.ad.state.AdState;
import tv.freewheel.ad.state.SlotPlayingState;
import tv.freewheel.ad.state.SlotState;

// Referenced classes of package tv.freewheel.ad:
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
