// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.log;

import com.amazon.device.analytics.configuration.ConfigurationChangedListener;
import com.amazon.device.analytics.log.appenders.LogAppender;
import com.amazon.device.analytics.util.StringUtil;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.amazon.device.analytics.log:
//            LoggerBuilder, Logging

public class Logger
    implements ConfigurationChangedListener
{

    private Logging.LogLevel classLevel;
    private Class cls;
    private Logging.LogLevel globalLevel;
    private String tag;

    public Logger(LoggerBuilder loggerbuilder)
    {
        classLevel = null;
        globalLevel = Logging.LogLevel.OFF;
        cls = null;
        tag = "TailwindAnalyticsSDK";
        if (loggerbuilder != null)
        {
            globalLevel = loggerbuilder.getGlobalLogLevel();
            cls = loggerbuilder.getLogClass();
            tag = loggerbuilder.getTag();
        }
    }

    private String buildMessage(String s)
    {
        String s2;
        StackTraceElement astacktraceelement[];
        int j;
        int l;
        int i1;
        int j1;
        if (getLogClass() == null)
        {
            return s;
        }
        astacktraceelement = Thread.currentThread().getStackTrace();
        s2 = null;
        j = 0;
        i1 = 0;
        j1 = astacktraceelement.length;
        l = 0;
_L7:
        String s1;
        int k;
        k = j;
        s1 = s2;
        if (l >= j1) goto _L2; else goto _L1
_L1:
        StackTraceElement stacktraceelement = astacktraceelement[l];
        if (i1 == 0) goto _L4; else goto _L3
_L3:
        k = j;
        s1 = s2;
        if (stacktraceelement.getClassName().equals(getLogClass().getName()))
        {
            s1 = stacktraceelement.getMethodName();
            k = stacktraceelement.getLineNumber();
        }
_L2:
        boolean flag;
        if (s1 != null)
        {
            return (new StringBuilder()).append(getLogClass().getName()).append("#").append(s1).append("(").append(k).append("): ").append(s).toString();
        } else
        {
            return (new StringBuilder()).append(getLogClass().getName()).append(": ").append(s).toString();
        }
_L4:
        k = i1;
        s1 = s2;
        if (!stacktraceelement.getClassName().equals(getLogClass().getName()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
        s2 = stacktraceelement.getMethodName();
        i1 = stacktraceelement.getLineNumber();
        k = ((flag) ? 1 : 0);
        j = i1;
        s1 = s2;
        if (s2.equals("v"))
        {
            break; /* Loop/switch isn't completed */
        }
        k = ((flag) ? 1 : 0);
        j = i1;
        s1 = s2;
        if (s2.equals("d"))
        {
            break; /* Loop/switch isn't completed */
        }
        k = ((flag) ? 1 : 0);
        j = i1;
        s1 = s2;
        if (s2.equals("i"))
        {
            break; /* Loop/switch isn't completed */
        }
        k = ((flag) ? 1 : 0);
        j = i1;
        s1 = s2;
        if (s2.equals("w"))
        {
            break; /* Loop/switch isn't completed */
        }
        k = ((flag) ? 1 : 0);
        j = i1;
        s1 = s2;
        if (s2.equals("e"))
        {
            break; /* Loop/switch isn't completed */
        }
        k = i1;
        s1 = s2;
        if (!s2.equals("wtf"))
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = s2;
        j = i1;
        k = ((flag) ? 1 : 0);
        break; /* Loop/switch isn't completed */
        if (true) goto _L2; else goto _L5
_L5:
        l++;
        i1 = k;
        s2 = s1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static String getLogLevelConfigurationKey(Class class1)
    {
        if (class1 != null)
        {
            return StringUtil.ionEscape((new StringBuilder()).append(class1.getName()).append(".logLevel").toString());
        } else
        {
            return "loglevel";
        }
    }

    public void d(String s)
    {
        if (isLoggingEnabled(Logging.LogLevel.DEBUG))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).d(getTag(), buildMessage(s))) { }
        }
    }

    public void d(String s, Throwable throwable)
    {
        if (isLoggingEnabled(Logging.LogLevel.DEBUG))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).d(getTag(), buildMessage(s), throwable)) { }
        }
    }

    public void e(String s)
    {
        if (isLoggingEnabled(Logging.LogLevel.ERROR))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).e(tag, buildMessage(s))) { }
        }
    }

    public void e(String s, Throwable throwable)
    {
        if (isLoggingEnabled(Logging.LogLevel.ERROR))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).e(tag, buildMessage(s), throwable)) { }
        }
    }

    Collection getAppenders()
    {
        return Logging.getLogAppenders();
    }

    Class getLogClass()
    {
        return cls;
    }

    Logging.LogLevel getLogLevel()
    {
        this;
        JVM INSTR monitorenter ;
        Logging.LogLevel loglevel = Logging.LogLevel.OFF;
        if (classLevel == null) goto _L2; else goto _L1
_L1:
        loglevel = classLevel;
_L4:
        this;
        JVM INSTR monitorexit ;
        return loglevel;
_L2:
        if (globalLevel != null)
        {
            loglevel = globalLevel;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    String getTag()
    {
        return tag;
    }

    public void i(String s)
    {
        if (isLoggingEnabled(Logging.LogLevel.INFO))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).i(getTag(), buildMessage(s))) { }
        }
    }

    public boolean isLoggingEnabled(Logging.LogLevel loglevel)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = false;
        int j = loglevel.compareTo(getLogLevel());
        if (j >= 0)
        {
            flag = true;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        loglevel;
        throw loglevel;
    }

    public void onPropertyChanged(String s, Object obj)
    {
        if (!s.equals(getLogLevelConfigurationKey(getLogClass())))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        setLogLevel(Logging.LogLevel.valueOf(obj.toString()));
        return;
        s;
    }

    void setGlobalLogLevel(Logging.LogLevel loglevel)
    {
        this;
        JVM INSTR monitorenter ;
        globalLevel = loglevel;
        this;
        JVM INSTR monitorexit ;
        return;
        loglevel;
        throw loglevel;
    }

    public void setLogLevel(Logging.LogLevel loglevel)
    {
        this;
        JVM INSTR monitorenter ;
        classLevel = loglevel;
        this;
        JVM INSTR monitorexit ;
        return;
        loglevel;
        throw loglevel;
    }

    public void v(String s)
    {
        if (isLoggingEnabled(Logging.LogLevel.VERBOSE))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).v(getTag(), buildMessage(s))) { }
        }
    }

    public void w(String s)
    {
        if (isLoggingEnabled(Logging.LogLevel.WARN))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).w(getTag(), buildMessage(s))) { }
        }
    }

    public void w(String s, Throwable throwable)
    {
        if (isLoggingEnabled(Logging.LogLevel.WARN))
        {
            for (Iterator iterator = getAppenders().iterator(); iterator.hasNext(); ((LogAppender)iterator.next()).w(getTag(), buildMessage(s), throwable)) { }
        }
    }
}
