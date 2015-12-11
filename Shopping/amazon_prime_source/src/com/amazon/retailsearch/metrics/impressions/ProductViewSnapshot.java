// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics.impressions;


public class ProductViewSnapshot
{

    private final String asin;
    private final float percentVisible;
    private final long timestamp;

    public ProductViewSnapshot(String s, float f, long l)
    {
        asin = s;
        percentVisible = f;
        timestamp = l;
    }

    public String getAsin()
    {
        return asin;
    }

    public float getPercentVisible()
    {
        return percentVisible;
    }

    public long getTimestamp()
    {
        return timestamp;
    }
}
