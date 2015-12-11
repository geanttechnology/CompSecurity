// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.image;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;
import tv.freewheel.renderers.interfaces.IRendererContext;
import tv.freewheel.utils.Logger;

class Parameters
{

    Boolean allowsUpscaling;
    Logger logger;
    Integer marginHeight;
    Integer marginWidth;
    String primaryAnchor;
    Boolean shouldEndAfterDuration;

    public Parameters(IRendererContext irenderercontext)
    {
        logger = Logger.getLogger(this);
        Object obj = irenderercontext.getParameter("renderer.image.primaryAnchor");
        if (obj == null)
        {
            primaryAnchor = "bc";
        } else
        {
            primaryAnchor = obj.toString();
        }
        obj = irenderercontext.getParameter("renderer.image.marginWidth");
        if (obj == null)
        {
            marginWidth = Integer.valueOf(0);
        } else
        {
            try
            {
                marginWidth = Integer.valueOf(Integer.parseInt(obj.toString()));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                marginWidth = Integer.valueOf(0);
            }
        }
        obj = irenderercontext.getParameter("renderer.image.marginHeight");
        if (obj == null)
        {
            marginHeight = Integer.valueOf(0);
        } else
        {
            try
            {
                marginHeight = Integer.valueOf(Integer.parseInt(obj.toString()));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                marginHeight = Integer.valueOf(0);
            }
        }
        obj = irenderercontext.getParameter("renderer.image.allowsUpscaling");
        allowsUpscaling = null;
        if (obj != null)
        {
            obj = obj.toString();
            if (((String) (obj)).equalsIgnoreCase("true") || ((String) (obj)).equalsIgnoreCase("on") || ((String) (obj)).equalsIgnoreCase("yes"))
            {
                allowsUpscaling = Boolean.valueOf(true);
            } else
            if (((String) (obj)).equalsIgnoreCase("false") || ((String) (obj)).equalsIgnoreCase("off") || ((String) (obj)).equalsIgnoreCase("no"))
            {
                allowsUpscaling = Boolean.valueOf(false);
            }
        }
        irenderercontext = ((IRendererContext) (irenderercontext.getParameter("renderer.image.shouldEndAfterDuration")));
        shouldEndAfterDuration = null;
        if (irenderercontext != null)
        {
            irenderercontext = irenderercontext.toString();
            if (irenderercontext.equalsIgnoreCase("true") || irenderercontext.equalsIgnoreCase("on") || irenderercontext.equalsIgnoreCase("yes"))
            {
                shouldEndAfterDuration = Boolean.valueOf(true);
            } else
            if (irenderercontext.equalsIgnoreCase("false") || irenderercontext.equalsIgnoreCase("off") || irenderercontext.equalsIgnoreCase("no"))
            {
                shouldEndAfterDuration = Boolean.valueOf(false);
            }
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
        if (i >= tv/freewheel/renderers/image/Parameters.getDeclaredFields().length)
        {
            break; /* Loop/switch isn't completed */
        }
        field = tv/freewheel/renderers/image/Parameters.getDeclaredFields()[i];
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
