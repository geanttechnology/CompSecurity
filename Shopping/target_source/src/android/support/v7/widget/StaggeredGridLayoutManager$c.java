// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            StaggeredGridLayoutManager, x

class zySpanLookup.FullSpanItem
{

    int a;
    int b;
    int c;
    final int d;
    final StaggeredGridLayoutManager e;
    private ArrayList f;

    static ArrayList a(zySpanLookup.FullSpanItem fullspanitem)
    {
        return fullspanitem.f;
    }

    int a(int j)
    {
        if (a != 0x80000000)
        {
            j = a;
        } else
        if (f.size() != 0)
        {
            a();
            return a;
        }
        return j;
    }

    void a()
    {
        View view = (View)f.get(0);
        a a1 = c(view);
        a = e.a.a(view);
        if (a1.f)
        {
            zySpanLookup.FullSpanItem fullspanitem = e.f.f(a1.e());
            if (fullspanitem != null && fullspanitem.b == -1)
            {
                a = a - fullspanitem.a(d);
            }
        }
    }

    void a(View view)
    {
        d d1 = c(view);
        d1.e = this;
        f.add(0, view);
        a = 0x80000000;
        if (f.size() == 1)
        {
            b = 0x80000000;
        }
        if (d1.c() || d1.d())
        {
            c = c + e.a.c(view);
        }
    }

    void a(boolean flag, int j)
    {
        int k;
        if (flag)
        {
            k = b(0x80000000);
        } else
        {
            k = a(0x80000000);
        }
        e();
        while (k == 0x80000000 || flag && k < e.a.d() || !flag && k > e.a.c()) 
        {
            return;
        }
        int l = k;
        if (j != 0x80000000)
        {
            l = k + j;
        }
        b = l;
        a = l;
    }

    int b()
    {
        if (a != 0x80000000)
        {
            return a;
        } else
        {
            a();
            return a;
        }
    }

    int b(int j)
    {
        if (b != 0x80000000)
        {
            j = b;
        } else
        if (f.size() != 0)
        {
            c();
            return b;
        }
        return j;
    }

    void b(View view)
    {
        b b1 = c(view);
        b1.e = this;
        f.add(view);
        b = 0x80000000;
        if (f.size() == 1)
        {
            a = 0x80000000;
        }
        if (b1.c() || b1.d())
        {
            c = c + e.a.c(view);
        }
    }

    e c(View view)
    {
        return (e)view.getLayoutParams();
    }

    void c()
    {
        View view = (View)f.get(f.size() - 1);
        e e1 = c(view);
        b = e.a.b(view);
        if (e1.f)
        {
            zySpanLookup.FullSpanItem fullspanitem = e.f.f(e1.e());
            if (fullspanitem != null && fullspanitem.b == 1)
            {
                int j = b;
                b = fullspanitem.a(d) + j;
            }
        }
    }

    void c(int j)
    {
        a = j;
        b = j;
    }

    int d()
    {
        if (b != 0x80000000)
        {
            return b;
        } else
        {
            c();
            return b;
        }
    }

    void d(int j)
    {
        if (a != 0x80000000)
        {
            a = a + j;
        }
        if (b != 0x80000000)
        {
            b = b + j;
        }
    }

    void e()
    {
        f.clear();
        f();
        c = 0;
    }

    void f()
    {
        a = 0x80000000;
        b = 0x80000000;
    }

    void g()
    {
        int j = f.size();
        View view = (View)f.remove(j - 1);
        b b1 = c(view);
        b1.e = null;
        if (b1.c() || b1.d())
        {
            c = c - e.a.c(view);
        }
        if (j == 1)
        {
            a = 0x80000000;
        }
        b = 0x80000000;
    }

    void h()
    {
        View view = (View)f.remove(0);
        b b1 = c(view);
        b1.e = null;
        if (f.size() == 0)
        {
            b = 0x80000000;
        }
        if (b1.c() || b1.d())
        {
            c = c - e.a.c(view);
        }
        a = 0x80000000;
    }

    public int i()
    {
        return c;
    }
}
