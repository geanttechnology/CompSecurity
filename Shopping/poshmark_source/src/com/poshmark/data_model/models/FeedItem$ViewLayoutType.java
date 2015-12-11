// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


// Referenced classes of package com.poshmark.data_model.models:
//            FeedItem

private static final class  extends Enum
{

    private static final VIEW_LAYOUT_TYPE_COUNT $VALUES[];
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_BRAND_SIFU;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_CLOSET_SIFU;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_COUNT;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_MIFU_4_GRID;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_SIFU;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER;
    public static final VIEW_LAYOUT_TYPE_COUNT VIEW_LAYOUT_TYPE_SOCIAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/models/FeedItem$ViewLayoutType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VIEW_LAYOUT_TYPE_SOCIAL = new <init>("VIEW_LAYOUT_TYPE_SOCIAL", 0);
        VIEW_LAYOUT_TYPE_SIFU = new <init>("VIEW_LAYOUT_TYPE_SIFU", 1);
        VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER = new <init>("VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER", 2);
        VIEW_LAYOUT_TYPE_MIFU_4_GRID = new <init>("VIEW_LAYOUT_TYPE_MIFU_4_GRID", 3);
        VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT = new <init>("VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT", 4);
        VIEW_LAYOUT_TYPE_BRAND_SIFU = new <init>("VIEW_LAYOUT_TYPE_BRAND_SIFU", 5);
        VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID = new <init>("VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID", 6);
        VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT = new <init>("VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT", 7);
        VIEW_LAYOUT_TYPE_CLOSET_SIFU = new <init>("VIEW_LAYOUT_TYPE_CLOSET_SIFU", 8);
        VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID = new <init>("VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID", 9);
        VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT = new <init>("VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT", 10);
        VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT = new <init>("VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT", 11);
        VIEW_LAYOUT_TYPE_COUNT = new <init>("VIEW_LAYOUT_TYPE_COUNT", 12);
        $VALUES = (new .VALUES[] {
            VIEW_LAYOUT_TYPE_SOCIAL, VIEW_LAYOUT_TYPE_SIFU, VIEW_LAYOUT_TYPE_SIFU_DOUBLE_HEADER, VIEW_LAYOUT_TYPE_MIFU_4_GRID, VIEW_LAYOUT_TYPE_MIFU_3_FLUID_LARGE_LEFT, VIEW_LAYOUT_TYPE_BRAND_SIFU, VIEW_LAYOUT_TYPE_BRAND_MIFU_4_GRID, VIEW_LAYOUT_TYPE_BRAND_MIFU_3_FLUID_LARGE_LEFT, VIEW_LAYOUT_TYPE_CLOSET_SIFU, VIEW_LAYOUT_TYPE_CLOSET_MIFU_4_GRID, 
            VIEW_LAYOUT_TYPE_CLOSET_MIFU_3_FLUID_LARGE_LEFT, VIEW_LAYOUT_TYPE_POSHPOST_SIFU_LEFT_TEXT_RIGHT, VIEW_LAYOUT_TYPE_COUNT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
