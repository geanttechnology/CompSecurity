// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.supersonic.mediationsdk.logger:
//            SupersonicLogger, LogListener, ConsoleLogger, ServerLogger

public class SupersonicLoggerManager extends SupersonicLogger
    implements LogListener
{

    private static SupersonicLoggerManager mInstance;
    private final String TAG;
    private ArrayList mLoggers;

    protected SupersonicLoggerManager(String s)
    {
        super(s);
        TAG = getClass().getName();
        mLoggers = new ArrayList();
        initSubLoggers();
    }

    protected SupersonicLoggerManager(String s, int i)
    {
        super(s, i);
        TAG = getClass().getName();
        mLoggers = new ArrayList();
        initSubLoggers();
    }

    private SupersonicLogger findLoggerByName(String s)
    {
        Object obj = null;
        Iterator iterator = mLoggers.iterator();
        SupersonicLogger supersoniclogger;
        do
        {
            supersoniclogger = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            supersoniclogger = (SupersonicLogger)iterator.next();
        } while (!supersoniclogger.getLoggerName().equals(s));
        return supersoniclogger;
    }

    public static SupersonicLoggerManager getLogger()
    {
        com/supersonic/mediationsdk/logger/SupersonicLoggerManager;
        JVM INSTR monitorenter ;
        SupersonicLoggerManager supersonicloggermanager;
        if (mInstance == null)
        {
            mInstance = new SupersonicLoggerManager(com/supersonic/mediationsdk/logger/SupersonicLoggerManager.getSimpleName());
        }
        supersonicloggermanager = mInstance;
        com/supersonic/mediationsdk/logger/SupersonicLoggerManager;
        JVM INSTR monitorexit ;
        return supersonicloggermanager;
        Exception exception;
        exception;
        throw exception;
    }

    public static SupersonicLoggerManager getLogger(int i)
    {
        com/supersonic/mediationsdk/logger/SupersonicLoggerManager;
        JVM INSTR monitorenter ;
        if (mInstance != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        mInstance = new SupersonicLoggerManager(com/supersonic/mediationsdk/logger/SupersonicLoggerManager.getSimpleName());
_L1:
        SupersonicLoggerManager supersonicloggermanager = mInstance;
        com/supersonic/mediationsdk/logger/SupersonicLoggerManager;
        JVM INSTR monitorexit ;
        return supersonicloggermanager;
        mInstance.mDebugLevel = i;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    private void initSubLoggers()
    {
        mLoggers.add(new ConsoleLogger(1));
        mLoggers.add(new ServerLogger(0));
    }

    public void addLogger(SupersonicLogger supersoniclogger)
    {
        mLoggers.add(supersoniclogger);
    }

    public void log(SupersonicLogger.SupersonicTag supersonictag, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = mDebugLevel;
        if (i >= j) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Iterator iterator = mLoggers.iterator();
        while (iterator.hasNext()) 
        {
            SupersonicLogger supersoniclogger = (SupersonicLogger)iterator.next();
            if (supersoniclogger.getDebugLevel() <= i)
            {
                supersoniclogger.log(supersonictag, s, i);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        supersonictag;
        throw supersonictag;
    }

    public void logException(SupersonicLogger.SupersonicTag supersonictag, String s, Throwable throwable)
    {
        this;
        JVM INSTR monitorenter ;
        if (throwable != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        for (throwable = mLoggers.iterator(); throwable.hasNext(); ((SupersonicLogger)throwable.next()).log(supersonictag, s, 3)) { }
        break MISSING_BLOCK_LABEL_84;
        supersonictag;
        throw supersonictag;
        for (Iterator iterator = mLoggers.iterator(); iterator.hasNext(); ((SupersonicLogger)iterator.next()).logException(supersonictag, s, throwable)) { }
        this;
        JVM INSTR monitorexit ;
    }

    public void onLog(SupersonicLogger.SupersonicTag supersonictag, String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        log(supersonictag, s, i);
        this;
        JVM INSTR monitorexit ;
        return;
        supersonictag;
        throw supersonictag;
    }

    public void setLoggerDebugLevel(String s, int i)
    {
        if (s == null)
        {
            return;
        }
        SupersonicLogger supersoniclogger = findLoggerByName(s);
        if (supersoniclogger != null)
        {
            if (i >= 0 && i <= 3)
            {
                log(SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("setLoggerDebugLevel(loggerName:").append(s).append(" ,debugLevel:").append(i).append(")").toString(), 0);
                supersoniclogger.setDebugLevel(i);
                return;
            } else
            {
                mLoggers.remove(supersoniclogger);
                return;
            }
        } else
        {
            log(SupersonicLogger.SupersonicTag.NATIVE, (new StringBuilder()).append("Failed to find logger:setLoggerDebugLevel(loggerName:").append(s).append(" ,debugLevel:").append(i).append(")").toString(), 0);
            return;
        }
    }
}
