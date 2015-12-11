// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.c.a;
import android.support.v4.view.ak;
import android.support.v4.view.ap;
import android.support.v4.view.bg;
import android.support.v4.view.z;
import android.support.v4.widget.n;
import android.support.v4.widget.s;
import android.support.v4.widget.t;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            ak, bb, az, ai, 
//            g, bh, bf, as, 
//            aj, aq, a, am, 
//            d, al, bj, au, 
//            bi, at, an, ao, 
//            ay, f, e, av, 
//            ax, aw, ar, ba, 
//            bg

public class RecyclerView extends ViewGroup
{

    private static final Interpolator ab = new android.support.v7.widget.ak();
    private static final boolean p;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private final boolean F;
    private final AccessibilityManager G;
    private boolean H;
    private boolean I;
    private int J;
    private int K;
    private VelocityTracker L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private final int R;
    private final int S;
    private ax T;
    private ar U;
    private boolean V;
    private bj W;
    final az a;
    private Runnable aa;
    android.support.v7.widget.a b;
    d c;
    final List d;
    an e;
    public au f;
    n g;
    n h;
    n i;
    n j;
    aq k;
    final bh l;
    final bf m;
    boolean n;
    boolean o;
    private final bb q;
    private SavedState r;
    private boolean s;
    private final Runnable t;
    private final Rect u;
    private ba v;
    private final ArrayList w;
    private final ArrayList x;
    private aw y;
    private boolean z;

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
        boolean flag1 = false;
        super(context, attributeset, i1);
        q = new bb(this, (byte)0);
        a = new az(this);
        d = new ArrayList();
        t = new ai(this);
        u = new Rect();
        w = new ArrayList();
        x = new ArrayList();
        H = false;
        I = false;
        k = new g();
        J = 0;
        K = -1;
        l = new bh(this);
        m = new bf();
        n = false;
        o = false;
        U = new as(this, (byte)0);
        V = false;
        aa = new aj(this);
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        F = flag;
        context = ViewConfiguration.get(context);
        Q = context.getScaledTouchSlop();
        R = context.getScaledMinimumFlingVelocity();
        S = context.getScaledMaximumFlingVelocity();
        flag = flag1;
        if (ap.a(this) == 2)
        {
            flag = true;
        }
        setWillNotDraw(flag);
        k.h = U;
        b = new android.support.v7.widget.a(new am(this));
        c = new d(new al(this));
        if (ap.e(this) == 0)
        {
            ap.c(this, 1);
        }
        G = (AccessibilityManager)getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new bj(this));
    }

    private void a(int i1, int j1)
    {
        j();
        int k1;
        int l1;
        int i2;
        int j2;
        if (e != null)
        {
            a();
            I = true;
            int l2;
            int j3;
            if (i1 != 0)
            {
                l1 = f.a(i1, a, m);
                k1 = i1 - l1;
            } else
            {
                l1 = 0;
                k1 = 0;
            }
            if (j1 != 0)
            {
                i2 = f.b(j1, a, m);
                j2 = j1 - i2;
            } else
            {
                i2 = 0;
                j2 = 0;
            }
            if (f())
            {
                int i3 = c.a();
                int k2 = 0;
                while (k2 < i3) 
                {
                    View view = c.b(k2);
                    Object obj = a(view);
                    if (obj == null || ((bi) (obj)).h == null)
                    {
                        continue;
                    }
                    obj = ((bi) (obj)).h;
                    int k3;
                    int l3;
                    if (obj != null)
                    {
                        obj = ((bi) (obj)).a;
                    } else
                    {
                        obj = null;
                    }
                    if (obj == null)
                    {
                        continue;
                    }
                    k3 = view.getLeft();
                    l3 = view.getTop();
                    if (k3 != ((View) (obj)).getLeft() || l3 != ((View) (obj)).getTop())
                    {
                        ((View) (obj)).layout(k3, l3, ((View) (obj)).getWidth() + k3, ((View) (obj)).getHeight() + l3);
                    }
                    k2++;
                }
            }
            I = false;
            a(false);
            l2 = j2;
            j3 = l1;
            j2 = k1;
            l1 = l2;
            k1 = j3;
        } else
        {
            i2 = 0;
            k1 = 0;
            l1 = 0;
            j2 = 0;
        }
        if (!w.isEmpty())
        {
            invalidate();
        }
        if (ap.a(this) != 2)
        {
            b(i1, j1);
            if (j2 < 0)
            {
                b();
                g.a((float)(-j2) / (float)getWidth());
            } else
            if (j2 > 0)
            {
                c();
                i.a((float)j2 / (float)getWidth());
            }
            if (l1 < 0)
            {
                d();
                h.a((float)(-l1) / (float)getHeight());
            } else
            if (l1 > 0)
            {
                e();
                j.a((float)l1 / (float)getHeight());
            }
            if (j2 != 0 || l1 != 0)
            {
                ap.d(this);
            }
        }
        if (k1 != 0 || i2 != 0)
        {
            onScrollChanged(0, 0, 0, 0);
        }
        if (!awakenScrollBars())
        {
            invalidate();
        }
    }

    private void a(a a1)
    {
        int j1 = d.size();
        int i1 = 0;
        while (i1 < j1) 
        {
            View view = (View)d.get(i1);
            bi bi1 = b(view);
            at at1 = (at)m.b.remove(bi1);
            if (!m.i)
            {
                m.c.remove(bi1);
            }
            if (a1.remove(view) != null)
            {
                f.a(view, a);
            } else
            if (at1 != null)
            {
                a(at1);
            } else
            {
                a(new at(bi1, view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            }
            i1++;
        }
        d.clear();
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
        if (recyclerview.e != null)
        {
            b(view);
        }
    }

    static void a(RecyclerView recyclerview, View view, int i1, android.view.ViewGroup.LayoutParams layoutparams)
    {
        recyclerview.attachViewToParent(view, i1, layoutparams);
    }

    private void a(an an1, boolean flag, boolean flag1)
    {
        if (e != null)
        {
            an an2 = e;
            bb bb1 = q;
            an2.a.unregisterObserver(bb1);
        }
        if (!flag || flag1)
        {
            if (k != null)
            {
                k.d();
            }
            if (f != null)
            {
                f.c(a);
                f.b(a);
            }
        }
        b.a();
        an an3 = e;
        e = an1;
        if (an1 != null)
        {
            bb bb2 = q;
            an1.a.registerObserver(bb2);
        }
        Object obj = a;
        an1 = e;
        ((az) (obj)).a();
        obj = ((az) (obj)).b();
        if (an3 != null)
        {
            ((ay) (obj)).b();
        }
        if (!flag && ((ay) (obj)).b == 0)
        {
            ((ay) (obj)).a.clear();
        }
        if (an1 != null)
        {
            ((ay) (obj)).a();
        }
        m.h = true;
        s();
    }

    private void a(at at1)
    {
        View view = at1.a.a;
        a(at1.a);
        int i1 = at1.b;
        int j1 = at1.c;
        int k1 = view.getLeft();
        int l1 = view.getTop();
        if (i1 != k1 || j1 != l1)
        {
            at1.a.a(false);
            view.layout(k1, l1, view.getWidth() + k1, view.getHeight() + l1);
            if (k.a(at1.a, i1, j1, k1, l1))
            {
                p();
            }
            return;
        } else
        {
            at1.a.a(false);
            k.a(at1.a);
            p();
            return;
        }
    }

    private void a(bi bi1)
    {
        View view = bi1.a;
        boolean flag;
        if (view.getParent() == this)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(a(view));
        if (bi1.n())
        {
            c.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!flag)
        {
            c.a(view, -1, true);
            return;
        }
        bi1 = c;
        int i1 = ((d) (bi1)).a.a(view);
        if (i1 < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("view is not a child, cannot hide ")).append(view).toString());
        } else
        {
            ((d) (bi1)).b.a(i1);
            ((d) (bi1)).c.add(view);
            return;
        }
    }

    private void a(MotionEvent motionevent)
    {
        int i1 = android.support.v4.view.z.b(motionevent);
        if (android.support.v4.view.z.b(motionevent, i1) == K)
        {
            int j1;
            if (i1 == 0)
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            K = android.support.v4.view.z.b(motionevent, i1);
            j1 = (int)(android.support.v4.view.z.c(motionevent, i1) + 0.5F);
            O = j1;
            M = j1;
            i1 = (int)(android.support.v4.view.z.d(motionevent, i1) + 0.5F);
            P = i1;
            N = i1;
        }
    }

    static boolean a(RecyclerView recyclerview)
    {
        return recyclerview.B;
    }

    static boolean a(RecyclerView recyclerview, boolean flag)
    {
        recyclerview.I = flag;
        return flag;
    }

    private long b(bi bi1)
    {
        if (e.b)
        {
            return bi1.d;
        } else
        {
            return (long)bi1.b;
        }
    }

    static bi b(View view)
    {
        if (view == null)
        {
            return null;
        } else
        {
            return ((av)view.getLayoutParams()).c;
        }
    }

    private void b(int i1, int j1)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (g != null)
        {
            flag = flag1;
            if (!g.a())
            {
                flag = flag1;
                if (i1 > 0)
                {
                    flag = g.c();
                }
            }
        }
        flag1 = flag;
        if (i != null)
        {
            flag1 = flag;
            if (!i.a())
            {
                flag1 = flag;
                if (i1 < 0)
                {
                    flag1 = flag | i.c();
                }
            }
        }
        flag = flag1;
        if (h != null)
        {
            flag = flag1;
            if (!h.a())
            {
                flag = flag1;
                if (j1 > 0)
                {
                    flag = flag1 | h.c();
                }
            }
        }
        flag1 = flag;
        if (j != null)
        {
            flag1 = flag;
            if (!j.a())
            {
                flag1 = flag;
                if (j1 < 0)
                {
                    flag1 = flag | j.c();
                }
            }
        }
        if (flag1)
        {
            ap.d(this);
        }
    }

    static void b(RecyclerView recyclerview, int i1)
    {
        recyclerview.setScrollState(i1);
    }

    static void b(RecyclerView recyclerview, View view)
    {
        recyclerview.e(view);
    }

    static boolean b(RecyclerView recyclerview)
    {
        return recyclerview.H;
    }

    public static int c(View view)
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

    static void c(RecyclerView recyclerview, View view)
    {
        if (!recyclerview.d.contains(view))
        {
            recyclerview.d.add(view);
        }
    }

    static boolean c(RecyclerView recyclerview)
    {
        return recyclerview.D;
    }

    static void d(RecyclerView recyclerview, View view)
    {
        recyclerview.d.remove(view);
    }

    static boolean d(RecyclerView recyclerview)
    {
        recyclerview.V = false;
        return false;
    }

    static au e(RecyclerView recyclerview)
    {
        return recyclerview.f;
    }

    private void e(View view)
    {
        if (e != null)
        {
            b(view);
        }
    }

    static boolean e(RecyclerView recyclerview, View view)
    {
        boolean flag = true;
        recyclerview.a();
        d d1 = recyclerview.c;
        int i1 = d1.a.a(view);
        if (i1 == -1)
        {
            d1.c.remove(view);
        } else
        if (d1.b.b(i1))
        {
            d1.b.c(i1);
            d1.a.a(i1);
            d1.c.remove(view);
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

    static void f(RecyclerView recyclerview)
    {
        recyclerview.j();
    }

    static an g(RecyclerView recyclerview)
    {
        return recyclerview.e;
    }

    static Interpolator h()
    {
        return ab;
    }

    static boolean h(RecyclerView recyclerview)
    {
        return recyclerview.f();
    }

    static ArrayList i(RecyclerView recyclerview)
    {
        return recyclerview.w;
    }

    static boolean i()
    {
        return p;
    }

    private void j()
    {
        t.run();
    }

    static void j(RecyclerView recyclerview)
    {
        recyclerview.onScrollChanged(0, 0, 0, 0);
    }

    static ax k(RecyclerView recyclerview)
    {
        return recyclerview.T;
    }

    private void k()
    {
        setScrollState(0);
        l();
    }

    private void l()
    {
        bh bh1 = l;
        bh1.d.removeCallbacks(bh1);
        bh1.c.f();
        f.q();
    }

    static boolean l(RecyclerView recyclerview)
    {
        return recyclerview.awakenScrollBars();
    }

    private void m()
    {
        boolean flag1 = false;
        if (g != null)
        {
            flag1 = g.c();
        }
        boolean flag = flag1;
        if (h != null)
        {
            flag = flag1 | h.c();
        }
        flag1 = flag;
        if (i != null)
        {
            flag1 = flag | i.c();
        }
        flag = flag1;
        if (j != null)
        {
            flag = flag1 | j.c();
        }
        if (flag)
        {
            ap.d(this);
        }
    }

    static boolean m(RecyclerView recyclerview)
    {
        recyclerview.H = true;
        return true;
    }

    private void n()
    {
        j = null;
        h = null;
        i = null;
        g = null;
    }

    static boolean n(RecyclerView recyclerview)
    {
        return recyclerview.F;
    }

    private void o()
    {
        if (L != null)
        {
            L.clear();
        }
        m();
        setScrollState(0);
    }

    static boolean o(RecyclerView recyclerview)
    {
        return recyclerview.A;
    }

    private void p()
    {
        if (!V && z)
        {
            ap.a(this, aa);
            V = true;
        }
    }

    static boolean p(RecyclerView recyclerview)
    {
        return recyclerview.z;
    }

    static Runnable q(RecyclerView recyclerview)
    {
        return recyclerview.t;
    }

    private void q()
    {
        boolean flag;
        boolean flag1;
        boolean flag2 = true;
        if (H)
        {
            b.a();
            s();
            f.a();
        }
        bf bf1;
        if (k != null && f.c())
        {
            b.b();
        } else
        {
            b.e();
        }
        if (n && !o || n || o && f())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bf1 = m;
        if (B && k != null && (H || flag || android.support.v7.widget.au.a(f)) && (!H || e.b))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        bf1.j = flag1;
        bf1 = m;
        if (!m.j || !flag || H) goto _L2; else goto _L1
_L1:
        if (k != null && f.c())
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
        bf1.k = flag1;
        return;
_L2:
        flag1 = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void r()
    {
        boolean flag = false;
        int i2 = c.b();
        for (int i1 = 0; i1 < i2; i1++)
        {
            bi bi1 = b(c.c(i1));
            if (!bi1.b())
            {
                bi1.a();
            }
        }

        az az1 = a;
        i2 = az1.c.size();
        for (int j1 = 0; j1 < i2; j1++)
        {
            ((bi)az1.c.get(j1)).a();
        }

        i2 = az1.a.size();
        for (int k1 = 0; k1 < i2; k1++)
        {
            ((bi)az1.a.get(k1)).a();
        }

        if (az1.b != null)
        {
            int j2 = az1.b.size();
            for (int l1 = ((flag) ? 1 : 0); l1 < j2; l1++)
            {
                ((bi)az1.b.get(l1)).a();
            }

        }
    }

    static boolean r(RecyclerView recyclerview)
    {
        recyclerview.E = true;
        return true;
    }

    static AccessibilityManager s(RecyclerView recyclerview)
    {
        return recyclerview.G;
    }

    private void s()
    {
        boolean flag = false;
        int j2 = c.b();
        for (int i1 = 0; i1 < j2; i1++)
        {
            bi bi1 = b(c.c(i1));
            if (bi1 != null && !bi1.b())
            {
                bi1.a(6);
            }
        }

        j2 = c.b();
        for (int j1 = 0; j1 < j2; j1++)
        {
            ((av)c.c(j1).getLayoutParams()).e = true;
        }

        az az1 = a;
        j2 = az1.c.size();
        for (int k1 = 0; k1 < j2; k1++)
        {
            av av1 = (av)((bi)az1.c.get(k1)).a.getLayoutParams();
            if (av1 != null)
            {
                av1.e = true;
            }
        }

        az1 = a;
        if (az1.h.e != null && az1.h.e.b)
        {
            int k2 = az1.c.size();
            for (int l1 = ((flag) ? 1 : 0); l1 < k2; l1++)
            {
                bi bi2 = (bi)az1.c.get(l1);
                if (bi2 != null)
                {
                    bi2.a(6);
                }
            }

        } else
        {
            for (int i2 = az1.c.size() - 1; i2 >= 0; i2--)
            {
                if (!az1.c(i2))
                {
                    ((bi)az1.c.get(i2)).a(6);
                }
            }

        }
    }

    private void setScrollState(int i1)
    {
        if (i1 == J)
        {
            return;
        }
        J = i1;
        if (i1 != 2)
        {
            l();
        }
        if (T != null)
        {
            T.a(i1);
        }
        f.f(i1);
    }

    static bj t(RecyclerView recyclerview)
    {
        return recyclerview.W;
    }

    static ba u(RecyclerView recyclerview)
    {
        return recyclerview.v;
    }

    static boolean v(RecyclerView recyclerview)
    {
        return recyclerview.I;
    }

    static bh w(RecyclerView recyclerview)
    {
        return recyclerview.l;
    }

    public final bi a(View view)
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
        if (!C)
        {
            C = true;
            D = false;
        }
    }

    public final void a(int i1)
    {
        k();
        f.b(i1);
        awakenScrollBars();
    }

    final void a(int i1, int j1, boolean flag)
    {
        int l1 = c.b();
        int k1 = 0;
        while (k1 < l1) 
        {
            bi bi1 = b(c.c(k1));
            if (bi1 != null && !bi1.b())
            {
                if (bi1.b >= i1 + j1)
                {
                    bi1.a(-j1, flag);
                    m.h = true;
                } else
                if (bi1.b >= i1)
                {
                    int i2 = -j1;
                    bi1.a(8);
                    bi1.a(i2, flag);
                    bi1.b = i1 - 1;
                    m.h = true;
                }
            }
            k1++;
        }
        az az1 = a;
        k1 = az1.c.size() - 1;
        while (k1 >= 0) 
        {
            bi bi2 = (bi)az1.c.get(k1);
            if (bi2 != null)
            {
                if (bi2.c() >= i1 + j1)
                {
                    bi2.a(-j1, flag);
                } else
                if (bi2.c() >= i1 && !az1.c(k1))
                {
                    bi2.a(4);
                }
            }
            k1--;
        }
        requestLayout();
    }

    public final void a(an an1)
    {
        a(an1, true, false);
        H = true;
        requestLayout();
    }

    final void a(String s1)
    {
        if (I)
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
        if (C)
        {
            if (flag && D && f != null && e != null)
            {
                g();
            }
            C = false;
            D = false;
        }
    }

    public void addFocusables(ArrayList arraylist, int i1, int j1)
    {
        super.addFocusables(arraylist, i1, j1);
    }

    final void b()
    {
        if (g != null)
        {
            return;
        }
        g = new n(getContext());
        if (s)
        {
            g.a(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
            return;
        } else
        {
            g.a(getMeasuredHeight(), getMeasuredWidth());
            return;
        }
    }

    final void c()
    {
        if (i != null)
        {
            return;
        }
        i = new n(getContext());
        if (s)
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
        return (layoutparams instanceof av) && f.a((av)layoutparams);
    }

    protected int computeHorizontalScrollExtent()
    {
        if (f.e())
        {
            return f.c(m);
        } else
        {
            return 0;
        }
    }

    protected int computeHorizontalScrollOffset()
    {
        if (f.e())
        {
            return f.a(m);
        } else
        {
            return 0;
        }
    }

    protected int computeHorizontalScrollRange()
    {
        if (f.e())
        {
            return f.e(m);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollExtent()
    {
        if (f.f())
        {
            return f.d(m);
        } else
        {
            return 0;
        }
    }

    public int computeVerticalScrollOffset()
    {
        if (f.f())
        {
            return f.b(m);
        } else
        {
            return 0;
        }
    }

    protected int computeVerticalScrollRange()
    {
        if (f.f())
        {
            return f.f(m);
        } else
        {
            return 0;
        }
    }

    final Rect d(View view)
    {
        av av1 = (av)view.getLayoutParams();
        if (!av1.e)
        {
            return av1.d;
        }
        Rect rect = av1.d;
        rect.set(0, 0, 0, 0);
        int j1 = w.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            u.set(0, 0, 0, 0);
            w.get(i1);
            Rect rect1 = u;
            view.getLayoutParams();
            rect1.set(0, 0, 0, 0);
            rect.left = rect.left + u.left;
            rect.top = rect.top + u.top;
            rect.right = rect.right + u.right;
            rect.bottom = rect.bottom + u.bottom;
        }

        av1.e = false;
        return rect;
    }

    final void d()
    {
        if (h != null)
        {
            return;
        }
        h = new n(getContext());
        if (s)
        {
            h.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            h.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    public void draw(Canvas canvas)
    {
        boolean flag = true;
        boolean flag1 = false;
        super.draw(canvas);
        int k1 = w.size();
        for (int i1 = 0; i1 < k1; i1++)
        {
            w.get(i1);
        }

        int j1;
        if (g != null && !g.a())
        {
            int l1 = canvas.save();
            int i2;
            if (s)
            {
                j1 = getPaddingBottom();
            } else
            {
                j1 = 0;
            }
            canvas.rotate(270F);
            canvas.translate(j1 + -getHeight(), 0.0F);
            if (g != null && g.a(canvas))
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
        if (h != null)
        {
            j1 = k1;
            if (!h.a())
            {
                l1 = canvas.save();
                if (s)
                {
                    canvas.translate(getPaddingLeft(), getPaddingTop());
                }
                if (h != null && h.a(canvas))
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
        if (i != null)
        {
            k1 = j1;
            if (!i.a())
            {
                l1 = canvas.save();
                i2 = getWidth();
                if (s)
                {
                    k1 = getPaddingTop();
                } else
                {
                    k1 = 0;
                }
                canvas.rotate(90F);
                canvas.translate(-k1, -i2);
                if (i != null && i.a(canvas))
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
        if (j != null)
        {
            j1 = k1;
            if (!j.a())
            {
                l1 = canvas.save();
                canvas.rotate(180F);
                if (s)
                {
                    canvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
                } else
                {
                    canvas.translate(-getWidth(), -getHeight());
                }
                j1 = ((flag1) ? 1 : 0);
                if (j != null)
                {
                    j1 = ((flag1) ? 1 : 0);
                    if (j.a(canvas))
                    {
                        j1 = 1;
                    }
                }
                j1 = k1 | j1;
                canvas.restoreToCount(l1);
            }
        }
        if (j1 == 0 && k != null && w.size() > 0 && k.b())
        {
            j1 = ((flag) ? 1 : 0);
        }
        if (j1 != 0)
        {
            ap.d(this);
        }
    }

    final void e()
    {
        if (j != null)
        {
            return;
        }
        j = new n(getContext());
        if (s)
        {
            j.a(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
            return;
        } else
        {
            j.a(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
    }

    final boolean f()
    {
        return k != null && k.m;
    }

    public View focusSearch(View view, int i1)
    {
        View view2 = FocusFinder.getInstance().findNextFocus(this, view, i1);
        View view1 = view2;
        if (view2 == null)
        {
            view1 = view2;
            if (e != null)
            {
                a();
                view1 = f.c(i1, a, m);
                a(false);
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

    final void g()
    {
        if (e == null)
        {
            Log.e("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        d.clear();
        a();
        I = true;
        q();
        bf bf2 = m;
        Object obj;
        if (m.j && o && f())
        {
            obj = new a();
        } else
        {
            obj = null;
        }
        bf2.d = ((a) (obj));
        o = false;
        n = false;
        m.i = m.k;
        m.e = e.a();
        if (m.j)
        {
            m.b.clear();
            m.c.clear();
            int l2 = c.a();
            for (int i1 = 0; i1 < l2; i1++)
            {
                obj = b(c.b(i1));
                if (!((bi) (obj)).b() && (!((bi) (obj)).i() || e.b))
                {
                    View view1 = ((bi) (obj)).a;
                    m.b.put(obj, new at(((bi) (obj)), view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom()));
                }
            }

        }
        if (!m.k) goto _L2; else goto _L1
_L1:
        Object obj2;
        int l1;
        int i3 = c.b();
        for (int j1 = 0; j1 < i3; j1++)
        {
            bi bi1 = b(c.c(j1));
            if (!bi1.b() && bi1.c == -1)
            {
                bi1.c = bi1.b;
            }
        }

        if (m.d != null)
        {
            int j3 = c.a();
            for (int k1 = 0; k1 < j3; k1++)
            {
                bi bi2 = b(c.b(k1));
                if (bi2.k() && !bi2.m() && !bi2.b())
                {
                    long l4 = b(bi2);
                    m.d.put(Long.valueOf(l4), bi2);
                    m.b.remove(bi2);
                }
            }

        }
        boolean flag = m.h;
        m.h = false;
        f.c(a, m);
        m.h = flag;
        obj2 = new a();
        l1 = 0;
_L9:
        if (l1 >= c.a()) goto _L4; else goto _L3
_L3:
        View view = c.b(l1);
        if (b(view).b()) goto _L6; else goto _L5
_L5:
        int k3 = 0;
_L10:
        if (k3 >= m.b.size())
        {
            break MISSING_BLOCK_LABEL_1844;
        }
        if (((bi)m.b.b(k3)).a != view) goto _L8; else goto _L7
_L7:
        k3 = 1;
_L11:
        if (k3 == 0)
        {
            ((a) (obj2)).put(view, new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        }
_L6:
        l1++;
          goto _L9
_L8:
        k3++;
          goto _L10
_L4:
        r();
        b.c();
        break MISSING_BLOCK_LABEL_633;
_L2:
        r();
        b.e();
        Object obj3;
        Object obj4;
        at at1;
        int k2;
        int l3;
        int i4;
        int j4;
        long l7;
        if (m.d != null)
        {
            k3 = c.a();
            for (int j2 = 0; j2 < k3; j2++)
            {
                obj1 = b(c.b(j2));
                if (((bi) (obj1)).k() && !((bi) (obj1)).m() && !((bi) (obj1)).b())
                {
                    long l6 = b(((bi) (obj1)));
                    m.d.put(Long.valueOf(l6), obj1);
                    m.b.remove(obj1);
                }
            }

        }
        obj2 = null;
        continue;
        do
        {
            m.e = e.a();
            m.g = 0;
            m.i = false;
            f.c(a, m);
            m.h = false;
            r = null;
            bf bf1 = m;
            boolean flag1;
            if (m.j && k != null)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            bf1.j = flag1;
            if (m.j)
            {
                Object obj1;
                int i2;
                if (m.d != null)
                {
                    obj1 = new a();
                } else
                {
                    obj1 = null;
                }
                k3 = c.a();
                i2 = 0;
                while (i2 < k3) 
                {
                    bi bi3 = b(c.b(i2));
                    if (!bi3.b())
                    {
                        View view2 = bi3.a;
                        long l5 = b(bi3);
                        if (obj1 != null && m.d.get(Long.valueOf(l5)) != null)
                        {
                            ((a) (obj1)).put(Long.valueOf(l5), bi3);
                        } else
                        {
                            m.c.put(bi3, new at(bi3, view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom()));
                        }
                    }
                    i2++;
                }
                a(((a) (obj2)));
                for (k2 = m.b.size() - 1; k2 >= 0; k2--)
                {
                    obj3 = (bi)m.b.b(k2);
                    if (!m.c.containsKey(obj3))
                    {
                        obj3 = (at)m.b.c(k2);
                        m.b.d(k2);
                        a.b(((at) (obj3)).a);
                        a(((at) (obj3)));
                    }
                }

                k2 = m.c.size();
                if (k2 > 0)
                {
                    k2--;
                    while (k2 >= 0) 
                    {
                        obj4 = (bi)m.c.b(k2);
                        at1 = (at)m.c.c(k2);
                        if (m.b.isEmpty() || !m.b.containsKey(obj4))
                        {
                            m.c.d(k2);
                            if (obj2 != null)
                            {
                                obj3 = (Rect)((a) (obj2)).get(((bi) (obj4)).a);
                            } else
                            {
                                obj3 = null;
                            }
                            k3 = at1.b;
                            l3 = at1.c;
                            if (obj3 != null && (((Rect) (obj3)).left != k3 || ((Rect) (obj3)).top != l3))
                            {
                                ((bi) (obj4)).a(false);
                                if (k.a(((bi) (obj4)), ((Rect) (obj3)).left, ((Rect) (obj3)).top, k3, l3))
                                {
                                    p();
                                }
                            } else
                            {
                                ((bi) (obj4)).a(false);
                                k.b(((bi) (obj4)));
                                p();
                            }
                        }
                        k2--;
                    }
                }
                k3 = m.c.size();
                for (k2 = 0; k2 < k3; k2++)
                {
                    obj2 = (bi)m.c.b(k2);
                    obj3 = (at)m.c.c(k2);
                    obj4 = (at)m.b.get(obj2);
                    if (obj4 == null || obj3 == null || ((at) (obj4)).b == ((at) (obj3)).b && ((at) (obj4)).c == ((at) (obj3)).c)
                    {
                        continue;
                    }
                    ((bi) (obj2)).a(false);
                    if (k.a(((bi) (obj2)), ((at) (obj4)).b, ((at) (obj4)).c, ((at) (obj3)).b, ((at) (obj3)).c))
                    {
                        p();
                    }
                }

                if (m.d != null)
                {
                    k2 = m.d.size();
                } else
                {
                    k2 = 0;
                }
                k2--;
                while (k2 >= 0) 
                {
                    l7 = ((Long)m.d.b(k2)).longValue();
                    obj2 = (bi)m.d.get(Long.valueOf(l7));
                    if (!((bi) (obj2)).b() && a.b != null && a.b.contains(obj2))
                    {
                        obj3 = (bi)((a) (obj1)).get(Long.valueOf(l7));
                        ((bi) (obj2)).a(false);
                        a(((bi) (obj2)));
                        obj2.g = ((bi) (obj3));
                        a.b(((bi) (obj2)));
                        i4 = ((bi) (obj2)).a.getLeft();
                        j4 = ((bi) (obj2)).a.getTop();
                        if (obj3 == null || ((bi) (obj3)).b())
                        {
                            l3 = j4;
                            k3 = i4;
                        } else
                        {
                            k3 = ((bi) (obj3)).a.getLeft();
                            l3 = ((bi) (obj3)).a.getTop();
                            ((bi) (obj3)).a(false);
                            obj3.h = ((bi) (obj2));
                        }
                        k.a(((bi) (obj2)), ((bi) (obj3)), i4, j4, k3, l3);
                        p();
                    }
                    k2--;
                }
            }
            a(false);
            f.b(a);
            m.f = m.e;
            H = false;
            m.j = false;
            m.k = false;
            I = false;
            au.b(f);
            if (a.b != null)
            {
                a.b.clear();
            }
            m.d = null;
            return;
        } while (true);
        k3 = 0;
          goto _L11
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams()
    {
        if (f == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return f.b();
        }
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeset)
    {
        if (f == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return f.a(getContext(), attributeset);
        }
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (f == null)
        {
            throw new IllegalStateException("RecyclerView has no LayoutManager");
        } else
        {
            return f.a(layoutparams);
        }
    }

    public an getAdapter()
    {
        return e;
    }

    public bj getCompatAccessibilityDelegate()
    {
        return W;
    }

    public aq getItemAnimator()
    {
        return k;
    }

    public au getLayoutManager()
    {
        return f;
    }

    public ay getRecycledViewPool()
    {
        return a.b();
    }

    public int getScrollState()
    {
        return J;
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        z = true;
        B = false;
        V = false;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        if (k != null)
        {
            k.d();
        }
        B = false;
        k();
        z = false;
        if (f != null)
        {
            f.a(this, a);
        }
        removeCallbacks(aa);
    }

    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        int j1 = w.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            w.get(i1);
        }

    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int k1;
        byte byte0;
        int k2;
        byte0 = -1;
        k1 = motionevent.getAction();
        if (k1 == 3 || k1 == 0)
        {
            y = null;
        }
        k2 = x.size();
        i1 = 0;
_L7:
        if (i1 >= k2) goto _L2; else goto _L1
_L1:
        aw aw1 = (aw)x.get(i1);
        if (!aw1.a() || k1 == 3) goto _L4; else goto _L3
_L3:
        y = aw1;
        i1 = 1;
_L8:
        if (i1 == 0) goto _L6; else goto _L5
_L5:
        o();
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
        flag = f.e();
        flag1 = f.f();
        if (L == null)
        {
            L = VelocityTracker.obtain();
        }
        L.addMovement(motionevent);
        k1 = android.support.v4.view.z.a(motionevent);
        i1 = android.support.v4.view.z.b(motionevent);
        k1;
        JVM INSTR tableswitch 0 6: default 192
    //                   0 202
    //                   1 578
    //                   2 334
    //                   3 588
    //                   4 192
    //                   5 277
    //                   6 570;
           goto _L9 _L10 _L11 _L12 _L13 _L9 _L14 _L15
_L9:
        break; /* Loop/switch isn't completed */
_L13:
        break MISSING_BLOCK_LABEL_588;
_L17:
        if (J != 1)
        {
            return false;
        }
          goto _L16
_L10:
        K = android.support.v4.view.z.b(motionevent, 0);
        i1 = (int)(motionevent.getX() + 0.5F);
        O = i1;
        M = i1;
        i1 = (int)(motionevent.getY() + 0.5F);
        P = i1;
        N = i1;
        if (J == 2)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
            setScrollState(1);
        }
          goto _L17
_L14:
        K = android.support.v4.view.z.b(motionevent, i1);
        int l1 = (int)(android.support.v4.view.z.c(motionevent, i1) + 0.5F);
        O = l1;
        M = l1;
        i1 = (int)(android.support.v4.view.z.d(motionevent, i1) + 0.5F);
        P = i1;
        N = i1;
          goto _L17
_L12:
        int i2 = android.support.v4.view.z.a(motionevent, K);
        if (i2 < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(K).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        int j1 = (int)(android.support.v4.view.z.c(motionevent, i2) + 0.5F);
        i2 = (int)(android.support.v4.view.z.d(motionevent, i2) + 0.5F);
        if (J != 1)
        {
            j1 -= M;
            int l2 = i2 - N;
            if (flag && Math.abs(j1) > Q)
            {
                int j2 = M;
                int i3 = Q;
                if (j1 < 0)
                {
                    j1 = -1;
                } else
                {
                    j1 = 1;
                }
                O = j1 * i3 + j2;
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            j2 = j1;
            if (flag1)
            {
                j2 = j1;
                if (Math.abs(l2) > Q)
                {
                    j2 = N;
                    i3 = Q;
                    if (l2 < 0)
                    {
                        j1 = byte0;
                    } else
                    {
                        j1 = 1;
                    }
                    P = j2 + j1 * i3;
                    j2 = 1;
                }
            }
            if (j2 != 0)
            {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        }
          goto _L17
_L15:
        a(motionevent);
          goto _L17
_L11:
        L.clear();
          goto _L17
        o();
          goto _L17
    }

    public void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        a();
        g();
        a(false);
        B = true;
    }

    protected void onMeasure(int i1, int j1)
    {
        if (E)
        {
            a();
            q();
            au au1;
            int k1;
            int l1;
            if (m.k)
            {
                m.i = true;
            } else
            {
                b.e();
                m.i = false;
            }
            E = false;
            a(false);
        }
        if (e != null)
        {
            m.e = e.a();
        } else
        {
            m.e = 0;
        }
        au1 = f;
        l1 = android.view.View.MeasureSpec.getMode(i1);
        k1 = android.view.View.MeasureSpec.getMode(j1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        switch (l1)
        {
        default:
            i1 = ap.m(au1.q);
            // fall through

        case -2147483648: 
        case 1073741824: 
            switch (k1)
            {
            default:
                j1 = ap.n(au1.q);
                // fall through

            case -2147483648: 
            case 1073741824: 
                au1.q.setMeasuredDimension(i1, j1);
                break;
            }
            break;
        }
        m.i = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable)
    {
        r = (SavedState)parcelable;
        super.onRestoreInstanceState(r.getSuperState());
        if (f != null && r.a != null)
        {
            f.a(r.a);
        }
    }

    protected Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        if (r != null)
        {
            android.support.v7.widget.SavedState.a(savedstate, r);
            return savedstate;
        }
        if (f != null)
        {
            savedstate.a = f.d();
            return savedstate;
        } else
        {
            savedstate.a = null;
            return savedstate;
        }
    }

    public void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 != k1 || j1 != l1)
        {
            n();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int k2;
        k2 = -1;
        i1 = motionevent.getAction();
        if (y == null) goto _L2; else goto _L1
_L1:
        if (i1 != 0) goto _L4; else goto _L3
_L3:
        y = null;
_L2:
        if (i1 == 0) goto _L6; else goto _L5
_L5:
        int l1;
        l1 = x.size();
        i1 = 0;
_L23:
        if (i1 >= l1) goto _L6; else goto _L7
_L7:
        aw aw1 = (aw)x.get(i1);
        if (!aw1.a()) goto _L9; else goto _L8
_L8:
        y = aw1;
        i1 = 1;
_L11:
        if (i1 != 0)
        {
            o();
            return true;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (i1 == 3 || i1 == 1)
        {
            y = null;
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
        flag = f.e();
        flag1 = f.f();
        if (L == null)
        {
            L = VelocityTracker.obtain();
        }
        L.addMovement(motionevent);
        l1 = android.support.v4.view.z.a(motionevent);
        i1 = android.support.v4.view.z.b(motionevent);
        l1;
        JVM INSTR tableswitch 0 6: default 228
    //                   0 230
    //                   1 683
    //                   2 349
    //                   3 934
    //                   4 228
    //                   5 287
    //                   6 676;
           goto _L12 _L13 _L14 _L15 _L16 _L12 _L17 _L18
_L12:
        return true;
_L13:
        K = android.support.v4.view.z.b(motionevent, 0);
        i1 = (int)(motionevent.getX() + 0.5F);
        O = i1;
        M = i1;
        i1 = (int)(motionevent.getY() + 0.5F);
        P = i1;
        N = i1;
        return true;
_L17:
        K = android.support.v4.view.z.b(motionevent, i1);
        int i2 = (int)(android.support.v4.view.z.c(motionevent, i1) + 0.5F);
        O = i2;
        M = i2;
        i1 = (int)(android.support.v4.view.z.d(motionevent, i1) + 0.5F);
        P = i1;
        N = i1;
        return true;
_L15:
        int j1 = android.support.v4.view.z.a(motionevent, K);
        if (j1 < 0)
        {
            Log.e("RecyclerView", (new StringBuilder("Error processing scroll; pointer index for id ")).append(K).append(" not found. Did any MotionEvents get skipped?").toString());
            return false;
        }
        int l2 = (int)(android.support.v4.view.z.c(motionevent, j1) + 0.5F);
        int i3 = (int)(android.support.v4.view.z.d(motionevent, j1) + 0.5F);
        if (J != 1)
        {
            int k1 = l2 - M;
            int j3 = i3 - N;
            float f1;
            float f2;
            s s1;
            int j2;
            if (flag && Math.abs(k1) > Q)
            {
                j2 = M;
                int k3 = Q;
                if (k1 < 0)
                {
                    k1 = -1;
                } else
                {
                    k1 = 1;
                }
                O = k1 * k3 + j2;
                k1 = 1;
            } else
            {
                k1 = 0;
            }
            j2 = k1;
            if (flag1)
            {
                j2 = k1;
                if (Math.abs(j3) > Q)
                {
                    j2 = N;
                    k3 = Q;
                    if (j3 < 0)
                    {
                        k1 = k2;
                    } else
                    {
                        k1 = 1;
                    }
                    P = j2 + k1 * k3;
                    j2 = 1;
                }
            }
            if (j2 != 0)
            {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        }
        if (J == 1)
        {
            k1 = O;
            j2 = P;
            if (flag)
            {
                k1 = -(l2 - k1);
            } else
            {
                k1 = 0;
            }
            if (flag1)
            {
                j2 = -(i3 - j2);
            } else
            {
                j2 = 0;
            }
            a(k1, j2);
        }
        O = l2;
        P = i3;
        return true;
_L18:
        a(motionevent);
        return true;
_L14:
        L.computeCurrentVelocity(1000, S);
        if (flag)
        {
            f1 = -ak.a(L, K);
        } else
        {
            f1 = 0.0F;
        }
        if (flag1)
        {
            f2 = -ak.b(L, K);
        } else
        {
            f2 = 0.0F;
        }
        if (f1 == 0.0F && f2 == 0.0F) goto _L20; else goto _L19
_L19:
        j2 = (int)f1;
        k2 = (int)f2;
        k1 = j2;
        if (Math.abs(j2) < R)
        {
            k1 = 0;
        }
        j2 = k2;
        if (Math.abs(k2) < R)
        {
            j2 = 0;
        }
        k1 = Math.max(-S, Math.min(k1, S));
        j2 = Math.max(-S, Math.min(j2, S));
        if (k1 != 0 || j2 != 0)
        {
            motionevent = l;
            ((bh) (motionevent)).d.setScrollState(2);
            motionevent.b = 0;
            motionevent.a = 0;
            s1 = ((bh) (motionevent)).c;
            s1.b.a(s1.a, k1, j2);
            motionevent.a();
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (k1 != 0) goto _L21; else goto _L20
_L20:
        setScrollState(0);
_L21:
        L.clear();
        m();
        return true;
_L16:
        o();
        return true;
        if (true) goto _L23; else goto _L22
_L22:
    }

    protected void removeDetachedView(View view, boolean flag)
    {
        bi bi1 = b(view);
        if (bi1 != null)
        {
            if (bi1.n())
            {
                bi1.h();
            } else
            if (!bi1.b())
            {
                throw new IllegalArgumentException((new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.")).append(bi1).toString());
            }
        }
        e(view);
        super.removeDetachedView(view, flag);
    }

    public void requestChildFocus(View view, View view1)
    {
        boolean flag = false;
        if (!f.a(this, m, view, view1) && view1 != null)
        {
            u.set(0, 0, view1.getWidth(), view1.getHeight());
            offsetDescendantRectToMyCoords(view1, u);
            offsetRectIntoDescendantCoords(view, u);
            Rect rect = u;
            if (!B)
            {
                flag = true;
            }
            requestChildRectangleOnScreen(view, rect, flag);
        }
        super.requestChildFocus(view, view1);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean flag)
    {
        au au1 = f;
        int j1 = au1.m();
        int l1 = au1.n();
        int k1 = au1.k();
        int l2 = au1.o();
        int i1 = au1.l();
        int i2 = au1.p();
        int i3 = view.getLeft() + rect.left;
        int j2 = view.getTop() + rect.top;
        int j3 = rect.width();
        int k2 = rect.height();
        j1 = Math.min(0, i3 - j1);
        l1 = Math.min(0, j2 - l1);
        k1 = Math.max(0, (j3 + i3) - (k1 - l2));
        i2 = Math.max(0, (k2 + j2) - (i1 - i2));
        if (ap.h(this) == 1)
        {
            if (k1 != 0)
            {
                i1 = k1;
            } else
            {
                i1 = j1;
            }
        } else
        {
            i1 = j1;
            if (j1 == 0)
            {
                i1 = k1;
            }
        }
        if (l1 != 0)
        {
            j1 = l1;
        } else
        {
            j1 = i2;
        }
        if (i1 != 0 || j1 != 0)
        {
            if (flag)
            {
                scrollBy(i1, j1);
            } else
            if (i1 != 0 || j1 != 0)
            {
                l.a(i1, j1);
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void requestLayout()
    {
        if (!C)
        {
            super.requestLayout();
            return;
        } else
        {
            D = true;
            return;
        }
    }

    public void scrollBy(int i1, int j1)
    {
        if (f == null)
        {
            throw new IllegalStateException("Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        }
        boolean flag = f.e();
        boolean flag1 = f.f();
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
            a(i1, j1);
        }
    }

    public void scrollTo(int i1, int j1)
    {
        throw new UnsupportedOperationException("RecyclerView does not support scrolling to an absolute position.");
    }

    public void setAccessibilityDelegateCompat(bj bj1)
    {
        W = bj1;
        ap.a(this, W);
    }

    public void setAdapter(an an1)
    {
        a(an1, false, true);
        requestLayout();
    }

    public void setClipToPadding(boolean flag)
    {
        if (flag != s)
        {
            n();
        }
        s = flag;
        super.setClipToPadding(flag);
        if (B)
        {
            requestLayout();
        }
    }

    public void setHasFixedSize(boolean flag)
    {
        A = flag;
    }

    public void setItemAnimator(aq aq1)
    {
        if (k != null)
        {
            k.d();
            k.h = null;
        }
        k = aq1;
        if (k != null)
        {
            k.h = U;
        }
    }

    public void setItemViewCacheSize(int i1)
    {
        az az1 = a;
        az1.e = i1;
        for (int j1 = az1.c.size() - 1; j1 >= 0 && az1.c.size() > i1; j1--)
        {
            az1.c(j1);
        }

        for (; az1.c.size() > i1; az1.c.remove(az1.c.size() - 1)) { }
    }

    public void setLayoutManager(au au1)
    {
        if (au1 == f)
        {
            return;
        }
        if (f != null)
        {
            if (z)
            {
                f.a(this, a);
            }
            f.a(null);
        }
        a.a();
        d d1 = c;
        d1.a.b();
        e e1 = d1.b;
        do
        {
            e1.a = 0L;
            if (e1.b == null)
            {
                break;
            }
            e1 = e1.b;
        } while (true);
        d1.c.clear();
        f = au1;
        if (au1 != null)
        {
            if (au1.q != null)
            {
                throw new IllegalArgumentException((new StringBuilder("LayoutManager ")).append(au1).append(" is already attached to a RecyclerView: ").append(au1.q).toString());
            }
            f.a(this);
        }
        requestLayout();
    }

    public void setOnScrollListener(ax ax1)
    {
        T = ax1;
    }

    public void setRecycledViewPool(ay ay1)
    {
        az az1 = a;
        if (az1.f != null)
        {
            az1.f.b();
        }
        az1.f = ay1;
        if (ay1 != null)
        {
            ay1 = az1.f;
            az1.h.getAdapter();
            ay1.a();
        }
    }

    public void setRecyclerListener(ba ba)
    {
        v = ba;
    }

    public void setScrollingTouchSlop(int i1)
    {
        ViewConfiguration viewconfiguration = ViewConfiguration.get(getContext());
        switch (i1)
        {
        default:
            Log.w("RecyclerView", (new StringBuilder("setScrollingTouchSlop(): bad argument constant ")).append(i1).append("; using default value").toString());
            // fall through

        case 0: // '\0'
            Q = viewconfiguration.getScaledTouchSlop();
            return;

        case 1: // '\001'
            Q = bg.a(viewconfiguration);
            break;
        }
    }

    public void setViewCacheExtension(android.support.v7.widget.bg bg1)
    {
        a.g = bg1;
    }

    static 
    {
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT == 19 || android.os.Build.VERSION.SDK_INT == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
    }

    private class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new bc();
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
            a = parcel.readParcelable(android/support/v7/widget/au.getClassLoader());
        }

        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }

}
