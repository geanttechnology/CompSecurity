// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


// Referenced classes of package com.a.a:
//            m

public static final class ring extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static ring valueOf(String s)
    {
        return (ring)Enum.valueOf(com/a/a/m$a, s);
    }

    public static ring[] values()
    {
        return (ring[])e.clone();
    }

    static 
    {
        a = new <init>("LOW", 0);
        b = new <init>("NORMAL", 1);
        c = new <init>("HIGH", 2);
        d = new <init>("IMMEDIATE", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private ring(String s, int i)
    {
        super(s, i);
    }
}
