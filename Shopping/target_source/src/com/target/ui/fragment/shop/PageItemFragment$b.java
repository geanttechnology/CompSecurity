// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;


// Referenced classes of package com.target.ui.fragment.shop:
//            PageItemFragment

public static final class  extends Enum
{

    private static final FEATURED $VALUES[];
    public static final FEATURED CATEGORIES;
    public static final FEATURED CUSTOM;
    public static final FEATURED DEALS;
    public static final FEATURED FEATURED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/ui/fragment/shop/PageItemFragment$b, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CATEGORIES = new <init>("CATEGORIES", 0);
        CUSTOM = new <init>("CUSTOM", 1);
        DEALS = new <init>("DEALS", 2);
        FEATURED = new <init>("FEATURED", 3);
        $VALUES = (new .VALUES[] {
            CATEGORIES, CUSTOM, DEALS, FEATURED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
