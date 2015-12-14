// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyBlendMode;

class ccb
{

    static final int a[];

    static 
    {
        a = new int[GPUImageBeautyBlendMode.values().length];
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeNormal.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror26) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeDissolve.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror25) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeDarken.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror24) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeMultiply.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror23) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeColorBurn.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror22) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeLinearBurn.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror21) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeDarkerColor.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror20) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeLighten.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror19) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeScreen.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror18) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeColorDodge.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror17) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeLinearDodge.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror16) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeLighterColor.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror15) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeOverlay.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror14) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeSoftLight.ordinal()] = 14;
        }
        catch (NoSuchFieldError nosuchfielderror13) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeHardLight.ordinal()] = 15;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeVividLight.ordinal()] = 16;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeLinearLight.ordinal()] = 17;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModePinLight.ordinal()] = 18;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeHardMix.ordinal()] = 19;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeDifference.ordinal()] = 20;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeExclusion.ordinal()] = 21;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeSubtract.ordinal()] = 22;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeDivide.ordinal()] = 23;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeHue.ordinal()] = 24;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeSaturation.ordinal()] = 25;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeColor.ordinal()] = 26;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[GPUImageBeautyBlendMode.BlendModeLuminosity.ordinal()] = 27;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
