// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ab;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Queue;
import myobfuscated.aj.j;
import myobfuscated.p.d;
import myobfuscated.p.e;

final class c
{

    private final Queue a = j.a(0);

    c()
    {
    }

    public final e a(ByteBuffer bytebuffer)
    {
        this;
        JVM INSTR monitorenter ;
        e e2 = (e)a.poll();
        e e1;
        e1 = e2;
        if (e2 != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        e1 = new e();
        e1.b = null;
        Arrays.fill(e1.a, (byte)0);
        e1.c = new d();
        e1.d = 0;
        e1.b = bytebuffer.asReadOnlyBuffer();
        e1.b.position(0);
        e1.b.order(ByteOrder.LITTLE_ENDIAN);
        this;
        JVM INSTR monitorexit ;
        return e1;
        bytebuffer;
        throw bytebuffer;
    }

    public final void a(e e1)
    {
        this;
        JVM INSTR monitorenter ;
        e1.b = null;
        e1.c = null;
        a.offer(e1);
        this;
        JVM INSTR monitorexit ;
        return;
        e1;
        throw e1;
    }
}
