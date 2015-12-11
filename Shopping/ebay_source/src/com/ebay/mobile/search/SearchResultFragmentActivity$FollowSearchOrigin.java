// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;


// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

public static final class  extends Enum
{

    private static final OTHER $VALUES[];
    public static final OTHER CAROUSEL;
    public static final OTHER FLOATING_BAR;
    public static final OTHER GLOBAL_HEADER;
    public static final OTHER OTHER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/search/SearchResultFragmentActivity$FollowSearchOrigin, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FLOATING_BAR = new <init>("FLOATING_BAR", 0);
        CAROUSEL = new <init>("CAROUSEL", 1);
        GLOBAL_HEADER = new <init>("GLOBAL_HEADER", 2);
        OTHER = new <init>("OTHER", 3);
        $VALUES = (new .VALUES[] {
            FLOATING_BAR, CAROUSEL, GLOBAL_HEADER, OTHER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
