// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            MetaItemListViewFragment

public static final class  extends Enum
{

    private static final STYLE_TAGS $VALUES[];
    public static final STYLE_TAGS AVAILABILITY_MODE;
    public static final STYLE_TAGS BRAND_MODE;
    public static final STYLE_TAGS CATEGORY_MODE;
    public static final STYLE_TAGS CONDITION_MODE;
    public static final STYLE_TAGS NWT_MODE;
    public static final STYLE_TAGS PRICE_MODE;
    public static final STYLE_TAGS SIZE_MODE;
    public static final STYLE_TAGS STYLE_TAGS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/MetaItemListViewFragment$META_ITEM_MODES, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CATEGORY_MODE = new <init>("CATEGORY_MODE", 0);
        SIZE_MODE = new <init>("SIZE_MODE", 1);
        BRAND_MODE = new <init>("BRAND_MODE", 2);
        CONDITION_MODE = new <init>("CONDITION_MODE", 3);
        AVAILABILITY_MODE = new <init>("AVAILABILITY_MODE", 4);
        PRICE_MODE = new <init>("PRICE_MODE", 5);
        NWT_MODE = new <init>("NWT_MODE", 6);
        STYLE_TAGS = new <init>("STYLE_TAGS", 7);
        $VALUES = (new .VALUES[] {
            CATEGORY_MODE, SIZE_MODE, BRAND_MODE, CONDITION_MODE, AVAILABILITY_MODE, PRICE_MODE, NWT_MODE, STYLE_TAGS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
