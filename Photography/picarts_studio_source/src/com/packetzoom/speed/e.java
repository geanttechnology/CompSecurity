// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.packetzoom.speed;


// Referenced classes of package com.packetzoom.speed:
//            PZLogLevel

public class e
{

    private static PZLogLevel a;

    public static void a(PZLogLevel pzloglevel)
    {
        a = pzloglevel;
    }

    public static void a(String s, String s1)
    {
        a.ordinal();
        PZLogLevel.pzlogINFO.ordinal();
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        a.ordinal();
        PZLogLevel.pzlogINFO.ordinal();
    }

    static 
    {
        a = PZLogLevel.pzlogINFO;
    }
}
