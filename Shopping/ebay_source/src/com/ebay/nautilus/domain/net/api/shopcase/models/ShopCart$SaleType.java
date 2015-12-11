// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase.models;

import android.text.TextUtils;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase.models:
//            ShopCart

public static final class  extends Enum
{

    private static final FIXED_PRICE $VALUES[];
    public static final FIXED_PRICE BID_AND_BIN;
    public static final FIXED_PRICE BID_ONLY;
    public static final FIXED_PRICE FIXED_PRICE;
    public static final FIXED_PRICE UNKNOWN;

    public static  from(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return UNKNOWN;
        }
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
        return (UNKNOWN)Enum.valueOf(com/ebay/nautilus/domain/net/api/shopcase/models/ShopCart$SaleType, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        BID_AND_BIN = new <init>("BID_AND_BIN", 1);
        BID_ONLY = new <init>("BID_ONLY", 2);
        FIXED_PRICE = new <init>("FIXED_PRICE", 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN, BID_AND_BIN, BID_ONLY, FIXED_PRICE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
