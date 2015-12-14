// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            l

public final class PixelFormat extends Enum
{

    public static final PixelFormat a;
    public static final PixelFormat b;
    public static final PixelFormat c;
    public static final PixelFormat d;
    private static final PixelFormat e[];
    private final int swigValue;

    private PixelFormat(String s, int i)
    {
        super(s, i);
        swigValue = l.a();
    }

    private PixelFormat(String s, int i, int j)
    {
        super(s, i);
        swigValue = j;
        l.a(j + 1);
    }

    public static PixelFormat a(int i)
    {
        PixelFormat apixelformat[] = (PixelFormat[])com/cyberlink/youcammakeup/jniproxy/PixelFormat.getEnumConstants();
        if (i < apixelformat.length && i >= 0 && apixelformat[i].swigValue == i)
        {
            return apixelformat[i];
        }
        int k = apixelformat.length;
        for (int j = 0; j < k; j++)
        {
            PixelFormat pixelformat = apixelformat[j];
            if (pixelformat.swigValue == i)
            {
                return pixelformat;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/cyberlink/youcammakeup/jniproxy/PixelFormat).append(" with value ").append(i).toString());
    }

    public static PixelFormat valueOf(String s)
    {
        return (PixelFormat)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/PixelFormat, s);
    }

    public static PixelFormat[] values()
    {
        return (PixelFormat[])e.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new PixelFormat("Format32bppRGBA", 0, 0);
        b = new PixelFormat("Format32bppBGRA", 1);
        c = new PixelFormat("Format64bppRGBA", 2);
        d = new PixelFormat("Format64bppBGRA", 3);
        e = (new PixelFormat[] {
            a, b, c, d
        });
    }
}
