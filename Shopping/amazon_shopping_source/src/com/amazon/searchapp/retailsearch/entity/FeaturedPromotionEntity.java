// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.FeaturedPromotion;
import com.amazon.searchapp.retailsearch.model.Image;
import com.amazon.searchapp.retailsearch.model.Ratings;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class FeaturedPromotionEntity extends RetailSearchEntity
    implements FeaturedPromotion
{

    private String actionUrl;
    private String description;
    private Image image;
    private String price;
    private Ratings ratings;
    private String title;

    public FeaturedPromotionEntity()
    {
    }

    public String getActionUrl()
    {
        return actionUrl;
    }

    public String getDescription()
    {
        return description;
    }

    public Image getImage()
    {
        return image;
    }

    public String getPrice()
    {
        return price;
    }

    public Ratings getRatings()
    {
        return ratings;
    }

    public String getTitle()
    {
        return title;
    }

    public void setActionUrl(String s)
    {
        actionUrl = s;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setImage(Image image1)
    {
        image = image1;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setRatings(Ratings ratings1)
    {
        ratings = ratings1;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
