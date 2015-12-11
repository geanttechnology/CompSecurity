// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j.impl;

import org.slf4j.ILoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

// Referenced classes of package org.slf4j.impl:
//            AndroidLoggerFactory

public class StaticLoggerBinder
    implements LoggerFactoryBinder
{

    public static String REQUESTED_API_VERSION = "1.5.8";
    private static final StaticLoggerBinder a = new StaticLoggerBinder();
    private static final String b = org/slf4j/impl/AndroidLoggerFactory.getName();
    private final ILoggerFactory c = new AndroidLoggerFactory();

    private StaticLoggerBinder()
    {
    }

    public static final StaticLoggerBinder getSingleton()
    {
        return a;
    }

    public ILoggerFactory getLoggerFactory()
    {
        return c;
    }

    public String getLoggerFactoryClassStr()
    {
        return b;
    }

}
