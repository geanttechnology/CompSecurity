// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.nullnull;

import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.renderers.interfaces.IRenderer;
import tv.freewheel.hybrid.renderers.interfaces.IRendererContext;
import tv.freewheel.hybrid.utils.Logger;

public class NullAdRenderer
    implements IRenderer
{

    private IConstants constants;
    protected Logger logger;
    private IRendererContext rendererContext;

    public NullAdRenderer()
    {
        logger = Logger.getLogger(this);
    }

    public void dispose()
    {
        logger.verbose("ignore");
    }

    public void load(IRendererContext irenderercontext)
    {
        logger.debug("NullAdRenderer init");
        rendererContext = irenderercontext;
        constants = rendererContext.getConstants();
        rendererContext.setRendererCapability(constants.EVENT_AD_CLICK(), constants.CAPABILITY_STATUS_OFF());
        rendererContext.dispatchEvent(constants.EVENT_AD_LOADED());
    }

    public void resize()
    {
    }

    public void start()
    {
        logger.debug("start");
        rendererContext.dispatchEvent(constants.EVENT_AD_STARTED());
        try
        {
            Thread.sleep(500L);
        }
        catch (InterruptedException interruptedexception)
        {
            interruptedexception.printStackTrace();
        }
        rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
    }

    public void stop()
    {
        logger.warn("ignore");
    }
}
