// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.a;
import com.a.a.a.u;
import java.io.ByteArrayOutputStream;
import java.net.ProtocolException;

final class ab extends a
{

    final ByteArrayOutputStream b;
    private final int c;

    public ab()
    {
        c = -1;
        b = new ByteArrayOutputStream();
    }

    public ab(int i)
    {
        c = i;
        b = new ByteArrayOutputStream(i);
    }

    public final int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        close();
        i = b.size();
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = a;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        a = true;
        if (b.size() >= c) goto _L1; else goto _L3
_L3:
        throw new ProtocolException((new StringBuilder("content-length promised ")).append(c).append(" bytes, but received ").append(b.size()).toString());
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        u.a(abyte0.length, i, j);
        if (c != -1 && b.size() > c - j)
        {
            throw new ProtocolException((new StringBuilder("exceeded content-length limit of ")).append(c).append(" bytes").toString());
        }
        break MISSING_BLOCK_LABEL_74;
        abyte0;
        this;
        JVM INSTR monitorexit ;
        throw abyte0;
        b.write(abyte0, i, j);
        this;
        JVM INSTR monitorexit ;
    }
}
