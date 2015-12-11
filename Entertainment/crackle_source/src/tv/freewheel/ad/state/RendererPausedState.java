// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            RendererState, RendererFailedState, RendererStopPendingState, RendererStartedState, 
//            RendererStartingState

public class RendererPausedState extends RendererState
{

    private static final RendererPausedState instance = new RendererPausedState();
    public boolean rendererStartedBeforePause;

    public RendererPausedState()
    {
        rendererStartedBeforePause = false;
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

    public void resume(AdInstance adinstance)
    {
        logger.debug("resume");
        if (rendererStartedBeforePause)
        {
            adinstance.rendererState = RendererStartedState.Instance();
        } else
        {
            adinstance.rendererState = RendererStartingState.Instance();
        }
        adinstance.renderer.resume();
    }

    public void stop(AdInstance adinstance)
    {
        logger.debug("stop");
        adinstance.rendererState = RendererStopPendingState.Instance();
        adinstance.renderer.stop();
    }

}
