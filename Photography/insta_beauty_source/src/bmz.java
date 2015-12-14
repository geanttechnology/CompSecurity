// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bmz
{

    public static final int a[];

    static 
    {
        a = new int[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.values().length];
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SIMPLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror35) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR_HOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror34) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR_VER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror33) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAUSSIANBLUR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror32) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.ABAO.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror31) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.ALPHAMASK.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror30) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.BLENDCOLOR.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror29) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.BLOOM.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.CHANNELMIXER.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.CHEAPBLOOM.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORCURVE.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKINTONE.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.COLORLOOKUP.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.CRTSCANLINE.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.DREAMVISION.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.ERODE.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXBLEND.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.NET_EXBLEND.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.EXCOLORBLEND.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.FILMGRAIN.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.FROSTEDGLASS.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.GAMMACOLLECTION.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.LEVELCONTROL.ordinal()] = 23;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.MOTIONBLUR.ordinal()] = 24;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.RIPPLE.ordinal()] = 25;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SCENELOWSATURATION.ordinal()] = 26;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SEPIA.ordinal()] = 27;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SHARPNESS.ordinal()] = 28;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.THEMALVISION.ordinal()] = 29;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.UNSHARPMASK.ordinal()] = 30;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.AUTUMN.ordinal()] = 31;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.INVERT.ordinal()] = 32;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.DESATURATION.ordinal()] = 33;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.FANTASY.ordinal()] = 34;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SELECTIVEBLUR.ordinal()] = 35;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.wantu.piprender.renderengine.filters.ImageFilterFactory.TYPE.SKETCH.ordinal()] = 36;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
