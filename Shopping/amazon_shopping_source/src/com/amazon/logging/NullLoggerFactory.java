// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.logging;


// Referenced classes of package com.amazon.logging:
//            LoggerFactory, NullLogger, Logger

public class NullLoggerFactory
    implements LoggerFactory
{

    public NullLoggerFactory()
    {
    }

    public Logger createLogger(Class class1)
    {
        return new NullLogger();
    }

    public Logger createLogger(String s, Class class1)
    {
        return new NullLogger();
    }
}
