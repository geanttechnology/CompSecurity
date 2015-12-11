// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;


// Referenced classes of package com.mopub.common.a:
//            a

public static final class d extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    private static final c e[];
    final String d;

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/mopub/common/a/a$d, s);
    }

    public static d[] values()
    {
        return (d[])e.clone();
    }

    static 
    {
        a = new <init>("AD_REQUEST", 0, "ad_request");
        b = new <init>("IMPRESSION_REQUEST", 1, "impression_request");
        c = new <init>("CLICK_REQUEST", 2, "click_request");
        e = (new e[] {
            a, b, c
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }
}
