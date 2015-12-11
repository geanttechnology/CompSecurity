// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.impl;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

// Referenced classes of package org.slf4j.impl:
//            Log4jLoggerAdapter

public class Log4jLoggerFactory
    implements ILoggerFactory
{

    Map loggerMap;

    public Log4jLoggerFactory()
    {
        loggerMap = new HashMap();
    }

    public Logger getLogger(String s)
    {
        this;
        JVM INSTR monitorenter ;
        Logger logger = (Logger)loggerMap.get(s);
        Object obj = logger;
        if (logger != null) goto _L2; else goto _L1
_L1:
        if (!s.equalsIgnoreCase("ROOT"))
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj = LogManager.getRootLogger();
_L3:
        obj = new Log4jLoggerAdapter(((org.apache.log4j.Logger) (obj)));
        loggerMap.put(s, obj);
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((Logger) (obj));
        obj = LogManager.getLogger(s);
          goto _L3
_L5:
        this;
        JVM INSTR monitorexit ;
        throw s;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
