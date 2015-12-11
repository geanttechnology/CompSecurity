// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


// Referenced classes of package com.g.c:
//            u

public static final class d extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c e[];
    final int d;

    public static ring valueOf(String s)
    {
        return (ring)Enum.valueOf(com/g/c/u$d, s);
    }

    public static ring[] values()
    {
        return (ring[])e.clone();
    }

    static 
    {
        a = new <init>("MEMORY", 0, 0xff00ff00);
        b = new <init>("DISK", 1, 0xff0000ff);
        c = new <init>("NETWORK", 2, 0xffff0000);
        e = (new e[] {
            a, b, c
        });
    }

    private ring(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }
}
