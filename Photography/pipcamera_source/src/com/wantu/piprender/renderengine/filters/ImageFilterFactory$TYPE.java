// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;


public final class  extends Enum
{

    private static final SKETCH $VALUES[];
    public static final SKETCH ABAO;
    public static final SKETCH ALPHAMASK;
    public static final SKETCH AUTUMN;
    public static final SKETCH BLENDCOLOR;
    public static final SKETCH BLOOM;
    public static final SKETCH CHANNELMIXER;
    public static final SKETCH CHEAPBLOOM;
    public static final SKETCH COLORCURVE;
    public static final SKETCH COLORLOOKUP;
    public static final SKETCH CRTSCANLINE;
    public static final SKETCH DESATURATION;
    public static final SKETCH DREAMVISION;
    public static final SKETCH ERODE;
    public static final SKETCH EXBLEND;
    public static final SKETCH EXCOLORBLEND;
    public static final SKETCH FANTASY;
    public static final SKETCH FILMGRAIN;
    public static final SKETCH FROSTEDGLASS;
    public static final SKETCH GAMMACOLLECTION;
    public static final SKETCH GAUSSIANBLUR;
    public static final SKETCH GAUSSIANBLUR_HOR;
    public static final SKETCH GAUSSIANBLUR_VER;
    public static final SKETCH INVERT;
    public static final SKETCH LEVELCONTROL;
    public static final SKETCH MOTIONBLUR;
    public static final SKETCH NET_EXBLEND;
    public static final SKETCH RIPPLE;
    public static final SKETCH SCENELOWSATURATION;
    public static final SKETCH SELECTIVEBLUR;
    public static final SKETCH SEPIA;
    public static final SKETCH SHARPNESS;
    public static final SKETCH SIMPLE;
    public static final SKETCH SKETCH;
    public static final SKETCH THEMALVISION;
    public static final SKETCH UNSHARPMASK;

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
        $VALUES = (new .VALUES[] {
            SIMPLE, GAUSSIANBLUR_HOR, GAUSSIANBLUR_VER, GAUSSIANBLUR, ABAO, ALPHAMASK, BLENDCOLOR, BLOOM, CHANNELMIXER, CHEAPBLOOM, 
            COLORCURVE, COLORLOOKUP, CRTSCANLINE, DREAMVISION, ERODE, EXBLEND, EXCOLORBLEND, FILMGRAIN, FROSTEDGLASS, GAMMACOLLECTION, 
            LEVELCONTROL, MOTIONBLUR, RIPPLE, SCENELOWSATURATION, SEPIA, SHARPNESS, THEMALVISION, UNSHARPMASK, AUTUMN, DESATURATION, 
            INVERT, NET_EXBLEND, FANTASY, SELECTIVEBLUR, SKETCH
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
