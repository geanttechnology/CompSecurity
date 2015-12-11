// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.ArrayList;
import java.util.Date;

public final class EbayDeals extends ArrayList
{
    public static class Item
    {

        public ItemCurrency convertedCurrentPrice;
        public Date endDate;
        public String energyRating;
        public long id;
        public String imageUrl;
        public ItemCurrency origRetailPrice;
        public int savingsRate;
        public ItemCurrency shippingCost;
        public String title;

        public Item()
        {
            id = 0L;
            imageUrl = null;
            title = null;
            convertedCurrentPrice = null;
            origRetailPrice = null;
            endDate = null;
            shippingCost = null;
            savingsRate = 0;
            energyRating = null;
        }
    }

    public static final class MultiSkuItem extends Item
    {

        public ArrayList items;

        public MultiSkuItem()
        {
            items = null;
        }
    }

    public static final class Section extends ArrayList
    {

        public String description;
        public int id;
        public String title;

        public Section()
        {
        }
    }

    public static final class SubSection extends ArrayList
    {

        public String title;

        public SubSection()
        {
        }
    }


    public EbayDeals()
    {
    }
}
