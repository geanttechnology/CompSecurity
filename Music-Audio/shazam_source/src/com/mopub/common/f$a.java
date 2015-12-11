// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


// Referenced classes of package com.mopub.common:
//            f

public static final class e extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d f[];
    public final int e;

    static e a(int i)
    {
        switch (i)
        {
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        default:
            return a;

        case 9: // '\t'
            return b;

        case 1: // '\001'
            return c;

        case 0: // '\0'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return d;
        }
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/mopub/common/f$a, s);
    }

    public static f[] values()
    {
        return (f[])f.clone();
    }

    public final String toString()
    {
        return Integer.toString(e);
    }

    static 
    {
        a = new <init>("UNKNOWN", 0, 0);
        b = new <init>("ETHERNET", 1, 1);
        c = new <init>("WIFI", 2, 2);
        d = new <init>("MOBILE", 3, 3);
        f = (new f[] {
            a, b, c, d
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        e = j;
    }
}
