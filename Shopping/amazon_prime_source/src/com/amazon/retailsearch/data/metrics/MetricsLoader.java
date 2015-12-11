// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.metrics;

import java.util.Map;

public interface MetricsLoader
{

    public abstract void clear();

    public abstract Map getLatencyMap();

    public abstract void load();
}
