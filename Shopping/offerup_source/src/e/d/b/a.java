// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.b;

import android.support.v4.app.r;
import e.f;
import e.j;
import java.util.concurrent.atomic.AtomicInteger;

public final class a extends AtomicInteger
    implements f
{

    private j a;
    private Object b;

    public a(j j1)
    {
        a = j1;
    }

    private static void a(j j1, Object obj)
    {
        if (!j1.c())
        {
            try
            {
                j1.a(obj);
            }
            catch (Throwable throwable)
            {
                android.support.v4.e.a.a(throwable);
                j1.a(r.a(throwable, obj));
                return;
            }
            if (!j1.c())
            {
                j1.a();
                return;
            }
        }
    }

    public final void a(long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException("n >= 0 required");
        }
        int i;
        if (l != 0L)
        {
            do
            {
                i = get();
                if (i != 0)
                {
                    continue;
                }
            } while (!compareAndSet(0, 2));
        }
        do
        {
            return;
        } while (i != 1 || !compareAndSet(1, 3));
        a(a, b);
    }

    public final void a(Object obj)
    {
_L4:
        int i = get();
        if (i != 0) goto _L2; else goto _L1
_L1:
        b = obj;
        if (!compareAndSet(0, 1)) goto _L4; else goto _L3
_L3:
        return;
_L2:
        if (i == 2 && compareAndSet(2, 3))
        {
            a(a, obj);
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }
}
