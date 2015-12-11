// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;


// Referenced classes of package com.target.ui.fragment.product.dialog:
//            ProductAddToCartErrorDialog

private static final class I extends Enum
{

    private static final GENERIC $VALUES[];
    public static final GENERIC AGE_RESTRICTED;
    public static final GENERIC GENERIC;
    public static final GENERIC SPECIFIC_TYPE;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/target/ui/fragment/product/dialog/ProductAddToCartErrorDialog$d, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        AGE_RESTRICTED = new <init>("AGE_RESTRICTED", 0);
        SPECIFIC_TYPE = new <init>("SPECIFIC_TYPE", 1);
        GENERIC = new <init>("GENERIC", 2);
        $VALUES = (new .VALUES[] {
            AGE_RESTRICTED, SPECIFIC_TYPE, GENERIC
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
