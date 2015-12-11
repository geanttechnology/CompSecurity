// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class BundleStarRating
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private int count;
    private double percent0To100;
    private int score;

    public BundleStarRating()
    {
    }

    public int getCount()
    {
        return count;
    }

    public double getPercent0To100()
    {
        return percent0To100;
    }

    public int getScore()
    {
        return score;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setPercent0To100(double d)
    {
        percent0To100 = d;
    }

    public void setScore(int i)
    {
        score = i;
    }
}
