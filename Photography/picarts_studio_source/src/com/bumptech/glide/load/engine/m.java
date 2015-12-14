// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import myobfuscated.aj.f;
import myobfuscated.aj.j;
import myobfuscated.t.b;
import myobfuscated.t.l;

// Referenced classes of package com.bumptech.glide.load.engine:
//            v, z, h, x, 
//            o, n, ag, q, 
//            y, r, s, ad

public final class m
    implements v, z, myobfuscated.t.m
{

    public final Map a;
    public final l b;
    public final o c;
    public final Map d;
    public final n e;
    private final ag f;
    private final h g;
    private ReferenceQueue h;

    public m(l l1, b b1, GlideExecutor glideexecutor, GlideExecutor glideexecutor1)
    {
        this(l1, b1, glideexecutor, glideexecutor1, (byte)0);
    }

    private m(l l1, b b1, GlideExecutor glideexecutor, GlideExecutor glideexecutor1, byte byte0)
    {
        b = l1;
        g = new h(b1);
        d = new HashMap();
        new x();
        a = new HashMap();
        c = new o(glideexecutor, glideexecutor1, this);
        e = new n(g);
        f = new ag();
        l1.a(this);
    }

    public static void a(String s1, long l1, com.bumptech.glide.load.b b1)
    {
        (new StringBuilder()).append(s1).append(" in ").append(myobfuscated.aj.f.a(l1)).append("ms, key: ").append(b1);
    }

    public final ReferenceQueue a()
    {
        if (h == null)
        {
            h = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new q(d, h));
        }
        return h;
    }

    public final void a(com.bumptech.glide.load.b b1, y y1)
    {
        j.a();
        if (y1 != null)
        {
            y1.c = b1;
            y1.b = this;
            if (y1.a)
            {
                d.put(b1, new r(b1, y1, a()));
            }
        }
        a.remove(b1);
    }

    public final void a(ad ad)
    {
        j.a();
        f.a(ad);
    }

    public final void a(s s1, com.bumptech.glide.load.b b1)
    {
        j.a();
        if (s1.equals((s)a.get(b1)))
        {
            a.remove(b1);
        }
    }

    public final void b(com.bumptech.glide.load.b b1, y y1)
    {
        j.a();
        d.remove(b1);
        if (y1.a)
        {
            b.a(b1, y1);
            return;
        } else
        {
            f.a(y1);
            return;
        }
    }
}
