// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.io;

import java.io.ByteArrayOutputStream;

public class FixedSizeByteArrayOutputStream extends ByteArrayOutputStream
{

    public FixedSizeByteArrayOutputStream(int i)
    {
        if (i >= 0)
        {
            buf = new byte[i];
            return;
        } else
        {
            throw new IllegalArgumentException("size < 0");
        }
    }

    private static void checkOffsetAndCount(int i, int j, int k)
    {
        if ((j | k) < 0 || j > i || i - j < k)
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("Array length: ").append(i).append(", offset: ").append(j).append(", count: ").append(k).toString());
        } else
        {
            return;
        }
    }

    public void write(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        int k;
        j = count;
        k = buf.length;
        if (j != k) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        byte abyte0[];
        abyte0 = buf;
        j = count;
        count = j + 1;
        abyte0[j] = (byte)i;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void write(byte abyte0[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        int l;
        checkOffsetAndCount(abyte0.length, i, j);
        k = buf.length;
        l = count;
        k -= l;
        if (k != 0 && j != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        j = Math.min(k, j);
        System.arraycopy(abyte0, i, buf, count, j);
        count = count + j;
        if (true) goto _L1; else goto _L3
_L3:
        abyte0;
        throw abyte0;
    }
}
