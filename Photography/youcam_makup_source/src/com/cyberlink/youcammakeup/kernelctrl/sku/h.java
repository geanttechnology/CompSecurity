// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.sku;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.database.more.i.c;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.database.more.i.e;
import com.cyberlink.youcammakeup.database.more.i.f;
import com.cyberlink.youcammakeup.kernelctrl.TestConfigHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.b;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ai;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.aj;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ak;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.al;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.am;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.ap;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.task.bn;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.av;
import com.cyberlink.youcammakeup.utility.bb;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.sku:
//            k, SkuInfo, i, j

public class h
{

    public static int a = 2;
    public static String b = "SkuManager";
    private List c;
    private List d;
    private List e;
    private Map f;
    private Map g;
    private Map h;
    private Map i;
    private List j;
    private Map k;
    private Map l;
    private List m;
    private boolean n;
    private boolean o;
    private ArrayList p;
    private am q = new am() {

        final h a;
        private int b;

        public void a(ak ak1)
        {
            com.cyberlink.youcammakeup.kernelctrl.z.c(Globals.d(), com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b());
            com.cyberlink.youcammakeup.kernelctrl.sku.k.a(com.cyberlink.youcammakeup.kernelctrl.sku.h.b(a));
            com.cyberlink.youcammakeup.kernelctrl.sku.h.a(a, ak1, true);
        }

        public void a(bn bn1)
        {
            if (b > 0)
            {
                b = b - 1;
                com.cyberlink.youcammakeup.kernelctrl.sku.h.a(a, com.cyberlink.youcammakeup.kernelctrl.sku.h.a(a));
            } else
            if (!NetworkManager.L())
            {
                Object obj = com.cyberlink.youcammakeup.h.w();
                long l1 = System.currentTimeMillis();
                bn1 = new ArrayList();
                Iterator iterator = com.cyberlink.youcammakeup.kernelctrl.sku.h.a(a).iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Collection collection = ((c) (obj)).a((String)iterator.next(), l1);
                    if (collection != null)
                    {
                        bn1.addAll(collection);
                    }
                } while (true);
                obj = new ak();
                ((ak) (obj)).a(bn1);
                com.cyberlink.youcammakeup.kernelctrl.sku.h.a(a, ((ak) (obj)), true);
                return;
            }
        }

        public volatile void a(Object obj)
        {
            a((ak)obj);
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
                a = h.this;
                super();
                b = com.cyberlink.youcammakeup.kernelctrl.sku.h.a;
            }
    };
    private aj r = new aj() {

        final h a;

        public void a(ak ak1)
        {
            com.cyberlink.youcammakeup.kernelctrl.sku.h.c(a).a(ak1);
        }

        public void a(bn bn1)
        {
            com.cyberlink.youcammakeup.kernelctrl.sku.h.c(a).b(bn1);
        }

        public volatile void a(Object obj)
        {
            a((ak)obj);
        }

        public void a(Void void1)
        {
            com.cyberlink.youcammakeup.kernelctrl.sku.h.c(a).c(void1);
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
                a = h.this;
                super();
            }
    };
    private boolean s;
    private JSONArray t;
    private String u;
    private Map v;
    private boolean w;
    private Map x;
    private List y;
    private List z;

    private h()
    {
        d = new ArrayList();
        e = new ArrayList();
        c = com.cyberlink.youcammakeup.kernelctrl.sku.k.a();
        f = new HashMap();
        g = new HashMap();
        h = null;
        i = null;
        m = null;
        j = new ArrayList();
        k = new HashMap();
        l = null;
        n = false;
        s = false;
        t = null;
        u = "";
        p = new ArrayList();
        x = new HashMap();
        y = new ArrayList();
        z = new ArrayList();
    }


    static List a(h h1)
    {
        return h1.d;
    }

    private void a(ak ak1, boolean flag)
    {
        Object obj;
        if (w)
        {
            flag = w;
        }
        w = flag;
        obj = ak1.a();
        ak1 = ak1.b();
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
                long l1 = System.currentTimeMillis();
                long l3 = d1.f();
                long l4 = d1.g();
                if (c() || l3 <= l1 && l4 >= l1)
                {
                    String s1 = d1.b();
                    long l2 = d1.a();
                    Object obj1 = (List)f.get(s1);
                    if (obj1 != null && !((List) (obj1)).contains(Long.valueOf(l2)))
                    {
                        ((List) (obj1)).add(Long.valueOf(l2));
                    }
                    obj1 = (Map)g.get(s1);
                    if (obj1 != null && !((Map) (obj1)).containsKey(Long.valueOf(l2)))
                    {
                        if (k == null)
                        {
                            k = new HashMap();
                        }
                        k.put(d1.d(), Long.valueOf(l2));
                        if (l == null)
                        {
                            l = new HashMap();
                        }
                        l.put(Long.valueOf(d1.a()), Pair.create(Long.valueOf(d1.f()), Long.valueOf(d1.g())));
                        if (!e.contains(s1))
                        {
                            e.add(s1);
                        }
                        ((Map) (obj1)).put(Long.valueOf(l2), new SkuInfo(d1, ak1.containsKey(Long.valueOf(l2)), (d)ak1.get(Long.valueOf(l2))));
                    }
                }
            }
        } while (true);
    }

    static void a(h h1, ak ak1, boolean flag)
    {
        h1.a(ak1, flag);
    }

    static void a(h h1, String s1)
    {
        h1.f(s1);
    }

    static void a(h h1, Collection collection)
    {
        h1.a(collection);
    }

    private void a(Collection collection)
    {
        NetworkManager networkmanager = Globals.d().w();
        if (y.size() > 0)
        {
            HashMap hashmap = new HashMap();
            for (collection = collection.iterator(); collection.hasNext(); hashmap.put((String)collection.next(), y)) { }
            networkmanager.a(new ai(networkmanager, hashmap, s, r));
            return;
        } else
        {
            networkmanager.a(new al(networkmanager, z, collection, o, s, q));
            return;
        }
    }

    private boolean a(long l1)
    {
        if (c())
        {
            return false;
        }
        long l2 = System.currentTimeMillis();
        Pair pair = (Pair)l.get(Long.valueOf(l1));
        boolean flag;
        if (pair != null)
        {
            if (((Long)pair.first).longValue() > l2 || ((Long)pair.second).longValue() < l2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = true;
        }
        return flag;
    }

    private boolean a(List list)
    {
        if (list != null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (c == null || c.size() != list.size())
        {
            return true;
        }
        HashMap hashmap = new HashMap();
        HashMap hashmap1 = new HashMap();
        for (int i1 = 0; i1 < c.size(); i1++)
        {
            f f1 = (f)list.get(i1);
            hashmap1.put(f1.a(), Long.valueOf(f1.b()));
            f1 = (f)c.get(i1);
            hashmap.put(f1.a(), Long.valueOf(f1.b()));
        }

        list = hashmap.keySet().iterator();
        String s1;
        do
        {
            if (!list.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s1 = (String)list.next();
        } while (((Long)hashmap.get(s1)).equals(hashmap1.get(s1)));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static h b()
    {
        h h1 = com.cyberlink.youcammakeup.kernelctrl.sku.i.a();
        if (!com.cyberlink.youcammakeup.kernelctrl.z.b(Globals.d(), "").equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()) && NetworkManager.L())
        {
            h1.h();
        }
        return h1;
    }

    static JSONArray b(h h1)
    {
        return h1.t;
    }

    static am c(h h1)
    {
        return h1.q;
    }

    public static boolean c()
    {
        boolean flag1 = Boolean.parseBoolean(Globals.d().getString(0x7f070739));
        boolean flag = flag1;
        if (TestConfigHelper.h().d())
        {
            flag = flag1;
            if (!flag1)
            {
                flag = TestConfigHelper.h().k();
            }
        }
        return flag;
    }

    static void d(h h1)
    {
        h1.g();
    }

    private void f(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (p.size() > 0)
        {
            for (Iterator iterator = p.iterator(); iterator.hasNext(); ((j)iterator.next()).a(s1)) { }
        }
        break MISSING_BLOCK_LABEL_52;
        s1;
        throw s1;
        this;
        JVM INSTR monitorexit ;
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        if (p.size() > 0)
        {
            for (Iterator iterator = p.iterator(); iterator.hasNext(); ((j)iterator.next()).a()) { }
        }
        break MISSING_BLOCK_LABEL_51;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    private void g(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (p.size() > 0)
        {
            for (Iterator iterator = p.iterator(); iterator.hasNext(); ((j)iterator.next()).b(s1)) { }
        }
        break MISSING_BLOCK_LABEL_52;
        s1;
        throw s1;
        this;
        JVM INSTR monitorexit ;
    }

    private Map h(String s1)
    {
        if (g == null || !g.containsKey(s1))
        {
            return null;
        } else
        {
            return (Map)g.get(s1);
        }
    }

    private void h()
    {
        if (d != null)
        {
            d.clear();
        }
        if (e != null)
        {
            e.clear();
        }
        if (f != null)
        {
            f.clear();
        }
        if (g != null)
        {
            for (Iterator iterator = g.entrySet().iterator(); iterator.hasNext();)
            {
                Iterator iterator1 = ((Map)((java.util.Map.Entry)iterator.next()).getValue()).entrySet().iterator();
                while (iterator1.hasNext()) 
                {
                    ((SkuInfo)((java.util.Map.Entry)iterator1.next()).getValue()).b();
                }
            }

            g.clear();
        }
        if (v != null)
        {
            v.clear();
            v = null;
        }
        if (h != null)
        {
            h.clear();
        }
        if (i != null)
        {
            i.clear();
        }
        if (m != null)
        {
            m.clear();
        }
        if (c != null)
        {
            c.clear();
        }
        n = false;
        w = false;
    }

    private void i()
    {
        List list = c;
        if (list != null)
        {
            for (int i1 = 0; i1 < list.size(); i1++)
            {
                String s1 = ((f)list.get(i1)).a();
                if (!d.contains(s1))
                {
                    d.add(s1);
                }
                if (!f.containsKey(s1))
                {
                    f.put(s1, new ArrayList());
                }
                if (!g.containsKey(s1))
                {
                    g.put(s1, new HashMap());
                }
            }

        }
        Object obj = com.cyberlink.youcammakeup.h.w();
        if (obj != null && list != null)
        {
            long l1 = System.currentTimeMillis();
            ArrayList arraylist = new ArrayList();
            Iterator iterator = d.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Collection collection = ((c) (obj)).a((String)iterator.next(), l1);
                if (collection != null)
                {
                    arraylist.addAll(collection);
                }
            } while (true);
            obj = new ak();
            ((ak) (obj)).a(arraylist);
            a(((ak) (obj)), true);
        }
    }

    private SkuInfo x(String s1, String s2)
    {
        if (k != null && g != null && k.containsKey(s2))
        {
            long l1 = ((Long)k.get(s2)).longValue();
            if (g.containsKey(s1) && !a(l1))
            {
                s1 = (Map)g.get(s1);
                if (s1 != null)
                {
                    s1 = (SkuInfo)s1.get(Long.valueOf(l1));
                } else
                {
                    s1 = null;
                }
                return s1;
            }
        }
        return null;
    }

    public d a(String s1, Long long1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!g.containsKey(s1))
        {
            break MISSING_BLOCK_LABEL_82;
        }
        s1 = (Map)g.get(s1);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = (SkuInfo)s1.get(long1);
_L3:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        boolean flag;
        s1 = s1.a();
        flag = a(s1.a());
        if (flag)
        {
            s1 = null;
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
          goto _L3
        s1;
        throw s1;
        s1 = null;
          goto _L4
    }

    public e a(String s1, Long long1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = b().a(s1, long1);
        if (s1 == null || s2 == null) goto _L2; else goto _L1
_L1:
        if (a(s1.a())) goto _L2; else goto _L3
_L3:
        long1 = s1.l().iterator();
_L6:
        if (!long1.hasNext()) goto _L2; else goto _L4
_L4:
        s1 = (e)long1.next();
        if (s1 == null) goto _L6; else goto _L5
_L5:
        boolean flag = s2.equals(s1.a());
        if (!flag) goto _L6; else goto _L7
_L7:
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
_L2:
        s1 = null;
        if (true) goto _L7; else goto _L8
_L8:
    }

    public e a(String s1, String s2, String s3)
    {
        Object obj1 = null;
        this;
        JVM INSTR monitorenter ;
        Object obj = obj1;
        if (g == null) goto _L2; else goto _L1
_L1:
        obj = k;
        if (obj != null) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((e) (obj));
_L4:
        s1 = (Map)g.get(s1);
        obj = obj1;
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s2 = (Long)k.get(s2);
        obj = obj1;
        if (s2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = (SkuInfo)s1.get(s2);
        obj = obj1;
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = s1.a();
        obj = obj1;
        if (s1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (a(s1.a()))
        {
            break; /* Loop/switch isn't completed */
        }
        s2 = s1.l().iterator();
        boolean flag;
        do
        {
            if (!s2.hasNext())
            {
                break; /* Loop/switch isn't completed */
            }
            s1 = (e)s2.next();
            flag = s1.a().equals(s3);
        } while (!flag);
_L6:
        obj = s1;
        if (true) goto _L2; else goto _L5
        s1;
        throw s1;
_L5:
        s1 = null;
          goto _L6
    }

    String a()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = u;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    void a(long l1, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!j.contains(Long.valueOf(l1)))
        {
            j.add(Long.valueOf(l1));
            g(s1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void a(ap ap1)
    {
        boolean flag1 = true;
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (14F != com.cyberlink.youcammakeup.kernelctrl.z.b(Globals.d(), 0.0F))
        {
            com.cyberlink.youcammakeup.kernelctrl.z.a(Globals.d(), 14F);
            com.cyberlink.youcammakeup.kernelctrl.z.g(Globals.d(), 0L);
        }
        obj = com.cyberlink.youcammakeup.kernelctrl.z.b(Globals.d(), "");
        boolean flag;
        long l1;
        boolean flag2;
        if (obj == "")
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!((String) (obj)).equals(com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b()))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        s = flag2;
        if (!NetworkManager.L()) goto _L2; else goto _L1
_L1:
        l1 = com.cyberlink.youcammakeup.kernelctrl.z.h(Globals.d(), 0L);
        if (System.currentTimeMillis() - l1 > 0x5265c00L || s) goto _L4; else goto _L3
_L3:
        w = true;
        i();
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        com.cyberlink.youcammakeup.kernelctrl.z.g(Globals.d(), System.currentTimeMillis());
_L2:
        if (ap1 == null)
        {
            break MISSING_BLOCK_LABEL_418;
        }
        obj = ap1.g();
_L13:
        o = a(((List) (obj)));
        int i1 = ((flag1) ? 1 : 0);
        if (!o)
        {
            if (s)
            {
                i1 = ((flag1) ? 1 : 0);
            } else
            {
                i1 = 0;
            }
        }
        if (i1 == 0) goto _L6; else goto _L5
_L5:
        h();
          goto _L6
_L12:
        for (; i1 < ((List) (obj)).size(); i1++)
        {
            String s1 = ((f)((List) (obj)).get(i1)).a();
            if (!d.contains(s1))
            {
                d.add(s1);
            }
            if (!f.containsKey(s1))
            {
                f.put(s1, new ArrayList());
            }
            if (!g.containsKey(s1))
            {
                g.put(s1, new HashMap());
            }
            break MISSING_BLOCK_LABEL_409;
        }

          goto _L7
_L10:
        obj = c;
        break; /* Loop/switch isn't completed */
_L7:
        if (obj == null || ap1 == null)
        {
            break MISSING_BLOCK_LABEL_353;
        }
        t = ap1.h();
        c = new LinkedList();
        c.addAll(((Collection) (obj)));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_367;
        }
        com.cyberlink.youcammakeup.kernelctrl.z.c(Globals.d(), com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b());
        if (d.size() > 0)
        {
            a(((Collection) (d)));
        }
          goto _L8
        ap1;
        throw ap1;
_L6:
        if (obj == null) goto _L10; else goto _L9
_L9:
        if (obj == null) goto _L7; else goto _L11
_L11:
        i1 = 0;
          goto _L12
        obj = null;
          goto _L13
    }

    public void a(j j1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!p.contains(j1))
        {
            p.add(j1);
            if (n)
            {
                (new Handler(Looper.getMainLooper())).post(new Runnable() {

                    final h a;

                    public void run()
                    {
                        com.cyberlink.youcammakeup.kernelctrl.sku.h.d(a);
                    }

            
            {
                a = h.this;
                super();
            }
                });
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        j1;
        throw j1;
    }

    public void a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        z.add(s1);
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    void a(String s1, long l1)
    {
        this;
        JVM INSTR monitorenter ;
        if (h == null)
        {
            h = new HashMap();
        }
        if (!h.containsKey(s1))
        {
            h.put(s1, new ArrayList());
        }
        ((List)h.get(s1)).add(Long.valueOf(l1));
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    void a(String s1, long l1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        if (i == null)
        {
            i = new HashMap();
        }
        if (!i.containsKey(s1))
        {
            i.put(s1, new ArrayList());
        }
        list = (List)i.get(s1);
        list.add(Long.valueOf(l1));
        f(s2);
        s2 = (List)f.get(s1);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        if (s2.size() == list.size())
        {
            e(s1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void a(String s1, String s2, j j1)
    {
        this;
        JVM INSTR monitorenter ;
        if (p.contains(j1)) goto _L2; else goto _L1
_L1:
        p.add(j1);
        if (!n) goto _L4; else goto _L3
_L3:
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final h a;

            public void run()
            {
                com.cyberlink.youcammakeup.kernelctrl.sku.h.d(a);
            }

            
            {
                a = h.this;
                super();
            }
        });
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (a(s1, s2))
        {
            u = null;
            (new Handler(Looper.getMainLooper())).post(new Runnable(s2) {

                final String a;
                final h b;

                public void run()
                {
                    com.cyberlink.youcammakeup.kernelctrl.sku.h.a(b, a);
                }

            
            {
                b = h.this;
                a = s1;
                super();
            }
            });
        }
        if (true) goto _L2; else goto _L5
_L5:
        s1;
        throw s1;
    }

    public boolean a(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        Map map = h;
        if (map != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        s2 = c(s2);
        if (s2 == null)
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if (!h.containsKey(s1))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        flag = ((List)h.get(s1)).contains(s2);
        if (flag)
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
        flag = false;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public boolean a(List list, ak ak1)
    {
        Object obj;
        obj = ak1.a();
        if (obj == null || ((Collection) (obj)).size() == 0)
        {
            return false;
        }
        obj = ((Collection) (obj)).iterator();
_L4:
        if (!((Iterator) (obj)).hasNext()) goto _L2; else goto _L1
_L1:
        d d1 = (d)((Iterator) (obj)).next();
        if (d1 == null) goto _L4; else goto _L3
_L3:
        long l1;
        long l2;
        long l3;
        l1 = System.currentTimeMillis();
        l2 = d1.f();
        l3 = d1.g();
        if (!c() && (l2 > l1 || l3 < l1) || a(d1.b(), Long.valueOf(d1.a())) != null) goto _L4; else goto _L5
_L5:
        boolean flag = false;
_L7:
        if (flag)
        {
            return false;
        }
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            String s1 = (String)list.next();
            if (!d.contains(s1))
            {
                d.add(s1);
            }
            if (!f.containsKey(s1))
            {
                f.put(s1, new ArrayList());
            }
            if (!g.containsKey(s1))
            {
                g.put(s1, new HashMap());
            }
        } while (true);
        com.cyberlink.youcammakeup.kernelctrl.z.c(Globals.d(), com.cyberlink.youcammakeup.kernelctrl.networkmanager.b.b());
        a(ak1, false);
        return true;
_L2:
        flag = true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public d b(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = a(s1, (Long)k.get(s2));
        this;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        throw s1;
    }

    public String b(String s1, String s2, String s3)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.a(s3);
        } else
        {
            return "";
        }
    }

    public List b(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Map map;
        arraylist = new ArrayList();
        map = h;
        if (map != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        if (h.containsKey(s1))
        {
            Object obj = (List)f.get(s1);
            s1 = (List)h.get(s1);
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                Long long1 = (Long)((Iterator) (obj)).next();
                if (s1.contains(long1) && !a(long1.longValue()))
                {
                    arraylist.add(long1);
                }
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public void b(j j1)
    {
        this;
        JVM INSTR monitorenter ;
        if (p.contains(j1))
        {
            p.remove(j1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        j1;
        throw j1;
    }

    public void b(String s1, String s2, j j1)
    {
        this;
        JVM INSTR monitorenter ;
        u = s2;
        if (a(s1, s2)) goto _L2; else goto _L1
_L1:
        Object obj = (Long)k.get(s2);
        if (!g.containsKey(s1)) goto _L2; else goto _L3
_L3:
        Map map = (Map)g.get(s1);
        if (map == null) goto _L5; else goto _L4
_L4:
        obj = (SkuInfo)map.get(obj);
_L8:
        if (obj == null) goto _L2; else goto _L6
_L6:
        ((SkuInfo) (obj)).r();
_L2:
        a(s1, s2, j1);
        this;
        JVM INSTR monitorexit ;
        return;
_L5:
        obj = null;
        if (true) goto _L8; else goto _L7
_L7:
        s1;
        throw s1;
    }

    public Long c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        Map map = k;
        if (map != null) goto _L2; else goto _L1
_L1:
        s1 = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = (Long)k.get(s1);
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String c(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.q();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String c(String s1, String s2, String s3)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.b(s3);
        } else
        {
            return "";
        }
    }

    public String d(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.m();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String d(String s1, String s2, String s3)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.c(s3);
        } else
        {
            return "";
        }
    }

    public List d(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        ArrayList arraylist;
        Object obj;
        arraylist = new ArrayList();
        obj = h(s1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj = ((Map) (obj)).values().iterator();
_L2:
        Object obj1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break MISSING_BLOCK_LABEL_157;
            }
            obj1 = (SkuInfo)((Iterator) (obj)).next();
        } while (obj1 == null);
        obj1 = ((SkuInfo) (obj1)).a();
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        if (((d) (obj1)).e() == null || ((d) (obj1)).m() == null || !a(s1, ((d) (obj1)).d())) goto _L2; else goto _L3
_L3:
        Pair pair = new Pair(((d) (obj1)).e(), ((d) (obj1)).m());
        if (!a(((d) (obj1)).a()) && !arraylist.contains(pair))
        {
            arraylist.add(pair);
        }
          goto _L2
        s1;
        throw s1;
        Collections.sort(arraylist, new Comparator() {

            final h a;

            public int a(Pair pair1, Pair pair2)
            {
                return ((String)pair1.first).compareTo((String)pair2.first);
            }

            public int compare(Object obj2, Object obj3)
            {
                return a((Pair)obj2, (Pair)obj3);
            }

            
            {
                a = h.this;
                super();
            }
        });
        this;
        JVM INSTR monitorexit ;
        return arraylist;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        if (!w)
        {
            i();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String e(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.n();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public void e()
    {
        this;
        JVM INSTR monitorenter ;
        com.cyberlink.youcammakeup.kernelctrl.z.g(Globals.d(), 0L);
        bb.b(new File((new StringBuilder()).append(com.cyberlink.youcammakeup.kernelctrl.networkmanager.a.a.b()).append(Globals.c).append("sku").toString()));
        com.cyberlink.youcammakeup.kernelctrl.sku.k.b();
        com.cyberlink.youcammakeup.h.w().a();
        h();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void e(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        if (m == null)
        {
            m = new ArrayList();
        }
        m.add(s1);
        if (e.size() == m.size())
        {
            n = true;
            g();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public boolean e(String s1, String s2, String s3)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.d(s3);
        } else
        {
            return false;
        }
    }

    public av f(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.o();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String f(String s1, String s2, String s3)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.e(s3);
        } else
        {
            return "";
        }
    }

    public Collection f()
    {
        this;
        JVM INSTR monitorenter ;
        List list = d;
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    public String g(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.p();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String h(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.h();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String i(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.i();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String j(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.j();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public av k(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.k();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public av l(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.l();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public boolean m(String s1, String s2)
    {
        if (k == null)
        {
            return true;
        }
        s1 = (Long)k.get(s1);
        if (s1 == null)
        {
            return true;
        }
        if (a(s2, s1) == null)
        {
            return true;
        }
        return a(a(s2, s1).a());
    }

    public String n(String s1, String s2)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.c();
        } else
        {
            return "";
        }
    }

    public String o(String s1, String s2)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.d();
        } else
        {
            return "";
        }
    }

    public String p(String s1, String s2)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.e();
        } else
        {
            return "";
        }
    }

    public String q(String s1, String s2)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.f();
        } else
        {
            return "";
        }
    }

    public String r(String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        s1 = x(s1, s2);
        if (s1 == null) goto _L2; else goto _L1
_L1:
        s1 = s1.g();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s1;
_L2:
        s1 = "";
        if (true) goto _L4; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public String s(String s1, String s2)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.s();
        } else
        {
            return "";
        }
    }

    public String t(String s1, String s2)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.t();
        } else
        {
            return "";
        }
    }

    public String u(String s1, String s2)
    {
        s1 = x(s1, s2);
        if (s1 != null)
        {
            return s1.u();
        } else
        {
            return "";
        }
    }

    public void v(String s1, String s2)
    {
        if (s1 == null || s2 == null)
        {
            return;
        }
        if (x == null)
        {
            x = new HashMap();
        }
        if (x.containsKey(s1))
        {
            x.remove(s1);
        }
        x.put(s1, s2);
    }

    public void w(String s1, String s2)
    {
        if (x.containsKey(s2)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((s1 = b(s1, s2)) != null)
        {
            s2 = URI.create((String)x.get(s2));
            s1 = s1.l().iterator();
            while (s1.hasNext()) 
            {
                ((e)s1.next()).a(s2);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

}
