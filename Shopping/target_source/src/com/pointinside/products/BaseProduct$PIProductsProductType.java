// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;


// Referenced classes of package com.pointinside.products:
//            BaseProduct

public static final class  extends Enum
{

    private static final deal $VALUES[];
    public static final deal deal;
    public static final deal metaproduct;
    public static final deal product;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/products/BaseProduct$PIProductsProductType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        product = new <init>("product", 0);
        metaproduct = new <init>("metaproduct", 1);
        deal = new <init>("deal", 2);
        $VALUES = (new .VALUES[] {
            product, metaproduct, deal
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
