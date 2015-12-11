// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

public abstract class by extends BaseAdapter
    implements android.widget.AdapterView.OnItemClickListener
{

    private int a;

    private int i(int j)
    {
        int k = a(j);
        if (b(j))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        return j + k;
    }

    public abstract int a();

    public abstract int a(int j);

    public abstract View a(int j, int k, View view, ViewGroup viewgroup);

    public View a(int j, View view, ViewGroup viewgroup)
    {
        return null;
    }

    public abstract Object a(int j, int k);

    public void a(AdapterView adapterview, View view, int j, int k, long l)
    {
    }

    public int b()
    {
        return 1;
    }

    public int b(int j, int k)
    {
        return 0;
    }

    public boolean b(int j)
    {
        return false;
    }

    public int c()
    {
        return 1;
    }

    public Object c(int j)
    {
        return null;
    }

    public boolean c(int j, int k)
    {
        return true;
    }

    public int d(int j)
    {
        return 0;
    }

    public boolean d()
    {
        return false;
    }

    protected int e(int j)
    {
        int l = 0;
        int k;
        for (k = 0; l <= j && k <= a(); k++)
        {
            l += i(k);
        }

        return k - 1;
    }

    protected int f(int j)
    {
        int l = e(j);
        int k = j - h(l);
        j = k;
        if (b(l))
        {
            j = k - 1;
        }
        return j;
    }

    protected boolean g(int j)
    {
        int k = e(j);
        return b(k) && h(k) == j;
    }

    public final int getCount()
    {
        if (a < 0)
        {
            a = h(a());
        }
        return a;
    }

    public final Object getItem(int j)
    {
        int k = e(j);
        if (g(j))
        {
            if (b(k))
            {
                return c(k);
            } else
            {
                return null;
            }
        } else
        {
            return a(k, f(j));
        }
    }

    public long getItemId(int j)
    {
        return (long)j;
    }

    public final int getItemViewType(int j)
    {
        int k = e(j);
        if (g(j))
        {
            j = b();
            return d(k) + j;
        } else
        {
            return b(k, f(j));
        }
    }

    public final View getView(int j, View view, ViewGroup viewgroup)
    {
        int k = e(j);
        if (g(j))
        {
            if (b(k))
            {
                return a(k, view, viewgroup);
            } else
            {
                return null;
            }
        } else
        {
            return a(k, f(j), view, viewgroup);
        }
    }

    public final int getViewTypeCount()
    {
        return b() + c();
    }

    protected int h(int j)
    {
        int k = 0;
        int l = 0;
        for (; k < Math.min(a(), j); k++)
        {
            l += i(k);
        }

        return l;
    }

    public boolean isEmpty()
    {
        return getCount() == 0;
    }

    public boolean isEnabled(int j)
    {
        return (d() || !g(j)) && c(e(j), f(j));
    }

    public void notifyDataSetChanged()
    {
        a = h(a());
        super.notifyDataSetChanged();
    }

    public void notifyDataSetInvalidated()
    {
        a = h(a());
        super.notifyDataSetInvalidated();
    }

    public final void onItemClick(AdapterView adapterview, View view, int j, long l)
    {
        a(adapterview, view, e(j), f(j), l);
    }
}
