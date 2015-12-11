// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.b;


public final class a extends Enum
{

    private static final a $VALUES[];
    public static final a BAKERY;
    public static final a BEAUTY;
    public static final a BOYS;
    public static final a DELI;
    public static final a DOMESTICS;
    public static final a ELECTRONICS;
    public static final a FROZEN_FOOD;
    public static final a FURNITURE;
    public static final a GIRLS;
    public static final a GROCERY;
    public static final a HOUSEHOLD_COMMODITIES;
    public static final a HOUSEWARES;
    public static final a INFANTS;
    public static final a INFANT_FURNITURE;
    public static final a INTIMATES;
    public static final a JEWELRY;
    public static final a LUGGAGE;
    public static final a MEAT;
    public static final a MENS;
    public static final a PAPER;
    public static final a PERSONAL_CARE;
    public static final a PETS;
    public static final a PRODUCE;
    public static final a PROMO_1;
    public static final a READY_TO_WEAR;
    public static final a SEASONAL;
    public static final a SHOES;
    public static final a SPORTING_GOODS;
    public static final a STATIONERY;
    public static final a TOYS;
    public static final a UNKNOWN;
    private String mValues[];

    private transient a(String s, int i, String as[])
    {
        super(s, i);
        mValues = as;
    }

    public static a a(String s)
    {
        a a1;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_10;
        }
        a1 = UNKNOWN;
        return a1;
        a a2;
        a aa[];
        String as[];
        int i;
        int j;
        int k;
        int l;
        aa = values();
        k = aa.length;
        i = 0;
          goto _L1
        continue; /* Loop/switch isn't completed */
        i++;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/target/mothership/common/b/a, s);
    }

    public static a[] values()
    {
        return (a[])$VALUES.clone();
    }

    static 
    {
        BAKERY = new a("BAKERY", 0, new String[] {
            "Bakery"
        });
        BEAUTY = new a("BEAUTY", 1, new String[] {
            "Beauty"
        });
        BOYS = new a("BOYS", 2, new String[] {
            "Boys"
        });
        DELI = new a("DELI", 3, new String[] {
            "Deli"
        });
        DOMESTICS = new a("DOMESTICS", 4, new String[] {
            "Domestics"
        });
        ELECTRONICS = new a("ELECTRONICS", 5, new String[] {
            "Electronics", "Entertainment"
        });
        FROZEN_FOOD = new a("FROZEN_FOOD", 6, new String[] {
            "Frozen", "Frozen Food"
        });
        FURNITURE = new a("FURNITURE", 7, new String[] {
            "Decorative Home", "Furniture"
        });
        GIRLS = new a("GIRLS", 8, new String[] {
            "Girls"
        });
        GROCERY = new a("GROCERY", 9, new String[] {
            "Dairy", "Dry", "Snacks/Bev/Candy", "Grocery"
        });
        HOUSEHOLD_COMMODITIES = new a("HOUSEHOLD_COMMODITIES", 10, new String[] {
            "Household Commodities"
        });
        HOUSEWARES = new a("HOUSEWARES", 11, new String[] {
            "Housewares", "Automotive"
        });
        INFANT_FURNITURE = new a("INFANT_FURNITURE", 12, new String[] {
            "N/I/T Basics and Furn", "Infant Furniture", "Newborn/Infant/Toddler"
        });
        INFANTS = new a("INFANTS", 13, new String[] {
            "Baby", "Infants"
        });
        INTIMATES = new a("INTIMATES", 14, new String[] {
            "Hosiery", "Intimate Sleepwear", "Intimate Basics", "Intimates"
        });
        JEWELRY = new a("JEWELRY", 15, new String[] {
            "Jewelry/Accessories", "Jewelry"
        });
        LUGGAGE = new a("LUGGAGE", 16, new String[] {
            "Luggage"
        });
        MEAT = new a("MEAT", 17, new String[] {
            "Meat"
        });
        MENS = new a("MENS", 18, new String[] {
            "Mens", "Mens Basics", "Men's"
        });
        PAPER = new a("PAPER", 19, new String[] {
            "Paper and Disposable Plastics", "Paper"
        });
        PERSONAL_CARE = new a("PERSONAL_CARE", 20, new String[] {
            "Personal Care", "Healthcare"
        });
        PETS = new a("PETS", 21, new String[] {
            "Pets"
        });
        PRODUCE = new a("PRODUCE", 22, new String[] {
            "Produce"
        });
        PROMO_1 = new a("PROMO_1", 23, new String[] {
            "Promo 1", "One Spot"
        });
        READY_TO_WEAR = new a("READY_TO_WEAR", 24, new String[] {
            "Performance", "Ready-to-wear", "Ready to Wear"
        });
        SEASONAL = new a("SEASONAL", 25, new String[] {
            "Seasonal"
        });
        SHOES = new a("SHOES", 26, new String[] {
            "Shoes"
        });
        SPORTING_GOODS = new a("SPORTING_GOODS", 27, new String[] {
            "Sporting Goods"
        });
        STATIONERY = new a("STATIONERY", 28, new String[] {
            "Stationery"
        });
        TOYS = new a("TOYS", 29, new String[] {
            "Toys"
        });
        UNKNOWN = new a("UNKNOWN", 30, new String[] {
            "UNKNOWN"
        });
        $VALUES = (new a[] {
            BAKERY, BEAUTY, BOYS, DELI, DOMESTICS, ELECTRONICS, FROZEN_FOOD, FURNITURE, GIRLS, GROCERY, 
            HOUSEHOLD_COMMODITIES, HOUSEWARES, INFANT_FURNITURE, INFANTS, INTIMATES, JEWELRY, LUGGAGE, MEAT, MENS, PAPER, 
            PERSONAL_CARE, PETS, PRODUCE, PROMO_1, READY_TO_WEAR, SEASONAL, SHOES, SPORTING_GOODS, STATIONERY, TOYS, 
            UNKNOWN
        });
    }
}
