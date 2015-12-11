// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.mopub.c.b;
import com.mopub.c.g;
import com.mopub.c.i;
import com.mopub.common.c;
import com.mopub.common.c.a;
import com.mopub.common.d.d;
import com.mopub.common.d.m;
import com.mopub.common.f;
import com.mopub.d.l;
import com.mopub.d.s;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;

// Referenced classes of package com.mopub.mobileads:
//            as, u, s, c

public final class e
{

    private static final android.widget.FrameLayout.LayoutParams s = new android.widget.FrameLayout.LayoutParams(-2, -2, 17);
    private static final WeakHashMap t = new WeakHashMap();
    final long a = com.mopub.common.d.m.a();
    Context b;
    u c;
    as d;
    b e;
    boolean f;
    Handler g;
    int h;
    Map i;
    boolean j;
    boolean k;
    String l;
    Location m;
    boolean n;
    String o;
    int p;
    com.mopub.c.a q;
    Integer r;
    private final Runnable u = new Runnable() {

        final e a;

        public final void run()
        {
            com.mopub.mobileads.e.a(a);
        }

            
            {
                a = e.this;
                super();
            }
    };
    private final com.mopub.c.a.a v = new com.mopub.c.a.a() {

        final e a;

        public final void a(b b1)
        {
            e e1 = a;
            e1.h = 1;
            e1.e = b1;
            String s1;
            int i1;
            if (e1.e.i == null)
            {
                i1 = e1.p;
            } else
            {
                i1 = e1.e.i.intValue();
            }
            e1.p = i1;
            e1.r = e1.e.j;
            e1.b();
            b1 = e1.e;
            com.mopub.common.c.a.c("Performing custom event.");
            s1 = b1.m;
            if (s1 != null)
            {
                b1 = new c.a(e1, s1, new TreeMap(b1.n));
            } else
            {
                com.mopub.common.c.a.c("Failed to create custom event.");
                b1 = null;
            }
            if (b1 != null)
            {
                b1.a();
            }
            e1.d();
        }

        public final void a(s s1)
        {
            a.a(s1);
        }

            
            {
                a = e.this;
                super();
            }
    };
    private boolean w;
    private String x;
    private boolean y;

    public e(Context context, u u1)
    {
        h = 1;
        i = new HashMap();
        j = true;
        k = true;
        b = context;
        c = u1;
        p = -1;
        d = new as(b.getApplicationContext(), com.mopub.b.e.c(b));
        r = Integer.valueOf(60000);
        g = new Handler();
    }

    static android.widget.FrameLayout.LayoutParams a(e e1, View view)
    {
        Integer integer;
        Integer integer1;
        if (e1.e != null)
        {
            integer = e1.e.g;
            integer1 = e1.e.h;
        } else
        {
            integer1 = null;
            integer = null;
        }
        if (integer != null && integer1 != null)
        {
            boolean flag;
            if (t.get(view) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag && integer.intValue() > 0 && integer1.intValue() > 0)
            {
                return new android.widget.FrameLayout.LayoutParams(com.mopub.common.d.d.c(integer.intValue(), e1.b), com.mopub.common.d.d.c(integer1.intValue(), e1.b), 17);
            }
        }
        return s;
    }

    static void a(e e1)
    {
        e1.a();
    }

    private void a(String s1)
    {
        if (s1 != null)
        {
            com.mopub.common.c.a.b((new StringBuilder("Loading url: ")).append(s1).toString());
            if (w)
            {
                if (!TextUtils.isEmpty(o))
                {
                    com.mopub.common.c.a.c((new StringBuilder("Already loading an ad for ")).append(o).append(", wait to finish.").toString());
                    return;
                }
            } else
            {
                x = s1;
                w = true;
                s1 = x;
                u u1 = c;
                if (u1 == null || b == null)
                {
                    com.mopub.common.c.a.b("Can't load an ad in this ad view because it was destroyed.");
                    b();
                    return;
                } else
                {
                    s1 = new com.mopub.c.a(s1, u1.getAdFormat(), o, b, v);
                    com.mopub.c.i.a(b).b(s1);
                    q = s1;
                    return;
                }
            }
        }
    }

    private void b(com.mopub.mobileads.s s1)
    {
        com.mopub.common.c.a.c("Ad failed to load.");
        b();
        u u1 = c;
        if (u1 == null)
        {
            return;
        } else
        {
            d();
            u1.a(s1);
            return;
        }
    }

    final void a()
    {
        y = true;
        if (TextUtils.isEmpty(o))
        {
            com.mopub.common.c.a.b("Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
            return;
        }
        if (b == null) goto _L2; else goto _L1
_L1:
        if (b.checkCallingPermission("android.permission.ACCESS_NETWORK_STATE") != -1) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        if (!flag)
        {
            com.mopub.common.c.a.b("Can't load an ad because there is no network connectivity.");
            d();
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        NetworkInfo networkinfo = ((ConnectivityManager)b.getSystemService("connectivity")).getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected())
        {
            flag = true;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
        String s1;
        if (d == null)
        {
            s1 = null;
        } else
        {
            s1 = d.a(o).b(l).a(m).c("ads.mopub.com");
        }
        a(s1);
        return;
    }

    final void a(s s1)
    {
        Context context;
        com.mopub.d.i i1;
        if (s1 instanceof g)
        {
            g g1 = (g)s1;
            if (g1.b != null)
            {
                r = g1.b;
            }
        }
        context = b;
        i1 = s1.c;
        if (!(s1 instanceof g)) goto _L2; else goto _L1
_L1:
        static final class _cls4
        {

            static final int a[];

            static 
            {
                a = new int[com.mopub.c.g.a.values().length];
                try
                {
                    a[com.mopub.c.g.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.mopub.c.g.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.mopub.mobileads._cls4.a[((g)s1).a.ordinal()];
        JVM INSTR tableswitch 1 2: default 80
    //                   1 111
    //                   2 118;
           goto _L3 _L4 _L5
_L3:
        s1 = s.q;
_L7:
        if (s1 == com.mopub.mobileads.s.c)
        {
            h = h + 1;
        }
        b();
        b(s1);
        return;
_L4:
        s1 = com.mopub.mobileads.s.b;
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = com.mopub.mobileads.s.a;
        continue; /* Loop/switch isn't completed */
_L2:
        if (i1 == null)
        {
            if (!com.mopub.common.d.c.a(context))
            {
                s1 = com.mopub.mobileads.s.f;
            } else
            {
                s1 = s.q;
            }
        } else
        if (s1.c.a >= 400)
        {
            s1 = com.mopub.mobileads.s.c;
        } else
        {
            s1 = s.q;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    final void a(com.mopub.mobileads.s s1)
    {
        w = false;
        StringBuilder stringbuilder = new StringBuilder("MoPubErrorCode: ");
        if (s1 == null)
        {
            s1 = "";
        } else
        {
            s1 = s1.toString();
        }
        stringbuilder.append(s1);
        if (e == null)
        {
            s1 = "";
        } else
        {
            s1 = e.e;
        }
        if (!TextUtils.isEmpty(s1))
        {
            com.mopub.common.c.a.b((new StringBuilder("Loading failover url: ")).append(s1).toString());
            a(((String) (s1)));
            return;
        } else
        {
            b(com.mopub.mobileads.s.a);
            return;
        }
    }

    final void a(boolean flag)
    {
        boolean flag1;
        if (y && j != flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            String s1;
            if (flag)
            {
                s1 = "enabled";
            } else
            {
                s1 = "disabled";
            }
            com.mopub.common.c.a.b((new StringBuilder("Refresh ")).append(s1).append(" for ad unit (").append(o).append(").").toString());
        }
        j = flag;
        if (y && j)
        {
            d();
        } else
        if (!j)
        {
            e();
            return;
        }
    }

    final void b()
    {
        w = false;
        if (q != null)
        {
            if (!((l) (q)).h)
            {
                q.h = true;
            }
            q = null;
        }
    }

    public final com.mopub.common.b c()
    {
        if (o != null && e != null)
        {
            return new com.mopub.common.b(o, com.mopub.common.f.a(b), e);
        } else
        {
            return null;
        }
    }

    final void d()
    {
        e();
        if (j && r != null && r.intValue() > 0)
        {
            g.postDelayed(u, Math.min(0x927c0L, (long)r.intValue() * (long)Math.pow(1.5D, h)));
        }
    }

    final void e()
    {
        g.removeCallbacks(u);
    }


    // Unreferenced inner class com/mopub/mobileads/e$3

/* anonymous class */
    final class _cls3
        implements Runnable
    {

        final View a;
        final e b;

        public final void run()
        {
            u u1 = b.c;
            if (u1 == null)
            {
                return;
            } else
            {
                u1.removeAllViews();
                u1.addView(a, com.mopub.mobileads.e.a(b, a));
                return;
            }
        }

            
            {
                b = e.this;
                a = view;
                super();
            }
    }

}
