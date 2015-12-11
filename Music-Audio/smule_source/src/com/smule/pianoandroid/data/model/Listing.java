// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import java.util.Collection;

// Referenced classes of package com.smule.pianoandroid.data.model:
//            Product

public class Listing
{

    public static final String COLUMN_NAME_COIN_PRICE = "coin_price";
    public static final String COLUMN_NAME_DISPLAY_NAME = "display_name";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_IS_FREE = "is_free";
    public static final String COLUMN_NAME_IS_NEW = "is_new";
    public static final String COLUMN_NAME_IS_ON_SALE = "is_on_sale";
    public static final String COLUMN_NAME_LISTING_ID = "listing_id";
    public static final String COLUMN_NAME_PRODUCT = "product";
    public static final String COLUMN_NAME_PRODUCT_TYPE = "product_type";
    public static final String COLUMN_NAME_SECTIONS = "sections";
    public static final String COLUMN_NAME_SKU = "sku";
    public static final String COLUMN_NAME_SUBSCRIBER_ONLY = "subscriber_only";
    public static final String COLUMN_NAME_UID = "uid";
    public int _id;
    public int coinPrice;
    public String displayName;
    public boolean isFree;
    public boolean isNew;
    public boolean isOnSale;
    public int listingId;
    public Product product;
    public String productType;
    public Collection sections;
    public String sku;
    public boolean subscriberOnly;
    public String uid;

    public Listing()
    {
    }

    public void copyLocal(Listing listing)
    {
        _id = listing._id;
        product = listing.product;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((Listing)obj);
    }

    public String equatableId()
    {
        return uid;
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }
}
