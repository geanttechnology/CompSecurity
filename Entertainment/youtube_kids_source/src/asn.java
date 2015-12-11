// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.ByteBuffer;

public class asn
    implements asl
{

    final art a;
    final arx b;
    final aro c;
    final arw d = new arw();
    arn e;
    volatile boolean f;
    volatile long g;
    volatile long h;
    int i;
    int j;
    int k;

    public asn(art art1, arx arx1, aro aro1)
    {
        boolean flag;
        if (arx1.e <= 0x7fffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        a = art1;
        b = arx1;
        c = aro1;
        h = -1L;
    }

    public int a(int l)
    {
        return a(null, null, 0, d, l);
    }

    public int a(ByteBuffer bytebuffer, int l)
    {
        return a(bytebuffer, null, 0, d, l);
    }

    int a(ByteBuffer bytebuffer, byte abyte0[], int l, arw arw1, int i1)
    {
        if (i())
        {
            return -1;
        }
        int l1 = (int)Math.min(g - (long)arw1.a, i1);
        if (l1 == 0)
        {
            return 0;
        }
        if (arw1.a == 0)
        {
            arw1.b = 0;
            arn arn1 = e;
            arw1.c = 0;
            arw1.d = e.c();
        }
        byte abyte1[][] = e.b();
        boolean flag = false;
        i1 = l;
        l = ((flag) ? 1 : 0);
        while (l < l1) 
        {
            if (arw1.d == 0)
            {
                arw1.b = arw1.b + 1;
                arn arn2 = e;
                int j1 = arw1.b;
                arw1.c = 0;
                arn2 = e;
                j1 = arw1.b;
                arw1.d = arn2.c();
            }
            int i2 = Math.min(arw1.d, l1 - l);
            int k1;
            if (bytebuffer != null)
            {
                bytebuffer.put(abyte1[arw1.b], arw1.c, i2);
                k1 = i1;
            } else
            {
                k1 = i1;
                if (abyte0 != null)
                {
                    System.arraycopy(abyte1[arw1.b], arw1.c, abyte0, i1, i2);
                    k1 = i1 + i2;
                }
            }
            arw1.a = arw1.a + i2;
            l += i2;
            arw1.c = arw1.c + i2;
            arw1.d = arw1.d - i2;
            i1 = k1;
        }
        return l;
    }

    public int a(byte abyte0[], int l, int i1)
    {
        return a(null, abyte0, l, d, i1);
    }

    public long a()
    {
        return g - (long)d.a;
    }

    public void b()
    {
        arw arw1 = d;
        arw1.a = 0;
        arw1.b = 0;
        arw1.c = 0;
        arw1.d = 0;
    }

    public long c()
    {
        return g;
    }

    public void d()
    {
        f = true;
    }

    public boolean e()
    {
        return f;
    }

    public void f()
    {
        if (f || h())
        {
            return;
        }
        if (g != 0L || h != -1L) goto _L2; else goto _L1
_L1:
        long l1;
        arx arx1 = b;
        l1 = a.a(arx1);
        if (l1 <= 0x7fffffffL)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        throw new arv(new asr(b.e, l1));
        Exception exception;
        exception;
        atp.a(a);
        throw exception;
        h = l1;
_L11:
        if (e != null) goto _L4; else goto _L3
_L3:
        int l;
        if (h == -1L)
        {
            break MISSING_BLOCK_LABEL_571;
        }
        l = (int)h;
_L17:
        e = c.a(l);
_L4:
        Object obj;
        int i1;
        i1 = e.a();
        if (g == 0L)
        {
            i = 0;
            arn arn1 = e;
            j = 0;
            k = e.c();
        }
        obj = e.b();
        l = 0x7fffffff;
_L13:
        if (f || l <= 0) goto _L6; else goto _L5
_L5:
        if (!k()) goto _L6; else goto _L7
_L7:
        if (Thread.interrupted())
        {
            throw new InterruptedException();
        }
          goto _L8
_L2:
        if (h == -1L) goto _L10; else goto _L9
_L9:
        l1 = h - g;
_L16:
        obj = new arx(b.a, b.d + g, l1, b.f);
        a.a(((arx) (obj)));
          goto _L11
_L8:
        int j1 = a.a(obj[i], j, k);
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_492;
        }
        g = g + (long)j1;
        j = j + j1;
        k = k - j1;
        l = j1;
        if (k != 0) goto _L13; else goto _L12
_L12:
        l = j1;
        if (!k()) goto _L13; else goto _L14
_L14:
        i = i + 1;
        l = i1;
        if (g == (long)i1)
        {
            e.a(i1 + 0x40000);
            l = e.a();
            obj = e.b();
        }
        arn arn2 = e;
        i1 = i;
        j = 0;
        arn2 = e;
        i1 = i;
        k = arn2.c();
        i1 = l;
        l = j1;
          goto _L13
        if (h != -1L)
        {
            break MISSING_BLOCK_LABEL_517;
        }
        h = g;
        l = j1;
          goto _L13
        l = j1;
        if (h == g) goto _L13; else goto _L15
_L15:
        throw new arv(new asr(h, g));
_L6:
        atp.a(a);
        return;
_L10:
        l1 = -1L;
          goto _L16
        l = 0x40000;
          goto _L17
    }

    public long g()
    {
        if (h != -1L)
        {
            return h;
        } else
        {
            return b.e;
        }
    }

    public boolean h()
    {
        return h != -1L && g == h;
    }

    public boolean i()
    {
        return h != -1L && (long)d.a == h;
    }

    public void j()
    {
        if (e != null)
        {
            e.d();
            e = null;
        }
    }

    boolean k()
    {
        return h == -1L || g < h;
    }
}
