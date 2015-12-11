// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.jirbo.adcolony:
//            aj, q, ae, ai, 
//            ac, ar, y, b, 
//            av, s, af, ao, 
//            aw, ab, as, r

public final class aa
    implements b.a
{

    ac a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    double g;
    Handler h;
    Runnable i;
    public al.j j;

    aa(ac ac1)
    {
        e = true;
        f = false;
        j = new al.j();
        a = ac1;
        if (Looper.myLooper() == null)
        {
            Looper.prepare();
        }
        h = new Handler();
        i = new Runnable() {

            final aa a;

            public final void run()
            {
                a.e = true;
                if (a.f)
                {
                    a.a();
                }
            }

            
            {
                a = aa.this;
                super();
            }
        };
    }

    private boolean a(a.g g1)
    {
_L2:
        return false;
        if (g1 == null || !g1.a("status", "").equals("success")) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = j;
        g1 = g1.a("app");
        if (g1 != null) goto _L4; else goto _L3
_L3:
        int k = 0;
_L5:
        if (k != 0)
        {
            aj.a.b("Finished parsing manifest");
            Object obj1;
            Object obj2;
            Object obj3;
            a.g g2;
            Object obj4;
            Object obj5;
            a.g g3;
            int l;
            if (!j.h.equalsIgnoreCase("none"))
            {
                aj.c.b("Enabling debug logging.");
                q.a(1);
            } else
            {
                q.a(2);
            }
            return true;
        }
        if (true) goto _L2; else goto _L4
_L4:
label0:
        {
            obj.a = g1.a("enabled", false);
            obj.b = g1.a("log_screen_overlay", false);
            obj.c = g1.a("last_country", "");
            obj.d = g1.a("last_ip", "");
            obj.f = g1.a("collect_iap_enabled", false);
            obj.g = g1.d("media_pool_size");
            obj.h = g1.a("log_level", "");
            obj.i = g1.a("view_network_pass_filter", "");
            obj.j = g1.a("cache_network_pass_filter", "");
            obj.e = g1.a("hardware_acceleration_disabled", false);
            if (((al.j) (obj)).i == null || ((al.j) (obj)).i.equals(""))
            {
                obj.i = "all";
            }
            if (((al.j) (obj)).j == null || ((al.j) (obj)).j.equals(""))
            {
                obj.j = "all";
            }
            obj.k = new al.k();
            obj1 = ((al.j) (obj)).k;
            obj2 = g1.a("tracking");
            if (obj2 != null)
            {
                obj1.a = ((a.g) (obj2)).a("update", null);
                obj1.b = ((a.g) (obj2)).a("install", null);
                obj1.c = ((a.g) (obj2)).a("dynamic_interests", null);
                obj1.d = ((a.g) (obj2)).a("user_meta_data", null);
                obj1.e = ((a.g) (obj2)).a("in_app_purchase", null);
                obj1.g = ((a.g) (obj2)).a("session_end", null);
                obj1.f = ((a.g) (obj2)).a("session_start", null);
                obj1.h = new a.g();
                ((al.k) (obj1)).h.b("update", ((al.k) (obj1)).a);
                ((al.k) (obj1)).h.b("install", ((al.k) (obj1)).b);
                ((al.k) (obj1)).h.b("dynamic_interests", ((al.k) (obj1)).c);
                ((al.k) (obj1)).h.b("user_meta_data", ((al.k) (obj1)).d);
                ((al.k) (obj1)).h.b("in_app_purchase", ((al.k) (obj1)).e);
                ((al.k) (obj1)).h.b("session_end", ((al.k) (obj1)).g);
                ((al.k) (obj1)).h.b("session_start", ((al.k) (obj1)).f);
                obj1 = new ae("iap_cache.txt");
                obj2 = ai.b(((ae) (obj1)));
                if (obj2 != null)
                {
                    for (k = 0; k < ((a.c) (obj2)).a.size(); k++)
                    {
                        obj3 = ((a.c) (obj2)).a(k, new a.g());
                        q.c.d.a("in_app_purchase", ((a.g) (obj3)));
                    }

                    ((ae) (obj1)).c();
                    q.Q.a.clear();
                }
                q.w = true;
            }
            obj.l = new al.ab();
            obj1 = ((al.j) (obj)).l;
            obj2 = g1.a("third_party_tracking");
            if (obj2 == null)
            {
                k = 0;
            } else
            {
                obj3 = ((a.g) (obj2)).c("update");
                obj1.a = ((ArrayList) (obj3));
                if (obj3 == null)
                {
                    k = 0;
                } else
                {
                    obj3 = ((a.g) (obj2)).c("install");
                    obj1.b = ((ArrayList) (obj3));
                    if (obj3 == null)
                    {
                        k = 0;
                    } else
                    {
                        obj2 = ((a.g) (obj2)).c("session_start");
                        obj1.c = ((ArrayList) (obj2));
                        if (obj2 == null)
                        {
                            k = 0;
                        } else
                        {
                            ((al.ab) (obj1)).d.put("update", ((al.ab) (obj1)).a);
                            ((al.ab) (obj1)).d.put("install", ((al.ab) (obj1)).b);
                            ((al.ab) (obj1)).d.put("session_start", ((al.ab) (obj1)).c);
                            k = 1;
                        }
                    }
                }
            }
            if (k != 0)
            {
                break label0;
            }
            k = 0;
        }
          goto _L5
        obj.m = g1.c("console_messages");
        aj.a.b("Parsing zones");
        obj.n = new al.f();
        obj1 = ((al.j) (obj)).n;
        obj2 = g1.b("zones");
        obj1.a = new ArrayList();
        if (obj2 != null) goto _L7; else goto _L6
_L6:
        k = 0;
_L8:
        if (k == 0)
        {
            k = 0;
        } else
        {
            obj.o = new al.n();
            obj = ((al.j) (obj)).o;
            g1 = g1.a("device");
            if (g1 == null)
            {
                k = 0;
            } else
            {
                obj.a = g1.a("type", null);
                q.O = ((al.n) (obj)).a;
                k = 1;
            }
            if (k == 0)
            {
                k = 0;
            } else
            {
                aj.a.b("Finished parsing app info");
                k = 1;
            }
        }
          goto _L5
_L7:
        l = 0;
_L9:
label1:
        {
            if (l >= ((a.c) (obj2)).a.size())
            {
                break MISSING_BLOCK_LABEL_1355;
            }
            obj3 = new al.c();
            g2 = ((a.c) (obj2)).a(l);
            if (g2 == null)
            {
                k = 0;
            } else
            {
                obj3.a = g2.a("uuid", "");
                obj3.e = g2.a("enabled", false);
                obj3.f = g2.a("active", false);
                if (!((al.c) (obj3)).e || !((al.c) (obj3)).f)
                {
                    k = 1;
                } else
                {
                    obj3.b = g2.e("play_interval");
                    obj3.c = g2.e("daily_play_cap");
                    obj3.d = g2.e("session_play_cap");
                    obj3.g = new ArrayList();
                    obj4 = g2.c("play_order");
                    obj3.g = ((ArrayList) (obj4));
                    if (obj4 == null)
                    {
                        k = 0;
                    } else
                    {
                        obj3.h = new al.d();
                        obj4 = ((al.c) (obj3)).h;
                        obj5 = g2.a("tracking");
                        if (obj5 != null)
                        {
                            obj4.a = ((a.g) (obj5)).a("request", null);
                        }
                        obj3.i = new al.i();
                        if (!((al.c) (obj3)).i.a(g2.b("ads")))
                        {
                            k = 0;
                        } else
                        {
                            obj3.j = new al.e();
                            obj4 = ((al.c) (obj3)).j;
                            g2 = g2.a("v4vc");
                            if (g2 == null)
                            {
                                k = 0;
                            } else
                            {
                                obj4.a = g2.a("enabled", false);
                                if (!((al.e) (obj4)).a)
                                {
                                    k = 1;
                                } else
                                {
                                    obj4.b = new al.ae();
                                    obj5 = ((al.e) (obj4)).b;
                                    g3 = g2.a("limits");
                                    if (g3 == null)
                                    {
                                        k = 0;
                                    } else
                                    {
                                        obj5.a = g3.e("daily_play_cap");
                                        obj5.b = g3.e("custom_play_cap");
                                        obj5.c = g3.e("custom_play_cap_period");
                                        k = 1;
                                    }
                                    if (k == 0)
                                    {
                                        k = 0;
                                    } else
                                    {
                                        obj4.c = g2.e("reward_amount");
                                        obj4.d = g2.a("reward_name", "");
                                        obj4.e = g2.a("client_side", false);
                                        obj4.f = g2.e("videos_per_reward");
                                        k = 1;
                                    }
                                }
                            }
                            if (k == 0)
                            {
                                k = 0;
                            } else
                            {
                                obj3.k = q.c.g.a(((al.c) (obj3)).a);
                                k = 1;
                            }
                        }
                    }
                }
            }
            if (k != 0)
            {
                break label1;
            }
            k = 0;
        }
          goto _L8
        ((al.f) (obj1)).a.add(obj3);
        l++;
          goto _L9
        k = 1;
          goto _L8
    }

    final void a()
    {
        if (e || q.q)
        {
            e = false;
            c = true;
            f = false;
            h.postDelayed(i, 60000L);
            return;
        } else
        {
            f = true;
            return;
        }
    }

    public final void a(b b1)
    {
        q.i = true;
        a.g g1;
        if (b1.i)
        {
            aj.c.b("Finished downloading:");
            aj.c.b(b1.c);
            g1 = ai.a(b1.m);
            if (g1 == null)
            {
                aj.a.b("Invalid JSON in manifest.  Raw data:");
                aj.a.b(b1.m);
                return;
            }
        } else
        {
            aj.c.b("Error downloading:");
            aj.c.b(b1.c);
            return;
        }
        if (a(g1))
        {
            aj.b.b("Ad manifest updated.");
            Object obj = new ae("manifest.txt");
            b1 = b1.m;
            obj = ((ae) (obj)).a();
            int l = b1.length();
            for (int k = 0; k < l; k++)
            {
                ((av) (obj)).a(b1.charAt(k));
            }

            ((av) (obj)).c();
            b = true;
            j.a();
            if (j.i == null || j.i.equals(""))
            {
                j.i = "all";
            }
            if (j.j == null || j.j.equals(""))
            {
                j.j = "all";
            }
            q.f();
            return;
        } else
        {
            aj.b.b("Invalid manifest.");
            return;
        }
    }

    final boolean a(String s1, boolean flag)
    {
        if (flag)
        {
            return b(s1, flag);
        }
        if (!b)
        {
            return aj.c.b("Ads are not ready to be played, as they are still downloading.");
        }
        if (flag)
        {
            return j.a(s1, true, false);
        } else
        {
            return j.a(s1, false, true);
        }
    }

    final void b()
    {
        if (s.b() >= g)
        {
            c = true;
        }
        if (!c) goto _L2; else goto _L1
_L1:
        c = false;
        if (af.a() < 32) goto _L2; else goto _L3
_L3:
        g = s.b() + 600D;
        q.i = true;
        aj.b.b("Refreshing manifest");
        if (ao.c()) goto _L5; else goto _L4
_L4:
        aj.b.b("Not connected to network.");
        aj.a.a("attempted_load:").a(d).a(" is_configured:").b(b);
        if (!d)
        {
            d = true;
            if (!b)
            {
                aj.b.b("Attempting to load backup manifest from file.");
                ae ae1 = new ae("manifest.txt");
                a.g g1 = ai.a(ae1);
                if (g1 != null)
                {
                    if (a(g1))
                    {
                        b = true;
                        j.a();
                    } else
                    {
                        aj.b.b("Invalid manifest loaded.");
                        ae1.c();
                        b = false;
                    }
                }
            }
        }
_L2:
        if (!ao.c())
        {
            if (q.t)
            {
                q.f();
            }
            q.t = false;
            return;
        }
        break MISSING_BLOCK_LABEL_561;
_L5:
        aw aw1;
        aw1 = new aw();
        aw1.a(ab.c);
        aw1.a("?app_id=");
        aw1.a(a.a.j);
        aw1.a("&zones=");
        if (a.a.k != null)
        {
            String as1[] = a.a.k;
            int l = as1.length;
            int k = 0;
            boolean flag = true;
            while (k < l) 
            {
                String s2 = as1[k];
                if (flag)
                {
                    flag = false;
                } else
                {
                    aw1.a(",");
                }
                aw1.a(s2);
                k++;
            }
        }
        String s1;
        String s3;
        if (q.c.e.j == null)
        {
            s1 = "";
        } else
        {
            s1 = q.c.e.j;
        }
        s3 = (new StringBuilder()).append(q.c.e.i).toString();
        aw1.a(a.a.h);
        aw1.a("&carrier=");
        aw1.a(ao.a(a.a.w));
        aw1.a("&network_type=");
        if (!ao.a())
        {
            break; /* Loop/switch isn't completed */
        }
        aw1.a("wifi");
_L7:
        aw1.a("&custom_id=");
        aw1.a(ao.a(a.a.x));
        aw1.a("&sid=");
        aw1.a(s1);
        aw1.a("&s_imp_count=");
        aw1.a(s3);
        aj.b.b("Downloading ad manifest from");
        aj.b.b(aw1);
        r.a(new b(a, aw1.toString(), this));
        if (true) goto _L2; else goto _L6
_L6:
        if (ao.b())
        {
            aw1.a("cell");
        } else
        {
            aw1.a("none");
        }
          goto _L7
        if (true) goto _L2; else goto _L8
_L8:
        if (!q.t)
        {
            q.f();
        }
        q.t = true;
        return;
    }

    public final boolean b(String s1, boolean flag)
    {
        if (!b)
        {
            return false;
        }
        if (flag)
        {
            return j.a(s1, true, false);
        } else
        {
            return j.a(s1, false, true);
        }
    }
}
