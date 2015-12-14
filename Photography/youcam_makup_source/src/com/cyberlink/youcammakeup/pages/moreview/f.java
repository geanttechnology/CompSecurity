// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.a;
import com.cyberlink.youcammakeup.database.more.a.d;
import com.cyberlink.youcammakeup.database.more.a.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.k;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.l;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.an;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ao;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bb;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bc;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bd;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            a, j, BeautyCategoryItem, af

public class f extends com.cyberlink.youcammakeup.pages.moreview.a
{

    public static float c = 1.0F;
    private static final String e = com/cyberlink/youcammakeup/pages/moreview/f.getName();
    protected Map d;
    private NetworkManager f;
    private Collection g;
    private Map h;
    private Map i;
    private Context j;
    private android.view.View.OnClickListener k;
    private boolean l;
    private int m;

    public f(Context context, android.view.View.OnClickListener onclicklistener)
    {
        j = context;
        k = onclicklistener;
        g = new ArrayList();
        h = new HashMap();
        l = true;
        a = new HashMap();
        d = new HashMap();
        context = URI.create("http://app.cyberlink.com/ymk/banner_hot.jpg");
        d.put(context, Integer.valueOf(0x7f02001b));
        context = URI.create("http://app.cyberlink.com/ymk/banner_new.jpg");
        d.put(context, Integer.valueOf(0x7f02001c));
        context = URI.create("http://app.cyberlink.com/ymk/banner_summer.jpg");
        d.put(context, Integer.valueOf(0x7f02001e));
        context = URI.create("http://app.cyberlink.com/ymk/banner_celebrity.jpg");
        d.put(context, Integer.valueOf(0x7f020019));
        context = URI.create("http://app.cyberlink.com/ymk/banner_work.jpg");
        d.put(context, Integer.valueOf(0x7f02001f));
        context = URI.create("http://app.cyberlink.com/ymk/banner_date.jpg");
        d.put(context, Integer.valueOf(0x7f02001a));
        context = URI.create("http://app.cyberlink.com/ymk/banner_party.jpg");
        d.put(context, Integer.valueOf(0x7f02001d));
        g();
        f = Globals.d().w();
        if (f != null)
        {
            h();
            b(true);
        }
    }

    static int a(f f1, int i1)
    {
        f1.m = i1;
        return i1;
    }

    static Context a(f f1)
    {
        return f1.j;
    }

    private j a(d d1)
    {
        return new j(d1.c(), d1.e(), d1.b(), d1.f());
    }

    static j a(f f1, d d1)
    {
        return f1.a(d1);
    }

    static Map a(f f1, Map map)
    {
        f1.i = map;
        return map;
    }

    private void a(d d1, BeautyCategoryItem beautycategoryitem)
    {
        long l1 = beautycategoryitem.getCategoryItemId();
        URI uri = d1.d();
        if (d != null && d.containsKey(uri) && beautycategoryitem != null && beautycategoryitem.getCategoryItemId() == l1)
        {
            beautycategoryitem.setThumbnail(((Integer)d.get(uri)).intValue());
            beautycategoryitem.setCategoryName(d1.b());
            beautycategoryitem.a(0x99000000, 1.0F, 2.0F, 5F);
            return;
        } else
        {
            k k1 = new k(d1.a(), "beauty_tip_category", d1.d());
            f.a(k1, new l(beautycategoryitem, l1, d1) {

                final BeautyCategoryItem a;
                final long b;
                final d c;
                final f d;

                public void a(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a a1)
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
                    Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.i);
                    if (activity == null)
                    {
                        return;
                    } else
                    {
                        activity.runOnUiThread(new Runnable(this, s) {

                            final String a;
                            final _cls3 b;

                            public void run()
                            {
                                if (b.a != null && b.a.getCategoryItemId() == b.b)
                                {
                                    b.a.setThumbnail(a);
                                    b.a.setCategoryName(b.c.b());
                                    b.a.a(0x99000000, 1.0F, 2.0F, 5F);
                                }
                            }

            
            {
                b = _pcls3;
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
                    a((com.cyberlink.youcammakeup.kernelctrl.networkmanager.a)obj);
                }

            
            {
                d = f.this;
                a = beautycategoryitem;
                b = l1;
                c = d1;
                super();
            }
            });
            return;
        }
    }

    private void a(BeautyCategoryItem beautycategoryitem)
    {
        beautycategoryitem.a();
        beautycategoryitem.setCategoryName("");
    }

    static void a(f f1, String s)
    {
        f1.a(s);
    }

    static void a(f f1, boolean flag)
    {
        f1.a(flag);
    }

    private void a(String s)
    {
        com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.i, k, 0x7f0c0084, s);
    }

    private void a(boolean flag)
    {
        f.a(new bc(f, 1, m, flag, new bd() {

            final f a;

            public void a(bb bb1)
            {
                f.c(a).clear();
                a.a.clear();
                com.cyberlink.youcammakeup.pages.moreview.f.d(a).clear();
                bb1 = bb1.a().iterator();
                do
                {
                    if (!bb1.hasNext())
                    {
                        break;
                    }
                    d d1 = (d)bb1.next();
                    Long long1 = Long.valueOf(d1.a());
                    if (f.c(a) != null)
                    {
                        f.c(a).put(long1, d1);
                        a.a.put(long1, com.cyberlink.youcammakeup.pages.moreview.f.a(a, d1));
                    }
                    if (com.cyberlink.youcammakeup.pages.moreview.f.d(a) != null && !com.cyberlink.youcammakeup.pages.moreview.f.d(a).contains(long1))
                    {
                        com.cyberlink.youcammakeup.pages.moreview.f.d(a).add(long1);
                    }
                } while (true);
                f.c(a, false);
                if (f.c(a) != null)
                {
                    a.a();
                }
                f.b(a, false);
            }

            public void a(bn bn1)
            {
                if (bn1 == null);
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.i);
                if (activity == null)
                {
                    return;
                } else
                {
                    activity.runOnUiThread(new Runnable(this, bn1) {

                        final bn a;
                        final _cls2 b;

                        public void run()
                        {
                            f.b(b.a, false);
                            com.cyberlink.youcammakeup.pages.moreview.f.a(b.a, NetworkManager.a(a.a()));
                        }

            
            {
                b = _pcls2;
                a = bn1;
                super();
            }
                    });
                    return;
                }
            }

            public volatile void a(Object obj)
            {
                a((bb)obj);
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
                a = f.this;
                super();
            }
        }));
    }

    static Map b(f f1)
    {
        return f1.i;
    }

    static void b(f f1, boolean flag)
    {
        f1.b(flag);
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            com.cyberlink.youcammakeup.pages.moreview.af.a(com.cyberlink.youcammakeup.Globals.ActivityType.i, 0x7f0c0083);
        } else
        if (!Boolean.valueOf(af.c(com.cyberlink.youcammakeup.Globals.ActivityType.i)).booleanValue())
        {
            com.cyberlink.youcammakeup.pages.moreview.af.d(com.cyberlink.youcammakeup.Globals.ActivityType.i);
            return;
        }
    }

    static Map c(f f1)
    {
        return f1.h;
    }

    static boolean c(f f1, boolean flag)
    {
        f1.l = flag;
        return flag;
    }

    static Collection d(f f1)
    {
        return f1.g;
    }

    private void g()
    {
        boolean flag = false;
        int j1 = z.b(j, 0);
        e e1;
        JSONArray jsonarray;
        d d1;
        int i1;
        try
        {
            i1 = j.getPackageManager().getPackageInfo(j.getPackageName(), 0).versionCode;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
            i1 = 0;
        }
        if (j1 == i1) goto _L2; else goto _L1
_L1:
        z.a(j, i1);
        e1 = com.cyberlink.youcammakeup.h.s();
        jsonarray = (new JSONObject("{\"status\":\"OK\",\"categoryList\":[{\"categoryId\":20003,\"name\":\"Hot Makeups\",\"longName\":\"Hot Makeups\",\"coverImgURL\":\"http://app.cyberlink.com/ymk/banner_hot.jpg\",\"x\":37,\"y\":37,\"w\":1006,\"h\":540,\"textX\":62,\"textY\":62,\"textW\":955,\"textH\":93},{\"categoryId\":20004,\"name\":\"New\",\"longName\":\"New Makeups\",\"coverImgURL\":\"http://app.cyberlink.com/ymk/banner_new.jpg\",\"x\":37,\"y\":603,\"w\":488,\"h\":360,\"textX\":62,\"textY\":628,\"textW\":437,\"textH\":76},{\"categoryId\":20005,\"name\":\"Summer\",\"longName\":\"Summer Makeups\",\"coverImgURL\":\"http://app.cyberlink.com/ymk/banner_summer.jpg\",\"x\":555,\"y\":603,\"w\":488,\"h\":360,\"textX\":580,\"textY\":628,\"textW\":437,\"textH\":76},{\"categoryId\":20006,\"name\":\"Celebrity\",\"longName\":\"Celebrity Makeups\",\"coverImgURL\":\"http://app.cyberlink.com/ymk/banner_celebrity.jpg\",\"x\":37,\"y\":998,\"w\":488,\"h\":360,\"textX\":62,\"textY\":1023,\"textW\":437,\"textH\":76},{\"categoryId\":20007,\"name\":\"Work\",\"longName\":\"Makeups for Work\",\"coverImgURL\":\"http://app.cyberlink.com/ymk/banner_work.jpg\",\"x\":555,\"y\":998,\"w\":488,\"h\":360,\"textX\":580,\"textY\":1023,\"textW\":437,\"textH\":76},{\"categoryId\":20008,\"name\":\"Dating\",\"longName\":\"Makeups for Dating\",\"coverImgURL\":\"http://app.cyberlink.com/ymk/banner_date.jpg\",\"x\":37,\"y\":1391,\"w\":488,\"h\":360,\"textX\":62,\"textY\":1416,\"textW\":437,\"textH\":76},{\"categoryId\":20009,\"name\":\"Party\",\"longName\":\"Makeups for Party\",\"coverImgURL\":\"http://app.cyberlink.com/ymk/banner_party.jpg\",\"x\":555,\"y\":1391,\"w\":488,\"h\":360,\"textX\":580,\"textY\":1416,\"textW\":437,\"textH\":76}],\"totalCount\":7}")).getJSONArray("categoryList");
        j1 = jsonarray.length();
        i1 = ((flag) ? 1 : 0);
_L3:
        if (i1 >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        d1 = new d((JSONObject)jsonarray.get(i1));
        e1.a(i1 + 1, d1);
        i1++;
        if (true) goto _L3; else goto _L2
        Exception exception;
        exception;
_L2:
    }

    private void h()
    {
        f.a(new an(j, f, new ao() {

            final f a;

            public void a(ap ap1)
            {
                Object obj = ap1.b();
                int i1 = ((Collection) (obj)).size();
                if (i1 > 0)
                {
                    boolean flag = false;
                    if (z.a(com.cyberlink.youcammakeup.pages.moreview.f.a(a), "KEY_BEAUTY_CATEGORY_ALL", Long.valueOf(0L)).longValue() < ap1.c())
                    {
                        flag = true;
                        z.b(com.cyberlink.youcammakeup.pages.moreview.f.a(a), "KEY_BEAUTY_CATEGORY_ALL", Long.valueOf(ap1.c()));
                    }
                    com.cyberlink.youcammakeup.pages.moreview.f.a(a, new HashMap(i1));
                    for (ap1 = ((Collection) (obj)).iterator(); ap1.hasNext(); f.b(a).put(Long.valueOf(((com.cyberlink.youcammakeup.database.more.a.a) (obj)).a()), obj))
                    {
                        obj = (com.cyberlink.youcammakeup.database.more.a.a)ap1.next();
                    }

                    com.cyberlink.youcammakeup.pages.moreview.f.a(a, i1);
                    com.cyberlink.youcammakeup.pages.moreview.f.a(a, flag);
                }
            }

            public void a(bn bn1)
            {
                if (bn1 == null);
                Activity activity = Globals.d().a(com.cyberlink.youcammakeup.Globals.ActivityType.i);
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
                            f.b(b.a, false);
                            com.cyberlink.youcammakeup.pages.moreview.f.a(b.a, NetworkManager.a(a.a()));
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
                a = f.this;
                super();
            }
        }));
    }

    public a a(long l1)
    {
        if (i != null && i.containsKey(Long.valueOf(l1)))
        {
            return (a)i.get(Long.valueOf(l1));
        } else
        {
            return null;
        }
    }

    public BeautyCategoryItem a(int i1)
    {
        if (g == null || g.size() < i1)
        {
            return null;
        }
        Object obj = (Long)((ArrayList)g).get(i1);
        if (h == null || !h.containsKey(obj))
        {
            return null;
        } else
        {
            BeautyCategoryItem beautycategoryitem = new BeautyCategoryItem(j);
            obj = (d)h.get(obj);
            a(beautycategoryitem);
            beautycategoryitem.setCategoryItemId(((d) (obj)).a());
            a(((d) (obj)), beautycategoryitem);
            return beautycategoryitem;
        }
    }

    public void b()
    {
        j = null;
        if (h != null)
        {
            h.clear();
            h = null;
        }
        if (g != null)
        {
            g.clear();
            g = null;
        }
        if (a != null)
        {
            a.clear();
            a = null;
        }
    }

    public int c()
    {
        if (h == null)
        {
            return 0;
        } else
        {
            return h.size();
        }
    }

    public Map d()
    {
        return a;
    }

    public Collection e()
    {
        return g;
    }

    public void f()
    {
        Object obj = com.cyberlink.youcammakeup.h.s().a();
        if (obj != null)
        {
            obj = ((Collection) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                d d1 = (d)((Iterator) (obj)).next();
                if (d1 != null)
                {
                    h.put(Long.valueOf(d1.a()), d1);
                    a.put(Long.valueOf(d1.a()), a(d1));
                    g.add(Long.valueOf(d1.a()));
                }
            } while (true);
            l = false;
            a();
        }
    }

}
