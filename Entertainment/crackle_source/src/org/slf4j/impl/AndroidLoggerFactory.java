// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.impl;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

// Referenced classes of package org.slf4j.impl:
//            AndroidLogger

public class AndroidLoggerFactory
    implements ILoggerFactory
{

    private final Map a = new HashMap();

    public AndroidLoggerFactory()
    {
    }

    public volatile Logger getLogger(String s)
    {
        return getLogger(s);
    }

    public AndroidLogger getLogger(String s)
    {
        this;
        JVM INSTR monitorenter ;
        AndroidLogger androidlogger1 = (AndroidLogger)a.get(s);
        AndroidLogger androidlogger;
        androidlogger = androidlogger1;
        if (androidlogger1 != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        androidlogger = new AndroidLogger(s);
        a.put(s, androidlogger);
        this;
        JVM INSTR monitorexit ;
        return androidlogger;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }
}
