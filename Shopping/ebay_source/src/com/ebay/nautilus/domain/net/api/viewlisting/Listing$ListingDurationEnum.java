// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final GTC $VALUES[];
    public static final GTC DAYS_1;
    public static final GTC DAYS_10;
    public static final GTC DAYS_120;
    public static final GTC DAYS_14;
    public static final GTC DAYS_21;
    public static final GTC DAYS_3;
    public static final GTC DAYS_30;
    public static final GTC DAYS_5;
    public static final GTC DAYS_60;
    public static final GTC DAYS_7;
    public static final GTC DAYS_90;
    public static final GTC GTC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ListingDurationEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DAYS_1 = new <init>("DAYS_1", 0);
        DAYS_3 = new <init>("DAYS_3", 1);
        DAYS_5 = new <init>("DAYS_5", 2);
        DAYS_7 = new <init>("DAYS_7", 3);
        DAYS_10 = new <init>("DAYS_10", 4);
        DAYS_14 = new <init>("DAYS_14", 5);
        DAYS_21 = new <init>("DAYS_21", 6);
        DAYS_30 = new <init>("DAYS_30", 7);
        DAYS_60 = new <init>("DAYS_60", 8);
        DAYS_90 = new <init>("DAYS_90", 9);
        DAYS_120 = new <init>("DAYS_120", 10);
        GTC = new <init>("GTC", 11);
        $VALUES = (new .VALUES[] {
            DAYS_1, DAYS_3, DAYS_5, DAYS_7, DAYS_10, DAYS_14, DAYS_21, DAYS_30, DAYS_60, DAYS_90, 
            DAYS_120, GTC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
