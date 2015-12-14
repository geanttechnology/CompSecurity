// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;


// Referenced classes of package com.wantu.piprender.renderengine.filters:
//            ImageFilterFactory

class PE
{

    static final int a[];

    static 
    {
        a = new int[PE.values().length];
        try
        {
            a[PE.SIMPLE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror34) { }
        try
        {
            a[PE.GAUSSIANBLUR_HOR.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror33) { }
        try
        {
            a[PE.GAUSSIANBLUR_VER.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror32) { }
        try
        {
            a[PE.GAUSSIANBLUR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror31) { }
        try
        {
            a[PE.ABAO.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror30) { }
        try
        {
            a[PE.ALPHAMASK.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror29) { }
        try
        {
            a[PE.BLENDCOLOR.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror28) { }
        try
        {
            a[PE.BLOOM.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror27) { }
        try
        {
            a[PE.CHANNELMIXER.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            a[PE.CHEAPBLOOM.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            a[PE.COLORCURVE.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            a[PE.COLORLOOKUP.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            a[PE.CRTSCANLINE.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            a[PE.DREAMVISION.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            a[PE.ERODE.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            a[PE.EXBLEND.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            a[PE.NET_EXBLEND.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            a[PE.EXCOLORBLEND.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            a[PE.FILMGRAIN.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            a[PE.FROSTEDGLASS.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            a[PE.GAMMACOLLECTION.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            a[PE.LEVELCONTROL.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            a[PE.MOTIONBLUR.ordinal()] = 23;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[PE.RIPPLE.ordinal()] = 24;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[PE.SCENELOWSATURATION.ordinal()] = 25;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[PE.SEPIA.ordinal()] = 26;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[PE.SHARPNESS.ordinal()] = 27;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[PE.THEMALVISION.ordinal()] = 28;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[PE.UNSHARPMASK.ordinal()] = 29;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[PE.AUTUMN.ordinal()] = 30;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[PE.INVERT.ordinal()] = 31;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[PE.DESATURATION.ordinal()] = 32;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[PE.FANTASY.ordinal()] = 33;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[PE.SELECTIVEBLUR.ordinal()] = 34;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[PE.SKETCH.ordinal()] = 35;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
