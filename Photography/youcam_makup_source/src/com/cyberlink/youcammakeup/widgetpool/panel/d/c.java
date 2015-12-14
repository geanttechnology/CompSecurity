// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.pages.librarypicker.photozoompage.kernel.k;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class c extends BaseAdapter
{

    protected Context a;
    protected final boolean b;
    protected com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition c;
    protected List d;
    protected List e;
    protected List f;
    protected android.view.View.OnClickListener g;
    protected boolean h;
    private boolean i;
    private ag j;
    private az k;
    private BeautyMode l;
    private List m;
    private String n;
    private int o;

    public c(Context context, BeautyMode beautymode, String s, boolean flag, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition deletableitemposition, az az1)
    {
        h = false;
        i = false;
        m = new ArrayList();
        o = -1;
        a = context;
        b = flag;
        c = deletableitemposition;
        j = new ag(context);
        l = beautymode;
        k = az1;
        n = s;
        context = new k(a, null);
        context.g = false;
        context.a(0.15F);
        j.a(((Activity)a).getFragmentManager(), context);
        i();
    }

    private void i()
    {
        boolean flag = false;
        d = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        o = -1;
        if (k == null)
        {
            List list = PanelDataCenter.a().b(l, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a);
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                ax ax2 = PanelDataCenter.a().p((String)list.get(i1));
                if (ax2 != null)
                {
                    e.add(new p(ax2.c(), ax2.a(), ax2.d(), ax2.e().booleanValue(), ax2.i()));
                }
            }

            int j1 = ((flag) ? 1 : 0);
            if (b)
            {
                d.add(new p("", "", null, false, null));
                j1 = 1;
            }
            if (n != null)
            {
                ax ax1 = PanelDataCenter.a().p(n);
                d.add(new p(ax1.c(), ax1.a(), ax1.d(), ax1.e().booleanValue(), ax1.i()));
                o = j1;
            }
            a();
            return;
        } else
        {
            j();
            return;
        }
    }

    private void j()
    {
        if (k != null)
        {
            Iterator iterator = com.cyberlink.youcammakeup.kernelctrl.sku.h.b().a(k.b(), k.a()).l().iterator();
            while (iterator.hasNext()) 
            {
                Object obj = (e)iterator.next();
                obj = PanelDataCenter.a().p(((e) (obj)).a());
                if (obj != null)
                {
                    e.add(new p(((ax) (obj)).c(), ((ax) (obj)).a(), ((ax) (obj)).d(), ((ax) (obj)).e().booleanValue(), ((ax) (obj)).i()));
                }
            }
        }
    }

    public p a(int i1)
    {
        List list2 = d;
        List list;
        List list1;
        if (c == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition.a)
        {
            list = f;
        } else
        {
            list = e;
        }
        if (c == com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanelItemAdapter.DeletableItemPosition.b)
        {
            list1 = f;
        } else
        {
            list1 = e;
        }
        if (i1 < list2.size())
        {
            return (p)list2.get(i1);
        }
        if (i1 - list2.size() < list.size())
        {
            return (p)list.get(i1 - list2.size());
        } else
        {
            return (p)list1.get(i1 - list2.size() - list.size());
        }
    }

    public void a()
    {
        f.clear();
        Object obj = PanelDataCenter.a().b(l, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b);
        Collections.reverse(((List) (obj)));
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Object obj1 = (String)((Iterator) (obj)).next();
            obj1 = PanelDataCenter.a().p(((String) (obj1)));
            if (obj1 != null)
            {
                f.add(new p(((ax) (obj1)).c(), ((ax) (obj1)).a(), ((ax) (obj1)).d(), ((ax) (obj1)).e().booleanValue(), ((ax) (obj1)).i()));
            }
        } while (true);
    }

    public void a(int i1, boolean flag)
    {
        p p1 = a(i1);
        if (p1.d != com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b)
        {
            return;
        } else
        {
            p1.e = false;
            PanelDataCenter.a().p(p1.c).a(Boolean.valueOf(flag));
            return;
        }
    }

    public void a(List list)
    {
        m.clear();
        if (list != null)
        {
            m.addAll(list);
        }
    }

    public void a(boolean flag)
    {
        if (h == flag)
        {
            return;
        } else
        {
            h = flag;
            notifyDataSetChanged();
            return;
        }
    }

    public void b(boolean flag)
    {
        i = flag;
    }

    public boolean b()
    {
        return h;
    }

    public boolean b(int i1)
    {
        return a(i1).e;
    }

    public List c()
    {
        return new ArrayList(m);
    }

    public boolean c(int i1)
    {
        return a(i1).d == com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b;
    }

    public List d()
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = m.iterator(); iterator.hasNext(); arraylist.add(a(((Integer)iterator.next()).intValue()).c)) { }
        return arraylist;
    }

    public void d(int i1)
    {
        m.clear();
        e(i1);
    }

    public int e()
    {
        return m.size();
    }

    public void e(int i1)
    {
        if (i1 >= 0 && i1 < getCount())
        {
            m.add(Integer.valueOf(i1));
        }
    }

    public int f()
    {
        return o;
    }

    public void f(int i1)
    {
        m.remove(Integer.valueOf(i1));
    }

    public boolean g()
    {
        return i;
    }

    public boolean g(int i1)
    {
        return m.contains(Integer.valueOf(i1));
    }

    public int getCount()
    {
        return d.size() + e.size() + f.size();
    }

    public Object getItem(int i1)
    {
        return a(i1);
    }

    public long getItemId(int i1)
    {
        return -1L;
    }

    public int getItemViewType(int i1)
    {
        return i1 != 0 || !b ? 1 : 0;
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        boolean flag1 = true;
        if (view != null)
        {
            view = (TemplateButton)view;
        } else
        if (i1 == 0 && b)
        {
            view = new TemplateButton(a, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton.LayoutType.a, l);
        } else
        {
            view = new TemplateButton(a, com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.TemplateButton.LayoutType.b, l);
            view.setOnItemDelete(g);
        }
        if (i1 == 0 && b)
        {
            return view;
        }
        viewgroup = a(i1);
        Object obj = ((p) (viewgroup)).c;
        p p1 = (p)view.getTag();
        if (view.getTag() == null || !p1.c.equals(obj))
        {
            obj = PanelDataCenter.a().p(((String) (obj)));
            view.setTag(new p(((ax) (obj)).c(), ((ax) (obj)).a(), ((ax) (obj)).d(), ((ax) (obj)).e().booleanValue(), ((ax) (obj)).i()));
        }
        viewgroup = ((p) (viewgroup)).b;
        boolean flag2 = g(i1);
        view.setNameVisibility(4);
        view.a(j, viewgroup);
        view.a(b(i1));
        boolean flag;
        if (h && c(i1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.c(flag);
        if (flag2 && g())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        view.e(flag);
        return view;
    }

    public int getViewTypeCount()
    {
        return 2;
    }

    public boolean h()
    {
        return b;
    }
}
