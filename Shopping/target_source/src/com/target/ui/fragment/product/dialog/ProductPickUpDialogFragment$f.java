// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;


// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductPickUpDialogFragment

private static final class I extends Enum
{

    private static final PICK_UP_VARIATIONS $VALUES[];
    public static final PICK_UP_VARIATIONS PICK_UP_PRODUCT;
    public static final PICK_UP_VARIATIONS PICK_UP_VARIATIONS;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductPickUpDialogFragment$f, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        PICK_UP_PRODUCT = new <init>("PICK_UP_PRODUCT", 0);
        PICK_UP_VARIATIONS = new <init>("PICK_UP_VARIATIONS", 1);
        $VALUES = (new .VALUES[] {
            PICK_UP_PRODUCT, PICK_UP_VARIATIONS
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
