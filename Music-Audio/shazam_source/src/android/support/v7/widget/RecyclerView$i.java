// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.v4.view.a.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.f;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, m

public static abstract class l
{

    m h;
    RecyclerView i;
    b j;
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
        return android.view.c.makeMeasureSpec(i1, j1);
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
        return ((Spec)view.getLayoutParams()).a.c();
    }

    static void a(c c1, c c2)
    {
        if (c1.j == c2)
        {
            c1.j = null;
        }
    }

    public static void a(View view, int i1, int j1, int k1, int l1)
    {
        Rect rect = ((j)view.getLayoutParams()).b;
        view.layout(rect.left + i1, rect.top + j1, k1 - rect.right, l1 - rect.bottom);
    }

    static boolean a(b b1)
    {
        return b1.k;
    }

    public static int b(View view)
    {
        Rect rect = ((k)view.getLayoutParams()).b;
        int i1 = view.getMeasuredWidth();
        int j1 = rect.left;
        return rect.right + (i1 + j1);
    }

    static boolean b(b b1)
    {
        b1.k = false;
        return false;
    }

    public static int c(View view)
    {
        Rect rect = ((k)view.getLayoutParams()).b;
        int i1 = view.getMeasuredHeight();
        int j1 = rect.top;
        return rect.bottom + (i1 + j1);
    }

    public static int d(View view)
    {
        return view.getLeft() - ((b)view.getLayoutParams()).b.left;
    }

    public static int e(View view)
    {
        return view.getTop() - ((b)view.getLayoutParams()).b.top;
    }

    public static int f(View view)
    {
        int i1 = view.getRight();
        return ((b)view.getLayoutParams()).b.right + i1;
    }

    public static int g(View view)
    {
        int i1 = view.getBottom();
        return ((b)view.getLayoutParams()).b.bottom + i1;
    }

    private void g(int i1)
    {
        if (c(i1) != null)
        {
            m m1 = h;
            i1 = m1.a(i1);
            View view = m1.a.h(i1);
            if (view != null)
            {
                if (m1.b.h(i1))
                {
                    m1.c.remove(view);
                }
                m1.a.h(i1);
            }
        }
    }

    private void h(int i1)
    {
        c(i1);
        m m1 = h;
        i1 = m1.a(i1);
        m1.b.h(i1);
        m1.a.h(i1);
    }

    public int a(int i1, h h1, h h2)
    {
        return 0;
    }

    public int a(h h1)
    {
        return 0;
    }

    public abstract h a();

    public h a(Context context, AttributeSet attributeset)
    {
        return new <init>(context, attributeset);
    }

    public <init> a(android.view.tParams tparams)
    {
        if (tparams instanceof )
        {
            return new <init>((<init>)tparams);
        }
        if (tparams instanceof android.view.nLayoutParams)
        {
            return new <init>((android.view.nLayoutParams)tparams);
        } else
        {
            return new <init>(tparams);
        }
    }

    public View a(int i1)
    {
        int k1 = j();
        for (int j1 = 0; j1 < k1; j1++)
        {
            View view = c(j1);
            <init> <init>1 = android.support.v7.widget.RecyclerView.b(view);
            if (<init>1 != null && <init>1.c() == i1 && !<init>1.b() && (i.o.j || !<init>1.m()))
            {
                return view;
            }
        }

        return null;
    }

    public void a(int i1, int j1)
    {
    }

    public final void a(int i1, m m1)
    {
        View view = c(i1);
        g(i1);
        m1.a(view);
    }

    public void a(Parcelable parcelable)
    {
    }

    public final void a(a a1)
    {
        int i1 = j() - 1;
        while (i1 >= 0) 
        {
            Object obj = c(i1);
            a a2 = android.support.v7.widget.RecyclerView.b(((View) (obj)));
            if (!a2.b())
            {
                if (a2.i() && !a2.m() && !a2.k() && !RecyclerView.g(i).b)
                {
                    g(i1);
                    a1.a(a2);
                } else
                {
                    h(i1);
                    obj = android.support.v7.widget.RecyclerView.b(((View) (obj)));
                    obj.j = a1;
                    if (!((j) (obj)).k() || !RecyclerView.i(a1.h))
                    {
                        if (((h) (obj)).i() && !((i) (obj)).m() && !RecyclerView.g(a1.h).b)
                        {
                            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
                        }
                        a1.a.add(obj);
                    } else
                    {
                        if (a1.b == null)
                        {
                            a1.b = new ArrayList();
                        }
                        a1.b.add(obj);
                    }
                }
            }
            i1--;
        }
    }

    public void a(b b1, b b2)
    {
        Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public final void a(b b1)
    {
        if (j != null && b1 != j && j.k)
        {
            j.b();
        }
        j = b1;
        b1 = j;
        b1.h = i;
        b1.i = this;
        if (b1.g == -1)
        {
            throw new IllegalArgumentException("Invalid target position");
        } else
        {
            b1.h.o.a = b1.g;
            b1.k = true;
            b1.j = true;
            int i1 = b1.g;
            b1.l = RecyclerView.e(b1.h).a(i1);
            android.support.v7.widget.RecyclerView.w(b1.h).a();
            return;
        }
    }

    public void a(RecyclerView recyclerview)
    {
        Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void a(RecyclerView recyclerview, a a1)
    {
    }

    final void a(View view, int i1, boolean flag)
    {
        a a1;
        a a2;
        a1 = android.support.v7.widget.RecyclerView.b(view);
        if (flag || a1.m())
        {
            i.o.b(view);
        } else
        {
            i.o.a(view);
        }
        a2 = (a)view.getLayoutParams();
        if (!a1.f() && !a1.d()) goto _L2; else goto _L1
_L1:
        if (a1.d())
        {
            a1.e();
        } else
        {
            a1.g();
        }
        h.a(view, i1, view.getLayoutParams(), false);
_L4:
        if (a2.d)
        {
            a1.a.invalidate();
            a2.d = false;
        }
        return;
_L2:
        if (view.getParent() == i)
        {
            m m1 = h;
            int j1 = m1.a.h(view);
            int k1;
            if (j1 == -1)
            {
                j1 = -1;
            } else
            if (m1.b.h(j1))
            {
                j1 = -1;
            } else
            {
                j1 -= m1.b.h(j1);
            }
            k1 = i1;
            if (i1 == -1)
            {
                k1 = h.a();
            }
            if (j1 == -1)
            {
                throw new IllegalStateException((new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:")).append(i.indexOfChild(view)).toString());
            }
            if (j1 != k1)
            {
                view = RecyclerView.e(i);
                View view1 = view.c(j1);
                if (view1 == null)
                {
                    throw new IllegalArgumentException((new StringBuilder("Cannot move a child from non-existing index:")).append(j1).toString());
                }
                view.h(j1);
                a a4 = (h)view1.getLayoutParams();
                a a5 = android.support.v7.widget.RecyclerView.b(view1);
                if (a5.m())
                {
                    ((m) (view)).i.o.b(view1);
                } else
                {
                    ((b) (view)).i.o.a(view1);
                }
                ((a) (view)).h.a(view1, k1, a4, a5.m());
            }
        } else
        {
            h.a(view, i1, false);
            a2.c = true;
            if (j != null && j.k)
            {
                a a3 = j;
                if (RecyclerView.d(view) == a3.g)
                {
                    a3.l = view;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    final void a(View view, b b1)
    {
        l l1 = android.support.v7.widget.RecyclerView.b(view);
        if (l1 != null && !l1.m() && !h.a(l1.a))
        {
            Object obj = i.a;
            obj = i.o;
            b(view, b1);
        }
    }

    public final void a(View view, b b1)
    {
        m m1 = h;
        int i1 = m1.a.h(view);
        if (i1 >= 0)
        {
            if (m1.b.h(i1))
            {
                m1.c.remove(view);
            }
            m1.a.h(i1);
        }
        b1.a(view);
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
            if (!w.b(i, 1))
            {
                flag = flag1;
                if (!w.b(i, -1))
                {
                    flag = flag1;
                    if (!w.a(i, -1))
                    {
                        if (w.a(i, 1))
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

    public void a(String s)
    {
        if (i != null)
        {
            i.a(s);
        }
    }

    public boolean a(i i1)
    {
        return i1 != null;
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

    public int b(int i1, moveCallbacks movecallbacks, moveCallbacks movecallbacks1)
    {
        return 0;
    }

    public int b(moveCallbacks movecallbacks, moveCallbacks movecallbacks1)
    {
        while (i == null || RecyclerView.g(i) == null || !d()) 
        {
            return 1;
        }
        return RecyclerView.g(i).a();
    }

    public int b(a a1)
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

    final void b(a a1)
    {
        int j1 = a1.a.size();
        for (int i1 = j1 - 1; i1 >= 0; i1--)
        {
            View view = ((a)a1.a.get(i1)).a;
            a a2 = android.support.v7.widget.RecyclerView.b(view);
            if (a2.b())
            {
                continue;
            }
            a2.a(false);
            if (a2.n())
            {
                i.removeDetachedView(view, false);
            }
            if (i.m != null)
            {
                i.m.c(a2);
            }
            a2.a(true);
            a1.b(view);
        }

        a1.a.clear();
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

    final void b(RecyclerView recyclerview, h h1)
    {
        l = false;
        a(recyclerview, h1);
    }

    public void b(View view, b b1)
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
        b1.a(android.support.v4.view.a.a(i1, 1, j1, 1, false));
    }

    public int c(a a1, a a2)
    {
        while (i == null || RecyclerView.g(i) == null || !c()) 
        {
            return 1;
        }
        return RecyclerView.g(i).a();
    }

    public int c(a a1)
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

    public View c(int i1, h h1, h h2)
    {
        return null;
    }

    public void c(int i1, int j1)
    {
    }

    public final void c(h h1)
    {
        for (int i1 = j() - 1; i1 >= 0; i1--)
        {
            if (!android.support.v7.widget.RecyclerView.b(c(i1)).b())
            {
                a(i1, h1);
            }
        }

    }

    public boolean c()
    {
        return false;
    }

    public int d(a a1)
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

    public int e(i i1)
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

    public int f(i i1)
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
        return i != null && RecyclerView.v(i);
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

    public vent()
    {
        k = false;
        l = false;
    }
}
