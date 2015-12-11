// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.internal.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.internal.view.menu:
//            l, ExpandedMenuView, p, g, 
//            f, m, h

public class e
    implements l, android.widget.AdapterView.OnItemClickListener
{
    private class a extends BaseAdapter
    {

        final e a;
        private int b;

        public h a(int k)
        {
            ArrayList arraylist = a.c.l();
            int i1 = e.a(a) + k;
            k = i1;
            if (b >= 0)
            {
                k = i1;
                if (i1 >= b)
                {
                    k = i1 + 1;
                }
            }
            return (h)arraylist.get(k);
        }

        void a()
        {
            h h1 = a.c.r();
            if (h1 != null)
            {
                ArrayList arraylist = a.c.l();
                int i1 = arraylist.size();
                for (int k = 0; k < i1; k++)
                {
                    if ((h)arraylist.get(k) == h1)
                    {
                        b = k;
                        return;
                    }
                }

            }
            b = -1;
        }

        public int getCount()
        {
            int k = a.c.l().size() - e.a(a);
            if (b < 0)
            {
                return k;
            } else
            {
                return k - 1;
            }
        }

        public Object getItem(int k)
        {
            return a(k);
        }

        public long getItemId(int k)
        {
            return (long)k;
        }

        public View getView(int k, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                view = a.b.inflate(a.f, viewgroup, false);
            }
            ((m.a)view).a(a(k), 0);
            return view;
        }

        public void notifyDataSetChanged()
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
    a g;
    private int h;
    private l.a i;
    private int j;

    public e(int k, int i1)
    {
        f = k;
        e = i1;
    }

    public e(Context context, int k)
    {
        this(k, 0);
        a = context;
        b = LayoutInflater.from(a);
    }

    static int a(e e1)
    {
        return e1.h;
    }

    public m a(ViewGroup viewgroup)
    {
        if (d == null)
        {
            d = (ExpandedMenuView)b.inflate(android.support.v7.a.a.h.abc_expanded_menu_layout, viewgroup, false);
            if (g == null)
            {
                g = new a();
            }
            d.setAdapter(g);
            d.setOnItemClickListener(this);
        }
        return d;
    }

    public void a(Context context, f f1)
    {
        if (e == 0) goto _L2; else goto _L1
_L1:
        a = new ContextThemeWrapper(context, e);
        b = LayoutInflater.from(a);
_L4:
        c = f1;
        if (g != null)
        {
            g.notifyDataSetChanged();
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

    public void a(Bundle bundle)
    {
        SparseArray sparsearray = new SparseArray();
        if (d != null)
        {
            d.saveHierarchyState(sparsearray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparsearray);
    }

    public void a(Parcelable parcelable)
    {
        b((Bundle)parcelable);
    }

    public void a(f f1, boolean flag)
    {
        if (i != null)
        {
            i.a(f1, flag);
        }
    }

    public void a(l.a a1)
    {
        i = a1;
    }

    public void a(boolean flag)
    {
        if (g != null)
        {
            g.notifyDataSetChanged();
        }
    }

    public boolean a()
    {
        return false;
    }

    public boolean a(f f1, h h1)
    {
        return false;
    }

    public boolean a(p p1)
    {
        if (!p1.hasVisibleItems())
        {
            return false;
        }
        (new g(p1)).a(null);
        if (i != null)
        {
            i.a_(p1);
        }
        return true;
    }

    public int b()
    {
        return j;
    }

    public void b(Bundle bundle)
    {
        bundle = bundle.getSparseParcelableArray("android:menu:list");
        if (bundle != null)
        {
            d.restoreHierarchyState(bundle);
        }
    }

    public boolean b(f f1, h h1)
    {
        return false;
    }

    public Parcelable c()
    {
        if (d == null)
        {
            return null;
        } else
        {
            Bundle bundle = new Bundle();
            a(bundle);
            return bundle;
        }
    }

    public ListAdapter d()
    {
        if (g == null)
        {
            g = new a();
        }
        return g;
    }

    public void onItemClick(AdapterView adapterview, View view, int k, long l1)
    {
        c.a(g.a(k), this, 0);
    }
}
