// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import android.support.v4.app.r;
import e.a;
import e.c.f;
import e.d.d.e;
import e.h.b;
import e.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

// Referenced classes of package e.d.a:
//            af

final class ae
{

    private static AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(e/d/a/ae, "a");
    private static int f;
    volatile long a;
    private final e.e b;
    private final f c;
    private final b d = new b();
    private int g;
    private Object h[];
    private AtomicLong i;

    public ae(j j1, f f1)
    {
        g = 0;
        b = j1;
        c = f1;
        j1.a(d);
    }

    static e.e a(ae ae1)
    {
        return ae1.b;
    }

    final void a()
    {
        Object obj;
        for (obj = ((Object) (h)); obj == null || e.getAndIncrement(this) != 0L;)
        {
            return;
        }

        int k1 = obj.length;
        e.e e1 = b;
        AtomicLong atomiclong = i;
        do
        {
            do
            {
                Object obj1 = ((Object) (new Object[k1]));
                boolean flag = true;
                int i1 = 0;
                while (i1 < k1) 
                {
                    Object obj2 = ((af)obj[i1]).a.h();
                    if (obj2 == null)
                    {
                        flag = false;
                    } else
                    {
                        if (e.d.d.e.b(obj2))
                        {
                            e1.a();
                            d.b();
                            return;
                        }
                        obj1[i1] = e.d.d.e.c(obj2);
                    }
                    i1++;
                }
                if (atomiclong.get() <= 0L || !flag)
                {
                    break;
                }
                try
                {
                    e1.a(c.a(((Object []) (obj1))));
                    atomiclong.decrementAndGet();
                    g = g + 1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    e1.a(r.a(((Throwable) (obj)), obj1));
                    return;
                }
                i1 = obj.length;
                for (int k = 0; k < i1; k++)
                {
                    obj1 = ((af)obj[k]).a;
                    ((e) (obj1)).g();
                    if (e.d.d.e.b(((e) (obj1)).h()))
                    {
                        e1.a();
                        d.b();
                        return;
                    }
                }

                if (g > f)
                {
                    int j1 = obj.length;
                    for (int l = 0; l < j1; l++)
                    {
                        ((af)obj[l]).b(g);
                    }

                    g = 0;
                }
            } while (true);
        } while (e.decrementAndGet(this) > 0L);
    }

    public final void a(a aa[], AtomicLong atomiclong)
    {
        boolean flag = false;
        h = new Object[aa.length];
        i = atomiclong;
        int k = 0;
        int l;
        do
        {
            l = ((flag) ? 1 : 0);
            if (k >= aa.length)
            {
                break;
            }
            atomiclong = new af(this);
            h[k] = atomiclong;
            d.a(atomiclong);
            k++;
        } while (true);
        for (; l < aa.length; l++)
        {
            aa[l].a((af)h[l]);
        }

    }

    static 
    {
        f = (int)((double)e.b * 0.69999999999999996D);
    }
}
