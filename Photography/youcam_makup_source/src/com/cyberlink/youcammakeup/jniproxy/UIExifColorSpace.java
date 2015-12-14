// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            w

public final class UIExifColorSpace extends Enum
{

    public static final UIExifColorSpace a;
    public static final UIExifColorSpace b;
    public static final UIExifColorSpace c;
    public static final UIExifColorSpace d;
    public static final UIExifColorSpace e;
    private static final UIExifColorSpace f[];
    private final int swigValue = w.a();

    private UIExifColorSpace(String s, int i)
    {
        super(s, i);
    }

    public static UIExifColorSpace a(int i)
    {
        UIExifColorSpace auiexifcolorspace[] = (UIExifColorSpace[])com/cyberlink/youcammakeup/jniproxy/UIExifColorSpace.getEnumConstants();
        if (i < auiexifcolorspace.length && i >= 0 && auiexifcolorspace[i].swigValue == i)
        {
            return auiexifcolorspace[i];
        }
        int k = auiexifcolorspace.length;
        for (int j = 0; j < k; j++)
        {
            UIExifColorSpace uiexifcolorspace = auiexifcolorspace[j];
            if (uiexifcolorspace.swigValue == i)
            {
                return uiexifcolorspace;
            }
        }

        throw new IllegalArgumentException((new StringBuilder()).append("No enum ").append(com/cyberlink/youcammakeup/jniproxy/UIExifColorSpace).append(" with value ").append(i).toString());
    }

    public static UIExifColorSpace valueOf(String s)
    {
        return (UIExifColorSpace)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIExifColorSpace, s);
    }

    public static UIExifColorSpace[] values()
    {
        return (UIExifColorSpace[])f.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIExifColorSpace("COLOR_SPACE_NONE", 0);
        b = new UIExifColorSpace("COLOR_SPACE_SRGB", 1);
        c = new UIExifColorSpace("COLOR_SPACE_PROPHOTO", 2);
        d = new UIExifColorSpace("COLOR_SPACE_AdobeRGB", 3);
        e = new UIExifColorSpace("COLOR_SPACE_CUSTOM", 4);
        f = (new UIExifColorSpace[] {
            a, b, c, d, e
        });
    }
}
