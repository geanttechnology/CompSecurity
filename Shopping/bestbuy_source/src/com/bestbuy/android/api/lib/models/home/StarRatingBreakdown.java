// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class StarRatingBreakdown
    implements gu, Serializable
{

    private static final long serialVersionUID = 0xec4d20ed1925df70L;
    private String count;
    private String percent0To100;
    private String score;

    public StarRatingBreakdown()
    {
    }

    public String getCount()
    {
        return count;
    }

    public String getPercent0To100()
    {
        return percent0To100;
    }

    public String getScore()
    {
        return score;
    }

    public void setCount(String s)
    {
        count = s;
    }

    public void setPercent0To100(String s)
    {
        percent0To100 = s;
    }

    public void setScore(String s)
    {
        score = s;
    }
}
