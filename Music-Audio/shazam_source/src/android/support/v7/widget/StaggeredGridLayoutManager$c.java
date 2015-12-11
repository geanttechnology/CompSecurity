// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            StaggeredGridLayoutManager, u

final class <init>
{

    ArrayList a;
    int b;
    int c;
    int d;
    final int e;
    final StaggeredGridLayoutManager f;

    private void f()
    {
        View view = (View)a.get(0);
        <init> <init>1 = (a)view.getLayoutParams();
        b = f.b.a(view);
        if (<init>1.f)
        {
            zySpanLookup.FullSpanItem fullspanitem = f.g.d(((zySpanLookup.d) (<init>1)).d.d());
            if (fullspanitem != null && fullspanitem.b == -1)
            {
                b = b - fullspanitem.a(e);
            }
        }
    }

    private void g()
    {
        View view = (View)a.get(a.size() - 1);
        e e1 = (a)view.getLayoutParams();
        c = f.b.b(view);
        if (e1.f)
        {
            zySpanLookup.FullSpanItem fullspanitem = f.g.d(((zySpanLookup.d) (e1)).d.d());
            if (fullspanitem != null && fullspanitem.b == 1)
            {
                int i = c;
                c = fullspanitem.a(e) + i;
            }
        }
    }

    final int a()
    {
        if (b != 0x80000000)
        {
            return b;
        } else
        {
            f();
            return b;
        }
    }

    final int a(int i)
    {
        if (b != 0x80000000)
        {
            i = b;
        } else
        if (a.size() != 0)
        {
            f();
            return b;
        }
        return i;
    }

    final int a(int i, int j)
    {
        byte byte1 = -1;
        int l = f.b.b();
        int i1 = f.b.c();
        byte byte0;
        if (j > i)
        {
            byte0 = 1;
        } else
        {
            byte0 = -1;
        }
        do
        {
label0:
            {
                int k = byte1;
                if (i != j)
                {
                    View view = (View)a.get(i);
                    k = f.b.a(view);
                    int j1 = f.b.b(view);
                    if (k >= i1 || j1 <= l)
                    {
                        break label0;
                    }
                    k = StaggeredGridLayoutManager.a(view);
                }
                return k;
            }
            i += byte0;
        } while (true);
    }

    final void a(View view)
    {
        f f1 = (f)view.getLayoutParams();
        f1.e = this;
        a.add(0, view);
        b = 0x80000000;
        if (a.size() == 1)
        {
            c = 0x80000000;
        }
        if (((c) (f1)).c.c() || ((c) (f1)).c.c())
        {
            d = d + f.b.c(view);
        }
    }

    final int b()
    {
        if (c != 0x80000000)
        {
            return c;
        } else
        {
            g();
            return c;
        }
    }

    final int b(int i)
    {
        if (c != 0x80000000)
        {
            i = c;
        } else
        if (a.size() != 0)
        {
            g();
            return c;
        }
        return i;
    }

    final void b(View view)
    {
        c c1 = (c)view.getLayoutParams();
        c1.e = this;
        a.add(view);
        c = 0x80000000;
        if (a.size() == 1)
        {
            b = 0x80000000;
        }
        if (((b) (c1)).b.b() || ((b) (c1)).b.b())
        {
            d = d + f.b.c(view);
        }
    }

    final void c()
    {
        a.clear();
        b = 0x80000000;
        c = 0x80000000;
        d = 0;
    }

    final void c(int i)
    {
        b = i;
        c = i;
    }

    final void d()
    {
        int i = a.size();
        View view = (View)a.remove(i - 1);
        c c1 = (a)view.getLayoutParams();
        c1.e = null;
        if (((e) (c1)).e.e() || ((e) (c1)).e.e())
        {
            d = d - f.b.c(view);
        }
        if (i == 1)
        {
            b = 0x80000000;
        }
        c = 0x80000000;
    }

    final void d(int i)
    {
        if (b != 0x80000000)
        {
            b = b + i;
        }
        if (c != 0x80000000)
        {
            c = c + i;
        }
    }

    final void e()
    {
        View view = (View)a.remove(0);
        c c1 = (a)view.getLayoutParams();
        c1.e = null;
        if (a.size() == 0)
        {
            c = 0x80000000;
        }
        if (((c) (c1)).c.c() || ((c) (c1)).c.c())
        {
            d = d - f.b.c(view);
        }
        b = 0x80000000;
    }

    private zySpanLookup.FullSpanItem(StaggeredGridLayoutManager staggeredgridlayoutmanager, int i)
    {
        f = staggeredgridlayoutmanager;
        super();
        a = new ArrayList();
        b = 0x80000000;
        c = 0x80000000;
        d = 0;
        e = i;
    }

    e(StaggeredGridLayoutManager staggeredgridlayoutmanager, int i, byte byte0)
    {
        this(staggeredgridlayoutmanager, i);
    }
}
