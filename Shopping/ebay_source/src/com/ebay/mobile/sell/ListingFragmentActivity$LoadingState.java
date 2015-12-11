// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;


// Referenced classes of package com.ebay.mobile.sell:
//            ListingFragmentActivity

private static final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR ERROR;
    public static final ERROR LOADED;
    public static final ERROR LOADING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/sell/ListingFragmentActivity$LoadingState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOADING = new <init>("LOADING", 0);
        LOADED = new <init>("LOADED", 1);
        ERROR = new <init>("ERROR", 2);
        $VALUES = (new .VALUES[] {
            LOADING, LOADED, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
