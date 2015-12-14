// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imageformat;


public final class ImageFormat extends Enum
{

    private static final ImageFormat $VALUES[];
    public static final ImageFormat BMP;
    public static final ImageFormat GIF;
    public static final ImageFormat JPEG;
    public static final ImageFormat PNG;
    public static final ImageFormat UNKNOWN;
    public static final ImageFormat WEBP_ANIMATED;
    public static final ImageFormat WEBP_EXTENDED;
    public static final ImageFormat WEBP_EXTENDED_WITH_ALPHA;
    public static final ImageFormat WEBP_LOSSLESS;
    public static final ImageFormat WEBP_SIMPLE;

    private ImageFormat(String s, int i)
    {
        super(s, i);
    }

    public static boolean isWebpFormat(ImageFormat imageformat)
    {
        return imageformat == WEBP_SIMPLE || imageformat == WEBP_LOSSLESS || imageformat == WEBP_EXTENDED || imageformat == WEBP_EXTENDED_WITH_ALPHA || imageformat == WEBP_ANIMATED;
    }

    public static ImageFormat valueOf(String s)
    {
        return (ImageFormat)Enum.valueOf(com/facebook/imageformat/ImageFormat, s);
    }

    public static ImageFormat[] values()
    {
        return (ImageFormat[])$VALUES.clone();
    }

    static 
    {
        WEBP_SIMPLE = new ImageFormat("WEBP_SIMPLE", 0);
        WEBP_LOSSLESS = new ImageFormat("WEBP_LOSSLESS", 1);
        WEBP_EXTENDED = new ImageFormat("WEBP_EXTENDED", 2);
        WEBP_EXTENDED_WITH_ALPHA = new ImageFormat("WEBP_EXTENDED_WITH_ALPHA", 3);
        WEBP_ANIMATED = new ImageFormat("WEBP_ANIMATED", 4);
        JPEG = new ImageFormat("JPEG", 5);
        PNG = new ImageFormat("PNG", 6);
        GIF = new ImageFormat("GIF", 7);
        BMP = new ImageFormat("BMP", 8);
        UNKNOWN = new ImageFormat("UNKNOWN", 9);
        $VALUES = (new ImageFormat[] {
            WEBP_SIMPLE, WEBP_LOSSLESS, WEBP_EXTENDED, WEBP_EXTENDED_WITH_ALPHA, WEBP_ANIMATED, JPEG, PNG, GIF, BMP, UNKNOWN
        });
    }
}
