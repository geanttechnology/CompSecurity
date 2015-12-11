// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class PartyRoomInfo
{

    public static final String PoshPartyCollectionAllKey = "all";
    public static final String PoshPartyCollectionDesignerKey = "designer";
    public static final String PoshPartyCollectionFreshKey = "fresh";
    public static final String PoshPartyCollectionHostPicksKey = "host_picks";
    public static final String PoshPartyCollectionNWTKey = "nwt";
    boolean default_value;
    String description;
    String id;
    String name;
    int posts;
    String type;

    public PartyRoomInfo()
    {
    }

    public int getCovershotBGColor()
    {
        if (type.equals("host_picks"))
        {
            return 0x7f090010;
        }
        if (type.equals("fresh"))
        {
            return 0x7f090011;
        }
        if (type.equals("designer"))
        {
            return 0x7f090012;
        }
        return !type.equals("nwt") ? 0x7f090015 : 0x7f090013;
    }

    public String getDescription()
    {
        return description;
    }

    public int getIconDrawable()
    {
        if (type.equals("host_picks"))
        {
            return 0x7f0200c3;
        }
        if (type.equals("fresh"))
        {
            return 0x7f0200c5;
        }
        if (type.equals("designer"))
        {
            return 0x7f0200c0;
        }
        return !type.equals("nwt") ? 0 : 0x7f0200c7;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getPostCount()
    {
        return posts;
    }

    public String getType()
    {
        return type;
    }

    public int getWhiteOutlineIconDrawable()
    {
        if (type.equals("host_picks"))
        {
            return 0x7f0200c4;
        }
        if (type.equals("fresh"))
        {
            return 0x7f0200c6;
        }
        if (type.equals("designer"))
        {
            return 0x7f0200c1;
        }
        return !type.equals("nwt") ? 0 : 0x7f0200c8;
    }

    public boolean isDefault()
    {
        return default_value;
    }
}
