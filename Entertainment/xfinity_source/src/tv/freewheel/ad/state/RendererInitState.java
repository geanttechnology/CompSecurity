// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.state;

import tv.freewheel.ad.AdInstance;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.ad.state:
//            RendererState, RendererFailedState, RendererLoadPendingState

public class RendererInitState extends RendererState
{

    private static final RendererInitState instance = new RendererInitState();

    public RendererInitState()
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

    public void load(AdInstance adinstance)
    {
        logger.debug("load");
        adinstance.rendererState = RendererLoadPendingState.Instance();
        adinstance.renderer.load(adinstance);
    }

}
