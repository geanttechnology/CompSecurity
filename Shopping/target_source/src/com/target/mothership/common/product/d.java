// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class d extends Enum
{

    private static final d $VALUES[];
    public static final d APPAREL;
    public static final d BABY;
    public static final d ELECTRONICS;
    public static final d FURNITURE;
    public static final d GARAGE_HARDWARE;
    public static final d GIFTS;
    public static final d GROCERY;
    public static final d HEALTH_BEAUTY;
    public static final d HOME;
    public static final d JEWELRY;
    public static final d KITCHEN;
    public static final d LAUNDRY;
    public static final d LAUNDRY_CLEANING_CLOSET;
    public static final d PATIO_OUTDOOR_DECOR;
    public static final d SERVICES;
    public static final d SPORTING_GOODS;
    public static final d STATIONERY_OFFICE_SUPPLIES;
    public static final d TOYS;
    public static final d UNKNOWN;
    private String mValue;

    private d(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static d a(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        d d1 = UNKNOWN;
_L4:
        return d1;
_L2:
        d ad[];
        int i;
        int j;
        ad = values();
        j = ad.length;
        i = 0;
_L6:
        d d2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        d2 = ad[i];
        d1 = d2;
        if (s.equalsIgnoreCase(d2.toString())) goto _L4; else goto _L3
_L3:
        d1 = d2;
        if (s.equalsIgnoreCase(d2.name())) goto _L4; else goto _L5
_L5:
        i++;
          goto _L6
        return UNKNOWN;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/target/mothership/common/product/d, s);
    }

    public static d[] values()
    {
        return (d[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        APPAREL = new d("APPAREL", 0, "APPAREL");
        BABY = new d("BABY", 1, "BABY");
        ELECTRONICS = new d("ELECTRONICS", 2, "ELECTRONICS");
        FURNITURE = new d("FURNITURE", 3, "FURNITURE");
        GARAGE_HARDWARE = new d("GARAGE_HARDWARE", 4, "GARAGE & HARDWARE");
        GIFTS = new d("GIFTS", 5, "GIFTS");
        GROCERY = new d("GROCERY", 6, "GROCERY");
        HEALTH_BEAUTY = new d("HEALTH_BEAUTY", 7, "HEALTH & BEAUTY");
        HOME = new d("HOME", 8, "HOME");
        JEWELRY = new d("JEWELRY", 9, "JEWELRY");
        KITCHEN = new d("KITCHEN", 10, "KITCHEN");
        LAUNDRY = new d("LAUNDRY", 11, "LAUNDRY");
        LAUNDRY_CLEANING_CLOSET = new d("LAUNDRY_CLEANING_CLOSET", 12, "LAUNDRY CLEANING & CLOSET");
        PATIO_OUTDOOR_DECOR = new d("PATIO_OUTDOOR_DECOR", 13, "PATIO & OUTDOOR DECOR");
        SERVICES = new d("SERVICES", 14, "SERVICES");
        SPORTING_GOODS = new d("SPORTING_GOODS", 15, "SPORTING GOODS");
        STATIONERY_OFFICE_SUPPLIES = new d("STATIONERY_OFFICE_SUPPLIES", 16, "STATIONERY & OFFICE SUPPLIES");
        TOYS = new d("TOYS", 17, "TOYS");
        UNKNOWN = new d("UNKNOWN", 18, "UNKNOWN");
        $VALUES = (new d[] {
            APPAREL, BABY, ELECTRONICS, FURNITURE, GARAGE_HARDWARE, GIFTS, GROCERY, HEALTH_BEAUTY, HOME, JEWELRY, 
            KITCHEN, LAUNDRY, LAUNDRY_CLEANING_CLOSET, PATIO_OUTDOOR_DECOR, SERVICES, SPORTING_GOODS, STATIONERY_OFFICE_SUPPLIES, TOYS, UNKNOWN
        });
    }
}
