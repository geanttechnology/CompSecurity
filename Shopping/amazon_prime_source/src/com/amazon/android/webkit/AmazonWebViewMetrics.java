// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import java.util.Map;

public class AmazonWebViewMetrics
{
    public static class Sample
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

        public Sample(double d, int i, String s)
        {
            value = d;
            count = i;
            unit = s;
        }
    }


    private final Map counts;
    private final Map levels;
    private final Map properties;
    private final Map times;

    public AmazonWebViewMetrics(Map map, Map map1, Map map2, Map map3)
    {
        counts = map;
        properties = map1;
        times = map2;
        levels = map3;
    }

    public Map getCounts()
    {
        return counts;
    }

    public Map getLevels()
    {
        return levels;
    }

    public Map getProperties()
    {
        return properties;
    }

    public Map getTimes()
    {
        return times;
    }
}
