// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.ad.slot.Slot;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            AdState, AdFailedState, AdLoadedState, AdEndPendingState

public class AdLoadingState extends AdState
{

    private static final AdLoadingState instance = new AdLoadingState();

    public AdLoadingState()
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

    public void notifyAdLoaded(AdInstance adinstance)
    {
        logger.debug("notifyAdLoaded");
        adinstance.state = AdLoadedState.Instance();
    }

    public void notifyRendererModuleLoaded(AdInstance adinstance)
    {
        adinstance.onRendererModuleLoaded();
    }

    public void stop(AdInstance adinstance)
    {
        logger.debug("stop");
        adinstance.state = AdEndPendingState.Instance();
        adinstance.onStopPlay();
    }

    public String toString()
    {
        return "AdLoadingState";
    }

}
