// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Location, Merchant

public class Rating
{

    private String linkText;
    protected Location parentLocation;
    protected Merchant parentMerchant;
    private Long primaryKey;
    private double rating;
    private Integer reviewsCount;
    private String url;

    public Rating()
    {
        reviewsCount = Integer.valueOf(0);
        linkText = "";
        url = "";
        rating = 0.0D;
    }

    public String getLinkText()
    {
        return linkText;
    }

    public Location getParentLocation()
    {
        return parentLocation;
    }

    public Merchant getParentMerchant()
    {
        return parentMerchant;
    }

    public Long getPrimaryKey()
    {
        return primaryKey;
    }

    public Double getRating()
    {
        return Double.valueOf(rating);
    }

    public Integer getReviewsCount()
    {
        return reviewsCount;
    }

    public String getUrl()
    {
        return url;
    }

    public void setLinkText(String s)
    {
        linkText = s;
    }

    public void setParentLocation(Location location)
    {
        parentLocation = location;
    }

    public void setParentMerchant(Merchant merchant)
    {
        parentMerchant = merchant;
    }

    public void setPrimaryKey(Long long1)
    {
        primaryKey = long1;
    }

    public void setRating(Double double1)
    {
        rating = double1.doubleValue();
    }

    public void setReviewsCount(Integer integer)
    {
        reviewsCount = integer;
    }

    public void setUrl(String s)
    {
        url = s;
    }
}
