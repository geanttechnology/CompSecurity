// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.utils.Logger;

public class RendererState
{

    protected Logger logger;

    public RendererState()
    {
        logger = Logger.getLogger(this);
    }

    public void dispose(AdInstance adinstance)
    {
        onErrorAction("dispose");
    }

    public void fail(AdInstance adinstance)
    {
        onErrorAction("fail");
    }

    public void load(AdInstance adinstance)
    {
        onErrorAction("load");
    }

    public void notifyLoaded(AdInstance adinstance, IEvent ievent)
    {
        onErrorAction("notifyLoaded");
    }

    public void notifyStarted(AdInstance adinstance, IEvent ievent)
    {
        onErrorAction("notifyStarted");
    }

    public void notifyStopped(AdInstance adinstance, IEvent ievent)
    {
        onErrorAction("notifyStopped");
    }

    protected void onErrorAction(String s)
    {
        logger.warn((new StringBuilder()).append("invalid action ").append(s).toString());
    }

    public void start(AdInstance adinstance)
    {
        onErrorAction("start");
    }

    public void stop(AdInstance adinstance)
    {
        onErrorAction("stop");
    }
}
