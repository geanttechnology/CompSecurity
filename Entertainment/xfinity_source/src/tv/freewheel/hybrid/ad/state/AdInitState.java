// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            AdState, AdFailedState, AdLoadingState, AdEndedState

public class AdInitState extends AdState
{

    private static final AdInitState instance = new AdInitState();

    public AdInitState()
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
    }

    public void load(AdInstance adinstance)
    {
        logger.debug("load");
        adinstance.state = AdLoadingState.Instance();
        adinstance.loadRenderer();
    }

    public void play(AdInstance adinstance)
    {
        load(adinstance);
    }

    public void stop(AdInstance adinstance)
    {
        logger.debug("stop");
        adinstance.state = AdEndedState.Instance();
    }

    public String toString()
    {
        return "AdInitState";
    }

}
