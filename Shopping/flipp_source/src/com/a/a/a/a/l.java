// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import com.a.a.a.a;
import com.a.a.a.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

final class l extends a
{

    private static final byte b[] = {
        13, 10
    };
    private static final byte c[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        97, 98, 99, 100, 101, 102
    };
    private static final byte d[] = {
        48, 13, 10, 13, 10
    };
    private final byte e[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 13, 10
    };
    private final OutputStream f;
    private final int g;
    private final ByteArrayOutputStream h;

    private l(OutputStream outputstream, int i)
    {
        f = outputstream;
        int k = 4;
        for (int j = i - 4; j > 0; j >>= 4)
        {
            k++;
        }

        g = Math.max(1, i - k);
        h = new ByteArrayOutputStream(i);
    }

    l(OutputStream outputstream, int i, byte byte0)
    {
        this(outputstream, i);
    }

    private void a(int i)
    {
        int j = 8;
        int k;
        int i1;
        do
        {
            byte abyte0[] = e;
            k = j - 1;
            abyte0[k] = c[i & 0xf];
            i1 = i >>> 4;
            j = k;
            i = i1;
        } while (i1 != 0);
        f.write(e, k, e.length - k);
    }

    private void b()
    {
        int i = h.size();
        if (i <= 0)
        {
            return;
        } else
        {
            a(i);
            h.writeTo(f);
            h.reset();
            f.write(b);
            return;
        }
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
        b();
        f.write(d);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void flush()
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
        b();
        f.flush();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void write(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        a();
        u.a(abyte0.length, i, j);
_L2:
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        int i1;
        if (h.size() <= 0 && j >= g)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        i1 = Math.min(j, g - h.size());
        h.write(abyte0, i, i1);
        int k = i1;
        if (h.size() != g)
        {
            break MISSING_BLOCK_LABEL_137;
        }
        b();
        k = i1;
        break MISSING_BLOCK_LABEL_137;
        k = g;
        a(k);
        f.write(abyte0, i, k);
        f.write(b);
        break MISSING_BLOCK_LABEL_137;
        abyte0;
        throw abyte0;
        this;
        JVM INSTR monitorexit ;
        return;
        i += k;
        j -= k;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
