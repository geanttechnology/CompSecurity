// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.spi;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.or.RendererMap;

// Referenced classes of package org.apache.log4j.spi:
//            ThrowableInformation, LocationInfo, RendererSupport

public class LoggingEvent
    implements Serializable
{

    static final Integer PARAM_ARRAY[] = new Integer[1];
    static final Class TO_LEVEL_PARAMS[];
    static Class class$org$apache$log4j$Level;
    static final Hashtable methodCache = new Hashtable(3);
    private static long startTime = System.currentTimeMillis();
    public final String categoryName;
    public final transient String fqnOfCategoryClass;
    public transient Priority level;
    private LocationInfo locationInfo;
    private transient Category logger;
    private Hashtable mdcCopy;
    private boolean mdcCopyLookupRequired;
    private transient Object message;
    private String ndc;
    private boolean ndcLookupRequired;
    private String renderedMessage;
    private String threadName;
    private ThrowableInformation throwableInfo;
    public final long timeStamp = System.currentTimeMillis();

    public LoggingEvent(String s, Category category, Priority priority, Object obj, Throwable throwable)
    {
        ndcLookupRequired = true;
        mdcCopyLookupRequired = true;
        fqnOfCategoryClass = s;
        logger = category;
        categoryName = category.getName();
        level = priority;
        message = obj;
        if (throwable != null)
        {
            throwableInfo = new ThrowableInformation(throwable, category);
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

    public static long getStartTime()
    {
        return startTime;
    }

    private void readLevel(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        int i = objectinputstream.readInt();
        String s = (String)objectinputstream.readObject();
        if (s == null)
        {
            Method method;
            try
            {
                level = Level.toLevel(i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectInputStream objectinputstream)
            {
                if ((objectinputstream.getTargetException() instanceof InterruptedException) || (objectinputstream.getTargetException() instanceof InterruptedIOException))
                {
                    Thread.currentThread().interrupt();
                }
                LogLog.warn("Level deserialization failed, reverting to default.", objectinputstream);
                level = Level.toLevel(i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectInputStream objectinputstream)
            {
                LogLog.warn("Level deserialization failed, reverting to default.", objectinputstream);
                level = Level.toLevel(i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectInputStream objectinputstream)
            {
                LogLog.warn("Level deserialization failed, reverting to default.", objectinputstream);
                level = Level.toLevel(i);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ObjectInputStream objectinputstream)
            {
                LogLog.warn("Level deserialization failed, reverting to default.", objectinputstream);
            }
            break MISSING_BLOCK_LABEL_181;
        }
        method = (Method)methodCache.get(s);
        objectinputstream = method;
        if (method != null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        objectinputstream = Loader.loadClass(s).getDeclaredMethod("toLevel", TO_LEVEL_PARAMS);
        methodCache.put(s, objectinputstream);
        PARAM_ARRAY[0] = new Integer(i);
        level = (Level)objectinputstream.invoke(null, PARAM_ARRAY);
        return;
        level = Level.toLevel(i);
        return;
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        objectinputstream.defaultReadObject();
        readLevel(objectinputstream);
        if (locationInfo == null)
        {
            locationInfo = new LocationInfo(null, null);
        }
    }

    private void writeLevel(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeInt(level.toInt());
        Class class2 = level.getClass();
        Class class1;
        if (class$org$apache$log4j$Level == null)
        {
            class1 = _mthclass$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = class1;
        } else
        {
            class1 = class$org$apache$log4j$Level;
        }
        if (class2 == class1)
        {
            objectoutputstream.writeObject(null);
            return;
        } else
        {
            objectoutputstream.writeObject(class2.getName());
            return;
        }
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        getThreadName();
        getRenderedMessage();
        getNDC();
        getMDCCopy();
        getThrowableStrRep();
        objectoutputstream.defaultWriteObject();
        writeLevel(objectoutputstream);
    }

    public Level getLevel()
    {
        return (Level)level;
    }

    public LocationInfo getLocationInformation()
    {
        if (locationInfo == null)
        {
            locationInfo = new LocationInfo(new Throwable(), fqnOfCategoryClass);
        }
        return locationInfo;
    }

    public String getLoggerName()
    {
        return categoryName;
    }

    public Object getMDC(String s)
    {
        if (mdcCopy != null)
        {
            Object obj = mdcCopy.get(s);
            if (obj != null)
            {
                return obj;
            }
        }
        return MDC.get(s);
    }

    public void getMDCCopy()
    {
        if (mdcCopyLookupRequired)
        {
            mdcCopyLookupRequired = false;
            Hashtable hashtable = MDC.getContext();
            if (hashtable != null)
            {
                mdcCopy = (Hashtable)hashtable.clone();
            }
        }
    }

    public String getNDC()
    {
        if (ndcLookupRequired)
        {
            ndcLookupRequired = false;
            ndc = NDC.get();
        }
        return ndc;
    }

    public Map getProperties()
    {
        getMDCCopy();
        Object obj;
        if (mdcCopy == null)
        {
            obj = new HashMap();
        } else
        {
            obj = mdcCopy;
        }
        return Collections.unmodifiableMap(((Map) (obj)));
    }

    public String getRenderedMessage()
    {
        if (renderedMessage == null && message != null)
        {
            if (message instanceof String)
            {
                renderedMessage = (String)message;
            } else
            {
                LoggerRepository loggerrepository = logger.getLoggerRepository();
                if (loggerrepository instanceof RendererSupport)
                {
                    renderedMessage = ((RendererSupport)loggerrepository).getRendererMap().findAndRender(message);
                } else
                {
                    renderedMessage = message.toString();
                }
            }
        }
        return renderedMessage;
    }

    public String getThreadName()
    {
        if (threadName == null)
        {
            threadName = Thread.currentThread().getName();
        }
        return threadName;
    }

    public ThrowableInformation getThrowableInformation()
    {
        return throwableInfo;
    }

    public String[] getThrowableStrRep()
    {
        if (throwableInfo == null)
        {
            return null;
        } else
        {
            return throwableInfo.getThrowableStrRep();
        }
    }

    static 
    {
        TO_LEVEL_PARAMS = (new Class[] {
            Integer.TYPE
        });
    }
}
