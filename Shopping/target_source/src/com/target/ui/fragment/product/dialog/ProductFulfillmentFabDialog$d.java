// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;


// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductFulfillmentFabDialog

public static final class I extends Enum
{

    private static final LOAD_PRODUCT_DETAILS_LIST $VALUES[];
    public static final LOAD_PRODUCT_DETAILS_LIST LOAD_PRODUCT_DETAILS;
    public static final LOAD_PRODUCT_DETAILS_LIST LOAD_PRODUCT_DETAILS_LIST;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductFulfillmentFabDialog$d, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        LOAD_PRODUCT_DETAILS = new <init>("LOAD_PRODUCT_DETAILS", 0);
        LOAD_PRODUCT_DETAILS_LIST = new <init>("LOAD_PRODUCT_DETAILS_LIST", 1);
        $VALUES = (new .VALUES[] {
            LOAD_PRODUCT_DETAILS, LOAD_PRODUCT_DETAILS_LIST
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
