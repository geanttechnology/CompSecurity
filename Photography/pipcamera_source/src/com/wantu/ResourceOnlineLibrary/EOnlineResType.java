// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary;


public final class EOnlineResType extends Enum
{

    private static final EOnlineResType $VALUES[];
    public static final EOnlineResType FILTER_FRAME;
    public static final EOnlineResType FREE_COLLAGE_STYLE;
    public static final EOnlineResType GIF_EFFECT;
    public static final EOnlineResType LIGHT_FILTER;
    public static final EOnlineResType MAG_COMIC_MASKGRAIN;
    public static final EOnlineResType MAG_MASK_INFO;
    public static final EOnlineResType PIP_SCENE;
    public static final EOnlineResType PIP_SCENE2;
    public static final EOnlineResType TIEZHI;

    private EOnlineResType(String s, int i)
    {
        super(s, i);
    }

    public static EOnlineResType valueOf(String s)
    {
        return (EOnlineResType)Enum.valueOf(com/wantu/ResourceOnlineLibrary/EOnlineResType, s);
    }

    public static EOnlineResType[] values()
    {
        return (EOnlineResType[])$VALUES.clone();
    }

    static 
    {
        LIGHT_FILTER = new EOnlineResType("LIGHT_FILTER", 0);
        PIP_SCENE = new EOnlineResType("PIP_SCENE", 1);
        PIP_SCENE2 = new EOnlineResType("PIP_SCENE2", 2);
        FILTER_FRAME = new EOnlineResType("FILTER_FRAME", 3);
        FREE_COLLAGE_STYLE = new EOnlineResType("FREE_COLLAGE_STYLE", 4);
        GIF_EFFECT = new EOnlineResType("GIF_EFFECT", 5);
        MAG_MASK_INFO = new EOnlineResType("MAG_MASK_INFO", 6);
        MAG_COMIC_MASKGRAIN = new EOnlineResType("MAG_COMIC_MASKGRAIN", 7);
        TIEZHI = new EOnlineResType("TIEZHI", 8);
        $VALUES = (new EOnlineResType[] {
            LIGHT_FILTER, PIP_SCENE, PIP_SCENE2, FILTER_FRAME, FREE_COLLAGE_STYLE, GIF_EFFECT, MAG_MASK_INFO, MAG_COMIC_MASKGRAIN, TIEZHI
        });
    }
}
