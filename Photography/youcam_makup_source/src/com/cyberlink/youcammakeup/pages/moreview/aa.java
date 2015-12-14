// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.ExtraDownloadActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.f;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.database.more.types.OrderType;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.ag;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.idunnololz.widgets.a;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            q, DownloadItemUtility, u, s, 
//            m, l, r, DownloadGridItem, 
//            p, t

public class aa extends a
    implements q
{

    private Set a;
    private Context b;
    private long c;
    private CategoryType d;
    private OrderType e;
    private DownloadItemUtility f;
    private android.widget.ExpandableListView.OnGroupClickListener g;
    private List h;
    private List i;
    private List j;
    private int k;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType l;
    private android.view.View.OnClickListener m;

    public aa(Context context, CategoryType categorytype, long l1, OrderType ordertype, android.view.View.OnClickListener onclicklistener, t t, 
            android.view.View.OnClickListener onclicklistener1, Object obj, ag ag, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        a = new HashSet();
        k = 30;
        m = new android.view.View.OnClickListener() {

            final aa a;

            public void onClick(View view)
            {
                if (aa.g(a) != null)
                {
                    int i1 = ((p)view.getTag()).a();
                    aa.g(a).onGroupClick((ExpandableListView)view.getParent(), view, i1, a.getGroupId(i1));
                }
            }

            
            {
                a = aa.this;
                super();
            }
        };
        b = context;
        l = displaymakeuptype;
        f = new DownloadItemUtility(this, obj, com.cyberlink.youcammakeup.Globals.ActivityType.c, l);
        c = l1;
        d = categorytype;
        e = ordertype;
        h = new ArrayList();
        i = new ArrayList();
        j = new ArrayList();
        f.a(onclicklistener);
        f.a(t);
        f.b(onclicklistener1);
        f.a(ag);
        f.a(c);
    }

    static List a(aa aa1)
    {
        return aa1.i;
    }

    static List a(aa aa1, List list)
    {
        aa1.i = list;
        return list;
    }

    private void a(u u1)
    {
        int k1 = u1.a;
        int i1 = u1.b;
        if (k1 + i1 > i.size())
        {
            i1 -= (k1 + i1) - i.size();
        }
        u1.b();
        ArrayList arraylist = new ArrayList();
        for (int j1 = k1; j1 < k1 + i1; j1++)
        {
            arraylist.add(((s)i.get(j1)).a);
        }

        f.b(arraylist, new e(i1, u1) {

            final int a;
            final u b;
            final aa c;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list)
            {
                if (list != null && list.size() > 0)
                {
                    ArrayList arraylist1 = new ArrayList();
                    for (Iterator iterator = com.cyberlink.youcammakeup.pages.moreview.aa.a(c).iterator(); iterator.hasNext(); arraylist1.add(Long.valueOf(((s)iterator.next()).a()))) { }
                    Iterator iterator1 = list.iterator();
                    do
                    {
                        if (!iterator1.hasNext())
                        {
                            break;
                        }
                        MakeupItemMetadata makeupitemmetadata = (MakeupItemMetadata)iterator1.next();
                        int l1 = arraylist1.indexOf(Long.valueOf(makeupitemmetadata.a()));
                        if (l1 >= 0)
                        {
                            ((s)com.cyberlink.youcammakeup.pages.moreview.aa.a(c).get(l1)).b = makeupitemmetadata;
                        }
                    } while (true);
                    ((Activity)com.cyberlink.youcammakeup.pages.moreview.aa.b(c)).runOnUiThread(new Runnable(this, list) {

                        final List a;
                        final _cls2 b;

                        public void run()
                        {
                            if (a.size() != b.a)
                            {
                                b.b.c();
                            }
                            ((ExtraDownloadActivity)com.cyberlink.youcammakeup.pages.moreview.aa.b(b.c)).k();
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
                com.pf.common.utility.m.e("ExtrasExpandableListAdapter", (new StringBuilder()).append("[getViewMetadata] error: ").append(obj.toString()).toString());
                b.c();
            }

            public void c(Object obj)
            {
                com.pf.common.utility.m.b("ExtrasExpandableListAdapter", (new StringBuilder()).append("[getViewMetadata] cancel: ").append(obj.toString()).toString());
                b.c();
            }

            
            {
                c = aa.this;
                a = i1;
                b = u1;
                super();
            }
        });
    }

    static Context b(aa aa1)
    {
        return aa1.b;
    }

    static OrderType c(aa aa1)
    {
        return aa1.e;
    }

    static List d(aa aa1)
    {
        return aa1.h;
    }

    static int e(aa aa1)
    {
        return aa1.k;
    }

    static List f(aa aa1)
    {
        return aa1.j;
    }

    static android.widget.ExpandableListView.OnGroupClickListener g(aa aa1)
    {
        return aa1.g;
    }

    public int a(int i1, int j1)
    {
        return 0;
    }

    public Context a()
    {
        return b;
    }

    public View a(int i1, int j1, boolean flag, View view, ViewGroup viewgroup)
    {
        Object obj = com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.a(getGroupType(i1));
        Object obj1;
        com.cyberlink.youcammakeup.pages.moreview.l l1;
        Long long1;
        Object obj2;
        if (view != null)
        {
            view = (com.cyberlink.youcammakeup.pages.moreview.m)view;
        } else
        {
            view = new com.cyberlink.youcammakeup.pages.moreview.m(viewgroup.getContext(), ((DownloadGridItem.LayoutTypeInfo.LayoutType) (obj)));
            view.setTag(new com.cyberlink.youcammakeup.pages.moreview.l());
        }
        obj = b(i1);
        obj1 = ((MakeupItemMetadata) (obj)).j();
        obj2 = a(i1);
        l1 = (com.cyberlink.youcammakeup.pages.moreview.l)view.getTag();
        long1 = l1.a();
        obj2 = Long.valueOf(((s) (obj2)).a());
        if (!((Long) (obj2)).equals(long1))
        {
            l1.a(((Long) (obj2)));
            view.a();
            obj1 = ((List) (obj1)).iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                f f1 = (f)((Iterator) (obj1)).next();
                k k1 = new k(((MakeupItemMetadata) (obj)).a(), "Makeup_Category_Item", f1.a());
                Globals.d().w().a(k1, new l(viewgroup, view, f1) {

                    final ViewGroup a;
                    final com.cyberlink.youcammakeup.pages.moreview.m b;
                    final f c;
                    final aa d;

                    public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
                    {
                    }

                    public void a(bn bn1)
                    {
                    }

                    public volatile void a(Object obj3)
                    {
                        a((String)obj3);
                    }

                    public void a(String s1)
                    {
                        a.post(new Runnable(this, s1) {

                            final String a;
                            final _cls1 b;

                            public void run()
                            {
                                if (b.b != null)
                                {
                                    b.b.a(b.c.b(), b.c.c(), a);
                                }
                            }

            
            {
                b = _pcls1;
                a = s1;
                super();
            }
                        });
                    }

                    public void a(Void void1)
                    {
                    }

                    public void b(Object obj3)
                    {
                        a((bn)obj3);
                    }

                    public void c(Object obj3)
                    {
                        a((Void)obj3);
                    }

                    public void d(Object obj3)
                    {
                        a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj3);
                    }

            
            {
                d = aa.this;
                a = viewgroup;
                b = m1;
                c = f1;
                super();
            }
                });
            }
        }
        return view;
    }

    public s a(int i1)
    {
        return (s)i.get(i1);
    }

    public void a(android.widget.ExpandableListView.OnGroupClickListener ongroupclicklistener)
    {
        g = ongroupclicklistener;
    }

    public void a(List list)
    {
        h.addAll(list);
        if (list.size() == 0)
        {
            if (b != null)
            {
                ((ExtraDownloadActivity)b).l();
            }
            return;
        }
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((r)list.next()).a)) { }
        f.a(arraylist, new e() {

            final aa a;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list1)
            {
                int k1 = 0;
                if (list1 == null || list1.size() == 0)
                {
                    return;
                }
                int i1 = 0;
                int j1 = 0;
                for (; i1 < list1.size(); i1++)
                {
                    if (((com.cyberlink.youcammakeup.database.more.makeup.a)list1.get(i1)).b().equals(aa.c(a).name()))
                    {
                        j1 = i1;
                    }
                }

                int l1 = (int)Math.ceil((double)((r)aa.d(a).get(j1)).c().size() / (double)com.cyberlink.youcammakeup.pages.moreview.aa.e(a));
                boolean flag = false;
                i1 = k1;
                k1 = ((flag) ? 1 : 0);
                for (; i1 < l1; i1++)
                {
                    list1 = new u();
                    list1.a = k1;
                    list1.b = com.cyberlink.youcammakeup.pages.moreview.aa.e(a);
                    com.cyberlink.youcammakeup.pages.moreview.aa.f(a).add(list1);
                    k1 += com.cyberlink.youcammakeup.pages.moreview.aa.e(a);
                }

                com.cyberlink.youcammakeup.pages.moreview.aa.a(a, ((r)aa.d(a).get(j1)).c());
                ((Activity)com.cyberlink.youcammakeup.pages.moreview.aa.b(a)).runOnUiThread(new Runnable(this) {

                    final _cls3 a;

                    public void run()
                    {
                        a.a.notifyDataSetChanged();
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
            }

            public void b(Object obj)
            {
                com.pf.common.utility.m.e("ExtrasExpandableListAdapter", obj.toString());
            }

            public void c(Object obj)
            {
                com.pf.common.utility.m.e("ExtrasExpandableListAdapter", obj.toString());
            }

            
            {
                a = aa.this;
                super();
            }
        });
    }

    public int a_(int i1)
    {
        List list = b(i1).j();
        return list == null || list.size() <= 0 ? 0 : 1;
    }

    public long b()
    {
        return c;
    }

    public MakeupItemMetadata b(int i1)
    {
        return a(i1).b();
    }

    public int c()
    {
        return 1;
    }

    public CategoryType d()
    {
        return d;
    }

    public void e()
    {
        h.clear();
        f.a(Long.valueOf(c));
        f.a();
    }

    public Object getChild(int i1, int j1)
    {
        return null;
    }

    public long getChildId(int i1, int j1)
    {
        return 0L;
    }

    public Object getGroup(int i1)
    {
        return a(i1);
    }

    public int getGroupCount()
    {
        return i.size();
    }

    public long getGroupId(int i1)
    {
        return 0L;
    }

    public int getGroupType(int i1)
    {
        return com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.a(a(i1).c());
    }

    public int getGroupTypeCount()
    {
        return 7;
    }

    public View getGroupView(int i1, boolean flag, View view, ViewGroup viewgroup)
    {
        DownloadGridItem.LayoutTypeInfo.LayoutType layouttype = com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.a(getGroupType(i1));
        p p1;
        Long long1;
        if (view != null)
        {
            view = (DownloadGridItem)view;
        } else
        {
            view = new DownloadGridItem(viewgroup.getContext(), layouttype, null);
            view.setOnDownloadClickListener(f.a);
            view.setOnGroupClickListener(m);
            if (layouttype == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.a || layouttype == DownloadGridItem.LayoutTypeInfo.LayoutType.g)
            {
                view.setOnEnlargeClickListener(f.b);
            }
            view.setTag(new p());
        }
        viewgroup = a(i1);
        view.e(flag);
        p1 = (p)view.getTag();
        p1.a(i1);
        long1 = Long.valueOf(viewgroup.a());
        f.a(view);
        if (viewgroup.b() == null) goto _L2; else goto _L1
_L1:
        p1.a(long1);
        view.setTitle(viewgroup.b().c());
        view.setDescription(viewgroup.b().e());
        f.a(viewgroup.b(), view, com.cyberlink.youcammakeup.utility.PanelDataCenter.ImageType.a);
        f.a(long1, Long.valueOf(c), view);
        if (viewgroup.b().k())
        {
            view.c(true);
        } else
        {
            view.c(false);
        }
        if (layouttype == com.cyberlink.youcammakeup.pages.moreview.DownloadGridItem.LayoutTypeInfo.LayoutType.a)
        {
            view.setEditMode(viewgroup.b().w());
            view.setLiveMode(viewgroup.b().x());
            view.setDisplayMakeupType(l);
            view.d();
        }
_L8:
        if ((d == CategoryType.c || d == CategoryType.b) && i1 != 0) goto _L4; else goto _L3
_L3:
        return view;
_L2:
        int j1 = i1 / k;
        if (((u)j.get(j1)).a())
        {
            a((u)j.get(j1));
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i1 != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        s s1 = a(0);
        if (s1.b() != null && !a.contains(Integer.valueOf(0)))
        {
            a.add(Integer.valueOf(0));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent.Operation.b, s1.b().b(), s1.b().c()));
        }
        if (viewgroup.b() == null || a.contains(Integer.valueOf(1))) goto _L3; else goto _L5
_L5:
        a.add(Integer.valueOf(1));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent.Operation.b, viewgroup.b().b(), viewgroup.b().c()));
        return view;
        if (viewgroup.b() == null || a.contains(Integer.valueOf(i1))) goto _L3; else goto _L6
_L6:
        a.add(Integer.valueOf(i1));
        com.cyberlink.youcammakeup.clflurry.b.a(new YMKLooksCategoryEvent(com.cyberlink.youcammakeup.clflurry.YMKLooksCategoryEvent.Operation.b, viewgroup.b().b(), viewgroup.b().c()));
        return view;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i1, int j1)
    {
        return false;
    }
}
