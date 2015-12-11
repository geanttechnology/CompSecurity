// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.slot.Slot;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            AdState, AdEndedState, AdFailedState, AdPausedState, 
//            AdEndPendingState

public class AdPlayingState extends AdState
{

    private static final AdPlayingState instance = new AdPlayingState();

    public AdPlayingState()
    {
    }

    public static AdState Instance()
    {
        return instance;
    }

    public void complete(AdInstance adinstance)
    {
        logger.debug("complete");
        adinstance.state = AdEndedState.Instance();
        adinstance.slot.notifyAdDone(adinstance);
    }

    public void fail(AdInstance adinstance)
    {
        logger.debug("fail");
        adinstance.state = AdFailedState.Instance();
        adinstance.slot.notifyAdDone(adinstance);
    }

    public void pause(AdInstance adinstance)
    {
        logger.debug("pause");
        adinstance.state = AdPausedState.Instance();
        adinstance.onPausePlay();
    }

    public void stop(AdInstance adinstance)
    {
        logger.debug("stop");
        adinstance.state = AdEndPendingState.Instance();
        adinstance.onStopPlay();
    }

    public String toString()
    {
        return "AdPlayingState";
    }

}
