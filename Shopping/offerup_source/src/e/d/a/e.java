// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import android.support.v4.e.a;
import e.f;
import e.j;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

final class e extends AtomicLong
    implements f
{

    private final j a;
    private final Iterator b;

    private e(j j1, Iterator iterator)
    {
        a = j1;
        b = iterator;
    }

    e(j j1, Iterator iterator, byte byte0)
    {
        this(j1, iterator);
    }

    public final void a(long l)
    {
        if (get() != 0x7fffffffffffffffL)
        {
            if (l != 0x7fffffffffffffffL || !compareAndSet(0L, 0x7fffffffffffffffL))
            {
                continue;
            }
            j1 = a;
            Iterator iterator = b;
            while (!j1.c()) 
            {
                if (!iterator.hasNext())
                {
                    continue;
                }
                j1.a(iterator.next());
            }
        }
_L4:
        j j2;
        Iterator iterator1;
        do
        {
            j j1;
            do
            {
                return;
            } while (j1.c());
            j1.a();
            return;
        } while (l <= 0L || android.support.v4.e.a.a(this, l) != 0L);
        j2 = a;
        iterator1 = b;
_L3:
        long l1 = l;
        do
        {
            if (j2.c())
            {
                break; /* Loop/switch isn't completed */
            }
            if (!iterator1.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            l1--;
            if (l1 < 0L)
            {
                break;
            }
            j2.a(iterator1.next());
        } while (true);
        break MISSING_BLOCK_LABEL_171;
        if (j2.c()) goto _L2; else goto _L1
_L1:
        break MISSING_BLOCK_LABEL_166;
_L2:
        break; /* Loop/switch isn't completed */
        j2.a();
        return;
        l = addAndGet(-l);
        if (l == 0L) goto _L4; else goto _L3
    }
}
