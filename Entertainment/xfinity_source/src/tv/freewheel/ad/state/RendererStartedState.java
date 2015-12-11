// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            RendererState, RendererFailedState, RendererStopPendingState

public class RendererStartedState extends RendererState
{

    private static final RendererStartedState instance = new RendererStartedState();

    public RendererStartedState()
    {
    }

    public static RendererState Instance()
    {
        return instance;
    }

    public void fail(AdInstance adinstance)
    {
        logger.debug("fail");
        adinstance.rendererState = RendererFailedState.Instance();
        adinstance.renderer.dispose();
        adinstance.renderer = null;
    }

    public void notifyStopped(AdInstance adinstance, IEvent ievent)
    {
        adinstance.rendererState = RendererStopPendingState.Instance();
        adinstance.rendererState.notifyStopped(adinstance, ievent);
    }

    public void stop(AdInstance adinstance)
    {
        logger.debug("stop");
        adinstance.rendererState = RendererStopPendingState.Instance();
        adinstance.renderer.stop();
    }

}
