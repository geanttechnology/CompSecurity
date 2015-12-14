// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.piprender.renderengine.filters;


public final class BlendMode extends Enum
{

    private static final BlendMode $VALUES[];
    public static final BlendMode ADD;
    public static final BlendMode AVERAGE;
    public static final BlendMode COLOR;
    public static final BlendMode COLORBURN;
    public static final BlendMode COLORDODGE;
    public static final BlendMode DARKEN;
    public static final BlendMode DIFFERENCE;
    public static final BlendMode EXCLUSION;
    public static final BlendMode GLOW;
    public static final BlendMode HARDLIGHT;
    public static final BlendMode HARDMIX;
    public static final BlendMode HUE;
    public static final BlendMode LIGHTEN;
    public static final BlendMode LINEARBURN;
    public static final BlendMode LINEARDODGE;
    public static final BlendMode LINEARLIGHT;
    public static final BlendMode LUMINOSITY;
    public static final BlendMode MULTIPLY;
    public static final BlendMode NEGATION;
    public static final BlendMode NORMAL;
    public static final BlendMode OVERLAY;
    public static final BlendMode PHOENIX;
    public static final BlendMode PINLIGHT;
    public static final BlendMode REFLECT;
    public static final BlendMode SATURATION;
    public static final BlendMode SCREEN;
    public static final BlendMode SOFTLIGHT;
    public static final BlendMode SUBSTRACT;
    public static final BlendMode VIVIDLIGHT;

    private BlendMode(String s, int i)
    {
        super(s, i);
    }

    public static BlendMode valueOf(String s)
    {
        return (BlendMode)Enum.valueOf(com/wantu/piprender/renderengine/filters/BlendMode, s);
    }

    public static BlendMode[] values()
    {
        return (BlendMode[])$VALUES.clone();
    }

    static 
    {
        NORMAL = new BlendMode("NORMAL", 0);
        LIGHTEN = new BlendMode("LIGHTEN", 1);
        DARKEN = new BlendMode("DARKEN", 2);
        MULTIPLY = new BlendMode("MULTIPLY", 3);
        AVERAGE = new BlendMode("AVERAGE", 4);
        ADD = new BlendMode("ADD", 5);
        SUBSTRACT = new BlendMode("SUBSTRACT", 6);
        NEGATION = new BlendMode("NEGATION", 7);
        EXCLUSION = new BlendMode("EXCLUSION", 8);
        SCREEN = new BlendMode("SCREEN", 9);
        OVERLAY = new BlendMode("OVERLAY", 10);
        SOFTLIGHT = new BlendMode("SOFTLIGHT", 11);
        HARDLIGHT = new BlendMode("HARDLIGHT", 12);
        COLORDODGE = new BlendMode("COLORDODGE", 13);
        COLORBURN = new BlendMode("COLORBURN", 14);
        LINEARDODGE = new BlendMode("LINEARDODGE", 15);
        LINEARBURN = new BlendMode("LINEARBURN", 16);
        LINEARLIGHT = new BlendMode("LINEARLIGHT", 17);
        VIVIDLIGHT = new BlendMode("VIVIDLIGHT", 18);
        PINLIGHT = new BlendMode("PINLIGHT", 19);
        HARDMIX = new BlendMode("HARDMIX", 20);
        REFLECT = new BlendMode("REFLECT", 21);
        GLOW = new BlendMode("GLOW", 22);
        PHOENIX = new BlendMode("PHOENIX", 23);
        HUE = new BlendMode("HUE", 24);
        SATURATION = new BlendMode("SATURATION", 25);
        COLOR = new BlendMode("COLOR", 26);
        LUMINOSITY = new BlendMode("LUMINOSITY", 27);
        DIFFERENCE = new BlendMode("DIFFERENCE", 28);
        $VALUES = (new BlendMode[] {
            NORMAL, LIGHTEN, DARKEN, MULTIPLY, AVERAGE, ADD, SUBSTRACT, NEGATION, EXCLUSION, SCREEN, 
            OVERLAY, SOFTLIGHT, HARDLIGHT, COLORDODGE, COLORBURN, LINEARDODGE, LINEARBURN, LINEARLIGHT, VIVIDLIGHT, PINLIGHT, 
            HARDMIX, REFLECT, GLOW, PHOENIX, HUE, SATURATION, COLOR, LUMINOSITY, DIFFERENCE
        });
    }
}
