// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.ai;
import com.cyberlink.youcammakeup.clflurry.aj;
import com.cyberlink.youcammakeup.database.more.f.b;
import com.cyberlink.youcammakeup.flurry.YMKNoticeItemClicksEvent;
import com.cyberlink.youcammakeup.flurry.YMKNoticeItemURLClicksEvent;
import com.cyberlink.youcammakeup.flurry.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aa;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.an;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aq;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bo;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            af, NoticeGridItemChild, NoticeGridItem

public class ah extends BaseExpandableListAdapter
{

    private Context a;
    private List b;
    private NetworkManager c;
    private Map d;
    private Handler e;
    private android.view.View.OnClickListener f;
    private boolean g;
    private boolean h;
    private int i;
    private long j;
    private boolean k;
    private boolean l;
    private aa m;
    private android.view.View.OnClickListener n;

    public ah(Context context, android.view.View.OnClickListener onclicklistener)
    {
        b = new ArrayList();
        g = true;
        h = false;
        l = false;
        m = new aa() {

            final ah a;

            public void a(bn bn1)
            {
                ah.d(a).post(new Runnable(this, bn1) {

                    final bn a;
                    final _cls2 b;

                    public void run()
                    {
                        ah.c(b.a);
                        com.cyberlink.youcammakeup.pages.moreview.ah.a(b.a, NetworkManager.a(a.a()));
                    }

            
            {
                b = _pcls2;
                a = bn1;
                super();
            }
                });
            }

            public void a(bo bo1)
            {
                ah.d(a).post(new Runnable(this, bo1) {

                    final bo a;
                    final _cls2 b;

                    public void run()
                    {
                        Collection collection = a.a();
                        b b1;
                        for (Iterator iterator = collection.iterator(); iterator.hasNext(); ah.f(b.a).put(Long.valueOf(b1.a()), b1))
                        {
                            b1 = (b)iterator.next();
                            long l1 = b1.a();
                            ah.e(b.a).add(Long.valueOf(l1));
                        }

                        ah ah1 = b.a;
                        boolean flag;
                        if (collection.size() > 0)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        ah.d(ah1, flag);
                        if (ah.g(b.a) && ah.h(b.a) != a.b())
                        {
                            com.cyberlink.youcammakeup.pages.moreview.ah.a(b.a, a.b());
                            com.cyberlink.youcammakeup.kernelctrl.z.e(com.cyberlink.youcammakeup.pages.moreview.ah.a(b.a), ah.h(b.a));
                            com.cyberlink.youcammakeup.pages.moreview.ah.b(b.a, false);
                        }
                        b.a.notifyDataSetChanged();
                        ah.c(b.a);
                    }

            
            {
                b = _pcls2;
                a = bo1;
                super();
            }
                });
            }

            public volatile void a(Object obj)
            {
                a((bo)obj);
            }

            public void a(Void void1)
            {
                ah.d(a).post(new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        ah.c(a.a);
                        com.cyberlink.youcammakeup.pages.moreview.ah.a(a.a, "");
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            public void b(Object obj)
            {
                a((bn)obj);
            }

            public void c(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = ah.this;
                super();
            }
        };
        n = new android.view.View.OnClickListener() {

            final ah a;

            public void onClick(View view)
            {
                view = (Integer)view.getTag();
                view = (b)a.getGroup(view.intValue());
                String s = view.f();
                com.cyberlink.youcammakeup.clflurry.b.a(new aj(view.a()));
                com.cyberlink.youcammakeup.flurry.a.a(new YMKNoticeItemURLClicksEvent(view.a()));
                com.cyberlink.youcammakeup.utility.a.b(s, Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.b), null);
            }

            
            {
                a = ah.this;
                super();
            }
        };
        a = context;
        e = new Handler();
        b = new ArrayList();
        c = Globals.d().w();
        d = new HashMap();
        f = onclicklistener;
        i = 0;
        j = 0L;
        k = true;
        if (c != null)
        {
            c.a(new an(a, c, new ao() {

                final ah a;

                public void a(ap ap1)
                {
                    com.cyberlink.youcammakeup.pages.moreview.ah.a(a, false);
                    long l1 = ap1.e().b();
                    if (Long.valueOf(com.cyberlink.youcammakeup.kernelctrl.z.d(com.cyberlink.youcammakeup.pages.moreview.ah.a(a), 0L)).longValue() < l1)
                    {
                        com.cyberlink.youcammakeup.pages.moreview.ah.a(a, true);
                        com.cyberlink.youcammakeup.kernelctrl.z.c(com.cyberlink.youcammakeup.pages.moreview.ah.a(a), l1);
                    }
                    if (!com.cyberlink.youcammakeup.pages.moreview.ah.b(a))
                    {
                        com.cyberlink.youcammakeup.pages.moreview.ah.b(a, false);
                        com.cyberlink.youcammakeup.pages.moreview.ah.a(a, com.cyberlink.youcammakeup.kernelctrl.z.f(com.cyberlink.youcammakeup.pages.moreview.ah.a(a), 0L));
                    }
                    ah.c(a, com.cyberlink.youcammakeup.pages.moreview.ah.b(a));
                }

                public void a(bn bn1)
                {
                    ah.d(a).post(new Runnable(this, bn1) {

                        final bn a;
                        final _cls1 b;

                        public void run()
                        {
                            ah.c(b.a);
                            com.cyberlink.youcammakeup.pages.moreview.ah.a(b.a, NetworkManager.a(a.a()));
                        }

            
            {
                b = _pcls1;
                a = bn1;
                super();
            }
                    });
                }

                public volatile void a(Object obj)
                {
                    a((ap)obj);
                }

                public void a(Void void1)
                {
                }

                public void b(Object obj)
                {
                    a((bn)obj);
                }

                public void c(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                a = ah.this;
                super();
            }
            }));
            b();
        }
    }

    static long a(ah ah1, long l1)
    {
        ah1.j = l1;
        return l1;
    }

    static Context a(ah ah1)
    {
        return ah1.a;
    }

    static void a(ah ah1, String s)
    {
        ah1.a(s);
    }

    private void a(String s)
    {
        a();
        com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.b, f, 0x7f0c0179, s);
    }

    private void a(boolean flag)
    {
        int i1 = b.size() + 1;
        if (l)
        {
            i1 = b.size();
        }
        c.a(new z(c, new Date(0L), i1, 15, flag, j, m));
    }

    static boolean a(ah ah1, boolean flag)
    {
        ah1.h = flag;
        return flag;
    }

    private void b()
    {
        com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.b, 0x7f0c0174);
    }

    static boolean b(ah ah1)
    {
        return ah1.h;
    }

    static boolean b(ah ah1, boolean flag)
    {
        ah1.k = flag;
        return flag;
    }

    private void c()
    {
        if (!Boolean.valueOf(af.c(com.cyberlink.youcammakeup.Globals.ActivityType.b)).booleanValue())
        {
            af.d(com.cyberlink.youcammakeup.Globals.ActivityType.b);
        }
    }

    static void c(ah ah1)
    {
        ah1.c();
    }

    static void c(ah ah1, boolean flag)
    {
        ah1.a(flag);
    }

    static Handler d(ah ah1)
    {
        return ah1.e;
    }

    static boolean d(ah ah1, boolean flag)
    {
        ah1.g = flag;
        return flag;
    }

    static List e(ah ah1)
    {
        return ah1.b;
    }

    static Map f(ah ah1)
    {
        return ah1.d;
    }

    static boolean g(ah ah1)
    {
        return ah1.k;
    }

    static long h(ah ah1)
    {
        return ah1.j;
    }

    public void a()
    {
        b.clear();
        notifyDataSetChanged();
    }

    public Object getChild(int i1, int j1)
    {
        return getGroup(i1);
    }

    public long getChildId(int i1, int j1)
    {
        return 0L;
    }

    public View getChildView(int i1, int j1, boolean flag, View view, ViewGroup viewgroup)
    {
        viewgroup = (b)getChild(i1, j1);
        if (view != null)
        {
            view = (NoticeGridItemChild)view;
        } else
        {
            view = new NoticeGridItemChild(a);
            view.setActionOnclickListener(n);
        }
        view.setTag(Integer.valueOf(i1));
        view.setFeatureDescription(viewgroup.c());
        view.setActionName(viewgroup.e());
        view.a(true);
        return view;
    }

    public int getChildrenCount(int i1)
    {
        return 1;
    }

    public Object getGroup(int i1)
    {
        long l1 = getGroupId(i1);
        if (d.containsKey(Long.valueOf(l1)))
        {
            return d.get(Long.valueOf(l1));
        } else
        {
            return null;
        }
    }

    public int getGroupCount()
    {
        return b.size();
    }

    public long getGroupId(int i1)
    {
        return ((Long)b.get(i1)).longValue();
    }

    public View getGroupView(int i1, boolean flag, View view, ViewGroup viewgroup)
    {
        viewgroup = (b)getGroup(i1);
        long l1 = getGroupId(i1);
        int j1;
        long l2;
        if (view != null)
        {
            view = (NoticeGridItem)view;
        } else
        {
            view = new NoticeGridItem(a);
        }
        view.setTag(Integer.valueOf(i1));
        l2 = c.K().b(com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState.BadgeViewType.a);
        if (Long.valueOf(l1).longValue() > l2)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 != 0)
        {
            j1 = 0;
        } else
        {
            j1 = 4;
        }
        view.setNewIconVisibility(j1);
        if (viewgroup != null)
        {
            view.setFeature(viewgroup.b());
            view.setDate(viewgroup.d().toString());
        }
        if (g && i1 >= getGroupCount() - 1 && i != getGroupCount())
        {
            i = getGroupCount();
            if (!l || i1 != 0)
            {
                a(false);
            }
        }
        if (flag)
        {
            view.b();
            return view;
        } else
        {
            view.c();
            return view;
        }
    }

    public boolean hasStableIds()
    {
        return false;
    }

    public boolean isChildSelectable(int i1, int j1)
    {
        return false;
    }

    public void onGroupExpanded(int i1)
    {
        long l1 = getGroupId(i1);
        if (d != null)
        {
            b b1 = (b)d.get(Long.valueOf(l1));
            if (b1 != null)
            {
                long l2 = b1.a();
                com.cyberlink.youcammakeup.clflurry.b.a(new ai(l2));
                com.cyberlink.youcammakeup.flurry.a.a(new YMKNoticeItemClicksEvent(l2));
            }
        }
    }
}
