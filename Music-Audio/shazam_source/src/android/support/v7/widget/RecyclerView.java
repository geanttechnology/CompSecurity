// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.d.e;
import android.support.v4.f.a;
import android.support.v4.view.aa;
import android.support.v4.view.ab;
import android.support.v4.view.n;
import android.support.v4.view.o;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.support.v4.view.v;
import android.support.v4.view.w;
import android.support.v4.widget.k;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            n, b, m, v

public class RecyclerView extends ViewGroup
    implements android.support.v4.view.o, android.support.v4.view.u
{
    static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public final Object createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public final volatile Object[] newArray(int i1)
            {
                return new SavedState[i1];
            }

        };
        Parcelable a;

        static void a(SavedState savedstate, SavedState savedstate1)
        {
            savedstate.a = savedstate1.a;
        }

        public void writeToParcel(Parcel parcel, int i1)
        {
            super.writeToParcel(parcel, i1);
            parcel.writeParcelable(a, 0);
        }


        SavedState(Parcel parcel)
        {
            super(parcel);
            a = parcel.readParcelable(android/support/v7/widget/RecyclerView$i.getClassLoader());
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

    public static abstract class a
    {

        public final b a = new b();
        boolean b;

        public abstract int a();

        public int a(int i1)
        {
            return 0;
        }

        public abstract u a(ViewGroup viewgroup, int i1);

        public final void a(int i1, int j1)
        {
            a.b(i1, j1);
        }

        public final void a(c c1)
        {
            a.registerObserver(c1);
        }

        public abstract void a(u u1, int i1);

        public long b(int i1)
        {
            return -1L;
        }

        public final void b(int i1, int j1)
        {
            a.c(i1, j1);
        }

        public final void b(u u1, int i1)
        {
            u1.b = i1;
            if (b)
            {
                u1.d = b(i1);
            }
            u1.a(1, 519);
            android.support.v4.d.e.a("RV OnBindView");
            a(u1, i1);
            android.support.v4.d.e.a();
        }

        public final void c(int i1)
        {
            a.c(i1, 1);
        }

        public a()
        {
            b = false;
        }
    }

    public static final class b extends Observable
    {

        public final void a()
        {
            for (int i1 = mObservers.size() - 1; i1 >= 0; i1--)
            {
                ((c)mObservers.get(i1)).a();
            }

        }

        public final void a(int i1, int j1)
        {
            for (int k1 = mObservers.size() - 1; k1 >= 0; k1--)
            {
                ((c)mObservers.get(k1)).a(i1, j1);
            }

        }

        public final void b(int i1, int j1)
        {
            for (int k1 = mObservers.size() - 1; k1 >= 0; k1--)
            {
                ((c)mObservers.get(k1)).b(i1, j1);
            }

        }

        public final void c(int i1, int j1)
        {
            for (int k1 = mObservers.size() - 1; k1 >= 0; k1--)
            {
                ((c)mObservers.get(k1)).c(i1, j1);
            }

        }

        b()
        {
        }
    }

    public static abstract class c
    {

        public void a()
        {
        }

        public void a(int i1, int j1)
        {
        }

        public void b(int i1, int j1)
        {
        }

        public void c(int i1, int j1)
        {
        }

        public c()
        {
        }
    }

    public static interface d
    {

        public abstract int a();
    }

    public static abstract class e
    {

        private ArrayList a;
        a h;
        long i;
        long j;
        long k;
        long l;
        boolean m;

        public abstract void a();

        public abstract boolean a(u u1);

        public abstract boolean a(u u1, int i1, int j1, int k1, int l1);

        public abstract boolean a(u u1, u u2, int i1, int j1, int k1, int l1);

        public abstract boolean b();

        public abstract boolean b(u u1);

        public abstract void c(u u1);

        public abstract void d();

        public final void d(u u1)
        {
            if (h != null)
            {
                h.a(u1);
            }
        }

        public final void e()
        {
            int j1 = a.size();
            for (int i1 = 0; i1 < j1; i1++)
            {
                a.get(i1);
            }

            a.clear();
        }

        public final void e(u u1)
        {
            if (h != null)
            {
                h.c(u1);
            }
        }

        public final void f(u u1)
        {
            if (h != null)
            {
                h.b(u1);
            }
        }

        public final void g(u u1)
        {
            if (h != null)
            {
                h.d(u1);
            }
        }

        public e()
        {
            h = null;
            a = new ArrayList();
            i = 120L;
            j = 120L;
            k = 250L;
            l = 250L;
            m = true;
        }
    }

    static interface e.a
    {

        public abstract void a(u u1);

        public abstract void b(u u1);

        public abstract void c(u u1);

        public abstract void d(u u1);
    }

    private final class f
        implements e.a
    {

        final RecyclerView a;

        public final void a(u u1)
        {
            u1.a(true);
            if (!RecyclerView.c(a, u1.a) && u1.n())
            {
                a.removeDetachedView(u1.a, false);
            }
        }

        public final void b(u u1)
        {
            u1.a(true);
            if (!android.support.v7.widget.u.a(u1))
            {
                RecyclerView.c(a, u1.a);
            }
        }

        public final void c(u u1)
        {
            u1.a(true);
            if (!android.support.v7.widget.u.a(u1))
            {
                RecyclerView.c(a, u1.a);
            }
        }

        public final void d(u u1)
        {
            u1.a(true);
            if (u1.g != null && u1.h == null)
            {
                u1.g = null;
                u1.a(-65, u1.i);
            }
            u1.h = null;
            if (!android.support.v7.widget.u.a(u1))
            {
                RecyclerView.c(a, u1.a);
            }
        }

        private f()
        {
            a = RecyclerView.this;
            super();
        }

        f(byte byte0)
        {
            this();
        }
    }

    public static abstract class g
    {

        public void a(Canvas canvas, RecyclerView recyclerview)
        {
        }

        public void a(Canvas canvas, RecyclerView recyclerview, r r1)
        {
        }

        public void a(Rect rect, View view, RecyclerView recyclerview)
        {
            view.getLayoutParams();
            rect.set(0, 0, 0, 0);
        }

        public g()
        {
        }
    }

    private static final class h
    {

        u a;
        int b;
        int c;
        int d;
        int e;

        h(u u1, int i1, int j1, int k1, int l1)
        {
            a = u1;
            b = i1;
            c = j1;
            d = k1;
            e = l1;
        }
    }

    public static abstract class i
    {

        android.support.v7.widget.m h;
        RecyclerView i;
        q j;
        boolean k;
        boolean l;

        public static int a(int i1, int j1, int k1, boolean flag)
        {
            int l1;
            int i2;
            i2 = 0x40000000;
            l1 = Math.max(0, i1 - j1);
            if (!flag) goto _L2; else goto _L1
_L1:
            if (k1 >= 0)
            {
                i1 = k1;
                j1 = i2;
            } else
            {
                j1 = 0;
                i1 = 0;
            }
_L4:
            return android.view.View.MeasureSpec.makeMeasureSpec(i1, j1);
_L2:
            j1 = i2;
            i1 = k1;
            if (k1 < 0)
            {
                if (k1 == -1)
                {
                    i1 = l1;
                    j1 = i2;
                } else
                if (k1 == -2)
                {
                    j1 = 0x80000000;
                    i1 = l1;
                } else
                {
                    j1 = 0;
                    i1 = 0;
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public static int a(View view)
        {
            return ((j)view.getLayoutParams()).a.c();
        }

        static void a(i i1, q q1)
        {
            if (i1.j == q1)
            {
                i1.j = null;
            }
        }

        public static void a(View view, int i1, int j1, int k1, int l1)
        {
            Rect rect = ((j)view.getLayoutParams()).b;
            view.layout(rect.left + i1, rect.top + j1, k1 - rect.right, l1 - rect.bottom);
        }

        static boolean a(i i1)
        {
            return i1.k;
        }

        public static int b(View view)
        {
            Rect rect = ((j)view.getLayoutParams()).b;
            int i1 = view.getMeasuredWidth();
            int j1 = rect.left;
            return rect.right + (i1 + j1);
        }

        static boolean b(i i1)
        {
            i1.k = false;
            return false;
        }

        public static int c(View view)
        {
            Rect rect = ((j)view.getLayoutParams()).b;
            int i1 = view.getMeasuredHeight();
            int j1 = rect.top;
            return rect.bottom + (i1 + j1);
        }

        public static int d(View view)
        {
            return view.getLeft() - ((j)view.getLayoutParams()).b.left;
        }

        public static int e(View view)
        {
            return view.getTop() - ((j)view.getLayoutParams()).b.top;
        }

        public static int f(View view)
        {
            int i1 = view.getRight();
            return ((j)view.getLayoutParams()).b.right + i1;
        }

        public static int g(View view)
        {
            int i1 = view.getBottom();
            return ((j)view.getLayoutParams()).b.bottom + i1;
        }

        private void g(int i1)
        {
            if (c(i1) != null)
            {
                android.support.v7.widget.m m1 = h;
                i1 = m1.a(i1);
                View view = m1.a.b(i1);
                if (view != null)
                {
                    if (m1.b.c(i1))
                    {
                        m1.c.remove(view);
                    }
                    m1.a.a(i1);
                }
            }
        }

        private void h(int i1)
        {
            c(i1);
            android.support.v7.widget.m m1 = h;
            i1 = m1.a(i1);
            m1.b.c(i1);
            m1.a.c(i1);
        }

        public int a(int i1, n n1, r r1)
        {
            return 0;
        }

        public int a(r r1)
        {
            return 0;
        }

        public abstract j a();

        public j a(Context context, AttributeSet attributeset)
        {
            return new j(context, attributeset);
        }

        public j a(android.view.ViewGroup.LayoutParams layoutparams)
        {
            if (layoutparams instanceof j)
            {
                return new j((j)layoutparams);
            }
            if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
            {
                return new j((android.view.ViewGroup.MarginLayoutParams)layoutparams);
            } else
            {
                return new j(layoutparams);
            }
        }

        public View a(int i1)
        {
            int k1 = j();
            for (int j1 = 0; j1 < k1; j1++)
            {
                View view = c(j1);
                u u1 = RecyclerView.b(view);
                if (u1 != null && u1.c() == i1 && !u1.b() && (i.o.j || !u1.m()))
                {
                    return view;
                }
            }

            return null;
        }

        public void a(int i1, int j1)
        {
        }

        public final void a(int i1, n n1)
        {
            View view = c(i1);
            g(i1);
            n1.a(view);
        }

        public void a(Parcelable parcelable)
        {
        }

        public final void a(n n1)
        {
            int i1 = j() - 1;
            while (i1 >= 0) 
            {
                Object obj = c(i1);
                u u1 = RecyclerView.b(((View) (obj)));
                if (!u1.b())
                {
                    if (u1.i() && !u1.m() && !u1.k() && !RecyclerView.g(i).b)
                    {
                        g(i1);
                        n1.a(u1);
                    } else
                    {
                        h(i1);
                        obj = RecyclerView.b(((View) (obj)));
                        obj.j = n1;
                        if (!((u) (obj)).k() || !RecyclerView.i(n1.h))
                        {
                            if (((u) (obj)).i() && !((u) (obj)).m() && !RecyclerView.g(n1.h).b)
                            {
                                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                            }
                            n1.a.add(obj);
                        } else
                        {
                            if (n1.b == null)
                            {
                                n1.b = new ArrayList();
                            }
                            n1.b.add(obj);
                        }
                    }
                }
                i1--;
            }
        }

        public void a(n n1, r r1)
        {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public final void a(q q1)
        {
            if (j != null && q1 != j && j.k)
            {
                j.b();
            }
            j = q1;
            q1 = j;
            q1.h = i;
            q1.i = this;
            if (q1.g == -1)
            {
                throw new IllegalArgumentException("Invalid target position");
            } else
            {
                q1.h.o.a = q1.g;
                q1.k = true;
                q1.j = true;
                int i1 = q1.g;
                q1.l = android.support.v7.widget.RecyclerView.e(q1.h).a(i1);
                android.support.v7.widget.RecyclerView.w(q1.h).a();
                return;
            }
        }

        public void a(RecyclerView recyclerview)
        {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(RecyclerView recyclerview, n n1)
        {
        }

        final void a(View view, int i1, boolean flag)
        {
            u u1;
            j j1;
            u1 = RecyclerView.b(view);
            if (flag || u1.m())
            {
                i.o.b(view);
            } else
            {
                i.o.a(view);
            }
            j1 = (j)view.getLayoutParams();
            if (!u1.f() && !u1.d()) goto _L2; else goto _L1
_L1:
            if (u1.d())
            {
                u1.e();
            } else
            {
                u1.g();
            }
            h.a(view, i1, view.getLayoutParams(), false);
_L4:
            if (j1.d)
            {
                u1.a.invalidate();
                j1.d = false;
            }
            return;
_L2:
            if (view.getParent() == i)
            {
                android.support.v7.widget.m m1 = h;
                int k1 = m1.a.a(view);
                int l1;
                if (k1 == -1)
                {
                    k1 = -1;
                } else
                if (m1.b.b(k1))
                {
                    k1 = -1;
                } else
                {
                    k1 -= m1.b.d(k1);
                }
                l1 = i1;
                if (i1 == -1)
                {
                    l1 = h.a();
                }
                if (k1 == -1)
                {
                    throw new IllegalStateException((new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:")).append(i.indexOfChild(view)).toString());
                }
                if (k1 != l1)
                {
                    view = android.support.v7.widget.RecyclerView.e(i);
                    View view1 = view.c(k1);
                    if (view1 == null)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Cannot move a child from non-existing index:")).append(k1).toString());
                    }
                    view.h(k1);
                    j j2 = (j)view1.getLayoutParams();
                    u u2 = RecyclerView.b(view1);
                    if (u2.m())
                    {
                        ((i) (view)).i.o.b(view1);
                    } else
                    {
                        ((i) (view)).i.o.a(view1);
                    }
                    ((i) (view)).h.a(view1, l1, j2, u2.m());
                }
            } else
            {
                h.a(view, i1, false);
                j1.c = true;
                if (j != null && j.k)
                {
                    q q1 = j;
                    if (RecyclerView.d(view) == q1.g)
                    {
                        q1.l = view;
                    }
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        final void a(View view, android.support.v4.view.a.b b1)
        {
            u u1 = RecyclerView.b(view);
            if (u1 != null && !u1.m() && !h.a(u1.a))
            {
                Object obj = i.a;
                obj = i.o;
                b(view, b1);
            }
        }

        public final void a(View view, n n1)
        {
            android.support.v7.widget.m m1 = h;
            int i1 = m1.a.a(view);
            if (i1 >= 0)
            {
                if (m1.b.c(i1))
                {
                    m1.c.remove(view);
                }
                m1.a.a(i1);
            }
            n1.a(view);
        }

        public void a(AccessibilityEvent accessibilityevent)
        {
            boolean flag1 = true;
            Object obj = i.a;
            obj = i.o;
            accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
            if (i != null)
            {
                boolean flag = flag1;
                if (!android.support.v4.view.w.b(i, 1))
                {
                    flag = flag1;
                    if (!android.support.v4.view.w.b(i, -1))
                    {
                        flag = flag1;
                        if (!android.support.v4.view.w.a(i, -1))
                        {
                            if (android.support.v4.view.w.a(i, 1))
                            {
                                flag = flag1;
                            } else
                            {
                                flag = false;
                            }
                        }
                    }
                }
                accessibilityevent.a(flag);
                if (RecyclerView.g(i) != null)
                {
                    accessibilityevent.a(RecyclerView.g(i).a());
                    return;
                }
            }
        }

        public void a(String s1)
        {
            if (i != null)
            {
                i.a(s1);
            }
        }

        public boolean a(j j1)
        {
            return j1 != null;
        }

        public final boolean a(Runnable runnable)
        {
            if (i != null)
            {
                return i.removeCallbacks(runnable);
            } else
            {
                return false;
            }
        }

        public int b(int i1, n n1, r r1)
        {
            return 0;
        }

        public int b(n n1, r r1)
        {
            while (i == null || RecyclerView.g(i) == null || !d()) 
            {
                return 1;
            }
            return RecyclerView.g(i).a();
        }

        public int b(r r1)
        {
            return 0;
        }

        public Parcelable b()
        {
            return null;
        }

        public void b(int i1)
        {
        }

        public void b(int i1, int j1)
        {
        }

        final void b(n n1)
        {
            int j1 = n1.a.size();
            for (int i1 = j1 - 1; i1 >= 0; i1--)
            {
                View view = ((u)n1.a.get(i1)).a;
                u u1 = RecyclerView.b(view);
                if (u1.b())
                {
                    continue;
                }
                u1.a(false);
                if (u1.n())
                {
                    i.removeDetachedView(view, false);
                }
                if (i.m != null)
                {
                    i.m.c(u1);
                }
                u1.a(true);
                n1.b(view);
            }

            n1.a.clear();
            if (j1 > 0)
            {
                i.invalidate();
            }
        }

        final void b(RecyclerView recyclerview)
        {
            if (recyclerview == null)
            {
                i = null;
                h = null;
                return;
            } else
            {
                i = recyclerview;
                h = recyclerview.c;
                return;
            }
        }

        final void b(RecyclerView recyclerview, n n1)
        {
            l = false;
            a(recyclerview, n1);
        }

        public void b(View view, android.support.v4.view.a.b b1)
        {
            int i1;
            int j1;
            if (d())
            {
                i1 = a(view);
            } else
            {
                i1 = 0;
            }
            if (c())
            {
                j1 = a(view);
            } else
            {
                j1 = 0;
            }
            b1.a(android.support.v4.view.a.b.j.a(i1, 1, j1, 1, false));
        }

        public int c(n n1, r r1)
        {
            while (i == null || RecyclerView.g(i) == null || !c()) 
            {
                return 1;
            }
            return RecyclerView.g(i).a();
        }

        public int c(r r1)
        {
            return 0;
        }

        public final View c(int i1)
        {
            if (h != null)
            {
                return h.b(i1);
            } else
            {
                return null;
            }
        }

        public View c(int i1, n n1, r r1)
        {
            return null;
        }

        public void c(int i1, int j1)
        {
        }

        public final void c(n n1)
        {
            for (int i1 = j() - 1; i1 >= 0; i1--)
            {
                if (!RecyclerView.b(c(i1)).b())
                {
                    a(i1, n1);
                }
            }

        }

        public boolean c()
        {
            return false;
        }

        public int d(r r1)
        {
            return 0;
        }

        public void d(int i1)
        {
            if (i != null)
            {
                RecyclerView recyclerview = i;
                int k1 = recyclerview.c.a();
                for (int j1 = 0; j1 < k1; j1++)
                {
                    recyclerview.c.b(j1).offsetLeftAndRight(i1);
                }

            }
        }

        public void d(int i1, int j1)
        {
        }

        public boolean d()
        {
            return false;
        }

        public int e(r r1)
        {
            return 0;
        }

        public void e(int i1)
        {
            if (i != null)
            {
                RecyclerView recyclerview = i;
                int k1 = recyclerview.c.a();
                for (int j1 = 0; j1 < k1; j1++)
                {
                    recyclerview.c.b(j1).offsetTopAndBottom(i1);
                }

            }
        }

        public int f(r r1)
        {
            return 0;
        }

        public void f(int i1)
        {
        }

        public boolean f()
        {
            return false;
        }

        public final void g()
        {
            if (i != null)
            {
                i.requestLayout();
            }
        }

        public final boolean h()
        {
            return i != null && android.support.v7.widget.RecyclerView.v(i);
        }

        public final boolean i()
        {
            return j != null && j.k;
        }

        public final int j()
        {
            if (h != null)
            {
                return h.a();
            } else
            {
                return 0;
            }
        }

        public final int k()
        {
            if (i != null)
            {
                return i.getWidth();
            } else
            {
                return 0;
            }
        }

        public final int l()
        {
            if (i != null)
            {
                return i.getHeight();
            } else
            {
                return 0;
            }
        }

        public final int m()
        {
            if (i != null)
            {
                return i.getPaddingLeft();
            } else
            {
                return 0;
            }
        }

        public final int n()
        {
            if (i != null)
            {
                return i.getPaddingTop();
            } else
            {
                return 0;
            }
        }

        public final int o()
        {
            if (i != null)
            {
                return i.getPaddingRight();
            } else
            {
                return 0;
            }
        }

        public final int p()
        {
            if (i != null)
            {
                return i.getPaddingBottom();
            } else
            {
                return 0;
            }
        }

        public void q()
        {
        }

        final void r()
        {
            if (j != null)
            {
                j.b();
            }
        }

        public i()
        {
            k = false;
            l = false;
        }
    }

    public static class j extends android.view.ViewGroup.MarginLayoutParams
    {

        u a;
        final Rect b;
        boolean c;
        boolean d;

        public j(int i1)
        {
            super(i1, -2);
            b = new Rect();
            c = true;
            d = false;
        }

        public j(Context context, AttributeSet attributeset)
        {
            super(context, attributeset);
            b = new Rect();
            c = true;
            d = false;
        }

        public j(j j1)
        {
            super(j1);
            b = new Rect();
            c = true;
            d = false;
        }

        public j(android.view.ViewGroup.LayoutParams layoutparams)
        {
            super(layoutparams);
            b = new Rect();
            c = true;
            d = false;
        }

        public j(android.view.ViewGroup.MarginLayoutParams marginlayoutparams)
        {
            super(marginlayoutparams);
            b = new Rect();
            c = true;
            d = false;
        }
    }

    public static interface k
    {

        public abstract boolean a();
    }

    public static abstract class l
    {

        public void a(RecyclerView recyclerview, int i1)
        {
        }

        public void a(RecyclerView recyclerview, int i1, int j1)
        {
        }

        public l()
        {
        }
    }

    public static final class m
    {

        SparseArray a;
        SparseIntArray b;
        int c;

        final void a()
        {
            c = c + 1;
        }

        final void b()
        {
            c = c - 1;
        }

        public m()
        {
            a = new SparseArray();
            b = new SparseIntArray();
            c = 0;
        }
    }

    public final class n
    {

        final ArrayList a = new ArrayList();
        ArrayList b;
        final ArrayList c = new ArrayList();
        final List d;
        int e;
        m f;
        s g;
        final RecyclerView h;

        private u a(long l1, int i1)
        {
            for (int j1 = a.size() - 1; j1 >= 0; j1--)
            {
                u u1 = (u)a.get(j1);
                if (u1.d != l1 || u1.f())
                {
                    continue;
                }
                if (i1 == u1.e)
                {
                    u1.b(32);
                    if (u1.m() && !h.o.j)
                    {
                        u1.a(2, 14);
                    }
                    return u1;
                }
                a.remove(j1);
                h.removeDetachedView(u1.a, false);
                b(u1.a);
            }

            for (int k1 = c.size() - 1; k1 >= 0; k1--)
            {
                u u2 = (u)c.get(k1);
                if (u2.d != l1)
                {
                    continue;
                }
                if (i1 == u2.e)
                {
                    c.remove(k1);
                    return u2;
                }
                b(k1);
            }

            return null;
        }

        private void a(ViewGroup viewgroup, boolean flag)
        {
            for (int i1 = viewgroup.getChildCount() - 1; i1 >= 0; i1--)
            {
                View view = viewgroup.getChildAt(i1);
                if (view instanceof ViewGroup)
                {
                    a((ViewGroup)view, true);
                }
            }

            if (!flag)
            {
                return;
            }
            if (viewgroup.getVisibility() == 4)
            {
                viewgroup.setVisibility(0);
                viewgroup.setVisibility(4);
                return;
            } else
            {
                int j1 = viewgroup.getVisibility();
                viewgroup.setVisibility(4);
                viewgroup.setVisibility(j1);
                return;
            }
        }

        private u c(int i1)
        {
            boolean flag;
            int k1;
label0:
            {
                flag = false;
                if (b != null)
                {
                    k1 = b.size();
                    if (k1 != 0)
                    {
                        break label0;
                    }
                }
                return null;
            }
            for (int j1 = 0; j1 < k1; j1++)
            {
                u u1 = (u)b.get(j1);
                if (!u1.f() && u1.c() == i1)
                {
                    u1.b(32);
                    return u1;
                }
            }

            if (RecyclerView.g(h).b)
            {
                i1 = h.b.a(i1, 0);
                if (i1 > 0 && i1 < RecyclerView.g(h).a())
                {
                    long l1 = RecyclerView.g(h).b(i1);
                    for (i1 = ((flag) ? 1 : 0); i1 < k1; i1++)
                    {
                        u u2 = (u)b.get(i1);
                        if (!u2.f() && u2.d == l1)
                        {
                            u2.b(32);
                            return u2;
                        }
                    }

                }
            }
            return null;
        }

        private void c(u u1)
        {
            android.support.v4.view.w.a(u1.a, null);
            if (android.support.v7.widget.RecyclerView.u(h) != null)
            {
                android.support.v7.widget.RecyclerView.u(h);
            }
            if (RecyclerView.g(h) != null)
            {
                RecyclerView.g(h);
            }
            if (h.o != null)
            {
                h.o.a(u1);
            }
            u1.k = null;
            m m1 = c();
            int i1 = u1.e;
            ArrayList arraylist1 = (ArrayList)m1.a.get(i1);
            ArrayList arraylist = arraylist1;
            if (arraylist1 == null)
            {
                ArrayList arraylist2 = new ArrayList();
                m1.a.put(i1, arraylist2);
                arraylist = arraylist2;
                if (m1.b.indexOfKey(i1) < 0)
                {
                    m1.b.put(i1, 5);
                    arraylist = arraylist2;
                }
            }
            if (m1.b.get(i1) > arraylist.size())
            {
                u1.o();
                arraylist.add(u1);
            }
        }

        private u d(int i1)
        {
            android.support.v7.widget.m m1;
            int k1;
            boolean flag;
            int l1;
            flag = false;
            l1 = a.size();
            for (int j1 = 0; j1 < l1; j1++)
            {
                u u1 = (u)a.get(j1);
                if (!u1.f() && u1.c() == i1 && !u1.i() && (h.o.j || !u1.m()))
                {
                    u1.b(32);
                    return u1;
                }
            }

            m1 = h.c;
            l1 = m1.c.size();
            k1 = 0;
_L7:
            if (k1 >= l1) goto _L2; else goto _L1
_L1:
            Object obj;
            u u2;
            obj = (View)m1.c.get(k1);
            u2 = m1.a.b(((View) (obj)));
            if (u2.c() != i1 || u2.i()) goto _L4; else goto _L3
_L3:
            if (obj != null)
            {
                h.m.c(h.a(((View) (obj))));
            }
            l1 = c.size();
            k1 = ((flag) ? 1 : 0);
_L5:
            if (k1 >= l1)
            {
                break MISSING_BLOCK_LABEL_272;
            }
            obj = (u)c.get(k1);
            if (!((u) (obj)).i() && ((u) (obj)).c() == i1)
            {
                c.remove(k1);
                return ((u) (obj));
            }
            break MISSING_BLOCK_LABEL_263;
_L4:
            k1++;
            continue; /* Loop/switch isn't completed */
_L2:
            obj = null;
              goto _L3
            k1++;
              goto _L5
            return null;
            if (true) goto _L7; else goto _L6
_L6:
        }

        public final View a(int i1)
        {
            boolean flag1 = true;
            if (i1 < 0 || i1 >= h.o.a())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Invalid item position ")).append(i1).append("(").append(i1).append("). Item count:").append(h.o.a()).toString());
            }
            Object obj;
            Object obj1;
            View view;
            boolean flag;
            int j1;
            int k1;
            if (h.o.j)
            {
                obj1 = c(i1);
                if (obj1 != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                j1 = ((flag) ? 1 : 0);
            } else
            {
                obj1 = null;
                j1 = 0;
            }
            obj = obj1;
            flag = j1;
            if (obj1 != null) goto _L2; else goto _L1
_L1:
            obj1 = d(i1);
            obj = obj1;
            flag = j1;
            if (obj1 == null) goto _L2; else goto _L3
_L3:
            if (((u) (obj1)).m()) goto _L5; else goto _L4
_L4:
            if (((u) (obj1)).b < 0 || ((u) (obj1)).b >= RecyclerView.g(h).a())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid view holder adapter position")).append(obj1).toString());
            }
            if (h.o.j || RecyclerView.g(h).a(((u) (obj1)).b) == ((u) (obj1)).e) goto _L7; else goto _L6
_L6:
            flag = false;
_L17:
            if (!flag)
            {
                ((u) (obj1)).b(4);
                if (((u) (obj1)).d())
                {
                    h.removeDetachedView(((u) (obj1)).a, false);
                    ((u) (obj1)).e();
                } else
                if (((u) (obj1)).f())
                {
                    ((u) (obj1)).g();
                }
                a(((u) (obj1)));
                obj = null;
                flag = j1;
            } else
            {
                flag = true;
                obj = obj1;
            }
_L2:
            if (obj != null) goto _L9; else goto _L8
_L8:
            k1 = h.b.a(i1);
            if (k1 < 0 || k1 >= RecyclerView.g(h).a())
            {
                throw new IndexOutOfBoundsException((new StringBuilder("Inconsistency detected. Invalid item position ")).append(i1).append("(offset:").append(k1).append(").state:").append(h.o.a()).toString());
            }
            j1 = RecyclerView.g(h).a(k1);
              goto _L10
_L7:
            if (RecyclerView.g(h).b && ((u) (obj1)).d != RecyclerView.g(h).b(((u) (obj1)).b))
            {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
_L5:
            flag = true;
            continue; /* Loop/switch isn't completed */
_L10:
            if (!RecyclerView.g(h).b) goto _L12; else goto _L11
_L11:
            obj1 = a(RecyclerView.g(h).b(k1), j1);
            obj = obj1;
            if (obj1 == null) goto _L12; else goto _L13
_L13:
            obj1.b = k1;
            flag = true;
_L15:
            obj = obj1;
            if (obj1 == null)
            {
                obj = obj1;
                if (g != null)
                {
                    view = g.a();
                    obj = obj1;
                    if (view != null)
                    {
                        obj1 = h.a(view);
                        if (obj1 == null)
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                        }
                        obj = obj1;
                        if (((u) (obj1)).b())
                        {
                            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                        }
                    }
                }
            }
            obj1 = obj;
            if (obj == null)
            {
                obj1 = (ArrayList)c().a.get(j1);
                if (obj1 != null && !((ArrayList) (obj1)).isEmpty())
                {
                    k1 = ((ArrayList) (obj1)).size() - 1;
                    obj = (u)((ArrayList) (obj1)).get(k1);
                    ((ArrayList) (obj1)).remove(k1);
                } else
                {
                    obj = null;
                }
                if (obj != null)
                {
                    ((u) (obj)).o();
                    if (android.support.v7.widget.RecyclerView.k() && (((u) (obj)).a instanceof ViewGroup))
                    {
                        a((ViewGroup)((u) (obj)).a, false);
                    }
                }
                obj1 = obj;
            }
            if (obj1 == null)
            {
                obj = RecyclerView.g(h);
                obj1 = h;
                android.support.v4.d.e.a("RV CreateView");
                obj = ((a) (obj)).a(((ViewGroup) (obj1)), j1);
                obj.e = j1;
                android.support.v4.d.e.a();
            } else
            {
                obj = obj1;
            }
_L9:
            if (h.o.j && ((u) (obj)).l())
            {
                obj.f = i1;
                i1 = 0;
            } else
            if (!((u) (obj)).l() || ((u) (obj)).j() || ((u) (obj)).i())
            {
                j1 = h.b.a(i1);
                obj.k = h;
                RecyclerView.g(h).b(((u) (obj)), j1);
                obj1 = ((u) (obj)).a;
                if (RecyclerView.s(h) != null && RecyclerView.s(h).isEnabled())
                {
                    if (android.support.v4.view.w.e(((View) (obj1))) == 0)
                    {
                        android.support.v4.view.w.f(((View) (obj1)));
                    }
                    if (!android.support.v4.view.w.b(((View) (obj1))))
                    {
                        android.support.v4.view.w.a(((View) (obj1)), RecyclerView.t(h).c);
                    }
                }
                if (h.o.j)
                {
                    obj.f = i1;
                }
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            obj1 = ((u) (obj)).a.getLayoutParams();
            if (obj1 == null)
            {
                obj1 = (j)h.generateDefaultLayoutParams();
                ((u) (obj)).a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            } else
            if (!h.checkLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1))))
            {
                obj1 = (j)h.generateLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
                ((u) (obj)).a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj1)));
            } else
            {
                obj1 = (j)obj1;
            }
            obj1.a = ((u) (obj));
            if (!flag || i1 == 0)
            {
                flag1 = false;
            }
            obj1.d = flag1;
            return ((u) (obj)).a;
_L12:
            obj1 = obj;
            if (true) goto _L15; else goto _L14
_L14:
            if (true) goto _L17; else goto _L16
_L16:
        }

        public final void a()
        {
            a.clear();
            b();
        }

        final void a(u u1)
        {
            boolean flag;
            boolean flag3 = true;
            boolean flag2 = false;
            if (u1.d() || u1.a.getParent() != null)
            {
                StringBuilder stringbuilder = (new StringBuilder("Scrapped or attached views may not be recycled. isScrap:")).append(u1.d()).append(" isAttached:");
                if (u1.a.getParent() == null)
                {
                    flag3 = false;
                }
                throw new IllegalArgumentException(stringbuilder.append(flag3).toString());
            }
            if (u1.n())
            {
                throw new IllegalArgumentException((new StringBuilder("Tmp detached view should be removed from RecyclerView before it can be recycled: ")).append(u1).toString());
            }
            if (u1.b())
            {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
            }
            int i1;
            boolean flag1;
            if ((u1.i & 0x10) == 0 && android.support.v4.view.w.c(u1.a))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (RecyclerView.g(h) != null && flag1)
            {
                RecyclerView.g(h);
            }
            if (!u1.p())
            {
                break MISSING_BLOCK_LABEL_293;
            }
            if (u1.a(78)) goto _L2; else goto _L1
_L1:
            i1 = c.size();
            if (i1 == e && i1 > 0)
            {
                b(0);
            }
            if (i1 >= e) goto _L2; else goto _L3
_L3:
            c.add(u1);
            flag = true;
_L4:
            if (!flag)
            {
                c(u1);
                flag2 = true;
            }
_L5:
            h.o.a(u1);
            if (!flag && !flag2 && flag1)
            {
                u1.k = null;
            }
            return;
_L2:
            flag = false;
              goto _L4
            flag = false;
              goto _L5
        }

        public final void a(View view)
        {
            u u1;
            u1 = RecyclerView.b(view);
            if (u1.n())
            {
                h.removeDetachedView(view, false);
            }
            if (!u1.d()) goto _L2; else goto _L1
_L1:
            u1.e();
_L4:
            a(u1);
            return;
_L2:
            if (u1.f())
            {
                u1.g();
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        final void b()
        {
            for (int i1 = c.size() - 1; i1 >= 0; i1--)
            {
                b(i1);
            }

            c.clear();
        }

        final void b(int i1)
        {
            c((u)c.get(i1));
            c.remove(i1);
        }

        final void b(u u1)
        {
            if (!u1.k() || !RecyclerView.i(h) || b == null)
            {
                a.remove(u1);
            } else
            {
                b.remove(u1);
            }
            u1.j = null;
            u1.g();
        }

        final void b(View view)
        {
            view = RecyclerView.b(view);
            view.j = null;
            view.g();
            a(view);
        }

        final m c()
        {
            if (f == null)
            {
                f = new m();
            }
            return f;
        }

        public n()
        {
            h = RecyclerView.this;
            super();
            b = null;
            d = Collections.unmodifiableList(a);
            e = 2;
        }
    }

    public static interface o
    {
    }

    private final class p extends c
    {

        final RecyclerView a;

        private void b()
        {
            if (android.support.v7.widget.RecyclerView.n(a) && android.support.v7.widget.RecyclerView.o(a) && android.support.v7.widget.RecyclerView.p(a))
            {
                android.support.v4.view.w.a(a, RecyclerView.q(a));
                return;
            } else
            {
                RecyclerView.r(a);
                a.requestLayout();
                return;
            }
        }

        public final void a()
        {
            a.a(null);
            RecyclerView.g(a);
            a.o.i = true;
            RecyclerView.m(a);
            if (!a.b.d())
            {
                a.requestLayout();
            }
        }

        public final void a(int i1, int j1)
        {
            boolean flag = true;
            a.a(null);
            android.support.v7.widget.b b1 = a.b;
            b1.a.add(b1.a(2, i1, j1));
            if (b1.a.size() == 1)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                b();
            }
        }

        public final void b(int i1, int j1)
        {
            boolean flag = true;
            a.a(null);
            android.support.v7.widget.b b1 = a.b;
            b1.a.add(b1.a(0, i1, j1));
            if (b1.a.size() == 1)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                b();
            }
        }

        public final void c(int i1, int j1)
        {
            boolean flag = true;
            a.a(null);
            android.support.v7.widget.b b1 = a.b;
            b1.a.add(b1.a(1, i1, j1));
            if (b1.a.size() == 1)
            {
                i1 = ((flag) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                b();
            }
        }

        private p()
        {
            a = RecyclerView.this;
            super();
        }

        p(byte byte0)
        {
            this();
        }
    }

    public static abstract class q
    {

        private final a a = new a();
        int g;
        RecyclerView h;
        i i;
        boolean j;
        boolean k;
        View l;

        static void a(q q1, int i1, int j1)
        {
label0:
            {
                boolean flag = false;
                RecyclerView recyclerview = q1.h;
                if (!q1.k || q1.g == -1 || recyclerview == null)
                {
                    q1.b();
                }
                q1.j = false;
                if (q1.l != null)
                {
                    if (RecyclerView.d(q1.l) == q1.g)
                    {
                        View view = q1.l;
                        r r2 = recyclerview.o;
                        q1.a(view, q1.a);
                        android.support.v7.widget.a.a(q1.a, recyclerview);
                        q1.b();
                    } else
                    {
                        Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                        q1.l = null;
                    }
                }
                if (q1.k)
                {
                    r r1 = recyclerview.o;
                    q1.a(i1, j1, q1.a);
                    i1 = ((flag) ? 1 : 0);
                    if (q1.a.a >= 0)
                    {
                        i1 = 1;
                    }
                    android.support.v7.widget.a.a(q1.a, recyclerview);
                    if (i1 != 0)
                    {
                        if (!q1.k)
                        {
                            break label0;
                        }
                        q1.j = true;
                        android.support.v7.widget.RecyclerView.w(recyclerview).a();
                    }
                }
                return;
            }
            q1.b();
        }

        protected abstract void a();

        protected abstract void a(int i1, int j1, a a1);

        protected abstract void a(View view, a a1);

        protected final void b()
        {
            if (!k)
            {
                return;
            } else
            {
                a();
                h.o.a = -1;
                l = null;
                g = -1;
                j = false;
                k = false;
                android.support.v7.widget.i.a(i, this);
                i = null;
                h = null;
                return;
            }
        }

        public q()
        {
            g = -1;
        }
    }

    public static final class q.a
    {

        int a;
        private int b;
        private int c;
        private int d;
        private Interpolator e;
        private boolean f;
        private int g;

        static void a(q.a a1, RecyclerView recyclerview)
        {
            if (a1.a >= 0)
            {
                int i1 = a1.a;
                a1.a = -1;
                RecyclerView.c(recyclerview, i1);
                a1.f = false;
                return;
            }
            if (a1.f)
            {
                if (a1.e != null && a1.d <= 0)
                {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (a1.d <= 0)
                {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
                if (a1.e == null)
                {
                    if (a1.d == 0x80000000)
                    {
                        android.support.v7.widget.RecyclerView.w(recyclerview).a(a1.b, a1.c);
                    } else
                    {
                        android.support.v7.widget.RecyclerView.w(recyclerview).a(a1.b, a1.c, a1.d);
                    }
                } else
                {
                    android.support.v7.widget.RecyclerView.w(recyclerview).a(a1.b, a1.c, a1.d, a1.e);
                }
                a1.g = a1.g + 1;
                if (a1.g > 10)
                {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                a1.f = false;
                return;
            } else
            {
                a1.g = 0;
                return;
            }
        }

        public final void a(int i1, int j1, int k1, Interpolator interpolator)
        {
            b = i1;
            c = j1;
            d = k1;
            e = interpolator;
            f = true;
        }

        public q.a()
        {
            this((byte)0);
        }

        private q.a(byte byte0)
        {
            a = -1;
            f = false;
            g = 0;
            b = 0;
            c = 0;
            d = 0x80000000;
            e = null;
        }
    }

    public static final class r
    {

        int a;
        android.support.v4.f.a b;
        android.support.v4.f.a c;
        android.support.v4.f.a d;
        final List e = new ArrayList();
        int f;
        int g;
        int h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        private SparseArray m;

        public final int a()
        {
            if (j)
            {
                return g - h;
            } else
            {
                return f;
            }
        }

        final void a(u u1)
        {
            b.remove(u1);
            c.remove(u1);
            if (d == null) goto _L2; else goto _L1
_L1:
            android.support.v4.f.a a1;
            int i1;
            a1 = d;
            i1 = a1.size() - 1;
_L7:
            if (i1 < 0) goto _L2; else goto _L3
_L3:
            if (u1 != a1.c(i1)) goto _L5; else goto _L4
_L4:
            a1.d(i1);
_L2:
            e.remove(u1.a);
            return;
_L5:
            i1--;
            if (true) goto _L7; else goto _L6
_L6:
        }

        final void a(View view)
        {
            e.remove(view);
        }

        final void b(View view)
        {
            if (!e.contains(view))
            {
                e.add(view);
            }
        }

        public final String toString()
        {
            return (new StringBuilder("State{mTargetPosition=")).append(a).append(", mPreLayoutHolderMap=").append(b).append(", mPostLayoutHolderMap=").append(c).append(", mData=").append(m).append(", mItemCount=").append(f).append(", mPreviousLayoutItemCount=").append(g).append(", mDeletedInvisibleItemCountSincePreviousLayout=").append(h).append(", mStructureChanged=").append(i).append(", mInPreLayout=").append(j).append(", mRunSimpleAnimations=").append(k).append(", mRunPredictiveAnimations=").append(l).append('}').toString();
        }

        public r()
        {
            a = -1;
            b = new android.support.v4.f.a();
            c = new android.support.v4.f.a();
            d = new android.support.v4.f.a();
            f = 0;
            g = 0;
            h = 0;
            i = false;
            j = false;
            k = false;
            l = false;
        }
    }

    public static abstract class s
    {

        public abstract View a();
    }

    private final class t
        implements Runnable
    {

        int a;
        int b;
        android.support.v4.widget.k c;
        final RecyclerView d;
        private Interpolator e;
        private boolean f;
        private boolean g;

        final void a()
        {
            if (f)
            {
                g = true;
                return;
            } else
            {
                d.removeCallbacks(this);
                android.support.v4.view.w.a(d, this);
                return;
            }
        }

        public final void a(int i1, int j1)
        {
            int i2 = Math.abs(i1);
            int j2 = Math.abs(j1);
            float f1;
            float f2;
            float f3;
            int k1;
            boolean flag;
            int k2;
            int l2;
            int i3;
            if (i2 > j2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k2 = (int)Math.sqrt(0.0D);
            l2 = (int)Math.sqrt(i1 * i1 + j1 * j1);
            if (flag)
            {
                k1 = d.getWidth();
            } else
            {
                k1 = d.getHeight();
            }
            i3 = k1 / 2;
            f3 = Math.min(1.0F, ((float)l2 * 1.0F) / (float)k1);
            f1 = i3;
            f2 = i3;
            f3 = (float)Math.sin((float)((double)(f3 - 0.5F) * 0.4712389167638204D));
            if (k2 > 0)
            {
                k1 = Math.round(1000F * Math.abs((f3 * f2 + f1) / (float)k2)) * 4;
            } else
            {
                int l1;
                if (flag)
                {
                    l1 = i2;
                } else
                {
                    l1 = j2;
                }
                k1 = (int)(((float)l1 / (float)k1 + 1.0F) * 300F);
            }
            a(i1, j1, Math.min(k1, 2000));
        }

        public final void a(int i1, int j1, int k1)
        {
            a(i1, j1, k1, RecyclerView.j());
        }

        public final void a(int i1, int j1, int k1, Interpolator interpolator)
        {
            if (e != interpolator)
            {
                e = interpolator;
                c = android.support.v4.widget.k.a(d.getContext(), interpolator);
            }
            RecyclerView.b(d, 2);
            b = 0;
            a = 0;
            interpolator = c;
            ((android.support.v4.widget.k) (interpolator)).b.a(((android.support.v4.widget.k) (interpolator)).a, i1, j1, k1);
            a();
        }

        public final void run()
        {
            android.support.v4.widget.k k1;
            q q1;
            g = false;
            f = true;
            RecyclerView.f(d);
            k1 = c;
            q1 = android.support.v7.widget.RecyclerView.e(d).j;
            if (!k1.b.e(k1.a)) goto _L2; else goto _L1
_L1:
            int i1;
            int j1;
            int l1;
            int i2;
            int j2;
            int k2;
            int l2;
            int i3;
            int j3;
            int k3;
            int l3;
            int i4;
            l3 = k1.b.b(k1.a);
            i4 = k1.b.c(k1.a);
            j3 = l3 - a;
            k3 = i4 - b;
            k2 = 0;
            i1 = 0;
            l2 = 0;
            i2 = 0;
            a = l3;
            b = i4;
            i3 = 0;
            j1 = 0;
            j2 = 0;
            l1 = 0;
            if (RecyclerView.g(d) == null)
            {
                break MISSING_BLOCK_LABEL_960;
            }
            d.a();
            RecyclerView.h(d);
            android.support.v4.d.e.a("RV Scroll");
            if (j3 != 0)
            {
                i1 = android.support.v7.widget.RecyclerView.e(d).a(j3, d.a, d.o);
                j1 = j3 - i1;
            }
            if (k3 != 0)
            {
                i2 = android.support.v7.widget.RecyclerView.e(d).b(k3, d.a, d.o);
                l1 = k3 - i2;
            }
            android.support.v4.d.e.a();
            if (RecyclerView.i(d))
            {
                k2 = d.c.a();
                for (j2 = 0; j2 < k2; j2++)
                {
                    View view = d.c.b(j2);
                    Object obj = d.a(view);
                    if (obj == null || ((u) (obj)).h == null)
                    {
                        continue;
                    }
                    obj = ((u) (obj)).h.a;
                    l2 = view.getLeft();
                    i3 = view.getTop();
                    if (l2 != ((View) (obj)).getLeft() || i3 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(l2, i3, ((View) (obj)).getWidth() + l2, ((View) (obj)).getHeight() + i3);
                    }
                }

            }
            RecyclerView.j(d);
            d.a(false);
            j2 = l1;
            l2 = i2;
            i3 = j1;
            k2 = i1;
            if (q1 == null)
            {
                break MISSING_BLOCK_LABEL_960;
            }
            j2 = l1;
            l2 = i2;
            i3 = j1;
            k2 = i1;
            if (q1.j)
            {
                break MISSING_BLOCK_LABEL_960;
            }
            j2 = l1;
            l2 = i2;
            i3 = j1;
            k2 = i1;
            if (!q1.k)
            {
                break MISSING_BLOCK_LABEL_960;
            }
            j2 = d.o.a();
            if (j2 != 0) goto _L4; else goto _L3
_L3:
            q1.b();
            k2 = i1;
_L5:
            if (!android.support.v7.widget.RecyclerView.k(d).isEmpty())
            {
                d.invalidate();
            }
            if (android.support.v4.view.w.a(d) != 2)
            {
                android.support.v7.widget.RecyclerView.a(d, j3, k3);
            }
            if (j1 != 0 || l1 != 0)
            {
                j2 = (int)k1.b.d(k1.a);
                if (j1 != l3)
                {
                    if (j1 < 0)
                    {
                        i1 = -j2;
                    } else
                    if (j1 > 0)
                    {
                        i1 = j2;
                    } else
                    {
                        i1 = 0;
                    }
                    l2 = i1;
                } else
                {
                    l2 = 0;
                }
                if (l1 != i4)
                {
                    if (l1 < 0)
                    {
                        i1 = -j2;
                    } else
                    {
                        i1 = j2;
                        if (l1 <= 0)
                        {
                            i1 = 0;
                        }
                    }
                } else
                {
                    i1 = 0;
                }
                if (android.support.v4.view.w.a(d) != 2)
                {
                    RecyclerView recyclerview = d;
                    if (l2 < 0)
                    {
                        recyclerview.c();
                        recyclerview.i.a(-l2);
                    } else
                    if (l2 > 0)
                    {
                        recyclerview.d();
                        recyclerview.k.a(l2);
                    }
                    if (i1 < 0)
                    {
                        recyclerview.e();
                        recyclerview.j.a(-i1);
                    } else
                    if (i1 > 0)
                    {
                        recyclerview.f();
                        recyclerview.l.a(i1);
                    }
                    if (l2 != 0 || i1 != 0)
                    {
                        android.support.v4.view.w.d(recyclerview);
                    }
                }
                if ((l2 != 0 || j1 == l3 || k1.b.g(k1.a) == 0) && (i1 != 0 || l1 == i4 || k1.a() == 0))
                {
                    k1.b();
                }
            }
            if (k2 != 0 || i2 != 0)
            {
                d.a(k2, i2);
            }
            if (!RecyclerView.l(d))
            {
                d.invalidate();
            }
            if (k3 != 0 && android.support.v7.widget.RecyclerView.e(d).d() && i2 == k3)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (j3 != 0 && android.support.v7.widget.RecyclerView.e(d).c() && k2 == j3)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            if (j3 == 0 && k3 == 0 || j1 != 0 || i1 != 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (k1.b.a(k1.a) || i1 == 0)
            {
                RecyclerView.b(d, 0);
            } else
            {
                a();
            }
_L2:
            if (q1 != null)
            {
                if (q1.j)
                {
                    android.support.v7.widget.q.a(q1, 0, 0);
                }
                if (!g)
                {
                    q1.b();
                }
            }
            f = false;
            if (g)
            {
                a();
            }
            return;
_L4:
            if (q1.g >= j2)
            {
                q1.g = j2 - 1;
            }
            android.support.v7.widget.q.a(q1, j3 - j1, k3 - l1);
            k2 = i1;
            i3 = j1;
            l2 = i2;
            j2 = l1;
            i2 = l2;
            j1 = i3;
            l1 = j2;
              goto _L5
        }

        public t()
        {
            d = RecyclerView.this;
            super();
            e = RecyclerView.j();
            f = false;
            g = false;
            c = android.support.v4.widget.k.a(getContext(), RecyclerView.j());
        }
    }

    public static abstract class u
    {

        public final View a;
        int b;
        int c;
        long d;
        int e;
        int f;
        u g;
        u h;
        int i;
        n j;
        RecyclerView k;
        private int l;

        static boolean a(u u1)
        {
            return (u1.i & 0x10) != 0;
        }

        final void a()
        {
            c = -1;
            f = -1;
        }

        final void a(int i1, int j1)
        {
            i = i & ~j1 | i1 & j1;
        }

        final void a(int i1, boolean flag)
        {
            if (c == -1)
            {
                c = b;
            }
            if (f == -1)
            {
                f = b;
            }
            if (flag)
            {
                f = f + i1;
            }
            b = b + i1;
            if (a.getLayoutParams() != null)
            {
                ((j)a.getLayoutParams()).c = true;
            }
        }

        public final void a(boolean flag)
        {
            int i1;
            if (flag)
            {
                i1 = l - 1;
            } else
            {
                i1 = l + 1;
            }
            l = i1;
            if (l < 0)
            {
                l = 0;
                Log.e("View", (new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ")).append(this).toString());
            } else
            {
                if (!flag && l == 1)
                {
                    i = i | 0x10;
                    return;
                }
                if (flag && l == 0)
                {
                    i = i & 0xffffffef;
                    return;
                }
            }
        }

        final boolean a(int i1)
        {
            return (i & i1) != 0;
        }

        final void b(int i1)
        {
            i = i | i1;
        }

        final boolean b()
        {
            return (i & 0x80) != 0;
        }

        public final int c()
        {
            if (f == -1)
            {
                return b;
            } else
            {
                return f;
            }
        }

        final boolean d()
        {
            return j != null;
        }

        final void e()
        {
            j.b(this);
        }

        final boolean f()
        {
            return (i & 0x20) != 0;
        }

        final void g()
        {
            i = i & 0xffffffdf;
        }

        final void h()
        {
            i = i & 0xfffffeff;
        }

        final boolean i()
        {
            return (i & 4) != 0;
        }

        final boolean j()
        {
            return (i & 2) != 0;
        }

        final boolean k()
        {
            return (i & 0x40) != 0;
        }

        final boolean l()
        {
            return (i & 1) != 0;
        }

        final boolean m()
        {
            return (i & 8) != 0;
        }

        final boolean n()
        {
            return (i & 0x100) != 0;
        }

        final void o()
        {
            i = 0;
            b = -1;
            c = -1;
            d = -1L;
            f = -1;
            l = 0;
            g = null;
            h = null;
        }

        public final boolean p()
        {
            return (i & 0x10) == 0 && !android.support.v4.view.w.c(a);
        }

        public String toString()
        {
            StringBuilder stringbuilder = new StringBuilder((new StringBuilder("ViewHolder{")).append(Integer.toHexString(hashCode())).append(" position=").append(b).append(" id=").append(d).append(", oldPos=").append(c).append(", pLpos:").append(f).toString());
            if (d())
            {
                stringbuilder.append(" scrap");
            }
            if (i())
            {
                stringbuilder.append(" invalid");
            }
            if (!l())
            {
                stringbuilder.append(" unbound");
            }
            if (j())
            {
                stringbuilder.append(" update");
            }
            if (m())
            {
                stringbuilder.append(" removed");
            }
            if (b())
            {
                stringbuilder.append(" ignored");
            }
            if (k())
            {
                stringbuilder.append(" changed");
            }
            if (n())
            {
                stringbuilder.append(" tmpDetached");
            }
            if (!p())
            {
                stringbuilder.append((new StringBuilder(" not recyclable(")).append(l).append(")").toString());
            }
            boolean flag;
            if ((i & 0x200) != 0 || i())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                stringbuilder.append("undefined adapter position");
            }
            if (a.getParent() == null)
            {
                stringbuilder.append(" no parent");
            }
            stringbuilder.append("}");
            return stringbuilder.toString();
        }

        public u(View view)
        {
            b = -1;
            c = -1;
            d = -1L;
            e = -1;
            f = -1;
            g = null;
            h = null;
            l = 0;
            j = null;
            if (view == null)
            {
                throw new IllegalArgumentException("itemView may not be null");
            } else
            {
                a = view;
                return;
            }
        }
    }


    private static final Interpolator al = new Interpolator() {

        public final float getInterpolation(float f1)
        {
            f1--;
            return f1 * (f1 * f1 * f1 * f1) + 1.0F;
        }

    };
    private static final boolean s;
    private static final Class t[];
    private final ArrayList A;
    private k B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private int G;
    private boolean H;
    private final boolean I;
    private final AccessibilityManager J;
    private List K;
    private int L;
    private int M;
    private int N;
    private VelocityTracker O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private final int U;
    private final int V;
    private float W;
    final n a;
    private l aa;
    private e.a ab;
    private boolean ac;
    private android.support.v7.widget.v ad;
    private d ae;
    private final int af[];
    private final android.support.v4.view.p ag;
    private final int ah[];
    private final int ai[];
    private final int aj[];
    private Runnable ak;
    android.support.v7.widget.b b;
    android.support.v7.widget.m c;
    a d;
    public i e;
    public final ArrayList f;
    boolean g;
    boolean h;
    android.support.v4.widget.e i;
    android.support.v4.widget.e j;
    android.support.v4.widget.e k;
    android.support.v4.widget.e l;
    e m;
    final t n;
    final r o;
    public List p;
    boolean q;
    boolean r;
    private final p u;
    private SavedState v;
    private boolean w;
    private final Runnable x;
    private final Rect y;
    private o z;

    public RecyclerView(Context context)
    {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeset, int i1)
    {
        Object obj;
        Object obj1;
        Class class1;
        super(context, attributeset, i1);
        u = new p((byte)0);
        a = new n();
        x = new Runnable() {

            final RecyclerView a;

            public final void run()
            {
                if (android.support.v7.widget.RecyclerView.a(a)) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if (RecyclerView.b(a))
                {
                    android.support.v4.d.e.a("RV FullInvalidate");
                    a.h();
                    android.support.v4.d.e.a();
                    return;
                }
                if (!a.b.d()) goto _L1; else goto _L3
_L3:
                RecyclerView recyclerview;
                int j1;
                int k1;
                android.support.v4.d.e.a("RV PartialInvalidate");
                a.a();
                a.b.b();
                if (RecyclerView.c(a))
                {
                    break MISSING_BLOCK_LABEL_221;
                }
                recyclerview = a;
                k1 = recyclerview.c.a();
                j1 = 0;
_L5:
                u u1;
                if (j1 >= k1)
                {
                    break MISSING_BLOCK_LABEL_221;
                }
                u1 = RecyclerView.b(recyclerview.c.b(j1));
                if (u1 != null && !u1.b())
                {
                    if (!u1.m() && !u1.i())
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    recyclerview.requestLayout();
                }
_L7:
                j1++;
                if (true) goto _L5; else goto _L4
_L4:
                if (!u1.j()) goto _L7; else goto _L6
_L6:
label0:
                {
                    int l1 = recyclerview.d.a(u1.b);
                    if (u1.e != l1)
                    {
                        break label0;
                    }
                    if (!u1.k() || !recyclerview.g())
                    {
                        recyclerview.d.b(u1, u1.b);
                    } else
                    {
                        recyclerview.requestLayout();
                    }
                }
                  goto _L7
                recyclerview.requestLayout();
                a.a(true);
                android.support.v4.d.e.a();
                return;
            }

            
            {
                a = RecyclerView.this;
                super();
            }
        };
        y = new Rect();
        f = new ArrayList();
        A = new ArrayList();
        h = false;
        L = 0;
        m = new android.support.v7.widget.n();
        M = 0;
        N = -1;
        W = 1.401298E-45F;
        n = new t();
        o = new r();
        q = false;
        r = false;
        ab = new f((byte)0);
        ac = false;
        af = new int[2];
        ah = new int[2];
        ai = new int[2];
        aj = new int[2];
        ak = new Runnable() {

            final RecyclerView a;

            public final void run()
            {
                if (a.m != null)
                {
                    a.m.a();
                }
                RecyclerView.d(a);
            }

            
            {
                a = RecyclerView.this;
                super();
            }
        };
        setFocusableInTouchMode(true);
        Object aobj[];
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        I = flag;
        obj = ViewConfiguration.get(context);
        T = ((ViewConfiguration) (obj)).getScaledTouchSlop();
        U = ((ViewConfiguration) (obj)).getScaledMinimumFlingVelocity();
        V = ((ViewConfiguration) (obj)).getScaledMaximumFlingVelocity();
        if (android.support.v4.view.w.a(this) == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setWillNotDraw(flag);
        m.h = ab;
        b = new android.support.v7.widget.b(new b.a() {

            final RecyclerView a;

            private void c(b.b b1)
            {
                switch (b1.a)
                {
                default:
                    return;

                case 0: // '\0'
                    android.support.v7.widget.RecyclerView.e(a).a(b1.b, b1.c);
                    return;

                case 1: // '\001'
                    android.support.v7.widget.RecyclerView.e(a).b(b1.b, b1.c);
                    return;

                case 2: // '\002'
                    android.support.v7.widget.RecyclerView.e(a).c(b1.b, b1.c);
                    return;

                case 3: // '\003'
                    android.support.v7.widget.RecyclerView.e(a).d(b1.b, b1.c);
                    break;
                }
            }

            public final u a(int j1)
            {
                RecyclerView recyclerview;
                int k1;
                int l1;
                recyclerview = a;
                l1 = recyclerview.c.b();
                k1 = 0;
_L6:
                if (k1 >= l1) goto _L2; else goto _L1
_L1:
                u u1 = RecyclerView.b(recyclerview.c.c(k1));
                if (u1 == null || u1.m() || u1.b != j1) goto _L4; else goto _L3
_L4:
                k1++;
                  goto _L5
_L2:
                u1 = null;
_L3:
                if (u1 == null || a.c.a(u1.a))
                {
                    return null;
                }
                return u1;
_L5:
                if (true) goto _L6; else goto _L2
            }

            public final void a(int j1, int k1)
            {
                a.a(j1, k1, true);
                a.q = true;
                r r1 = a.o;
                r1.h = r1.h + k1;
            }

            public final void a(b.b b1)
            {
                c(b1);
            }

            public final void b(int j1, int k1)
            {
                a.a(j1, k1, false);
                a.q = true;
            }

            public final void b(b.b b1)
            {
                c(b1);
            }

            public final void c(int j1, int k1)
            {
                Object obj2 = a;
                int j2 = ((RecyclerView) (obj2)).c.b();
                for (int l1 = 0; l1 < j2; l1++)
                {
                    View view = ((RecyclerView) (obj2)).c.c(l1);
                    u u2 = RecyclerView.b(view);
                    if (u2 == null || u2.b() || u2.b < j1 || u2.b >= j1 + k1)
                    {
                        continue;
                    }
                    u2.b(2);
                    if (((RecyclerView) (obj2)).g())
                    {
                        u2.b(64);
                    }
                    ((j)view.getLayoutParams()).c = true;
                }

                obj2 = ((RecyclerView) (obj2)).a;
                for (int i2 = ((n) (obj2)).c.size() - 1; i2 >= 0; i2--)
                {
                    u u1 = (u)((n) (obj2)).c.get(i2);
                    if (u1 == null)
                    {
                        continue;
                    }
                    int k2 = u1.c();
                    if (k2 >= j1 && k2 < j1 + k1)
                    {
                        u1.b(2);
                        ((n) (obj2)).b(i2);
                    }
                }

                a.r = true;
            }

            public final void d(int j1, int k1)
            {
                RecyclerView recyclerview = a;
                int j2 = recyclerview.c.b();
                for (int l1 = 0; l1 < j2; l1++)
                {
                    u u1 = RecyclerView.b(recyclerview.c.c(l1));
                    if (u1 != null && !u1.b() && u1.b >= j1)
                    {
                        u1.a(k1, false);
                        recyclerview.o.i = true;
                    }
                }

                n n1 = recyclerview.a;
                j2 = n1.c.size();
                for (int i2 = 0; i2 < j2; i2++)
                {
                    u u2 = (u)n1.c.get(i2);
                    if (u2 != null && u2.c() >= j1)
                    {
                        u2.a(k1, true);
                    }
                }

                recyclerview.requestLayout();
                a.q = true;
            }

            public final void e(int j1, int k1)
            {
                int k2 = -1;
                RecyclerView recyclerview = a;
                int l2 = recyclerview.c.b();
                byte byte0;
                int l1;
                int i2;
                int j2;
                if (j1 < k1)
                {
                    byte0 = -1;
                    l1 = k1;
                    i2 = j1;
                } else
                {
                    byte0 = 1;
                    l1 = j1;
                    i2 = k1;
                }
                j2 = 0;
                while (j2 < l2) 
                {
                    u u1 = RecyclerView.b(recyclerview.c.c(j2));
                    if (u1 != null && u1.b >= i2 && u1.b <= l1)
                    {
                        if (u1.b == j1)
                        {
                            u1.a(k1 - j1, false);
                        } else
                        {
                            u1.a(byte0, false);
                        }
                        recyclerview.o.i = true;
                    }
                    j2++;
                }
                n n1 = recyclerview.a;
                if (j1 < k1)
                {
                    l1 = k1;
                    i2 = j1;
                    byte0 = k2;
                } else
                {
                    byte0 = 1;
                    l1 = j1;
                    i2 = k1;
                }
                k2 = n1.c.size();
                j2 = 0;
                while (j2 < k2) 
                {
                    u u2 = (u)n1.c.get(j2);
                    if (u2 != null && u2.b >= i2 && u2.b <= l1)
                    {
                        if (u2.b == j1)
                        {
                            u2.a(k1 - j1, false);
                        } else
                        {
                            u2.a(byte0, false);
                        }
                    }
                    j2++;
                }
                recyclerview.requestLayout();
                a.q = true;
            }

            
            {
                a = RecyclerView.this;
                super();
            }
        });
        c = new android.support.v7.widget.m(new m.b() {

            final RecyclerView a;

            public final int a()
            {
                return a.getChildCount();
            }

            public final int a(View view)
            {
                return a.indexOfChild(view);
            }

            public final void a(int j1)
            {
                View view = a.getChildAt(j1);
                if (view != null)
                {
                    RecyclerView.b(a, view);
                }
                a.removeViewAt(j1);
            }

            public final void a(View view, int j1)
            {
                a.addView(view, j1);
                android.support.v7.widget.RecyclerView.a(a, view);
            }

            public final void a(View view, int j1, android.view.ViewGroup.LayoutParams layoutparams)
            {
                u u1 = RecyclerView.b(view);
                if (u1 != null)
                {
                    if (!u1.n() && !u1.b())
                    {
                        throw new IllegalArgumentException((new StringBuilder("Called attach on a child which is not detached: ")).append(u1).toString());
                    }
                    u1.h();
                }
                android.support.v7.widget.RecyclerView.a(a, view, j1, layoutparams);
            }

            public final u b(View view)
            {
                return RecyclerView.b(view);
            }

            public final View b(int j1)
            {
                return a.getChildAt(j1);
            }

            public final void b()
            {
                int k1 = a.getChildCount();
                for (int j1 = 0; j1 < k1; j1++)
                {
                    RecyclerView.b(a, b(j1));
                }

                a.removeAllViews();
            }

            public final void c(int j1)
            {
                Object obj2 = b(j1);
                if (obj2 != null)
                {
                    obj2 = RecyclerView.b(((View) (obj2)));
                    if (obj2 != null)
                    {
                        if (((u) (obj2)).n() && !((u) (obj2)).b())
                        {
                            throw new IllegalArgumentException((new StringBuilder("called detach on an already detached child ")).append(obj2).toString());
                        }
                        ((u) (obj2)).b(256);
                    }
                }
                android.support.v7.widget.RecyclerView.a(a, j1);
            }

            
            {
                a = RecyclerView.this;
                super();
            }
        });
        if (android.support.v4.view.w.e(this) == 0)
        {
            android.support.v4.view.w.f(this);
        }
        J = (AccessibilityManager)getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new android.support.v7.widget.v(this));
        if (attributeset == null) goto _L2; else goto _L1
_L1:
        obj = context.obtainStyledAttributes(attributeset, android.support.v7.d.a.a.RecyclerView, i1, 0);
        obj1 = ((TypedArray) (obj)).getString(android.support.v7.d.a.a.RecyclerView_layoutManager);
        ((TypedArray) (obj)).recycle();
        if (obj1 == null) goto _L2; else goto _L3
_L3:
        obj = ((String) (obj1)).trim();
        if (((String) (obj)).length() == 0) goto _L2; else goto _L4
_L4:
        if (((String) (obj)).charAt(0) == '.')
        {
            obj = (new StringBuilder()).append(context.getPackageName()).append(((String) (obj))).toString();
        } else
        if (!((String) (obj)).contains("."))
        {
            obj = (new StringBuilder()).append(android/support/v7/widget/RecyclerView.getPackage().getName()).append('.').append(((String) (obj))).toString();
        }
_L9:
        if (!isInEditMode()) goto _L6; else goto _L5
_L5:
        obj1 = getClass().getClassLoader();
_L7:
        class1 = ((ClassLoader) (obj1)).loadClass(((String) (obj))).asSubclass(android/support/v7/widget/RecyclerView$i);
        obj1 = class1.getConstructor(t);
        aobj = new Object[4];
        aobj[0] = context;
        aobj[1] = attributeset;
        aobj[2] = Integer.valueOf(i1);
        aobj[3] = Integer.valueOf(0);
        context = ((Context) (aobj));
_L8:
        NoSuchMethodException nosuchmethodexception;
        try
        {
            ((Constructor) (obj1)).setAccessible(true);
            setLayoutManager((i)((Constructor) (obj1)).newInstance(context));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Unable to find LayoutManager ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Could not instantiate the LayoutManager: ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Cannot access non-public constructor ").append(((String) (obj))).toString(), context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Class is not a LayoutManager ").append(((String) (obj))).toString(), context);
        }
_L2:
        ag = new android.support.v4.view.p(this);
        setNestedScrollingEnabled(true);
        return;
_L6:
        obj1 = context.getClassLoader();
          goto _L7
        context;
        obj1 = class1.getConstructor(new Class[0]);
        context = null;
          goto _L8
        nosuchmethodexception;
        nosuchmethodexception.initCause(context);
        throw new IllegalStateException((new StringBuilder()).append(attributeset.getPositionDescription()).append(": Error creating LayoutManager ").append(((String) (obj))).toString(), nosuchmethodexception);
          goto _L9
    }

    private void a(android.support.v4.f.a a1)
    {
        List list = o.e;
        int i1 = list.size() - 1;
        while (i1 >= 0) 
        {
            View view = (View)list.get(i1);
            u u1 = b(view);
            h h1 = (h)o.b.remove(u1);
            if (!o.j)
            {
                o.c.remove(u1);
            }
            if (a1.remove(view) != null)
            {
                e.a(view, a);
            } else
            if (h1 != null)
            {
                a(h1);
            } else
            {
                a(new h(u1, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
            i1--;
        }
        list.clear();
    }

    private void a(h h1)
    {
        View view = h1.a.a;
        a(h1.a);
        int i1 = h1.b;
        int j1 = h1.c;
        int k1 = view.getLeft();
        int l1 = view.getTop();
        if (!h1.a.m() && (i1 != k1 || j1 != l1))
        {
            h1.a.a(false);
            view.layout(k1, l1, view.getWidth() + k1, view.getHeight() + l1);
            if (m.a(h1.a, i1, j1, k1, l1))
            {
                t();
            }
            return;
        } else
        {
            h1.a.a(false);
            m.a(h1.a);
            t();
            return;
        }
    }

    private void a(u u1)
    {
        View view = u1.a;
        boolean flag;
        if (view.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(a(view));
        if (u1.n())
        {
            c.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!flag)
        {
            c.a(view, -1, true);
            return;
        }
        u1 = c;
        int i1 = ((android.support.v7.widget.m) (u1)).a.a(view);
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("view is not a child, cannot hide ")).append(view).toString());
        } else
        {
            ((android.support.v7.widget.m) (u1)).b.a(i1);
            ((android.support.v7.widget.m) (u1)).c.add(view);
            return;
        }
    }

    static void a(RecyclerView recyclerview, int i1)
    {
        recyclerview.detachViewFromParent(i1);
    }

    static void a(RecyclerView recyclerview, int i1, int j1)
    {
        recyclerview.b(i1, j1);
    }

    static void a(RecyclerView recyclerview, View view)
    {
        b(view);
        if (recyclerview.K != null)
        {
            for (int i1 = recyclerview.K.size() - 1; i1 >= 0; i1--)
            {
                recyclerview.K.get(i1);
            }

        }
    }

    static void a(RecyclerView recyclerview, View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        recyclerview.attachViewToParent(view, i1, layoutparams);
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = android.support.v4.view.n.b(motionevent);
        if (android.support.v4.view.n.b(motionevent, i1) == N)
        {
            int j1;
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            N = android.support.v4.view.n.b(motionevent, i1);
            j1 = (int)(android.support.v4.view.n.c(motionevent, i1) + 0.5F);
            R = j1;
            P = j1;
            i1 = (int)(android.support.v4.view.n.d(motionevent, i1) + 0.5F);
            S = i1;
            Q = i1;
        }
    }

    private boolean a(int i1, int j1, MotionEvent motionevent)
    {
        int l1 = 0;
        boolean flag4 = false;
        int j2 = 0;
        boolean flag2 = false;
        int k2 = 0;
        int k1 = 0;
        int i2 = 0;
        boolean flag3 = false;
        l();
        if (d != null)
        {
            a();
            q();
            android.support.v4.d.e.a("RV Scroll");
            l1 = ((flag4) ? 1 : 0);
            if (i1 != 0)
            {
                k1 = e.a(i1, a, o);
                l1 = i1 - k1;
            }
            i2 = ((flag3) ? 1 : 0);
            j2 = ((flag2) ? 1 : 0);
            if (j1 != 0)
            {
                i2 = e.b(j1, a, o);
                j2 = j1 - i2;
            }
            android.support.v4.d.e.a();
            if (g())
            {
                int l2 = c.a();
                k2 = 0;
                while (k2 < l2) 
                {
                    View view = c.b(k2);
                    Object obj = a(view);
                    if (obj == null || ((u) (obj)).h == null)
                    {
                        continue;
                    }
                    obj = ((u) (obj)).h;
                    int i3;
                    int j3;
                    if (obj != null)
                    {
                        obj = ((u) (obj)).a;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    i3 = view.getLeft();
                    j3 = view.getTop();
                    if (i3 != ((View) (obj)).getLeft() || j3 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(i3, j3, ((View) (obj)).getWidth() + i3, ((View) (obj)).getHeight() + j3);
                    }
                    k2++;
                }
            }
            r();
            a(false);
            k2 = k1;
        }
        if (!f.isEmpty())
        {
            invalidate();
        }
        if (dispatchNestedScroll(k2, i2, l1, j2, ah))
        {
            R = R - ah[0];
            S = S - ah[1];
            if (motionevent != null)
            {
                motionevent.offsetLocation(ah[0], ah[1]);
            }
            motionevent = aj;
            motionevent[0] = motionevent[0] + ah[0];
            motionevent = aj;
            motionevent[1] = motionevent[1] + ah[1];
        } else
        if (android.support.v4.view.w.a(this) != 2)
        {
            if (motionevent != null)
            {
                float f1 = motionevent.getX();
                float f2 = l1;
                float f3 = motionevent.getY();
                float f4 = j2;
                boolean flag1 = false;
                boolean flag;
                if (f2 < 0.0F)
                {
                    c();
                    flag = flag1;
                    if (i.a(-f2 / (float)getWidth(), 1.0F - f3 / (float)getHeight()))
                    {
                        flag = true;
                    }
                } else
                {
                    flag = flag1;
                    if (f2 > 0.0F)
                    {
                        d();
                        flag = flag1;
                        if (k.a(f2 / (float)getWidth(), f3 / (float)getHeight()))
                        {
                            flag = true;
                        }
                    }
                }
                if (f4 < 0.0F)
                {
                    e();
                    flag1 = flag;
                    if (j.a(-f4 / (float)getHeight(), f1 / (float)getWidth()))
                    {
                        flag1 = true;
                    }
                } else
                {
                    flag1 = flag;
                    if (f4 > 0.0F)
                    {
                        f();
                        flag1 = flag;
                        if (l.a(f4 / (float)getHeight(), 1.0F - f1 / (float)getWidth()))
                        {
                            flag1 = true;
                        }
                    }
                }
                if (flag1 || f2 != 0.0F || f4 != 0.0F)
                {
                    android.support.v4.view.w.d(this);
                }
            }
            b(i1, j1);
        }
        if (k2 != 0 || i2 != 0)
        {
            a(k2, i2);
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
        return k2 != 0 || i2 != 0;
    }

    static boolean a(RecyclerView recyclerview)
    {
        return recyclerview.g;
    }

    private long b(u u1)
    {
        if (d.b)
        {
            return u1.d;
        } else
        {
            return (long)u1.b;
        }
    }

    static u b(View view)
    {
        if (view == null)
        {
            return null;
        } else
        {
            return ((j)view.getLayoutParams()).a;
        }
    }

    private void b(int i1, int j1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (i != null)
        {
            flag = flag1;
            if (!i.a())
            {
                flag = flag1;
                if (i1 > 0)
                {
                    flag = i.c();
                }
            }
        }
        flag1 = flag;
        if (k != null)
        {
            flag1 = flag;
            if (!k.a())
            {
                flag1 = flag;
                if (i1 < 0)
                {
                    flag1 = flag | k.c();
                }
            }
        }
        flag = flag1;
        if (j != null)
        {
            flag = flag1;
            if (!j.a())
            {
                flag = flag1;
                if (j1 > 0)
                {
                    flag = flag1 | j.c();
                }
            }
        }
        flag1 = flag;
        if (l != null)
        {
            flag1 = flag;
            if (!l.a())
            {
                flag1 = flag;
                if (j1 < 0)
                {
                    flag1 = flag | l.c();
                }
            }
        }
        if (flag1)
        {
            android.support.v4.view.w.d(this);
        }
    }

    static void b(RecyclerView recyclerview, int i1)
    {
        recyclerview.setScrollState(i1);
    }

    static void b(RecyclerView recyclerview, View view)
    {
        recyclerview.f(view);
    }

    static boolean b(RecyclerView recyclerview)
    {
        return recyclerview.h;
    }

    public static int c(View view)
    {
        Object obj;
        view = b(view);
        if (view == null || ((u) (view)).k == null)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        obj = ((u) (view)).k;
        if (!view.a(524) && view.l()) goto _L2; else goto _L1
_L1:
        int i1 = -1;
_L4:
        return i1;
_L2:
        int j1;
        int l1;
        int i2;
        obj = ((RecyclerView) (obj)).b;
        j1 = ((u) (view)).b;
        i2 = ((android.support.v7.widget.b) (obj)).a.size();
        l1 = 0;
_L10:
        i1 = j1;
        if (l1 >= i2) goto _L4; else goto _L3
_L3:
        view = (b.b)((android.support.v7.widget.b) (obj)).a.get(l1);
        i1 = j1;
        ((b.b) (view)).a;
        JVM INSTR tableswitch 0 3: default 124
    //                   0 137
    //                   1 157
    //                   2 126
    //                   3 190;
           goto _L5 _L6 _L7 _L8 _L9
_L9:
        break MISSING_BLOCK_LABEL_190;
_L8:
        break; /* Loop/switch isn't completed */
_L5:
        i1 = j1;
_L11:
        l1++;
        j1 = i1;
          goto _L10
_L6:
        i1 = j1;
        if (((b.b) (view)).b <= j1)
        {
            i1 = j1 + ((b.b) (view)).c;
        }
          goto _L11
_L7:
        i1 = j1;
        if (((b.b) (view)).b <= j1)
        {
            if (((b.b) (view)).b + ((b.b) (view)).c > j1)
            {
                break MISSING_BLOCK_LABEL_242;
            }
            i1 = j1 - ((b.b) (view)).c;
        }
          goto _L11
        if (((b.b) (view)).b == j1)
        {
            i1 = ((b.b) (view)).c;
        } else
        {
            int k1 = j1;
            if (((b.b) (view)).b < j1)
            {
                k1 = j1 - 1;
            }
            i1 = k1;
            if (((b.b) (view)).c <= k1)
            {
                i1 = k1 + 1;
            }
        }
          goto _L11
        return -1;
    }

    private void c(int i1, int j1)
    {
        int l1 = android.view.View.MeasureSpec.getMode(i1);
        int k1 = android.view.View.MeasureSpec.getMode(j1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        switch (l1)
        {
        default:
            i1 = android.support.v4.view.w.l(this);
            // fall through

        case -2147483648: 
        case 1073741824: 
            switch (k1)
            {
            default:
                j1 = android.support.v4.view.w.m(this);
                // fall through

            case -2147483648: 
            case 1073741824: 
                setMeasuredDimension(i1, j1);
                break;
            }
            break;
        }
    }

    static void c(RecyclerView recyclerview, int i1)
    {
        if (recyclerview.e != null)
        {
            recyclerview.e.b(i1);
            recyclerview.awakenScrollBars();
        }
    }

    static boolean c(RecyclerView recyclerview)
    {
        return recyclerview.F;
    }

    static boolean c(RecyclerView recyclerview, View view)
    {
        boolean flag = true;
        recyclerview.a();
        android.support.v7.widget.m m1 = recyclerview.c;
        int i1 = m1.a.a(view);
        if (i1 == -1)
        {
            m1.c.remove(view);
        } else
        if (m1.b.b(i1))
        {
            m1.b.c(i1);
            m1.c.remove(view);
            m1.a.a(i1);
        } else
        {
            flag = false;
        }
        if (flag)
        {
            view = b(view);
            recyclerview.a.b(view);
            recyclerview.a.a(view);
        }
        recyclerview.a(false);
        return flag;
    }

    public static int d(View view)
    {
        view = b(view);
        if (view != null)
        {
            return view.c();
        } else
        {
            return -1;
        }
    }

    private boolean d(int i1, int j1)
    {
        int l1;
        boolean flag1;
        flag1 = false;
        l1 = c.a();
        if (l1 != 0) goto _L2; else goto _L1
_L1:
        boolean flag;
label0:
        {
            if (i1 == 0)
            {
                flag = flag1;
                if (j1 == 0)
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        int k1 = 0;
        do
        {
            flag = flag1;
            if (k1 >= l1)
            {
                continue;
            }
            u u1 = b(c.b(k1));
            if (!u1.b())
            {
                int i2 = u1.c();
                if (i2 < i1 || i2 > j1)
                {
                    return true;
                }
            }
            k1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean d(RecyclerView recyclerview)
    {
        recyclerview.ac = false;
        return false;
    }

    static i e(RecyclerView recyclerview)
    {
        return recyclerview.e;
    }

    static void f(RecyclerView recyclerview)
    {
        recyclerview.l();
    }

    private void f(View view)
    {
        b(view);
        if (K != null)
        {
            for (int i1 = K.size() - 1; i1 >= 0; i1--)
            {
                K.get(i1);
            }

        }
    }

    static a g(RecyclerView recyclerview)
    {
        return recyclerview.d;
    }

    private float getScrollFactor()
    {
label0:
        {
            if (W == 1.401298E-45F)
            {
                TypedValue typedvalue = new TypedValue();
                if (!getContext().getTheme().resolveAttribute(0x101004d, typedvalue, true))
                {
                    break label0;
                }
                W = typedvalue.getDimension(getContext().getResources().getDisplayMetrics());
            }
            return W;
        }
        return 0.0F;
    }

    static void h(RecyclerView recyclerview)
    {
        recyclerview.q();
    }

    static boolean i(RecyclerView recyclerview)
    {
        return recyclerview.g();
    }

    static Interpolator j()
    {
        return al;
    }

    static void j(RecyclerView recyclerview)
    {
        recyclerview.r();
    }

    static ArrayList k(RecyclerView recyclerview)
    {
        return recyclerview.f;
    }

    static boolean k()
    {
        return s;
    }

    private void l()
    {
        x.run();
    }

    static boolean l(RecyclerView recyclerview)
    {
        return recyclerview.awakenScrollBars();
    }

    private void m()
    {
        t t1 = n;
        t1.d.removeCallbacks(t1);
        t1.c.b();
        if (e != null)
        {
            e.r();
        }
    }

    static void m(RecyclerView recyclerview)
    {
        if (!recyclerview.h)
        {
            recyclerview.h = true;
            int k1 = recyclerview.c.b();
            for (int i1 = 0; i1 < k1; i1++)
            {
                u u1 = b(recyclerview.c.c(i1));
                if (u1 != null && !u1.b())
                {
                    u1.b(512);
                }
            }

            recyclerview = recyclerview.a;
            k1 = ((n) (recyclerview)).c.size();
            for (int j1 = 0; j1 < k1; j1++)
            {
                u u2 = (u)((n) (recyclerview)).c.get(j1);
                if (u2 != null)
                {
                    u2.b(512);
                }
            }

        }
    }

    private void n()
    {
        boolean flag1 = false;
        if (i != null)
        {
            flag1 = i.c();
        }
        boolean flag = flag1;
        if (j != null)
        {
            flag = flag1 | j.c();
        }
        flag1 = flag;
        if (k != null)
        {
            flag1 = flag | k.c();
        }
        flag = flag1;
        if (l != null)
        {
            flag = flag1 | l.c();
        }
        if (flag)
        {
            android.support.v4.view.w.d(this);
        }
    }

    static boolean n(RecyclerView recyclerview)
    {
        return recyclerview.I;
    }

    private void o()
    {
        l = null;
        j = null;
        k = null;
        i = null;
    }

    static boolean o(RecyclerView recyclerview)
    {
        return recyclerview.D;
    }

    private void p()
    {
        if (O != null)
        {
            O.clear();
        }
        stopNestedScroll();
        n();
        setScrollState(0);
    }

    static boolean p(RecyclerView recyclerview)
    {
        return recyclerview.C;
    }

    static Runnable q(RecyclerView recyclerview)
    {
        return recyclerview.x;
    }

    private void q()
    {
        L = L + 1;
    }

    private void r()
    {
        L = L - 1;
        if (L <= 0)
        {
            L = 0;
            int i1 = G;
            G = 0;
            if (i1 != 0 && J != null && J.isEnabled())
            {
                AccessibilityEvent accessibilityevent = AccessibilityEvent.obtain();
                accessibilityevent.setEventType(2048);
                android.support.v4.view.a.a.a(accessibilityevent, i1);
                sendAccessibilityEventUnchecked(accessibilityevent);
            }
        }
    }

    static boolean r(RecyclerView recyclerview)
    {
        recyclerview.H = true;
        return true;
    }

    static AccessibilityManager s(RecyclerView recyclerview)
    {
        return recyclerview.J;
    }

    private boolean s()
    {
        return L > 0;
    }

    private void setScrollState(int i1)
    {
        if (i1 != M) goto _L2; else goto _L1
_L1:
        return;
_L2:
        M = i1;
        if (i1 != 2)
        {
            m();
        }
        if (e != null)
        {
            e.f(i1);
        }
        if (aa != null)
        {
            aa.a(this, i1);
        }
        if (p != null)
        {
            int j1 = p.size() - 1;
            while (j1 >= 0) 
            {
                ((l)p.get(j1)).a(this, i1);
                j1--;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    static android.support.v7.widget.v t(RecyclerView recyclerview)
    {
        return recyclerview.ad;
    }

    private void t()
    {
        if (!ac && C)
        {
            android.support.v4.view.w.a(this, ak);
            ac = true;
        }
    }

    static o u(RecyclerView recyclerview)
    {
        return recyclerview.z;
    }

    private void u()
    {
        boolean flag;
        boolean flag1;
        boolean flag2 = true;
        if (h)
        {
            b.a();
            w();
            e.q();
        }
        r r1;
        if (m != null && e.f())
        {
            b.b();
        } else
        {
            b.e();
        }
        if (q && !r || q || r && g())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        r1 = o;
        if (g && m != null && (h || flag || android.support.v7.widget.i.a(e)) && (!h || d.b))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        r1.k = flag1;
        r1 = o;
        if (!o.k || !flag || h) goto _L2; else goto _L1
_L1:
        if (m != null && e.f())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        flag1 = flag2;
_L5:
        r1.l = flag1;
        return;
_L2:
        flag1 = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void v()
    {
        boolean flag = false;
        int i2 = c.b();
        for (int i1 = 0; i1 < i2; i1++)
        {
            u u1 = b(c.c(i1));
            if (!u1.b())
            {
                u1.a();
            }
        }

        n n1 = a;
        i2 = n1.c.size();
        for (int j1 = 0; j1 < i2; j1++)
        {
            ((u)n1.c.get(j1)).a();
        }

        i2 = n1.a.size();
        for (int k1 = 0; k1 < i2; k1++)
        {
            ((u)n1.a.get(k1)).a();
        }

        if (n1.b != null)
        {
            int j2 = n1.b.size();
            for (int l1 = ((flag) ? 1 : 0); l1 < j2; l1++)
            {
                ((u)n1.b.get(l1)).a();
            }

        }
    }

    static boolean v(RecyclerView recyclerview)
    {
        return recyclerview.w;
    }

    static t w(RecyclerView recyclerview)
    {
        return recyclerview.n;
    }

    private void w()
    {
        int k1 = c.b();
        for (int i1 = 0; i1 < k1; i1++)
        {
            u u1 = b(c.c(i1));
            if (u1 != null && !u1.b())
            {
                u1.b(6);
            }
        }

        i();
        n n1 = a;
        if (n1.h.d != null && n1.h.d.b)
        {
            int l1 = n1.c.size();
            for (int j1 = 0; j1 < l1; j1++)
            {
                u u2 = (u)n1.c.get(j1);
                if (u2 != null)
                {
                    u2.b(6);
                }
            }

        } else
        {
            n1.b();
        }
    }

    public final u a(View view)
    {
        ViewParent viewparent = view.getParent();
        if (viewparent != null && viewparent != this)
        {
            throw new IllegalArgumentException((new StringBuilder("View ")).append(view).append(" is not a direct child of ").append(this).toString());
        } else
        {
            return b(view);
        }
    }

    final void a()
    {
        if (!E)
        {
            E = true;
            F = false;
        }
    }

    final void a(int i1, int j1)
    {
        int k1 = getScrollX();
        int i2 = getScrollY();
        onScrollChanged(k1, i2, k1, i2);
        if (aa != null)
        {
            aa.a(this, i1, j1);
        }
        if (p != null)
        {
            for (int l1 = p.size() - 1; l1 >= 0; l1--)
            {
                ((l)p.get(l1)).a(this, i1, j1);
            }

        }
    }

    final void a(int i1, int j1, boolean flag)
    {
        int l1 = c.b();
        int k1 = 0;
        while (k1 < l1) 
        {
            u u1 = b(c.c(k1));
            if (u1 != null && !u1.b())
            {
                if (u1.b >= i1 + j1)
                {
                    u1.a(-j1, flag);
                    o.i = true;
                } else
                if (u1.b >= i1)
                {
                    int i2 = -j1;
                    u1.b(8);
                    u1.a(i2, flag);
                    u1.b = i1 - 1;
                    o.i = true;
                }
            }
            k1++;
        }
        n n1 = a;
        k1 = n1.c.size() - 1;
        while (k1 >= 0) 
        {
            u u2 = (u)n1.c.get(k1);
            if (u2 != null)
            {
                if (u2.c() >= i1 + j1)
                {
                    u2.a(-j1, flag);
                } else
                if (u2.c() >= i1)
                {
                    u2.b(8);
                    n1.b(k1);
                }
            }
            k1--;
        }
        requestLayout();
    }

    final void a(String s1)
    {
        if (s())
        {
            if (s1 == null)
            {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
            } else
            {
                throw new IllegalStateException(s1);
            }
        } else
        {
            return;
        }
    }

    final void a(boolean flag)
    {
        if (E)
        {
            if (flag && F && e != null && d != null)
            {
                h();
            }
            E = false;
            F = false;
        }
    }

    public void addFocusables(ArrayList arraylist, int i1, int j1)
    {
        super.addFocusables(arraylist, i1, j1);
    }

    public final void b()
    {
        setScrollState(0);
        m();
    }

    final void c()
    {
        if (i != null)
        {
            return;
        }
        i = new android.support.v4.widget.e(getContext());
        if (w)
        {
            i.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            i.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        return (layoutparams instanceof j) && e.a((j)layoutparams);
    }

    public int computeHorizontalScrollExtent()
    {
        if (e.c())
        {
            return e.c(o);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollOffset()
    {
        if (e.c())
        {
            return e.a(o);
        } else
        {
            return 0;
        }
    }

    public int computeHorizontalScrollRange()
    {
        if (e.c())
        {
            return e.e(o);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollExtent()
    {
        if (e.d())
        {
            return e.d(o);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollOffset()
    {
        if (e.d())
        {
            return e.b(o);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollRange()
    {
        if (e.d())
        {
            return e.f(o);
        } else
        {
            return 0;
        }
    }

    final void d()
    {
        if (k != null)
        {
            return;
        }
        k = new android.support.v4.widget.e(getContext());
        if (w)
        {
            k.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            k.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    public boolean dispatchNestedFling(float f1, float f2, boolean flag)
    {
        android.support.v4.view.p p1 = ag;
        if (p1.c && p1.b != null)
        {
            return android.support.v4.view.ab.a(p1.b, p1.a, f1, f2, flag);
        } else
        {
            return false;
        }
    }

    public boolean dispatchNestedPreFling(float f1, float f2)
    {
        android.support.v4.view.p p1 = ag;
        if (p1.c && p1.b != null)
        {
            return android.support.v4.view.ab.a(p1.b, p1.a, f1, f2);
        } else
        {
            return false;
        }
    }

    public boolean dispatchNestedPreScroll(int i1, int j1, int ai1[], int ai2[])
    {
        android.support.v4.view.p p1;
        boolean flag;
        boolean flag1;
        flag1 = false;
        p1 = ag;
        flag = flag1;
        if (!p1.c) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (p1.b == null) goto _L2; else goto _L3
_L3:
        if (i1 == 0 && j1 == 0) goto _L5; else goto _L4
_L4:
        int ai3[];
        int k1;
        int l1;
        if (ai2 != null)
        {
            p1.a.getLocationInWindow(ai2);
            l1 = ai2[0];
            k1 = ai2[1];
        } else
        {
            k1 = 0;
            l1 = 0;
        }
        ai3 = ai1;
        if (ai1 == null)
        {
            if (p1.d == null)
            {
                p1.d = new int[2];
            }
            ai3 = p1.d;
        }
        ai3[0] = 0;
        ai3[1] = 0;
        android.support.v4.view.ab.a(p1.b, p1.a, i1, j1, ai3);
        if (ai2 != null)
        {
            p1.a.getLocationInWindow(ai2);
            ai2[0] = ai2[0] - l1;
            ai2[1] = ai2[1] - k1;
        }
        if (ai3[0] != 0) goto _L7; else goto _L6
_L6:
        flag = flag1;
        if (ai3[1] == 0) goto _L2; else goto _L7
_L7:
        flag = true;
_L2:
        return flag;
_L5:
        flag = flag1;
        if (ai2 != null)
        {
            ai2[0] = 0;
            ai2[1] = 0;
            return false;
        }
        if (true) goto _L2; else goto _L8
_L8:
    }

    public boolean dispatchNestedScroll(int i1, int j1, int k1, int l1, int ai1[])
    {
        android.support.v4.view.p p1 = ag;
        if (p1.c && p1.b != null)
        {
            if (i1 != 0 || j1 != 0 || k1 != 0 || l1 != 0)
            {
                int i2;
                int j2;
                if (ai1 != null)
                {
                    p1.a.getLocationInWindow(ai1);
                    j2 = ai1[0];
                    i2 = ai1[1];
                } else
                {
                    i2 = 0;
                    j2 = 0;
                }
                android.support.v4.view.ab.a(p1.b, p1.a, i1, j1, k1, l1);
                if (ai1 != null)
                {
                    p1.a.getLocationInWindow(ai1);
                    ai1[0] = ai1[0] - j2;
                    ai1[1] = ai1[1] - i2;
                }
                return true;
            }
            if (ai1 != null)
            {
                ai1[0] = 0;
                ai1[1] = 0;
            }
        }
        return false;
    }

    protected void dispatchRestoreInstanceState(SparseArray sparsearray)
    {
        dispatchThawSelfOnly(sparsearray);
    }

    protected void dispatchSaveInstanceState(SparseArray sparsearray)
    {
        dispatchFreezeSelfOnly(sparsearray);
    }

    public void draw(Canvas canvas)
    {
        boolean flag = true;
        boolean flag1 = false;
        super.draw(canvas);
        int k1 = f.size();
        for (int i1 = 0; i1 < k1; i1++)
        {
            ((g)f.get(i1)).a(canvas, this, o);
        }

        int j1;
        if (i != null && !i.a())
        {
            int l1 = canvas.save();
            int i2;
            if (w)
            {
                j1 = getPaddingBottom();
            } else
            {
                j1 = 0;
            }
            canvas.rotate(270F);
            canvas.translate(j1 + -getHeight(), 0.0F);
            if (i != null && i.a(canvas))
            {
                k1 = 1;
            } else
            {
                k1 = 0;
            }
            canvas.restoreToCount(l1);
        } else
        {
            k1 = 0;
        }
        j1 = k1;
        if (j != null)
        {
            j1 = k1;
            if (!j.a())
            {
                l1 = canvas.save();
                if (w)
                {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                if (j != null && j.a(canvas))
                {
                    j1 = 1;
                } else
                {
                    j1 = 0;
                }
                j1 = k1 | j1;
                canvas.restoreToCount(l1);
            }
        }
        k1 = j1;
        if (k != null)
        {
            k1 = j1;
            if (!k.a())
            {
                l1 = canvas.save();
                i2 = getWidth();
                if (w)
                {
                    k1 = getPaddingTop();
                } else
                {
                    k1 = 0;
                }
                canvas.rotate(90F);
                canvas.translate(-k1, -i2);
                if (k != null && k.a(canvas))
                {
                    k1 = 1;
                } else
                {
                    k1 = 0;
                }
                k1 = j1 | k1;
                canvas.restoreToCount(l1);
            }
        }
        j1 = k1;
        if (l != null)
        {
            j1 = k1;
            if (!l.a())
            {
                l1 = canvas.save();
                canvas.rotate(180F);
                if (w)
                {
                    canvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
                } else
                {
                    canvas.translate(-getWidth(), -getHeight());
                }
                j1 = ((flag1) ? 1 : 0);
                if (l != null)
                {
                    j1 = ((flag1) ? 1 : 0);
                    if (l.a(canvas))
                    {
                        j1 = 1;
                    }
                }
                j1 = k1 | j1;
                canvas.restoreToCount(l1);
            }
        }
        if (j1 == 0 && m != null && f.size() > 0 && m.b())
        {
            j1 = ((flag) ? 1 : 0);
        }
        if (j1 != 0)
        {
            android.support.v4.view.w.d(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l1)
    {
        return super.drawChild(canvas, view, l1);
    }

    final Rect e(View view)
    {
        j j1 = (j)view.getLayoutParams();
        if (!j1.c)
        {
            return j1.b;
        }
        Rect rect = j1.b;
        rect.set(0, 0, 0, 0);
        int k1 = f.size();
        for (int i1 = 0; i1 < k1; i1++)
        {
            y.set(0, 0, 0, 0);
            ((g)f.get(i1)).a(y, view, this);
            rect.left = rect.left + y.left;
            rect.top = rect.top + y.top;
            rect.right = rect.right + y.right;
            rect.bottom = rect.bottom + y.bottom;
        }

        j1.c = false;
        return rect;
    }

    final void e()
    {
        if (j != null)
        {
            return;
        }
        j = new android.support.v4.widget.e(getContext());
        if (w)
        {
            j.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            j.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    final void f()
    {
        if (l != null)
        {
            return;
        }
        l = new android.support.v4.widget.e(getContext());
        if (w)
        {
            l.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            l.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    public View focusSearch(View view, int i1)
    {
        View view2 = FocusFinder.getInstance().findNextFocus(this, view, i1);
        View view1 = view2;
        if (view2 == null)
        {
            view1 = view2;
            if (d != null)
            {
                view1 = view2;
                if (e != null)
                {
                    view1 = view2;
                    if (!s())
                    {
                        a();
                        view1 = e.c(i1, a, o);
                        a(false);
                    }
                }
            }
        }
        if (view1 != null)
        {
            return view1;
        } else
        {
            return super.focusSearch(view, i1);
        }
    }

    final boolean g()
    {
        return m != null && m.m;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        if (e == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return e.a();
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        if (e == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return e.a(getContext(), attributeset);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (e == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return e.a(layoutparams);
        }
    }

    public a getAdapter()
    {
        return d;
    }

    public int getBaseline()
    {
        if (e != null)
        {
            return -1;
        } else
        {
            return super.getBaseline();
        }
    }

    protected int getChildDrawingOrder(int i1, int j1)
    {
        if (ae == null)
        {
            return super.getChildDrawingOrder(i1, j1);
        } else
        {
            return ae.a();
        }
    }

    public android.support.v7.widget.v getCompatAccessibilityDelegate()
    {
        return ad;
    }

    public e getItemAnimator()
    {
        return m;
    }

    public i getLayoutManager()
    {
        return e;
    }

    public int getMaxFlingVelocity()
    {
        return V;
    }

    public int getMinFlingVelocity()
    {
        return U;
    }

    public m getRecycledViewPool()
    {
        return a.c();
    }

    public int getScrollState()
    {
        return M;
    }

    final void h()
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        Log.e("RecyclerView", "No adapter attached; skipping layout");
_L19:
        return;
_L2:
        Object obj;
        int j3;
        if (e == null)
        {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        o.e.clear();
        a();
        q();
        u();
        Object obj2 = o;
        int i1;
        int k1;
        if (o.k && r && g())
        {
            obj = new android.support.v4.f.a();
        } else
        {
            obj = null;
        }
        obj2.d = ((android.support.v4.f.a) (obj));
        r = false;
        q = false;
        o.j = o.l;
        o.f = d.a();
        obj = af;
        j3 = c.a();
        if (j3 != 0) goto _L4; else goto _L3
_L3:
        obj[0] = 0;
        obj[1] = 0;
_L8:
        if (o.k)
        {
            o.b.clear();
            o.c.clear();
            k1 = c.a();
            for (i1 = 0; i1 < k1; i1++)
            {
                obj = b(c.b(i1));
                if (!((u) (obj)).b() && (!((u) (obj)).i() || d.b))
                {
                    obj2 = ((u) (obj)).a;
                    o.b.put(obj, new h(((u) (obj)), ((View) (obj2)).getLeft(), ((View) (obj2)).getTop(), ((View) (obj2)).getRight(), ((View) (obj2)).getBottom()));
                }
            }

        }
          goto _L5
_L4:
        int j1;
        int i2;
        int k2;
        j1 = 0x7fffffff;
        i2 = 0x80000000;
        k2 = 0;
_L7:
        int l1;
        int j2;
        if (k2 >= j3)
        {
            break; /* Loop/switch isn't completed */
        }
        u u1 = b(c.b(k2));
        j2 = j1;
        if (u1.b())
        {
            break MISSING_BLOCK_LABEL_2031;
        }
        int i3 = u1.c();
        l1 = j1;
        if (i3 < j1)
        {
            l1 = i3;
        }
        j2 = l1;
        if (i3 <= i2)
        {
            break MISSING_BLOCK_LABEL_2031;
        }
        j1 = i3;
_L22:
        k2++;
        i2 = j1;
        j1 = l1;
        if (true) goto _L7; else goto _L6
_L6:
        obj[0] = j1;
        obj[1] = i2;
          goto _L8
_L5:
        if (!o.l) goto _L10; else goto _L9
_L9:
        Object obj3;
        l1 = c.b();
        for (j1 = 0; j1 < l1; j1++)
        {
            obj = b(c.c(j1));
            if (!((u) (obj)).b() && ((u) (obj)).c == -1)
            {
                obj.c = ((u) (obj)).b;
            }
        }

        if (o.d != null)
        {
            l1 = c.a();
            for (j1 = 0; j1 < l1; j1++)
            {
                obj = b(c.b(j1));
                if (((u) (obj)).k() && !((u) (obj)).m() && !((u) (obj)).b())
                {
                    long l3 = b(((u) (obj)));
                    o.d.put(Long.valueOf(l3), obj);
                    o.b.remove(obj);
                }
            }

        }
        boolean flag = o.i;
        o.i = false;
        e.a(a, o);
        o.i = flag;
        obj3 = new android.support.v4.f.a();
        j1 = 0;
_L17:
        if (j1 >= c.a()) goto _L12; else goto _L11
_L11:
        obj = c.b(j1);
        if (b(((View) (obj))).b()) goto _L14; else goto _L13
_L13:
        l1 = 0;
_L18:
        if (l1 >= o.b.size())
        {
            break MISSING_BLOCK_LABEL_2025;
        }
        if (((u)o.b.b(l1)).a != obj) goto _L16; else goto _L15
_L15:
        l1 = 1;
_L21:
        if (l1 == 0)
        {
            ((android.support.v4.f.a) (obj3)).put(obj, new Rect(((View) (obj)).getLeft(), ((View) (obj)).getTop(), ((View) (obj)).getRight(), ((View) (obj)).getBottom()));
        }
_L14:
        j1++;
          goto _L17
_L16:
        l1++;
          goto _L18
_L12:
        v();
        b.c();
_L20:
        o.f = d.a();
        o.h = 0;
        o.j = false;
        e.a(a, o);
        o.i = false;
        v = null;
        r r1 = o;
        boolean flag1;
        if (o.k && m != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        r1.k = flag1;
        if (o.k)
        {
            Object obj1;
            if (o.d != null)
            {
                obj1 = new android.support.v4.f.a();
            } else
            {
                obj1 = null;
            }
            l1 = c.a();
            j1 = 0;
            while (j1 < l1) 
            {
                u u2 = b(c.b(j1));
                if (!u2.b())
                {
                    View view = u2.a;
                    long l4 = b(u2);
                    if (obj1 != null && o.d.get(Long.valueOf(l4)) != null)
                    {
                        ((android.support.v4.f.a) (obj1)).put(Long.valueOf(l4), u2);
                    } else
                    {
                        o.c.put(u2, new h(u2, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
                    }
                }
                j1++;
            }
            a(((android.support.v4.f.a) (obj3)));
            for (j1 = o.b.size() - 1; j1 >= 0; j1--)
            {
                u u3 = (u)o.b.b(j1);
                if (!o.c.containsKey(u3))
                {
                    h h1 = (h)o.b.c(j1);
                    o.b.d(j1);
                    a.b(h1.a);
                    a(h1);
                }
            }

            j1 = o.c.size();
            if (j1 > 0)
            {
                j1--;
                while (j1 >= 0) 
                {
                    u u5 = (u)o.c.b(j1);
                    h h4 = (h)o.c.c(j1);
                    if (o.b.isEmpty() || !o.b.containsKey(u5))
                    {
                        o.c.d(j1);
                        Rect rect;
                        if (obj3 != null)
                        {
                            rect = (Rect)((android.support.v4.f.a) (obj3)).get(u5.a);
                        } else
                        {
                            rect = null;
                        }
                        l1 = h4.b;
                        i2 = h4.c;
                        if (rect != null && (rect.left != l1 || rect.top != i2))
                        {
                            u5.a(false);
                            if (m.a(u5, rect.left, rect.top, l1, i2))
                            {
                                t();
                            }
                        } else
                        {
                            u5.a(false);
                            m.b(u5);
                            t();
                        }
                    }
                    j1--;
                }
            }
            l1 = o.c.size();
            for (j1 = 0; j1 < l1; j1++)
            {
                obj3 = (u)o.c.b(j1);
                h h2 = (h)o.c.c(j1);
                h h3 = (h)o.b.get(obj3);
                if (h3 == null || h2 == null || h3.b == h2.b && h3.c == h2.c)
                {
                    continue;
                }
                ((u) (obj3)).a(false);
                if (m.a(((u) (obj3)), h3.b, h3.c, h2.b, h2.c))
                {
                    t();
                }
            }

            if (o.d != null)
            {
                j1 = o.d.size();
            } else
            {
                j1 = 0;
            }
            j1--;
            while (j1 >= 0) 
            {
                long l5 = ((Long)o.d.b(j1)).longValue();
                obj3 = (u)o.d.get(Long.valueOf(l5));
                if (!((u) (obj3)).b() && a.b != null && a.b.contains(obj3))
                {
                    u u4 = (u)((android.support.v4.f.a) (obj1)).get(Long.valueOf(l5));
                    ((u) (obj3)).a(false);
                    a(((u) (obj3)));
                    obj3.g = u4;
                    a.b(((u) (obj3)));
                    j2 = ((u) (obj3)).a.getLeft();
                    int l2 = ((u) (obj3)).a.getTop();
                    if (u4 == null || u4.b())
                    {
                        i2 = l2;
                        l1 = j2;
                    } else
                    {
                        l1 = u4.a.getLeft();
                        i2 = u4.a.getTop();
                        u4.a(false);
                        u4.h = ((u) (obj3));
                    }
                    m.a(((u) (obj3)), u4, j2, l2, l1, i2);
                    t();
                }
                j1--;
            }
        }
        a(false);
        e.b(a);
        o.g = o.f;
        h = false;
        o.k = false;
        o.l = false;
        r();
        i.b(e);
        if (a.b != null)
        {
            a.b.clear();
        }
        o.d = null;
        if (d(af[0], af[1]))
        {
            a(0, 0);
            return;
        }
          goto _L19
_L10:
        v();
        b.e();
        if (o.d != null)
        {
            l1 = c.a();
            for (j1 = 0; j1 < l1; j1++)
            {
                obj1 = b(c.b(j1));
                if (((u) (obj1)).k() && !((u) (obj1)).m() && !((u) (obj1)).b())
                {
                    l4 = b(((u) (obj1)));
                    o.d.put(Long.valueOf(l4), obj1);
                    o.b.remove(obj1);
                }
            }

        }
        obj3 = null;
          goto _L20
        l1 = 0;
          goto _L21
        j1 = i2;
        l1 = j2;
          goto _L22
    }

    public boolean hasNestedScrollingParent()
    {
        return ag.a();
    }

    public final void i()
    {
        boolean flag = false;
        int l1 = c.b();
        for (int i1 = 0; i1 < l1; i1++)
        {
            ((j)c.c(i1).getLayoutParams()).c = true;
        }

        n n1 = a;
        l1 = n1.c.size();
        for (int k1 = ((flag) ? 1 : 0); k1 < l1; k1++)
        {
            j j1 = (j)((u)n1.c.get(k1)).a.getLayoutParams();
            if (j1 != null)
            {
                j1.c = true;
            }
        }

    }

    public boolean isAttachedToWindow()
    {
        return C;
    }

    public boolean isNestedScrollingEnabled()
    {
        return ag.c;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        L = 0;
        C = true;
        g = false;
        if (e != null)
        {
            e.l = true;
        }
        ac = false;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (m != null)
        {
            m.d();
        }
        g = false;
        b();
        C = false;
        if (e != null)
        {
            e.b(this, a);
        }
        removeCallbacks(ak);
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int j1 = f.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            ((g)f.get(i1)).a(canvas, this);
        }

    }

    public boolean onGenericMotionEvent(MotionEvent motionevent)
    {
        if (e != null && (android.support.v4.view.n.c(motionevent) & 2) != 0 && motionevent.getAction() == 8)
        {
            float f1;
            float f2;
            if (e.d())
            {
                f1 = -android.support.v4.view.n.e(motionevent, 9);
            } else
            {
                f1 = 0.0F;
            }
            if (e.c())
            {
                f2 = android.support.v4.view.n.e(motionevent, 10);
            } else
            {
                f2 = 0.0F;
            }
            if (f1 != 0.0F || f2 != 0.0F)
            {
                float f3 = getScrollFactor();
                a((int)(f2 * f3), (int)(f1 * f3), motionevent);
                return false;
            }
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        byte byte0;
        int i2;
        byte0 = -1;
        j1 = motionevent.getAction();
        if (j1 == 3 || j1 == 0)
        {
            B = null;
        }
        i2 = A.size();
        i1 = 0;
_L7:
        if (i1 >= i2) goto _L2; else goto _L1
_L1:
        k k1 = (k)A.get(i1);
        if (!k1.a() || j1 == 3) goto _L4; else goto _L3
_L3:
        B = k1;
        i1 = 1;
_L8:
        if (i1 == 0) goto _L6; else goto _L5
_L5:
        p();
_L16:
        return true;
_L4:
        i1++;
          goto _L7
_L2:
        i1 = 0;
          goto _L8
_L6:
        boolean flag;
        boolean flag1;
        if (e == null)
        {
            return false;
        }
        flag = e.c();
        flag1 = e.d();
        if (O == null)
        {
            O = VelocityTracker.obtain();
        }
        O.addMovement(motionevent);
        j1 = android.support.v4.view.n.a(motionevent);
        i1 = android.support.v4.view.n.b(motionevent);
        j1;
        JVM INSTR tableswitch 0 6: default 204
    //                   0 214
    //                   1 607
    //                   2 373
    //                   3 621
    //                   4 204
    //                   5 316
    //                   6 599;
           goto _L9 _L10 _L11 _L12 _L13 _L9 _L14 _L15
_L9:
        break; /* Loop/switch isn't completed */
_L13:
        break MISSING_BLOCK_LABEL_621;
_L17:
        if (M != 1)
        {
            return false;
        }
          goto _L16
_L10:
        N = android.support.v4.view.n.b(motionevent, 0);
        i1 = (int)(motionevent.getX() + 0.5F);
        R = i1;
        P = i1;
        i1 = (int)(motionevent.getY() + 0.5F);
        S = i1;
        Q = i1;
        if (M == 2)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
            setScrollState(1);
        }
        int l1;
        int j2;
        int k2;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        l1 = i1;
        if (flag1)
        {
            l1 = i1 | 2;
        }
        startNestedScroll(l1);
          goto _L17
_L14:
        N = android.support.v4.view.n.b(motionevent, i1);
        l1 = (int)(android.support.v4.view.n.c(motionevent, i1) + 0.5F);
        R = l1;
        P = l1;
        i1 = (int)(android.support.v4.view.n.d(motionevent, i1) + 0.5F);
        S = i1;
        Q = i1;
          goto _L17
_L12:
        l1 = android.support.v4.view.n.a(motionevent, N);
        if (l1 < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(N).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        i1 = (int)(android.support.v4.view.n.c(motionevent, l1) + 0.5F);
        l1 = (int)(android.support.v4.view.n.d(motionevent, l1) + 0.5F);
        if (M != 1)
        {
            i1 -= P;
            j2 = l1 - Q;
            if (flag && Math.abs(i1) > T)
            {
                l1 = P;
                k2 = T;
                if (i1 < 0)
                {
                    i1 = -1;
                } else
                {
                    i1 = 1;
                }
                R = i1 * k2 + l1;
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            l1 = i1;
            if (flag1)
            {
                l1 = i1;
                if (Math.abs(j2) > T)
                {
                    l1 = Q;
                    k2 = T;
                    if (j2 < 0)
                    {
                        i1 = byte0;
                    } else
                    {
                        i1 = 1;
                    }
                    S = l1 + i1 * k2;
                    l1 = 1;
                }
            }
            if (l1 != 0)
            {
                setScrollState(1);
            }
        }
          goto _L17
_L15:
        a(motionevent);
          goto _L17
_L11:
        O.clear();
        stopNestedScroll();
          goto _L17
        p();
          goto _L17
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        a();
        android.support.v4.d.e.a("RV OnLayout");
        h();
        android.support.v4.d.e.a();
        a(false);
        g = true;
    }

    protected void onMeasure(int i1, int j1)
    {
        if (H)
        {
            a();
            u();
            if (o.l)
            {
                o.j = true;
            } else
            {
                b.e();
                o.j = false;
            }
            H = false;
            a(false);
        }
        if (d != null)
        {
            o.f = d.a();
        } else
        {
            o.f = 0;
        }
        if (e == null)
        {
            c(i1, j1);
        } else
        {
            e.i.c(i1, j1);
        }
        o.j = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        v = (SavedState)parcelable;
        super.onRestoreInstanceState(v.getSuperState());
        if (e != null && v.a != null)
        {
            e.a(v.a);
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (v != null)
        {
            android.support.v7.widget.SavedState.a(savedstate, v);
            return savedstate;
        }
        if (e != null)
        {
            savedstate.a = e.b();
            return savedstate;
        } else
        {
            savedstate.a = null;
            return savedstate;
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != k1 || j1 != l1)
        {
            o();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1 = motionevent.getAction();
        if (B == null) goto _L2; else goto _L1
_L1:
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        B = null;
_L2:
        if (i1 == 0) goto _L6; else goto _L5
_L5:
        int j1;
        j1 = A.size();
        i1 = 0;
_L30:
        if (i1 >= j1) goto _L6; else goto _L7
_L7:
        Object obj = (k)A.get(i1);
        if (!((k) (obj)).a()) goto _L9; else goto _L8
_L8:
        B = ((k) (obj));
        i1 = 1;
_L11:
        if (i1 != 0)
        {
            p();
            return true;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (i1 == 3 || i1 == 1)
        {
            B = null;
        }
        i1 = 1;
        continue; /* Loop/switch isn't completed */
_L9:
        i1++;
        continue; /* Loop/switch isn't completed */
_L6:
        i1 = 0;
        if (true) goto _L11; else goto _L10
_L10:
        boolean flag;
        boolean flag1;
        if (e == null)
        {
            return false;
        }
        flag = e.c();
        flag1 = e.d();
        if (O == null)
        {
            O = VelocityTracker.obtain();
        }
        O.addMovement(motionevent);
        obj = MotionEvent.obtain(motionevent);
        j1 = android.support.v4.view.n.a(motionevent);
        i1 = android.support.v4.view.n.b(motionevent);
        if (j1 == 0)
        {
            int ai1[] = aj;
            aj[1] = 0;
            ai1[0] = 0;
        }
        ((MotionEvent) (obj)).offsetLocation(aj[0], aj[1]);
        j1;
        JVM INSTR tableswitch 0 6: default 284
    //                   0 291
    //                   1 880
    //                   2 442
    //                   3 1211
    //                   4 284
    //                   5 379
    //                   6 872;
           goto _L12 _L13 _L14 _L15 _L16 _L12 _L17 _L18
_L12:
        ((MotionEvent) (obj)).recycle();
        return true;
_L13:
        N = android.support.v4.view.n.b(motionevent, 0);
        i1 = (int)(motionevent.getX() + 0.5F);
        R = i1;
        P = i1;
        i1 = (int)(motionevent.getY() + 0.5F);
        S = i1;
        Q = i1;
        float f1;
        float f2;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        if (flag)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        k1 = i1;
        if (flag1)
        {
            k1 = i1 | 2;
        }
        startNestedScroll(k1);
        continue; /* Loop/switch isn't completed */
_L17:
        N = android.support.v4.view.n.b(motionevent, i1);
        k1 = (int)(android.support.v4.view.n.c(motionevent, i1) + 0.5F);
        R = k1;
        P = k1;
        i1 = (int)(android.support.v4.view.n.d(motionevent, i1) + 0.5F);
        S = i1;
        Q = i1;
        continue; /* Loop/switch isn't completed */
_L15:
        i1 = android.support.v4.view.n.a(motionevent, N);
        if (i1 < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(N).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        l2 = (int)(android.support.v4.view.n.c(motionevent, i1) + 0.5F);
        i3 = (int)(android.support.v4.view.n.d(motionevent, i1) + 0.5F);
        i2 = R - l2;
        l1 = S - i3;
        i1 = l1;
        k1 = i2;
        if (dispatchNestedPreScroll(i2, l1, ai, ah))
        {
            k1 = i2 - ai[0];
            i1 = l1 - ai[1];
            ((MotionEvent) (obj)).offsetLocation(ah[0], ah[1]);
            motionevent = aj;
            motionevent[0] = motionevent[0] + ah[0];
            motionevent = aj;
            motionevent[1] = motionevent[1] + ah[1];
        }
        l1 = i1;
        j2 = k1;
        if (M != 1)
        {
            if (flag && Math.abs(k1) > T)
            {
                if (k1 > 0)
                {
                    k1 -= T;
                } else
                {
                    k1 += T;
                }
                l1 = 1;
            } else
            {
                l1 = 0;
            }
            i2 = i1;
            k2 = l1;
            if (flag1)
            {
                i2 = i1;
                k2 = l1;
                if (Math.abs(i1) > T)
                {
                    if (i1 > 0)
                    {
                        i2 = i1 - T;
                    } else
                    {
                        i2 = i1 + T;
                    }
                    k2 = 1;
                }
            }
            l1 = i2;
            j2 = k1;
            if (k2 != 0)
            {
                setScrollState(1);
                j2 = k1;
                l1 = i2;
            }
        }
        if (M == 1)
        {
            R = l2 - ah[0];
            S = i3 - ah[1];
            if (!flag)
            {
                j2 = 0;
            }
            if (!flag1)
            {
                l1 = 0;
            }
            if (a(j2, l1, ((MotionEvent) (obj))))
            {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        continue; /* Loop/switch isn't completed */
_L18:
        a(motionevent);
        continue; /* Loop/switch isn't completed */
_L14:
        O.computeCurrentVelocity(1000, V);
        if (flag)
        {
            f1 = -android.support.v4.view.v.a(O, N);
        } else
        {
            f1 = 0.0F;
        }
        if (flag1)
        {
            f2 = -android.support.v4.view.v.b(O, N);
        } else
        {
            f2 = 0.0F;
        }
        if (f1 == 0.0F && f2 == 0.0F) goto _L20; else goto _L19
_L19:
        i1 = (int)f1;
        k1 = (int)f2;
        if (e != null) goto _L22; else goto _L21
_L21:
        Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
_L25:
        i1 = 0;
_L27:
        if (i1 != 0) goto _L23; else goto _L20
_L20:
        setScrollState(0);
_L23:
        O.clear();
        n();
        continue; /* Loop/switch isn't completed */
_L22:
        flag = e.c();
        flag1 = e.d();
        if (!flag || Math.abs(i1) < U)
        {
            i1 = 0;
        }
        if (!flag1 || Math.abs(k1) < U)
        {
            k1 = 0;
        }
        if (i1 == 0 && k1 == 0 || dispatchNestedPreFling(i1, k1)) goto _L25; else goto _L24
_L24:
        if (flag || flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dispatchNestedFling(i1, k1, flag);
        if (!flag) goto _L25; else goto _L26
_L26:
        i1 = Math.max(-V, Math.min(i1, V));
        k1 = Math.max(-V, Math.min(k1, V));
        motionevent = n;
        ((t) (motionevent)).d.setScrollState(2);
        motionevent.b = 0;
        motionevent.a = 0;
        ((t) (motionevent)).c.a(i1, k1, 0x80000000, 0x7fffffff);
        motionevent.a();
        i1 = 1;
          goto _L27
_L16:
        p();
        if (true) goto _L12; else goto _L28
_L28:
        if (true) goto _L30; else goto _L29
_L29:
    }

    protected void removeDetachedView(View view, boolean flag)
    {
        u u1 = b(view);
        if (u1 != null)
        {
            if (u1.n())
            {
                u1.h();
            } else
            if (!u1.b())
            {
                throw new IllegalArgumentException((new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.")).append(u1).toString());
            }
        }
        f(view);
        super.removeDetachedView(view, flag);
    }

    public void requestChildFocus(View view, View view1)
    {
        int i1;
        if (e.i() || s())
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0 && view1 != null)
        {
            y.set(0, 0, view1.getWidth(), view1.getHeight());
            Object obj = view1.getLayoutParams();
            if (obj instanceof j)
            {
                obj = (j)obj;
                if (!((j) (obj)).c)
                {
                    obj = ((j) (obj)).b;
                    Rect rect = y;
                    rect.left = rect.left - ((Rect) (obj)).left;
                    rect = y;
                    rect.right = rect.right + ((Rect) (obj)).right;
                    rect = y;
                    rect.top = rect.top - ((Rect) (obj)).top;
                    rect = y;
                    i1 = rect.bottom;
                    rect.bottom = ((Rect) (obj)).bottom + i1;
                }
            }
            offsetDescendantRectToMyCoords(view1, y);
            offsetRectIntoDescendantCoords(view, y);
            obj = y;
            boolean flag;
            if (!g)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            requestChildRectangleOnScreen(view, ((Rect) (obj)), flag);
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        i i1 = e;
        int l2 = i1.m();
        int i2 = i1.n();
        int i3 = i1.k() - i1.o();
        int k2 = i1.l();
        int l3 = i1.p();
        int j3 = view.getLeft() + rect.left;
        int j2 = view.getTop() + rect.top;
        int k3 = j3 + rect.width();
        int i4 = rect.height();
        int j1 = Math.min(0, j3 - l2);
        int k1 = Math.min(0, j2 - i2);
        int l1 = Math.max(0, k3 - i3);
        k2 = Math.max(0, (j2 + i4) - (k2 - l3));
        if (android.support.v4.view.w.h(i1.i) == 1)
        {
            if (l1 != 0)
            {
                j1 = l1;
            } else
            {
                j1 = Math.max(j1, k3 - i3);
            }
        } else
        if (j1 == 0)
        {
            j1 = Math.min(j3 - l2, l1);
        }
        if (k1 == 0)
        {
            k1 = Math.min(j2 - i2, k2);
        }
        if (j1 != 0 || k1 != 0)
        {
            if (flag)
            {
                scrollBy(j1, k1);
            } else
            if (e == null)
            {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else
            {
                if (!e.c())
                {
                    j1 = 0;
                }
                if (!e.d())
                {
                    k1 = 0;
                }
                if (j1 != 0 || k1 != 0)
                {
                    n.a(j1, k1);
                }
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean flag)
    {
        int j1 = A.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            A.get(i1);
        }

        super.requestDisallowInterceptTouchEvent(flag);
    }

    public void requestLayout()
    {
        if (!E)
        {
            super.requestLayout();
            return;
        } else
        {
            F = true;
            return;
        }
    }

    public void scrollBy(int i1, int j1)
    {
        if (e == null)
        {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else
        {
            boolean flag = e.c();
            boolean flag1 = e.d();
            if (flag || flag1)
            {
                if (!flag)
                {
                    i1 = 0;
                }
                if (!flag1)
                {
                    j1 = 0;
                }
                a(i1, j1, ((MotionEvent) (null)));
                return;
            }
        }
    }

    public void scrollTo(int i1, int j1)
    {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityevent)
    {
        int i1 = 0;
        boolean flag = false;
        if (s())
        {
            if (accessibilityevent != null)
            {
                i1 = android.support.v4.view.a.a.b(accessibilityevent);
            } else
            {
                i1 = 0;
            }
            if (i1 == 0)
            {
                i1 = ((flag) ? 1 : 0);
            }
            G = i1 | G;
            i1 = 1;
        }
        if (i1 != 0)
        {
            return;
        } else
        {
            super.sendAccessibilityEventUnchecked(accessibilityevent);
            return;
        }
    }

    public void setAccessibilityDelegateCompat(android.support.v7.widget.v v1)
    {
        ad = v1;
        android.support.v4.view.w.a(this, ad);
    }

    public void setAdapter(a a1)
    {
        if (d != null)
        {
            a a2 = d;
            p p1 = u;
            a2.a.unregisterObserver(p1);
        }
        if (m != null)
        {
            m.d();
        }
        if (e != null)
        {
            e.c(a);
            e.b(a);
        }
        a.a();
        b.a();
        a a3 = d;
        d = a1;
        if (a1 != null)
        {
            a1.a(u);
        }
        Object obj = a;
        a1 = d;
        ((n) (obj)).a();
        obj = ((n) (obj)).c();
        if (a3 != null)
        {
            ((m) (obj)).b();
        }
        if (((m) (obj)).c == 0)
        {
            ((m) (obj)).a.clear();
        }
        if (a1 != null)
        {
            ((m) (obj)).a();
        }
        o.i = true;
        w();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(d d1)
    {
        if (d1 == ae)
        {
            return;
        }
        ae = d1;
        boolean flag;
        if (ae != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setChildrenDrawingOrderEnabled(flag);
    }

    public void setClipToPadding(boolean flag)
    {
        if (flag != w)
        {
            o();
        }
        w = flag;
        super.setClipToPadding(flag);
        if (g)
        {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean flag)
    {
        D = flag;
    }

    public void setItemAnimator(e e1)
    {
        if (m != null)
        {
            m.d();
            m.h = null;
        }
        m = e1;
        if (m != null)
        {
            m.h = ab;
        }
    }

    public void setItemViewCacheSize(int i1)
    {
        n n1 = a;
        n1.e = i1;
        for (int j1 = n1.c.size() - 1; j1 >= 0 && n1.c.size() > i1; j1--)
        {
            n1.b(j1);
        }

    }

    public void setLayoutManager(i i1)
    {
        if (i1 == e)
        {
            return;
        }
        if (e != null)
        {
            if (C)
            {
                e.b(this, a);
            }
            e.b(null);
        }
        a.a();
        android.support.v7.widget.m m1 = c;
        m.a a1 = m1.b;
        do
        {
            a1.a = 0L;
            if (a1.b == null)
            {
                break;
            }
            a1 = a1.b;
        } while (true);
        m1.c.clear();
        m1.a.b();
        e = i1;
        if (i1 != null)
        {
            if (i1.i != null)
            {
                throw new IllegalArgumentException((new StringBuilder("LayoutManager ")).append(i1).append(" is already attached to a RecyclerView: ").append(i1.i).toString());
            }
            e.b(this);
            if (C)
            {
                e.l = true;
            }
        }
        requestLayout();
    }

    public void setNestedScrollingEnabled(boolean flag)
    {
        android.support.v4.view.p p1 = ag;
        if (p1.c)
        {
            android.support.v4.view.w.t(p1.a);
        }
        p1.c = flag;
    }

    public void setOnScrollListener(l l1)
    {
        aa = l1;
    }

    public void setRecycledViewPool(m m1)
    {
        n n1 = a;
        if (n1.f != null)
        {
            n1.f.b();
        }
        n1.f = m1;
        if (m1 != null)
        {
            m1 = n1.f;
            n1.h.getAdapter();
            m1.a();
        }
    }

    public void setRecyclerListener(o o1)
    {
        z = o1;
    }

    public void setScrollingTouchSlop(int i1)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        switch (i1)
        {
        default:
            (new StringBuilder("setScrollingTouchSlop(): bad argument constant ")).append(i1).append("; using default value");
            // fall through

        case 0: // '\0'
            T = viewconfiguration.getScaledTouchSlop();
            return;

        case 1: // '\001'
            T = android.support.v4.view.aa.a(viewconfiguration);
            break;
        }
    }

    public void setViewCacheExtension(s s1)
    {
        a.g = s1;
    }

    public boolean startNestedScroll(int i1)
    {
        android.support.v4.view.p p1 = ag;
        if (p1.a())
        {
            return true;
        }
        if (p1.c)
        {
            ViewParent viewparent = p1.a.getParent();
            View view = p1.a;
            for (; viewparent != null; viewparent = viewparent.getParent())
            {
                if (android.support.v4.view.ab.a(viewparent, view, p1.a, i1))
                {
                    p1.b = viewparent;
                    android.support.v4.view.ab.b(viewparent, view, p1.a, i1);
                    return true;
                }
                if (viewparent instanceof View)
                {
                    view = (View)viewparent;
                }
            }

        }
        return false;
    }

    public void stopNestedScroll()
    {
        android.support.v4.view.p p1 = ag;
        if (p1.b != null)
        {
            android.support.v4.view.ab.a(p1.b, p1.a);
            p1.b = null;
        }
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT == 18 || android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s = flag;
        t = (new Class[] {
            android/content/Context, android/util/AttributeSet, Integer.TYPE, Integer.TYPE
        });
    }
}
