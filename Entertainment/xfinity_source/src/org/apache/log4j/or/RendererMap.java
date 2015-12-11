// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.or;

import java.util.Hashtable;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.RendererSupport;

// Referenced classes of package org.apache.log4j.or:
//            DefaultRenderer, ObjectRenderer

public class RendererMap
{

    static Class class$org$apache$log4j$or$ObjectRenderer;
    static ObjectRenderer defaultRenderer = new DefaultRenderer();
    Hashtable map;

    public RendererMap()
    {
        map = new Hashtable();
    }

    public static void addRenderer(RendererSupport renderersupport, String s, String s1)
    {
        LogLog.debug("Rendering class: [" + s1 + "], Rendered class: [" + s + "].");
        Object obj;
        if (class$org$apache$log4j$or$ObjectRenderer == null)
        {
            obj = _mthclass$("org.apache.log4j.or.ObjectRenderer");
            class$org$apache$log4j$or$ObjectRenderer = ((Class) (obj));
        } else
        {
            obj = class$org$apache$log4j$or$ObjectRenderer;
        }
        obj = (ObjectRenderer)OptionConverter.instantiateByClassName(s1, ((Class) (obj)), null);
        if (obj == null)
        {
            LogLog.error("Could not instantiate renderer [" + s1 + "].");
            return;
        }
        try
        {
            renderersupport.setRenderer(Loader.loadClass(s), ((ObjectRenderer) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RendererSupport renderersupport)
        {
            LogLog.error("Could not find class [" + s + "].", renderersupport);
        }
    }

    static Class _mthclass$(String s)
    {
        try
        {
            s = Class.forName(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new NoClassDefFoundError(s.getMessage());
        }
        return s;
    }

    public void clear()
    {
        map.clear();
    }

    public String findAndRender(Object obj)
    {
        if (obj == null)
        {
            return null;
        } else
        {
            return get(obj.getClass()).doRender(obj);
        }
    }

    public ObjectRenderer get(Class class1)
    {
        for (; class1 != null; class1 = class1.getSuperclass())
        {
            ObjectRenderer objectrenderer = (ObjectRenderer)map.get(class1);
            if (objectrenderer != null)
            {
                return objectrenderer;
            }
            objectrenderer = searchInterfaces(class1);
            if (objectrenderer != null)
            {
                return objectrenderer;
            }
        }

        return defaultRenderer;
    }

    public void put(Class class1, ObjectRenderer objectrenderer)
    {
        map.put(class1, objectrenderer);
    }

    ObjectRenderer searchInterfaces(Class class1)
    {
        ObjectRenderer objectrenderer = (ObjectRenderer)map.get(class1);
        if (objectrenderer != null)
        {
            return objectrenderer;
        }
        class1 = class1.getInterfaces();
        for (int i = 0; i < class1.length; i++)
        {
            ObjectRenderer objectrenderer1 = searchInterfaces(class1[i]);
            if (objectrenderer1 != null)
            {
                return objectrenderer1;
            }
        }

        return null;
    }

}
