// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.impl;

import org.apache.log4j.Level;
import org.slf4j.ILoggerFactory;
import org.slf4j.helpers.Util;

// Referenced classes of package org.slf4j.impl:
//            Log4jLoggerFactory

public class StaticLoggerBinder
{

    public static String REQUESTED_API_VERSION = "1.6";
    private static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
    static Class class$org$slf4j$impl$Log4jLoggerFactory;
    private static final String loggerFactoryClassStr;
    private final ILoggerFactory loggerFactory = new Log4jLoggerFactory();

    private StaticLoggerBinder()
    {
        try
        {
            Level level = Level.TRACE;
            return;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            Util.report("This version of SLF4J requires log4j version 1.2.12 or later. See also http://www.slf4j.org/codes.html#log4j_version");
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

    public static final StaticLoggerBinder getSingleton()
    {
        return SINGLETON;
    }

    public ILoggerFactory getLoggerFactory()
    {
        return loggerFactory;
    }

    static 
    {
        Class class1;
        if (class$org$slf4j$impl$Log4jLoggerFactory == null)
        {
            class1 = _mthclass$("org.slf4j.impl.Log4jLoggerFactory");
            class$org$slf4j$impl$Log4jLoggerFactory = class1;
        } else
        {
            class1 = class$org$slf4j$impl$Log4jLoggerFactory;
        }
        loggerFactoryClassStr = class1.getName();
    }
}
