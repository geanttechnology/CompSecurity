// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class StarRating
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private int count;
    private int percent;
    private int score;

    public StarRating()
    {
    }

    public int getCount()
    {
        return count;
    }

    public int getPercent()
    {
        return percent;
    }

    public int getScore()
    {
        return score;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setPercent(int i)
    {
        percent = i;
    }

    public void setScore(int i)
    {
        score = i;
    }
}
