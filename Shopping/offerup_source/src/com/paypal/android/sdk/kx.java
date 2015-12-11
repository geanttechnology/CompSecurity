// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

// Referenced classes of package com.paypal.android.sdk:
//            lj, kz, ky, kq, 
//            lf, ks, lk

public final class kx
    implements lj
{

    private int a;
    private final ks b;
    private final Inflater c;
    private final ky d;
    private final CRC32 e = new CRC32();

    public kx(lj lj1)
    {
        a = 0;
        if (lj1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            c = new Inflater(true);
            b = kz.a(lj1);
            d = new ky(b, c);
            return;
        }
    }

    private void a(kq kq1, long l, long l1)
    {
        kq1 = kq1.a;
        Object obj;
        long l2;
        long l3;
        do
        {
            obj = kq1;
            l2 = l;
            l3 = l1;
            if (l < (long)(((lf) (kq1)).c - ((lf) (kq1)).b))
            {
                break;
            }
            l -= ((lf) (kq1)).c - ((lf) (kq1)).b;
            kq1 = ((lf) (kq1)).f;
        } while (true);
        while (l3 > 0L) 
        {
            int i = (int)((long)((lf) (obj)).b + l2);
            int j = (int)Math.min(((lf) (obj)).c - i, l3);
            e.update(((lf) (obj)).a, i, j);
            l3 -= j;
            obj = ((lf) (obj)).f;
            l2 = 0L;
        }
    }

    private static void a(String s, int i, int j)
    {
        if (j != i)
        {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[] {
                s, Integer.valueOf(j), Integer.valueOf(i)
            }));
        } else
        {
            return;
        }
    }

    public final long a(kq kq1, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (l == 0L)
        {
            return 0L;
        }
        if (a == 0)
        {
            b.a(10L);
            byte byte0 = b.b().b(3L);
            boolean flag;
            if ((byte0 >> 1 & 1) == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                a(b.b(), 0L, 10L);
            }
            a("ID1ID2", 8075, b.e());
            b.f(8L);
            if ((byte0 >> 2 & 1) == 1)
            {
                b.a(2L);
                if (flag)
                {
                    a(b.b(), 0L, 2L);
                }
                int i = b.b().g();
                b.a(i);
                if (flag)
                {
                    a(b.b(), 0L, i);
                }
                b.f(i);
            }
            if ((byte0 >> 3 & 1) == 1)
            {
                long l1 = b.a((byte)0);
                if (l1 == -1L)
                {
                    throw new EOFException();
                }
                if (flag)
                {
                    a(b.b(), 0L, 1L + l1);
                }
                b.f(1L + l1);
            }
            if ((byte0 >> 4 & 1) == 1)
            {
                long l2 = b.a((byte)0);
                if (l2 == -1L)
                {
                    throw new EOFException();
                }
                if (flag)
                {
                    a(b.b(), 0L, 1L + l2);
                }
                b.f(1L + l2);
            }
            if (flag)
            {
                a("FHCRC", b.g(), (short)(int)e.getValue());
                e.reset();
            }
            a = 1;
        }
        if (a == 1)
        {
            long l3 = kq1.b;
            l = d.a(kq1, l);
            if (l != -1L)
            {
                a(kq1, l3, l);
                return l;
            }
            a = 2;
        }
        if (a == 2)
        {
            a("CRC", b.h(), (int)e.getValue());
            a("ISIZE", b.h(), c.getTotalOut());
            a = 3;
            if (!b.c())
            {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    public final lk a()
    {
        return b.a();
    }

    public final void close()
    {
        d.close();
    }
}
