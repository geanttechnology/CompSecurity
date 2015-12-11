// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class AverageWouldRecommend
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x4630bddf21509f02L;
    private String percent0To1;
    private String percent0To100;
    private String totalCount;

    public AverageWouldRecommend()
    {
    }

    public String getPercent0To1()
    {
        return percent0To1;
    }

    public String getPercent0To100()
    {
        return percent0To100;
    }

    public String getTotalCount()
    {
        return totalCount;
    }

    public void setPercent0To1(String s)
    {
        percent0To1 = s;
    }

    public void setPercent0To100(String s)
    {
        percent0To100 = s;
    }

    public void setTotalCount(String s)
    {
        totalCount = s;
    }
}
