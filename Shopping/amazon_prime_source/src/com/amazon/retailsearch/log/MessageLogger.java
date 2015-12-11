// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.log;


public interface MessageLogger
{

    public abstract void debug(String s);

    public abstract void debug(String s, Throwable throwable);

    public abstract boolean enabled();

    public abstract boolean enabled(int i);

    public abstract void error(String s);

    public abstract void error(String s, Throwable throwable);

    public abstract String getTag();

    public abstract void info(String s);

    public abstract void info(String s, Throwable throwable);

    public abstract void log(int i, String s);

    public abstract void log(int i, String s, Throwable throwable);

    public abstract void verbose(String s);

    public abstract void verbose(String s, Throwable throwable);

    public abstract void warn(String s);

    public abstract void warn(String s, Throwable throwable);
}
