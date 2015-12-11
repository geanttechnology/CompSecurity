// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common;

import com.target.mothership.util.o;

public final class b extends Enum
{

    private static final b $VALUES[];
    private static final String PRODUCT_LEVEL_PROMOTION = "ProductLevelPromotion";
    public static final b ProductPromotion;
    private static final String SHIPPING_PROMOTION = "ShippingPromotion";
    public static final b ShippingPromotion;
    public static final b Unknown;

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b a(String s)
    {
        if (!o.g(s))
        {
            return Unknown;
        }
        if (s.equalsIgnoreCase("ShippingPromotion"))
        {
            return ShippingPromotion;
        }
        if (s.equalsIgnoreCase("ProductLevelPromotion"))
        {
            return ProductPromotion;
        } else
        {
            return Unknown;
        }
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/target/mothership/common/b, s);
    }

    public static b[] values()
    {
        return (b[])$VALUES.clone();
    }

    static 
    {
        ShippingPromotion = new b("ShippingPromotion", 0);
        ProductPromotion = new b("ProductPromotion", 1);
        Unknown = new b("Unknown", 2);
        $VALUES = (new b[] {
            ShippingPromotion, ProductPromotion, Unknown
        });
    }
}
