// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.slot.Slot;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            AdState, AdFailedState, AdPlayingState, AdEndPendingState

public class AdPausedState extends AdState
{

    private static final AdPausedState instance = new AdPausedState();

    public AdPausedState()
    {
    }

    public static AdState Instance()
    {
        return instance;
    }

    public void fail(AdInstance adinstance)
    {
        logger.debug("fail");
        adinstance.state = AdFailedState.Instance();
        adinstance.slot.notifyAdDone(adinstance);
    }

    public void play(AdInstance adinstance)
    {
        logger.debug("play");
        adinstance.state = AdPlayingState.Instance();
        adinstance.onResumePlay();
    }

    public void stop(AdInstance adinstance)
    {
        logger.debug("stop");
        adinstance.state = AdEndPendingState.Instance();
        adinstance.onStopPlay();
    }

    public String toString()
    {
        return "AdPausedState";
    }

}
