// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.renderers.interfaces.IRenderer;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            RendererState, RendererFailedState, RendererStoppedState

public class RendererStopPendingState extends RendererState
{

    private static final RendererStopPendingState instance = new RendererStopPendingState();

    public RendererStopPendingState()
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
        adinstance.rendererState = RendererStoppedState.Instance();
        adinstance.onRendererStopped(ievent);
    }

}
