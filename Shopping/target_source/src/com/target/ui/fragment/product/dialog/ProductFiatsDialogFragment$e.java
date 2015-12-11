// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;


// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductFiatsDialogFragment

private static final class  extends Enum
{

    private static final FIND_IN_STORE_VARIATIONS $VALUES[];
    public static final FIND_IN_STORE_VARIATIONS FIND_IN_STORE;
    public static final FIND_IN_STORE_VARIATIONS FIND_IN_STORE_VARIATIONS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/product/dialog/ProductFiatsDialogFragment$e, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FIND_IN_STORE = new <init>("FIND_IN_STORE", 0);
        FIND_IN_STORE_VARIATIONS = new <init>("FIND_IN_STORE_VARIATIONS", 1);
        $VALUES = (new .VALUES[] {
            FIND_IN_STORE, FIND_IN_STORE_VARIATIONS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
