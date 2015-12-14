// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            g, m

public class f extends BaseAdapter
{

    private int a;
    private Context b;
    private List c;
    private List d;
    private List e;
    private List f;

    public f(Context context)
    {
        a = 0;
        c = null;
        d = null;
        e = null;
        f = null;
        a(context);
    }

    private void a(Context context)
    {
        b = context;
        c = d(4);
        d = d(3);
        e = d(2);
        f = d(1);
    }

    private List d(int i)
    {
        Object obj = new ArrayList();
        ((List) (obj)).addAll(PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, i));
        ((List) (obj)).addAll(PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, i));
        ((List) (obj)).addAll(PanelDataCenter.a().a(BeautyMode.n, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, i));
        ArrayList arraylist = new ArrayList();
        aw aw1;
        List list;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new g(aw1.a(), list, aw1.h().booleanValue())))
        {
            aw1 = (aw)((Iterator) (obj)).next();
            list = aw1.i();
        }

        return arraylist;
    }

    public int a()
    {
        return a;
    }

    public g a(int i)
    {
        if (i != 0)
        {
            i--;
            if (i < c.size())
            {
                return (g)c.get(i);
            }
            i -= c.size();
            if (i < d.size())
            {
                return (g)d.get(i);
            }
            i -= d.size();
            if (i < e.size())
            {
                return (g)e.get(i);
            }
            i -= e.size();
            if (i < f.size())
            {
                return (g)f.get(i);
            }
        }
        return null;
    }

    public void a(int i, boolean flag)
    {
        a(i).c = flag;
        aw aw1 = PanelDataCenter.a().i(a(i).a);
        if (aw1.g() == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
        {
            aw1.a(Boolean.valueOf(flag));
        }
    }

    public void b(int i)
    {
        if (i <= 0 || i >= getCount())
        {
            a = 0;
            return;
        } else
        {
            a = i;
            return;
        }
    }

    public boolean c(int i)
    {
        return a(i).c;
    }

    public int getCount()
    {
        return c.size() + 1 + d.size() + e.size() + f.size();
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        if (i == 0)
        {
            return 0;
        } else
        {
            return a(i).b.size();
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (i == 0)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = new m(b, 0);
            }
            return viewgroup;
        }
        viewgroup = a(i).b;
        if (view == null)
        {
            view = new m(b, viewgroup.size());
        } else
        {
            view = (m)view;
        }
        view.setColors(viewgroup);
        view.a(c(i));
        return view;
    }

    public int getViewTypeCount()
    {
        return 5;
    }
}
