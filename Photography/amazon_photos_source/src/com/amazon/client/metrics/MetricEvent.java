// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.List;

public interface MetricEvent
{

    public abstract void addCounter(String s, double d);

    public abstract void addString(String s, String s1);

    public abstract void addTimer(String s, double d);

    public abstract void clear();

    public abstract List getAsDataPoints();

    public abstract String getProgram();

    public abstract String getSource();

    public abstract boolean hasDataPoints();

    public abstract void incrementCounter(String s, double d);

    public abstract void startTimer(String s);

    public abstract void stopTimer(String s);
}
