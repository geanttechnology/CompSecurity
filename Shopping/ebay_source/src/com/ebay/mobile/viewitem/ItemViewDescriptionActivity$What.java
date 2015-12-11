// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;


// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewDescriptionActivity

public static final class  extends Enum
{

    private static final DESCRIPTION $VALUES[];
    public static final DESCRIPTION DESCRIPTION;
    public static final DESCRIPTION PRODUCT_DETAILS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/viewitem/ItemViewDescriptionActivity$What, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PRODUCT_DETAILS = new <init>("PRODUCT_DETAILS", 0);
        DESCRIPTION = new <init>("DESCRIPTION", 1);
        $VALUES = (new .VALUES[] {
            PRODUCT_DETAILS, DESCRIPTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
