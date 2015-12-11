// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable.model;

import java.io.Serializable;
import java.util.Locale;
import java.util.UUID;

public class WearableSearchResult
    implements Serializable
{

    boolean addOnItem;
    String asin;
    float avgRating;
    String badge;
    String bindingSymbol;
    boolean buyable;
    String deliveryDate;
    String group;
    String icon;
    String id;
    String imageUrl;
    String merchantId;
    String name;
    String offerId;
    boolean oneClickEnabled;
    boolean outOfStock;
    String price;
    boolean prime;
    int reviewCount;
    String shippingCost;
    String shippingOffer;
    boolean variations;

    public WearableSearchResult()
    {
        id = UUID.randomUUID().toString();
        avgRating = 0.0F;
        reviewCount = 0;
        prime = false;
        oneClickEnabled = false;
        buyable = false;
        outOfStock = false;
        variations = false;
        addOnItem = false;
    }

    public static boolean isDigital(String s)
    {
        if (s != null)
        {
            if ((s = s.toLowerCase(Locale.US)).equals("generic") || s.equals("wir_plan_option_display_on_website") || s.equals("wir_bundle_display_on_website") || s.equals("wir_plan_display_on_website") || s.contains("magazine_display") || s.contains("video_rental") || s.contains("digital") || s.contains("kindle") || s.contains("mp3") || s.contains("download") || s.contains("ebooks") || s.contains("mobile_application") || s.contains("audible"))
            {
                return true;
            }
        }
        return false;
    }

    public void determineBuyable()
    {
        while (isDigital(group) || getPrice() != null && getPrice().contains("-") || getPrice() == null || getPrice().isEmpty() || isVariations() || outOfStock || isPantryItem()) 
        {
            return;
        }
        setBuyable(true);
    }

    public String getPrice()
    {
        return price;
    }

    public boolean isPantryItem()
    {
        if (badge != null)
        {
            return badge.equals("PRIME_PANTRY");
        } else
        {
            return false;
        }
    }

    public boolean isVariations()
    {
        return variations;
    }

    public void setAddOnItem(boolean flag)
    {
        addOnItem = flag;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setAvgRating(float f)
    {
        avgRating = f;
    }

    public void setBadge(String s)
    {
        badge = s;
    }

    public void setBindingSymbol(String s)
    {
        bindingSymbol = s;
    }

    public void setBuyable(boolean flag)
    {
        buyable = flag;
    }

    public void setGroup(String s)
    {
        group = s;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setOutOfStock(boolean flag)
    {
        outOfStock = flag;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setPrime(boolean flag)
    {
        prime = flag;
    }

    public void setReviewCount(int i)
    {
        reviewCount = i;
    }

    public void setShippingCost(String s)
    {
        shippingCost = s;
    }

    public void setShippingOffer(String s)
    {
        shippingOffer = s;
    }

    public void setVariations(boolean flag)
    {
        variations = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append("WearableSearchResult [id=").append(id).append(", asin=").append(asin).append(", name=").append(name).append(", price=").append(price).append(", avgRating=").append(avgRating).append(", reviewCount=").append(reviewCount).append(", prime=").append(prime).append(", ").append("oneClickEnabled=").append(oneClickEnabled).append(", buyable=").append(buyable).append(", icon=").append(icon).append(", imageUrl=").append(imageUrl).append(", merchantId=").append(merchantId).append(", offerId=").append(offerId).append(", ").append("shippingOffer=").append(shippingOffer).append(", deliveryDate=").append(deliveryDate).append(", group=").append(group).append(", variations=").append(variations).append("]").toString();
    }
}
