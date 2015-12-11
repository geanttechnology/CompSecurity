// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;


// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductAddToListDialogFragment

private static final class  extends Enum
{

    private static final GENERIC_PRODUCT $VALUES[];
    public static final GENERIC_PRODUCT GENERIC_PRODUCT;
    public static final GENERIC_PRODUCT SPECIFIC_PRODUCT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/product/dialog/ProductAddToListDialogFragment$i, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SPECIFIC_PRODUCT = new <init>("SPECIFIC_PRODUCT", 0);
        GENERIC_PRODUCT = new <init>("GENERIC_PRODUCT", 1);
        $VALUES = (new .VALUES[] {
            SPECIFIC_PRODUCT, GENERIC_PRODUCT
        });
    }

    private (String s, int j)
    {
        super(s, j);
    }
}
