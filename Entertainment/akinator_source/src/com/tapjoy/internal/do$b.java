// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.OutputStream;
import java.util.ArrayList;

// Referenced classes of package com.tapjoy.internal:
//            do, dw

public static final class e extends OutputStream
{

    private static final byte a[] = new byte[0];
    private final int b = 128;
    private final ArrayList c = new ArrayList();
    private int d;
    private byte e[];
    private int f;

    private void a(int i)
    {
        c.add(new dw(e));
        d = d + e.length;
        e = new byte[Math.max(b, Math.max(i, d >>> 1))];
        f = 0;
    }

    private int b()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = d;
        j = f;
        this;
        JVM INSTR monitorexit ;
        return i + j;
        Exception exception;
        exception;
        throw exception;
    }

    public final do a()
    {
        this;
        JVM INSTR monitorenter ;
        if (f >= e.length)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (f > 0)
        {
            byte abyte0[] = e;
            int i = f;
            byte abyte1[] = new byte[i];
            System.arraycopy(abyte0, 0, abyte1, 0, Math.min(abyte0.length, i));
            c.add(new dw(abyte1));
        }
_L1:
        do do1;
        d = d + f;
        f = 0;
        do1 = com.tapjoy.internal.do.a(c);
        this;
        JVM INSTR monitorexit ;
        return do1;
        c.add(new dw(e));
        e = a;
          goto _L1
        Exception exception;
        exception;
        throw exception;
    }

    public final String toString()
    {
        return String.format("<ByteString.Output@%s size=%d>", new Object[] {
            Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(b())
        });
    }

    public final void write(int i)
    {
        this;
        JVM INSTR monitorenter ;
        byte abyte0[];
        int j;
        if (f == e.length)
        {
            a(1);
        }
        abyte0 = e;
        j = f;
        f = j + 1;
        abyte0[j] = (byte)i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (j > e.length - f) goto _L2; else goto _L1
_L1:
        System.arraycopy(abyte0, i, e, f, j);
        f = f + j;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        int k;
        k = e.length - f;
        System.arraycopy(abyte0, i, e, f, k);
        j -= k;
        a(j);
        System.arraycopy(abyte0, i + k, e, 0, j);
        f = j;
        if (true) goto _L4; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }


    ()
    {
        e = new byte[128];
    }
}
