// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.jirbo.adcolony:
//            l, bx, ak, k, 
//            bl, bk, bg, h, 
//            bt, bq, ap, bh, 
//            cx, dh, be, bd, 
//            dd

class bc
    implements l
{

    be a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    double g;
    Handler h;
    Runnable i;
    bx j;

    bc(be be1)
    {
        e = true;
        f = false;
        j = new bx();
        a = be1;
        if (Looper.myLooper() == null)
        {
            Looper.prepare();
        }
        h = new Handler();
        i = new Runnable() {

            final bc a;

            public void run()
            {
                a.e = true;
                if (a.f)
                {
                    a.e();
                }
            }

            
            {
                a = bc.this;
                super();
            }
        };
    }

    void a()
    {
    }

    public void a(k k1)
    {
        ak.i = true;
        h h1;
        if (k1.i)
        {
            bl.c.b("Finished downloading:");
            bl.c.b(k1.c);
            h1 = bk.b(k1.m);
            if (h1 == null)
            {
                bl.a.b("Invalid JSON in manifest.  Raw data:");
                bl.a.b(k1.m);
                return;
            }
        } else
        {
            bl.c.b("Error downloading:");
            bl.c.b(k1.c);
            return;
        }
        if (a(h1))
        {
            bl.b.b("Ad manifest updated.");
            (new bg("manifest.txt")).a(k1.m);
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
            ak.f();
            return;
        } else
        {
            bl.b.b("Invalid manifest.");
            return;
        }
    }

    boolean a(h h1)
    {
        while (h1 == null || !h1.d("status").equals("success") || !j.a(h1.a("app"))) 
        {
            return false;
        }
        bl.a.b("Finished parsing manifest");
        if (!j.h.equalsIgnoreCase("none"))
        {
            bl.c.b("Enabling debug logging.");
            ak.a(1);
        } else
        {
            ak.a(2);
        }
        return true;
    }

    boolean a(String s, boolean flag)
    {
        boolean flag2 = false;
        int i1 = 0;
        do
        {
label0:
            {
                boolean flag1 = flag2;
                if (i1 < j.n.a())
                {
                    bq bq1 = j.n.a(i1);
                    if (!bq1.c(flag) || !bq1.a.equals(s))
                    {
                        break label0;
                    }
                    flag1 = true;
                }
                return flag1;
            }
            i1++;
        } while (true);
    }

    void b()
    {
        bg bg1;
label0:
        {
            bl.b.b("Attempting to load backup manifest from file.");
            bg1 = new bg("manifest.txt");
            h h1 = bk.b(bg1);
            if (h1 != null)
            {
                if (!a(h1))
                {
                    break label0;
                }
                b = true;
                j.a();
            }
            return;
        }
        bl.b.b("Invalid manifest loaded.");
        bg1.c();
        b = false;
    }

    boolean b(String s, boolean flag)
    {
        if (flag)
        {
            return c(s, flag);
        }
        if (!b)
        {
            return bl.c.b("Ads are not ready to be played, as they are still downloading.");
        }
        if (flag)
        {
            return j.a(s, true, false);
        } else
        {
            return j.a(s, false, true);
        }
    }

    String c()
    {
        if (!b)
        {
            return null;
        }
        String s = null;
        for (int i1 = 0; i1 < j.n.a(); i1++)
        {
            bq bq1 = j.n.a(i1);
            if (!bq1.d())
            {
                continue;
            }
            s = bq1.a;
            if (bq1.a())
            {
                return bq1.a;
            }
        }

        return s;
    }

    boolean c(String s, boolean flag)
    {
        if (!b)
        {
            return false;
        }
        if (flag)
        {
            return j.a(s, true, false);
        } else
        {
            return j.a(s, false, true);
        }
    }

    String d()
    {
        if (!b)
        {
            return null;
        }
        String s = null;
        for (int i1 = 0; i1 < j.n.a(); i1++)
        {
            bq bq1 = j.n.a(i1);
            if (!bq1.f())
            {
                continue;
            }
            s = bq1.a;
            if (bq1.a())
            {
                return bq1.a;
            }
        }

        return s;
    }

    void e()
    {
        if (e || ak.q)
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

    void f()
    {
        if (ap.b() >= g)
        {
            c = true;
        }
        if (c)
        {
            c = false;
            if (bh.c() >= 32)
            {
                g = ap.b() + 600D;
                g();
            }
        }
        if (!cx.c())
        {
            if (ak.t)
            {
                ak.f();
            }
            ak.t = false;
            return;
        }
        if (!ak.t)
        {
            ak.f();
        }
        ak.t = true;
    }

    void g()
    {
        boolean flag = true;
        ak.i = true;
        bl.b.b("Refreshing manifest");
        if (!cx.c())
        {
            bl.b.b("Not connected to network.");
            bl.a.a("attempted_load:").a(d).a(" is_configured:").b(b);
            if (!d)
            {
                d = true;
                if (!b)
                {
                    b();
                }
            }
            return;
        }
        dh dh1 = new dh();
        Object obj = a.a;
        dh1.a(bd.c);
        dh1.a("?app_id=");
        dh1.a(a.a.j);
        dh1.a("&zones=");
        if (a.a.k != null)
        {
            String as[] = a.a.k;
            int j1 = as.length;
            int i1 = 0;
            while (i1 < j1) 
            {
                String s = as[i1];
                if (flag)
                {
                    flag = false;
                } else
                {
                    dh1.a(",");
                }
                dh1.a(s);
                i1++;
            }
        }
        String s1;
        if (ak.c.e.j == null)
        {
            as = "";
        } else
        {
            as = ak.c.e.j;
        }
        s1 = (new StringBuilder()).append("").append(ak.c.e.i).toString();
        dh1.a(a.a.h);
        dh1.a("&carrier=");
        dh1.a(cx.a(a.a.w));
        dh1.a("&network_type=");
        if (cx.a())
        {
            dh1.a("wifi");
        } else
        if (cx.b())
        {
            dh1.a("cell");
        } else
        {
            dh1.a("none");
        }
        dh1.a("&custom_id=");
        dh1.a(cx.a(a.a.x));
        dh1.a("&sid=");
        dh1.a(as);
        dh1.a("&s_imp_count=");
        dh1.a(s1);
        bl.b.b("Downloading ad manifest from");
        bl.b.b(dh1);
        (new k(a, dh1.toString(), this)).a();
    }
}
