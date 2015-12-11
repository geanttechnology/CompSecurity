// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;


// Referenced classes of package com.mopub.common.a:
//            a

public static final class b extends Enum
{

    public static final a a;
    private static final a c[];
    final String b;

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/mopub/common/a/a$c, s);
    }

    public static b[] values()
    {
        return (b[])c.clone();
    }

    static 
    {
        a = new <init>("REQUESTS", "requests");
        c = (new c[] {
            a
        });
    }

    private (String s, String s1)
    {
        super(s, 0);
        b = s1;
    }
}
