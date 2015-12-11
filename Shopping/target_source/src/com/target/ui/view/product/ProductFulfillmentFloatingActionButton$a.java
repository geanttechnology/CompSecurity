// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;


// Referenced classes of package com.target.ui.view.product:
//            ProductFulfillmentFloatingActionButton

public static final class I extends Enum
{

    private static final INACTIVE $VALUES[];
    public static final INACTIVE ACTIVE;
    public static final INACTIVE INACTIVE;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/target/ui/view/product/ProductFulfillmentFloatingActionButton$a, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        ACTIVE = new <init>("ACTIVE", 0);
        INACTIVE = new <init>("INACTIVE", 1);
        $VALUES = (new .VALUES[] {
            ACTIVE, INACTIVE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
