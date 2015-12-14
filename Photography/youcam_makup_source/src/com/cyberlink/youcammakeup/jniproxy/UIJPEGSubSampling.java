// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            ay

public final class UIJPEGSubSampling extends Enum
{

    public static final UIJPEGSubSampling a;
    public static final UIJPEGSubSampling b;
    public static final UIJPEGSubSampling c;
    public static final UIJPEGSubSampling d;
    private static final UIJPEGSubSampling e[];
    private final int swigValue;

    private UIJPEGSubSampling(String s, int i, int j)
    {
        super(s, i);
        swigValue = j;
        ay.a(j + 1);
    }

    public static UIJPEGSubSampling valueOf(String s)
    {
        return (UIJPEGSubSampling)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIJPEGSubSampling, s);
    }

    public static UIJPEGSubSampling[] values()
    {
        return (UIJPEGSubSampling[])e.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIJPEGSubSampling("JPEG_SUBSAMPLING_DEFAULT", 0, 0);
        b = new UIJPEGSubSampling("JPEG_SUBSAMPLING_420", 1, 1);
        c = new UIJPEGSubSampling("JPEG_SUBSAMPLING_422", 2, 2);
        d = new UIJPEGSubSampling("JPEG_SUBSAMPLING_444", 3, 3);
        e = (new UIJPEGSubSampling[] {
            a, b, c, d
        });
    }
}
