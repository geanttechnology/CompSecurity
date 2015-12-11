// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

// Referenced classes of package android.support.v4.view:
//            bs, br, bp, bo, 
//            bn, bm, bl, bk, 
//            bj, bt, dn, a, 
//            ba, cx

public final class bi
{

    private static bt a;

    public static void A(View view)
    {
        a.B(view);
    }

    public static boolean B(View view)
    {
        return a.C(view);
    }

    public static float C(View view)
    {
        return a.D(view);
    }

    public static boolean D(View view)
    {
        return a.E(view);
    }

    public static int a(int i1, int j1)
    {
        return a.a(i1, j1);
    }

    public static int a(int i1, int j1, int k1)
    {
        return a.a(i1, j1, k1);
    }

    public static int a(View view)
    {
        return a.a(view);
    }

    public static dn a(View view, dn dn)
    {
        return a.a(view, dn);
    }

    public static void a(View view, float f1)
    {
        a.a(view, f1);
    }

    public static void a(View view, int i1, int j1, int k1, int l1)
    {
        a.a(view, i1, j1, k1, l1);
    }

    public static void a(View view, int i1, Paint paint)
    {
        a.a(view, i1, paint);
    }

    public static void a(View view, ColorStateList colorstatelist)
    {
        a.a(view, colorstatelist);
    }

    public static void a(View view, android.graphics.PorterDuff.Mode mode)
    {
        a.a(view, mode);
    }

    public static void a(View view, a a1)
    {
        a.a(view, a1);
    }

    public static void a(View view, ba ba)
    {
        a.a(view, ba);
    }

    public static void a(View view, Runnable runnable)
    {
        a.a(view, runnable);
    }

    public static void a(View view, Runnable runnable, long l1)
    {
        a.a(view, runnable, l1);
    }

    public static void a(View view, boolean flag)
    {
        a.a(view, flag);
    }

    public static void a(ViewGroup viewgroup, boolean flag)
    {
        a.a(viewgroup, true);
    }

    public static boolean a(View view, int i1)
    {
        return a.a(view, i1);
    }

    public static dn b(View view, dn dn)
    {
        return a.b(view, dn);
    }

    public static void b(View view, float f1)
    {
        a.b(view, f1);
    }

    public static void b(View view, boolean flag)
    {
        a.b(view, false);
    }

    public static boolean b(View view)
    {
        return a.b(view);
    }

    public static boolean b(View view, int i1)
    {
        return a.b(view, i1);
    }

    public static void c(View view, float f1)
    {
        a.c(view, f1);
    }

    public static void c(View view, int i1)
    {
        a.c(view, i1);
    }

    public static void c(View view, boolean flag)
    {
        a.c(view, flag);
    }

    public static boolean c(View view)
    {
        return a.c(view);
    }

    public static void d(View view)
    {
        a.d(view);
    }

    public static void d(View view, float f1)
    {
        a.d(view, f1);
    }

    public static void d(View view, int i1)
    {
        view.offsetTopAndBottom(i1);
        if (i1 != 0 && android.os.Build.VERSION.SDK_INT < 11)
        {
            view.invalidate();
        }
    }

    public static int e(View view)
    {
        return a.e(view);
    }

    public static void e(View view, float f1)
    {
        a.e(view, f1);
    }

    public static void e(View view, int i1)
    {
        view.offsetLeftAndRight(i1);
        if (i1 != 0 && android.os.Build.VERSION.SDK_INT < 11)
        {
            view.invalidate();
        }
    }

    public static float f(View view)
    {
        return a.f(view);
    }

    public static void f(View view, float f1)
    {
        a.f(view, f1);
    }

    public static int g(View view)
    {
        return a.g(view);
    }

    public static int h(View view)
    {
        return a.h(view);
    }

    public static ViewParent i(View view)
    {
        return a.i(view);
    }

    public static int j(View view)
    {
        return a.j(view);
    }

    public static int k(View view)
    {
        return a.k(view);
    }

    public static int l(View view)
    {
        return a.l(view);
    }

    public static float m(View view)
    {
        return a.n(view);
    }

    public static float n(View view)
    {
        return a.o(view);
    }

    public static int o(View view)
    {
        return a.q(view);
    }

    public static int p(View view)
    {
        return a.r(view);
    }

    public static cx q(View view)
    {
        return a.s(view);
    }

    public static float r(View view)
    {
        return a.p(view);
    }

    public static float s(View view)
    {
        return a.v(view);
    }

    public static int t(View view)
    {
        return a.t(view);
    }

    public static void u(View view)
    {
        a.u(view);
    }

    public static boolean v(View view)
    {
        return a.x(view);
    }

    public static void w(View view)
    {
        a.y(view);
    }

    public static boolean x(View view)
    {
        return a.m(view);
    }

    public static boolean y(View view)
    {
        return a.z(view);
    }

    public static boolean z(View view)
    {
        return a.A(view);
    }

    static 
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
        if (i1 >= 21)
        {
            a = new bs();
        } else
        if (i1 >= 19)
        {
            a = new br();
        } else
        if (i1 >= 17)
        {
            a = new bp();
        } else
        if (i1 >= 16)
        {
            a = new bo();
        } else
        if (i1 >= 14)
        {
            a = new bn();
        } else
        if (i1 >= 11)
        {
            a = new bm();
        } else
        if (i1 >= 9)
        {
            a = new bl();
        } else
        if (i1 >= 7)
        {
            a = new bk();
        } else
        {
            a = new bj();
        }
    }
}
