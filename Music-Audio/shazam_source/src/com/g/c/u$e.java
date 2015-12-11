// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


// Referenced classes of package com.g.c:
//            u

public static final class ring extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static ring valueOf(String s)
    {
        return (ring)Enum.valueOf(com/g/c/u$e, s);
    }

    public static ring[] values()
    {
        return (ring[])d.clone();
    }

    static 
    {
        a = new <init>("LOW", 0);
        b = new <init>("NORMAL", 1);
        c = new <init>("HIGH", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private ring(String s, int i)
    {
        super(s, i);
    }
}
