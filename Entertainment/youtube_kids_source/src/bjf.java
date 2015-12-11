// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

final class bjf
    implements Runnable
{

    private Object a;
    private Object b;
    private bje c;

    bjf(bje bje1, Object obj, Object obj1)
    {
        c = bje1;
        a = obj;
        b = obj1;
        super();
    }

    public final void run()
    {
        bje.a(c).readLock().lock();
        Object obj = a.a(new ArrayList(a.a(bje.b(c), a.getClass())));
        bje.a(c).readLock().unlock();
_L1:
        if (obj != null && !((List) (obj)).isEmpty())
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                bji bji1 = (bji)((Iterator) (obj)).next();
                int i = bji1.d;
                Object obj1;
                if (i == b.hashCode() || i == bje.a.hashCode())
                {
                    if (bji1.a.get() != null)
                    {
                        bji1.c.a(a);
                    } else
                    {
                        c.a(new bji[] {
                            bji1
                        });
                    }
                }
            } while (true);
        }
        break MISSING_BLOCK_LABEL_220;
        obj1;
        bmo.a("exception ", ((Throwable) (obj1)));
        obj1 = null;
        bje.a(c).readLock().unlock();
          goto _L1
        obj1;
        bje.a(c).readLock().unlock();
        throw obj1;
    }
}
