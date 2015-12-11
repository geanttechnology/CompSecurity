// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ae;


// Referenced classes of package com.shazam.android.ae:
//            p, n, b

public final class m
{

    private static p a;

    public static void a(p p1)
    {
        a = p1;
    }

    public static void a(Object obj, String s)
    {
        a.a(n.e, b.a(obj), s);
    }

    public static void a(Object obj, String s, Throwable throwable)
    {
        a.a(n.e, b.a(obj), s, throwable);
    }

    public static transient void a(Object obj, Throwable throwable, String s, Object aobj[])
    {
        a.a(n.e, b.a(obj), throwable, s, aobj);
    }

    static 
    {
        a = p.a;
    }
}
