// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class bj extends FilterInputStream
{

    public bj(InputStream inputstream)
    {
        super(inputstream);
    }

    public final int read(byte abyte0[])
    {
        int i = 0;
        do
        {
            int j;
label0:
            {
label1:
                {
                    if (i < abyte0.length)
                    {
                        j = super.read(abyte0, i, abyte0.length - i);
                        if (j != -1)
                        {
                            break label0;
                        }
                        if (i == 0)
                        {
                            break label1;
                        }
                    }
                    return i;
                }
                return -1;
            }
            i += j;
        } while (true);
    }

    public final int read(byte abyte0[], int i, int j)
    {
        int k = 0;
        do
        {
            int l;
label0:
            {
label1:
                {
                    if (k < j)
                    {
                        l = super.read(abyte0, i + k, j - k);
                        if (l != -1)
                        {
                            break label0;
                        }
                        if (k == 0)
                        {
                            break label1;
                        }
                    }
                    return k;
                }
                return -1;
            }
            k += l;
        } while (true);
    }

    public final long skip(long l)
    {
        long l1;
        long l2;
        for (l1 = 0L; l1 < l; l1 = l2 + l1)
        {
            long l3 = super.skip(l - l1);
            l2 = l3;
            if (l3 != 0L)
            {
                continue;
            }
            if (super.read() < 0)
            {
                break;
            }
            l2 = l3 + 1L;
        }

        return l1;
    }
}
