// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


// Referenced classes of package com.poshmark.data_model.models:
//            FeedItemImageLayout

public static final class  extends Enum
{

    private static final Invalid $VALUES[];
    public static final Invalid Invalid;
    public static final Invalid MIFU_3_FLUID_LARGE_LEFT;
    public static final Invalid MIFU_4_GRID;
    public static final Invalid SIFU_LEFT_IMAGE_RIGHT_TEXT;
    public static final Invalid SIFU_SOCIAL;
    public static final Invalid SIFU_SUMMARY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/models/FeedItemImageLayout$Layout, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SIFU_SUMMARY = new <init>("SIFU_SUMMARY", 0);
        SIFU_SOCIAL = new <init>("SIFU_SOCIAL", 1);
        MIFU_3_FLUID_LARGE_LEFT = new <init>("MIFU_3_FLUID_LARGE_LEFT", 2);
        MIFU_4_GRID = new <init>("MIFU_4_GRID", 3);
        SIFU_LEFT_IMAGE_RIGHT_TEXT = new <init>("SIFU_LEFT_IMAGE_RIGHT_TEXT", 4);
        Invalid = new <init>("Invalid", 5);
        $VALUES = (new .VALUES[] {
            SIFU_SUMMARY, SIFU_SOCIAL, MIFU_3_FLUID_LARGE_LEFT, MIFU_4_GRID, SIFU_LEFT_IMAGE_RIGHT_TEXT, Invalid
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
