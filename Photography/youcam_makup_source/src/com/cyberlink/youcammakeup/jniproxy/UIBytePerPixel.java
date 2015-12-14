// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            o

public final class UIBytePerPixel extends Enum
{

    public static final UIBytePerPixel a;
    public static final UIBytePerPixel b;
    private static final UIBytePerPixel c[];
    private final int swigValue;

    private UIBytePerPixel(String s, int i, int j)
    {
        super(s, i);
        swigValue = j;
        o.a(j + 1);
    }

    public static UIBytePerPixel valueOf(String s)
    {
        return (UIBytePerPixel)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIBytePerPixel, s);
    }

    public static UIBytePerPixel[] values()
    {
        return (UIBytePerPixel[])c.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIBytePerPixel("PIXEL_4BYTE", 0, 4);
        b = new UIBytePerPixel("PIXEL_8BYTE", 1, 8);
        c = (new UIBytePerPixel[] {
            a, b
        });
    }
}
