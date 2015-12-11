// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Features

public static final class val extends Enum
{

    private static final HEALTH_BEAUTY_WELLNESS $VALUES[];
    public static final HEALTH_BEAUTY_WELLNESS FOOD_AND_DRINK;
    public static final HEALTH_BEAUTY_WELLNESS HEALTH_BEAUTY_WELLNESS;
    public static final HEALTH_BEAUTY_WELLNESS UNKNOWN;
    private String val;

    public static val valueOf(String s)
    {
        return (val)Enum.valueOf(com/groupon/db/models/Features$SearchIntentCategory, s);
    }

    public static val[] values()
    {
        return (val[])$VALUES.clone();
    }

    public String toString()
    {
        return val;
    }

    public String toTrackingString()
    {
        switch (pon.db.models.Features.SearchIntentCategory[ordinal()])
        {
        default:
            return toString();

        case 1: // '\001'
            return "F&D";

        case 2: // '\002'
            return "HBW";
        }
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, "Unknown");
        FOOD_AND_DRINK = new <init>("FOOD_AND_DRINK", 1, "Food & Drink");
        HEALTH_BEAUTY_WELLNESS = new <init>("HEALTH_BEAUTY_WELLNESS", 2, "Beauty & Spas");
        $VALUES = (new .VALUES[] {
            UNKNOWN, FOOD_AND_DRINK, HEALTH_BEAUTY_WELLNESS
        });
    }

    private _cls9(String s, int i, String s1)
    {
        super(s, i);
        val = s1;
    }
}
