// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d.a;

import java.io.ByteArrayOutputStream;

// Referenced classes of package com.mopub.d.a:
//            b

public final class i extends ByteArrayOutputStream
{

    private final b a;

    public i(b b1, int j)
    {
        a = b1;
        buf = a.a(Math.max(j, 256));
    }

    private void a(int j)
    {
        if (count + j <= buf.length)
        {
            return;
        } else
        {
            byte abyte0[] = a.a((count + j) * 2);
            System.arraycopy(buf, 0, abyte0, 0, count);
            a.a(buf);
            buf = abyte0;
            return;
        }
    }

    public final void close()
    {
        a.a(buf);
        buf = null;
        super.close();
    }

    public final void finalize()
    {
        a.a(buf);
    }

    public final void write(int j)
    {
        this;
        JVM INSTR monitorenter ;
        a(1);
        super.write(j);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void write(byte abyte0[], int j, int k)
    {
        this;
        JVM INSTR monitorenter ;
        a(k);
        super.write(abyte0, j, k);
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }
}
