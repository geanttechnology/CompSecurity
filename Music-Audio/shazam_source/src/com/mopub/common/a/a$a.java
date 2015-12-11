// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;


// Referenced classes of package com.mopub.common.a:
//            a

public static final class e extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d f[];
    final int e;

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/mopub/common/a/a$a, s);
    }

    public static e[] values()
    {
        return (e[])f.clone();
    }

    static 
    {
        a = new <init>("NONE", 0, 0);
        b = new <init>("IOS", 1, 1);
        c = new <init>("ANDROID", 2, 2);
        d = new <init>("MOBILE_WEB", 3, 3);
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
