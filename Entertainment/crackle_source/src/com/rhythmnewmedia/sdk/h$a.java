// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;


// Referenced classes of package com.rhythmnewmedia.sdk:
//            h, z, k, j, 
//            l

public static final class d extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c e[];
    private final h d;

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/rhythmnewmedia/sdk/h$a, s);
    }

    public static d[] values()
    {
        return (d[])e.clone();
    }

    public final h a()
    {
        return d;
    }

    static 
    {
        a = new <init>("rhythm", 0, (h)z.a.a(com/rhythmnewmedia/sdk/k, new Object[0]));
        b = new <init>("ormma", 1, (h)z.a.a(com/rhythmnewmedia/sdk/j, new Object[0]));
        c = new <init>("rhythmLegacy", 2, (h)z.a.a(com/rhythmnewmedia/sdk/l, new Object[0]));
        e = (new e[] {
            a, b, c
        });
    }

    private (String s, int i, h h1)
    {
        super(s, i);
        d = h1;
    }
}
