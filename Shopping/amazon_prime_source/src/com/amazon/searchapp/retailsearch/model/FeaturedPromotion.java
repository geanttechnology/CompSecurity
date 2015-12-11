// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Image, Ratings

public interface FeaturedPromotion
{

    public abstract String getActionUrl();

    public abstract String getDescription();

    public abstract Image getImage();

    public abstract String getPrice();

    public abstract Ratings getRatings();

    public abstract String getTitle();

    public abstract void setActionUrl(String s);

    public abstract void setDescription(String s);

    public abstract void setImage(Image image);

    public abstract void setPrice(String s);

    public abstract void setRatings(Ratings ratings);

    public abstract void setTitle(String s);
}
