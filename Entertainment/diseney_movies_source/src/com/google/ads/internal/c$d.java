// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.internal;


// Referenced classes of package com.google.ads.internal:
//            c

public static final class e extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d f[];
    public String e;

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/google/ads/internal/c$d, s);
    }

    public static e[] values()
    {
        return (e[])f.clone();
    }

    static 
    {
        a = new <init>("ONLINE_USING_BUFFERED_ADS", 0, "online_buffered");
        b = new <init>("ONLINE_SERVER_REQUEST", 1, "online_request");
        c = new <init>("OFFLINE_USING_BUFFERED_ADS", 2, "offline_buffered");
        d = new <init>("OFFLINE_EMPTY", 3, "offline_empty");
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
