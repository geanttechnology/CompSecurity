// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.rhythm;

import android.os.Bundle;
import java.util.HashMap;
import tv.freewheel.ad.interfaces.IAdInstance;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.ad.interfaces.ICreativeRendition;
import tv.freewheel.renderers.interfaces.IRenderer;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.renderers.rhythm.display.RhythmDisplayRenderer;
import tv.freewheel.renderers.rhythm.display.RhythmTakeoverRenderer;
import tv.freewheel.utils.Logger;

public class RhythmRenderer
    implements IRenderer
{

    private Logger logger;
    private IRenderer worker;

    public RhythmRenderer()
    {
        logger = Logger.getLogger(this);
        logger.info("RhythmRenderer_5.6.0-r6886-1305271003");
    }

    public void dispose()
    {
        logger.info("dispose");
        if (worker != null)
        {
            worker.dispose();
        }
    }

    public double getDuration()
    {
        if (worker != null)
        {
            return worker.getDuration();
        } else
        {
            return -1D;
        }
    }

    public HashMap getModuleInfo()
    {
        return worker.getModuleInfo();
    }

    public double getPlayheadTime()
    {
        if (worker != null)
        {
            return worker.getPlayheadTime();
        } else
        {
            return -1D;
        }
    }

    public void load(IRendererContext irenderercontext)
    {
        logger.info("load");
        Object obj = irenderercontext.getAdInstance().getActiveCreativeRendition().getContentType();
        boolean flag = false;
        if (obj == null || ((String) (obj)).length() == 0)
        {
            flag = true;
        } else
        if (((String) (obj)).equals("external/rhythm-new-media-display"))
        {
            worker = new RhythmDisplayRenderer();
        } else
        if (((String) (obj)).equals("external/rhythm-new-media-takeover"))
        {
            worker = new RhythmTakeoverRenderer();
        } else
        {
            flag = true;
        }
        if (flag)
        {
            worker = null;
            IConstants iconstants = irenderercontext.getConstants();
            Object obj1 = (new StringBuilder()).append("The content type ").append(((String) (obj))).append(" does not match any Rhythm sub render.").toString();
            logger.error((new StringBuilder()).append("failWithError errorCode:").append(iconstants.ERROR_UNKNOWN()).append(", errorMessage:").append(((String) (obj1))).toString());
            obj = new Bundle();
            ((Bundle) (obj)).putString(iconstants.INFO_KEY_ERROR_CODE(), iconstants.ERROR_UNKNOWN());
            ((Bundle) (obj)).putString(iconstants.INFO_KEY_ERROR_INFO(), ((String) (obj1)));
            obj1 = new HashMap();
            ((HashMap) (obj1)).put(iconstants.INFO_KEY_EXTRA_INFO(), obj);
            irenderercontext.dispatchEvent(iconstants.EVENT_ERROR(), ((HashMap) (obj1)));
            return;
        } else
        {
            worker.load(irenderercontext);
            return;
        }
    }

    public void pause()
    {
        logger.info("pause");
        if (worker != null)
        {
            worker.pause();
        }
    }

    public void resize()
    {
    }

    public void resume()
    {
        logger.info("resume");
        if (worker != null)
        {
            worker.resume();
        }
    }

    public void start()
    {
        logger.info("start");
        if (worker != null)
        {
            worker.start();
        }
    }

    public void stop()
    {
        logger.info("stop");
        if (worker != null)
        {
            worker.stop();
        }
    }
}
