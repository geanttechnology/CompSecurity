// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


// Referenced classes of package com.ebay.nautilus.domain.data:
//            ShoppingCart

public static final class A extends Enum
{

    private static final BID_ONLY $VALUES[];
    public static final BID_ONLY BID_AND_BIN;
    public static final BID_ONLY BID_ONLY;
    public static final BID_ONLY BIN_ONLY;
    public static final BID_ONLY UNKNOWN;

    public static A from(String s)
    {
        try
        {
            s = valueOf(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return UNKNOWN;
        }
        return s;
    }

    public static UNKNOWN valueOf(String s)
    {
        return (UNKNOWN)Enum.valueOf(com/ebay/nautilus/domain/data/ShoppingCart$Item$ListingType, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        BIN_ONLY = new <init>("BIN_ONLY", 1);
        BID_AND_BIN = new <init>("BID_AND_BIN", 2);
        BID_ONLY = new <init>("BID_ONLY", 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN, BIN_ONLY, BID_AND_BIN, BID_ONLY
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
