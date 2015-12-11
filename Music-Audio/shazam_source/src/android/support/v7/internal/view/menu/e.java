// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.support.v7.a.d;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            l, ExpandedMenuView, p, g, 
//            f, m, h

public final class e
    implements l, android.widget.AdapterView.OnItemClickListener
{
    private final class a extends BaseAdapter
    {

        final e a;
        private int b;

        private void a()
        {
            h h1 = a.c.j;
            if (h1 != null)
            {
                ArrayList arraylist = a.c.j();
                int k = arraylist.size();
                for (int j = 0; j < k; j++)
                {
                    if ((h)arraylist.get(j) == h1)
                    {
                        b = j;
                        return;
                    }
                }

            }
            b = -1;
        }

        public final h a(int j)
        {
            ArrayList arraylist = a.c.j();
            int k = e.a(a) + j;
            j = k;
            if (b >= 0)
            {
                j = k;
                if (k >= b)
                {
                    j = k + 1;
                }
            }
            return (h)arraylist.get(j);
        }

        public final int getCount()
        {
            int j = a.c.j().size() - e.a(a);
            if (b < 0)
            {
                return j;
            } else
            {
                return j - 1;
            }
        }

        public final Object getItem(int j)
        {
            return a(j);
        }

        public final long getItemId(int j)
        {
            return (long)j;
        }

        public final View getView(int j, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = a.b.inflate(a.f, viewgroup, false);
            }
            ((m.a)view).a(a(j));
            return view;
        }

        public final void notifyDataSetChanged()
        {
            a();
            super.notifyDataSetChanged();
        }

        public a()
        {
            a = e.this;
            super();
            b = -1;
            a();
        }
    }


    Context a;
    LayoutInflater b;
    f c;
    ExpandedMenuView d;
    int e;
    int f;
    public l.a g;
    a h;
    private int i;

    private e(int j)
    {
        f = j;
        e = 0;
    }

    public e(Context context, int j)
    {
        this(j);
        a = context;
        b = LayoutInflater.from(a);
    }

    static int a(e e1)
    {
        return e1.i;
    }

    public final m a(ViewGroup viewgroup)
    {
        if (d == null)
        {
            d = (ExpandedMenuView)b.inflate(android.support.v7.b.a.h.abc_expanded_menu_layout, viewgroup, false);
            if (h == null)
            {
                h = new a();
            }
            d.setAdapter(h);
            d.setOnItemClickListener(this);
        }
        return d;
    }

    public final void a(Context context, f f1)
    {
        if (e == 0) goto _L2; else goto _L1
_L1:
        a = new ContextThemeWrapper(context, e);
        b = LayoutInflater.from(a);
_L4:
        c = f1;
        if (h != null)
        {
            h.notifyDataSetChanged();
        }
        return;
_L2:
        if (a != null)
        {
            a = context;
            if (b == null)
            {
                b = LayoutInflater.from(a);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(f f1, boolean flag)
    {
        if (g != null)
        {
            g.a(f1, flag);
        }
    }

    public final boolean a()
    {
        return false;
    }

    public final boolean a(p p1)
    {
        if (!p1.hasVisibleItems())
        {
            return false;
        }
        g g1 = new g(p1);
        Object obj = g1.a;
        android.support.v7.a.a a1 = new android.support.v7.a.a(((f) (obj)).a);
        g1.c = new e(a1.a.a, android.support.v7.b.a.h.abc_list_menu_item_layout);
        g1.c.g = g1;
        g1.a.a(g1.c);
        Object obj1 = g1.c.b();
        a1.a.t = ((ListAdapter) (obj1));
        a1.a.u = g1;
        obj1 = ((f) (obj)).h;
        android.support.v7.a.d.a a2;
        d d1;
        if (obj1 != null)
        {
            a1.a.g = ((View) (obj1));
        } else
        {
            android.graphics.drawable.Drawable drawable = ((f) (obj)).g;
            a1.a.d = drawable;
            obj = ((f) (obj)).f;
            a1.a.f = ((CharSequence) (obj));
        }
        a1.a.r = g1;
        obj1 = new android.support.v7.a.e(a1.a.a, a1.b);
        a2 = a1.a;
        d1 = android.support.v7.a.e.a(((android.support.v7.a.e) (obj1)));
        if (a2.g != null)
        {
            d1.C = a2.g;
        } else
        {
            if (a2.f != null)
            {
                d1.a(a2.f);
            }
            if (a2.d != null)
            {
                obj = a2.d;
                d1.y = ((android.graphics.drawable.Drawable) (obj));
                d1.x = 0;
                int k;
                if (d1.z != null)
                {
                    if (obj != null)
                    {
                        d1.z.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
                    } else
                    {
                        d1.z.setVisibility(8);
                    }
                }
            }
            if (a2.c != 0)
            {
                d1.a(a2.c);
            }
            if (a2.e != 0)
            {
                k = a2.e;
                obj = new TypedValue();
                d1.a.getTheme().resolveAttribute(k, ((TypedValue) (obj)), true);
                d1.a(((TypedValue) (obj)).resourceId);
            }
        }
        if (a2.h != null)
        {
            obj = a2.h;
            d1.e = ((CharSequence) (obj));
            if (d1.B != null)
            {
                d1.B.setText(((CharSequence) (obj)));
            }
        }
        if (a2.i != null)
        {
            d1.a(-1, a2.i, a2.j, null);
        }
        if (a2.k != null)
        {
            d1.a(-2, a2.k, a2.l, null);
        }
        if (a2.m != null)
        {
            d1.a(-3, a2.m, a2.n, null);
        }
        if (a2.s != null || a2.H != null || a2.t != null)
        {
            ListView listview = (ListView)a2.b.inflate(d1.H, null);
            int j;
            int k1;
            int l1;
            int i2;
            if (a2.D)
            {
                if (a2.H == null)
                {
                    obj = new android.support.v7.a.d.a._cls1(a2, a2.a, d1.I, a2.s, listview);
                } else
                {
                    obj = new android.support.v7.a.d.a._cls2(a2, a2.a, a2.H, listview, d1);
                }
            } else
            {
                int i1;
                if (a2.E)
                {
                    i1 = d1.J;
                } else
                {
                    i1 = d1.K;
                }
                if (a2.H == null)
                {
                    if (a2.t != null)
                    {
                        obj = a2.t;
                    } else
                    {
                        obj = new android.support.v7.a.d.c(a2.a, i1, a2.s);
                    }
                } else
                {
                    obj = new SimpleCursorAdapter(a2.a, i1, a2.H, new String[] {
                        a2.I
                    }, new int[] {
                        0x1020014
                    });
                }
            }
            d1.D = ((ListAdapter) (obj));
            d1.E = a2.F;
            if (a2.u != null)
            {
                listview.setOnItemClickListener(new android.support.v7.a.d.a._cls3(a2, d1));
            } else
            if (a2.G != null)
            {
                listview.setOnItemClickListener(new android.support.v7.a.d.a._cls4(a2, listview, d1));
            }
            if (a2.K != null)
            {
                listview.setOnItemSelectedListener(a2.K);
            }
            if (a2.E)
            {
                listview.setChoiceMode(1);
            } else
            if (a2.D)
            {
                listview.setChoiceMode(2);
            }
            d1.f = listview;
        }
        if (a2.w != null)
        {
            if (a2.B)
            {
                obj = a2.w;
                j = a2.x;
                k1 = a2.y;
                l1 = a2.z;
                i2 = a2.A;
                d1.g = ((View) (obj));
                d1.h = 0;
                d1.m = true;
                d1.i = j;
                d1.j = k1;
                d1.k = l1;
                d1.l = i2;
            } else
            {
                d1.g = a2.w;
                d1.h = 0;
                d1.m = false;
            }
        } else
        if (a2.v != 0)
        {
            int j1 = a2.v;
            d1.g = null;
            d1.h = j1;
            d1.m = false;
        }
        ((android.support.v7.a.e) (obj1)).setCancelable(a1.a.o);
        if (a1.a.o)
        {
            ((android.support.v7.a.e) (obj1)).setCanceledOnTouchOutside(true);
        }
        ((android.support.v7.a.e) (obj1)).setOnCancelListener(a1.a.p);
        ((android.support.v7.a.e) (obj1)).setOnDismissListener(a1.a.q);
        if (a1.a.r != null)
        {
            ((android.support.v7.a.e) (obj1)).setOnKeyListener(a1.a.r);
        }
        g1.b = ((android.support.v7.a.e) (obj1));
        g1.b.setOnDismissListener(g1);
        obj = g1.b.getWindow().getAttributes();
        obj.type = 1003;
        obj.flags = ((android.view.WindowManager.LayoutParams) (obj)).flags | 0x20000;
        g1.b.show();
        if (g != null)
        {
            g.a(p1);
        }
        return true;
    }

    public final ListAdapter b()
    {
        if (h == null)
        {
            h = new a();
        }
        return h;
    }

    public final void b(boolean flag)
    {
        if (h != null)
        {
            h.notifyDataSetChanged();
        }
    }

    public final boolean b(h h1)
    {
        return false;
    }

    public final boolean c(h h1)
    {
        return false;
    }

    public final void onItemClick(AdapterView adapterview, View view, int j, long l1)
    {
        c.a(h.a(j), this, 0);
    }
}
