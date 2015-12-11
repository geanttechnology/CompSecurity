// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


public class AdCreative
{

    public static final String kAlignmentBottom = "bottom";
    public static final String kAlignmentCenter = "center";
    public static final String kAlignmentLeft = "left";
    public static final String kAlignmentMiddle = "middle";
    public static final String kAlignmentRight = "right";
    public static final String kAlignmentTop = "top";
    public static final String kFixBoth = "both";
    public static final String kFixHeight = "height";
    public static final String kFixNone = "none";
    public static final String kFixWidth = "width";
    public static final String kFormatBanner = "banner";
    public static final String kFormatCustom = "custom";
    public static final String kFormatTakeover = "takeover";
    private int v;
    private int w;
    private String x;
    private String y;
    private String z;

    AdCreative(int i, int j, String s, String s1, String s2)
    {
        v = i;
        w = j;
        x = s;
        y = s1;
        z = s2;
    }

    public String getAlignment()
    {
        return z;
    }

    public String getFix()
    {
        return y;
    }

    public String getFormat()
    {
        return x;
    }

    public int getHeight()
    {
        return v;
    }

    public int getWidth()
    {
        return w;
    }
}
