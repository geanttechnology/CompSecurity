// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.p;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import myobfuscated.s.b;
import myobfuscated.s.g;

// Referenced classes of package myobfuscated.p:
//            d, c, b

public class a
{

    private static final String k = myobfuscated/p/a.getSimpleName();
    public ByteBuffer a;
    public byte b[];
    public byte c[];
    public byte d[];
    public int e[];
    public int f;
    public d g;
    public myobfuscated.p.b h;
    public Bitmap i;
    public boolean j;
    private int l[];
    private int m;
    private int n;
    private short o[];
    private byte p[];
    private byte q[];
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;

    private a(myobfuscated.p.b b1)
    {
        m = 0;
        n = 0;
        h = b1;
        g = new d();
    }

    public a(myobfuscated.p.b b1, d d1, ByteBuffer bytebuffer, int i1)
    {
        this(b1);
        a(d1, bytebuffer, i1);
    }

    private Bitmap a(c c1, c c2)
    {
        int ai[] = e;
        if (c2 == null || c2.g <= 0) goto _L2; else goto _L1
_L1:
        if (c2.g != 2) goto _L4; else goto _L3
_L3:
        int j1 = 0;
        if (c1.f) goto _L6; else goto _L5
_L5:
        int i1 = g.k;
_L24:
        int k1;
        int k4;
        int l6;
        int j7;
        Arrays.fill(ai, i1);
          goto _L2
_L6:
        i1 = j1;
        if (f == 0)
        {
            j = true;
            i1 = j1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (c2.g == 3 && i != null)
        {
            i.getPixels(ai, 0, v, 0, 0, v, u);
        }
_L2:
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int l3;
        int j4;
        m = 0;
        n = 0;
        if (c1 != null)
        {
            a.position(c1.j);
        }
        if (c1 == null)
        {
            k4 = g.f * g.g;
        } else
        {
            k4 = c1.c * c1.d;
        }
        if (d == null || d.length < k4)
        {
            d = h.a(k4);
        }
        if (o == null)
        {
            o = new short[4096];
        }
        if (p == null)
        {
            p = new byte[4096];
        }
        if (q == null)
        {
            q = new byte[4097];
        }
        l6 = d();
        j7 = 1 << l6;
        k1 = l6 + 1;
        for (i1 = 0; i1 < j7; i1++)
        {
            o[i1] = 0;
            p[i1] = (byte)i1;
        }

        j3 = 0;
        i3 = 0;
        j2 = -1;
        i2 = k1;
        k3 = 0;
        j4 = 0;
        l2 = 0;
        j1 = 0;
        k2 = (1 << k1) - 1;
        l1 = j7 + 2;
        i1 = 0;
        k1 = 0;
          goto _L7
        l3 = 0;
        int i4;
        j3 += (b[l3] & 0xff) << i3;
        i4 = l3 + 1;
        l3 = j1 - 1;
        int i5 = i2;
        k1 = k2;
        i3 += 8;
        j1 = l2;
        i2 = i1;
        i1 = j2;
        l2 = j3;
        j3 = k3;
        j2 = i2;
        i2 = l1;
        l1 = i5;
        break MISSING_BLOCK_LABEL_493;
_L7:
        if (l2 < k4)
        {
            l3 = j1;
            j1 = k1;
            if (k1 != 0)
            {
                break MISSING_BLOCK_LABEL_415;
            }
            j1 = e();
            if (j1 > 0)
            {
                break MISSING_BLOCK_LABEL_412;
            }
            s = 3;
        }
        byte abyte0[];
        int j5;
        for (; i1 < k4; i1++)
        {
            d[i1] = 0;
        }

        int l7 = c1.d / t;
        int i8 = c1.b / t;
        int j8 = c1.c / t;
        int k8 = c1.a / t;
        k1 = 1;
        j1 = 8;
        l1 = 0;
        int j9;
        if (f == 0)
        {
            k3 = 1;
        } else
        {
            k3 = 0;
        }
        j2 = 0;
_L20:
        if (j2 >= l7) goto _L9; else goto _L8
_L8:
        if (!c1.e)
        {
            break MISSING_BLOCK_LABEL_1821;
        }
        i1 = l1;
        i2 = j1;
        k2 = k1;
        if (l1 < l7) goto _L11; else goto _L10
_L10:
        k2 = k1 + 1;
        k2;
        JVM INSTR tableswitch 2 4: default 1076
    //                   2 1390
    //                   3 1400
    //                   4 1409;
           goto _L12 _L13 _L14 _L15
_L12:
        i2 = j1;
        i1 = l1;
_L11:
        l1 = i1 + i2;
        k1 = i2;
        j1 = k2;
_L21:
        i1 += i8;
        if (i1 >= u) goto _L17; else goto _L16
_L16:
        i1 *= v;
        i4 = i1 + k8;
        l3 = i4 + j8;
        if (v + i1 < l3)
        {
            l3 = v + i1;
        }
        i1 = t * j2 * c1.c;
        l8 = i1 + (l3 - i4) * t;
_L19:
        if (i4 >= l3) goto _L17; else goto _L18
_L13:
        i1 = 4;
        i2 = j1;
          goto _L11
_L14:
        i1 = 2;
        i2 = 4;
          goto _L11
_L15:
        i1 = 1;
        i2 = 2;
          goto _L11
_L18:
        int i9 = c1.c;
        j3 = 0;
        i3 = 0;
        l2 = 0;
        k2 = 0;
        i2 = 0;
        for (j4 = i1; j4 < t + i1 && j4 < d.length && j4 < l8;)
        {
            k4 = d[j4];
            j9 = l[k4 & 0xff];
            j7 = i2;
            l6 = k2;
            j6 = l2;
            k5 = i3;
            k4 = j3;
            if (j9 != 0)
            {
                k4 = j3 + (j9 >> 24 & 0xff);
                k5 = i3 + (j9 >> 16 & 0xff);
                j6 = l2 + (j9 >> 8 & 0xff);
                l6 = k2 + (j9 & 0xff);
                j7 = i2 + 1;
            }
            j4++;
            i2 = j7;
            k2 = l6;
            l2 = j6;
            i3 = k5;
            j3 = k4;
        }

        k4 = i1 + i9;
        j4 = j3;
        j3 = i3;
        i3 = l2;
        l2 = k2;
        k2 = i2;
        for (i2 = k4; i2 < i1 + i9 + t && i2 < d.length && i2 < l8;)
        {
            int l4 = d[i2];
            int k9 = l[l4 & 0xff];
            int k7 = k2;
            int i7 = l2;
            j6 = i3;
            k5 = j3;
            l4 = j4;
            if (k9 != 0)
            {
                l4 = j4 + (k9 >> 24 & 0xff);
                k5 = j3 + (k9 >> 16 & 0xff);
                j6 = i3 + (k9 >> 8 & 0xff);
                i7 = l2 + (k9 & 0xff);
                k7 = k2 + 1;
            }
            i2++;
            k2 = k7;
            l2 = i7;
            i3 = j6;
            j3 = k5;
            j4 = l4;
        }

        if (k2 == 0)
        {
            i2 = 0;
        } else
        {
            i2 = j4 / k2 << 24 | j3 / k2 << 16 | i3 / k2 << 8 | l2 / k2;
        }
        if (i2 != 0)
        {
            ai[i4] = i2;
        } else
        if (!j && k3 != 0)
        {
            j = true;
        }
        i1 += t;
        i4++;
          goto _L19
_L17:
        j2++;
        i1 = j1;
        j1 = k1;
        k1 = i1;
          goto _L20
_L9:
        if (r && (c1.g == 0 || c1.g == 1))
        {
            if (i == null)
            {
                i = f();
            }
            i.setPixels(ai, 0, v, 0, 0, v, u);
        }
        c1 = f();
        c1.setPixels(ai, 0, v, 0, 0, v, u);
        return c1;
        i2 = k1;
        i1 = j2;
        k1 = j1;
        j1 = i2;
          goto _L21
        do
        {
            if (i3 < l1)
            {
                break MISSING_BLOCK_LABEL_1953;
            }
            k3 = l2 & k1;
            k2 = l2 >> l1;
            l2 = i3 - l1;
            if (k3 == j7)
            {
                l1 = l6 + 1;
                k1 = (1 << l1) - 1;
                i2 = j7 + 2;
                i1 = -1;
                i3 = l2;
                l2 = k2;
                continue;
            }
            if (k3 > i2)
            {
                s = 3;
                k3 = i1;
                j5 = l1;
                l1 = i2;
                i2 = i4;
                i1 = j2;
                i3 = l2;
                l2 = k2;
                i4 = j1;
                k2 = k1;
                k1 = l3;
                j1 = i2;
                i2 = j5;
                j2 = k3;
                k3 = j3;
                j3 = l2;
                l2 = i4;
                continue; /* Loop/switch isn't completed */
            }
            if (k3 == j7 + 1)
            {
                break;
            }
            if (i1 == -1)
            {
                q[j3] = p[k3];
                i1 = k3;
                j3++;
                i3 = l2;
                j4 = k3;
                l2 = k2;
                continue;
            }
            int k5;
            int j6;
            int l8;
            if (k3 >= i2)
            {
                q[j3] = (byte)j4;
                j3++;
                i3 = i1;
            } else
            {
                i3 = k3;
            }
            while (i3 >= j7) 
            {
                q[j3] = p[i3];
                i3 = o[i3];
                j3++;
            }
            j6 = p[i3] & 0xff;
            q[j3] = (byte)j6;
            k5 = l1;
            j4 = k1;
            i3 = i2;
            if (i2 < 4096)
            {
                o[i2] = (short)i1;
                p[i2] = (byte)j6;
                i1 = i2 + 1;
                k5 = l1;
                j4 = k1;
                i3 = i1;
                if ((i1 & k1) == 0)
                {
                    k5 = l1;
                    j4 = k1;
                    i3 = i1;
                    if (i1 < 4096)
                    {
                        k5 = l1 + 1;
                        j4 = k1 + i1;
                        i3 = i1;
                    }
                }
            }
            i1 = j1;
            for (j1 = j3 + 1; j1 > 0;)
            {
                c2 = d;
                abyte0 = q;
                j1--;
                c2[j2] = abyte0[j1];
                i1++;
                j2++;
            }

            j3 = j1;
            l1 = k5;
            k1 = j4;
            i2 = i3;
            i3 = l2;
            j1 = i1;
            i1 = k3;
            j4 = j6;
            l2 = k2;
        } while (true);
        k3 = i1;
        int l5 = l1;
        l1 = i2;
        i2 = i4;
        i1 = j2;
        i3 = l2;
        l2 = k2;
        i4 = j1;
        k2 = k1;
        k1 = l3;
        j1 = i2;
        i2 = l5;
        j2 = k3;
        k3 = j3;
        j3 = l2;
        l2 = i4;
        continue; /* Loop/switch isn't completed */
        k3 = i1;
        int i6 = j1;
        k2 = k1;
        int k6 = i2;
        i1 = j2;
        k1 = l3;
        j1 = i4;
        i2 = l1;
        l1 = k6;
        j2 = k3;
        k3 = j3;
        j3 = l2;
        l2 = i6;
        if (true) goto _L7; else goto _L22
_L22:
        if (true) goto _L24; else goto _L23
_L23:
    }

    private void a(d d1, ByteBuffer bytebuffer, int i1)
    {
        this;
        JVM INSTR monitorenter ;
        if (i1 > 0)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        throw new IllegalArgumentException((new StringBuilder("Sample size must be >=0, not: ")).append(i1).toString());
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
        int j1;
        i1 = Integer.highestOneBit(i1);
        s = 0;
        g = d1;
        j = false;
        f = -1;
        a = bytebuffer.asReadOnlyBuffer();
        a.position(0);
        a.order(ByteOrder.LITTLE_ENDIAN);
        r = false;
        bytebuffer = d1.e.iterator();
        do
        {
            if (!bytebuffer.hasNext())
            {
                break;
            }
            if (((c)bytebuffer.next()).g != 3)
            {
                continue;
            }
            r = true;
            break;
        } while (true);
        t = i1;
        d = h.a(d1.f * d1.g);
        bytebuffer = h;
        j1 = (d1.f / i1) * (d1.g / i1);
        if (((myobfuscated.p.b) (bytebuffer)).b != null)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        bytebuffer = new int[j1];
_L1:
        e = bytebuffer;
        v = d1.f / i1;
        u = d1.g / i1;
        this;
        JVM INSTR monitorexit ;
        return;
        bytebuffer = (int[])((myobfuscated.p.b) (bytebuffer)).b.a(j1, [I);
          goto _L1
    }

    private void c()
    {
        if (m > n)
        {
            return;
        }
        if (c == null)
        {
            c = h.a(16384);
        }
        n = 0;
        m = Math.min(a.remaining(), 16384);
        a.get(c, 0, m);
    }

    private int d()
    {
        byte abyte0[];
        int i1;
        try
        {
            c();
            abyte0 = c;
            i1 = n;
            n = i1 + 1;
        }
        catch (Exception exception)
        {
            s = 1;
            return 0;
        }
        i1 = abyte0[i1];
        return i1 & 0xff;
    }

    private int e()
    {
        int i1;
        i1 = d();
        if (i1 <= 0)
        {
            break MISSING_BLOCK_LABEL_172;
        }
        int j1;
        int k1;
        try
        {
            if (b == null)
            {
                b = h.a(255);
            }
            j1 = m - n;
        }
        catch (Exception exception)
        {
            Log.w(k, "Error Reading Block", exception);
            s = 1;
            return i1;
        }
        if (j1 < i1)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        System.arraycopy(c, n, b, 0, i1);
        n = n + i1;
        return i1;
        if (a.remaining() + j1 < i1)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        System.arraycopy(c, n, b, 0, j1);
        n = m;
        c();
        k1 = i1 - j1;
        System.arraycopy(c, 0, b, j1, k1);
        n = n + k1;
        return i1;
        s = 1;
        return i1;
    }

    private Bitmap f()
    {
        Object obj;
        myobfuscated.p.b b1;
        int i1;
        int j1;
        if (j)
        {
            obj = android.graphics.Bitmap.Config.ARGB_8888;
        } else
        {
            obj = android.graphics.Bitmap.Config.RGB_565;
        }
        b1 = h;
        i1 = v;
        j1 = u;
        obj = b1.a.b(i1, j1, ((android.graphics.Bitmap.Config) (obj)));
        if (android.os.Build.VERSION.SDK_INT >= 12)
        {
            ((Bitmap) (obj)).setHasAlpha(true);
        }
        return ((Bitmap) (obj));
    }

    public final void a()
    {
        f = (f + 1) % g.c;
    }

    public final Bitmap b()
    {
        int i1 = 0;
        this;
        JVM INSTR monitorenter ;
        if (g.c <= 0 || f < 0)
        {
            if (Log.isLoggable(k, 3))
            {
                (new StringBuilder("unable to decode frame, frameCount=")).append(g.c).append(" framePointer=").append(f);
            }
            s = 1;
        }
        if (s != 1 && s != 2) goto _L2; else goto _L1
_L1:
        if (Log.isLoggable(k, 3))
        {
            (new StringBuilder("Unable to decode frame, status=")).append(s);
        }
        Object obj = null;
_L5:
        this;
        JVM INSTR monitorexit ;
        return ((Bitmap) (obj));
_L2:
        c c1;
        int j1;
        s = 0;
        c1 = (c)g.e.get(f);
        j1 = f - 1;
        if (j1 < 0) goto _L4; else goto _L3
_L3:
        obj = (c)g.e.get(j1);
_L6:
        j1 = g.k;
        if (c1.k != null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        l = g.a;
_L7:
        if (c1.f)
        {
            i1 = l[c1.h];
            l[c1.h] = 0;
        }
        if (l != null)
        {
            break MISSING_BLOCK_LABEL_321;
        }
        Log.isLoggable(k, 3);
        s = 1;
        obj = null;
          goto _L5
_L4:
        obj = (c)g.e.get(g.c - 1);
          goto _L6
        l = c1.k;
        if (g.j == c1.h)
        {
            g.k = 0;
        }
          goto _L7
        obj;
        throw obj;
        obj = a(c1, ((c) (obj)));
        if (c1.f)
        {
            l[c1.h] = i1;
        }
        g.k = j1;
          goto _L5
    }

}
