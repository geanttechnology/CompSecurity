// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.paypal.android.sdk:
//            hb, hp, hr, id, 
//            kt, hn, fn, ks, 
//            jb, gp, ic, ij, 
//            ib, kz, jf, ho, 
//            hl

final class ia extends hb
    implements hp
{

    final hr a;
    private ho b;

    private ia(hr hr1)
    {
        a = hr1;
        super("OkHttp %s", new Object[] {
            hr.a(hr1)
        });
    }

    ia(hr hr1, byte byte0)
    {
        this(hr1);
    }

    public final void a(int i, long l)
    {
        if (i == 0)
        {
            synchronized (a)
            {
                hr hr2 = a;
                hr2.d = hr2.d + l;
                a.notifyAll();
            }
            return;
        }
        break MISSING_BLOCK_LABEL_50;
        exception;
        hr1;
        JVM INSTR monitorexit ;
        throw exception;
        id id1;
        id1 = a.a(i);
        if (id1 == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        id1;
        JVM INSTR monitorenter ;
        id1.a(l);
        id1;
        JVM INSTR monitorexit ;
        return;
        Exception exception1;
        exception1;
        id1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final void a(int i, hn hn1)
    {
        if (hr.a(a, i))
        {
            hr.a(a, i, hn1);
        } else
        {
            id id1 = a.b(i);
            if (id1 != null)
            {
                id1.c(hn1);
                return;
            }
        }
    }

    public final void a(int i, kt kt1)
    {
        int j = kt1.b.length;
        id aid[];
        synchronized (a)
        {
            aid = (id[])hr.e(a).values().toArray(new id[hr.e(a).size()]);
            hr.i(a);
        }
        int l = aid.length;
        for (int k = 0; k < l; k++)
        {
            kt1 = aid[k];
            if (kt1.a() > i && kt1.c())
            {
                kt1.c(hn.g);
                a.b(kt1.a());
            }
        }

        break MISSING_BLOCK_LABEL_127;
        exception;
        kt1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void a(int i, List list)
    {
        hr.a(a, i, list);
    }

    public final void a(boolean flag, int i, int j)
    {
        if (flag)
        {
            fn fn1 = hr.c(a, i);
            if (fn1 != null)
            {
                fn1.b();
            }
            return;
        } else
        {
            hr.a(a, i, j);
            return;
        }
    }

    public final void a(boolean flag, int i, ks ks1, int j)
    {
        if (hr.a(a, i))
        {
            hr.a(a, i, ks1, j, flag);
        } else
        {
            id id1 = a.a(i);
            if (id1 == null)
            {
                a.a(i, hn.c);
                ks1.f(j);
                return;
            }
            id1.a(ks1, j);
            if (flag)
            {
                id1.h();
                return;
            }
        }
    }

    public final void a(boolean flag, jb jb1)
    {
        hr1 = a;
        hr1;
        JVM INSTR monitorenter ;
        int j = a.f.d();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        a.f.a();
        jb jb2 = a.f;
        int i = 0;
_L5:
        if (i >= 10)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        if (jb1.a(i))
        {
            jb2.a(i, jb1.c(i), jb1.b(i));
        }
        break MISSING_BLOCK_LABEL_334;
        if (a.a == gp.d)
        {
            hr.d().execute(new ic(this, "OkHttp %s ACK Settings", new Object[] {
                hr.a(a)
            }, jb1));
        }
        i = a.f.d();
        long l;
        if (i == -1 || i == j)
        {
            break MISSING_BLOCK_LABEL_326;
        }
        l = i - j;
        if (hr.g(a))
        {
            break MISSING_BLOCK_LABEL_208;
        }
        jb1 = a;
        jb1.d = ((hr) (jb1)).d + l;
        if (l <= 0L)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        jb1.notifyAll();
        hr.h(a);
        if (hr.e(a).isEmpty()) goto _L2; else goto _L1
_L1:
        jb1 = (id[])hr.e(a).values().toArray(new id[hr.e(a).size()]);
_L3:
        hr1;
        JVM INSTR monitorexit ;
        if (jb1 != null && l != 0L)
        {
            int k = jb1.length;
            for (i = 0; i < k; i++)
            {
                synchronized (jb1[i])
                {
                    hr1.a(l);
                }
            }

        }
        break MISSING_BLOCK_LABEL_320;
        jb1;
        hr1;
        JVM INSTR monitorexit ;
        throw jb1;
        jb1;
        hr1;
        JVM INSTR monitorexit ;
        throw jb1;
        return;
_L2:
        jb1 = null;
          goto _L3
        jb1 = null;
        l = 0L;
          goto _L3
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a(boolean flag, boolean flag1, int i, List list, ij ij1)
    {
        boolean flag2;
        boolean flag3;
        flag2 = true;
        flag3 = false;
        if (!hr.a(a, i)) goto _L2; else goto _L1
_L1:
        hr.a(a, i, list, flag1);
_L4:
        return;
_L2:
        synchronized (a)
        {
            if (!hr.b(a))
            {
                break MISSING_BLOCK_LABEL_60;
            }
        }
        return;
        list;
        hr1;
        JVM INSTR monitorexit ;
        throw list;
        id id1 = a.a(i);
        if (id1 != null)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        if (ij1 == ij.b)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        flag2 = flag3;
        if (ij1 == ij.c)
        {
            break MISSING_BLOCK_LABEL_302;
        }
        for (; !flag2; flag2 = true)
        {
            break MISSING_BLOCK_LABEL_118;
        }

        a.a(i, hn.c);
        hr1;
        JVM INSTR monitorexit ;
        return;
        if (i > hr.c(a))
        {
            break MISSING_BLOCK_LABEL_133;
        }
        hr1;
        JVM INSTR monitorexit ;
        return;
        if (i % 2 != hr.d(a) % 2)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        hr1;
        JVM INSTR monitorexit ;
        return;
        list = new id(i, a, flag, flag1, list);
        hr.b(a, i);
        hr.e(a).put(Integer.valueOf(i), list);
        hr.d().execute(new ib(this, "OkHttp %s stream %d", new Object[] {
            hr.a(a), Integer.valueOf(i)
        }, list));
        hr1;
        JVM INSTR monitorexit ;
        return;
        hr1;
        JVM INSTR monitorexit ;
        if (ij1 != ij.a)
        {
            flag2 = false;
        }
        if (flag2)
        {
            id1.b(hn.b);
            a.b(i);
            return;
        }
        id1.a(list, ij1);
        if (flag1)
        {
            id1.h();
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected final void c()
    {
        Object obj;
        hn hn1;
        Object obj2;
        hn hn2;
        obj2 = hn.e;
        hn2 = hn.e;
        hn1 = ((hn) (obj2));
        obj = obj2;
        b = a.g.a(kz.a(kz.b(a.h)), a.b);
        hn1 = ((hn) (obj2));
        obj = obj2;
        if (a.b)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        hn1 = ((hn) (obj2));
        obj = obj2;
        b.a();
_L2:
        hn1 = ((hn) (obj2));
        obj = obj2;
        if (b.a(this)) goto _L2; else goto _L1
_L1:
        hn1 = ((hn) (obj2));
        obj = obj2;
        obj2 = hn.a;
        hn1 = ((hn) (obj2));
        obj = obj2;
        hn hn3 = hn.h;
        IOException ioexception;
        Object obj1;
        try
        {
            hr.a(a, ((hn) (obj2)), hn3);
        }
        catch (IOException ioexception1) { }
        hl.a(b);
        return;
        obj;
        obj = hn1;
        obj2 = hn.b;
        obj = hn.b;
        try
        {
            hr.a(a, ((hn) (obj2)), ((hn) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        hl.a(b);
        return;
        obj1;
        obj2 = obj;
        obj = obj1;
_L4:
        try
        {
            hr.a(a, ((hn) (obj2)), hn2);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        hl.a(b);
        throw obj;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
