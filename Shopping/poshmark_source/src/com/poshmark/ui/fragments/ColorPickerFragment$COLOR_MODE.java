// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            ColorPickerFragment

public static final class  extends Enum
{

    private static final COLOR_LISTING_FLOW $VALUES[];
    public static final COLOR_LISTING_FLOW COLOR_BROWSE;
    public static final COLOR_LISTING_FLOW COLOR_FILTER;
    public static final COLOR_LISTING_FLOW COLOR_LISTING_FLOW;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        COLOR_BROWSE = new <init>("COLOR_BROWSE", 0);
        COLOR_FILTER = new <init>("COLOR_FILTER", 1);
        COLOR_LISTING_FLOW = new <init>("COLOR_LISTING_FLOW", 2);
        $VALUES = (new .VALUES[] {
            COLOR_BROWSE, COLOR_FILTER, COLOR_LISTING_FLOW
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
