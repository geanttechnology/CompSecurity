// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            AdState, AdLoadingState

public class AdFailedState extends AdState
{

    private static final AdFailedState instance = new AdFailedState();

    public AdFailedState()
    {
    }

    public static AdState Instance()
    {
        return instance;
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

    public String toString()
    {
        return "AdFailedState";
    }

}
