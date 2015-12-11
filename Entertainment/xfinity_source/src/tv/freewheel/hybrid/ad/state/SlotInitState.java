// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.slot.Slot;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            SlotState, SlotPlayingState

public class SlotInitState extends SlotState
{

    private static final SlotInitState instance = new SlotInitState();

    public SlotInitState()
    {
    }

    public static SlotState Instance()
    {
        return instance;
    }

    public void play(Slot slot)
    {
        logger.debug("play");
        slot.state = SlotPlayingState.Instance();
        slot.onStartPlay();
    }

    public String toString()
    {
        return "SlotInitState";
    }

}
