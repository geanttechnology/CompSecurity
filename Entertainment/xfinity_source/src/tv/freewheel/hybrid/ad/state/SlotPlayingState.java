// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.slot.Slot;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            SlotState, SlotEndedState

public class SlotPlayingState extends SlotState
{

    private static final SlotPlayingState instance = new SlotPlayingState();

    public SlotPlayingState()
    {
    }

    public static SlotState Instance()
    {
        return instance;
    }

    public void complete(Slot slot)
    {
        logger.debug("complete");
        slot.state = SlotEndedState.Instance();
        slot.onComplete();
    }

    public void stop(Slot slot)
    {
        logger.debug("stop");
        slot.state = SlotEndedState.Instance();
        slot.onStopPlay();
    }

    public String toString()
    {
        return "SlotPlayingState";
    }

}
