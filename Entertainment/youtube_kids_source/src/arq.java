// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

public final class arq
    implements aro
{

    public final int a;
    private int b;
    private int c;
    private byte d[][];

    public arq(int i)
    {
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag);
        a = i;
        d = new byte[100][];
    }

    public final int a()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int j;
        i = b;
        j = a;
        this;
        JVM INSTR monitorexit ;
        return i * j;
        Exception exception;
        exception;
        throw exception;
    }

    public final arn a(int i)
    {
        this;
        JVM INSTR monitorenter ;
        arr arr1 = new arr(this, a(i, null));
        this;
        JVM INSTR monitorexit ;
        return arr1;
        Exception exception;
        exception;
        throw exception;
    }

    final void a(arr arr1)
    {
        this;
        JVM INSTR monitorenter ;
        arr1 = arr1.a;
        b = b - arr1.length;
        int i = c + arr1.length;
        if (d.length < i)
        {
            byte abyte0[][] = new byte[i << 1][];
            if (c > 0)
            {
                System.arraycopy(d, 0, abyte0, 0, c);
            }
            d = abyte0;
        }
        System.arraycopy(arr1, 0, d, c, arr1.length);
        c = i;
        this;
        JVM INSTR monitorexit ;
        return;
        arr1;
        throw arr1;
    }

    final byte[][] a(int i, byte abyte0[][])
    {
        int j = 0;
        this;
        JVM INSTR monitorenter ;
        long l = i;
        int k = (int)(((l + (long)a) - 1L) / (long)a);
        if (abyte0 == null) goto _L2; else goto _L1
_L1:
        i = abyte0.length;
        if (k > i) goto _L2; else goto _L3
_L3:
        this;
        JVM INSTR monitorexit ;
        return abyte0;
_L2:
        byte abyte1[][] = new byte[k][];
        i = j;
        if (abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        i = abyte0.length;
        System.arraycopy(abyte0, 0, abyte1, 0, i);
        b = b + (k - i);
_L4:
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        if (c <= 0)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        abyte0 = d;
        j = c - 1;
        c = j;
        abyte0 = abyte0[j];
        break MISSING_BLOCK_LABEL_142;
        abyte0 = new byte[a];
        break MISSING_BLOCK_LABEL_142;
        abyte0 = abyte1;
          goto _L3
        abyte0;
        throw abyte0;
        abyte1[i] = abyte0;
        i++;
          goto _L4
    }

    public final void b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        i = Math.max(0, ((a + i) - 1) / a - b);
        if (i < c)
        {
            Arrays.fill(d, i, c, null);
            c = i;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
