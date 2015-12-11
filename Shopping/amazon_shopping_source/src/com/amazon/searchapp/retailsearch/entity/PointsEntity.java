// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Points;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PointsEntity extends RetailSearchEntity
    implements Points
{

    private int percentage;
    private long points;

    public PointsEntity()
    {
    }

    public int getPercentage()
    {
        return percentage;
    }

    public long getPoints()
    {
        return points;
    }

    public void setPercentage(int i)
    {
        percentage = i;
    }

    public void setPoints(long l)
    {
        points = l;
    }
}
