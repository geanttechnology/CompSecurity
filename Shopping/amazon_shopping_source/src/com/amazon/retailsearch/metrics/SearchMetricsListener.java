// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


public interface SearchMetricsListener
{

    public abstract void onSearchATFReached();

    public abstract void onSearchSRDSCompleted();

    public abstract void onSearchSRDSStarted();

    public abstract void onSearchStarted();
}
