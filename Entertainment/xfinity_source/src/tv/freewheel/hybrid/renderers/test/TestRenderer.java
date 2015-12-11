// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.test;

import android.os.Bundle;
import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.renderers.interfaces.IRenderer;
import tv.freewheel.hybrid.renderers.interfaces.IRendererContext;
import tv.freewheel.hybrid.utils.Logger;

public class TestRenderer
    implements IRenderer
{

    private boolean autoLoad;
    private boolean autoPlay;
    private boolean autoStop;
    private boolean canStop;
    private IConstants constants;
    private boolean loadPendingFail;
    protected Logger logger;
    private boolean playFail;
    private boolean playingFail;
    private IRendererContext rendererContext;
    private boolean stopPendingFail;

    public TestRenderer()
    {
        autoStop = false;
        autoLoad = false;
        autoPlay = false;
        loadPendingFail = false;
        playingFail = false;
        playFail = false;
        stopPendingFail = false;
        canStop = false;
        logger = Logger.getLogger(this);
    }

    private void fail()
    {
        Bundle bundle = new Bundle();
        bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
        HashMap hashmap = new HashMap();
        hashmap.put(constants.INFO_KEY_EXTRA_INFO(), bundle);
        rendererContext.dispatchEvent(constants.EVENT_ERROR(), hashmap);
    }

    public void dispose()
    {
    }

    public void load(IRendererContext irenderercontext)
    {
        logger.debug("init");
        rendererContext = irenderercontext;
        constants = rendererContext.getConstants();
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("autoStop")));
        if (irenderercontext != null)
        {
            try
            {
                autoStop = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception)
            {
                autoStop = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("autoStop is ").append(autoStop).toString());
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("autoLoad")));
        if (irenderercontext != null)
        {
            try
            {
                autoLoad = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception1)
            {
                autoLoad = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("autoLoad is ").append(autoLoad).toString());
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("autoPlay")));
        if (irenderercontext != null)
        {
            try
            {
                autoPlay = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception2)
            {
                autoPlay = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("autoPlay is ").append(autoPlay).toString());
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("loadPendingFail")));
        if (irenderercontext != null)
        {
            try
            {
                loadPendingFail = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception3)
            {
                loadPendingFail = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("loadPendingFail is ").append(loadPendingFail).toString());
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("playingFail")));
        if (irenderercontext != null)
        {
            try
            {
                playingFail = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception4)
            {
                playingFail = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("playingFail is ").append(playingFail).toString());
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("playFail")));
        if (irenderercontext != null)
        {
            try
            {
                playFail = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception5)
            {
                playFail = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("playFail is ").append(playFail).toString());
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("canStop")));
        if (irenderercontext != null)
        {
            try
            {
                canStop = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception6)
            {
                canStop = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("canStop is ").append(canStop).toString());
        irenderercontext = ((IRendererContext) (rendererContext.getParameter("stopPendingFail")));
        if (irenderercontext != null)
        {
            try
            {
                stopPendingFail = ((Boolean)irenderercontext).booleanValue();
            }
            catch (Exception exception7)
            {
                stopPendingFail = Boolean.valueOf((String)irenderercontext).booleanValue();
            }
        }
        logger.debug((new StringBuilder()).append("stopPendingFail is ").append(stopPendingFail).toString());
        if (loadPendingFail)
        {
            fail();
        } else
        if (autoLoad)
        {
            rendererContext.dispatchEvent(constants.EVENT_AD_LOADED());
            return;
        }
    }

    public void resize()
    {
    }

    public void start()
    {
        logger.debug("start");
        if (playingFail)
        {
            fail();
        } else
        {
            if (autoPlay)
            {
                rendererContext.dispatchEvent(constants.EVENT_AD_STARTED());
                if (playFail)
                {
                    fail();
                    return;
                }
            }
            if (autoStop)
            {
                try
                {
                    Thread.sleep(3000L);
                }
                catch (InterruptedException interruptedexception)
                {
                    interruptedexception.printStackTrace();
                }
                rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
                return;
            }
        }
    }

    public void stop()
    {
        if (stopPendingFail)
        {
            fail();
        } else
        if (canStop)
        {
            rendererContext.dispatchEvent(constants.EVENT_AD_STOPPED());
            return;
        }
    }
}
