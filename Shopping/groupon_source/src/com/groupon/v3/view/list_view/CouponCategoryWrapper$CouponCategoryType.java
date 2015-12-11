// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.list_view;


// Referenced classes of package com.groupon.v3.view.list_view:
//            CouponCategoryWrapper

public static final class  extends Enum
{

    private static final ALL $VALUES[];
    public static final ALL ALL;
    public static final ALL TOP_CATEGORIES;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/v3/view/list_view/CouponCategoryWrapper$CouponCategoryType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TOP_CATEGORIES = new <init>("TOP_CATEGORIES", 0);
        ALL = new <init>("ALL", 1);
        $VALUES = (new .VALUES[] {
            TOP_CATEGORIES, ALL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
