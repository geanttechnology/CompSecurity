// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.Link;
import com.amazon.searchapp.retailsearch.model.Ratings;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class RatingsEntity extends RetailSearchEntity
    implements Ratings
{

    private int count;
    private Link link;
    private double rating;

    public RatingsEntity()
    {
    }

    public int getCount()
    {
        return count;
    }

    public Link getLink()
    {
        return link;
    }

    public double getRating()
    {
        return rating;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setLink(Link link1)
    {
        link = link1;
    }

    public void setRating(double d)
    {
        rating = d;
    }
}
