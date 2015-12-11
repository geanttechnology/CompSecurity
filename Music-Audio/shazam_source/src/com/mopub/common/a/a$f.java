// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.a;


// Referenced classes of package com.mopub.common.a:
//            a

public static final class c extends Enum
{

    public static final b a;
    public static final b b;
    private static final b d[];
    final String c;

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/mopub/common/a/a$f, s);
    }

    public static c[] values()
    {
        return (c[])d.clone();
    }

    static 
    {
        a = new <init>("EXCHANGE_CLIENT_EVENT", 0, "exchange_client_event");
        b = new <init>("EXCHANGE_CLIENT_ERROR", 1, "exchange_client_error");
        d = (new d[] {
            a, b
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        c = s1;
    }
}
