// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.impl;

import com.amazon.insights.InsightsOptions;

public class DefaultInsightsOptions
    implements InsightsOptions
{

    private final boolean allowEventCollection;
    private final boolean allowWANDelivery;

    public DefaultInsightsOptions(boolean flag, boolean flag1)
    {
        allowEventCollection = flag;
        allowWANDelivery = flag1;
    }

    public boolean getAllowEventCollection()
    {
        return allowEventCollection;
    }

    public boolean getAllowWANDelivery()
    {
        return allowWANDelivery;
    }
}
