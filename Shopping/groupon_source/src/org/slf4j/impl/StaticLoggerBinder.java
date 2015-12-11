// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.impl;

import org.slf4j.ILoggerFactory;

// Referenced classes of package org.slf4j.impl:
//            Log4jLoggerFactory

public class StaticLoggerBinder
{

    public static final StaticLoggerBinder SINGLETON = new StaticLoggerBinder();
    static Class class$org$slf4j$impl$Log4jLoggerFactory;
    private static final String loggerFactoryClassStr;
    private final ILoggerFactory loggerFactory = new Log4jLoggerFactory();

    private StaticLoggerBinder()
    {
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

    public ILoggerFactory getLoggerFactory()
    {
        return loggerFactory;
    }

    public String getLoggerFactoryClassStr()
    {
        return loggerFactoryClassStr;
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
