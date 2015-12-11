// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;


// Referenced classes of package com.mopub.common.d:
//            c

public static final class e extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d f[];
    private final String e;

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/mopub/common/d/c$a, s);
    }

    public static e[] values()
    {
        return (e[])f.clone();
    }

    static 
    {
        a = new <init>("FORCE_PORTRAIT", 0, "portrait");
        b = new <init>("FORCE_LANDSCAPE", 1, "landscape");
        c = new <init>("DEVICE_ORIENTATION", 2, "device");
        d = new <init>("UNDEFINED", 3, "");
        f = (new f[] {
            a, b, c, d
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }
}
