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
    private int a;
    private int b;
    private String c;
    private String d;
    private String e;

    public AdCreative(int i, int j, String s, String s1, String s2)
    {
        a = i;
        b = j;
        c = s;
        d = s1;
        e = s2;
    }

    public String getAlignment()
    {
        return e;
    }

    public String getFix()
    {
        return d;
    }

    public String getFormat()
    {
        return c;
    }

    public int getHeight()
    {
        return a;
    }

    public int getWidth()
    {
        return b;
    }
}
