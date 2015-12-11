// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class AverageFeatureRating
    implements gu, Serializable
{

    private String displayName;
    private double percent0To1;
    private double percent0To100;
    private int rangeMax;
    private double score;

    public AverageFeatureRating()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public double getPercent0To1()
    {
        return percent0To1;
    }

    public double getPercent0To100()
    {
        return percent0To100;
    }

    public int getRangeMax()
    {
        return rangeMax;
    }

    public double getScore()
    {
        return score;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setPercent0To1(double d)
    {
        percent0To1 = d;
    }

    public void setPercent0To100(double d)
    {
        percent0To100 = d;
    }

    public void setRangeMax(int i)
    {
        rangeMax = i;
    }

    public void setScore(double d)
    {
        score = d;
    }
}
