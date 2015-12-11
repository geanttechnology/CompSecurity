// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.ads:
//            ds, dr, aw, cm, 
//            co, bc, cl, y, 
//            dy, k, ad, cd, 
//            j, h, ac, a, 
//            cn, v, dc, at, 
//            bg, aj, ay, aa, 
//            ab, ae

class s
{
    protected final class a extends Exception
    {

        final k a;
        final s b;

        public a(k k1)
        {
            b = s.this;
            super();
            a = k1;
        }
    }

    protected static final class b
    {

        protected b()
        {
        }
    }


    private static final String g = com/amazon/device/ads/s.getSimpleName();
    final Map a;
    int b;
    k c;
    final cn d;
    final aw e;
    final ds.k f;
    private final y h;
    private cl.a i;
    private final cm j;
    private final bc k;
    private final dr l;

    public s(y y1, Map map)
    {
        ds.k k1 = ds.a();
        dr dr1 = new dr();
        aw aw1 = aw.a();
        cm cm1 = cm.a();
        new co();
        this(y1, map, k1, dr1, aw1, cm1, bc.a());
    }

    private s(y y1, Map map, ds.k k1, dr dr1, aw aw1, cm cm1, bc bc1)
    {
        b = 20000;
        c = null;
        i = null;
        h = y1;
        a = map;
        f = k1;
        l = dr1;
        e = aw1;
        j = cm1;
        d = co.a(g);
        k = bc1;
    }

    static void a(s s1)
    {
        s1.f.a(s1. new Runnable() {

            final s a;

            public final void run()
            {
                s s2 = a;
                Iterator iterator = s2.a.entrySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj = (ad)((java.util.Map.Entry)iterator.next()).getValue();
                    if (!((ad) (obj)).b.n())
                    {
                        s2.d.c("Ad object was destroyed before ad fetching could be finalized. Ad fetching has been aborted.", null);
                    } else
                    {
                        ((ad) (obj)).b.f.c(ck.a.h);
                        boolean flag;
                        if (((ad) (obj)).b.o != null && ((ad) (obj)).b.o.h)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (!flag)
                        {
                            ((ad) (obj)).b.f.b(ck.a.j);
                            if (((ad) (obj)).e != null)
                            {
                                ((ad) (obj)).a(((ad) (obj)).e);
                            } else
                            {
                                ((ad) (obj)).a(new k(k.a.d, "Unknown error occurred."));
                            }
                        } else
                        {
                            ((ad) (obj)).b.f.b(ck.a.i);
                            obj = ((ad) (obj)).b;
                            if (((h) (obj)).n())
                            {
                                if ((at.c(((h) (obj)).h, 14) || at.c(((h) (obj)).h, 15)) && ((h) (obj)).o.e.contains(com.amazon.device.ads.a.k))
                                {
                                    obj.D = true;
                                } else
                                {
                                    obj.D = false;
                                }
                                if (((h) (obj)).k())
                                {
                                    Iterator iterator1;
                                    if (!((h) (obj)).u())
                                    {
                                        float f1 = ((h) (obj)).g.b.g;
                                        obj.y = aj.a((int)((float)((h) (obj)).o.g * f1), (int)(f1 * (float)((h) (obj)).o.f), ((h) (obj)).v, ((h) (obj)).u);
                                        if (!((h) (obj)).c.b() && ((h) (obj)).y > 1.0D)
                                        {
                                            obj.y = 1.0D;
                                        }
                                        ((h) (obj)).i();
                                    } else
                                    {
                                        obj.y = -1D;
                                    }
                                    iterator1 = ((h) (obj)).o.iterator();
                                    do
                                    {
                                        if (!iterator1.hasNext())
                                        {
                                            break;
                                        }
                                        Object obj1 = (com.amazon.device.ads.a)iterator1.next();
                                        obj1 = (Set)((h) (obj)).k.a.get(obj1);
                                        if (obj1 != null)
                                        {
                                            obj1 = ((Set) (obj1)).iterator();
                                            while (((Iterator) (obj1)).hasNext()) 
                                            {
                                                z z = ((aa)((Iterator) (obj1)).next()).a(((h) (obj)).c());
                                                ((h) (obj)).l.a(z);
                                            }
                                        }
                                    } while (true);
                                    if (((h) (obj)).n())
                                    {
                                        ((h) (obj)).a(ae.c);
                                        ds.b(new h._cls7(((h) (obj)), ((h) (obj)).o.d));
                                    }
                                }
                            }
                        }
                    }
                } while (true);
            }

            
            {
                a = s.this;
                super();
            }
        }, ds.b.b, ds.c.a);
    }

    final dy.g a()
    {
        b().b(ck.a.k);
        Object obj = h.a();
        b().c(ck.a.k);
        obj.h = b();
        ((dy) (obj)).a(ck.a.s);
        obj.g = b;
        obj.i = false;
        b().c(ck.a.f);
        b().a(ck.a.V);
        try
        {
            obj = ((dy) (obj)).c();
        }
        catch (Object obj1)
        {
            if (((dy.c) (obj1)).a == dy.f.a)
            {
                obj1 = new k(k.a.a, "Could not contact Ad Server");
            } else
            if (((dy.c) (obj1)).a == dy.f.b)
            {
                obj1 = new k(k.a.b, "Connection to Ad Server timed out");
            } else
            {
                obj1 = new k(k.a.d, ((dy.c) (obj1)).getMessage());
            }
            throw new a(((k) (obj1)));
        }
        b().b(ck.a.g);
        return ((dy.g) (obj));
    }

    final void a(k k1)
    {
        for (Iterator iterator = a.values().iterator(); iterator.hasNext();)
        {
            ((ad)iterator.next()).e = k1;
        }

    }

    final void a(JSONObject jsonobject)
    {
        long l2 = System.currentTimeMillis();
        Object obj2 = cd.a(jsonobject, "status", null);
        Object obj1 = new HashSet(a.keySet());
        int i1 = cd.a(jsonobject, "noretryTTL", 0);
        int k1 = k.a("debug.noRetryTTL", Integer.valueOf(i1)).intValue();
        Object obj = j;
        i1 = ((cm) (obj)).k.a("debug.noRetryTTLMax", Integer.valueOf(0x493e0)).intValue();
        String s1;
        ad ad1;
        j j1;
        JSONObject jsonobject1;
        String s2;
        HashSet hashset;
        JSONArray jsonarray;
        int l1;
        int i2;
        boolean flag;
        boolean flag1;
        boolean flag2;
        long l3;
        if (i1 >= k1)
        {
            i1 = k1;
        }
        if (i1 == 0)
        {
            obj.f = 0;
            obj.g = 0L;
        } else
        {
            obj.f = i1 * 1000;
            obj.g = System.currentTimeMillis() + (long)((cm) (obj)).f;
        }
        obj = cd.a(jsonobject, "errorMessage", "No Ad Received");
        j.h = ((String) (obj)).equalsIgnoreCase("DISABLED_APP");
        s1 = (new StringBuilder("Server Message: ")).append(((String) (obj))).toString();
        if (k1 > 0)
        {
            b().a(ck.a.B, k1 * 1000);
        }
        if (k1 > 0 && !j.h)
        {
            obj = (new StringBuilder()).append(s1).append(". Try again in ").append(k1).append(" seconds").toString();
            obj = new k(k.a.c, ((String) (obj)));
        } else
        if (((String) (obj)).equals("no results"))
        {
            obj = new k(k.a.c, s1);
        } else
        {
            obj = new k(k.a.d, s1);
        }
        s1 = cd.a(jsonobject, "errorCode", "No Ad Received");
        h.c = cd.a(jsonobject, "instrPixelURL", null);
        if (obj2 == null || !((String) (obj2)).equals("ok"))
        {
            break MISSING_BLOCK_LABEL_975;
        }
        obj2 = cd.a(jsonobject, "ads");
        i2 = 0;
        if (i2 >= ((JSONArray) (obj2)).length())
        {
            break MISSING_BLOCK_LABEL_975;
        }
        jsonobject1 = cd.a(((JSONArray) (obj2)), i2);
        if (jsonobject1 != null)
        {
            i1 = cd.a(jsonobject1, "slotId", -1);
            ad1 = (ad)a.get(Integer.valueOf(i1));
            if (ad1 != null)
            {
                ((HashSet) (obj1)).remove(Integer.valueOf(i1));
                jsonobject = cd.a(jsonobject1, "instrPixelURL", h.c);
                j1 = new j();
                j1.a = jsonobject;
                j1.b = cd.a(jsonobject1, "impPixelURL", null);
                if (ad1.b.c.a())
                {
                    ad1.b.f.a(ck.a.C);
                }
                s2 = cd.a(jsonobject1, "html", "");
                jsonarray = cd.a(jsonobject1, "creativeTypes");
                hashset = new HashSet();
                if (jsonarray != null)
                {
                    i1 = 0;
                    while (i1 < jsonarray.length()) 
                    {
                        if (jsonarray.isNull(i1))
                        {
                            k1 = 0;
                        } else
                        {
                            k1 = jsonarray.optInt(i1, 0);
                        }
                        jsonobject = com.amazon.device.ads.a.a(k1);
                        if (jsonobject != null)
                        {
                            hashset.add(jsonobject);
                        } else
                        {
                            d.c("%d is not a recognized creative type.", new Object[] {
                                Integer.valueOf(k1)
                            });
                        }
                        i1++;
                    }
                }
                if (com.amazon.device.ads.a.a(hashset))
                {
                    break; /* Loop/switch isn't completed */
                }
                ad1.e = new k(k.a.d, "No valid creative types found");
                d.d("No valid creative types found", null);
            }
        }
_L8:
        i2++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_290;
_L1:
        jsonobject = cd.a(jsonobject1, "size", "");
        if (jsonobject != null && (jsonobject.equals("9999x9999") || jsonobject.equals("interstitial")) && !hashset.contains(com.amazon.device.ads.a.d))
        {
            hashset.add(com.amazon.device.ads.a.d);
        }
        l1 = 0;
        i1 = 0;
        flag1 = false;
        k1 = 0;
        flag = false;
        if (hashset.contains(com.amazon.device.ads.a.d))
        {
            break MISSING_BLOCK_LABEL_879;
        }
        flag2 = false;
        if (jsonobject != null)
        {
            jsonobject = jsonobject.split("x");
        } else
        {
            jsonobject = null;
        }
        if (jsonobject != null && jsonobject.length == 2) goto _L4; else goto _L3
_L3:
        l1 = 1;
        i1 = ((flag1) ? 1 : 0);
        k1 = ((flag) ? 1 : 0);
_L6:
        if (l1 == 0)
        {
            break MISSING_BLOCK_LABEL_879;
        }
        ad1.e = new k(k.a.d, "Server returned an invalid ad size");
        d.d("Server returned an invalid ad size", null);
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = l1;
        l1 = Integer.parseInt(jsonobject[0]);
        i1 = l1;
        k1 = Integer.parseInt(jsonobject[1]);
        i1 = l1;
        l1 = ((flag2) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
        jsonobject;
        l1 = 1;
        k1 = ((flag) ? 1 : 0);
        if (true) goto _L6; else goto _L5
_L5:
        l3 = cd.a(jsonobject1, "cacheTTL", -1L);
        if (l3 > -1L)
        {
            j1.i = l3 * 1000L + l2;
        }
        jsonobject = new v(jsonarray);
        j1.f = k1;
        j1.g = i1;
        j1.c = s2;
        j1.e = hashset;
        j1.d = jsonobject;
        j1.h = true;
        ad1.a(j1);
        if (true) goto _L8; else goto _L7
_L7:
        for (jsonobject = ((HashSet) (obj1)).iterator(); jsonobject.hasNext(); d.c("%s; code: %s", new Object[] {
    ((k) (obj)).b, s1
}))
        {
            obj1 = (Integer)jsonobject.next();
            ((ad)a.get(obj1)).e = ((k) (obj));
            obj2 = new j();
            obj2.a = h.c;
            ((ad)a.get(obj1)).a(((j) (obj2)));
        }

        return;
    }

    final cl b()
    {
        if (i == null)
        {
            ArrayList arraylist = new ArrayList();
            for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext(); arraylist.add(((ad)((java.util.Map.Entry)iterator.next()).getValue()).b.f)) { }
            i = new cl.a(arraylist);
        }
        return i;
    }


    // Unreferenced inner class com/amazon/device/ads/s$1

/* anonymous class */
    final class _cls1
        implements Runnable
    {

        final s a;

        public final void run()
        {
            s s1;
            s1 = a;
            s1.b().c(ck.a.e);
            s1.b().b(ck.a.f);
            if (s1.e.b()) goto _L2; else goto _L1
_L1:
            s1.c = new k(k.a.e, "Unable to create the assets needed to display ads");
            s1.d.d("Unable to create the assets needed to display ads", null);
            s1.a(s1.c);
_L4:
            s.a(a);
            return;
_L2:
            Object obj = s1.a();
            boolean flag;
            if (((dy.g) (obj)).a == 200)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                obj = (new StringBuilder()).append(((dy.g) (obj)).a).append(" - ").append(((dy.g) (obj)).b).toString();
                s1.c = new k(k.a.a, ((String) (obj)));
                s1.d.d(((String) (obj)), null);
                s1.a(s1.c);
            } else
            {
                obj = ((dy.g) (obj)).a().b();
                if (obj == null)
                {
                    s1.c = new k(k.a.d, "Unable to parse response");
                    s1.d.d("Unable to parse response", null);
                    s1.a(s1.c);
                } else
                {
                    s1.a(((JSONObject) (obj)));
                    s1.b().c(ck.a.g);
                    s1.b().b(ck.a.h);
                }
            }
            continue; /* Loop/switch isn't completed */
            obj;
            s1.c = ((a) (obj)).a;
            s1.d.d(((a) (obj)).a.b, null);
            s1.a(s1.c);
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                a = s.this;
                super();
            }
    }

}
