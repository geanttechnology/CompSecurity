// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.MoreMakeupActivity;
import com.cyberlink.youcammakeup.database.more.makeup.MKCategoryV2Status;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.a;
import com.cyberlink.youcammakeup.database.more.makeup.b;
import com.cyberlink.youcammakeup.database.more.types.CategoryType;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.an;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.q;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.r;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.s;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.t;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.o;
import com.pf.common.utility.m;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            q, DownloadItemUtility, ad, r, 
//            b

public class ac
    implements com.cyberlink.youcammakeup.pages.moreview.q
{

    public static float a = 4F;
    protected static final String b = com/cyberlink/youcammakeup/pages/moreview/ac.getName();
    private NetworkManager c;
    private List d;
    private Map e;
    private MoreMakeupActivity f;
    private android.view.View.OnClickListener g;
    private Map h;
    private DownloadItemUtility i;
    private com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType j;
    private ArrayList k;

    public ac(MoreMakeupActivity moremakeupactivity, android.view.View.OnClickListener onclicklistener, com.cyberlink.youcammakeup.kernelctrl.MakeupItemTreeManager.DisplayMakeupType displaymakeuptype)
    {
        k = new ArrayList();
        f = moremakeupactivity;
        g = onclicklistener;
        d = new ArrayList();
        e = new HashMap();
        j = displaymakeuptype;
        c = Globals.d().w();
        if (c != null)
        {
            i = new DownloadItemUtility(this, null, com.cyberlink.youcammakeup.Globals.ActivityType.l, j);
            f();
        }
    }

    static List a(ac ac1)
    {
        return ac1.d;
    }

    static Map a(ac ac1, Map map)
    {
        ac1.h = map;
        return map;
    }

    private void a(Activity activity, String s1)
    {
        Globals.d().i().a(activity, com.cyberlink.youcammakeup.Globals.ActivityType.l, g, null, s1);
    }

    private void a(a a1, URI uri, ad ad1)
    {
        long l = ad1.b();
        uri = new k(a1.a(), "Makeup_Category", uri);
        c.a(uri, new l(ad1, l, a1) {

            final ad a;
            final long b;
            final a c;
            final ac d;

            public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a2)
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

            public void a(String s1)
            {
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l);
                if (activity == null || ac.c(d) == null)
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this, s1) {

                        final String a;
                        final _cls4 b;

                        public void run()
                        {
                            while (ac.c(b.d) == null || b.a == null || b.a.b() != b.b) 
                            {
                                return;
                            }
                            b.a.a(a);
                            b.a.b(b.c.b());
                            b.a.a(0xff000000);
                            ac.c(b.d).a(b.a.b(), b.a);
                        }

            
            {
                b = _pcls4;
                a = s1;
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
                a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
            }

            
            {
                d = ac.this;
                a = ad1;
                b = l1;
                c = a1;
                super();
            }
        });
    }

    static void a(ac ac1, Activity activity, String s1)
    {
        ac1.a(activity, s1);
    }

    static void a(ac ac1, a a1, URI uri, ad ad1)
    {
        ac1.a(a1, uri, ad1);
    }

    static void a(ac ac1, ad ad1)
    {
        ac1.a(ad1);
    }

    static void a(ac ac1, String s1, bn bn)
    {
        ac1.a(s1, bn);
    }

    private void a(ad ad1)
    {
        ad1.a();
        ad1.b("");
    }

    private void a(String s1, bn bn)
    {
        if (bn == null);
        s1 = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l);
        if (s1 == null)
        {
            return;
        } else
        {
            s1.runOnUiThread(new Runnable(s1, bn) {

                final Activity a;
                final bn b;
                final ac c;

                public void run()
                {
                    Globals.d().i().h(ac.c(c));
                    com.cyberlink.youcammakeup.pages.moreview.ac.a(c, a, NetworkManager.a(b.a()));
                }

            
            {
                c = ac.this;
                a = activity;
                b = bn1;
                super();
            }
            });
            return;
        }
    }

    static Map b(ac ac1)
    {
        return ac1.e;
    }

    static MoreMakeupActivity c(ac ac1)
    {
        return ac1.f;
    }

    static Map d(ac ac1)
    {
        return ac1.h;
    }

    static DownloadItemUtility e(ac ac1)
    {
        return ac1.i;
    }

    private void f()
    {
        Globals.d().i().b(f);
        c.a(new an(f, c, new ao() {

            final ac a;

            public void a(ap ap1)
            {
label0:
                {
                    Object obj = ap1.i().b();
                    int l = ((Collection) (obj)).size();
                    if (l > 0)
                    {
                        if (z.c(Globals.d(), "KEY_MAKEUP_CATEGORY_ALL", Long.valueOf(0L)).longValue() < ap1.c())
                        {
                            z.d(Globals.d(), "KEY_MAKEUP_CATEGORY_ALL", Long.valueOf(ap1.c()));
                        }
                        com.cyberlink.youcammakeup.pages.moreview.ac.a(a, new HashMap(l));
                        for (ap1 = ((Collection) (obj)).iterator(); ap1.hasNext(); ac.d(a).put(Long.valueOf(((b) (obj)).a()), obj))
                        {
                            obj = (b)ap1.next();
                        }

                        ap1 = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l);
                        if (ap1 != null)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                ap1.runOnUiThread(new Runnable(this) {

                    final _cls2 a;

                    public void run()
                    {
                        if (ac.c(a.a) == null)
                        {
                            return;
                        } else
                        {
                            Globals.d().i().h(ac.c(a.a));
                            com.cyberlink.youcammakeup.pages.moreview.ac.e(a.a).a(MakeupItemTreeManager.a);
                            return;
                        }
                    }

            
            {
                a = _pcls2;
                super();
            }
                });
            }

            public void a(bn bn1)
            {
                com.cyberlink.youcammakeup.pages.moreview.ac.a(a, "GetStatus", bn1);
            }

            public volatile void a(Object obj)
            {
                a((ap)obj);
            }

            public void a(Void void1)
            {
                void1 = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.l);
                if (void1 == null)
                {
                    return;
                } else
                {
                    void1.runOnUiThread(new Runnable(this) {

                        final _cls2 a;

                        public void run()
                        {
                            Globals.d().i().h(ac.c(a.a));
                        }

            
            {
                a = _pcls2;
                super();
            }
                    });
                    return;
                }
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
                a = ac.this;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

    public Context a()
    {
        return f;
    }

    public com.cyberlink.youcammakeup.database.more.a a(long l)
    {
        if (h != null && h.containsKey(Long.valueOf(l)))
        {
            return (com.cyberlink.youcammakeup.database.more.a)h.get(Long.valueOf(l));
        } else
        {
            return null;
        }
    }

    public void a(com.cyberlink.youcammakeup.pages.moreview.b b1)
    {
        k.add(b1);
    }

    public void a(List list)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext(); arraylist.add(((com.cyberlink.youcammakeup.pages.moreview.r)list.next()).a)) { }
        i.a(arraylist, new e() {

            final ac a;

            public volatile void a(Object obj)
            {
                a((List)obj);
            }

            public void a(List list1)
            {
                if (list1 == null || list1.size() == 0)
                {
                    return;
                }
                a a1;
                for (list1 = list1.iterator(); list1.hasNext(); com.cyberlink.youcammakeup.pages.moreview.ac.b(a).put(Long.valueOf(a1.a()), a1))
                {
                    a1 = (a)list1.next();
                    com.cyberlink.youcammakeup.pages.moreview.ac.a(a).add(Long.valueOf(a1.a()));
                }

                Globals.d(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        ac.c(a.a).o();
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
            }

            public void b(Object obj)
            {
                com.cyberlink.youcammakeup.pages.moreview.ac.a(a, "GetStatus", (bn)obj);
            }

            public void c(Object obj)
            {
                m.e(com.cyberlink.youcammakeup.pages.moreview.ac.b, obj.toString());
            }

            
            {
                a = ac.this;
                super();
            }
        });
    }

    public void a(Map map)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("makeupStore_category_natural", Long.valueOf(0x15ab1bL));
        hashmap.put("makeupStore_category_costume", Long.valueOf(0x15ab1cL));
        hashmap.put("makeupStore_category_eyeshadow", Long.valueOf(0x15ab16L));
        hashmap.put("makeupStore_category_eyeliner", Long.valueOf(0x15ab18L));
        hashmap.put("makeupStore_category_eyelash", Long.valueOf(0x15ab19L));
        hashmap.put("makeupStore_category_hair", Long.valueOf(0x15ab32L));
        hashmap.put("makeupStore_category_eyewear", Long.valueOf(0x15ab38L));
        hashmap.put("makeupStore_category_accessories", Long.valueOf(0x15ab37L));
        ArrayList arraylist = new ArrayList();
        arraylist.add("makeupStore_category_natural");
        arraylist.add("makeupStore_category_costume");
        arraylist.add("makeupStore_category_eyeshadow");
        arraylist.add("makeupStore_category_eyeliner");
        arraylist.add("makeupStore_category_eyelash");
        arraylist.add("makeupStore_category_hair");
        arraylist.add("makeupStore_category_eyewear");
        arraylist.add("makeupStore_category_accessories");
        c.a(new s(c, arraylist, new t(arraylist, hashmap, map) {

            final ArrayList a;
            final Map b;
            final Map c;
            final ac d;

            public void a(bn bn1)
            {
                com.cyberlink.youcammakeup.pages.moreview.ac.a(d, "GetDownloadItemTask", bn1);
            }

            public void a(q q1)
            {
                Globals.d(new Runnable(this, q1) {

                    final q a;
                    final _cls3 b;

                    public void run()
                    {
                        if (ac.c(b.d) != null)
                        {
                            Object obj = new ArrayList();
                            Map map = a.b();
                            for (Iterator iterator = b.a.iterator(); iterator.hasNext(); ((List) (obj)).add(map.get((String)iterator.next()))) { }
                            obj = ((List) (obj)).iterator();
                            while (((Iterator) (obj)).hasNext()) 
                            {
                                r r1 = (r)((Iterator) (obj)).next();
                                if (r1 != null && r1.a != null && r1.b != null)
                                {
                                    long l = ((Long)b.b.get(r1.a)).longValue();
                                    if ((a)com.cyberlink.youcammakeup.pages.moreview.ac.b(b.d).get(Long.valueOf(l)) == null && ac.c(b.d) != null)
                                    {
                                        ac.c(b.d).a(l, 8);
                                    } else
                                    {
                                        com.cyberlink.youcammakeup.pages.moreview.ac.a(b.d, (ad)b.c.get(Long.valueOf(l)));
                                        com.cyberlink.youcammakeup.pages.moreview.ac.a(b.d, (a)com.cyberlink.youcammakeup.pages.moreview.ac.b(b.d).get(Long.valueOf(l)), r1.b, (ad)b.c.get(Long.valueOf(l)));
                                    }
                                }
                            }
                        }
                    }

            
            {
                b = _pcls3;
                a = q1;
                super();
            }
                });
            }

            public volatile void a(Object obj)
            {
                a((q)obj);
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
                d = ac.this;
                a = arraylist;
                b = map;
                c = map1;
                super();
            }
        }), com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager.TaskPriority.b);
    }

    public long b()
    {
        return MakeupItemTreeManager.a;
    }

    public MakeupItemMetadata b(int l)
    {
        return null;
    }

    public void b(com.cyberlink.youcammakeup.pages.moreview.b b1)
    {
        if (k.contains(b1))
        {
            k.remove(b1);
        }
    }

    public void c()
    {
        f = null;
        if (d != null)
        {
            d.clear();
            d = null;
        }
        if (e != null)
        {
            e.clear();
            e = null;
        }
    }

    public CategoryType d()
    {
        return null;
    }

    public Map e()
    {
        return e;
    }

}
