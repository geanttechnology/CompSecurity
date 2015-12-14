// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            bh

public final class UITiffCompression extends Enum
{

    public static final UITiffCompression a;
    public static final UITiffCompression b;
    public static final UITiffCompression c;
    private static final UITiffCompression d[];
    private final int swigValue = bh.a();

    private UITiffCompression(String s, int i)
    {
        super(s, i);
    }

    public static UITiffCompression valueOf(String s)
    {
        return (UITiffCompression)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UITiffCompression, s);
    }

    public static UITiffCompression[] values()
    {
        return (UITiffCompression[])d.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UITiffCompression("ENC_TIFF_COMPRESS_NONE", 0);
        b = new UITiffCompression("ENC_TIFF_COMPRESS_ZIP", 1);
        c = new UITiffCompression("ENC_TIFF_COMPRESS_LZW", 2);
        d = (new UITiffCompression[] {
            a, b, c
        });
    }
}
