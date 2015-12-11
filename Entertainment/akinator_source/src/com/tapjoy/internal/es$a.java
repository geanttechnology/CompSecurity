// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            es

static final class  extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d e[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/tapjoy/internal/es$a, s);
    }

    public static [] values()
    {
        return ([])e.clone();
    }

    static 
    {
        a = new <init>("GET", 0);
        b = new <init>("GET_CONSUME", 1);
        c = new <init>("POST", 2);
        d = new <init>("POST_CONSUME", 3);
        e = (new e[] {
            a, b, c, d
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
