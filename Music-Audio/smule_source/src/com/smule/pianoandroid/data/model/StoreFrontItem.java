// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StoreFrontItem
{

    public static final String COLUMN_NAME_DISPLAY_NAME = "display_name";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_IMAGE_URL = "image_url";
    public static final String COLUMN_NAME_ITEM_TYPE = "item_type";
    public static final String COLUMN_NAME_LISTING_LIST = "listing_list";
    public static final String COLUMN_NAME_ORDER = "order";
    public static final String COLUMN_NAME_SECTION_UID = "section_uid";
    public static final String COLUMN_NAME_UPDATED_AT = "updated_at";
    public static final String COLUMN_NAME_URL = "url";
    public int _id;
    public String displayName;
    public String imageUrl;
    public String itemType;
    public String listingList;
    public Collection listings;
    public int order;
    public String sectionUid;
    public Date updatedAt;
    public String url;

    public StoreFrontItem()
    {
    }

    private void parseListings()
    {
        listings = new ArrayList();
        if (listingList != null)
        {
            for (Matcher matcher = Pattern.compile("\\d+").matcher(listingList); matcher.find(); listings.add(Integer.valueOf(matcher.group()))) { }
        }
    }

    public void copyLocal(StoreFrontItem storefrontitem)
    {
        _id = storefrontitem._id;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((StoreFrontItem)obj);
    }

    public String equatableId()
    {
        return (new StringBuilder()).append("").append(sectionUid).toString();
    }

    public Collection getListings()
    {
        if (listings == null)
        {
            parseListings();
        }
        return listings;
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }
}
