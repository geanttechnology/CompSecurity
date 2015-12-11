// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.state;

import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.renderers.interfaces.IRenderer;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad.state:
//            RendererState

public class RendererStoppedState extends RendererState
{

    private static final RendererStoppedState instance = new RendererStoppedState();

    public RendererStoppedState()
    {
    }

    public static RendererState Instance()
    {
        return instance;
    }

    public void dispose(AdInstance adinstance)
    {
        logger.debug("dispose");
        adinstance.renderer.dispose();
        adinstance.renderer = null;
    }

}
