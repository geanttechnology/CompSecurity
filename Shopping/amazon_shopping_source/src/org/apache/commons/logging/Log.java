// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;


public interface Log
{

    public abstract void debug(Object obj);

    public abstract void debug(Object obj, Throwable throwable);

    public abstract void error(Object obj, Throwable throwable);

    public abstract void info(Object obj);

    public abstract boolean isDebugEnabled();

    public abstract boolean isErrorEnabled();

    public abstract boolean isWarnEnabled();

    public abstract void trace(Object obj);

    public abstract void warn(Object obj);

    public abstract void warn(Object obj, Throwable throwable);
}
