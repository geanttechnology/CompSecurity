// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;


// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            h

public static final class  extends Enum
{

    public static final p a;
    public static final p b;
    public static final p c;
    public static final p d;
    public static final p e;
    public static final p f;
    public static final p g;
    public static final p h;
    public static final p i;
    public static final p j;
    public static final p k;
    public static final p l;
    public static final p m;
    public static final p n;
    public static final p o;
    public static final p p;
    private static final p q[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/tremorvideo/sdk/android/richmedia/h$c, s);
    }

    public static [] values()
    {
        return ([])q.clone();
    }

    static 
    {
        a = new <init>("None", 0);
        b = new <init>("VideoStart", 1);
        c = new <init>("VideoEnd", 2);
        d = new <init>("TouchDown", 3);
        e = new <init>("TouchRelease", 4);
        f = new <init>("SceneStart", 5);
        g = new <init>("SceneEnd", 6);
        h = new <init>("SceneExit", 7);
        i = new <init>("Shake", 8);
        j = new <init>("DropEnter", 9);
        k = new <init>("DropRelease", 10);
        l = new <init>("DropCancel", 11);
        m = new <init>("Code", 12);
        n = new <init>("AgePass", 13);
        o = new <init>("AgeFail", 14);
        p = new <init>("Timer", 15);
        q = (new q[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o, p
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
