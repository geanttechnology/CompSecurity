// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class AverageRating
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xa530682a826adde1L;
    private double percent0To1;
    private double percent0To100;
    private double rangeMax;
    private double score;

    public AverageRating()
    {
    }

    public double getPercent0To1()
    {
        return percent0To1;
    }

    public double getPercent0To100()
    {
        return percent0To100;
    }

    public double getRangeMax()
    {
        return rangeMax;
    }

    public double getScore()
    {
        return score;
    }

    public void setPercent0To1(double d)
    {
        percent0To1 = d;
    }

    public void setPercent0To100(double d)
    {
        percent0To100 = d;
    }

    public void setRangeMax(double d)
    {
        rangeMax = d;
    }

    public void setScore(double d)
    {
        score = d;
    }
}
