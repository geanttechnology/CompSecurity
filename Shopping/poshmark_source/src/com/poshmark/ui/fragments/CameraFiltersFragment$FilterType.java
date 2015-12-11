// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            CameraFiltersFragment

static final class  extends Enum
{

    private static final FILTER_TYPE_CLASSIC $VALUES[];
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_CHIC;
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_CLASSIC;
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_GLAM;
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_MODERN;
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_RETRO;
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_STREET;
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_TIMELESS;
    public static final FILTER_TYPE_CLASSIC FILTER_TYPE_VINTAGE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/ui/fragments/CameraFiltersFragment$FilterType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FILTER_TYPE_TIMELESS = new <init>("FILTER_TYPE_TIMELESS", 0);
        FILTER_TYPE_GLAM = new <init>("FILTER_TYPE_GLAM", 1);
        FILTER_TYPE_MODERN = new <init>("FILTER_TYPE_MODERN", 2);
        FILTER_TYPE_VINTAGE = new <init>("FILTER_TYPE_VINTAGE", 3);
        FILTER_TYPE_RETRO = new <init>("FILTER_TYPE_RETRO", 4);
        FILTER_TYPE_CHIC = new <init>("FILTER_TYPE_CHIC", 5);
        FILTER_TYPE_STREET = new <init>("FILTER_TYPE_STREET", 6);
        FILTER_TYPE_CLASSIC = new <init>("FILTER_TYPE_CLASSIC", 7);
        $VALUES = (new .VALUES[] {
            FILTER_TYPE_TIMELESS, FILTER_TYPE_GLAM, FILTER_TYPE_MODERN, FILTER_TYPE_VINTAGE, FILTER_TYPE_RETRO, FILTER_TYPE_CHIC, FILTER_TYPE_STREET, FILTER_TYPE_CLASSIC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
