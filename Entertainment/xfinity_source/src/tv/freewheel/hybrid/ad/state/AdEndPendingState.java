// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.ad.slot.Slot;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            AdState, AdEndedState, AdFailedState

public class AdEndPendingState extends AdState
{

    private static final AdEndPendingState instance = new AdEndPendingState();

    public AdEndPendingState()
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

    public String toString()
    {
        return "AdEndPendingState";
    }

}
