// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.search;


// Referenced classes of package com.target.ui.fragment.product.search:
//            b

public static final class  extends Enum
{

    private static final PI_PRODUCTS $VALUES[];
    public static final PI_PRODUCTS PI_PRODUCTS;
    public static final PI_PRODUCTS PRODUCTS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/product/search/b$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PRODUCTS = new <init>("PRODUCTS", 0);
        PI_PRODUCTS = new <init>("PI_PRODUCTS", 1);
        $VALUES = (new .VALUES[] {
            PRODUCTS, PI_PRODUCTS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
