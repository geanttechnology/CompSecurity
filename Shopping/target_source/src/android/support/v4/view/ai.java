// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.a.d;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;

// Referenced classes of package android.support.v4.view:
//            bh, a, ab, ba

public class ai
{

    static final j a;

    public static boolean A(View view)
    {
    /* block-local class not found */
    class j {}

        return a.C(view);
    }

    public static float B(View view)
    {
        return a.D(view);
    }

    public static boolean C(View view)
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

    public static bh a(View view, bh bh)
    {
        return a.a(view, bh);
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

    public static void a(View view, Paint paint)
    {
        a.a(view, paint);
    }

    public static void a(View view, d d1)
    {
        a.a(view, d1);
    }

    public static void a(View view, a a1)
    {
        a.a(view, a1);
    }

    public static void a(View view, ab ab)
    {
        a.a(view, ab);
    }

    public static void a(View view, AccessibilityEvent accessibilityevent)
    {
        a.a(view, accessibilityevent);
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
        a.a(viewgroup, flag);
    }

    public static boolean a(View view, int i1)
    {
        return a.a(view, i1);
    }

    public static boolean a(View view, int i1, Bundle bundle)
    {
        return a.a(view, i1, bundle);
    }

    public static bh b(View view, bh bh)
    {
        return a.b(view, bh);
    }

    public static void b(View view, float f1)
    {
        a.b(view, f1);
    }

    public static void b(View view, int i1, int j1, int k1, int l1)
    {
        a.b(view, i1, j1, k1, l1);
    }

    public static void b(View view, boolean flag)
    {
        a.b(view, flag);
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

    public static boolean j(View view)
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

    public static int m(View view)
    {
        return a.m(view);
    }

    public static int n(View view)
    {
        return a.n(view);
    }

    public static float o(View view)
    {
        return a.o(view);
    }

    public static float p(View view)
    {
        return a.p(view);
    }

    public static int q(View view)
    {
        return a.r(view);
    }

    public static int r(View view)
    {
        return a.s(view);
    }

    public static ba s(View view)
    {
        return a.t(view);
    }

    public static float t(View view)
    {
        return a.q(view);
    }

    public static int u(View view)
    {
        return a.u(view);
    }

    public static void v(View view)
    {
        a.v(view);
    }

    public static boolean w(View view)
    {
        return a.y(view);
    }

    public static void x(View view)
    {
        a.z(view);
    }

    public static boolean y(View view)
    {
        return a.A(view);
    }

    public static void z(View view)
    {
        a.B(view);
    }

    static 
    {
        int i1 = android.os.Build.VERSION.SDK_INT;
    /* block-local class not found */
    class a {}

    /* block-local class not found */
    class b {}

    /* block-local class not found */
    class c {}

    /* block-local class not found */
    class d {}

    /* block-local class not found */
    class e {}

    /* block-local class not found */
    class f {}

    /* block-local class not found */
    class g {}

    /* block-local class not found */
    class h {}

    /* block-local class not found */
    class i {}

        if (i1 >= 21)
        {
            a = new i();
        } else
        if (i1 >= 19)
        {
            a = new h();
        } else
        if (i1 >= 17)
        {
            a = new g();
        } else
        if (i1 >= 16)
        {
            a = new f();
        } else
        if (i1 >= 14)
        {
            a = new e();
        } else
        if (i1 >= 11)
        {
            a = new d();
        } else
        if (i1 >= 9)
        {
            a = new c();
        } else
        if (i1 >= 7)
        {
            a = new b();
        } else
        {
            a = new a();
        }
    }

    // Unreferenced inner class android/support/v4/view/ViewCompat$AccessibilityLiveRegion
    /* block-local class not found */
    class ViewCompat.AccessibilityLiveRegion {}


    // Unreferenced inner class android/support/v4/view/ViewCompat$ImportantForAccessibility
    /* block-local class not found */
    class ViewCompat.ImportantForAccessibility {}


    // Unreferenced inner class android/support/v4/view/ViewCompat$LayerType
    /* block-local class not found */
    class ViewCompat.LayerType {}


    // Unreferenced inner class android/support/v4/view/ViewCompat$LayoutDirectionMode
    /* block-local class not found */
    class ViewCompat.LayoutDirectionMode {}


    // Unreferenced inner class android/support/v4/view/ViewCompat$OverScroll
    /* block-local class not found */
    class ViewCompat.OverScroll {}


    // Unreferenced inner class android/support/v4/view/ViewCompat$ResolvedLayoutDirectionMode
    /* block-local class not found */
    class ViewCompat.ResolvedLayoutDirectionMode {}

}
