// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j;


public interface Logger
{

    public abstract void debug(String s);

    public abstract void debug(String s, Object obj);

    public abstract void debug(String s, Object obj, Object obj1);

    public abstract void debug(String s, Throwable throwable);

    public abstract void error(String s);

    public abstract void error(String s, Object obj);

    public abstract void error(String s, Object obj, Object obj1);

    public abstract void error(String s, Throwable throwable);

    public abstract void error(String s, Object aobj[]);

    public abstract void info(String s);

    public abstract void info(String s, Object obj);

    public abstract void info(String s, Throwable throwable);

    public abstract void info(String s, Object aobj[]);

    public abstract boolean isDebugEnabled();

    public abstract boolean isTraceEnabled();

    public abstract boolean isWarnEnabled();

    public abstract void trace(String s);

    public abstract void trace(String s, Object obj);

    public abstract void trace(String s, Object obj, Object obj1);

    public abstract void trace(String s, Throwable throwable);

    public abstract void trace(String s, Object aobj[]);

    public abstract void warn(String s);

    public abstract void warn(String s, Object obj);

    public abstract void warn(String s, Object obj, Object obj1);

    public abstract void warn(String s, Throwable throwable);

    public abstract void warn(String s, Object aobj[]);
}
