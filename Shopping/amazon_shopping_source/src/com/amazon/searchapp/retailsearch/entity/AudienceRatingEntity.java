// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.AudienceRating;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class AudienceRatingEntity extends RetailSearchEntity
    implements AudienceRating
{

    private String org;
    private String rating;
    private String title;

    public AudienceRatingEntity()
    {
    }

    public String getOrg()
    {
        return org;
    }

    public String getRating()
    {
        return rating;
    }

    public String getTitle()
    {
        return title;
    }

    public void setOrg(String s)
    {
        org = s;
    }

    public void setRating(String s)
    {
        rating = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
