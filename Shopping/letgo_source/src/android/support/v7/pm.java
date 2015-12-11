// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.x;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package android.support.v7:
//            tp, ms, mq, ug, 
//            mu, mt, ty, ox, 
//            ul

public class pm
{
    static class a
    {

        static int a = 60000;
        static int b = 10000;

    }

    public static interface b
    {

        public abstract void zzc(Object obj);
    }

    public static class c
        implements b
    {

        public void zzc(Object obj)
        {
        }

        public c()
        {
        }
    }

    public static class d extends ug
    {

        private final Object d = new Object();
        private final e e;
        private boolean f;

        static e a(d d1)
        {
            return d1.e;
        }

        public void a()
        {
label0:
            {
                synchronized (d)
                {
                    if (!f)
                    {
                        break label0;
                    }
                }
                return;
            }
            f = true;
            a(new uf.c(this) {

                final d a;

                public void a(mt mt1)
                {
                    zzb.v("Ending javascript session.");
                    ((mu)mt1).a();
                }

                public void zzc(Object obj)
                {
                    a((mt)obj);
                }

            
            {
                a = d1;
                super();
            }
            }, ((uf.a) (new uf.b())));
            a(new uf.c(this) {

                final d a;

                public void a(mt mt1)
                {
                    zzb.v("Releasing engine reference.");
                    d.a(a).b();
                }

                public void zzc(Object obj)
                {
                    a((mt)obj);
                }

            
            {
                a = d1;
                super();
            }
            }, new uf.a(this) {

                final d a;

                public void run()
                {
                    d.a(a).b();
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
            e = e1;
        }
    }

    public static class e extends ug
    {

        private final Object d = new Object();
        private b e;
        private boolean f;
        private int g;

        static b a(e e1)
        {
            return e1.e;
        }

        public d a()
        {
            d d1 = new d(this);
            Object obj = d;
            obj;
            JVM INSTR monitorenter ;
            a(new uf.c(this, d1) {

                final d a;
                final e b;

                public void a(mq mq1)
                {
                    zzb.v("Getting a new session for JS Engine.");
                    a.a(mq1.b());
                }

                public void zzc(Object obj)
                {
                    a((mq)obj);
                }

            
            {
                b = e1;
                a = d1;
                super();
            }
            }, new uf.a(this, d1) {

                final d a;
                final e b;

                public void run()
                {
                    zzb.v("Rejecting reference for JS Engine.");
                    a.e();
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
            x.a(flag);
            g = g + 1;
            obj;
            JVM INSTR monitorexit ;
            return d1;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected void b()
        {
            boolean flag = true;
            Object obj = d;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            if (g < 1)
            {
                flag = false;
            }
            x.a(flag);
            zzb.v("Releasing 1 reference for JS Engine");
            g = g - 1;
            d();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public void c()
        {
            boolean flag = true;
            Object obj = d;
            obj;
            JVM INSTR monitorenter ;
            Exception exception;
            if (g < 0)
            {
                flag = false;
            }
            x.a(flag);
            zzb.v("Releasing root reference. JS Engine will be destroyed once other references are released.");
            f = true;
            d();
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        protected void d()
        {
            Object obj = d;
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
            x.a(flag);
            if (!f || g != 0)
            {
                break MISSING_BLOCK_LABEL_61;
            }
            zzb.v("No reference is left (including root). Cleaning up engine.");
            a(new uf.c(this) {

                final e a;

                public void a(mq mq1)
                {
                    tp.a(new Runnable(this, mq1) {

                        final mq a;
                        final e._cls3 b;

                        public void run()
                        {
                            e.a(b.a).zzc(a);
                            a.a();
                        }

            
            {
                b = _pcls3;
                a = mq1;
                super();
            }
                    });
                }

                public void zzc(Object obj)
                {
                    a((mq)obj);
                }

            
            {
                a = e1;
                super();
            }
            }, new uf.b());
_L2:
            obj;
            JVM INSTR monitorexit ;
            return;
            zzb.v("There are still references to the engine. Not destroying.");
            if (true) goto _L2; else goto _L1
_L1:
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public e(b b1)
        {
            e = b1;
            f = false;
            g = 0;
        }
    }


    private final Object a;
    private final Context b;
    private final String c;
    private final VersionInfoParcel d;
    private b e;
    private b f;
    private e g;
    private int h;

    public pm(Context context, VersionInfoParcel versioninfoparcel, String s)
    {
        a = new Object();
        h = 1;
        c = s;
        b = context.getApplicationContext();
        d = versioninfoparcel;
        e = new c();
        f = new c();
    }

    public pm(Context context, VersionInfoParcel versioninfoparcel, String s, b b1, b b2)
    {
        this(context, versioninfoparcel, s);
        e = b1;
        f = b2;
    }

    static int a(pm pm1, int i)
    {
        pm1.h = i;
        return i;
    }

    static Context a(pm pm1)
    {
        return pm1.b;
    }

    static e a(pm pm1, e e1)
    {
        pm1.g = e1;
        return e1;
    }

    static VersionInfoParcel b(pm pm1)
    {
        return pm1.d;
    }

    private e c()
    {
        e e1 = new e(f);
        tp.a(new Runnable(e1) {

            final e a;
            final pm b;

            public void run()
            {
                mq mq1 = b.a(pm.a(b), pm.b(b));
                mq1.a(new mq.a(this, mq1) {

                    final mq a;
                    final _cls1 b;

                    public void a()
                    {
                        (new Timer()).schedule(new TimerTask(this) {

                            final _cls1 a;

                            public void run()
                            {
label0:
                                {
                                    synchronized (pm.c(a.b.b))
                                    {
                                        if (a.b.a.f() != -1 && a.b.a.f() != 1)
                                        {
                                            break label0;
                                        }
                                    }
                                    return;
                                }
                                a.b.a.e();
                                tp.a(new Runnable(this) {

                                    final _cls1 a;

                                    public void run()
                                    {
                                        a.a.a.a();
                                    }

            
            {
                a = _pcls1;
                super();
            }
                                });
                                zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
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
                a = mq;
                super();
            }
                });
                mq1.a("/jsLoaded", new ox(this, mq1) {

                    final mq a;
                    final _cls1 b;

                    public void zza(ul ul, Map map)
                    {
label0:
                        {
                            synchronized (pm.c(b.b))
                            {
                                if (b.a.f() != -1 && b.a.f() != 1)
                                {
                                    break label0;
                                }
                            }
                            return;
                        }
                        pm.a(b.b, 0);
                        pm.d(b.b).zzc(a);
                        b.a.a(a);
                        pm.a(b.b, b.a);
                        zzb.v("Successfully loaded JS Engine.");
                        ul;
                        JVM INSTR monitorexit ;
                        return;
                        map;
                        ul;
                        JVM INSTR monitorexit ;
                        throw map;
                    }

            
            {
                b = _pcls1;
                a = mq;
                super();
            }
                });
                ty ty1 = new ty();
                ox ox = new ox(this, mq1, ty1) {

                    final mq a;
                    final ty b;
                    final _cls1 c;

                    public void zza(ul ul, Map map)
                    {
                        synchronized (pm.c(c.b))
                        {
                            zzb.zzaD("JS Engine is requesting an update");
                            if (pm.e(c.b) == 0)
                            {
                                zzb.zzaD("Starting reload.");
                                pm.a(c.b, 2);
                                c.b.a();
                            }
                            a.b("/requestReload", (ox)b.a());
                        }
                        return;
                        map;
                        ul;
                        JVM INSTR monitorexit ;
                        throw map;
                    }

            
            {
                c = _pcls1;
                a = mq1;
                b = ty1;
                super();
            }
                };
                ty1.a(ox);
                mq1.a("/requestReload", ox);
                if (pm.f(b).endsWith(".js"))
                {
                    mq1.a(pm.f(b));
                } else
                if (pm.f(b).startsWith("<html>"))
                {
                    mq1.c(pm.f(b));
                } else
                {
                    mq1.b(pm.f(b));
                }
                (new Timer()).schedule(new TimerTask(this, mq1) {

                    final mq a;
                    final _cls1 b;

                    public void run()
                    {
label0:
                        {
                            synchronized (pm.c(b.b))
                            {
                                if (b.a.f() != -1 && b.a.f() != 1)
                                {
                                    break label0;
                                }
                            }
                            return;
                        }
                        b.a.e();
                        tp.a(new Runnable(this) {

                            final _cls4 a;

                            public void run()
                            {
                                a.a.a();
                            }

            
            {
                a = _pcls4;
                super();
            }
                        });
                        zzb.v("Could not receive loaded message in a timely manner. Rejecting.");
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
                a = mq;
                super();
            }
                }, a.a);
            }

            
            {
                b = pm.this;
                a = e1;
                super();
            }
        });
        return e1;
    }

    static Object c(pm pm1)
    {
        return pm1.a;
    }

    static b d(pm pm1)
    {
        return pm1.e;
    }

    static int e(pm pm1)
    {
        return pm1.h;
    }

    static String f(pm pm1)
    {
        return pm1.c;
    }

    static e g(pm pm1)
    {
        return pm1.g;
    }

    protected mq a(Context context, VersionInfoParcel versioninfoparcel)
    {
        return new ms(context, versioninfoparcel, null);
    }

    protected e a()
    {
        e e1 = c();
        e1.a(new uf.c(e1) {

            final e a;
            final pm b;

            public void a(mq mq1)
            {
                synchronized (pm.c(b))
                {
                    pm.a(b, 0);
                    if (pm.g(b) != null && a != pm.g(b))
                    {
                        zzb.v("New JS engine is loaded, marking previous one as destroyable.");
                        pm.g(b).c();
                    }
                    pm.a(b, a);
                }
                return;
                exception;
                mq1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public void zzc(Object obj)
            {
                a((mq)obj);
            }

            
            {
                b = pm.this;
                a = e1;
                super();
            }
        }, new uf.a(e1) {

            final e a;
            final pm b;

            public void run()
            {
                synchronized (pm.c(b))
                {
                    pm.a(b, 1);
                    zzb.v("Failed loading new engine. Marking new engine destroyable.");
                    a.c();
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = pm.this;
                a = e1;
                super();
            }
        });
        return e1;
    }

    public d b()
    {
label0:
        {
            d d1;
            synchronized (a)
            {
                if (g != null && g.f() != -1)
                {
                    break label0;
                }
                h = 2;
                g = a();
                d1 = g.a();
            }
            return d1;
        }
        d d2;
        if (h != 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        d2 = g.a();
        obj;
        JVM INSTR monitorexit ;
        return d2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (h != 1)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        h = 2;
        a();
        exception = g.a();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        if (h != 2)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        exception = g.a();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        exception = g.a();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }
}
