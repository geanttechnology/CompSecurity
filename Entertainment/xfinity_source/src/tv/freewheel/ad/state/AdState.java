// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.utils.Logger;

public class AdState
{

    protected Logger logger;

    public AdState()
    {
        logger = Logger.getLogger(this);
    }

    public void complete(AdInstance adinstance)
    {
        logger.warn((new StringBuilder()).append(this).append(" ").append(adinstance).append(" invalid action:complete").toString());
    }

    public void fail(AdInstance adinstance)
    {
        logger.warn((new StringBuilder()).append(this).append(" ").append(adinstance).append(" invalid action:fail").toString());
    }

    public void load(AdInstance adinstance)
    {
        logger.warn((new StringBuilder()).append(this).append(" ").append(adinstance).append(" invalid action:load").toString());
    }

    public void notifyAdLoaded(AdInstance adinstance)
    {
        logger.warn((new StringBuilder()).append(this).append(" ").append(adinstance).append(" invalid action:notifyAdLoaded").toString());
    }

    public void notifyRendererModuleLoaded(AdInstance adinstance)
    {
        logger.debug((new StringBuilder()).append(this).append(" ").append(adinstance).append(" invalid action:notifyRendererModuleLoaded").toString());
    }

    public void play(AdInstance adinstance)
    {
        logger.warn((new StringBuilder()).append(this).append(" ").append(adinstance).append(" invalid action:play").toString());
    }

    public void stop(AdInstance adinstance)
    {
        logger.warn((new StringBuilder()).append(this).append(" ").append(adinstance).append(" invalid action:stop").toString());
    }

    public String toString()
    {
        return "AdState";
    }
}
