// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display.results.listeners;

import com.amazon.retailsearch.metrics.SearchMetricsListener;

public interface MetricEventListeners
{

    public abstract void addListener(SearchMetricsListener searchmetricslistener);

    public abstract void removeListener(SearchMetricsListener searchmetricslistener);
}
