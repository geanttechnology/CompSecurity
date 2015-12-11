// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.text.TextUtils;
import com.flurry.android.impl.ads.protocol.v13.AdFrame;
import com.flurry.android.impl.ads.protocol.v13.AdUnit;
import com.flurry.android.impl.ads.protocol.v13.Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.flurry.sdk:
//            b, ap, dt, aw, 
//            cz, c, f, i, 
//            bc, a, au, gd, 
//            g, ea, d, aa, 
//            cy, hp, fz, fy, 
//            fx

public class h
{

    private static final String a = com/flurry/sdk/h.getSimpleName();
    private static Map b = Collections.unmodifiableMap(new HashMap() {

            
            {
                put("playVideo", au.t);
                put("open", au.u);
                put("expand", au.r);
                put("collapse", au.s);
            }
    });
    private static Set c = Collections.unmodifiableSet(new HashSet() {

            
            {
                add(au.b);
                add(au.e);
                add(au.g);
                add(au.r);
                add(au.s);
                add(au.h);
            }
    });
    private final fy d = new fy() {

        final h a;

        public void a(c c1)
        {
            gd.a(3, h.c(), (new StringBuilder()).append("Detected event was fired :").append(c1.a).append(" for adSpace:").append(c1.a.e().adSpace).toString());
            h.a(a, c1);
        }

        public void notify(fx fx)
        {
            a((c)fx);
        }

            
            {
                a = h.this;
                super();
            }
    };

    public h()
    {
    }

    private void a(b b1, List list)
    {
        list = b1.c().m();
        if (!list.c())
        {
            cz.d(b1.c(), b1.a.a(), b1.d().adGuid);
            list.b(true);
            b1.c().a(list);
        }
    }

    private void a(c c1)
    {
        List list;
        Object obj;
        obj = c1.a;
        String s = ((b) (obj)).a.a();
        list = a(((b) (obj)).d(), ((b) (obj)));
        com.flurry.sdk.f.a().a(s, 1);
        com.flurry.sdk.i.a().n().a(((b) (obj)));
        if (list.isEmpty())
        {
            Iterator iterator = b.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (((String)entry.getKey()).equals(((b) (obj)).a.a()))
                {
                    list.add(new a((au)entry.getValue(), ((b) (obj)).b, ((b) (obj))));
                }
            } while (true);
        }
        class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[aw.values().length];
                try
                {
                    a[aw.g.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror31) { }
                try
                {
                    a[aw.f.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror30) { }
                try
                {
                    a[aw.i.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror29) { }
                try
                {
                    a[aw.E.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror28) { }
                try
                {
                    a[aw.F.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror27) { }
                try
                {
                    a[aw.G.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror26) { }
                try
                {
                    a[aw.j.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror25) { }
                try
                {
                    a[aw.h.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror24) { }
                try
                {
                    a[aw.q.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror23) { }
                try
                {
                    a[aw.s.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror22) { }
                try
                {
                    a[aw.M.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    a[aw.t.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    a[aw.v.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    a[aw.N.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    a[aw.O.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    a[aw.Q.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    a[aw.b.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    a[aw.d.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    a[aw.e.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    a[aw.K.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    a[aw.r.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    a[aw.C.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    a[aw.B.ordinal()] = 23;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    a[aw.n.ordinal()] = 24;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[aw.o.ordinal()] = 25;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[aw.k.ordinal()] = 26;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[aw.l.ordinal()] = 27;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[aw.c.ordinal()] = 28;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[aw.L.ordinal()] = 29;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[aw.J.ordinal()] = 30;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[aw.I.ordinal()] = 31;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[aw.a.ordinal()] = 32;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4.a[((b) (obj)).a.ordinal()];
        JVM INSTR tableswitch 1 16: default 232
    //                   1 283
    //                   2 292
    //                   3 301
    //                   4 310
    //                   5 319
    //                   6 328
    //                   7 337
    //                   8 346
    //                   9 355
    //                   10 363
    //                   11 372
    //                   12 428
    //                   13 436
    //                   14 444
    //                   15 452
    //                   16 460;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L1:
        gd.a(3, a, (new StringBuilder()).append("Event not handled: ").append(((b) (obj)).a).append(" for adSpace:").append(((b) (obj)).c().p()).toString());
_L19:
        a(c1, list);
        return;
_L2:
        h(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L3:
        a(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L4:
        b(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L5:
        c(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L6:
        d(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L7:
        e(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L8:
        f(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L9:
        g(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L10:
        g(((b) (obj)));
        continue; /* Loop/switch isn't completed */
_L11:
        j(((b) (obj)), list);
        continue; /* Loop/switch isn't completed */
_L12:
        obj = list.iterator();
        do
        {
            a a1;
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                a1 = (a)((Iterator) (obj)).next();
            } while (!a1.a().equals(au.l));
            a1.a("is_privacy", "true");
        } while (true);
_L13:
        c(((b) (obj)));
        continue; /* Loop/switch isn't completed */
_L14:
        c(((b) (obj)));
        continue; /* Loop/switch isn't completed */
_L15:
        a(((b) (obj)));
        continue; /* Loop/switch isn't completed */
_L16:
        b(((b) (obj)));
        continue; /* Loop/switch isn't completed */
_L17:
        d(((b) (obj)));
        if (true) goto _L19; else goto _L18
_L18:
    }

    private void a(c c1, List list)
    {
        Object obj = null;
        Iterator iterator = list.iterator();
        list = obj;
        a a1;
        for (; iterator.hasNext(); com.flurry.sdk.i.a().o().a(a1, c1.b + 1))
        {
            a1 = (a)iterator.next();
            if (a1.a().equals(au.c))
            {
                a1.a("__sendToServer", "true");
                list = a1;
            }
            if (a1.a().equals(au.k))
            {
                java.util.Map.Entry entry;
                for (Iterator iterator1 = a1.c().b.entrySet().iterator(); iterator1.hasNext(); a1.a((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)iterator1.next();
                }

            }
            gd.d(a, a1.toString());
        }

        if (list == null)
        {
            list = new HashMap();
            list.put("__sendToServer", "false");
            list = new a(au.c, list, c1.a);
            gd.d(a, list.toString());
            com.flurry.sdk.i.a().o().a(list, c1.b + 1);
        }
    }

    static void a(h h1, c c1)
    {
        h1.a(c1);
    }

    private void b(b b1, List list)
    {
        cz.e(b1.c(), b1.a.a(), b1.d().adGuid);
        list = b1.c().m();
        list.a(true);
        b1.c().a(list);
    }

    static String c()
    {
        return a;
    }

    private void c(b b1, List list)
    {
        cz.f(b1.c(), b1.a.a(), b1.d().adGuid);
        list = b1.c().m();
        list.c(true);
        b1.c().a(list);
    }

    private void d()
    {
        ea ea1 = new ea();
        ea1.e = ea.a.b;
        ea1.b();
    }

    private void d(b b1)
    {
        gd.a(3, a, (new StringBuilder()).append("Firing onAdImpressionLogged, adObject=").append(b1.b()).toString());
        d d1 = new d();
        d1.a = b1.b();
        d1.b = d.a.j;
        d1.b();
    }

    private void d(b b1, List list)
    {
        cz.g(b1.c(), b1.a.a(), b1.d().adGuid);
        list = b1.c().m();
        list.d(true);
        b1.c().a(list);
    }

    private void e(b b1)
    {
        gd.a(3, a, (new StringBuilder()).append("Firing onRenderFailed, adObject=").append(b1.b()).toString());
        d d1 = new d();
        d1.a = b1.b();
        d1.b = d.a.d;
        d1.b();
    }

    private void e(b b1, List list)
    {
        cz.h(b1.c(), b1.a.a(), b1.d().adGuid);
        list = b1.c().m();
        list.e(true);
        b1.c().a(list);
    }

    private void f(b b1, List list)
    {
        cz.i(b1.c(), b1.a.a(), b1.d().adGuid);
        com.flurry.sdk.i.a().l().a(b1.b());
        com.flurry.sdk.i.a().l().g();
        gd.a(3, a, (new StringBuilder()).append("initLayout onVideoCompleted ").append(b1.a()).toString());
        if (b1.e().rewardable)
        {
            gd.a(3, a, "Ad unit is rewardable, onVideoCompleted listener will fire");
            gd.a(3, a, (new StringBuilder()).append("Firing onVideoCompleted, adObject=").append(b1.b()).toString());
            list = new d();
            list.a = b1.b();
            list.b = d.a.k;
            list.b();
            return;
        } else
        {
            gd.a(3, a, "Ad unit is not rewardable, onVideoCompleted listener will not fire");
            return;
        }
    }

    private boolean f(b b1)
    {
        boolean flag;
        if ((String)b1.b.remove("binding_3rd_party") != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (((AdFrame)b1.e().adFrames.get(0)).binding == 4)
        {
            return true;
        } else
        {
            return flag;
        }
    }

    private void g(b b1)
    {
        com.flurry.sdk.i.a().l().a(b1.b());
        com.flurry.sdk.i.a().l().g();
    }

    private void g(b b1, List list)
    {
        b1.c().p();
        gd.a(3, a, (new StringBuilder()).append("Firing onClicked, adObject=").append(b1.b()).toString());
        list = new d();
        list.a = b1.b();
        list.b = d.a.h;
        list.b();
        list = b1.c();
        Object obj = list.g();
        if (obj != null)
        {
            dt dt1 = b1.c().m();
            obj = ((cy) (obj)).i();
            if (dt1 != null && !TextUtils.isEmpty(((CharSequence) (obj))))
            {
                list.a(dt1);
                com.flurry.sdk.i.a().o().a(b1.a(), ((String) (obj)), true, b1.b());
            }
            if (dt1 != null && !dt1.h())
            {
                dt1.g(true);
                list.a(dt1);
                cz.c(b1.c(), b1.a.a(), b1.d().adGuid);
            }
        }
    }

    private void h(b b1, List list)
    {
        boolean flag = f(b1);
        if (b1.b.remove("preRender") == null && !flag)
        {
            e(b1);
        } else
        {
            i(b1, list);
        }
        cz.b(b1.c(), b1.a.a(), b1.d().adGuid);
        if (b1.c().l())
        {
            d();
        }
        com.flurry.sdk.i.a().l().c(b1.c());
        com.flurry.sdk.i.a().l().a(b1.b());
        com.flurry.sdk.i.a().l().g();
    }

    private void i(b b1, List list)
    {
        list = list.iterator();
_L4:
        if (!list.hasNext()) goto _L2; else goto _L1
_L1:
        a a1 = (a)list.next();
        if (!au.f.equals(a1.a())) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        if (flag)
        {
            gd.a(3, a, (new StringBuilder()).append("Firing onFetchFailed, adObject=").append(b1.b()).toString());
            list = new d();
            list.a = b1.b();
            list.b = d.a.b;
            list.b();
        }
        return;
_L2:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void j(b b1, List list)
    {
        Iterator iterator;
        cz.a(b1.c(), b1.a.a(), b1.d().adGuid);
        iterator = list.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        a a1 = (a)iterator.next();
        if (!c.contains(a1.a())) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        if (!flag)
        {
            list.add(0, new a(au.g, Collections.emptyMap(), b1));
            com.flurry.sdk.i.a().l().a(b1.b());
            com.flurry.sdk.i.a().l().g();
        }
        return;
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public List a(AdFrame adframe, b b1)
    {
        ArrayList arraylist = new ArrayList();
        adframe = adframe.callbacks;
        String s2 = b1.a.a();
        Iterator iterator = adframe.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            adframe = (Callback)iterator.next();
            if (((Callback) (adframe)).event.equals(s2))
            {
                Iterator iterator1 = ((Callback) (adframe)).actions.iterator();
                while (iterator1.hasNext()) 
                {
                    String s1 = (String)iterator1.next();
                    HashMap hashmap = new HashMap();
                    int k = s1.indexOf('?');
                    adframe = s1;
                    if (k != -1)
                    {
                        String s = s1.substring(0, k);
                        s1 = s1.substring(k + 1);
                        adframe = s1;
                        if (s1.contains("%{eventParams}"))
                        {
                            adframe = s1.replace("%{eventParams}", "");
                            hashmap.putAll(b1.b);
                        }
                        hashmap.putAll(hp.h(adframe));
                        adframe = s;
                    }
                    arraylist.add(new a(com.flurry.sdk.a.c(adframe), hashmap, b1));
                }
            }
        } while (true);
        return arraylist;
    }

    public void a()
    {
        gd.a(3, a, "Unregister Event Handler ");
        fz.a().a(d);
    }

    public void a(b b1)
    {
        gd.a(3, a, (new StringBuilder()).append("Firing onOpen, adObject=").append(b1.b()).toString());
        d d1 = new d();
        d1.a = b1.b();
        d1.b = d.a.e;
        d1.b();
    }

    public void b()
    {
        gd.a(3, a, "Registered Event Handler ");
        fz.a().a("com.flurry.android.impl.ads.AdEvent", d);
    }

    public void b(b b1)
    {
        gd.a(3, a, (new StringBuilder()).append("Firing onAppExit, adObject=").append(b1.b()).toString());
        d d1 = new d();
        d1.a = b1.b();
        d1.b = d.a.g;
        d1.b();
        d();
    }

    public void c(b b1)
    {
        gd.a(3, a, (new StringBuilder()).append("Firing onClose, adObject=").append(b1.b()).toString());
        d d1 = new d();
        d1.a = b1.b();
        d1.b = d.a.f;
        d1.b();
        d();
    }

}
