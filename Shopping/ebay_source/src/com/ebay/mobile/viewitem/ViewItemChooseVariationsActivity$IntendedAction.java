// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ViewItemChooseVariationsActivity

public static final class value extends Enum
{

    private static final SPR $VALUES[];
    public static final SPR ADD_TO_CART;
    public static final SPR BIN;
    public static final SPR SPR;
    public static final SPR WATCH;
    public int value;

    public static value valueOf(String s)
    {
        return (value)Enum.valueOf(com/ebay/mobile/viewitem/ViewItemChooseVariationsActivity$IntendedAction, s);
    }

    public static value[] values()
    {
        return (value[])$VALUES.clone();
    }

    static 
    {
        BIN = new <init>("BIN", 0, 3);
        ADD_TO_CART = new <init>("ADD_TO_CART", 1, 9);
        WATCH = new <init>("WATCH", 2, 2);
        SPR = new <init>("SPR", 3, 4);
        $VALUES = (new .VALUES[] {
            BIN, ADD_TO_CART, WATCH, SPR
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        value = j;
    }
}
