// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.slot.Slot;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            SlotState, SlotPlayingState, SlotPreloadingState

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

    public void preload(Slot slot)
    {
        logger.debug("preload");
        slot.state = SlotPreloadingState.Instance();
        slot.onPreloading();
    }

    public String toString()
    {
        return "SlotInitState";
    }

}
