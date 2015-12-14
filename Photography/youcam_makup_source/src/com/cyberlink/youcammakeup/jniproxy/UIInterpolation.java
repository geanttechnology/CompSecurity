// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.jniproxy;


// Referenced classes of package com.cyberlink.youcammakeup.jniproxy:
//            aw

public final class UIInterpolation extends Enum
{

    public static final UIInterpolation a;
    public static final UIInterpolation b;
    public static final UIInterpolation c;
    public static final UIInterpolation d;
    public static final UIInterpolation e;
    private static final UIInterpolation f[];
    private final int swigValue;

    private UIInterpolation(String s, int i)
    {
        super(s, i);
        swigValue = aw.a();
    }

    private UIInterpolation(String s, int i, int j)
    {
        super(s, i);
        swigValue = j;
        aw.a(j + 1);
    }

    public static UIInterpolation valueOf(String s)
    {
        return (UIInterpolation)Enum.valueOf(com/cyberlink/youcammakeup/jniproxy/UIInterpolation, s);
    }

    public static UIInterpolation[] values()
    {
        return (UIInterpolation[])f.clone();
    }

    public final int a()
    {
        return swigValue;
    }

    static 
    {
        a = new UIInterpolation("DEFAULT", 0, 0);
        b = new UIInterpolation("BILINEAR", 1);
        c = new UIInterpolation("BICUBIC", 2);
        d = new UIInterpolation("LANCZOS", 3);
        e = new UIInterpolation("SUPER", 4);
        f = (new UIInterpolation[] {
            a, b, c, d, e
        });
    }
}
