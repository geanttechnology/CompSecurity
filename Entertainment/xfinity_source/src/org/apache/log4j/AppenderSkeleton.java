// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OnlyOnceErrorHandler;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

// Referenced classes of package org.apache.log4j:
//            Appender, Priority, Layout

public abstract class AppenderSkeleton
    implements Appender, OptionHandler
{

    protected boolean closed;
    protected ErrorHandler errorHandler;
    protected Filter headFilter;
    protected Layout layout;
    protected String name;
    protected Filter tailFilter;
    protected Priority threshold;

    public AppenderSkeleton()
    {
        errorHandler = new OnlyOnceErrorHandler();
        closed = false;
    }

    public void activateOptions()
    {
    }

    public void addFilter(Filter filter)
    {
        if (headFilter == null)
        {
            tailFilter = filter;
            headFilter = filter;
            return;
        } else
        {
            tailFilter.setNext(filter);
            tailFilter = filter;
            return;
        }
    }

    protected abstract void append(LoggingEvent loggingevent);

    public void doAppend(LoggingEvent loggingevent)
    {
        this;
        JVM INSTR monitorenter ;
        if (!closed) goto _L2; else goto _L1
_L1:
        LogLog.error("Attempted to append to closed appender named [" + name + "].");
_L10:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Filter filter;
        if (!isAsSevereAsThreshold(loggingevent.getLevel()))
        {
            continue; /* Loop/switch isn't completed */
        }
        filter = headFilter;
_L8:
        if (filter == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        filter.decide(loggingevent);
        JVM INSTR tableswitch -1 1: default 113
    //                   -1 39
    //                   0 92
    //                   1 100;
           goto _L3 _L4 _L5 _L6
_L3:
        if (true) goto _L8; else goto _L7
_L7:
_L6:
        break MISSING_BLOCK_LABEL_100;
_L4:
        continue; /* Loop/switch isn't completed */
_L5:
        filter = filter.getNext();
          goto _L8
        append(loggingevent);
        if (true) goto _L10; else goto _L9
_L9:
        loggingevent;
        throw loggingevent;
    }

    public void finalize()
    {
        if (closed)
        {
            return;
        } else
        {
            LogLog.debug("Finalizing appender named [" + name + "].");
            close();
            return;
        }
    }

    public Layout getLayout()
    {
        return layout;
    }

    public final String getName()
    {
        return name;
    }

    public boolean isAsSevereAsThreshold(Priority priority)
    {
        return threshold == null || priority.isGreaterOrEqual(threshold);
    }

    public void setErrorHandler(ErrorHandler errorhandler)
    {
        this;
        JVM INSTR monitorenter ;
        if (errorhandler != null) goto _L2; else goto _L1
_L1:
        LogLog.warn("You have tried to set a null error-handler.");
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        errorHandler = errorhandler;
        if (true) goto _L4; else goto _L3
_L3:
        errorhandler;
        throw errorhandler;
    }

    public void setLayout(Layout layout1)
    {
        layout = layout1;
    }

    public void setName(String s)
    {
        name = s;
    }
}
