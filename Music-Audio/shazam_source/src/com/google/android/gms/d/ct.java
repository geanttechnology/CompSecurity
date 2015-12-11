// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.w;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.google.android.gms.d:
//            gm, hd, ae, af, 
//            ab, ad, gv, ce, 
//            he

public final class ct
{
    static final class a
    {

        static int a = 60000;
        static int b = 10000;

    }

    public static interface b
    {

        public abstract void a(Object obj);
    }

    public static final class c
        implements b
    {

        public final void a(Object obj)
        {
        }

        public c()
        {
        }
    }

    public static final class d extends hd
    {

        final e a;
        private final Object e = new Object();
        private boolean f;

        public final void a()
        {
label0:
            {
                synchronized (e)
                {
                    if (!f)
                    {
                        break label0;
                    }
                }
                return;
            }
            f = true;
            a(new hc.c(this) {

                final d a;

                public final void a(Object obj)
                {
                    obj = (ae)obj;
                    com.google.android.gms.ads.internal.util.client.b.a(2);
                    ((af)obj).a();
                }

            
            {
                a = d1;
                super();
            }
            }, ((hc.a) (new hc.b())));
            a(new hc.c(this) {

                final d a;

                public final void a(Object obj)
                {
                    com.google.android.gms.ads.internal.util.client.b.a(2);
                    a.a.b();
                }

            
            {
                a = d1;
                super();
            }
            }, new hc.a(this) {

                final d a;

                public final void a()
                {
                    a.a.b();
                }

            
            {
                a = d1;
                super();
            }
            });
            obj;
            JVM INSTR monitorexit ;
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public d(e e1)
        {
            a = e1;
        }
    }

    public static final class e extends hd
    {

        b a;
        private final Object e = new Object();
        private boolean f;
        private int g;

        private void f()
        {
            Object obj = e;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            boolean flag;
            if (g >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.a(flag);
            if (!f || g != 0)
            {
                break MISSING_BLOCK_LABEL_61;
            }
            com.google.android.gms.ads.internal.util.client.b.a(2);
            a(new hc.c(this) {

                final e a;

                public final void a(Object obj)
                {
                    gm.a(new Runnable(this, (ab)obj) {

                        final ab a;
                        final e._cls3 b;

                        public final void run()
                        {
                            b.a.a.a(a);
                            a.a();
                        }

            
            {
                b = _pcls3;
                a = ab1;
                super();
            }
                    });
                }

            
            {
                a = e1;
                super();
            }
            }, new hc.b());
_L2:
            obj;
            JVM INSTR monitorexit ;
            return;
            com.google.android.gms.ads.internal.util.client.b.a(2);
            if (true) goto _L2; else goto _L1
_L1:
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final d a()
        {
            d d1 = new d(this);
            Object obj = e;
            obj;
            JVM INSTR monitorenter ;
            a(new hc.c(this, d1) {

                final d a;
                final e b;

                public final void a(Object obj)
                {
                    obj = (ab)obj;
                    com.google.android.gms.ads.internal.util.client.b.a(2);
                    a.a(((ab) (obj)).b());
                }

            
            {
                b = e1;
                a = d1;
                super();
            }
            }, new hc.a(this, d1) {

                final d a;
                final e b;

                public final void a()
                {
                    com.google.android.gms.ads.internal.util.client.b.a(2);
                    a.d();
                }

            
            {
                b = e1;
                a = d1;
                super();
            }
            });
            Exception exception;
            boolean flag;
            if (g >= 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.a(flag);
            g = g + 1;
            obj;
            JVM INSTR monitorexit ;
            return d1;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected final void b()
        {
            Object obj = e;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            boolean flag;
            if (g > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.a(flag);
            com.google.android.gms.ads.internal.util.client.b.a(2);
            g = g - 1;
            f();
            obj;
            JVM INSTR monitorexit ;
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public final void c()
        {
            boolean flag = true;
            Object obj = e;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            if (g < 0)
            {
                flag = false;
            }
            w.a(flag);
            com.google.android.gms.ads.internal.util.client.b.a(2);
            f = true;
            f();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public e(b b1)
        {
            a = b1;
            f = false;
            g = 0;
        }
    }


    final Object a;
    final Context b;
    final String c;
    final VersionInfoParcel d;
    b e;
    e f;
    int g;
    private b h;

    public ct(Context context, VersionInfoParcel versioninfoparcel, String s)
    {
        a = new Object();
        g = 1;
        c = s;
        b = context.getApplicationContext();
        d = versioninfoparcel;
        e = new c();
        h = new c();
    }

    public ct(Context context, VersionInfoParcel versioninfoparcel, String s, b b1, b b2)
    {
        this(context, versioninfoparcel, s);
        e = b1;
        h = b2;
    }

    protected final e a()
    {
        e e1 = new e(h);
        gm.a(new Runnable(e1) {

            final e a;
            final ct b;

            public final void run()
            {
                ad ad1 = new ad(b.b, b.d, null);
                ad1.a(new ab.a(this, ad1) {

                    final ab a;
                    final _cls1 b;

                    public final void a()
                    {
                        (new Timer()).schedule(new TimerTask(this) {

                            final _cls1 a;

                            public final void run()
                            {
label0:
                                {
                                    synchronized (a.b.b.a)
                                    {
                                        if (a.b.a.e() != -1 && a.b.a.e() != 1)
                                        {
                                            break label0;
                                        }
                                    }
                                    return;
                                }
                                a.b.a.d();
                                gm.a(new Runnable(this) {

                                    final _cls1 a;

                                    public final void run()
                                    {
                                        a.a.a.a();
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                                com.google.android.gms.ads.internal.util.client.b.a(2);
                                obj;
                                JVM INSTR monitorexit ;
                                return;
                                exception;
                                obj;
                                JVM INSTR monitorexit ;
                                throw exception;
                            }

            
            {
                a = _pcls1;
                super();
            }
                        }, a.b);
                    }

            
            {
                b = _pcls1;
                a = ab;
                super();
            }
                });
                ad1.a("/jsLoaded", new ce(this, ad1) {

                    final ab a;
                    final _cls1 b;

                    public final void a(he he, Map map)
                    {
label0:
                        {
                            synchronized (b.b.a)
                            {
                                if (b.a.e() != -1 && b.a.e() != 1)
                                {
                                    break label0;
                                }
                            }
                            return;
                        }
                        b.b.g = 0;
                        b.b.e.a(a);
                        b.a.a(a);
                        b.b.f = b.a;
                        com.google.android.gms.ads.internal.util.client.b.a(2);
                        he;
                        JVM INSTR monitorexit ;
                        return;
                        map;
                        he;
                        JVM INSTR monitorexit ;
                        throw map;
                    }

            
            {
                b = _pcls1;
                a = ab;
                super();
            }
                });
                gv gv1 = new gv();
                ce ce = new ce(this, ad1, gv1) {

                    final ab a;
                    final gv b;
                    final _cls1 c;

                    public final void a(he he, Map map)
                    {
                        synchronized (c.b.a)
                        {
                            com.google.android.gms.ads.internal.util.client.b.a(4);
                            if (c.b.g == 0)
                            {
                                com.google.android.gms.ads.internal.util.client.b.a(4);
                                c.b.g = 2;
                                c.b.a();
                            }
                            a.b("/requestReload", (ce)b.a);
                        }
                        return;
                        map;
                        he;
                        JVM INSTR monitorexit ;
                        throw map;
                    }

            
            {
                c = _pcls1;
                a = ab1;
                b = gv1;
                super();
            }
                };
                gv1.a = ce;
                ad1.a("/requestReload", ce);
                if (b.c.endsWith(".js"))
                {
                    ad1.a(b.c);
                } else
                if (b.c.startsWith("<html>"))
                {
                    ad1.c(b.c);
                } else
                {
                    ad1.b(b.c);
                }
                (new Timer()).schedule(new TimerTask(this, ad1) {

                    final ab a;
                    final _cls1 b;

                    public final void run()
                    {
label0:
                        {
                            synchronized (b.b.a)
                            {
                                if (b.a.e() != -1 && b.a.e() != 1)
                                {
                                    break label0;
                                }
                            }
                            return;
                        }
                        b.a.d();
                        gm.a(new Runnable(this) {

                            final _cls4 a;

                            public final void run()
                            {
                                a.a.a();
                            }

            
            {
                a = _pcls4;
                super();
            }
                        });
                        com.google.android.gms.ads.internal.util.client.b.a(2);
                        obj;
                        JVM INSTR monitorexit ;
                        return;
                        exception;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                b = _pcls1;
                a = ab;
                super();
            }
                }, a.a);
            }

            
            {
                b = ct.this;
                a = e1;
                super();
            }
        });
        e1.a(new hc.c(e1) {

            final e a;
            final ct b;

            public final void a(Object obj)
            {
                synchronized (b.a)
                {
                    b.g = 0;
                    if (b.f != null && a != b.f)
                    {
                        com.google.android.gms.ads.internal.util.client.b.a(2);
                        b.f.c();
                    }
                    b.f = a;
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = ct.this;
                a = e1;
                super();
            }
        }, new hc.a(e1) {

            final e a;
            final ct b;

            public final void a()
            {
                synchronized (b.a)
                {
                    b.g = 1;
                    com.google.android.gms.ads.internal.util.client.b.a(2);
                    a.c();
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = ct.this;
                a = e1;
                super();
            }
        });
        return e1;
    }

    public final d b()
    {
label0:
        {
            d d1;
            synchronized (a)
            {
                if (f != null && f.e() != -1)
                {
                    break label0;
                }
                g = 2;
                f = a();
                d1 = f.a();
            }
            return d1;
        }
        d d2;
        if (g != 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        d2 = f.a();
        obj;
        JVM INSTR monitorexit ;
        return d2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (g != 1)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        g = 2;
        a();
        exception = f.a();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        if (g != 2)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        exception = f.a();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        exception = f.a();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }
}
