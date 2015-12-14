// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.grafika;


public final class GPUImageBeautyBlendMode extends Enum
{

    private static final GPUImageBeautyBlendMode $VALUES[];
    public static final GPUImageBeautyBlendMode BlendModeColor;
    public static final GPUImageBeautyBlendMode BlendModeColorBurn;
    public static final GPUImageBeautyBlendMode BlendModeColorDodge;
    public static final GPUImageBeautyBlendMode BlendModeDarken;
    public static final GPUImageBeautyBlendMode BlendModeDarkerColor;
    public static final GPUImageBeautyBlendMode BlendModeDifference;
    public static final GPUImageBeautyBlendMode BlendModeDissolve;
    public static final GPUImageBeautyBlendMode BlendModeDivide;
    public static final GPUImageBeautyBlendMode BlendModeExclusion;
    public static final GPUImageBeautyBlendMode BlendModeHardLight;
    public static final GPUImageBeautyBlendMode BlendModeHardMix;
    public static final GPUImageBeautyBlendMode BlendModeHue;
    public static final GPUImageBeautyBlendMode BlendModeLighten;
    public static final GPUImageBeautyBlendMode BlendModeLighterColor;
    public static final GPUImageBeautyBlendMode BlendModeLinearBurn;
    public static final GPUImageBeautyBlendMode BlendModeLinearDodge;
    public static final GPUImageBeautyBlendMode BlendModeLinearLight;
    public static final GPUImageBeautyBlendMode BlendModeLuminosity;
    public static final GPUImageBeautyBlendMode BlendModeMultiply;
    public static final GPUImageBeautyBlendMode BlendModeNormal;
    public static final GPUImageBeautyBlendMode BlendModeOverlay;
    public static final GPUImageBeautyBlendMode BlendModePinLight;
    public static final GPUImageBeautyBlendMode BlendModeSaturation;
    public static final GPUImageBeautyBlendMode BlendModeScreen;
    public static final GPUImageBeautyBlendMode BlendModeSoftLight;
    public static final GPUImageBeautyBlendMode BlendModeSubtract;
    public static final GPUImageBeautyBlendMode BlendModeVividLight;

    private GPUImageBeautyBlendMode(String s, int i)
    {
        super(s, i);
    }

    public static GPUImageBeautyBlendMode valueOf(String s)
    {
        return (GPUImageBeautyBlendMode)Enum.valueOf(jp/co/cyberagent/android/gpuimage/grafika/GPUImageBeautyBlendMode, s);
    }

    public static GPUImageBeautyBlendMode[] values()
    {
        return (GPUImageBeautyBlendMode[])$VALUES.clone();
    }

    static 
    {
        BlendModeNormal = new GPUImageBeautyBlendMode("BlendModeNormal", 0);
        BlendModeDissolve = new GPUImageBeautyBlendMode("BlendModeDissolve", 1);
        BlendModeDarken = new GPUImageBeautyBlendMode("BlendModeDarken", 2);
        BlendModeMultiply = new GPUImageBeautyBlendMode("BlendModeMultiply", 3);
        BlendModeColorBurn = new GPUImageBeautyBlendMode("BlendModeColorBurn", 4);
        BlendModeLinearBurn = new GPUImageBeautyBlendMode("BlendModeLinearBurn", 5);
        BlendModeDarkerColor = new GPUImageBeautyBlendMode("BlendModeDarkerColor", 6);
        BlendModeLighten = new GPUImageBeautyBlendMode("BlendModeLighten", 7);
        BlendModeScreen = new GPUImageBeautyBlendMode("BlendModeScreen", 8);
        BlendModeColorDodge = new GPUImageBeautyBlendMode("BlendModeColorDodge", 9);
        BlendModeLinearDodge = new GPUImageBeautyBlendMode("BlendModeLinearDodge", 10);
        BlendModeLighterColor = new GPUImageBeautyBlendMode("BlendModeLighterColor", 11);
        BlendModeOverlay = new GPUImageBeautyBlendMode("BlendModeOverlay", 12);
        BlendModeSoftLight = new GPUImageBeautyBlendMode("BlendModeSoftLight", 13);
        BlendModeHardLight = new GPUImageBeautyBlendMode("BlendModeHardLight", 14);
        BlendModeVividLight = new GPUImageBeautyBlendMode("BlendModeVividLight", 15);
        BlendModeLinearLight = new GPUImageBeautyBlendMode("BlendModeLinearLight", 16);
        BlendModePinLight = new GPUImageBeautyBlendMode("BlendModePinLight", 17);
        BlendModeHardMix = new GPUImageBeautyBlendMode("BlendModeHardMix", 18);
        BlendModeDifference = new GPUImageBeautyBlendMode("BlendModeDifference", 19);
        BlendModeExclusion = new GPUImageBeautyBlendMode("BlendModeExclusion", 20);
        BlendModeSubtract = new GPUImageBeautyBlendMode("BlendModeSubtract", 21);
        BlendModeDivide = new GPUImageBeautyBlendMode("BlendModeDivide", 22);
        BlendModeHue = new GPUImageBeautyBlendMode("BlendModeHue", 23);
        BlendModeSaturation = new GPUImageBeautyBlendMode("BlendModeSaturation", 24);
        BlendModeColor = new GPUImageBeautyBlendMode("BlendModeColor", 25);
        BlendModeLuminosity = new GPUImageBeautyBlendMode("BlendModeLuminosity", 26);
        $VALUES = (new GPUImageBeautyBlendMode[] {
            BlendModeNormal, BlendModeDissolve, BlendModeDarken, BlendModeMultiply, BlendModeColorBurn, BlendModeLinearBurn, BlendModeDarkerColor, BlendModeLighten, BlendModeScreen, BlendModeColorDodge, 
            BlendModeLinearDodge, BlendModeLighterColor, BlendModeOverlay, BlendModeSoftLight, BlendModeHardLight, BlendModeVividLight, BlendModeLinearLight, BlendModePinLight, BlendModeHardMix, BlendModeDifference, 
            BlendModeExclusion, BlendModeSubtract, BlendModeDivide, BlendModeHue, BlendModeSaturation, BlendModeColor, BlendModeLuminosity
        });
    }
}
