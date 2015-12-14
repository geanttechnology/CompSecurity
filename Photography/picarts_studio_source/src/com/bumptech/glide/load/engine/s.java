// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.b;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myobfuscated.aj.j;
import myobfuscated.ak.d;
import myobfuscated.ak.f;

// Referenced classes of package com.bumptech.glide.load.engine:
//            f, t, u, ad, 
//            y, v, DecodeJob, i, 
//            GlideException

public final class s
    implements com.bumptech.glide.load.engine.f, d
{

    private static final t m = new t();
    private static final Handler n = new Handler(Looper.getMainLooper(), new u((byte)0));
    public final List a;
    public final f b;
    public final v c;
    public final GlideExecutor d;
    public final GlideExecutor e;
    public b f;
    public boolean g;
    public boolean h;
    public boolean i;
    public List j;
    public DecodeJob k;
    public volatile boolean l;
    private final android.support.v4.util.Pools.Pool o;
    private ad p;
    private DataSource q;
    private GlideException r;
    private y s;

    s(GlideExecutor glideexecutor, GlideExecutor glideexecutor1, v v1, android.support.v4.util.Pools.Pool pool)
    {
        this(glideexecutor, glideexecutor1, v1, pool, m);
    }

    private s(GlideExecutor glideexecutor, GlideExecutor glideexecutor1, v v1, android.support.v4.util.Pools.Pool pool, t t1)
    {
        a = new ArrayList(2);
        b = myobfuscated.ak.f.a();
        d = glideexecutor;
        e = glideexecutor1;
        c = v1;
        o = pool;
    }

    static void a(s s1)
    {
        s1.b.b();
        if (s1.l)
        {
            s1.p.d();
            s1.a(false);
            return;
        }
        if (s1.a.isEmpty())
        {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        if (s1.h)
        {
            throw new IllegalStateException("Already have resource");
        }
        s1.s = new y(s1.p, s1.g);
        s1.h = true;
        s1.s.e();
        s1.c.a(s1.f, s1.s);
        Iterator iterator = s1.a.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.bumptech.glide.request.f f1 = (com.bumptech.glide.request.f)iterator.next();
            if (!s1.b(f1))
            {
                s1.s.e();
                f1.a(s1.s, s1.q);
            }
        } while (true);
        s1.s.f();
        s1.a(false);
    }

    static void b(s s1)
    {
        s1.b.b();
        if (!s1.l)
        {
            if (s1.a.isEmpty())
            {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (s1.i)
            {
                throw new IllegalStateException("Already failed once");
            }
            s1.i = true;
            s1.c.a(s1.f, null);
            Iterator iterator = s1.a.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                com.bumptech.glide.request.f f1 = (com.bumptech.glide.request.f)iterator.next();
                if (!s1.b(f1))
                {
                    f1.a(s1.r);
                }
            } while (true);
        }
        s1.a(false);
    }

    private boolean b(com.bumptech.glide.request.f f1)
    {
        return j != null && j.contains(f1);
    }

    static void c(s s1)
    {
        s1.b.b();
        if (!s1.l)
        {
            throw new IllegalStateException("Not cancelled");
        } else
        {
            s1.c.a(s1, s1.f);
            s1.a(false);
            return;
        }
    }

    public final void a(DecodeJob decodejob)
    {
        if (l)
        {
            n.obtainMessage(3, this).sendToTarget();
            return;
        } else
        {
            e.execute(decodejob);
            return;
        }
    }

    public final void a(GlideException glideexception)
    {
        r = glideexception;
        n.obtainMessage(2, this).sendToTarget();
    }

    public final void a(ad ad1, DataSource datasource)
    {
        p = ad1;
        q = datasource;
        n.obtainMessage(1, this).sendToTarget();
    }

    public final void a(com.bumptech.glide.request.f f1)
    {
        myobfuscated.aj.j.a();
        b.b();
        if (h)
        {
            f1.a(s, q);
            return;
        }
        if (i)
        {
            f1.a(r);
            return;
        } else
        {
            a.add(f1);
            return;
        }
    }

    public final void a(boolean flag)
    {
        myobfuscated.aj.j.a();
        a.clear();
        f = null;
        s = null;
        p = null;
        if (j != null)
        {
            j.clear();
        }
        i = false;
        l = false;
        h = false;
        DecodeJob decodejob = k;
        if (decodejob.c.a(flag))
        {
            decodejob.a();
        }
        k = null;
        r = null;
        q = null;
        o.release(this);
    }

    public final f e_()
    {
        return b;
    }

}
