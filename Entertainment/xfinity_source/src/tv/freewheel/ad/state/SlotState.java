// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.slot.Slot;
import tv.freewheel.utils.Logger;

public class SlotState
{

    protected Logger logger;

    public SlotState()
    {
        logger = Logger.getLogger(this);
    }

    public void complete(Slot slot)
    {
        logger.warn("invalid action: complete");
    }

    public void play(Slot slot)
    {
        logger.warn("invalid action: play");
    }

    public void resume(Slot slot)
    {
        logger.warn("invalid action: resume");
    }

    public void stop(Slot slot)
    {
        logger.warn("invalid action: stop");
    }

    public String toString()
    {
        return "SlotState";
    }
}
