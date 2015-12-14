// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;


public final class  extends Enum
{

    private static final SKINTONE $VALUES[];
    public static final SKINTONE ABAO;
    public static final SKINTONE ALPHAMASK;
    public static final SKINTONE AUTUMN;
    public static final SKINTONE BLENDCOLOR;
    public static final SKINTONE BLOOM;
    public static final SKINTONE CHANNELMIXER;
    public static final SKINTONE CHEAPBLOOM;
    public static final SKINTONE COLORCURVE;
    public static final SKINTONE COLORLOOKUP;
    public static final SKINTONE CRTSCANLINE;
    public static final SKINTONE DESATURATION;
    public static final SKINTONE DREAMVISION;
    public static final SKINTONE ERODE;
    public static final SKINTONE EXBLEND;
    public static final SKINTONE EXCOLORBLEND;
    public static final SKINTONE FANTASY;
    public static final SKINTONE FILMGRAIN;
    public static final SKINTONE FROSTEDGLASS;
    public static final SKINTONE GAMMACOLLECTION;
    public static final SKINTONE GAUSSIANBLUR;
    public static final SKINTONE GAUSSIANBLUR_HOR;
    public static final SKINTONE GAUSSIANBLUR_VER;
    public static final SKINTONE INVERT;
    public static final SKINTONE LEVELCONTROL;
    public static final SKINTONE MOTIONBLUR;
    public static final SKINTONE NET_EXBLEND;
    public static final SKINTONE RIPPLE;
    public static final SKINTONE SCENELOWSATURATION;
    public static final SKINTONE SELECTIVEBLUR;
    public static final SKINTONE SEPIA;
    public static final SKINTONE SHARPNESS;
    public static final SKINTONE SIMPLE;
    public static final SKINTONE SKETCH;
    public static final SKINTONE SKINTONE;
    public static final SKINTONE THEMALVISION;
    public static final SKINTONE UNSHARPMASK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/wantu/piprender/renderengine/filters/ImageFilterFactory$TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SIMPLE = new <init>("SIMPLE", 0);
        GAUSSIANBLUR_HOR = new <init>("GAUSSIANBLUR_HOR", 1);
        GAUSSIANBLUR_VER = new <init>("GAUSSIANBLUR_VER", 2);
        GAUSSIANBLUR = new <init>("GAUSSIANBLUR", 3);
        ABAO = new <init>("ABAO", 4);
        ALPHAMASK = new <init>("ALPHAMASK", 5);
        BLENDCOLOR = new <init>("BLENDCOLOR", 6);
        BLOOM = new <init>("BLOOM", 7);
        CHANNELMIXER = new <init>("CHANNELMIXER", 8);
        CHEAPBLOOM = new <init>("CHEAPBLOOM", 9);
        COLORCURVE = new <init>("COLORCURVE", 10);
        COLORLOOKUP = new <init>("COLORLOOKUP", 11);
        CRTSCANLINE = new <init>("CRTSCANLINE", 12);
        DREAMVISION = new <init>("DREAMVISION", 13);
        ERODE = new <init>("ERODE", 14);
        EXBLEND = new <init>("EXBLEND", 15);
        EXCOLORBLEND = new <init>("EXCOLORBLEND", 16);
        FILMGRAIN = new <init>("FILMGRAIN", 17);
        FROSTEDGLASS = new <init>("FROSTEDGLASS", 18);
        GAMMACOLLECTION = new <init>("GAMMACOLLECTION", 19);
        LEVELCONTROL = new <init>("LEVELCONTROL", 20);
        MOTIONBLUR = new <init>("MOTIONBLUR", 21);
        RIPPLE = new <init>("RIPPLE", 22);
        SCENELOWSATURATION = new <init>("SCENELOWSATURATION", 23);
        SEPIA = new <init>("SEPIA", 24);
        SHARPNESS = new <init>("SHARPNESS", 25);
        THEMALVISION = new <init>("THEMALVISION", 26);
        UNSHARPMASK = new <init>("UNSHARPMASK", 27);
        AUTUMN = new <init>("AUTUMN", 28);
        DESATURATION = new <init>("DESATURATION", 29);
        INVERT = new <init>("INVERT", 30);
        NET_EXBLEND = new <init>("NET_EXBLEND", 31);
        FANTASY = new <init>("FANTASY", 32);
        SELECTIVEBLUR = new <init>("SELECTIVEBLUR", 33);
        SKETCH = new <init>("SKETCH", 34);
        SKINTONE = new <init>("SKINTONE", 35);
        $VALUES = (new .VALUES[] {
            SIMPLE, GAUSSIANBLUR_HOR, GAUSSIANBLUR_VER, GAUSSIANBLUR, ABAO, ALPHAMASK, BLENDCOLOR, BLOOM, CHANNELMIXER, CHEAPBLOOM, 
            COLORCURVE, COLORLOOKUP, CRTSCANLINE, DREAMVISION, ERODE, EXBLEND, EXCOLORBLEND, FILMGRAIN, FROSTEDGLASS, GAMMACOLLECTION, 
            LEVELCONTROL, MOTIONBLUR, RIPPLE, SCENELOWSATURATION, SEPIA, SHARPNESS, THEMALVISION, UNSHARPMASK, AUTUMN, DESATURATION, 
            INVERT, NET_EXBLEND, FANTASY, SELECTIVEBLUR, SKETCH, SKINTONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
