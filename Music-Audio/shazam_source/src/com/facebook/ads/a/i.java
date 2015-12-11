// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import com.facebook.ads.a.b.a;
import com.facebook.ads.a.b.k;
import com.facebook.ads.a.b.u;
import com.facebook.ads.a.b.v;
import com.facebook.ads.a.c.c;
import com.facebook.ads.a.c.d;
import com.facebook.ads.a.e.b;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.s;
import com.facebook.ads.e;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.facebook.ads.a:
//            a, b, c, f, 
//            d

public class i
    implements com.facebook.ads.a.e.b.a
{
    private static final class a extends com.facebook.ads.a.f.u
    {

        public final void run()
        {
            i i1 = (i)super.a.get();
            if (i1 == null)
            {
                return;
            } else
            {
                com.facebook.ads.a.i.a(i1);
                com.facebook.ads.a.i.b(i1);
                return;
            }
        }

        public a(i i1)
        {
            super(i1);
        }
    }

    private static final class b extends com.facebook.ads.a.f.u
    {

        public final void run()
        {
            i i1 = (i)super.a.get();
            if (i1 == null)
            {
                return;
            } else
            {
                com.facebook.ads.a.i.c(i1);
                return;
            }
        }

        public b(i i1)
        {
            super(i1);
        }
    }

    private final class c extends BroadcastReceiver
    {

        final i a;

        public final void onReceive(Context context, Intent intent)
        {
            context = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(context))
            {
                i.h(a);
            } else
            if ("android.intent.action.SCREEN_ON".equals(context))
            {
                com.facebook.ads.a.i.c(a);
                return;
            }
        }

        private c()
        {
            a = i.this;
            super();
        }

        c(byte byte0)
        {
            this();
        }
    }


    private static final String c = com/facebook/ads/a/i.getSimpleName();
    protected com.facebook.ads.a.b a;
    public volatile boolean b;
    private final Context d;
    private final String e;
    private final com.facebook.ads.a.e.b f = new com.facebook.ads.a.e.b();
    private final Handler g = new Handler();
    private final Runnable h = new a(this);
    private final Runnable i = new b(this);
    private volatile boolean j;
    private boolean k;
    private com.facebook.ads.a.b.a l;
    private View m;
    private com.facebook.ads.a.c.c n;
    private com.facebook.ads.a.c.e o;
    private f p;
    private com.facebook.ads.a.d q;
    private e r;
    private int s;
    private final c t = new c((byte)0);
    private boolean u;

    public i(Context context, String s1, f f1, e e1, com.facebook.ads.a.d d1, boolean flag)
    {
        d = context;
        e = s1;
        p = f1;
        r = e1;
        q = d1;
        s = 1;
        f.b = this;
        k = flag;
        if (!k)
        {
            context = new IntentFilter("android.intent.action.SCREEN_ON");
            context.addAction("android.intent.action.SCREEN_OFF");
            d.registerReceiver(t, context);
            u = true;
        }
    }

    static View a(i i1, View view)
    {
        i1.m = view;
        return view;
    }

    static com.facebook.ads.a.b.a a(i i1, com.facebook.ads.a.b.a a1)
    {
        i1.l = a1;
        return a1;
    }

    static void a(com.facebook.ads.a.b.a a1)
    {
        b(a1);
    }

    static boolean a(i i1)
    {
        i1.j = false;
        return false;
    }

    private static void b(com.facebook.ads.a.b.a a1)
    {
        if (a1 != null)
        {
            a1.b();
        }
    }

    static void b(i i1)
    {
        i1.b();
    }

    static void c(i i1)
    {
        i1.e();
    }

    static void d(i i1)
    {
        i1.i();
    }

    static Handler e(i i1)
    {
        return i1.g;
    }

    static com.facebook.ads.a.b.a f(i i1)
    {
        return i1.l;
    }

    static void g()
    {
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            throw new IllegalStateException("Adapter listener must be called on the main thread.");
        } else
        {
            return;
        }
    }

    static boolean g(i i1)
    {
        return i1.b;
    }

    private com.facebook.ads.a.e.a h()
    {
        if (r == null)
        {
            return com.facebook.ads.a.e.a.d;
        }
        if (r == e.b)
        {
            return com.facebook.ads.a.e.a.c;
        } else
        {
            return com.facebook.ads.a.e.a.b;
        }
    }

    static void h(i i1)
    {
        i1.f();
    }

    static com.facebook.ads.a.c.e i(i i1)
    {
        return i1.o;
    }

    private void i()
    {
        Object obj;
        Object obj1;
        com.facebook.ads.a.b.a a1;
        do
        {
            obj1 = n;
            if (((com.facebook.ads.a.c.c) (obj1)).b < ((com.facebook.ads.a.c.c) (obj1)).a.size())
            {
                obj1.b = ((com.facebook.ads.a.c.c) (obj1)).b + 1;
                obj = (com.facebook.ads.a.c.a)((com.facebook.ads.a.c.c) (obj1)).a.get(((com.facebook.ads.a.c.c) (obj1)).b - 1);
            } else
            {
                obj = null;
            }
            if (obj == null)
            {
                a.a(com.facebook.ads.a.a.c.a(""));
                e();
                return;
            }
            String s1 = ((com.facebook.ads.a.c.a) (obj)).b;
            a1 = com.facebook.ads.a.b.k.a(s1, ((com.facebook.ads.a.c.c) (obj1)).c.a());
            if (a1 != null)
            {
                break;
            }
            Log.e(c, (new StringBuilder("Adapter does not exist: ")).append(s1).toString());
        } while (true);
        if (h() != a1.a())
        {
            a.a(com.facebook.ads.a.a.g.a(""));
            return;
        }
        HashMap hashmap = new HashMap();
        obj1 = ((com.facebook.ads.a.c.c) (obj1)).c;
        hashmap.put("data", ((com.facebook.ads.a.c.a) (obj)).c);
        hashmap.put("definition", obj1);
        if (o == null)
        {
            a.a(com.facebook.ads.a.a.a.a("environment is empty"));
        }
        static final class _cls7
        {

            static final int a[];

            static 
            {
                a = new int[com.facebook.ads.a.e.a.values().length];
                try
                {
                    a[com.facebook.ads.a.e.a.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.facebook.ads.a.e.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.facebook.ads.a.e.a.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.facebook.ads.a._cls7.a[a1.a().ordinal()])
        {
        default:
            Log.e(c, "attempt unexpected adapter type");
            return;

        case 2: // '\002'
            obj = (com.facebook.ads.a.b.b)a1;
            obj1 = new Runnable(((com.facebook.ads.a.b.b) (obj))) {

                final com.facebook.ads.a.b.b a;
                final i b;

                public final void run()
                {
                    com.facebook.ads.a.i.a(a);
                    com.facebook.ads.a.i.d(b);
                }

            
            {
                b = i.this;
                a = b1;
                super();
            }
            };
            g.postDelayed(((Runnable) (obj1)), 10000L);
            ((com.facebook.ads.a.b.b) (obj)).a(d, new com.facebook.ads.a.b.c(((Runnable) (obj1))) {

                final Runnable a;
                final i b;

                public final void a()
                {
                    com.facebook.ads.a.i.g();
                    b.a.c();
                }

                public final void a(com.facebook.ads.a.b.b b1)
                {
                    com.facebook.ads.a.i.g();
                    com.facebook.ads.a.i.e(b).removeCallbacks(a);
                    com.facebook.ads.a.i.a(b1);
                    com.facebook.ads.a.i.d(b);
                }

                public final void a(com.facebook.ads.a.b.b b1, View view)
                {
                    com.facebook.ads.a.i.g();
                    com.facebook.ads.a.i.e(b).removeCallbacks(a);
                    com.facebook.ads.a.b.a a2 = i.f(b);
                    com.facebook.ads.a.i.a(b, b1);
                    com.facebook.ads.a.i.a(b, view);
                    if (!com.facebook.ads.a.i.g(b))
                    {
                        b.a.a();
                        return;
                    } else
                    {
                        b.a.a(view);
                        com.facebook.ads.a.i.a(a2);
                        com.facebook.ads.a.i.c(b);
                        return;
                    }
                }

                public final void b()
                {
                    com.facebook.ads.a.i.g();
                    b.a.b();
                }

            
            {
                b = i.this;
                a = runnable;
                super();
            }
            }, hashmap);
            return;

        case 1: // '\001'
            obj = (com.facebook.ads.a.b.d)a1;
            obj1 = new Runnable(((com.facebook.ads.a.b.d) (obj))) {

                final com.facebook.ads.a.b.d a;
                final i b;

                public final void run()
                {
                    com.facebook.ads.a.i.a(a);
                    com.facebook.ads.a.i.d(b);
                }

            
            {
                b = i.this;
                a = d1;
                super();
            }
            };
            g.postDelayed(((Runnable) (obj1)), 10000L);
            ((com.facebook.ads.a.b.d) (obj)).a(d, new com.facebook.ads.a.b.e(((Runnable) (obj1))) {

                final Runnable a;
                final i b;

                public final void a()
                {
                    com.facebook.ads.a.i.g();
                    b.a.c();
                }

                public final void a(com.facebook.ads.a.b.d d1)
                {
                    com.facebook.ads.a.i.g();
                    com.facebook.ads.a.i.e(b).removeCallbacks(a);
                    com.facebook.ads.a.i.a(b, d1);
                    b.a.a();
                    com.facebook.ads.a.i.c(b);
                }

                public final void a(String s2, boolean flag)
                {
                    com.facebook.ads.a.i.g();
                    b.a.b();
                    boolean flag1;
                    if (!com.facebook.ads.a.f.s.a(s2))
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (flag && flag1)
                    {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        if (!(i.i(b).d instanceof Activity))
                        {
                            intent.addFlags(0x10000000);
                        }
                        intent.setData(Uri.parse(s2));
                        i.i(b).d.startActivity(intent);
                    }
                }

                public final void b()
                {
                    com.facebook.ads.a.i.g();
                    b.a.d();
                }

                public final void b(com.facebook.ads.a.b.d d1)
                {
                    com.facebook.ads.a.i.g();
                    com.facebook.ads.a.i.e(b).removeCallbacks(a);
                    com.facebook.ads.a.i.a(d1);
                    com.facebook.ads.a.i.d(b);
                }

                public final void c()
                {
                    com.facebook.ads.a.i.g();
                    b.a.e();
                }

            
            {
                b = i.this;
                a = runnable;
                super();
            }
            }, hashmap);
            return;

        case 3: // '\003'
            obj = (u)a1;
            break;
        }
        obj1 = new Runnable(((u) (obj))) {

            final u a;
            final i b;

            public final void run()
            {
                com.facebook.ads.a.i.a(a);
                com.facebook.ads.a.i.d(b);
            }

            
            {
                b = i.this;
                a = u1;
                super();
            }
        };
        g.postDelayed(((Runnable) (obj1)), 10000L);
        ((u) (obj)).a(d, new v(((Runnable) (obj1))) {

            final Runnable a;
            final i b;

            public final void a(u u1)
            {
                com.facebook.ads.a.i.g();
                com.facebook.ads.a.i.e(b).removeCallbacks(a);
                com.facebook.ads.a.i.a(b, u1);
                b.a.a();
            }

            public final void b(u u1)
            {
                com.facebook.ads.a.i.g();
                com.facebook.ads.a.i.e(b).removeCallbacks(a);
                com.facebook.ads.a.i.a(u1);
                com.facebook.ads.a.i.d(b);
            }

            
            {
                b = i.this;
                a = runnable;
                super();
            }
        }, hashmap);
    }

    public final d a()
    {
        if (n == null)
        {
            return null;
        } else
        {
            return n.c;
        }
    }

    public final void a(com.facebook.ads.a.b b1)
    {
        a = b1;
    }

    public final void a(com.facebook.ads.a.c c1)
    {
        a.a(c1);
        if (k || j)
        {
            return;
        }
        switch (c1.a.o)
        {
        case 1001: 
        default:
            return;

        case 1000: 
        case 1002: 
            switch (com.facebook.ads.a._cls7.a[h().ordinal()])
            {
            default:
                return;

            case 2: // '\002'
                g.postDelayed(h, 30000L);
                break;
            }
            break;
        }
        j = true;
    }

    public final void a(com.facebook.ads.a.e.e e1)
    {
        e1 = ((com.facebook.ads.a.e.d) (e1)).a;
        if (e1 == null || ((com.facebook.ads.a.c.c) (e1)).c == null)
        {
            throw new IllegalStateException("invalid placement in response");
        } else
        {
            n = e1;
            i();
            return;
        }
    }

    public final void b()
    {
        o = new com.facebook.ads.a.c.e(d, e, r, p, q, s, com.facebook.ads.d.a(d));
        com.facebook.ads.a.e.b b1 = f;
        Object obj = d;
        com.facebook.ads.a.c.e e1 = o;
        b1.a();
        if (!com.facebook.ads.a.e.b.a(((Context) (obj))))
        {
            b1.a(new com.facebook.ads.a.c(com.facebook.ads.a.a.b, "No network connection"));
            return;
        }
        b1.c = e1;
        if (com.facebook.ads.a.f.d.a(e1))
        {
            obj = com.facebook.ads.a.f.d.c(e1);
            if (obj != null)
            {
                b1.a(((String) (obj)));
                return;
            } else
            {
                b1.a(com.facebook.ads.a.a.d.a(null));
                return;
            }
        } else
        {
            com.facebook.ads.a.e.b.d.submit(new com.facebook.ads.a.e.b._cls1(b1, ((Context) (obj)), e1));
            return;
        }
    }

    public final void c()
    {
        com.facebook.ads.a.e.a a1;
        if (l == null)
        {
            throw new IllegalStateException("no adapter ready to start");
        }
        if (b)
        {
            throw new IllegalStateException("ad already started");
        }
        b = true;
        a1 = l.a();
        com.facebook.ads.a._cls7.a[a1.ordinal()];
        JVM INSTR tableswitch 1 3: default 84
    //                   1 95
    //                   2 107
    //                   3 130;
           goto _L1 _L2 _L3 _L4
_L1:
        Log.e(c, "start unexpected adapter type");
_L6:
        return;
_L2:
        ((com.facebook.ads.a.b.d)l).c();
        return;
_L3:
        if (m == null) goto _L6; else goto _L5
_L5:
        a.a(m);
        e();
        return;
_L4:
        u u1 = (u)l;
        if (!u1.s())
        {
            throw new IllegalStateException("ad is not ready or already displayed");
        } else
        {
            a.a(u1);
            return;
        }
    }

    public final void d()
    {
        if (u)
        {
            try
            {
                d.unregisterReceiver(t);
                u = false;
            }
            catch (Exception exception)
            {
                com.facebook.ads.a.f.c.a(com.facebook.ads.a.f.b.a(exception, "Error unregistering screen state receiever"));
            }
        }
        if (!b)
        {
            return;
        } else
        {
            f();
            b(l);
            m = null;
            b = false;
            return;
        }
    }

    public final void e()
    {
        if (!k && !j) goto _L2; else goto _L1
_L1:
        return;
_L2:
        com.facebook.ads.a._cls7.a[h().ordinal()];
        JVM INSTR tableswitch 1 2: default 48
    //                   1 49
    //                   2 110;
           goto _L3 _L4 _L5
_L3:
        return;
_L4:
        if (!com.facebook.ads.a.f.g.a(d))
        {
            g.postDelayed(i, 1000L);
        }
_L6:
        int i1;
        long l1;
        if (n == null)
        {
            l1 = 30000L;
        } else
        {
            l1 = n.c.b();
        }
        if (l1 > 0L)
        {
            g.postDelayed(h, l1);
            j = true;
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
        if (n == null)
        {
            i1 = 1;
        } else
        {
            i1 = n.c.e();
        }
        if (m != null && !com.facebook.ads.a.f.g.a(d, m, i1))
        {
            g.postDelayed(i, 1000L);
            return;
        }
          goto _L6
    }

    public final void f()
    {
        if (!j)
        {
            return;
        } else
        {
            g.removeCallbacks(h);
            j = false;
            return;
        }
    }

}
