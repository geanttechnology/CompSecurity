// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.ag;
import android.support.v4.view.a.e;
import android.support.v4.view.a.n;
import android.support.v4.view.ap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            av, bi, d, f, 
//            e, RecyclerView, an, bf, 
//            az, bd, bh

public abstract class au
{

    d p;
    RecyclerView q;
    bd r;
    boolean s;

    public au()
    {
        s = false;
    }

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
        return ((av)view.getLayoutParams()).c.c();
    }

    static void a(au au1, bd bd1)
    {
        if (au1.r == bd1)
        {
            au1.r = null;
        }
    }

    public static void a(View view, int i1, int j1, int k1, int l1)
    {
        Rect rect = ((av)view.getLayoutParams()).d;
        view.layout(rect.left + i1, rect.top + j1, k1 - rect.right, l1 - rect.bottom);
    }

    static boolean a(au au1)
    {
        return au1.s;
    }

    public static int b(View view)
    {
        Rect rect = ((av)view.getLayoutParams()).d;
        int i1 = view.getMeasuredWidth();
        int j1 = rect.left;
        return rect.right + (i1 + j1);
    }

    static boolean b(au au1)
    {
        au1.s = false;
        return false;
    }

    public static int c(View view)
    {
        Rect rect = ((av)view.getLayoutParams()).d;
        int i1 = view.getMeasuredHeight();
        int j1 = rect.top;
        return rect.bottom + (i1 + j1);
    }

    public static int d(View view)
    {
        return view.getLeft() - ((av)view.getLayoutParams()).d.left;
    }

    public static int e(View view)
    {
        return view.getTop() - ((av)view.getLayoutParams()).d.top;
    }

    public static int f(View view)
    {
        int i1 = view.getRight();
        return ((av)view.getLayoutParams()).d.right + i1;
    }

    public static int g(View view)
    {
        int i1 = view.getBottom();
        return ((av)view.getLayoutParams()).d.bottom + i1;
    }

    private void g(int i1)
    {
        if (c(i1) != null)
        {
            d d1 = p;
            i1 = d1.a(i1);
            View view = d1.a.b(i1);
            if (view != null)
            {
                d1.a.a(i1);
                if (d1.b.c(i1))
                {
                    d1.c.remove(view);
                }
            }
        }
    }

    private void h(int i1)
    {
        c(i1);
        d d1 = p;
        i1 = d1.a(i1);
        d1.a.c(i1);
        d1.b.c(i1);
    }

    public int a(int i1, az az1, bf bf1)
    {
        return 0;
    }

    public int a(az az1, bf bf1)
    {
        while (q == null || RecyclerView.g(q) == null || !f()) 
        {
            return 1;
        }
        return RecyclerView.g(q).a();
    }

    public int a(bf bf1)
    {
        return 0;
    }

    public av a(Context context, AttributeSet attributeset)
    {
        return new av(context, attributeset);
    }

    public av a(android.view.ViewGroup.LayoutParams layoutparams)
    {
        if (layoutparams instanceof av)
        {
            return new av((av)layoutparams);
        }
        if (layoutparams instanceof android.view.ViewGroup.MarginLayoutParams)
        {
            return new av((android.view.ViewGroup.MarginLayoutParams)layoutparams);
        } else
        {
            return new av(layoutparams);
        }
    }

    public View a(int i1)
    {
        int k1 = j();
        for (int j1 = 0; j1 < k1; j1++)
        {
            View view = c(j1);
            bi bi1 = RecyclerView.b(view);
            if (bi1 != null && bi1.c() == i1 && !bi1.b() && (q.m.i || !bi1.m()))
            {
                return view;
            }
        }

        return null;
    }

    public void a()
    {
    }

    public void a(int i1, int j1)
    {
    }

    public final void a(int i1, az az1)
    {
        View view = c(i1);
        g(i1);
        az1.a(view);
    }

    public void a(Parcelable parcelable)
    {
    }

    final void a(RecyclerView recyclerview)
    {
        if (recyclerview == null)
        {
            q = null;
            p = null;
            return;
        } else
        {
            q = recyclerview;
            p = recyclerview.c;
            return;
        }
    }

    public void a(RecyclerView recyclerview, int i1)
    {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void a(RecyclerView recyclerview, az az1)
    {
    }

    public final void a(az az1)
    {
        int i1 = j() - 1;
        while (i1 >= 0) 
        {
            Object obj = c(i1);
            bi bi1 = RecyclerView.b(((View) (obj)));
            if (!bi1.b())
            {
                if (bi1.i() && !bi1.m() && !bi1.k() && !RecyclerView.g(q).b)
                {
                    g(i1);
                    az1.a(bi1);
                } else
                {
                    h(i1);
                    obj = RecyclerView.b(((View) (obj)));
                    obj.j = az1;
                    if (!((bi) (obj)).k() || !RecyclerView.h(az1.h))
                    {
                        if (((bi) (obj)).i() && !((bi) (obj)).m() && !RecyclerView.g(az1.h).b)
                        {
                            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                        }
                        az1.a.add(obj);
                    } else
                    {
                        if (az1.b == null)
                        {
                            az1.b = new ArrayList();
                        }
                        az1.b.add(obj);
                    }
                }
            }
            i1--;
        }
    }

    public void a(az az1, bf bf1, View view, e e1)
    {
        int i1;
        int j1;
        if (f())
        {
            i1 = a(view);
        } else
        {
            i1 = 0;
        }
        if (e())
        {
            j1 = a(view);
        } else
        {
            j1 = 0;
        }
        e1.a(android.support.v4.view.a.n.a(i1, 1, j1, 1, false));
    }

    public final void a(bd bd1)
    {
        if (r != null && bd1 != r && r.k)
        {
            r.b();
        }
        r = bd1;
        bd1 = r;
        bd1.h = q;
        bd1.i = this;
        if (bd1.g == -1)
        {
            throw new IllegalArgumentException("Invalid target position");
        } else
        {
            bd1.h.m.a = bd1.g;
            bd1.k = true;
            bd1.j = true;
            int i1 = bd1.g;
            bd1.l = android.support.v7.widget.RecyclerView.e(bd1.h).a(i1);
            RecyclerView.w(bd1.h).a();
            return;
        }
    }

    final void a(View view, int i1, boolean flag)
    {
        bi bi1;
        av av1;
        bi1 = RecyclerView.b(view);
        if (flag || bi1.m())
        {
            RecyclerView.c(q, view);
        } else
        {
            RecyclerView.d(q, view);
        }
        av1 = (av)view.getLayoutParams();
        if (!bi1.f() && !bi1.d()) goto _L2; else goto _L1
_L1:
        if (bi1.d())
        {
            bi1.e();
        } else
        {
            bi1.g();
        }
        p.a(view, i1, view.getLayoutParams(), false);
_L4:
        if (av1.f)
        {
            bi1.a.invalidate();
            av1.f = false;
        }
        return;
_L2:
        if (view.getParent() == q)
        {
            d d1 = p;
            int j1 = d1.a.a(view);
            int k1;
            if (j1 == -1)
            {
                j1 = -1;
            } else
            if (d1.b.b(j1))
            {
                j1 = -1;
            } else
            {
                j1 -= d1.b.d(j1);
            }
            k1 = i1;
            if (i1 == -1)
            {
                k1 = p.a();
            }
            if (j1 == -1)
            {
                throw new IllegalStateException((new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:")).append(q.indexOfChild(view)).toString());
            }
            if (j1 != k1)
            {
                view = android.support.v7.widget.RecyclerView.e(q);
                View view1 = view.c(j1);
                if (view1 == null)
                {
                    throw new IllegalArgumentException((new StringBuilder("Cannot move a child from non-existing index:")).append(j1).toString());
                }
                view.h(j1);
                av av2 = (av)view1.getLayoutParams();
                bi bi2 = RecyclerView.b(view1);
                if (bi2.m())
                {
                    RecyclerView.c(((au) (view)).q, view1);
                } else
                {
                    RecyclerView.d(((au) (view)).q, view1);
                }
                ((au) (view)).p.a(view1, k1, av2, bi2.m());
            }
        } else
        {
            p.a(view, i1, false);
            av1.e = true;
            if (r != null && r.k)
            {
                bd bd1 = r;
                if (RecyclerView.c(view) == bd1.g)
                {
                    bd1.l = view;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void a(View view, e e1)
    {
        bi bi1 = RecyclerView.b(view);
        if (bi1 != null && !bi1.m())
        {
            a(q.a, q.m, view, e1);
        }
    }

    public final void a(View view, az az1)
    {
        d d1 = p;
        int i1 = d1.a.a(view);
        if (i1 >= 0)
        {
            d1.a.a(i1);
            if (d1.b.c(i1))
            {
                d1.c.remove(view);
            }
        }
        az1.a(view);
    }

    public void a(AccessibilityEvent accessibilityevent)
    {
        boolean flag1 = true;
        Object obj = q.a;
        obj = q.m;
        accessibilityevent = android.support.v4.view.a.a.a(accessibilityevent);
        if (q != null)
        {
            boolean flag = flag1;
            if (!ap.b(q, 1))
            {
                flag = flag1;
                if (!ap.b(q, -1))
                {
                    flag = flag1;
                    if (!ap.a(q, -1))
                    {
                        if (ap.a(q, 1))
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
            if (RecyclerView.g(q) != null)
            {
                accessibilityevent.a(RecyclerView.g(q).a());
                return;
            }
        }
    }

    public void a(String s1)
    {
        if (q != null)
        {
            q.a(s1);
        }
    }

    public boolean a(RecyclerView recyclerview, bf bf1, View view, View view1)
    {
        return i() || RecyclerView.v(recyclerview);
    }

    public boolean a(av av1)
    {
        return av1 != null;
    }

    public int b(int i1, az az1, bf bf1)
    {
        return 0;
    }

    public int b(az az1, bf bf1)
    {
        while (q == null || RecyclerView.g(q) == null || !e()) 
        {
            return 1;
        }
        return RecyclerView.g(q).a();
    }

    public int b(bf bf1)
    {
        return 0;
    }

    public abstract av b();

    public void b(int i1)
    {
    }

    public void b(int i1, int j1)
    {
    }

    final void b(az az1)
    {
        int j1 = az1.a.size();
        for (int i1 = 0; i1 < j1; i1++)
        {
            View view = ((bi)az1.a.get(i1)).a;
            bi bi1 = RecyclerView.b(view);
            if (bi1.b())
            {
                continue;
            }
            if (bi1.n())
            {
                q.removeDetachedView(view, false);
            }
            az1.b(view);
        }

        az1.a.clear();
        if (j1 > 0)
        {
            q.invalidate();
        }
    }

    public int c(bf bf1)
    {
        return 0;
    }

    public final View c(int i1)
    {
        if (p != null)
        {
            return p.b(i1);
        } else
        {
            return null;
        }
    }

    public View c(int i1, az az1, bf bf1)
    {
        return null;
    }

    public void c(int i1, int j1)
    {
    }

    public final void c(az az1)
    {
        for (int i1 = j() - 1; i1 >= 0; i1--)
        {
            if (!RecyclerView.b(c(i1)).b())
            {
                a(i1, az1);
            }
        }

    }

    public void c(az az1, bf bf1)
    {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public boolean c()
    {
        return false;
    }

    public int d(bf bf1)
    {
        return 0;
    }

    public Parcelable d()
    {
        return null;
    }

    public void d(int i1)
    {
        if (q != null)
        {
            RecyclerView recyclerview = q;
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

    public int e(bf bf1)
    {
        return 0;
    }

    public void e(int i1)
    {
        if (q != null)
        {
            RecyclerView recyclerview = q;
            int k1 = recyclerview.c.a();
            for (int j1 = 0; j1 < k1; j1++)
            {
                recyclerview.c.b(j1).offsetTopAndBottom(i1);
            }

        }
    }

    public boolean e()
    {
        return false;
    }

    public int f(bf bf1)
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

    public final void h()
    {
        if (q != null)
        {
            q.requestLayout();
        }
    }

    public final boolean i()
    {
        return r != null && r.k;
    }

    public final int j()
    {
        if (p != null)
        {
            return p.a();
        } else
        {
            return 0;
        }
    }

    public final int k()
    {
        if (q != null)
        {
            return q.getWidth();
        } else
        {
            return 0;
        }
    }

    public final int l()
    {
        if (q != null)
        {
            return q.getHeight();
        } else
        {
            return 0;
        }
    }

    public final int m()
    {
        if (q != null)
        {
            return q.getPaddingLeft();
        } else
        {
            return 0;
        }
    }

    public final int n()
    {
        if (q != null)
        {
            return q.getPaddingTop();
        } else
        {
            return 0;
        }
    }

    public final int o()
    {
        if (q != null)
        {
            return q.getPaddingRight();
        } else
        {
            return 0;
        }
    }

    public final int p()
    {
        if (q != null)
        {
            return q.getPaddingBottom();
        } else
        {
            return 0;
        }
    }

    final void q()
    {
        if (r != null)
        {
            r.b();
        }
    }
}
