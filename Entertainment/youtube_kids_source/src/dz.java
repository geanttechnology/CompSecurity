// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Paint;
import android.view.View;

public final class dz
{

    private static ej a;

    public static int a(int i, int j, int k)
    {
        return a.a(i, j, k);
    }

    public static int a(View view)
    {
        return a.b(view);
    }

    public static void a(View view, float f1)
    {
        a.a(view, f1);
    }

    public static void a(View view, int i, Paint paint)
    {
        a.a(view, i, null);
    }

    public static void a(View view, Runnable runnable)
    {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long l)
    {
        a.a(view, runnable, l);
    }

    public static int b(View view)
    {
        return a.c(view);
    }

    public static float c(View view)
    {
        return a.d(view);
    }

    public static int d(View view)
    {
        return a.e(view);
    }

    public static ep e(View view)
    {
        return a.f(view);
    }

    public static int f(View view)
    {
        return a.g(view);
    }

    public static void g(View view)
    {
        a.a(view);
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 21)
        {
            a = new ea();
        } else
        if (i >= 19)
        {
            a = new ei();
        } else
        if (i >= 17)
        {
            a = new eh();
        } else
        if (i >= 16)
        {
            a = new eg();
        } else
        if (i >= 14)
        {
            a = new ef();
        } else
        if (i >= 11)
        {
            a = new ee();
        } else
        if (i >= 9)
        {
            a = new ed();
        } else
        if (i >= 7)
        {
            a = new ec();
        } else
        {
            a = new eb();
        }
    }
}
