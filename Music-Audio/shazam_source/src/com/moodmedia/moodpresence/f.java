// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.moodmedia.moodpresence:
//            FloatFFT, d, c

class f
    implements Runnable
{

    private static int a[][];
    private static int b[][];
    private static int c[][];
    private static int d[][];
    private final FloatFFT e = new FloatFFT();
    private BlockingQueue f;
    private BlockingQueue g;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private int m;
    private double n[];
    private double o[][][][];
    private double p[][];
    private int q;
    private double r[][];
    private double s[];
    private d t[];
    private int u;

    f(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, int i1)
    {
        o = (double[][][][])Array.newInstance(Double.TYPE, new int[] {
            2, 7, 12, 63
        });
        p = (double[][])Array.newInstance(Double.TYPE, new int[] {
            2, 63
        });
        r = (double[][])Array.newInstance(Double.TYPE, new int[] {
            107, 48
        });
        s = new double[48];
        t = new d[64];
        f = blockingqueue;
        g = blockingqueue1;
        h = i1;
        if (h == 48000)
        {
            m = 2229;
        } else
        {
            m = 2048;
        }
        n = new double[m];
        i1 = 0;
        do
        {
            if (i1 >= 64)
            {
                u = 0;
                return;
            }
            t[i1] = new d();
            i1++;
        } while (true);
    }

    private static double a(double d1, double d2)
    {
        return Math.log10(d1 * d1 + d2 * d2 + 1.5848999999999999E-13D);
    }

    static int a()
    {
        return 9;
    }

    private void a(int i1)
    {
        this;
        JVM INSTR monitorenter ;
        l = false;
        i = i1 % 2;
        j = (i1 / 2) % 7;
        k = (i1 / 14) % 12;
        q = i1 % 107;
        if (i == 1 && j == 6)
        {
            l = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void a(c c1)
    {
        this;
        JVM INSTR monitorenter ;
        a(c1.b());
        a(c1.a(), n);
        e.nativeFFT(n);
        a(n);
        b(n);
        if (!l) goto _L2; else goto _L1
_L1:
        long l1 = d().longValue();
        c1 = t[u];
        u = u + 1;
        if (u == 64)
        {
            u = 0;
        }
        c1.a(l1);
        c1.a(g.a.b);
        if (!Thread.currentThread().isInterrupted())
        {
            g.offer(c1, 1000L, TimeUnit.MILLISECONDS);
        }
_L3:
        long l2 = e().longValue();
        c1 = t[u];
        u = u + 1;
        if (u == 64)
        {
            u = 0;
        }
        c1.a(l2);
        c1.a(g.a.a);
        if (!Thread.currentThread().isInterrupted())
        {
            g.offer(c1, 1000L, TimeUnit.MILLISECONDS);
        }
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        c1;
        Thread.currentThread().interrupt();
          goto _L3
        c1;
        throw c1;
        c1;
        Thread.currentThread().interrupt();
          goto _L2
    }

    private void a(double ad[])
    {
        int i1 = 0;
_L1:
        int j1;
        if (i1 >= 9)
        {
            i1 = 0;
            break MISSING_BLOCK_LABEL_10;
        }
        j1 = 0;
_L2:
label0:
        {
            if (j1 < 2)
            {
                break label0;
            }
            i1++;
        }
          goto _L1
        int k1 = a[i1][j1];
        ad[k1] = a(ad[k1], ad[k1 + 1]);
        j1++;
          goto _L2
_L4:
        if (i1 >= 48)
        {
            return;
        }
        j1 = 0;
_L5:
label1:
        {
            if (j1 < 12)
            {
                break label1;
            }
            i1++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        int l1 = c[i1][j1];
        ad[l1] = a(ad[l1], ad[l1 + 1]);
        j1++;
          goto _L5
    }

    private static void a(short aword0[], double ad[])
    {
        int i1 = 0;
        do
        {
            if (i1 >= ad.length)
            {
                return;
            }
            ad[i1] = aword0[i1];
            i1++;
        } while (true);
    }

    static int b()
    {
        return 7;
    }

    private void b(double ad[])
    {
        this;
        JVM INSTR monitorenter ;
        int i1 = 0;
_L19:
        if (i1 < 9) goto _L2; else goto _L1
_L1:
        i1 = 0;
_L21:
        if (i1 >= 48)
        {
            return;
        }
          goto _L3
_L2:
        o[i][j][k][i1] = 0L;
        int j1;
        int k1;
        j1 = 0;
        k1 = 0;
_L20:
        if (k1 < 2) goto _L5; else goto _L4
_L4:
        int l1;
        l1 = (j * 9 + i1) % 63;
        p[i][l1] = 0L;
        k1 = 0;
_L12:
        if (k1 < 12) goto _L7; else goto _L6
_L6:
        if (j1 <= 0) goto _L9; else goto _L8
_L8:
        double ad1[] = p[i];
        ad1[l1] = ad1[l1] / (double)j1;
          goto _L9
_L5:
        int i2 = a[i1][k1];
        l1 = j1;
        if (ad[i2] <= -3D) goto _L11; else goto _L10
_L10:
        double ad2[] = o[i][j][k];
        ad2[i1] = ad2[i1] + (ad[i2] + 3D) * (double)b[i1][k1];
        l1 = j1 + 1;
          goto _L11
_L7:
        double ad3[] = p[i];
        ad3[l1] = ad3[l1] + o[i][j][k1][i1];
        k1++;
          goto _L12
_L3:
        r[q][i1] = 0L;
        j1 = 0;
        k1 = 0;
_L22:
        if (k1 < 12) goto _L14; else goto _L13
_L13:
        s[i1] = 0.0D;
        k1 = 0;
_L18:
        if (k1 < 107) goto _L16; else goto _L15
_L15:
        if (j1 <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        double ad4[] = s;
        ad4[i1] = ad4[i1] / (double)j1;
        break; /* Loop/switch isn't completed */
_L14:
        i2 = c[i1][k1];
        l1 = j1;
        if (ad[i2] <= -3D)
        {
            break MISSING_BLOCK_LABEL_444;
        }
        double ad5[] = r[q];
        ad5[i1] = ad5[i1] + (ad[i2] + 3D) * (double)d[i1][k1];
        l1 = j1 + 1;
        break MISSING_BLOCK_LABEL_444;
_L16:
        double ad6[] = s;
        ad6[i1] = ad6[i1] + r[k1][i1];
        k1++;
        if (true) goto _L18; else goto _L17
        ad;
        throw ad;
_L9:
        i1++;
          goto _L19
_L11:
        k1++;
        j1 = l1;
          goto _L20
_L17:
        i1++;
          goto _L21
        k1++;
        j1 = l1;
          goto _L22
    }

    private void c()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        l = false;
        int i1 = 0;
_L10:
        if (i1 < 2) goto _L2; else goto _L1
_L1:
        i1 = ((flag) ? 1 : 0);
_L8:
        if (i1 >= 107)
        {
            return;
        }
          goto _L3
_L2:
        int j1 = 0;
_L5:
        int k1;
        if (j1 >= 7)
        {
            i1++;
            continue; /* Loop/switch isn't completed */
        }
        k1 = 0;
_L6:
label0:
        {
            if (k1 < 12)
            {
                break label0;
            }
            j1++;
        }
        if (true) goto _L5; else goto _L4
_L4:
        Arrays.fill(o[i1][j1][k1], 0.0D);
        k1++;
          goto _L6
_L3:
        Arrays.fill(r[i1], 0.0D);
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private Long d()
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        long l1;
        l1 = 0L;
        i1 = 0;
_L2:
        if (i1 >= 63)
        {
            return Long.valueOf(l1);
        }
        double d1 = p[i][i1];
        int j1;
        if (d1 > 0.0D)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        l1 += (1L << i1) * (long)j1;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    private Long e()
    {
        this;
        JVM INSTR monitorenter ;
        int i1;
        long l1;
        l1 = 0L;
        i1 = 0;
_L2:
        if (i1 >= 48)
        {
            return Long.valueOf(l1);
        }
        double d1 = s[i1];
        int j1;
        if (d1 > 0.0D)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        l1 += (1L << i1) * (long)j1;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    public final void run()
    {
        c();
_L1:
        if (Thread.currentThread().isInterrupted())
        {
            return;
        }
        try
        {
            a((c)f.take());
        }
        catch (InterruptedException interruptedexception)
        {
            Thread.currentThread().interrupt();
            return;
        }
          goto _L1
    }

    static 
    {
        int i1;
        int j1;
        a = (int[][])Array.newInstance(Integer.TYPE, new int[] {
            9, 2
        });
        i1 = 884;
        j1 = 0;
_L1:
        if (j1 >= 2)
        {
            b = (int[][])Array.newInstance(Integer.TYPE, new int[] {
                9, 2
            });
            i1 = 0;
            break MISSING_BLOCK_LABEL_61;
        }
        k1 = 0;
_L2:
label0:
        {
            if (k1 < 9)
            {
                break label0;
            }
            j1 += 2;
        }
          goto _L1
        a[k1][0] = i1 * 2;
        i1 += 4;
        a[k1][1] = i1 * 2;
        i1 += 4;
        k1++;
          goto _L2
_L3:
        int k1;
        if (i1 >= 2)
        {
            c = (int[][])Array.newInstance(Integer.TYPE, new int[] {
                48, 12
            });
            i1 = 46;
            j1 = 0;
            break MISSING_BLOCK_LABEL_96;
        }
        j1 = 0;
_L4:
label1:
        {
            if (j1 < 9)
            {
                break label1;
            }
            i1 += 2;
        }
          goto _L3
        b[j1][0] = 1;
        b[j1][1] = -1;
        j1++;
          goto _L4
_L5:
        if (j1 >= 12)
        {
            d = (int[][])Array.newInstance(Integer.TYPE, new int[] {
                48, 12
            });
            i1 = 0;
            break MISSING_BLOCK_LABEL_129;
        }
        l1 = 0;
_L6:
label2:
        {
            if (l1 < 48)
            {
                break label2;
            }
            j1 += 2;
        }
          goto _L5
        c[l1][j1] = i1 * 2;
        i1++;
        c[l1][j1 + 1] = i1 * 2;
        i1++;
        l1++;
          goto _L6
_L8:
        int l1;
        if (i1 >= 12)
        {
            return;
        }
        j1 = 0;
_L9:
label3:
        {
            if (j1 < 48)
            {
                break label3;
            }
            i1 += 2;
        }
        if (true) goto _L8; else goto _L7
_L7:
        d[j1][i1] = 1;
        d[j1][i1 + 1] = -1;
        j1++;
          goto _L9
    }
}
