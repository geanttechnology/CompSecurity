// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;


// Referenced classes of package com.ebay.mobile.myebay:
//            RemindersActivity

private static final class  extends Enum
{

    private static final COUPONS $VALUES[];
    public static final COUPONS ACTIVITIES;
    public static final COUPONS BUYING;
    public static final COUPONS COUPONS;
    public static final COUPONS SELLING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/myebay/RemindersActivity$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACTIVITIES = new <init>("ACTIVITIES", 0);
        BUYING = new <init>("BUYING", 1);
        SELLING = new <init>("SELLING", 2);
        COUPONS = new <init>("COUPONS", 3);
        $VALUES = (new .VALUES[] {
            ACTIVITIES, BUYING, SELLING, COUPONS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
