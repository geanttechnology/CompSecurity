// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

// Referenced classes of package android.support.v4.view:
//            ak, a, s, ad, 
//            u, x, o, y, 
//            al

public final class w
{
    static class a
        implements j
    {

        WeakHashMap a;

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

        public ak a(View view, ak ak)
        {
            return ak;
        }

        public void a(View view, float f1)
        {
        }

        public void a(View view, int i1, Paint paint)
        {
        }

        public void a(View view, android.support.v4.view.a a1)
        {
        }

        public void a(View view, s s1)
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

        public void a(ViewGroup viewgroup)
        {
        }

        public boolean a(View view, int i1)
        {
            if (!(view instanceof u)) goto _L2; else goto _L1
_L1:
            int j1;
            int k1;
            view = (u)view;
            j1 = view.computeHorizontalScrollOffset();
            k1 = view.computeHorizontalScrollRange() - view.computeHorizontalScrollExtent();
            if (k1 == 0) goto _L4; else goto _L3
_L3:
            if (i1 >= 0) goto _L6; else goto _L5
_L5:
            if (j1 > 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
_L7:
            if (i1 != 0)
            {
                return true;
            }
            break; /* Loop/switch isn't completed */
_L6:
            if (j1 < k1 - 1)
            {
                i1 = 1;
                continue; /* Loop/switch isn't completed */
            }
_L4:
            i1 = 0;
            if (true) goto _L7; else goto _L2
_L2:
            return false;
        }

        public void b(View view, float f1)
        {
        }

        public boolean b(View view)
        {
            return false;
        }

        public boolean b(View view, int i1)
        {
            if (!(view instanceof u)) goto _L2; else goto _L1
_L1:
            int j1;
            int k1;
            view = (u)view;
            j1 = view.computeVerticalScrollOffset();
            k1 = view.computeVerticalScrollRange() - view.computeVerticalScrollExtent();
            if (k1 == 0) goto _L4; else goto _L3
_L3:
            if (i1 >= 0) goto _L6; else goto _L5
_L5:
            if (j1 > 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
_L7:
            if (i1 != 0)
            {
                return true;
            }
            break; /* Loop/switch isn't completed */
_L6:
            if (j1 < k1 - 1)
            {
                i1 = 1;
                continue; /* Loop/switch isn't completed */
            }
_L4:
            i1 = 0;
            if (true) goto _L7; else goto _L2
_L2:
            return false;
        }

        public void c(View view, float f1)
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

        public void f(View view)
        {
        }

        public void f(View view, float f1)
        {
        }

        public float g(View view)
        {
            return 1.0F;
        }

        public int h(View view)
        {
            return 0;
        }

        public int i(View view)
        {
            return 0;
        }

        public float j(View view)
        {
            return 0.0F;
        }

        public float k(View view)
        {
            return 0.0F;
        }

        public float l(View view)
        {
            return 0.0F;
        }

        public int m(View view)
        {
            return x.a(view);
        }

        public int n(View view)
        {
            return x.b(view);
        }

        public ad o(View view)
        {
            return new ad(view);
        }

        public int p(View view)
        {
            return 0;
        }

        public void q(View view)
        {
        }

        public void r(View view)
        {
        }

        public void s(View view)
        {
        }

        public void t(View view)
        {
            if (view instanceof o)
            {
                ((o)view).stopNestedScroll();
            }
        }

        public boolean u(View view)
        {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        public boolean v(View view)
        {
            return view.getWindowToken() != null;
        }

        a()
        {
            a = null;
        }
    }

    static class b extends a
    {

        public final void a(ViewGroup viewgroup)
        {
            if (y.a == null)
            {
                try
                {
                    y.a = android/view/ViewGroup.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[] {
                        Boolean.TYPE
                    });
                }
                catch (NoSuchMethodException nosuchmethodexception)
                {
                    Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", nosuchmethodexception);
                }
                y.a.setAccessible(true);
            }
            try
            {
                y.a.invoke(viewgroup, new Object[] {
                    Boolean.valueOf(true)
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", viewgroup);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", viewgroup);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (ViewGroup viewgroup)
            {
                Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", viewgroup);
            }
        }

        b()
        {
        }
    }

    static class c extends b
    {

        public final int a(View view)
        {
            return view.getOverScrollMode();
        }

        c()
        {
        }
    }

    static class d extends c
    {

        public final int a(int i1, int j1, int k1)
        {
            return View.resolveSizeAndState(i1, j1, k1);
        }

        final long a()
        {
            return ValueAnimator.getFrameDelay();
        }

        public final void a(View view, float f1)
        {
            view.setTranslationX(f1);
        }

        public final void a(View view, int i1, Paint paint)
        {
            view.setLayerType(i1, paint);
        }

        public final void a(View view, boolean flag)
        {
            view.setActivated(flag);
        }

        public final void b(View view, float f1)
        {
            view.setTranslationY(f1);
        }

        public final void c(View view, float f1)
        {
            view.setAlpha(f1);
        }

        public final void d(View view, float f1)
        {
            view.setScaleX(f1);
        }

        public final void e(View view, float f1)
        {
            view.setScaleY(f1);
        }

        public final float g(View view)
        {
            return view.getAlpha();
        }

        public final int i(View view)
        {
            return view.getMeasuredState();
        }

        public final float j(View view)
        {
            return view.getTranslationX();
        }

        public final float k(View view)
        {
            return view.getTranslationY();
        }

        public final float l(View view)
        {
            return view.getScaleX();
        }

        public final void r(View view)
        {
            view.jumpDrawablesToCurrentState();
        }

        public final void s(View view)
        {
            view.setSaveFromParentEnabled(false);
        }

        d()
        {
        }
    }

    static class e extends d
    {

        static Field b;
        static boolean c = false;

        public final void a(View view, android.support.v4.view.a a1)
        {
            if (a1 == null)
            {
                a1 = null;
            } else
            {
                a1 = ((android.support.v4.view.a) (a1.a));
            }
            view.setAccessibilityDelegate((android.view.View.AccessibilityDelegate)a1);
        }

        public final boolean a(View view, int i1)
        {
            return view.canScrollHorizontally(i1);
        }

        public final boolean b(View view)
        {
            if (!c)
            {
                if (b == null)
                {
                    try
                    {
                        Field field = android/view/View.getDeclaredField("mAccessibilityDelegate");
                        b = field;
                        field.setAccessible(true);
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
                if (view != null)
                {
                    return true;
                }
            }
            return false;
        }

        public final boolean b(View view, int i1)
        {
            return view.canScrollVertically(i1);
        }

        public final ad o(View view)
        {
            if (a == null)
            {
                a = new WeakHashMap();
            }
            ad ad2 = (ad)a.get(view);
            ad ad1 = ad2;
            if (ad2 == null)
            {
                ad1 = new ad(view);
                a.put(view, ad1);
            }
            return ad1;
        }


        e()
        {
        }
    }

    static class f extends e
    {

        public final void a(View view, Runnable runnable)
        {
            view.postOnAnimation(runnable);
        }

        public final void a(View view, Runnable runnable, long l1)
        {
            view.postOnAnimationDelayed(runnable, l1);
        }

        public final boolean c(View view)
        {
            return view.hasTransientState();
        }

        public final void d(View view)
        {
            view.postInvalidateOnAnimation();
        }

        public final int e(View view)
        {
            return view.getImportantForAccessibility();
        }

        public void f(View view)
        {
            view.setImportantForAccessibility(1);
        }

        public final int m(View view)
        {
            return view.getMinimumWidth();
        }

        public final int n(View view)
        {
            return view.getMinimumHeight();
        }

        public void q(View view)
        {
            view.requestFitSystemWindows();
        }

        f()
        {
        }
    }

    static class g extends f
    {

        public final int h(View view)
        {
            return view.getLayoutDirection();
        }

        public final int p(View view)
        {
            return view.getWindowSystemUiVisibility();
        }

        g()
        {
        }
    }

    static class h extends g
    {

        public final void f(View view)
        {
            view.setImportantForAccessibility(1);
        }

        public final boolean u(View view)
        {
            return view.isLaidOut();
        }

        public final boolean v(View view)
        {
            return view.isAttachedToWindow();
        }

        h()
        {
        }
    }

    static final class i extends h
    {

        public final ak a(View view, ak ak)
        {
            Object obj = ak;
            if (ak instanceof al)
            {
                android.view.WindowInsets windowinsets = ((al)ak).a;
                view = view.onApplyWindowInsets(windowinsets);
                obj = ak;
                if (view != windowinsets)
                {
                    obj = new al(view);
                }
            }
            return ((ak) (obj));
        }

        public final void a(View view, s s1)
        {
            view.setOnApplyWindowInsetsListener(new z._cls1(s1));
        }

        public final void f(View view, float f1)
        {
            view.setElevation(f1);
        }

        public final void q(View view)
        {
            view.requestApplyInsets();
        }

        public final void t(View view)
        {
            view.stopNestedScroll();
        }

        i()
        {
        }
    }

    static interface j
    {

        public abstract int a(int i1, int j1, int k1);

        public abstract int a(View view);

        public abstract ak a(View view, ak ak);

        public abstract void a(View view, float f1);

        public abstract void a(View view, int i1, Paint paint);

        public abstract void a(View view, android.support.v4.view.a a1);

        public abstract void a(View view, s s1);

        public abstract void a(View view, Runnable runnable);

        public abstract void a(View view, Runnable runnable, long l1);

        public abstract void a(View view, boolean flag);

        public abstract void a(ViewGroup viewgroup);

        public abstract boolean a(View view, int i1);

        public abstract void b(View view, float f1);

        public abstract boolean b(View view);

        public abstract boolean b(View view, int i1);

        public abstract void c(View view, float f1);

        public abstract boolean c(View view);

        public abstract void d(View view);

        public abstract void d(View view, float f1);

        public abstract int e(View view);

        public abstract void e(View view, float f1);

        public abstract void f(View view);

        public abstract void f(View view, float f1);

        public abstract float g(View view);

        public abstract int h(View view);

        public abstract int i(View view);

        public abstract float j(View view);

        public abstract float k(View view);

        public abstract float l(View view);

        public abstract int m(View view);

        public abstract int n(View view);

        public abstract ad o(View view);

        public abstract int p(View view);

        public abstract void q(View view);

        public abstract void r(View view);

        public abstract void s(View view);

        public abstract void t(View view);

        public abstract boolean u(View view);

        public abstract boolean v(View view);
    }


    static final j a;

    public static int a(int i1, int j1, int k1)
    {
        return a.a(i1, j1, k1);
    }

    public static int a(View view)
    {
        return a.a(view);
    }

    public static ak a(View view, ak ak)
    {
        return a.a(view, ak);
    }

    public static void a(View view, float f1)
    {
        a.a(view, f1);
    }

    public static void a(View view, int i1, Paint paint)
    {
        a.a(view, i1, paint);
    }

    public static void a(View view, android.support.v4.view.a a1)
    {
        a.a(view, a1);
    }

    public static void a(View view, s s1)
    {
        a.a(view, s1);
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

    public static void a(ViewGroup viewgroup)
    {
        a.a(viewgroup);
    }

    public static boolean a(View view, int i1)
    {
        return a.a(view, i1);
    }

    public static void b(View view, float f1)
    {
        a.b(view, f1);
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

    public static int e(View view)
    {
        return a.e(view);
    }

    public static void e(View view, float f1)
    {
        a.e(view, f1);
    }

    public static void f(View view)
    {
        a.f(view);
    }

    public static void f(View view, float f1)
    {
        a.f(view, f1);
    }

    public static float g(View view)
    {
        return a.g(view);
    }

    public static int h(View view)
    {
        return a.h(view);
    }

    public static int i(View view)
    {
        return a.i(view);
    }

    public static float j(View view)
    {
        return a.j(view);
    }

    public static float k(View view)
    {
        return a.k(view);
    }

    public static int l(View view)
    {
        return a.m(view);
    }

    public static int m(View view)
    {
        return a.n(view);
    }

    public static ad n(View view)
    {
        return a.o(view);
    }

    public static float o(View view)
    {
        return a.l(view);
    }

    public static int p(View view)
    {
        return a.p(view);
    }

    public static void q(View view)
    {
        a.q(view);
    }

    public static void r(View view)
    {
        a.r(view);
    }

    public static void s(View view)
    {
        a.s(view);
    }

    public static void t(View view)
    {
        a.t(view);
    }

    public static boolean u(View view)
    {
        return a.u(view);
    }

    public static boolean v(View view)
    {
        return a.v(view);
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
