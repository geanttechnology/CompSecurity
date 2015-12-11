// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.logging;


// Referenced classes of package com.amazon.logging:
//            NullLoggerFactory, LoggerFactory

public abstract class Logger
{

    private static LoggerFactory factory = new NullLoggerFactory();

    public Logger()
    {
    }

    public static Logger getLogger(Class class1)
    {
        return factory.createLogger(class1);
    }

    public static Logger getLogger(String s, Class class1)
    {
        return factory.createLogger(s, class1);
    }

    public static void setLoggerFactory(LoggerFactory loggerfactory)
    {
        factory = loggerfactory;
    }

    public abstract void d(String s);

    public abstract void d(String s, Throwable throwable);

    public transient void d(String s, Object aobj[])
    {
        while (s == null || aobj == null || aobj.length == 0 || !isDebugEnabled()) 
        {
            return;
        }
        d(String.format(s, aobj));
    }

    public abstract void e(String s);

    public abstract void e(String s, Throwable throwable);

    public abstract void i(String s);

    public abstract void i(String s, Throwable throwable);

    public abstract boolean isDebugEnabled();

    public abstract boolean isVerboseEnabled();

    public abstract void v(String s);

    public abstract void v(String s, Throwable throwable);

    public transient void v(String s, Object aobj[])
    {
        while (s == null || aobj == null || aobj.length == 0 || !isVerboseEnabled()) 
        {
            return;
        }
        v(String.format(s, aobj));
    }

    public abstract void w(String s);

    public abstract void w(String s, Throwable throwable);

}
