// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


// Referenced classes of package com.amazon.android.webkit:
//            AmazonWebViewMetrics

public static class unit
{

    private final int count;
    private final String unit;
    private final double value;

    public int getCount()
    {
        return count;
    }

    public String getUnit()
    {
        return unit;
    }

    public double getValue()
    {
        return value;
    }

    public (double d, int i, String s)
    {
        value = d;
        count = i;
        unit = s;
    }
}
