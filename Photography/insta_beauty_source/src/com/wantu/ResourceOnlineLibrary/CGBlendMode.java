// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary;


public final class CGBlendMode extends Enum
{

    private static final CGBlendMode $VALUES[];
    public static final CGBlendMode kCGBlendModeClear;
    public static final CGBlendMode kCGBlendModeColor;
    public static final CGBlendMode kCGBlendModeColorBurn;
    public static final CGBlendMode kCGBlendModeColorDodge;
    public static final CGBlendMode kCGBlendModeCopy;
    public static final CGBlendMode kCGBlendModeDarken;
    public static final CGBlendMode kCGBlendModeDestinationAtop;
    public static final CGBlendMode kCGBlendModeDestinationIn;
    public static final CGBlendMode kCGBlendModeDestinationOut;
    public static final CGBlendMode kCGBlendModeDestinationOver;
    public static final CGBlendMode kCGBlendModeDifference;
    public static final CGBlendMode kCGBlendModeExclusion;
    public static final CGBlendMode kCGBlendModeHardLight;
    public static final CGBlendMode kCGBlendModeHue;
    public static final CGBlendMode kCGBlendModeLighten;
    public static final CGBlendMode kCGBlendModeLuminosity;
    public static final CGBlendMode kCGBlendModeMultiply;
    public static final CGBlendMode kCGBlendModeNormal;
    public static final CGBlendMode kCGBlendModeOverlay;
    public static final CGBlendMode kCGBlendModePlusDarker;
    public static final CGBlendMode kCGBlendModePlusLighter;
    public static final CGBlendMode kCGBlendModeSaturation;
    public static final CGBlendMode kCGBlendModeScreen;
    public static final CGBlendMode kCGBlendModeSoftLight;
    public static final CGBlendMode kCGBlendModeSourceAtop;
    public static final CGBlendMode kCGBlendModeSourceIn;
    public static final CGBlendMode kCGBlendModeSourceOut;
    public static final CGBlendMode kCGBlendModeXOR;

    private CGBlendMode(String s, int i)
    {
        super(s, i);
    }

    public static CGBlendMode valueOf(String s)
    {
        return (CGBlendMode)Enum.valueOf(com/wantu/ResourceOnlineLibrary/CGBlendMode, s);
    }

    public static CGBlendMode[] values()
    {
        return (CGBlendMode[])$VALUES.clone();
    }

    static 
    {
        kCGBlendModeNormal = new CGBlendMode("kCGBlendModeNormal", 0);
        kCGBlendModeMultiply = new CGBlendMode("kCGBlendModeMultiply", 1);
        kCGBlendModeScreen = new CGBlendMode("kCGBlendModeScreen", 2);
        kCGBlendModeOverlay = new CGBlendMode("kCGBlendModeOverlay", 3);
        kCGBlendModeDarken = new CGBlendMode("kCGBlendModeDarken", 4);
        kCGBlendModeLighten = new CGBlendMode("kCGBlendModeLighten", 5);
        kCGBlendModeColorDodge = new CGBlendMode("kCGBlendModeColorDodge", 6);
        kCGBlendModeColorBurn = new CGBlendMode("kCGBlendModeColorBurn", 7);
        kCGBlendModeSoftLight = new CGBlendMode("kCGBlendModeSoftLight", 8);
        kCGBlendModeHardLight = new CGBlendMode("kCGBlendModeHardLight", 9);
        kCGBlendModeDifference = new CGBlendMode("kCGBlendModeDifference", 10);
        kCGBlendModeExclusion = new CGBlendMode("kCGBlendModeExclusion", 11);
        kCGBlendModeHue = new CGBlendMode("kCGBlendModeHue", 12);
        kCGBlendModeSaturation = new CGBlendMode("kCGBlendModeSaturation", 13);
        kCGBlendModeColor = new CGBlendMode("kCGBlendModeColor", 14);
        kCGBlendModeLuminosity = new CGBlendMode("kCGBlendModeLuminosity", 15);
        kCGBlendModeClear = new CGBlendMode("kCGBlendModeClear", 16);
        kCGBlendModeCopy = new CGBlendMode("kCGBlendModeCopy", 17);
        kCGBlendModeSourceIn = new CGBlendMode("kCGBlendModeSourceIn", 18);
        kCGBlendModeSourceOut = new CGBlendMode("kCGBlendModeSourceOut", 19);
        kCGBlendModeSourceAtop = new CGBlendMode("kCGBlendModeSourceAtop", 20);
        kCGBlendModeDestinationOver = new CGBlendMode("kCGBlendModeDestinationOver", 21);
        kCGBlendModeDestinationIn = new CGBlendMode("kCGBlendModeDestinationIn", 22);
        kCGBlendModeDestinationOut = new CGBlendMode("kCGBlendModeDestinationOut", 23);
        kCGBlendModeDestinationAtop = new CGBlendMode("kCGBlendModeDestinationAtop", 24);
        kCGBlendModeXOR = new CGBlendMode("kCGBlendModeXOR", 25);
        kCGBlendModePlusDarker = new CGBlendMode("kCGBlendModePlusDarker", 26);
        kCGBlendModePlusLighter = new CGBlendMode("kCGBlendModePlusLighter", 27);
        $VALUES = (new CGBlendMode[] {
            kCGBlendModeNormal, kCGBlendModeMultiply, kCGBlendModeScreen, kCGBlendModeOverlay, kCGBlendModeDarken, kCGBlendModeLighten, kCGBlendModeColorDodge, kCGBlendModeColorBurn, kCGBlendModeSoftLight, kCGBlendModeHardLight, 
            kCGBlendModeDifference, kCGBlendModeExclusion, kCGBlendModeHue, kCGBlendModeSaturation, kCGBlendModeColor, kCGBlendModeLuminosity, kCGBlendModeClear, kCGBlendModeCopy, kCGBlendModeSourceIn, kCGBlendModeSourceOut, 
            kCGBlendModeSourceAtop, kCGBlendModeDestinationOver, kCGBlendModeDestinationIn, kCGBlendModeDestinationOut, kCGBlendModeDestinationAtop, kCGBlendModeXOR, kCGBlendModePlusDarker, kCGBlendModePlusLighter
        });
    }
}
