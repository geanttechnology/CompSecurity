// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.transcoder;

import java.util.Comparator;

public final class CompressionQuality extends Enum
    implements Comparator
{

    private static final CompressionQuality $VALUES[];
    public static final CompressionQuality QUALITY_1080P;
    public static final CompressionQuality QUALITY_160P;
    public static final CompressionQuality QUALITY_180P;
    public static final CompressionQuality QUALITY_240P;
    public static final CompressionQuality QUALITY_288P;
    public final int audioBitrate;
    public final int boundingSize;
    public final int videoBitrate;

    private CompressionQuality(String s, int i, int j, int k, int l)
    {
        super(s, i);
        boundingSize = j;
        videoBitrate = k;
        audioBitrate = l;
    }

    public static CompressionQuality valueOf(String s)
    {
        return (CompressionQuality)Enum.valueOf(com/amazon/gallery/framework/transcoder/CompressionQuality, s);
    }

    public static CompressionQuality[] values()
    {
        return (CompressionQuality[])$VALUES.clone();
    }

    public int compare(CompressionQuality compressionquality, CompressionQuality compressionquality1)
    {
        if (compressionquality.videoBitrate < compressionquality1.videoBitrate)
        {
            return -1;
        }
        return compressionquality.videoBitrate <= compressionquality1.videoBitrate ? 0 : 1;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((CompressionQuality)obj, (CompressionQuality)obj1);
    }

    static 
    {
        QUALITY_1080P = new CompressionQuality("QUALITY_1080P", 0, 1920, 0x7d0000, 0x18000);
        QUALITY_288P = new CompressionQuality("QUALITY_288P", 1, 512, 0xfa000, 49152);
        QUALITY_240P = new CompressionQuality("QUALITY_240P", 2, 384, 0x7d000, 24576);
        QUALITY_180P = new CompressionQuality("QUALITY_180P", 3, 320, 0x60400, 24576);
        QUALITY_160P = new CompressionQuality("QUALITY_160P", 4, 284, 0x3fc00, 12288);
        $VALUES = (new CompressionQuality[] {
            QUALITY_1080P, QUALITY_288P, QUALITY_240P, QUALITY_180P, QUALITY_160P
        });
    }
}
