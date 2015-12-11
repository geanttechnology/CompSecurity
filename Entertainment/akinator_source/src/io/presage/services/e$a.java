// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services;


// Referenced classes of package io.presage.services:
//            e

private static final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(io/presage/services/e$a, s);
    }

    public static [] values()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("ONCE", 0);
        b = new <init>("PERIODIC", 1);
        c = new <init>("GREATER", 2);
        d = new <init>("EVENT", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
