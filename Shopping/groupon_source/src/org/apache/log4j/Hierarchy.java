// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import java.util.Hashtable;
import java.util.Vector;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.or.ObjectRenderer;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RendererSupport;

// Referenced classes of package org.apache.log4j:
//            Level, Category, DefaultCategoryFactory, Logger, 
//            CategoryKey, ProvisionNode, Priority, Appender

public class Hierarchy
    implements LoggerRepository, RendererSupport
{

    private LoggerFactory defaultFactory;
    boolean emittedNoAppenderWarning;
    boolean emittedNoResourceBundleWarning;
    Hashtable ht;
    private Vector listeners;
    RendererMap rendererMap;
    Logger root;
    Level threshold;
    int thresholdInt;

    public Hierarchy(Logger logger)
    {
        emittedNoAppenderWarning = false;
        emittedNoResourceBundleWarning = false;
        ht = new Hashtable();
        listeners = new Vector(1);
        root = logger;
        setThreshold(Level.ALL);
        root.setHierarchy(this);
        rendererMap = new RendererMap();
        defaultFactory = new DefaultCategoryFactory();
    }

    private final void updateChildren(ProvisionNode provisionnode, Logger logger)
    {
        int j = provisionnode.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            Logger logger1 = (Logger)provisionnode.elementAt(i);
            if (!((Category) (logger1)).parent.name.startsWith(((Category) (logger)).name))
            {
                logger.parent = ((Category) (logger1)).parent;
                logger1.parent = logger;
            }
            i++;
        } while (true);
    }

    private final void updateParents(Logger logger)
    {
        String s;
        int i;
        boolean flag;
        s = ((Category) (logger)).name;
        i = s.length();
        flag = false;
        i = s.lastIndexOf('.', i - 1);
_L5:
        if (i >= 0) goto _L2; else goto _L1
_L1:
        i = ((flag) ? 1 : 0);
_L6:
        if (i == 0)
        {
            logger.parent = root;
        }
        return;
_L2:
        CategoryKey categorykey;
        Object obj;
        categorykey = new CategoryKey(s.substring(0, i));
        obj = ht.get(categorykey);
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj = new ProvisionNode(logger);
        ht.put(categorykey, obj);
_L7:
        i = s.lastIndexOf('.', i - 1);
          goto _L5
_L4:
label0:
        {
            if (!(obj instanceof Category))
            {
                break label0;
            }
            i = 1;
            logger.parent = (Category)obj;
        }
          goto _L6
        if (obj instanceof ProvisionNode)
        {
            ((ProvisionNode)obj).addElement(logger);
        } else
        {
            (new IllegalStateException("unexpected object type " + obj.getClass() + " in ht.")).printStackTrace();
        }
          goto _L7
    }

    public void emitNoAppenderWarning(Category category)
    {
        if (!emittedNoAppenderWarning)
        {
            LogLog.warn("No appenders could be found for logger (" + category.getName() + ").");
            LogLog.warn("Please initialize the log4j system properly.");
            emittedNoAppenderWarning = true;
        }
    }

    public void fireAddAppenderEvent(Category category, Appender appender)
    {
        if (listeners == null) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        j = listeners.size();
        i = 0;
_L5:
        if (i < j) goto _L3; else goto _L2
_L2:
        return;
_L3:
        ((HierarchyEventListener)listeners.elementAt(i)).addAppenderEvent(category, appender);
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Logger getLogger(String s)
    {
        return getLogger(s, defaultFactory);
    }

    public Logger getLogger(String s, LoggerFactory loggerfactory)
    {
        CategoryKey categorykey = new CategoryKey(s);
        Hashtable hashtable = ht;
        hashtable;
        JVM INSTR monitorenter ;
        Object obj = ht.get(categorykey);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        s = loggerfactory.makeNewLoggerInstance(s);
        s.setHierarchy(this);
        ht.put(categorykey, s);
        updateParents(s);
        hashtable;
        JVM INSTR monitorexit ;
        return s;
        if (!(obj instanceof Logger))
        {
            break MISSING_BLOCK_LABEL_84;
        }
        s = (Logger)obj;
        hashtable;
        JVM INSTR monitorexit ;
        return s;
        if (!(obj instanceof ProvisionNode))
        {
            break MISSING_BLOCK_LABEL_140;
        }
        s = loggerfactory.makeNewLoggerInstance(s);
        s.setHierarchy(this);
        ht.put(categorykey, s);
        updateChildren((ProvisionNode)obj, s);
        updateParents(s);
        return s;
        s;
        throw s;
        hashtable;
        JVM INSTR monitorexit ;
        return null;
    }

    public Logger getRootLogger()
    {
        return root;
    }

    public Level getThreshold()
    {
        return threshold;
    }

    public boolean isDisabled(int i)
    {
        return thresholdInt > i;
    }

    public void setRenderer(Class class1, ObjectRenderer objectrenderer)
    {
        rendererMap.put(class1, objectrenderer);
    }

    public void setThreshold(Level level)
    {
        if (level != null)
        {
            thresholdInt = ((Priority) (level)).level;
            threshold = level;
        }
    }
}
