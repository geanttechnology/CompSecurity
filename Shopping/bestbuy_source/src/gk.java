// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class gk
{

    public static gl a;
    private static String b = gk.getSimpleName();

    public gk()
    {
    }

    public static void a(ft ft1)
    {
        if (ft1 == ft.a)
        {
            a = gl.a;
            return;
        }
        if (ft1 == ft.f)
        {
            a = gl.b;
            return;
        }
        if (ft1 == ft.d)
        {
            a = gl.c;
            return;
        }
        if (ft1 == ft.c)
        {
            a = gl.d;
            return;
        }
        if (ft1 == ft.l)
        {
            a = gl.e;
            return;
        } else
        {
            a = gl.a;
            return;
        }
    }

}
