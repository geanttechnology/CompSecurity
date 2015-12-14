// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.OrderType;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            q, DownloadItemUtility, af, u, 
//            s, r, DownloadGridItem, p

public class ab extends BaseAdapter
    implements q
{

    private Context a;
    private List b;
    private List c;
    private DownloadItemUtility d;
    private long e;
    private OrderType f;
    private List g;
    private int h;
    private CategoryType i;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType j;

    public ab(Context context, CategoryType categorytype, long l, OrderType ordertype, android.view.View.OnClickListener onclicklistener, android.view.View.OnClickListener onclicklistener1, 
            Object obj, ag ag, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        h = 30;
        a = context;
        j = displaymakeuptype;
        d = new DownloadItemUtility(this, obj, com.cyberlink.youcammakeup.Globals.ActivityType.c, j);
        b = new ArrayList();
        c = new ArrayList();
        g = new ArrayList();
        e = l;
        i = categorytype;
        f = ordertype;
        d.a(onclicklistener);
        d.b(onclicklistener1);
        d.a(ag);
        if (z.c(af.c, Globals.d()) < 4);
        d.a(e);
    }

    static OrderType a(ab ab1)
    {
        return ab1.f;
    }

    static List a(ab ab1, List list)
    {
        ab1.c = list;
        return list;
    }

    private void a(u u1)
    {
        int i1 = u1.a;
        int k = u1.b;
        if (i1 + k > c.size())
        {
            k -= (i1 + k) - c.size();
        }
        u1.b();
        ArrayList arraylist = new ArrayList();
        for (int l = i1; l < i1 + k; l++)
        {
            arraylist.add(((s)c.get(l)).a);
        }

        d.b(arraylist, new e(i1, k, u1) {

            final int a;
            final int b;
            final u c;
            final ab d;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (list != null && list.size() > 0)
                {
                    for (int j1 = a; j1 < a + list.size(); j1++)
                    {
                        ((s)ab.f(d).get(j1)).b = (MakeupItemMetadata)list.get(j1 - a);
                    }

                    ((Activity)com.cyberlink.youcammakeup.pages.moreview.ab.e(d)).runOnUiThread(new Runnable(this, list) {

                        final List a;
                        final _cls2 b;

                        public void run()
                        {
                            if (a.size() != b.b)
                            {
                                b.c.c();
                            }
                            ((ExtraDownloadActivity)com.cyberlink.youcammakeup.pages.moreview.ab.e(b.d)).k();
                        }

            
            {
                b = _pcls2;
                a = list;
                super();
            }
                    });
                }
            }

            public void b(Object obj)
            {
                m.e("ExtrasGridViewAdapter", (new StringBuilder()).append("[getViewMetadata] error: ").append(obj.toString()).toString());
                c.c();
            }

            public void c(Object obj)
            {
                m.b("ExtrasGridViewAdapter", (new StringBuilder()).append("[getViewMetadata] cancel: ").append(obj.toString()).toString());
                c.c();
            }

            
            {
                d = ab.this;
                a = k;
                b = l;
                c = u1;
                super();
            }
        });
    }

    static List b(ab ab1)
    {
        return ab1.b;
    }

    static int c(ab ab1)
    {
        return ab1.h;
    }

    static List d(ab ab1)
    {
        return ab1.g;
    }

    static Context e(ab ab1)
    {
        return ab1.a;
    }

    static List f(ab ab1)
    {
        return ab1.c;
    }

    public Context a()
    {
        return a;
    }

    public s a(int k)
    {
        return (s)c.get(k);
    }

    public void a(List list)
    {
        b.addAll(list);
        if (list.size() == 0)
        {
            if (a != null)
            {
                ((ExtraDownloadActivity)a).l();
            }
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((r)list.next()).a)) { }
        d.a(arraylist, new e() {

            final ab a;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list1)
            {
                int i1 = 0;
                if (list1 == null || list1.size() == 0)
                {
                    return;
                }
                int k = 0;
                int l = 0;
                for (; k < list1.size(); k++)
                {
                    if (((a)list1.get(k)).b().equals(com.cyberlink.youcammakeup.pages.moreview.ab.a(a).name()))
                    {
                        l = k;
                    }
                }

                int j1 = (int)Math.ceil((double)((r)ab.b(a).get(l)).c().size() / (double)ab.c(a));
                boolean flag = false;
                k = i1;
                i1 = ((flag) ? 1 : 0);
                for (; k < j1; k++)
                {
                    list1 = new u();
                    list1.a = i1;
                    list1.b = ab.c(a);
                    ab.d(a).add(list1);
                    i1 += ab.c(a);
                }

                com.cyberlink.youcammakeup.pages.moreview.ab.a(a, ((r)ab.b(a).get(l)).c());
                ((Activity)com.cyberlink.youcammakeup.pages.moreview.ab.e(a)).runOnUiThread(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        a.a.notifyDataSetChanged();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            public void b(Object obj)
            {
                m.e("ExtrasGridViewAdapter", obj.toString());
            }

            public void c(Object obj)
            {
                m.e("ExtrasGridViewAdapter", obj.toString());
            }

            
            {
                a = ab.this;
                super();
            }
        });
    }

    public long b()
    {
        return e;
    }

    public MakeupItemMetadata b(int k)
    {
        return a(k).b();
    }

    public void c()
    {
        b.clear();
        d.a(Long.valueOf(e));
        d.a();
    }

    public CategoryType d()
    {
        return i;
    }

    public int getCount()
    {
        return c.size();
    }

    public Object getItem(int k)
    {
        return a(k);
    }

    public long getItemId(int k)
    {
        return 0L;
    }

    public int getItemViewType(int k)
    {
        return com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.a(a(k).c());
    }

    public View getView(int k, View view, ViewGroup viewgroup)
    {
        Long long1;
        Long long2;
        if (view != null)
        {
            view = (DownloadGridItem)view;
        } else
        {
            view = com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.a(getItemViewType(k));
            view = new DownloadGridItem(viewgroup.getContext(), view, null);
            view.setOnDownloadClickListener(d.a);
            view.setTag(new p());
        }
        viewgroup = (p)view.getTag();
        viewgroup.a(k);
        long1 = viewgroup.b();
        long2 = Long.valueOf(a(k).a());
        if (!long2.equals(long1))
        {
            d.a(view);
            if (a(k).b != null)
            {
                viewgroup.a(long2);
                d.a(a(k).b, view, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a);
                d.a(long2, Long.valueOf(e), view);
            } else
            {
                k /= h;
                if (((u)g.get(k)).a())
                {
                    a((u)g.get(k));
                    return view;
                }
            }
        }
        return view;
    }
}
