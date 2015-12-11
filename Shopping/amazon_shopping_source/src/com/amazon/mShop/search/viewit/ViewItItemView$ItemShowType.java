// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;


// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItItemView

static final class  extends Enum
{

    private static final ITEM_SHOW_IN_ALL_MATCHES $VALUES[];
    public static final ITEM_SHOW_IN_ALL_MATCHES ITEM_SHOW_IN_ALL_MATCHES;
    public static final ITEM_SHOW_IN_ALL_MATCHES ITME_SHOW_AS_GROUP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/mShop/search/viewit/ViewItItemView$ItemShowType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ITME_SHOW_AS_GROUP = new <init>("ITME_SHOW_AS_GROUP", 0);
        ITEM_SHOW_IN_ALL_MATCHES = new <init>("ITEM_SHOW_IN_ALL_MATCHES", 1);
        $VALUES = (new .VALUES[] {
            ITME_SHOW_AS_GROUP, ITEM_SHOW_IN_ALL_MATCHES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
