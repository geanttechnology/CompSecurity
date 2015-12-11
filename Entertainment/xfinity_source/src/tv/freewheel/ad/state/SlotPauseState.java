// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.slot.Slot;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            SlotState, SlotEndedState, SlotPlayingState

public class SlotPauseState extends SlotState
{

    private static final SlotPauseState instance = new SlotPauseState();

    public SlotPauseState()
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

    public void play(Slot slot)
    {
        logger.debug("play");
        resume(slot);
    }

    public void resume(Slot slot)
    {
        logger.debug("resume");
        slot.state = SlotPlayingState.Instance();
        slot.onResumePlay();
    }

    public void stop(Slot slot)
    {
        logger.debug("stop");
        slot.state = SlotEndedState.Instance();
        slot.onStopPlay();
    }

    public String toString()
    {
        return "SlotPauseState";
    }

}
