// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


// Referenced classes of package com.mopub.common:
//            k

public static final class  extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c d[];

    public static  a( )
    {
        if ( == c)
        {
            return c;
        }
        if ( == b)
        {
            return b;
        } else
        {
            return a;
        }
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/mopub/common/k$a, s);
    }

    public static f[] values()
    {
        return (f[])d.clone();
    }

    static 
    {
        a = new <init>("NORMAL", 0);
        b = new <init>("TRUNCATED", 1);
        c = new <init>("DISABLED", 2);
        d = (new d[] {
            a, b, c
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
