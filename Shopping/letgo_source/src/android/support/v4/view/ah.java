// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            bf, a, ac, ay, 
//            ae, ai, y, aj, 
//            ak, al, am, an, 
//            ao, ap, aq

public class ah
{
    static class a
        implements j
    {

        WeakHashMap a;

        private boolean a(ae ae1, int i1)
        {
            int j1;
            int k1;
            boolean flag;
            flag = true;
            j1 = ae1.computeHorizontalScrollOffset();
            k1 = ae1.computeHorizontalScrollRange() - ae1.computeHorizontalScrollExtent();
            if (k1 != 0) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            if (i1 >= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j1 > 0) goto _L4; else goto _L3
_L3:
            return false;
            if (j1 < k1 - 1) goto _L4; else goto _L5
_L5:
            return false;
        }

        private boolean b(ae ae1, int i1)
        {
            int j1;
            int k1;
            boolean flag;
            flag = true;
            j1 = ae1.computeVerticalScrollOffset();
            k1 = ae1.computeVerticalScrollRange() - ae1.computeVerticalScrollExtent();
            if (k1 != 0) goto _L2; else goto _L1
_L1:
            flag = false;
_L4:
            return flag;
_L2:
            if (i1 >= 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (j1 > 0) goto _L4; else goto _L3
_L3:
            return false;
            if (j1 < k1 - 1) goto _L4; else goto _L5
_L5:
            return false;
        }

        public boolean A(View view)
        {
            return ai.a(view);
        }

        public float B(View view)
        {
            return v(view) + u(view);
        }

        public boolean C(View view)
        {
            return ai.d(view);
        }

        public int a(int i1, int j1)
        {
            return i1 | j1;
        }

        public int a(int i1, int j1, int k1)
        {
            return View.resolveSize(i1, j1);
        }

        public int a(View view)
        {
            return 2;
        }

        long a()
        {
            return 10L;
        }

        public bf a(View view, bf bf)
        {
            return bf;
        }

        public void a(View view, float f1)
        {
        }

        public void a(View view, int i1, int j1, int k1, int l1)
        {
            view.setPadding(i1, j1, k1, l1);
        }

        public void a(View view, int i1, Paint paint)
        {
        }

        public void a(View view, android.support.v4.view.a a1)
        {
        }

        public void a(View view, ac ac)
        {
        }

        public void a(View view, Runnable runnable)
        {
            view.postDelayed(runnable, a());
        }

        public void a(View view, Runnable runnable, long l1)
        {
            view.postDelayed(runnable, a() + l1);
        }

        public void a(View view, boolean flag)
        {
        }

        public void a(ViewGroup viewgroup, boolean flag)
        {
        }

        public boolean a(View view, int i1)
        {
            return (view instanceof ae) && a((ae)view, i1);
        }

        public bf b(View view, bf bf)
        {
            return bf;
        }

        public void b(View view, float f1)
        {
        }

        public void b(View view, boolean flag)
        {
        }

        public boolean b(View view)
        {
            return false;
        }

        public boolean b(View view, int i1)
        {
            return (view instanceof ae) && b((ae)view, i1);
        }

        public void c(View view, float f1)
        {
        }

        public void c(View view, int i1)
        {
        }

        public boolean c(View view)
        {
            return false;
        }

        public void d(View view)
        {
            view.invalidate();
        }

        public void d(View view, float f1)
        {
        }

        public int e(View view)
        {
            return 0;
        }

        public void e(View view, float f1)
        {
        }

        public float f(View view)
        {
            return 1.0F;
        }

        public void f(View view, float f1)
        {
        }

        public int g(View view)
        {
            return 0;
        }

        public ViewParent h(View view)
        {
            return view.getParent();
        }

        public int i(View view)
        {
            return view.getMeasuredWidth();
        }

        public int j(View view)
        {
            return 0;
        }

        public int k(View view)
        {
            return view.getPaddingLeft();
        }

        public int l(View view)
        {
            return view.getPaddingRight();
        }

        public float m(View view)
        {
            return 0.0F;
        }

        public float n(View view)
        {
            return 0.0F;
        }

        public float o(View view)
        {
            return 0.0F;
        }

        public int p(View view)
        {
            return ai.b(view);
        }

        public int q(View view)
        {
            return ai.c(view);
        }

        public ay r(View view)
        {
            return new ay(view);
        }

        public int s(View view)
        {
            return 0;
        }

        public void t(View view)
        {
        }

        public float u(View view)
        {
            return 0.0F;
        }

        public float v(View view)
        {
            return 0.0F;
        }

        public boolean w(View view)
        {
            return false;
        }

        public void x(View view)
        {
        }

        public boolean y(View view)
        {
            return false;
        }

        public void z(View view)
        {
            if (view instanceof y)
            {
                ((y)view).stopNestedScroll();
            }
        }

        a()
        {
            a = null;
        }
    }

    static class b extends a
    {

        public void a(ViewGroup viewgroup, boolean flag)
        {
            aj.a(viewgroup, flag);
        }

        b()
        {
        }
    }

    static class c extends b
    {

        public int a(View view)
        {
            return ak.a(view);
        }

        c()
        {
        }
    }

    static class d extends c
    {

        public int a(int i1, int j1)
        {
            return al.a(i1, j1);
        }

        public int a(int i1, int j1, int k1)
        {
            return al.a(i1, j1, k1);
        }

        long a()
        {
            return al.a();
        }

        public void a(View view, float f1)
        {
            al.a(view, f1);
        }

        public void a(View view, int i1, Paint paint)
        {
            al.a(view, i1, paint);
        }

        public void a(View view, boolean flag)
        {
            al.a(view, flag);
        }

        public void b(View view, float f1)
        {
            al.b(view, f1);
        }

        public void b(View view, boolean flag)
        {
            al.b(view, flag);
        }

        public void c(View view, float f1)
        {
            al.c(view, f1);
        }

        public void d(View view, float f1)
        {
            al.d(view, f1);
        }

        public void e(View view, float f1)
        {
            al.e(view, f1);
        }

        public float f(View view)
        {
            return al.a(view);
        }

        public int i(View view)
        {
            return al.b(view);
        }

        public int j(View view)
        {
            return al.c(view);
        }

        public float m(View view)
        {
            return al.d(view);
        }

        public float n(View view)
        {
            return al.e(view);
        }

        public float o(View view)
        {
            return al.f(view);
        }

        public void x(View view)
        {
            al.g(view);
        }

        d()
        {
        }
    }

    static class e extends d
    {

        static Field b;
        static boolean c = false;

        public void a(View view, android.support.v4.view.a a1)
        {
            if (a1 == null)
            {
                a1 = null;
            } else
            {
                a1 = ((android.support.v4.view.a) (a1.getBridge()));
            }
            am.a(view, a1);
        }

        public boolean a(View view, int i1)
        {
            return am.a(view, i1);
        }

        public boolean b(View view)
        {
            boolean flag = true;
            if (c)
            {
                return false;
            }
            if (b == null)
            {
                try
                {
                    b = android/view/View.getDeclaredField("mAccessibilityDelegate");
                    b.setAccessible(true);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    c = true;
                    return false;
                }
            }
            try
            {
                view = ((View) (b.get(view)));
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                c = true;
                return false;
            }
            if (view == null)
            {
                flag = false;
            }
            return flag;
        }

        public boolean b(View view, int i1)
        {
            return am.b(view, i1);
        }

        public ay r(View view)
        {
            if (a == null)
            {
                a = new WeakHashMap();
            }
            ay ay2 = (ay)a.get(view);
            ay ay1 = ay2;
            if (ay2 == null)
            {
                ay1 = new ay(view);
                a.put(view, ay1);
            }
            return ay1;
        }


        e()
        {
        }
    }

    static class f extends e
    {

        public void a(View view, Runnable runnable)
        {
            an.a(view, runnable);
        }

        public void a(View view, Runnable runnable, long l1)
        {
            an.a(view, runnable, l1);
        }

        public void c(View view, int i1)
        {
            int j1 = i1;
            if (i1 == 4)
            {
                j1 = 2;
            }
            an.a(view, j1);
        }

        public boolean c(View view)
        {
            return an.a(view);
        }

        public void d(View view)
        {
            an.b(view);
        }

        public int e(View view)
        {
            return an.c(view);
        }

        public ViewParent h(View view)
        {
            return an.d(view);
        }

        public int p(View view)
        {
            return an.e(view);
        }

        public int q(View view)
        {
            return an.f(view);
        }

        public void t(View view)
        {
            an.g(view);
        }

        public boolean w(View view)
        {
            return an.h(view);
        }

        f()
        {
        }
    }

    static class g extends f
    {

        public void a(View view, int i1, int j1, int k1, int l1)
        {
            ao.a(view, i1, j1, k1, l1);
        }

        public int g(View view)
        {
            return ao.a(view);
        }

        public int k(View view)
        {
            return ao.b(view);
        }

        public int l(View view)
        {
            return ao.c(view);
        }

        public int s(View view)
        {
            return ao.d(view);
        }

        public boolean y(View view)
        {
            return ao.e(view);
        }

        g()
        {
        }
    }

    static class h extends g
    {

        public boolean A(View view)
        {
            return ap.a(view);
        }

        public boolean C(View view)
        {
            return ap.b(view);
        }

        public void c(View view, int i1)
        {
            an.a(view, i1);
        }

        h()
        {
        }
    }

    static class i extends h
    {

        public float B(View view)
        {
            return aq.e(view);
        }

        public bf a(View view, bf bf)
        {
            return aq.a(view, bf);
        }

        public void a(View view, ac ac)
        {
            aq.a(view, ac);
        }

        public bf b(View view, bf bf)
        {
            return aq.b(view, bf);
        }

        public void f(View view, float f1)
        {
            aq.a(view, f1);
        }

        public void t(View view)
        {
            aq.a(view);
        }

        public float u(View view)
        {
            return aq.b(view);
        }

        public float v(View view)
        {
            return aq.c(view);
        }

        public void z(View view)
        {
            aq.d(view);
        }

        i()
        {
        }
    }

    static interface j
    {

        public abstract boolean A(View view);

        public abstract float B(View view);

        public abstract boolean C(View view);

        public abstract int a(int i1, int j1);

        public abstract int a(int i1, int j1, int k1);

        public abstract int a(View view);

        public abstract bf a(View view, bf bf);

        public abstract void a(View view, float f1);

        public abstract void a(View view, int i1, int j1, int k1, int l1);

        public abstract void a(View view, int i1, Paint paint);

        public abstract void a(View view, android.support.v4.view.a a1);

        public abstract void a(View view, ac ac);

        public abstract void a(View view, Runnable runnable);

        public abstract void a(View view, Runnable runnable, long l1);

        public abstract void a(View view, boolean flag);

        public abstract void a(ViewGroup viewgroup, boolean flag);

        public abstract boolean a(View view, int i1);

        public abstract bf b(View view, bf bf);

        public abstract void b(View view, float f1);

        public abstract void b(View view, boolean flag);

        public abstract boolean b(View view);

        public abstract boolean b(View view, int i1);

        public abstract void c(View view, float f1);

        public abstract void c(View view, int i1);

        public abstract boolean c(View view);

        public abstract void d(View view);

        public abstract void d(View view, float f1);

        public abstract int e(View view);

        public abstract void e(View view, float f1);

        public abstract float f(View view);

        public abstract void f(View view, float f1);

        public abstract int g(View view);

        public abstract ViewParent h(View view);

        public abstract int i(View view);

        public abstract int j(View view);

        public abstract int k(View view);

        public abstract int l(View view);

        public abstract float m(View view);

        public abstract float n(View view);

        public abstract float o(View view);

        public abstract int p(View view);

        public abstract int q(View view);

        public abstract ay r(View view);

        public abstract int s(View view);

        public abstract void t(View view);

        public abstract float u(View view);

        public abstract boolean w(View view);

        public abstract void x(View view);

        public abstract boolean y(View view);

        public abstract void z(View view);
    }


    static final j a;

    public static float A(View view)
    {
        return a.B(view);
    }

    public static boolean B(View view)
    {
        return a.C(view);
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

    public static bf a(View view, bf bf)
    {
        return a.a(view, bf);
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

    public static void a(View view, android.support.v4.view.a a1)
    {
        a.a(view, a1);
    }

    public static void a(View view, ac ac)
    {
        a.a(view, ac);
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

    public static bf b(View view, bf bf)
    {
        return a.b(view, bf);
    }

    public static void b(View view, float f1)
    {
        a.b(view, f1);
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

    public static ViewParent h(View view)
    {
        return a.h(view);
    }

    public static int i(View view)
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
        return a.m(view);
    }

    public static float n(View view)
    {
        return a.n(view);
    }

    public static int o(View view)
    {
        return a.p(view);
    }

    public static int p(View view)
    {
        return a.q(view);
    }

    public static ay q(View view)
    {
        return a.r(view);
    }

    public static float r(View view)
    {
        return a.o(view);
    }

    public static float s(View view)
    {
        return a.u(view);
    }

    public static int t(View view)
    {
        return a.s(view);
    }

    public static void u(View view)
    {
        a.t(view);
    }

    public static boolean v(View view)
    {
        return a.w(view);
    }

    public static void w(View view)
    {
        a.x(view);
    }

    public static boolean x(View view)
    {
        return a.y(view);
    }

    public static void y(View view)
    {
        a.z(view);
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
}
