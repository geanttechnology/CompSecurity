// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.clientlib.impl.livenessAndTM;


public final class PixelFormatType
{

    public static final PixelFormatType PIXEL_FORMAT_BGRA_8;
    public static final PixelFormatType PIXEL_FORMAT_BGR_8;
    public static final PixelFormatType PIXEL_FORMAT_GRAY;
    public static final PixelFormatType PIXEL_FORMAT_RGBA_8;
    public static final PixelFormatType PIXEL_FORMAT_RGB_8;
    public static final PixelFormatType PIXEL_FORMAT_YUV420_NV21;
    private static PixelFormatType a[];
    private static int b = 0;
    private final int c;
    private final String d;

    private PixelFormatType(String s)
    {
        d = s;
        int i = b;
        b = i + 1;
        c = i;
    }

    public static PixelFormatType swigToEnum(int i)
    {
        if (i < a.length && i >= 0 && a[i].c == i)
        {
            return a[i];
        }
        for (int j = 0; j < a.length; j++)
        {
            if (a[j].c == i)
            {
                return a[j];
            }
        }

        throw new IllegalArgumentException((new StringBuilder("No enum ")).append(com/jumio/clientlib/impl/livenessAndTM/PixelFormatType).append(" with value ").append(i).toString());
    }

    public final int swigValue()
    {
        return c;
    }

    public final String toString()
    {
        return d;
    }

    static 
    {
        PIXEL_FORMAT_RGB_8 = new PixelFormatType("PIXEL_FORMAT_RGB_8");
        PIXEL_FORMAT_RGBA_8 = new PixelFormatType("PIXEL_FORMAT_RGBA_8");
        PIXEL_FORMAT_BGR_8 = new PixelFormatType("PIXEL_FORMAT_BGR_8");
        PIXEL_FORMAT_BGRA_8 = new PixelFormatType("PIXEL_FORMAT_BGRA_8");
        PIXEL_FORMAT_YUV420_NV21 = new PixelFormatType("PIXEL_FORMAT_YUV420_NV21");
        PIXEL_FORMAT_GRAY = new PixelFormatType("PIXEL_FORMAT_GRAY");
        a = (new PixelFormatType[] {
            PIXEL_FORMAT_RGB_8, PIXEL_FORMAT_RGBA_8, PIXEL_FORMAT_BGR_8, PIXEL_FORMAT_BGRA_8, PIXEL_FORMAT_YUV420_NV21, PIXEL_FORMAT_GRAY
        });
    }
}
