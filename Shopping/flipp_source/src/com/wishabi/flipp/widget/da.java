// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class da extends BaseAdapter
{

    private List a;
    public int j;

    public da()
    {
    }

    protected View a(int i, int k, View view)
    {
        return null;
    }

    protected View a(int i, View view, ViewGroup viewgroup)
    {
        return null;
    }

    protected Object a(int i)
    {
        return null;
    }

    protected final void a(List list)
    {
        a = new ArrayList();
        j = 0;
        for (list = list.iterator(); list.hasNext();)
        {
            Integer integer = (Integer)list.next();
            a.add(Integer.valueOf(j));
            int i = j;
            j = integer.intValue() + i;
        }

    }

    public boolean areAllItemsEnabled()
    {
        return false;
    }

    public final int b()
    {
        return a.size();
    }

    protected final int b(int i, int k)
    {
        return ((Integer)a.get(i)).intValue() + k;
    }

    protected int c(int i)
    {
        return -1;
    }

    protected int d(int i)
    {
        return -1;
    }

    public int getCount()
    {
        return j + a.size() * 2;
    }

    public Object getItem(int i)
    {
        if (i < j)
        {
            return a(i);
        } else
        {
            return null;
        }
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        if (i < j)
        {
            Iterator iterator = a.iterator();
            int k = -1;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Integer integer = (Integer)iterator.next();
                if (i < integer.intValue())
                {
                    break;
                }
                k++;
                integer.intValue();
            } while (true);
            return c(k);
        }
        if (i < j + a.size())
        {
            return d(i - j);
        }
        if (i < j + a.size() * 2)
        {
            a.size();
            return -1;
        } else
        {
            a.size();
            return -1;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i < j)
        {
            viewgroup = a.iterator();
            int k = -1;
            int l = 0;
            do
            {
                if (!viewgroup.hasNext())
                {
                    break;
                }
                Integer integer = (Integer)viewgroup.next();
                if (i < integer.intValue())
                {
                    break;
                }
                l = integer.intValue();
                k++;
                l = i - l;
            } while (true);
            return a(k, l, view);
        }
        if (i < j + a.size())
        {
            return a(i - j, view, viewgroup);
        }
        if (i < j + a.size() * 2)
        {
            a.size();
            return null;
        } else
        {
            a.size();
            return null;
        }
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isEmpty()
    {
        return j == 0;
    }

    public boolean isEnabled(int i)
    {
        return i < j;
    }
}
