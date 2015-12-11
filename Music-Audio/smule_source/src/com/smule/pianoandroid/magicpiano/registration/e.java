// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Activity;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.c.j;
import com.smule.android.c.k;
import com.smule.pianoandroid.utils.o;

public class e
{

    private static String a = com/smule/pianoandroid/magicpiano/registration/e.getName();
    private static boolean b = false;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static Runnable i = null;
    private static Runnable j = null;

    public e()
    {
    }

    public static void a()
    {
        b = false;
        c = false;
        d = false;
        e = false;
        g = false;
        f();
    }

    public static void a(Activity activity)
    {
        if (i != null)
        {
            activity.finish();
            i.run();
        } else
        {
            o.c(activity);
            activity.finish();
        }
        f();
    }

    public static void a(Runnable runnable)
    {
        i = runnable;
    }

    public static void a(boolean flag)
    {
        e = true;
        f = flag;
        e();
    }

    public static void b()
    {
        b = true;
        e();
    }

    public static void b(Activity activity)
    {
        if (j != null)
        {
            j.run();
        }
        f();
    }

    public static void b(Runnable runnable)
    {
        j = runnable;
    }

    public static void b(boolean flag)
    {
        g = true;
        h = flag;
        e();
    }

    public static void c()
    {
        c = true;
        e();
    }

    public static void d()
    {
        d = true;
        e();
    }

    private static void e()
    {
        Object obj = null;
        j j1;
        if (b)
        {
            j1 = j.b;
            obj = k.c;
        } else
        if (d)
        {
            j1 = j.a;
            obj = k.a;
        } else
        if (c)
        {
            j1 = j.b;
            obj = k.a;
        } else
        if (e)
        {
            k k1;
            if (e)
            {
                obj = j.a;
            } else
            {
                obj = j.b;
            }
            k1 = k.b;
            j1 = ((j) (obj));
            obj = k1;
        } else
        if (g)
        {
            k k2;
            if (h)
            {
                obj = j.a;
            } else
            {
                obj = j.b;
            }
            k2 = k.d;
            j1 = ((j) (obj));
            obj = k2;
        } else
        {
            aa.b(a, "Don't know how the login finished! Not enough information.");
            j1 = null;
        }
        com.smule.android.c.a.a(j1, ((k) (obj)));
    }

    private static void f()
    {
        i = null;
        j = null;
    }

}
