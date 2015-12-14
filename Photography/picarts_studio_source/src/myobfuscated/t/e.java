// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.t;

import com.bumptech.glide.load.b;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.t:
//            g, f

final class e
{

    final Map a = new HashMap();
    final g b = new g((byte)0);

    e()
    {
    }

    final void a(b b1)
    {
        this;
        JVM INSTR monitorenter ;
        f f1;
        f1 = (f)m.a(a.get(b1), "Argument must not be null");
        if (f1.b <= 0)
        {
            throw new IllegalStateException((new StringBuilder("Cannot release a lock that is not held, key: ")).append(b1).append(", interestedThreads: ").append(f1.b).toString());
        }
        break MISSING_BLOCK_LABEL_69;
        b1;
        this;
        JVM INSTR monitorexit ;
        throw b1;
        f f2;
        g g1;
        f1.b = f1.b - 1;
        if (f1.b != 0)
        {
            break MISSING_BLOCK_LABEL_193;
        }
        f2 = (f)a.remove(b1);
        if (!f2.equals(f1))
        {
            throw new IllegalStateException((new StringBuilder("Removed the wrong lock, expected to remove: ")).append(f1).append(", but actually removed: ").append(f2).append(", key: ").append(b1).toString());
        }
        g1 = b;
        synchronized (g1.a)
        {
            if (g1.a.size() < 10)
            {
                g1.a.offer(f2);
            }
        }
        this;
        JVM INSTR monitorexit ;
        f1.a.unlock();
        return;
        exception;
        b1;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
