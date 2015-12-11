// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;


// Referenced classes of package com.poshmark.ui.customviews:
//            ListingsFilterWidget

public static final class  extends Enum
{

    private static final STYLE_TAGS $VALUES[];
    public static final STYLE_TAGS AVAILABILITY;
    public static final STYLE_TAGS BRAND;
    public static final STYLE_TAGS CATEGORY;
    public static final STYLE_TAGS COLOR;
    public static final STYLE_TAGS CONDITION;
    public static final STYLE_TAGS FILTER;
    public static final STYLE_TAGS PRICE;
    public static final STYLE_TAGS SIZE;
    public static final STYLE_TAGS STYLE_TAGS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/customviews/ListingsFilterWidget$FILTER_BUTTON, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FILTER = new <init>("FILTER", 0);
        CATEGORY = new <init>("CATEGORY", 1);
        BRAND = new <init>("BRAND", 2);
        SIZE = new <init>("SIZE", 3);
        PRICE = new <init>("PRICE", 4);
        AVAILABILITY = new <init>("AVAILABILITY", 5);
        CONDITION = new <init>("CONDITION", 6);
        COLOR = new <init>("COLOR", 7);
        STYLE_TAGS = new <init>("STYLE_TAGS", 8);
        $VALUES = (new .VALUES[] {
            FILTER, CATEGORY, BRAND, SIZE, PRICE, AVAILABILITY, CONDITION, COLOR, STYLE_TAGS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
