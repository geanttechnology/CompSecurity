// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.d;
import com.bumptech.glide.load.DataSource;
import java.util.Collections;
import java.util.List;
import myobfuscated.af.a;
import myobfuscated.aj.f;
import myobfuscated.q.b;
import myobfuscated.q.c;
import myobfuscated.v.af;

// Referenced classes of package com.bumptech.glide.load.engine:
//            c, d, e, l, 
//            b, h, a

final class ai
    implements com.bumptech.glide.load.engine.c, com.bumptech.glide.load.engine.d, c
{

    private final e a;
    private final com.bumptech.glide.load.engine.d b;
    private int c;
    private com.bumptech.glide.load.engine.a d;
    private Object e;
    private volatile af f;
    private com.bumptech.glide.load.engine.b g;

    public ai(e e1, com.bumptech.glide.load.engine.d d1)
    {
        a = e1;
        b = d1;
    }

    public final void a(com.bumptech.glide.load.b b1, Exception exception, b b2, DataSource datasource)
    {
        b.a(b1, exception, b2, f.c.c());
    }

    public final void a(com.bumptech.glide.load.b b1, Object obj, b b2, DataSource datasource, com.bumptech.glide.load.b b3)
    {
        b.a(b1, obj, b2, f.c.c(), b1);
    }

    public final void a(Exception exception)
    {
        b.a(g, exception, f.c, f.c.c());
    }

    public final void a(Object obj)
    {
        l l1 = a.p;
        if (obj != null && l1.a(f.c.c()))
        {
            e = obj;
            b.c();
            return;
        } else
        {
            b.a(f.a, obj, f.c, f.c.c(), g);
            return;
        }
    }

    public final boolean a()
    {
        Object obj;
        long l1;
        if (e == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        obj = e;
        e = null;
        l1 = myobfuscated.aj.f.a();
        com.bumptech.glide.load.a a1 = a.c.a.a.a(obj.getClass());
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        myobfuscated.t.c c1 = new myobfuscated.t.c(a1, obj, a.i);
        g = new com.bumptech.glide.load.engine.b(f.a, a.n);
        a.h.a().a(g, c1);
        if (Log.isLoggable("SourceGenerator", 2))
        {
            (new StringBuilder("Finished encoding source to cache, key: ")).append(g).append(", data: ").append(obj).append(", encoder: ").append(a1).append(", duration: ").append(myobfuscated.aj.f.a(l1));
        }
        f.c.a();
        d = new com.bumptech.glide.load.engine.a(Collections.singletonList(f.a), a, this);
        if (d != null && d.a())
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_250;
        throw new com.bumptech.glide.Registry.NoSourceEncoderAvailableException(obj.getClass());
        Exception exception;
        exception;
        f.c.a();
        throw exception;
        d = null;
        f = null;
        boolean flag = false;
        do
        {
            if (flag)
            {
                break;
            }
            List list;
            int i;
            if (c < a.a().size())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i == 0)
            {
                break;
            }
            list = a.a();
            i = c;
            c = i + 1;
            f = (af)list.get(i);
            if (f != null && (a.p.a(f.c.c()) || a.a(f.c.d())))
            {
                f.c.a(a.o, this);
                flag = true;
            }
        } while (true);
        return flag;
    }

    public final void b()
    {
        af af1 = f;
        if (af1 != null)
        {
            af1.c.b();
        }
    }

    public final void c()
    {
        throw new UnsupportedOperationException();
    }
}
