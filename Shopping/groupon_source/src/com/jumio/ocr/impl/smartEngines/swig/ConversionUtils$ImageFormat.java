// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jumio.ocr.impl.smartEngines.swig;


public final class c
{

    public static final FORMAT_UNKNOWN FORMAT_JPEG;
    public static final FORMAT_UNKNOWN FORMAT_PNG;
    public static final FORMAT_UNKNOWN FORMAT_TIFF;
    public static final FORMAT_UNKNOWN FORMAT_UNKNOWN;
    public static final FORMAT_UNKNOWN FORMAT_WEBP;
    private static FORMAT_UNKNOWN a[];
    private static int b = 0;
    private final int c;
    private final String d;

    public static c swigToEnum(int i)
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

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/jumio/ocr/impl/smartEngines/swig/ConversionUtils$ImageFormat).append(" with value ").append(i).toString());
    }

    public final int swigValue()
    {
        return c;
    }

    public String toString()
    {
        return d;
    }

    static 
    {
        FORMAT_TIFF = new <init>("FORMAT_TIFF");
        FORMAT_JPEG = new <init>("FORMAT_JPEG");
        FORMAT_PNG = new <init>("FORMAT_PNG");
        FORMAT_WEBP = new <init>("FORMAT_WEBP");
        FORMAT_UNKNOWN = new <init>("FORMAT_UNKNOWN");
        a = (new a[] {
            FORMAT_TIFF, FORMAT_JPEG, FORMAT_PNG, FORMAT_WEBP, FORMAT_UNKNOWN
        });
    }

    private (String s)
    {
        d = s;
        int i = b;
        b = i + 1;
        c = i;
    }
}
