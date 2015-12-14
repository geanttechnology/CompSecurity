// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.configuration;


public interface Configuration
{

    public abstract Boolean optBoolean(String s, Boolean boolean1);

    public abstract Integer optInt(String s, Integer integer);

    public abstract Long optLong(String s, Long long1);

    public abstract String optString(String s, String s1);

    public abstract void refresh();
}
