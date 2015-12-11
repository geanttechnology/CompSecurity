// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;


// Referenced classes of package com.poshmark.ui.customviews:
//            PMPriceLayout

static final class  extends Enum
{

    private static final ORIGINAL_STRING $VALUES[];
    public static final ORIGINAL_STRING LISTING_PRICE;
    public static final ORIGINAL_STRING ORIGINAL_STRING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/customviews/PMPriceLayout$STRING_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LISTING_PRICE = new <init>("LISTING_PRICE", 0);
        ORIGINAL_STRING = new <init>("ORIGINAL_STRING", 1);
        $VALUES = (new .VALUES[] {
            LISTING_PRICE, ORIGINAL_STRING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
