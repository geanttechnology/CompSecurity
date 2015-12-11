// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;

import java.io.Serializable;

public class EPFeaturedCategory
    implements Serializable
{

    private static final long serialVersionUID = 0x4eb65af01a14a2dbL;
    String abbrevation;
    String categoryId;
    String imageUrl;
    String listingsUrl;
    String name;
    String shortName;
    String type;
    String vodUrl;

    public EPFeaturedCategory(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7)
    {
        categoryId = s;
        name = s1;
        shortName = s2;
        abbrevation = s3;
        type = s4;
        imageUrl = s5;
        listingsUrl = s6;
        vodUrl = s7;
    }

    public String getAbbrevation()
    {
        return abbrevation;
    }

    public String getCategoryId()
    {
        return categoryId;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    protected String getListingsUrl()
    {
        return listingsUrl;
    }

    public String getName()
    {
        return name;
    }

    public String getShortName()
    {
        return shortName;
    }

    public String getType()
    {
        return type;
    }

    protected String getVodUrl()
    {
        return vodUrl;
    }
}
