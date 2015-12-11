// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;


// Referenced classes of package com.facebook:
//            h

public static final class nit> extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static nit> valueOf(String s)
    {
        return (nit>)Enum.valueOf(com/facebook/h$a, s);
    }

    public static lueOf[] values()
    {
        return (lueOf[])d.clone();
    }

    static 
    {
        a = new <init>("LOGIN_RECOVERABLE", 0);
        b = new <init>("OTHER", 1);
        c = new <init>("TRANSIENT", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
