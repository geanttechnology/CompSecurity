// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.trigger;


public interface TriggerRuleId
{

    public abstract TriggerRuleId append(String s);

    public abstract void markCommonPrefix();

    public abstract void reset();

    public abstract void resetToCommonPrefix();

    public abstract String toString();
}
