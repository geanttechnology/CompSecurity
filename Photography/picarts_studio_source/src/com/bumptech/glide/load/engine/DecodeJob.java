// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.e;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.ak.d;
import myobfuscated.ak.f;
import myobfuscated.q.b;
import myobfuscated.t.a;
import myobfuscated.t.c;

// Referenced classes of package com.bumptech.glide.load.engine:
//            d, e, g, i, 
//            k, ab, ae, a, 
//            ai, c, GlideException, f, 
//            ac, h, l, w, 
//            ad

public final class DecodeJob
    implements com.bumptech.glide.load.engine.d, Comparable, Runnable, d
{

    private DataSource A;
    private b B;
    private volatile boolean C;
    public final com.bumptech.glide.load.engine.e a = new com.bumptech.glide.load.engine.e();
    public final h b;
    final i c = new i((byte)0);
    public com.bumptech.glide.d d;
    public com.bumptech.glide.load.b e;
    public Priority f;
    public w g;
    public int h;
    public int i;
    public l j;
    public e k;
    public com.bumptech.glide.load.engine.f l;
    public int m;
    public RunReason n;
    public volatile com.bumptech.glide.load.engine.c o;
    public volatile boolean p;
    private final List q = new ArrayList();
    private final f r = myobfuscated.ak.f.a();
    private final android.support.v4.util.Pools.Pool s;
    private final g t = new g((byte)0);
    private Stage u;
    private long v;
    private Thread w;
    private com.bumptech.glide.load.b x;
    private com.bumptech.glide.load.b y;
    private Object z;

    DecodeJob(h h1, android.support.v4.util.Pools.Pool pool)
    {
        b = h1;
        s = pool;
    }

    private ad a(Object obj, DataSource datasource, ab ab1)
    {
        obj = d.a.c.a(obj);
        datasource = ab1.a(((myobfuscated.q.d) (obj)), k, h, i, new k(this, datasource));
        ((myobfuscated.q.d) (obj)).b();
        return datasource;
        datasource;
        ((myobfuscated.q.d) (obj)).b();
        throw datasource;
    }

    private ad a(b b1, Object obj, DataSource datasource)
    {
        if (obj == null)
        {
            b1.a();
            return null;
        }
        long l1 = myobfuscated.aj.f.a();
        obj = a(obj, datasource, a.b(obj.getClass()));
        if (Log.isLoggable("DecodeJob", 2))
        {
            a((new StringBuilder("Decoded result ")).append(obj).toString(), l1, ((String) (null)));
        }
        b1.a();
        return ((ad) (obj));
        obj;
        b1.a();
        throw obj;
    }

    static com.bumptech.glide.load.engine.e a(DecodeJob decodejob)
    {
        return decodejob.a;
    }

    private void a(String s1, long l1, String s2)
    {
        StringBuilder stringbuilder = (new StringBuilder()).append(s1).append(" in ").append(myobfuscated.aj.f.a(l1)).append(", load key: ").append(g);
        if (s2 != null)
        {
            s1 = (new StringBuilder(", ")).append(s2).toString();
        } else
        {
            s1 = "";
        }
        stringbuilder.append(s1).append(", thread: ").append(Thread.currentThread().getName());
    }

    static int b(DecodeJob decodejob)
    {
        return decodejob.h;
    }

    static int c(DecodeJob decodejob)
    {
        return decodejob.i;
    }

    static e d(DecodeJob decodejob)
    {
        return decodejob.k;
    }

    private void d()
    {
        if (c.a())
        {
            a();
        }
    }

    static com.bumptech.glide.load.b e(DecodeJob decodejob)
    {
        return decodejob.x;
    }

    private com.bumptech.glide.load.engine.c e()
    {
        final class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[Stage.values().length];
                try
                {
                    b[Stage.RESOURCE_CACHE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    b[Stage.DATA_CACHE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[Stage.SOURCE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[Stage.FINISHED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    b[Stage.INITIALIZE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                a = new int[RunReason.values().length];
                try
                {
                    a[RunReason.INITIALIZE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[RunReason.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[RunReason.DECODE_DATA.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }

            private class RunReason extends Enum
            {

                private static final RunReason $VALUES[];
                public static final RunReason DECODE_DATA;
                public static final RunReason INITIALIZE;
                public static final RunReason SWITCH_TO_SOURCE_SERVICE;

                public static RunReason valueOf(String s1)
                {
                    return (RunReason)Enum.valueOf(com/bumptech/glide/load/engine/DecodeJob$RunReason, s1);
                }

                public static RunReason[] values()
                {
                    return (RunReason[])$VALUES.clone();
                }

                static 
                {
                    INITIALIZE = new RunReason("INITIALIZE", 0);
                    SWITCH_TO_SOURCE_SERVICE = new RunReason("SWITCH_TO_SOURCE_SERVICE", 1);
                    DECODE_DATA = new RunReason("DECODE_DATA", 2);
                    $VALUES = (new RunReason[] {
                        INITIALIZE, SWITCH_TO_SOURCE_SERVICE, DECODE_DATA
                    });
                }

                private RunReason(String s1, int i1)
                {
                    super(s1, i1);
                }
            }

        }

        switch (com.bumptech.glide.load.engine._cls1.b[u.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder("Unrecognized stage: ")).append(u).toString());

        case 1: // '\001'
            return new ae(a, this);

        case 2: // '\002'
            return new com.bumptech.glide.load.engine.a(a, this);

        case 3: // '\003'
            return new ai(a, this);

        case 4: // '\004'
            return null;
        }
    }

    static l f(DecodeJob decodejob)
    {
        return decodejob.j;
    }

    private void f()
    {
        boolean flag;
        w = Thread.currentThread();
        v = myobfuscated.aj.f.a();
        flag = false;
_L6:
        boolean flag1 = flag;
        if (p) goto _L2; else goto _L1
_L1:
        flag1 = flag;
        if (o == null) goto _L2; else goto _L3
_L3:
        flag = o.a();
        flag1 = flag;
        if (flag) goto _L2; else goto _L4
_L4:
        u = a(u);
        o = e();
        if (u != Stage.SOURCE) goto _L6; else goto _L5
_L5:
        c();
_L8:
        return;
_L2:
        if ((u == Stage.FINISHED || p) && !flag1)
        {
            g();
            return;
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    static com.bumptech.glide.load.b g(DecodeJob decodejob)
    {
        return decodejob.e;
    }

    private void g()
    {
        h();
        GlideException glideexception = new GlideException("Failed to load resource", new ArrayList(q));
        l.a(glideexception);
        if (c.b())
        {
            a();
        }
    }

    static g h(DecodeJob decodejob)
    {
        return decodejob.t;
    }

    private void h()
    {
        r.b();
        if (C)
        {
            throw new IllegalStateException("Already notified");
        } else
        {
            C = true;
            return;
        }
    }

    private void i()
    {
        Object obj;
        ac ac1;
        ac1 = null;
        if (Log.isLoggable("DecodeJob", 2))
        {
            a("Retrieved data", v, (new StringBuilder("data: ")).append(z).append(", cache key: ").append(x).append(", fetcher: ").append(B).toString());
        }
        Object obj1;
        Object obj2;
        try
        {
            obj = a(B, z, A);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((GlideException) (obj)).setLoggingDetails(y, A);
            q.add(obj);
            obj = null;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        obj2 = A;
        obj1 = obj;
        if (t.a())
        {
            ac1 = com.bumptech.glide.load.engine.ac.a(((ad) (obj)));
            obj1 = ac1;
        }
        h();
        l.a(((ad) (obj1)), ((DataSource) (obj2)));
        u = Stage.ENCODE;
        if (!t.a())
        {
            break MISSING_BLOCK_LABEL_200;
        }
        obj = t;
        obj1 = b;
        obj2 = k;
        ((h) (obj1)).a().a(((g) (obj)).a, new c(((g) (obj)).b, ((g) (obj)).c, ((e) (obj2))));
        ((g) (obj)).c.e();
        if (ac1 != null)
        {
            ac1.e();
        }
        d();
        return;
        Exception exception1;
        exception1;
        ((g) (obj)).c.e();
        throw exception1;
        Exception exception;
        exception;
        if (ac1 != null)
        {
            ac1.e();
        }
        d();
        throw exception;
        f();
        return;
    }

    public final Stage a(Stage stage)
    {
        do
        {
            switch (com.bumptech.glide.load.engine._cls1.b[stage.ordinal()])
            {
            default:
                throw new IllegalArgumentException((new StringBuilder("Unrecognized stage: ")).append(stage).toString());

            case 5: // '\005'
                if (j.a())
                {
                    return Stage.RESOURCE_CACHE;
                }
                stage = Stage.RESOURCE_CACHE;
                break;

            case 1: // '\001'
                if (j.b())
                {
                    return Stage.DATA_CACHE;
                }
                stage = Stage.DATA_CACHE;
                break;

            case 2: // '\002'
                return Stage.SOURCE;

            case 3: // '\003'
            case 4: // '\004'
                return Stage.FINISHED;
            }
        } while (true);
    }

    final void a()
    {
        c.c();
        Object obj = t;
        obj.a = null;
        obj.b = null;
        obj.c = null;
        obj = a;
        obj.c = null;
        obj.d = null;
        obj.n = null;
        obj.g = null;
        obj.k = null;
        obj.i = null;
        obj.o = null;
        obj.j = null;
        obj.p = null;
        ((com.bumptech.glide.load.engine.e) (obj)).a.clear();
        obj.l = false;
        ((com.bumptech.glide.load.engine.e) (obj)).b.clear();
        obj.m = false;
        C = false;
        d = null;
        e = null;
        k = null;
        f = null;
        g = null;
        l = null;
        u = null;
        o = null;
        w = null;
        x = null;
        z = null;
        A = null;
        B = null;
        v = 0L;
        p = false;
        q.clear();
        s.release(this);
    }

    public final void a(com.bumptech.glide.load.b b1, Exception exception, b b2, DataSource datasource)
    {
        exception = new GlideException("Fetching data failed", exception);
        exception.setLoggingDetails(b1, datasource, b2.d());
        q.add(exception);
        if (Thread.currentThread() != w)
        {
            n = RunReason.SWITCH_TO_SOURCE_SERVICE;
            l.a(this);
            return;
        } else
        {
            f();
            return;
        }
    }

    public final void a(com.bumptech.glide.load.b b1, Object obj, b b2, DataSource datasource, com.bumptech.glide.load.b b3)
    {
        x = b1;
        z = obj;
        B = b2;
        A = datasource;
        y = b3;
        if (Thread.currentThread() != w)
        {
            n = RunReason.DECODE_DATA;
            l.a(this);
            return;
        } else
        {
            i();
            return;
        }
    }

    public final void c()
    {
        n = RunReason.SWITCH_TO_SOURCE_SERVICE;
        l.a(this);
    }

    public final int compareTo(Object obj)
    {
        obj = (DecodeJob)obj;
        int j1 = f.ordinal() - ((DecodeJob) (obj)).f.ordinal();
        int i1 = j1;
        if (j1 == 0)
        {
            i1 = m - ((DecodeJob) (obj)).m;
        }
        return i1;
    }

    public final f e_()
    {
        return r;
    }

    public final void run()
    {
        if (p)
        {
            g();
            return;
        }
        com.bumptech.glide.load.engine._cls1.a[n.ordinal()];
        JVM INSTR tableswitch 1 3: default 174
    //                   1 140
    //                   2 164
    //                   3 169;
           goto _L1 _L2 _L3 _L4
_L1:
        RuntimeException runtimeexception;
        throw new IllegalStateException((new StringBuilder("Unrecognized run reason: ")).append(n).toString());
_L2:
        try
        {
            u = a(Stage.INITIALIZE);
            o = e();
            f();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RuntimeException runtimeexception)
        {
            if (Log.isLoggable("DecodeJob", 3))
            {
                (new StringBuilder("DecodeJob threw unexpectedly, isCancelled: ")).append(p).append(", stage: ").append(u);
            }
            if (u != Stage.ENCODE)
            {
                g();
            }
            if (!p)
            {
                throw runtimeexception;
            }
        }
        break; /* Loop/switch isn't completed */
_L3:
        f();
        return;
_L4:
        i();
    }

    private class Stage extends Enum
    {

        private static final Stage $VALUES[];
        public static final Stage DATA_CACHE;
        public static final Stage ENCODE;
        public static final Stage FINISHED;
        public static final Stage INITIALIZE;
        public static final Stage RESOURCE_CACHE;
        public static final Stage SOURCE;

        public static Stage valueOf(String s1)
        {
            return (Stage)Enum.valueOf(com/bumptech/glide/load/engine/DecodeJob$Stage, s1);
        }

        public static Stage[] values()
        {
            return (Stage[])$VALUES.clone();
        }

        static 
        {
            INITIALIZE = new Stage("INITIALIZE", 0);
            RESOURCE_CACHE = new Stage("RESOURCE_CACHE", 1);
            DATA_CACHE = new Stage("DATA_CACHE", 2);
            SOURCE = new Stage("SOURCE", 3);
            ENCODE = new Stage("ENCODE", 4);
            FINISHED = new Stage("FINISHED", 5);
            $VALUES = (new Stage[] {
                INITIALIZE, RESOURCE_CACHE, DATA_CACHE, SOURCE, ENCODE, FINISHED
            });
        }

        private Stage(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
