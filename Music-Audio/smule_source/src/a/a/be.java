// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;

// Referenced classes of package a.a:
//            u, ah, cn

public final class be
{

    private static u a = null;
    private static Context b = null;
    private static ah c = null;
    private static cn d = null;

    static u a()
    {
        return a;
    }

    public static void a(ah ah)
    {
        c = ah;
    }

    public static void a(cn cn)
    {
        d = cn;
    }

    public static void a(u u)
    {
        a = u;
    }

    public static void a(Context context)
    {
        b = context;
    }

    static Context b()
    {
        return b;
    }

    static ah c()
    {
        return c;
    }

    static cn d()
    {
        return d;
    }

}
