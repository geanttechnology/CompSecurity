// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ar

public static final class f extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e g[];
    private String f;

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/millennialmedia/android/ar$e, s);
    }

    public static f[] values()
    {
        return (f[])g.clone();
    }

    public final String toString()
    {
        return f;
    }

    static 
    {
        a = new <init>("ERROR", 0, "error");
        b = new <init>("VOCALIZING", 1, "vocalizing");
        c = new <init>("RECORDING", 2, "recording");
        d = new <init>("READY", 3, "ready");
        e = new <init>("PROCESSING", 4, "processing");
        g = (new g[] {
            a, b, c, d, e
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }
}
