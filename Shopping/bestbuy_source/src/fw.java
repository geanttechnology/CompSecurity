// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class fw
{

    private static final String a = fw.getSimpleName();
    private static fx b;

    public fw()
    {
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            b = fx.a;
            return;
        }
        if (ft1 == ft.f)
        {
            b = fx.b;
            return;
        }
        if (ft1 == ft.h)
        {
            b = fx.c;
            return;
        }
        if (ft1 == ft.l)
        {
            b = fx.d;
            return;
        } else
        {
            b = fx.a;
            return;
        }
    }

    public static void a(String s)
    {
        fx.a("CUSTOM").e = s;
    }

    static 
    {
        b = fx.a;
    }
}
