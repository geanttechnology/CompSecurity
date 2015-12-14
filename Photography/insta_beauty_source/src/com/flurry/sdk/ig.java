// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            kk, is, it, if, 
//            jx, lk, ll, kg, 
//            kc, jz, js, ie, 
//            hr, hq, ht, hw, 
//            hx, in, lt, ir, 
//            ij, je, im, jf, 
//            jq, kn, kx, hs, 
//            lq, jt, jo, hv, 
//            hp, hu, jn, jj, 
//            hz, hy, ic, io, 
//            id, ii, kb

public class ig
    implements ll.a
{

    private static final String a = com/flurry/sdk/ig.getSimpleName();
    private static String b = "https://proton.flurry.com/sdk/v1/config";
    private final Runnable c = new _cls1();
    private final kb d = new _cls4();
    private final kb e = new _cls5();
    private final kb f = new _cls6();
    private final kk g = new kk("proton config request", new is());
    private final kk h = new kk("proton config response", new it());
    private jz i;
    private jz j;
    private final if k = new if();
    private final jx l = new jx();
    private final List m = new ArrayList();
    private boolean n;
    private String o;
    private boolean p;
    private boolean q;
    private long r;
    private long s;
    private boolean t;
    private ht u;
    private boolean v;

    public ig()
    {
        p = true;
        r = 10000L;
        lk lk1 = lk.a();
        n = ((Boolean)lk1.a("ProtonEnabled")).booleanValue();
        lk1.a("ProtonEnabled", this);
        kg.a(4, a, (new StringBuilder()).append("initSettings, protonEnabled = ").append(n).toString());
        o = (String)lk1.a("ProtonConfigUrl");
        lk1.a("ProtonConfigUrl", this);
        kg.a(4, a, (new StringBuilder()).append("initSettings, protonConfigUrl = ").append(o).toString());
        p = ((Boolean)lk1.a("analyticsEnabled")).booleanValue();
        lk1.a("analyticsEnabled", this);
        kg.a(4, a, (new StringBuilder()).append("initSettings, AnalyticsEnabled = ").append(p).toString());
        kc.a().a("com.flurry.android.sdk.IdProviderFinishedEvent", d);
        kc.a().a("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", e);
        kc.a().a("com.flurry.android.sdk.NetworkStateEvent", f);
        i = new jz(js.a().c().getFileStreamPath(o()), ".yflurryprotonconfig.", 1, new _cls7());
        j = new jz(js.a().c().getFileStreamPath(p()), ".yflurryprotonreport.", 1, new _cls8());
        js.a().b(new _cls9());
        js.a().b(new _cls10());
    }

    static long a(ig ig1, long l1)
    {
        ig1.r = l1;
        return l1;
    }

    private void a(long l1, boolean flag, byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        if (abyte0 != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kg.a(4, a, "Saving proton config response");
        ie ie1 = new ie();
        ie1.a(l1);
        ie1.a(flag);
        ie1.a(abyte0);
        i.a(ie1);
        if (true) goto _L1; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }

    static void a(ig ig1)
    {
        ig1.g();
    }

    static void a(ig ig1, long l1, boolean flag, byte abyte0[])
    {
        ig1.a(l1, flag, abyte0);
    }

    static void a(ig ig1, String s1, Map map)
    {
        ig1.b(s1, map);
    }

    private boolean a(hr hr1)
    {
        if (hr1 == null)
        {
            return true;
        }
        if (hr1.a == null)
        {
            return true;
        }
        for (int i1 = 0; i1 < hr1.a.size(); i1++)
        {
            hq hq1 = (hq)hr1.a.get(i1);
            if (hq1 != null && (hq1.b.equals("") || hq1.a == -1L || hq1.e.equals("") || !a(hq1.c)))
            {
                kg.a(3, a, "A callback template is missing required values");
                return false;
            }
        }

        return true;
    }

    private boolean a(ht ht1)
    {
        if (ht1 == null)
        {
            return false;
        }
        if (!a(ht1.e) || ht1.e.e.equals(""))
        {
            kg.a(3, a, "Config response is missing required values.");
            return false;
        } else
        {
            return true;
        }
    }

    static boolean a(ig ig1, ht ht1)
    {
        return ig1.a(ht1);
    }

    static boolean a(ig ig1, boolean flag)
    {
        ig1.t = flag;
        return flag;
    }

    private boolean a(List list)
    {
        if (list == null)
        {
            return true;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            hw hw1 = (hw)list.next();
            if (hw1.a.equals(""))
            {
                kg.a(3, a, "An event is missing a name");
                return false;
            }
            if ((hw1 instanceof hx) && ((hx)hw1).c.equals(""))
            {
                kg.a(3, a, "An event trigger is missing a param name");
                return false;
            }
        }

        return true;
    }

    static long b(ig ig1, long l1)
    {
        ig1.s = l1;
        return l1;
    }

    static ht b(ig ig1, ht ht1)
    {
        ig1.u = ht1;
        return ht1;
    }

    private void b(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = m.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (l1 == ((in)iterator.next()).b())
            {
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_52;
        Exception exception;
        exception;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    static void b(ig ig1)
    {
        ig1.j();
    }

    private void b(String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        kg.a(3, a, (new StringBuilder()).append("Event triggered: ").append(s1).toString());
        if (p) goto _L2; else goto _L1
_L1:
        kg.e(a, "Analytics and pulse have been disabled.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (u != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        kg.a(3, a, "Config response is empty. No events to fire.");
          goto _L3
        s1;
        throw s1;
        lt.b();
        if (TextUtils.isEmpty(s1)) goto _L3; else goto _L4
_L4:
        Object obj = l.a(s1);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        kg.a(3, a, "No events to fire. Returning.");
          goto _L3
label0:
        {
            if (((List) (obj)).size() != 0)
            {
                break label0;
            }
            kg.a(3, a, "No events to fire. Returning.");
        }
          goto _L3
        long l1 = System.currentTimeMillis();
        int i1;
        ir ir1;
        HashMap hashmap;
        Iterator iterator;
        String as[];
        hq hq1;
        String s2;
        HashMap hashmap1;
        byte byte0;
        long l2;
        boolean flag;
        if (map != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 831
    //                   645204782: 334
    //                   1371447545: 350
    //                   1579613685: 318;
           goto _L5 _L6 _L7 _L8
_L32:
        ir1 = ir.d;
_L18:
        hashmap = new HashMap();
        iterator = ((List) (obj)).iterator();
_L17:
        if (!iterator.hasNext()) goto _L10; else goto _L9
_L9:
        obj = (hw)iterator.next();
        byte0 = 0;
        if (!(obj instanceof hx)) goto _L12; else goto _L11
_L11:
        kg.a(4, a, "Event contains triggers.");
        as = ((hx)obj).d;
        if (as != null) goto _L14; else goto _L13
_L13:
        kg.a(4, a, "Template does not contain trigger values. Firing.");
        byte0 = 1;
_L19:
        s2 = (String)map.get(((hx)obj).c);
        if (s2 != null) goto _L16; else goto _L15
_L15:
        kg.a(4, a, "Publisher params has no value associated with proton key. Not firing.");
          goto _L17
_L8:
        if (s1.equals("flurry.session_start"))
        {
            byte0 = 0;
        }
          goto _L5
_L6:
        if (s1.equals("flurry.session_end"))
        {
            byte0 = 1;
        }
          goto _L5
_L7:
        if (s1.equals("flurry.app_install"))
        {
            byte0 = 2;
        }
          goto _L5
_L33:
        ir1 = ir.b;
          goto _L18
_L34:
        ir1 = ir.c;
          goto _L18
_L35:
        ir1 = ir.a;
          goto _L18
_L14:
        if (as.length != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        kg.a(4, a, "Template does not contain trigger values. Firing.");
        byte0 = 1;
          goto _L19
        if (map != null) goto _L19; else goto _L20
_L20:
        kg.a(4, a, "Publisher has not passed in params list. Not firing.");
          goto _L17
_L36:
        if (i1 >= as.length) goto _L22; else goto _L21
_L21:
        if (!as[i1].equals(s2)) goto _L24; else goto _L23
_L23:
        byte0 = 1;
_L22:
        if (byte0 != 0) goto _L26; else goto _L25
_L25:
        kg.a(4, a, "Publisher params list does not match proton param values. Not firing.");
          goto _L17
_L26:
        kg.a(4, a, "Publisher params match proton values. Firing.");
_L12:
        hq1 = ((hw) (obj)).b;
        if (hq1 != null) goto _L28; else goto _L27
_L27:
        kg.a(3, a, "Template is empty. Not firing current event.");
          goto _L17
_L28:
        kg.a(3, a, (new StringBuilder()).append("Creating callback report for partner: ").append(hq1.b).toString());
        hashmap1 = new HashMap();
        hashmap1.put("event_name", s1);
        hashmap1.put("event_time_millis", String.valueOf(l1));
        s2 = k.a(hq1.e, hashmap1);
        obj = null;
        if (hq1.f != null)
        {
            obj = k.a(hq1.f, hashmap1);
        }
        l2 = System.currentTimeMillis();
        obj = new ij(hq1.b, hq1.a, s2, l2 + 0xf731400L, u.e.b, hq1.g, hq1.d, hq1.j, hq1.i, hq1.h, ((String) (obj)));
        hashmap.put(Long.valueOf(hq1.a), obj);
          goto _L17
_L10:
        if (hashmap.size() == 0) goto _L3; else goto _L29
_L29:
        map = new in(s1, flag, je.a().d(), je.a().g(), ir1, hashmap);
        if (!"flurry.session_end".equals(s1)) goto _L31; else goto _L30
_L30:
        kg.a(3, a, (new StringBuilder()).append("Storing Pulse callbacks for event: ").append(s1).toString());
        m.add(map);
          goto _L3
_L31:
        kg.a(3, a, (new StringBuilder()).append("Firing Pulse callbacks for event: ").append(s1).toString());
        im.a().a(map);
          goto _L3
_L5:
        byte0;
        JVM INSTR tableswitch 0 2: default 860
    //                   0 366
    //                   1 373
    //                   2 380;
           goto _L32 _L33 _L34 _L35
_L16:
        i1 = 0;
          goto _L36
_L24:
        i1++;
          goto _L36
    }

    static boolean b(ig ig1, boolean flag)
    {
        ig1.v = flag;
        return flag;
    }

    static void c(ig ig1)
    {
        ig1.l();
    }

    static void d(ig ig1)
    {
        ig1.m();
    }

    static kk e(ig ig1)
    {
        return ig1.h;
    }

    static String e()
    {
        return a;
    }

    private void f()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = n;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        lt.b();
        Object obj = js.a().c().getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0);
        if (((SharedPreferences) (obj)).getBoolean("com.flurry.android.flurryAppInstall", true))
        {
            b("flurry.app_install", ((Map) (null)));
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putBoolean("com.flurry.android.flurryAppInstall", false);
            ((android.content.SharedPreferences.Editor) (obj)).apply();
        }
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void f(ig ig1)
    {
        ig1.i();
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = n;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        lt.b();
        if (!q || !jf.a().c()) goto _L1; else goto _L3
_L3:
        long l1 = System.currentTimeMillis();
        Object obj;
        byte abyte0[];
        kn kn1;
        if (!jf.a().e())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (u == null) goto _L5; else goto _L4
_L4:
        if (t == flag) goto _L7; else goto _L6
_L6:
        kg.a(3, a, "Limit ad tracking value has changed, purging");
        u = null;
_L5:
        jq.a().a(this);
        kg.a(3, a, "Requesting proton config");
        abyte0 = h();
        if (abyte0 == null) goto _L1; else goto _L8
_L8:
        kn1 = new kn();
        if (!TextUtils.isEmpty(o))
        {
            break MISSING_BLOCK_LABEL_353;
        }
        obj = b;
_L12:
        kn1.a(((String) (obj)));
        kn1.d(5000);
        kn1.a(kp.a.c);
        kn1.a("Content-Type", "application/x-flurry;version=2");
        kn1.a("Accept", "application/x-flurry;version=2");
        kn1.a("FM-Checksum", Integer.toString(kk.c(abyte0)));
        kn1.a(new kx());
        kn1.b(new kx());
        kn1.a(abyte0);
        kn1.a(new _cls2(l1, flag));
        jq.a().a(this, kn1);
          goto _L1
        obj;
        throw obj;
_L7:
        if (System.currentTimeMillis() >= s + u.b * 1000L) goto _L10; else goto _L9
_L9:
        kg.a(3, a, "Cached Proton config valid, no need to refresh");
        if (!v)
        {
            v = true;
            b("flurry.session_start", ((Map) (null)));
        }
          goto _L1
_L10:
        if (System.currentTimeMillis() < s + u.c * 1000L) goto _L5; else goto _L11
_L11:
        kg.a(3, a, "Cached Proton config expired, purging");
        u = null;
        l.a();
          goto _L5
        obj = o;
          goto _L12
    }

    static boolean g(ig ig1)
    {
        return ig1.v;
    }

    static void h(ig ig1)
    {
        ig1.f();
    }

    private byte[] h()
    {
        Object obj;
        obj = new hs();
        obj.a = js.a().d();
        obj.b = lq.c(js.a().c());
        obj.c = lq.d(js.a().c());
        obj.d = jt.a();
        obj.e = 3;
        obj.f = jo.a().c();
        Object obj1;
        java.util.Map.Entry entry;
        hu hu1;
        boolean flag;
        if (!jf.a().e())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.g = flag;
        obj.h = new hv();
        ((hs) (obj)).h.a = new hp();
        ((hs) (obj)).h.a.a = Build.MODEL;
        ((hs) (obj)).h.a.b = Build.BRAND;
        ((hs) (obj)).h.a.c = Build.ID;
        ((hs) (obj)).h.a.d = Build.DEVICE;
        ((hs) (obj)).h.a.e = Build.PRODUCT;
        ((hs) (obj)).h.a.f = android.os.Build.VERSION.RELEASE;
        obj.i = new ArrayList();
        obj1 = jf.a().h().entrySet().iterator();
_L2:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_367;
        }
        entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
        hu1 = new hu();
        hu1.a = ((jn)entry.getKey()).d;
        if (!((jn)entry.getKey()).e)
        {
            break; /* Loop/switch isn't completed */
        }
        hu1.b = new String((byte[])entry.getValue());
_L3:
        ((hs) (obj)).i.add(hu1);
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            hu1.b = lt.b((byte[])entry.getValue());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            kg.a(5, a, (new StringBuilder()).append("Proton config request failed with exception: ").append(obj).toString());
            return null;
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        obj1 = jj.a().e();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_459;
        }
        obj.j = new hz();
        ((hs) (obj)).j.a = new hy();
        ((hs) (obj)).j.a.a = lt.a(((Location) (obj1)).getLatitude(), 3);
        ((hs) (obj)).j.a.b = lt.a(((Location) (obj1)).getLongitude(), 3);
        ((hs) (obj)).j.a.c = (float)lt.a(((Location) (obj1)).getAccuracy(), 3);
        byte abyte0[];
        String s1 = (String)lk.a().a("UserId");
        if (!s1.equals(""))
        {
            obj.k = new ic();
            ((hs) (obj)).k.a = s1;
        }
        abyte0 = g.a(obj);
        return abyte0;
    }

    static long i(ig ig1)
    {
        return ig1.r;
    }

    private void i()
    {
        if (u != null)
        {
            kg.a(5, a, "Processing config response");
            im.a(u.e.c);
            im.b(u.e.d * 1000);
            io.a().a(u.e.e);
            if (n)
            {
                lk.a().a("analyticsEnabled", Boolean.valueOf(u.f.b));
            }
            l.a();
            Object obj = u.e;
            if (obj != null)
            {
                obj = ((hr) (obj)).a;
                if (obj != null)
                {
                    obj = ((List) (obj)).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        hq hq1 = (hq)((Iterator) (obj)).next();
                        if (hq1 != null)
                        {
                            Object obj1 = hq1.c;
                            if (obj1 != null)
                            {
                                obj1 = ((List) (obj1)).iterator();
                                while (((Iterator) (obj1)).hasNext()) 
                                {
                                    hw hw1 = (hw)((Iterator) (obj1)).next();
                                    if (hw1 != null && !TextUtils.isEmpty(hw1.a))
                                    {
                                        hw1.b = hq1;
                                        l.a(hw1.a, hw1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    static Runnable j(ig ig1)
    {
        return ig1.c;
    }

    private void j()
    {
        this;
        JVM INSTR monitorenter ;
        ie ie1 = (ie)i.a();
        if (ie1 == null) goto _L2; else goto _L1
_L1:
        ht ht1 = (ht)h.d(ie1.c());
_L5:
        ht ht2 = ht1;
        if (!a(ht1))
        {
            ht2 = null;
        }
        if (ht2 == null) goto _L2; else goto _L3
_L3:
        kg.a(4, a, "Loaded saved proton config response");
        r = 10000L;
        s = ie1.a();
        t = ie1.b();
        u = ht2;
        i();
_L2:
        q = true;
        js.a().b(new _cls3());
        this;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        kg.a(5, a, (new StringBuilder()).append("Failed to decode saved proton config response: ").append(obj).toString());
        i.b();
        obj = null;
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        throw obj;
    }

    private void k()
    {
        this;
        JVM INSTR monitorenter ;
        if (p) goto _L2; else goto _L1
_L1:
        kg.e(a, "Analytics disabled, not sending pulse reports.");
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        kg.a(4, a, (new StringBuilder()).append("Sending ").append(m.size()).append(" queued reports.").toString());
        in in1;
        for (Iterator iterator = m.iterator(); iterator.hasNext(); im.a().a(in1))
        {
            in1 = (in)iterator.next();
            kg.a(3, a, (new StringBuilder()).append("Firing Pulse callbacks for event: ").append(in1.c()).toString());
        }

        break MISSING_BLOCK_LABEL_136;
        Exception exception;
        exception;
        throw exception;
        n();
          goto _L3
    }

    private void l()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        kg.a(4, a, "Loading queued report data.");
        list = (List)j.a();
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        m.addAll(list);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void m()
    {
        this;
        JVM INSTR monitorenter ;
        kg.a(4, a, "Saving queued report data.");
        j.a(m);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void n()
    {
        this;
        JVM INSTR monitorenter ;
        m.clear();
        j.b();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private String o()
    {
        return (new StringBuilder()).append(".yflurryprotonconfig.").append(Long.toString(lt.i(js.a().d()), 16)).toString();
    }

    private String p()
    {
        return (new StringBuilder()).append(".yflurryprotonreport.").append(Long.toString(lt.i(js.a().d()), 16)).toString();
    }

    public void a()
    {
        js.a().c(c);
        kc.a().b("com.flurry.android.sdk.NetworkStateEvent", f);
        kc.a().b("com.flurry.android.sdk.IdProviderUpdatedAdvertisingId", e);
        kc.a().b("com.flurry.android.sdk.IdProviderFinishedEvent", d);
        im.b();
        lk.a().b("ProtonEnabled", this);
    }

    public void a(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = n;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        lt.b();
        b(l1);
        b("flurry.session_end", ((Map) (null)));
        js.a().b(new _cls11());
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void a(String s1, Object obj)
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   -1720015653: 108
    //                   640941243: 80
    //                   1591403975: 94;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break MISSING_BLOCK_LABEL_108;
_L5:
        switch (byte0)
        {
        default:
            kg.a(6, a, "onSettingUpdate internal error!");
            return;

        case 0: // '\0'
            n = ((Boolean)obj).booleanValue();
            kg.a(4, a, (new StringBuilder()).append("onSettingUpdate, protonEnabled = ").append(n).toString());
            return;

        case 1: // '\001'
            o = (String)obj;
            kg.a(4, a, (new StringBuilder()).append("onSettingUpdate, protonConfigUrl = ").append(o).toString());
            return;

        case 2: // '\002'
            p = ((Boolean)obj).booleanValue();
            break;
        }
        break MISSING_BLOCK_LABEL_214;
_L3:
        if (s1.equals("ProtonEnabled"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s1.equals("ProtonConfigUrl"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s1.equals("analyticsEnabled"))
        {
            byte0 = 2;
        }
          goto _L5
        kg.a(4, a, (new StringBuilder()).append("onSettingUpdate, AnalyticsEnabled = ").append(p).toString());
        return;
    }

    public void a(String s1, Map map)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = n;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        lt.b();
        b(s1, map);
        if (true) goto _L1; else goto _L3
_L3:
        s1;
        throw s1;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = n;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        lt.b();
        ii.a = je.a().d();
        v = false;
        g();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = n;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        lt.b();
        b(je.a().d());
        k();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = n;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        lt.b();
        k();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }


    private class _cls1 extends ly
    {

        final ig a;

        public void a()
        {
            ig.a(a);
        }

        _cls1()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls4
        implements kb
    {

        final ig a;

        public void a(jg jg1)
        {
            ig.a(a);
        }

        public volatile void a(ka ka)
        {
            a((jg)ka);
        }

        _cls4()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls5
        implements kb
    {

        final ig a;

        public void a(jh jh1)
        {
            ig.a(a);
        }

        public volatile void a(ka ka)
        {
            a((jh)ka);
        }

        _cls5()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls6
        implements kb
    {

        final ig a;

        public void a(jk jk1)
        {
            if (jk1.a)
            {
                ig.a(a);
            }
        }

        public volatile void a(ka ka)
        {
            a((jk)ka);
        }

        _cls6()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls7
        implements le
    {

        final ig a;

        public lb a(int i1)
        {
            return new ie.a();
        }

        _cls7()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls8
        implements le
    {

        final ig a;

        public lb a(int i1)
        {
            return new la(new in.a());
        }

        _cls8()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls9 extends ly
    {

        final ig a;

        public void a()
        {
            ig.b(a);
        }

        _cls9()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls10 extends ly
    {

        final ig a;

        public void a()
        {
            ig.c(a);
        }

        _cls10()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls2
        implements kn.a
    {

        final long a;
        final boolean b;
        final ig c;

        public volatile void a(kn kn1, Object obj)
        {
            a(kn1, (byte[])obj);
        }

        public void a(kn kn1, byte abyte0[])
        {
            Object obj;
            int i1;
            obj = null;
            i1 = kn1.h();
            kg.a(3, ig.e(), (new StringBuilder()).append("Proton config request: HTTP status code is:").append(i1).toString());
            if (i1 != 400 && i1 != 406 && i1 != 412 && i1 != 415) goto _L2; else goto _L1
_L1:
            ig.a(c, 10000L);
_L4:
            return;
_L2:
            long l1;
            ht ht1 = obj;
            if (!kn1.f())
            {
                continue; /* Loop/switch isn't completed */
            }
            ht1 = obj;
            if (abyte0 == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            class _cls1 extends ly
            {

                final byte a[];
                final _cls2 b;

                public void a()
                {
                    ig.a(b.c, b.a, b.b, a);
                }

                _cls1(byte abyte0[])
                {
                    b = _cls2.this;
                    a = abyte0;
                    super();
                }
            }

            js.a().b(new _cls1(abyte0));
            long l2;
            try
            {
                abyte0 = (ht)ig.e(c).d(abyte0);
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                kg.a(5, ig.e(), (new StringBuilder()).append("Failed to decode proton config response: ").append(abyte0).toString());
                abyte0 = null;
            }
            ht1 = abyte0;
            if (!ig.a(c, abyte0))
            {
                ht1 = null;
            }
            if (ht1 != null)
            {
                ig.a(c, 10000L);
                ig.b(c, a);
                ig.a(c, b);
                ig.b(c, ht1);
                ig.f(c);
                if (!ig.g(c))
                {
                    ig.b(c, true);
                    ig.a(c, "flurry.session_start", null);
                }
                ig.h(c);
            }
            if (ht1 != null) goto _L4; else goto _L3
_L3:
            l1 = ig.i(c);
            if (i1 != 429) goto _L6; else goto _L5
_L5:
            kn1 = kn1.b("Retry-After");
            if (kn1.isEmpty()) goto _L6; else goto _L7
_L7:
            kn1 = (String)kn1.get(0);
            kg.a(3, ig.e(), (new StringBuilder()).append("Server returned retry time: ").append(kn1).toString());
            l2 = Long.parseLong(kn1);
            l1 = l2 * 1000L;
_L9:
            ig.a(c, l1);
            kg.a(3, ig.e(), (new StringBuilder()).append("Proton config request failed, backing off: ").append(ig.i(c)).append("ms").toString());
            js.a().b(ig.j(c), ig.i(c));
            return;
            kn1;
            kg.a(3, ig.e(), "Server returned nonsensical retry time");
_L6:
            l1 <<= 1;
            if (true) goto _L9; else goto _L8
_L8:
        }

        _cls2(long l1, boolean flag)
        {
            c = ig.this;
            a = l1;
            b = flag;
            super();
        }
    }


    private class _cls3 extends ly
    {

        final ig a;

        public void a()
        {
            ig.a(a);
        }

        _cls3()
        {
            a = ig.this;
            super();
        }
    }


    private class _cls11 extends ly
    {

        final ig a;

        public void a()
        {
            ig.d(a);
        }

        _cls11()
        {
            a = ig.this;
            super();
        }
    }

}
