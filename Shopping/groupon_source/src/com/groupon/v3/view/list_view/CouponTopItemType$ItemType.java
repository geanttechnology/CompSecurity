// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;


// Referenced classes of package com.groupon.v3.view.list_view:
//            CouponTopItemType

public static final class  extends Enum
{

    private static final TOP_CATEGORY $VALUES[];
    public static final TOP_CATEGORY NEARBY;
    public static final TOP_CATEGORY TOP_CATEGORY;
    public static final TOP_CATEGORY TOP_MERCHANT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/v3/view/list_view/CouponTopItemType$ItemType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NEARBY = new <init>("NEARBY", 0);
        TOP_MERCHANT = new <init>("TOP_MERCHANT", 1);
        TOP_CATEGORY = new <init>("TOP_CATEGORY", 2);
        $VALUES = (new .VALUES[] {
            NEARBY, TOP_MERCHANT, TOP_CATEGORY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
