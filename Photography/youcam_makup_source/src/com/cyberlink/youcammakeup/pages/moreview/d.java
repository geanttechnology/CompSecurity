// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.BeautyTipCategoryActivity;
import com.cyberlink.youcammakeup.activity.VideoPlaybackActivity;
import com.cyberlink.youcammakeup.clflurry.t;
import com.cyberlink.youcammakeup.database.more.a.b;
import com.cyberlink.youcammakeup.flurry.PopularityOfAllVideosEvent;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.be;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bf;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bg;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bm;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            g, af

public class d extends ArrayAdapter
{

    public static float a = 1.0F;
    private String b;
    private Context c;
    private NetworkManager d;
    private long e;
    private boolean f;
    private Toast g;
    private Map h;
    private List i;
    private android.view.View.OnClickListener j;
    private boolean k;
    private int l;
    private long m;
    private boolean n;
    private android.view.View.OnClickListener o;

    public d(Context context, long l1, boolean flag, android.view.View.OnClickListener onclicklistener)
    {
        super(context, 0);
        b = com/cyberlink/youcammakeup/pages/moreview/d.getName();
        f = true;
        i = null;
        k = true;
        o = new android.view.View.OnClickListener() {

            final d a;

            public void onClick(View view)
            {
                Long long1 = Long.valueOf(((g)view).getFilmId());
                if (!d.c(a).containsKey(long1)) goto _L2; else goto _L1
_L1:
                view = (b)d.c(a).get(long1);
                if (view == null) goto _L2; else goto _L3
_L3:
                com.cyberlink.youcammakeup.flurry.a.a(new PopularityOfAllVideosEvent(String.valueOf(long1.longValue())));
                d.i(a).a(new bm(d.i(a), long1.longValue()));
                if (view.b() == null || !view.b().equals("Youtube")) goto _L5; else goto _L4
_L4:
                StatusManager.j().a(d.d(a));
                StatusManager.j().a(view);
                Intent intent = new Intent(d.g(a), com/cyberlink/youcammakeup/activity/VideoPlaybackActivity);
                d.g(a).startActivity(intent);
_L8:
                com.cyberlink.youcammakeup.clflurry.b.a(new t(Long.toString(d.h(a)), Long.toString(view.a())));
                a.b();
_L2:
                return;
_L5:
                if (view == null || view.e() == null || view.e().getPath() == null) goto _L2; else goto _L6
_L6:
                Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(view.e().toString()));
                d.g(a).startActivity(intent1);
                if (true) goto _L8; else goto _L7
_L7:
            }

            
            {
                a = d.this;
                super();
            }
        };
        c = context;
        e = l1;
        j = onclicklistener;
        i = new ArrayList();
        d = Globals.d().w();
        k = flag;
        m = z.b(c, e, 0L);
        if (d != null)
        {
            a(k);
            b(true);
        }
        h = new HashMap();
        l = 0;
        n = false;
    }

    static long a(d d1, long l1)
    {
        d1.m = l1;
        return l1;
    }

    static Toast a(d d1, Toast toast)
    {
        d1.g = toast;
        return toast;
    }

    private void a(b b1, g g1)
    {
        long l1 = g1.getFilmId();
        k k1 = new k(b1.a(), "beauty_tip_film", b1.f());
        d.a(k1, new l(g1, l1, b1) {

            final g a;
            final long b;
            final b c;
            final d d;

            public void a(a a1)
            {
            }

            public void a(bn bn1)
            {
                if (bn1 == null);
            }

            public volatile void a(Object obj)
            {
                a((String)obj);
            }

            public void a(String s)
            {
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.j);
                if (activity == null)
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this, s) {

                        final String a;
                        final _cls2 b;

                        public void run()
                        {
                            if (b.a != null && Long.valueOf(b.a.getFilmId()).longValue() == b.b)
                            {
                                b.a.setTumbnail(a);
                                b.a.setDescription(b.c.c());
                            }
                        }

            
            {
                b = _pcls2;
                a = s;
                super();
            }
                    });
                    return;
                }
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

            public void d(Object obj)
            {
                a((a)obj);
            }

            
            {
                d = d.this;
                a = g1;
                b = l1;
                c = b1;
                super();
            }
        });
    }

    static void a(d d1, String s)
    {
        d1.a(s);
    }

    static void a(d d1, boolean flag)
    {
        d1.b(flag);
    }

    private void a(g g1)
    {
        g1.a();
        g1.b();
    }

    private void a(String s)
    {
        clear();
        com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.j, j, 0x7f0c008b, s);
    }

    private void a(boolean flag)
    {
        int i1 = getCount();
        d.a(new bf(d, i1 + 1, 16, e, flag, m, new bg() {

            final d a;

            public void a(be be1)
            {
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.j);
                if (activity == null)
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this, be1, activity) {

                        final be a;
                        final Activity b;
                        final _cls1 c;

                        public void run()
                        {
                            if (a != null && !com.cyberlink.youcammakeup.pages.moreview.d.a(c.a))
                            {
                                Collection collection = a.b();
                                if (collection.size() == 0)
                                {
                                    com.cyberlink.youcammakeup.pages.moreview.d.b(c.a, false);
                                    if (c.a.getCount() == 0)
                                    {
                                        com.cyberlink.youcammakeup.pages.moreview.d.a(c.a, Toast.makeText(b, 0x7f070518, 0));
                                        com.cyberlink.youcammakeup.pages.moreview.d.b(c.a).setGravity(17, 0, 0);
                                        com.cyberlink.youcammakeup.pages.moreview.d.b(c.a).show();
                                    }
                                } else
                                {
                                    b b1;
                                    for (Iterator iterator = collection.iterator(); iterator.hasNext(); d.d(c.a).add(b1))
                                    {
                                        b1 = (b)iterator.next();
                                        Long long1 = Long.valueOf(b1.a());
                                        if (d.c(c.a) != null && !d.c(c.a).containsKey(long1))
                                        {
                                            d.c(c.a).put(long1, b1);
                                        }
                                    }

                                    if (d.e(c.a) && d.f(c.a) != (long)a.a())
                                    {
                                        com.cyberlink.youcammakeup.pages.moreview.d.a(c.a, a.a());
                                        z.a(d.g(c.a), d.h(c.a), d.f(c.a));
                                    }
                                    c.a.addAll(collection);
                                }
                                com.cyberlink.youcammakeup.pages.moreview.d.a(c.a, false);
                            }
                        }

            
            {
                c = _pcls1;
                a = be1;
                b = activity;
                super();
            }
                    });
                    return;
                }
            }

            public void a(bn bn1)
            {
                if (bn1 == null);
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.j);
                if (activity == null)
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this, bn1) {

                        final bn a;
                        final _cls1 b;

                        public void run()
                        {
                            com.cyberlink.youcammakeup.pages.moreview.d.a(b.a, false);
                            com.cyberlink.youcammakeup.pages.moreview.d.a(b.a, NetworkManager.a(a.a()));
                        }

            
            {
                b = _pcls1;
                a = bn1;
                super();
            }
                    });
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((be)obj);
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
                a = d.this;
                super();
            }
        }));
    }

    static boolean a(d d1)
    {
        return d1.n;
    }

    static Toast b(d d1)
    {
        return d1.g;
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.j, 0x7f0c008a);
        } else
        if (!Boolean.valueOf(af.c(com.cyberlink.youcammakeup.Globals.ActivityType.j)).booleanValue())
        {
            af.d(com.cyberlink.youcammakeup.Globals.ActivityType.j);
            return;
        }
    }

    static boolean b(d d1, boolean flag)
    {
        d1.f = flag;
        return flag;
    }

    static Map c(d d1)
    {
        return d1.h;
    }

    static List d(d d1)
    {
        return d1.i;
    }

    static boolean e(d d1)
    {
        return d1.k;
    }

    static long f(d d1)
    {
        return d1.m;
    }

    static Context g(d d1)
    {
        return d1.c;
    }

    static long h(d d1)
    {
        return d1.e;
    }

    static NetworkManager i(d d1)
    {
        return d1.d;
    }

    public void a()
    {
        c = null;
        if (h != null)
        {
            h.clear();
            h = null;
        }
        if (g != null)
        {
            g.cancel();
            g = null;
        }
        n = true;
    }

    public void a(Long long1, g g1)
    {
        long l1 = d.K().c(BeautyTipCategoryActivity.a, e);
        boolean flag;
        if (long1.longValue() > l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g1.a(flag);
    }

    public void b()
    {
        com.cyberlink.youcammakeup.pages.moreview.af.b(BeautyTipCategoryActivity.a, e);
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        long l1;
        long l2;
        if (view != null)
        {
            view = (g)view;
        } else
        {
            view = new g(c, 0, null);
            view.setOnClickListener(o);
        }
        l1 = Long.valueOf(view.getFilmId()).longValue();
        l2 = ((b)getItem(i1)).a();
        if (l1 != l2)
        {
            view.setFilmId(l2);
            a(view);
            a((b)getItem(i1), view);
            a(Long.valueOf(l2), view);
        }
        if (f && i1 == getCount() - 1 && l != getCount())
        {
            l = getCount();
            a(false);
        }
        return view;
    }

}
