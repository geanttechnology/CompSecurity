// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.wantu.ResourceOnlineLibrary.CGBlendMode;

class bgo
{

    static final int a[];

    static 
    {
        a = new int[CGBlendMode.values().length];
        try
        {
            a[CGBlendMode.kCGBlendModeNormal.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            a[CGBlendMode.kCGBlendModeMultiply.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            a[CGBlendMode.kCGBlendModeScreen.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            a[CGBlendMode.kCGBlendModeOverlay.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[CGBlendMode.kCGBlendModeDarken.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[CGBlendMode.kCGBlendModeLighten.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[CGBlendMode.kCGBlendModeColorDodge.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[CGBlendMode.kCGBlendModeColorBurn.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[CGBlendMode.kCGBlendModeSoftLight.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[CGBlendMode.kCGBlendModeDifference.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[CGBlendMode.kCGBlendModeExclusion.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[CGBlendMode.kCGBlendModeHue.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[CGBlendMode.kCGBlendModeSaturation.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[CGBlendMode.kCGBlendModeColor.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[CGBlendMode.kCGBlendModeLuminosity.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[CGBlendMode.kCGBlendModeHardLight.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
