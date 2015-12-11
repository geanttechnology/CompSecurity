// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Points;
import java.util.List;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class PointsEntity extends RetailSearchEntity
    implements Points
{

    private List label;
    private int percentage;
    private long points;

    public PointsEntity()
    {
    }

    public List getLabel()
    {
        return label;
    }

    public int getPercentage()
    {
        return percentage;
    }

    public long getPoints()
    {
        return points;
    }

    public void setLabel(List list)
    {
        label = list;
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
