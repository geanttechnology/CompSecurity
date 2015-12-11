// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;

import android.app.Activity;
import android.content.Intent;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.q;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.PurchasesManager;
import com.smule.android.network.managers.ap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.android.d:
//            j, m, k, o, 
//            c, h, n, p, 
//            q, u, r, f, 
//            e, t

public class g
{

    private static final String d = com/smule/android/d/g.getName();
    private static String e = null;
    m a;
    k b;
    o c;
    private c f;
    private j g;
    private boolean h;
    private Activity i;
    private String j;
    private boolean k;
    private boolean l;

    public g()
    {
        g = null;
        h = false;
        k = false;
        l = false;
        a = new m() {

            final g a;

            public void a(p p1, r r1)
            {
                aa.a(g.e(), (new StringBuilder()).append("Purchase finished: ").append(p1).append(", purchase: ").append(r1).toString());
                if (!p1.c()) goto _L2; else goto _L1
_L1:
                if (PurchasesManager.a().a(r1.c()).booleanValue())
                {
                    g.a(a).a(r1, a.b);
                } else
                {
                    com.smule.android.f.h.a().a("SUBSCRIPTION_PURCHASED", new Object[0]);
                    r1.f();
                    com.smule.android.d.g.b(a).a(true, r1.c());
                }
_L4:
                com.smule.android.d.g.b(a).a(com.smule.android.d.f.a(p1.a()));
                return;
_L2:
                if (com.smule.android.d.g.b(a) != null && g.d(a) != null)
                {
                    com.smule.android.d.g.b(a).a(com.smule.android.d.f.a(p1.a()), g.d(a));
                    g.a(a, null);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                a = g.this;
                super();
            }
        };
        b = new k() {

            final g a;

            public void a(r r1, p p1)
            {
                if (com.smule.android.d.g.b(a) != null && !g.e(a).isFinishing())
                {
                    aa.a(g.e(), (new StringBuilder()).append("Consume finished: ").append(p1).append(", purchase: ").append(r1).toString());
                    com.smule.android.d.g.b(a).a(p1.c(), r1.c());
                }
            }

            
            {
                a = g.this;
                super();
            }
        };
        c = new o() {

            final g a;

            public void a(p p1, com.smule.android.d.q q1)
            {
                if (p1.c())
                {
                    Object obj = q1.b("subs");
                    if (((List) (obj)).size() == 0)
                    {
                        g.a(a, Boolean.valueOf(false));
                    } else
                    {
                        q q2 = new q(((List) (obj)).size(), new Runnable(this) {

                            final _cls5 a;

                            public void run()
                            {
                                g.a(a.a, Boolean.valueOf(true));
                            }

            
            {
                a = _pcls5;
                super();
            }
                        });
                        obj = ((List) (obj)).iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            com.smule.android.network.core.b.a(new Runnable(this, q1.a((String)((Iterator) (obj)).next()), q2) {

                                final r a;
                                final q b;
                                final _cls5 c;

                                public void run()
                                {
                                    t.a(com.smule.android.d.e.a(a.e()), a.c(), a.b(), a.d(), a.h(), a.i());
                                    b.a();
                                    return;
                                    Exception exception;
                                    exception;
                                    b.a();
                                    throw exception;
                                }

            
            {
                c = _pcls5;
                a = r1;
                b = q1;
                super();
            }
                            });
                        }
                    }
                }
                if (com.smule.android.d.g.b(a) != null)
                {
                    com.smule.android.d.g.b(a).b(com.smule.android.d.f.a(p1.a()));
                }
            }

            
            {
                a = g.this;
                super();
            }
        };
    }

    static j a(g g1)
    {
        return g1.g;
    }

    static String a(g g1, String s)
    {
        g1.j = s;
        return s;
    }

    static void a(g g1, Boolean boolean1)
    {
        g1.a(boolean1);
    }

    private void a(Boolean boolean1)
    {
        com.smule.android.f.h.a().a("AutoRap.PURCHASES_RESTORED", boolean1);
    }

    public static void a(String s)
    {
        e = s;
    }

    private void a(List list, com.smule.android.d.h h1, boolean flag)
    {
        g.a(true, list, new o(h1, flag) {

            final com.smule.android.d.h a;
            final boolean b;
            final g c;

            public void a(p p1, com.smule.android.d.q q1)
            {
                if (p1.d())
                {
                    a.a(null);
                    if (b)
                    {
                        c.c.a(p1, q1);
                    }
                } else
                {
                    java.util.Map.Entry entry;
                    u u1;
                    for (Iterator iterator = q1.a.entrySet().iterator(); iterator.hasNext(); ap.a().a((String)entry.getKey(), u1.e.intValue(), u1.f))
                    {
                        entry = (java.util.Map.Entry)iterator.next();
                        u1 = (u)entry.getValue();
                    }

                    a.a(q1.a);
                    if (b)
                    {
                        c.c.a(p1, q1);
                        return;
                    }
                }
            }

            
            {
                c = g.this;
                a = h1;
                b = flag;
                super();
            }
        });
    }

    static boolean a(g g1, boolean flag)
    {
        g1.h = flag;
        return flag;
    }

    static c b(g g1)
    {
        return g1.f;
    }

    static boolean c(g g1)
    {
        return g1.h;
    }

    static String d(g g1)
    {
        return g1.j;
    }

    static Activity e(g g1)
    {
        return g1.i;
    }

    static String e()
    {
        return d;
    }

    public void a(Activity activity, c c1)
    {
        if (e == null)
        {
            throw new NullPointerException("Public key is not set");
        } else
        {
            f = c1;
            i = activity;
            g = new j(activity, e);
            g.a(true, com/smule/android/d/j.getName());
            g.a(new n() {

                final g a;

                public void a(p p1)
                {
                    if (!p1.c())
                    {
                        aa.b(g.e(), (new StringBuilder()).append("Problem setting up In-app Billing: ").append(p1).toString());
                    }
                    aa.a(g.e(), "Setup complete");
                    if (g.a(a) != null && com.smule.android.d.g.b(a) != null)
                    {
                        g g1 = a;
                        boolean flag;
                        if (p1.c() && g.a(a).b())
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        g.a(g1, flag);
                        com.smule.android.d.g.b(a).a(g.c(a));
                    }
                }

            
            {
                a = g.this;
                super();
            }
            });
            k = true;
            return;
        }
    }

    public void a(List list, com.smule.android.d.h h1)
    {
        a(list, h1, false);
    }

    public boolean a()
    {
        return g == null;
    }

    public boolean a(int i1, int j1, Intent intent)
    {
        if (g == null)
        {
            aa.e(d, "handleActivityResult - mHelper is null; returning false!");
            return false;
        } else
        {
            return g.a(i1, j1, intent);
        }
    }

    public void b()
    {
        if (!a())
        {
            g.a(c);
        }
    }

    public void b(String s)
    {
        if (i == null)
        {
            aa.b(d, (new StringBuilder()).append("Activity is null. Was created: ").append(k).append(". Was destroyed: ").append(l).toString());
            throw new NullPointerException("Activity is null, probably create() isn't called");
        } else
        {
            j = s;
            g.a(i, s, 1001, a);
            return;
        }
    }

    public void c()
    {
        try
        {
            if (g != null)
            {
                g.a();
            }
        }
        catch (Exception exception)
        {
            aa.b(d, "Failed to dispose IabHelper", exception);
        }
        g = null;
        i = null;
        l = true;
    }

    public boolean d()
    {
        return h;
    }

}
