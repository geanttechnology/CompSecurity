// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.c;


// Referenced classes of package com.smule.android.c:
//            b

public final class p extends Enum
    implements b
{

    public static final p a;
    public static final p b;
    private static final p d[];
    private String c;

    private p(String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }

    public static p valueOf(String s)
    {
        return (p)Enum.valueOf(com/smule/android/c/p, s);
    }

    public static p[] values()
    {
        return (p[])d.clone();
    }

    public String a()
    {
        return c;
    }

    static 
    {
        a = new p("SONG", 0, "song");
        b = new p("SOUNDFONT", 1, "soundfont");
        d = (new p[] {
            a, b
        });
    }
}
