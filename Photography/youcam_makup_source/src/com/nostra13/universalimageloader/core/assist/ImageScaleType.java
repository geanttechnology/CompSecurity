// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core.assist;


public final class ImageScaleType extends Enum
{

    public static final ImageScaleType a;
    public static final ImageScaleType b;
    public static final ImageScaleType c;
    public static final ImageScaleType d;
    public static final ImageScaleType e;
    public static final ImageScaleType f;
    private static final ImageScaleType g[];

    private ImageScaleType(String s, int i)
    {
        super(s, i);
    }

    public static ImageScaleType valueOf(String s)
    {
        return (ImageScaleType)Enum.valueOf(com/nostra13/universalimageloader/core/assist/ImageScaleType, s);
    }

    public static ImageScaleType[] values()
    {
        return (ImageScaleType[])g.clone();
    }

    static 
    {
        a = new ImageScaleType("NONE", 0);
        b = new ImageScaleType("NONE_SAFE", 1);
        c = new ImageScaleType("IN_SAMPLE_POWER_OF_2", 2);
        d = new ImageScaleType("IN_SAMPLE_INT", 3);
        e = new ImageScaleType("EXACTLY", 4);
        f = new ImageScaleType("EXACTLY_STRETCHED", 5);
        g = (new ImageScaleType[] {
            a, b, c, d, e, f
        });
    }
}
