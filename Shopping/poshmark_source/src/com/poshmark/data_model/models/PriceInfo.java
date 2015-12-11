// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


public class PriceInfo
{

    private String max;
    private String min;

    public PriceInfo()
    {
    }

    public PriceInfo(String s, String s1)
    {
        min = s;
        max = s1;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (PriceInfo)obj;
            if (max != null && !max.equals(((PriceInfo) (obj)).max))
            {
                return false;
            }
            if (min != null && !min.equals(((PriceInfo) (obj)).min))
            {
                return false;
            }
        }
        return true;
    }

    public String getDisplay()
    {
        if (min == null)
        {
            return (new StringBuilder()).append("Under $").append(max).toString();
        }
        if (max == null)
        {
            return (new StringBuilder()).append("Over $").append(min).toString();
        } else
        {
            return (new StringBuilder()).append("$").append(min).append(" - ").append("$").append(max).toString();
        }
    }

    public String getMax()
    {
        return max;
    }

    public String getMin()
    {
        return min;
    }

    public int hashCode()
    {
        int i = 1;
        int j = 1;
        if (min != null)
        {
            i = min.hashCode();
        }
        if (max != null)
        {
            j = max.hashCode();
        }
        return i * 31 + j;
    }
}
