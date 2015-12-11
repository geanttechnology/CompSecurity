// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.logging;


public interface AgentLog
{

    public abstract void debug(String s);

    public abstract void error(String s);

    public abstract void error(String s, Throwable throwable);

    public abstract void info(String s);

    public abstract void verbose(String s);

    public abstract void warning(String s);
}
