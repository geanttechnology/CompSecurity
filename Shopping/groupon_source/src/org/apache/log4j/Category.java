// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j;

import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

// Referenced classes of package org.apache.log4j:
//            Priority, Level, Appender

public class Category
{

    private static final String FQCN;
    static Class class$org$apache$log4j$Category;
    AppenderAttachableImpl aai;
    protected boolean additive;
    protected volatile Level level;
    protected String name;
    protected volatile Category parent;
    protected LoggerRepository repository;

    protected Category(String s)
    {
        additive = true;
        name = s;
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

    public void addAppender(Appender appender)
    {
        this;
        JVM INSTR monitorenter ;
        if (aai == null)
        {
            aai = new AppenderAttachableImpl();
        }
        aai.addAppender(appender);
        repository.fireAddAppenderEvent(this, appender);
        this;
        JVM INSTR monitorexit ;
        return;
        appender;
        throw appender;
    }

    public void callAppenders(LoggingEvent loggingevent)
    {
        Category category;
        int i;
        i = 0;
        category = this;
_L5:
        if (category != null) goto _L2; else goto _L1
_L1:
        if (i == 0)
        {
            repository.emitNoAppenderWarning(this);
        }
        return;
_L2:
        category;
        JVM INSTR monitorenter ;
        int j = i;
        if (category.aai != null)
        {
            j = i + category.aai.appendLoopOnAppenders(loggingevent);
        }
        if (category.additive)
        {
            break; /* Loop/switch isn't completed */
        }
        category;
        JVM INSTR monitorexit ;
        i = j;
        if (true) goto _L1; else goto _L3
        loggingevent;
        throw loggingevent;
_L3:
        category;
        JVM INSTR monitorexit ;
        category = category.parent;
        i = j;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void forcedLog(String s, Priority priority, Object obj, Throwable throwable)
    {
        callAppenders(new LoggingEvent(s, this, priority, obj, throwable));
    }

    public Level getEffectiveLevel()
    {
        Category category = this;
        do
        {
            if (category == null)
            {
                return null;
            }
            if (category.level != null)
            {
                return category.level;
            }
            category = category.parent;
        } while (true);
    }

    public final Level getLevel()
    {
        return level;
    }

    public final String getName()
    {
        return name;
    }

    public void log(String s, Priority priority, Object obj, Throwable throwable)
    {
        while (repository.isDisabled(priority.level) || !priority.isGreaterOrEqual(getEffectiveLevel())) 
        {
            return;
        }
        forcedLog(s, priority, obj, throwable);
    }

    public void removeAllAppenders()
    {
        this;
        JVM INSTR monitorenter ;
        if (aai != null)
        {
            aai.removeAllAppenders();
            aai = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setAdditivity(boolean flag)
    {
        additive = flag;
    }

    final void setHierarchy(LoggerRepository loggerrepository)
    {
        repository = loggerrepository;
    }

    public void setLevel(Level level1)
    {
        level = level1;
    }

    static 
    {
        Class class1;
        if (class$org$apache$log4j$Category == null)
        {
            class1 = _mthclass$("org.apache.log4j.Category");
            class$org$apache$log4j$Category = class1;
        } else
        {
            class1 = class$org$apache$log4j$Category;
        }
        FQCN = class1.getName();
    }
}
