// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            MyEbayWatchingDataManager

public static final class  extends Enum
{

    private static final EndTimeDescending $VALUES[];
    public static final EndTimeDescending CurrentPrice;
    public static final EndTimeDescending CurrentPriceDescending;
    public static final EndTimeDescending EndTimeDescending;
    public static final EndTimeDescending TimeLeft;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/content/dm/MyEbayWatchingDataManager$Sort, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TimeLeft = new <init>("TimeLeft", 0);
        CurrentPrice = new <init>("CurrentPrice", 1);
        CurrentPriceDescending = new <init>("CurrentPriceDescending", 2);
        EndTimeDescending = new <init>("EndTimeDescending", 3);
        $VALUES = (new .VALUES[] {
            TimeLeft, CurrentPrice, CurrentPriceDescending, EndTimeDescending
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
