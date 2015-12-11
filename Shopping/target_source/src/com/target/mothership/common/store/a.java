// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.store;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a ACCEPTS_WIC;
    public static final a APPLE_STORE;
    public static final a BEAUTY_CONCIERGE;
    public static final a CAFE;
    public static final a CAFE_PIZZA;
    public static final a CLINIC;
    public static final a FLU_SHOT;
    public static final a FRESH_GROCERY;
    public static final a MOBILE_KIOSK;
    public static final a OPTICAL;
    public static final a OTHER;
    public static final a PHARMACY;
    public static final a PHOTO_LAB;
    public static final a PORTRAIT;
    public static final a STARBUCKS;
    public static final a UNIFORM;
    public static final a WINE;
    private final String mValue;

    private a(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static a a(String s)
    {
        if (s != null)
        {
            a aa[] = values();
            int j = aa.length;
            for (int i = 0; i < j; i++)
            {
                a a1 = aa[i];
                if (s.equalsIgnoreCase(a1.mValue))
                {
                    return a1;
                }
            }

        }
        return OTHER;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/store/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        BEAUTY_CONCIERGE = new a("BEAUTY_CONCIERGE", 0, "Beauty Concierge");
        CAFE = new a("CAFE", 1, "Caf\351");
        FRESH_GROCERY = new a("FRESH_GROCERY", 2, "Fresh Grocery");
        MOBILE_KIOSK = new a("MOBILE_KIOSK", 3, "Mobile Kiosk");
        WINE = new a("WINE", 4, "Wine");
        FLU_SHOT = new a("FLU_SHOT", 5, "Flu shot");
        APPLE_STORE = new a("APPLE_STORE", 6, "In-Store Apple Store");
        PHARMACY = new a("PHARMACY", 7, "Pharmacy");
        ACCEPTS_WIC = new a("ACCEPTS_WIC", 8, "Accepts WIC");
        CAFE_PIZZA = new a("CAFE_PIZZA", 9, "Cafe-Pizza");
        OPTICAL = new a("OPTICAL", 10, "Optical");
        STARBUCKS = new a("STARBUCKS", 11, "Starbucks");
        PORTRAIT = new a("PORTRAIT", 12, "Portrait");
        CLINIC = new a("CLINIC", 13, "Clinic");
        PHOTO_LAB = new a("PHOTO_LAB", 14, "Photo Lab");
        UNIFORM = new a("UNIFORM", 15, "Uniform");
        OTHER = new a("OTHER", 16, "");
        $VALUES = (new a[] {
            BEAUTY_CONCIERGE, CAFE, FRESH_GROCERY, MOBILE_KIOSK, WINE, FLU_SHOT, APPLE_STORE, PHARMACY, ACCEPTS_WIC, CAFE_PIZZA, 
            OPTICAL, STARBUCKS, PORTRAIT, CLINIC, PHOTO_LAB, UNIFORM, OTHER
        });
    }
}
