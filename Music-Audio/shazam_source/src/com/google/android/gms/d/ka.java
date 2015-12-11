// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.e.aj;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.d:
//            kh, ij, jy, kc, 
//            kd, ii, kp, ko, 
//            kn, ke, kb, kg

public final class ka
{
    public static interface a
    {

        public abstract void a(ke ke);
    }

    public final class b extends kn
    {

        final ka a;
        private final a b;

        protected final void a(ke ke1)
        {
            byte abyte0[] = ke1.a;
            Object obj = a;
            Object obj2 = ((ke.a) (abyte0)).e.a;
            Object obj1 = ((ke.a) (abyte0)).a;
            kf.c c1 = ((ke.a) (abyte0)).f;
            if (((ka) (obj)).d.containsKey(obj2))
            {
                obj2 = (c)((ka) (obj)).d.get(obj2);
                obj2.c = ((ka) (obj)).b.a();
                if (obj1 == Status.a)
                {
                    obj2.a = ((Status) (obj1));
                    obj2.b = c1;
                }
            } else
            {
                ((ka) (obj)).d.put(obj2, new c(((Status) (obj1)), c1, ((ka) (obj)).b.a()));
            }
            if (((ke.a) (abyte0)).a == Status.a && ((ke.a) (abyte0)).b == ke.a.a.a && ((ke.a) (abyte0)).c != null && ((ke.a) (abyte0)).c.length > 0)
            {
                obj = a.a;
                obj1 = ((ke.a) (abyte0)).e.a();
                abyte0 = ((ke.a) (abyte0)).c;
                ((kh) (obj)).d.execute(new kh._cls2(((kh) (obj)), ((String) (obj1)), abyte0));
                aj.d();
                b.a(ke1);
                return;
            }
            obj = new StringBuilder("Response status: ");
            if (((ke.a) (abyte0)).a.b())
            {
                ke1 = "SUCCESS";
            } else
            {
                ke1 = "FAILURE";
            }
            ((StringBuilder) (obj)).append(ke1);
            aj.d();
            if (((ke.a) (abyte0)).a.b())
            {
                (new StringBuilder("Response source: ")).append(((ke.a) (abyte0)).b.toString());
                aj.d();
                (new StringBuilder("Response size: ")).append(((ke.a) (abyte0)).c.length);
                aj.d();
            }
            a.a(((ke.a) (abyte0)).e, b);
        }

        public b(kd kd1, kb kb, a a1)
        {
            a = ka.this;
            super(kd1, kb);
            b = a1;
        }
    }

    static final class c
    {

        Status a;
        Object b;
        long c;

        public c(Status status, Object obj, long l)
        {
            a = status;
            b = obj;
            c = l;
        }
    }


    final kh a;
    final ii b;
    public String c;
    Map d;
    private final Context e;
    private final Map f;

    public ka(Context context)
    {
        this(context, ((Map) (new HashMap())), new kh(context), ij.d());
    }

    private ka(Context context, Map map, kh kh1, ii ii1)
    {
        c = null;
        d = new HashMap();
        e = context;
        b = ii1;
        a = kh1;
        f = map;
    }

    final void a(jy jy1, a a1)
    {
        kh kh1 = a;
        String s = jy1.a();
        Integer integer = jy1.b;
        kb kb = kc.a;
        jy1 = new kg(jy1, a1) {

            final jy a;
            final a b;
            final ka c;

            public final void a(Status status, Object obj, Integer integer1, long l)
            {
                if (status.b())
                {
                    if (integer1 == kh.a)
                    {
                        status = ke.a.a.c;
                    } else
                    {
                        status = ke.a.a.b;
                    }
                    status = new ke.a(Status.a, a, null, (kf.c)obj, status, l);
                } else
                {
                    status = new ke.a(new Status(16, (new StringBuilder("There is no valid resource for the container: ")).append(a.a).toString()), null, ke.a.a.b);
                }
                b.a(new ke(status));
            }

            
            {
                c = ka.this;
                a = jy1;
                b = a1;
                super();
            }
        };
        kh1.d.execute(new kh._cls1(kh1, s, integer, kb, jy1));
    }

    public final void a(kd kd1, a a1, kn kn)
    {
        Object obj;
        boolean flag1;
        flag1 = true;
        obj = kd1.a.iterator();
        boolean flag = false;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            jy jy1 = (jy)((Iterator) (obj)).next();
            c c1 = (c)d.get(jy1.a);
            long l;
            if (c1 != null)
            {
                l = c1.c;
            } else
            {
                l = a.a(jy1.a);
            }
            if (l + 0xdbba0L < b.a())
            {
                flag = true;
            }
        } while (true);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_273;
        }
        obj = (kp)f.get(kd1.a());
        a1 = ((a) (obj));
        if (obj == null)
        {
            if (c == null)
            {
                a1 = new kp();
            } else
            {
                a1 = new kp(c);
            }
            f.put(kd1.a(), a1);
        }
        obj = e;
        a1;
        JVM INSTR monitorenter ;
        aj.d();
        if (((kp) (a1)).b == null)
        {
            break MISSING_BLOCK_LABEL_209;
        }
        a1;
        JVM INSTR monitorexit ;
        return;
        if (((kp) (a1)).c == null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        kd1 = new ko(((Context) (obj)), kd1, kn, ((kp) (a1)).c);
_L1:
        a1.b = ((kp) (a1)).a.schedule(kd1, 0L, TimeUnit.MILLISECONDS);
        a1;
        JVM INSTR monitorexit ;
        return;
        kd1;
        a1;
        JVM INSTR monitorexit ;
        throw kd1;
        kd1 = new ko(((Context) (obj)), kd1, kn);
          goto _L1
        kd1 = kd1.a;
        if (kd1.size() != 1)
        {
            flag1 = false;
        }
        w.b(flag1);
        a((jy)kd1.get(0), a1);
        return;
    }
}
