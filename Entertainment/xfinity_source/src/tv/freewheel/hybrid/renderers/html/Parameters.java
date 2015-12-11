// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.renderers.html;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import tv.freewheel.hybrid.renderers.interfaces.IRendererContext;
import tv.freewheel.hybrid.utils.Logger;

class Parameters
{

    String bootstrap;
    Logger logger;
    Integer marginHeight;
    Integer marginWidth;
    String placementType;
    String primaryAnchor;
    Boolean shouldBackgroundTransparent;
    Boolean shouldEndAfterDuration;
    Boolean shouldUseDip;

    public Parameters(IRendererContext irenderercontext)
    {
        logger = Logger.getLogger(this);
        placementType = (String)irenderercontext.getParameter("renderer.html.placementType");
        primaryAnchor = (String)irenderercontext.getParameter("renderer.html.primaryAnchor");
        if (primaryAnchor == null)
        {
            primaryAnchor = "bc";
        }
        Object obj = (String)irenderercontext.getParameter("renderer.html.marginWidth");
        if (obj == null)
        {
            marginWidth = Integer.valueOf(0);
        } else
        {
            try
            {
                marginWidth = Integer.valueOf(Integer.parseInt(((String) (obj))));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                marginWidth = Integer.valueOf(0);
            }
        }
        obj = (String)irenderercontext.getParameter("renderer.html.marginHeight");
        if (obj == null)
        {
            marginHeight = Integer.valueOf(0);
        } else
        {
            try
            {
                marginHeight = Integer.valueOf(Integer.parseInt(((String) (obj))));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                marginHeight = Integer.valueOf(0);
            }
        }
        bootstrap = (String)irenderercontext.getParameter("renderer.html.bootstrap");
        obj = (String)irenderercontext.getParameter("renderer.html.shouldEndAfterDuration");
        shouldEndAfterDuration = null;
        if (obj != null)
        {
            if (((String) (obj)).equalsIgnoreCase("true") || ((String) (obj)).equalsIgnoreCase("on") || ((String) (obj)).equalsIgnoreCase("yes"))
            {
                shouldEndAfterDuration = Boolean.valueOf(true);
            } else
            if (((String) (obj)).equalsIgnoreCase("false") || ((String) (obj)).equalsIgnoreCase("off") || ((String) (obj)).equalsIgnoreCase("no"))
            {
                shouldEndAfterDuration = Boolean.valueOf(false);
            }
        }
        obj = (String)irenderercontext.getParameter("renderer.html.isBackgroundTransparent");
        shouldBackgroundTransparent = null;
        if (obj != null)
        {
            if (((String) (obj)).equalsIgnoreCase("true") || ((String) (obj)).equalsIgnoreCase("on") || ((String) (obj)).equalsIgnoreCase("yes") || ((String) (obj)).equalsIgnoreCase("1"))
            {
                shouldBackgroundTransparent = Boolean.valueOf(true);
            } else
            if (((String) (obj)).equalsIgnoreCase("false") || ((String) (obj)).equalsIgnoreCase("off") || ((String) (obj)).equalsIgnoreCase("no") || ((String) (obj)).equalsIgnoreCase("0"))
            {
                shouldBackgroundTransparent = Boolean.valueOf(false);
            }
        }
        irenderercontext = (String)irenderercontext.getParameter("renderer.html.shouldUseDip");
        shouldUseDip = Boolean.valueOf(false);
        if (irenderercontext != null && (irenderercontext.equalsIgnoreCase("true") || irenderercontext.equalsIgnoreCase("on") || irenderercontext.equalsIgnoreCase("yes") || irenderercontext.equalsIgnoreCase("1")))
        {
            shouldUseDip = Boolean.valueOf(true);
        }
        logger.debug(toJSONString());
    }

    public String toJSONString()
    {
        JSONObject jsonobject;
        int i;
        jsonobject = new JSONObject();
        i = 0;
_L2:
        Field field;
        if (i >= tv/freewheel/hybrid/renderers/html/Parameters.getDeclaredFields().length)
        {
            break; /* Loop/switch isn't completed */
        }
        field = tv/freewheel/hybrid/renderers/html/Parameters.getDeclaredFields()[i];
        if (Modifier.isStatic(field.getModifiers()))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        Object obj1 = field.get(this);
        Object obj = obj1;
        if (obj1 instanceof Calendar)
        {
            obj = ((Calendar)obj1).getTime().toString();
        }
        obj1 = obj;
        if (!(obj instanceof Integer))
        {
            break MISSING_BLOCK_LABEL_105;
        }
        obj1 = obj;
        if (field.getName().contains("Color"))
        {
            obj1 = Integer.toHexString(((Integer)obj).intValue());
        }
        jsonobject.put(field.getName(), obj1);
_L3:
        i++;
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        logger.error(exception.toString());
          goto _L3
_L1:
        return jsonobject.toString();
    }
}
