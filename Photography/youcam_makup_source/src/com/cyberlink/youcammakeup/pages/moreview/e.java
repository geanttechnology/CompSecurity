// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.BeautyTipCategoryActivity;
import com.cyberlink.youcammakeup.database.more.a.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.state.NewBadgeState;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.be;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bf;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bg;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            i, af

public class e extends ArrayAdapter
{

    public static float a = 1.0F;
    private String b;
    private Context c;
    private NetworkManager d;
    private long e;
    private boolean f;
    private Toast g;
    private Map h;
    private android.view.View.OnClickListener i;
    private int j;
    private long k;
    private int l;
    private boolean m;

    public e(Context context, long l1, List list, android.view.View.OnClickListener onclicklistener, boolean flag)
    {
        super(context, 0);
        b = com/cyberlink/youcammakeup/pages/moreview/e.getName();
        f = true;
        j = -1;
        j = 0;
        c = context;
        e = l1;
        i = onclicklistener;
        k = z.b(c, e, 0L);
        m = flag;
        if (list != null)
        {
            h = new HashMap();
            context = list.iterator();
            do
            {
                if (!context.hasNext())
                {
                    break;
                }
                onclicklistener = (b)context.next();
                Long long1 = Long.valueOf(onclicklistener.a());
                if (!h.containsKey(long1))
                {
                    h.put(long1, onclicklistener);
                }
            } while (true);
            j = list.size() + 1;
            addAll(list);
        } else
        {
            h = new HashMap();
        }
        d = Globals.d().w();
        if (d != null)
        {
            b();
        }
        l = 0;
    }

    static int a(e e1, int i1)
    {
        e1.j = i1;
        return i1;
    }

    static Toast a(e e1)
    {
        return e1.g;
    }

    static Toast a(e e1, Toast toast)
    {
        e1.g = toast;
        return toast;
    }

    private void a(b b1, i i1)
    {
        long l1 = i1.getFilmId();
        k k1 = new k(b1.a(), "beauty_tip_film", b1.f());
        d.a(k1, new l(i1, l1, b1) {

            final i a;
            final long b;
            final b c;
            final e d;

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
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
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
                d = e.this;
                a = i1;
                b = l1;
                c = b1;
                super();
            }
        });
    }

    static void a(e e1, String s)
    {
        e1.a(s);
    }

    private void a(i i1)
    {
        i1.a();
    }

    private void a(Long long1, i i1)
    {
        d.K().c(BeautyTipCategoryActivity.a, e);
        i1.a(false);
    }

    private void a(String s)
    {
        clear();
        Object obj = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
        if (obj != null)
        {
            if ((obj = ((Activity) (obj)).findViewById(0x7f0c01f2)) != null)
            {
                ((View) (obj)).setVisibility(0);
                com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.k, i, 0x7f0c01f2, s);
                return;
            }
        }
    }

    static boolean a(e e1, boolean flag)
    {
        e1.f = flag;
        return flag;
    }

    static Map b(e e1)
    {
        return e1.h;
    }

    private void b()
    {
        d.a(new bf(d, j, 15, e, m, k, new bg() {

            final e a;

            public void a(be be1)
            {
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
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
                            Collection collection;
label0:
                            {
                                if (a != null)
                                {
                                    collection = a.b();
                                    if (collection.size() != 0)
                                    {
                                        break label0;
                                    }
                                    com.cyberlink.youcammakeup.pages.moreview.e.a(c.a, false);
                                    if (c.a.getCount() == 0)
                                    {
                                        com.cyberlink.youcammakeup.pages.moreview.e.a(c.a, Toast.makeText(b, 0x7f070518, 0));
                                        com.cyberlink.youcammakeup.pages.moreview.e.a(c.a).setGravity(17, 0, 0);
                                        com.cyberlink.youcammakeup.pages.moreview.e.a(c.a).show();
                                    }
                                }
                                return;
                            }
                            Iterator iterator = collection.iterator();
                            do
                            {
                                if (!iterator.hasNext())
                                {
                                    break;
                                }
                                b b1 = (b)iterator.next();
                                Long long1 = Long.valueOf(b1.a());
                                if (long1 != null && com.cyberlink.youcammakeup.pages.moreview.e.b(c.a) != null && !com.cyberlink.youcammakeup.pages.moreview.e.b(c.a).containsKey(long1))
                                {
                                    com.cyberlink.youcammakeup.pages.moreview.e.b(c.a).put(long1, b1);
                                }
                            } while (true);
                            com.cyberlink.youcammakeup.pages.moreview.e.a(c.a, e.c(c.a) + collection.size() + 1);
                            c.a.addAll(collection);
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
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.k);
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
                            com.cyberlink.youcammakeup.pages.moreview.e.a(b.a, NetworkManager.a(a.a()));
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
                a = e.this;
                super();
            }
        }));
    }

    static int c(e e1)
    {
        return e1.j;
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
        com.cyberlink.youcammakeup.pages.moreview.af.b(BeautyTipCategoryActivity.a, e);
    }

    public View getView(int i1, View view, ViewGroup viewgroup)
    {
        long l1;
        long l2;
        if (view != null)
        {
            view = (i)view;
        } else
        {
            view = new i(c, 0, null);
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
            b();
        }
        return view;
    }

}
