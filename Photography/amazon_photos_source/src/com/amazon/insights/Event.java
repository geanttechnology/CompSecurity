// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights;

import java.util.Map;

public interface Event
{

    public abstract void addAttribute(String s, String s1);

    public abstract void addMetric(String s, Number number);

    public abstract Map getAllAttributes();

    public abstract Map getAllMetrics();

    public abstract String getAttribute(String s);

    public abstract String getEventType();

    public abstract boolean hasAttribute(String s);

    public abstract boolean hasMetric(String s);

    public abstract Event withAttribute(String s, String s1);

    public abstract Event withMetric(String s, Number number);
}
