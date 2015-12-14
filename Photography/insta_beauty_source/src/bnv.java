// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

public class bnv extends Thread
{

    private Bitmap A;
    private bnw B;
    private boolean C;
    private byte D[];
    private int E;
    private int F;
    private int G;
    private boolean H;
    private boolean I;
    private int J;
    private int K;
    private short L[];
    private byte M[];
    private byte N[];
    private byte O[];
    private bnw P;
    private int Q;
    private bnu R;
    private byte S[];
    private String T;
    private boolean U;
    public int a;
    public int b;
    private InputStream c;
    private int d;
    private boolean e;
    private int f;
    private int g;
    private int h[];
    private int i[];
    private int j[];
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private Bitmap z;

    public bnv(bnu bnu1)
    {
        g = 1;
        B = null;
        C = false;
        D = new byte[256];
        E = 0;
        F = 0;
        G = 0;
        H = false;
        I = false;
        J = 0;
        R = null;
        S = null;
        T = null;
        U = false;
        R = bnu1;
    }

    private int[] d(int i1)
    {
        int ai[];
        byte abyte0[];
        int l1;
        l1 = 0;
        int i2 = i1 * 3;
        ai = null;
        abyte0 = new byte[i2];
        int j1;
        try
        {
            j1 = c.read(abyte0);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            j1 = 0;
        }
        if (j1 >= i2) goto _L2; else goto _L1
_L1:
        d = 1;
_L4:
        return ai;
_L2:
        int ai1[] = new int[256];
        boolean flag = false;
        int k1 = l1;
        l1 = ((flag) ? 1 : 0);
        do
        {
            ai = ai1;
            if (k1 >= i1)
            {
                continue;
            }
            int k2 = l1 + 1;
            byte byte0 = abyte0[l1];
            int j2 = k2 + 1;
            k2 = abyte0[k2];
            l1 = j2 + 1;
            ai1[k1] = (byte0 & 0xff) << 16 | 0xff000000 | (k2 & 0xff) << 8 | abyte0[j2] & 0xff;
            k1++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private String e()
    {
        this;
        JVM INSTR monitorenter ;
        long l1 = System.currentTimeMillis();
        this;
        JVM INSTR monitorexit ;
        return String.valueOf(l1);
        Exception exception;
        exception;
        throw exception;
    }

    private void f()
    {
        int i3 = 0;
        int ai[] = new int[a * b];
        if (G > 0)
        {
            if (G == 3)
            {
                int i1 = Q - 2;
                int i2;
                int k2;
                if (i1 > 0)
                {
                    A = c(i1 - 1);
                } else
                {
                    A = null;
                }
            }
            if (A != null)
            {
                A.getPixels(ai, 0, a, 0, 0, a, b);
                if (G == 2)
                {
                    int j1;
                    int k1;
                    int l1;
                    int j2;
                    int l2;
                    int j3;
                    int k3;
                    if (!H)
                    {
                        k1 = m;
                    } else
                    {
                        k1 = 0;
                    }
                    for (l1 = 0; l1 < y; l1++)
                    {
                        i2 = (w + l1) * a + v;
                        k2 = x;
                        for (i1 = i2; i1 < k2 + i2; i1++)
                        {
                            ai[i1] = k1;
                        }

                    }

                }
            }
        }
        j2 = 8;
        l2 = 1;
        j1 = 0;
        l1 = i3;
        i3 = j1;
        if (l1 >= u) goto _L2; else goto _L1
_L1:
        if (!p)
        {
            break MISSING_BLOCK_LABEL_460;
        }
        j1 = i3;
        k1 = j2;
        j3 = l2;
        if (i3 < u) goto _L4; else goto _L3
_L3:
        j3 = l2 + 1;
        j3;
        JVM INSTR tableswitch 2 4: default 264
    //                   2 406
    //                   3 414
    //                   4 421;
           goto _L5 _L6 _L7 _L8
_L5:
        k1 = j2;
        j1 = i3;
_L4:
        i3 = j1 + k1;
        l2 = j3;
        break MISSING_BLOCK_LABEL_279;
_L6:
        j1 = 4;
        k1 = j2;
        continue; /* Loop/switch isn't completed */
_L7:
        j1 = 2;
        k1 = 4;
        continue; /* Loop/switch isn't completed */
_L8:
        j1 = 1;
        k1 = 2;
        continue; /* Loop/switch isn't completed */
_L10:
        j1 += s;
        if (j1 < b)
        {
            k3 = a * j1;
            j3 = k3 + r;
            j2 = t + j3;
            j1 = j2;
            if (a + k3 < j2)
            {
                j1 = a + k3;
            }
            for (j2 = t * l1; j3 < j1; j2++)
            {
                k3 = O[j2];
                k3 = j[k3 & 0xff];
                if (k3 != 0)
                {
                    ai[j3] = k3;
                }
                j3++;
            }

        }
        l1++;
        j2 = k1;
        break MISSING_BLOCK_LABEL_195;
_L2:
        z = Bitmap.createBitmap(ai, a, b, android.graphics.Bitmap.Config.RGB_565);
        return;
        j1 = l1;
        k1 = j2;
        if (true) goto _L10; else goto _L9
_L9:
        if (true) goto _L4; else goto _L11
_L11:
    }

    private int g()
    {
        c = new ByteArrayInputStream(S);
        S = null;
        return h();
    }

    private int h()
    {
        k();
        if (c != null)
        {
            p();
            if (!j())
            {
                n();
                if (Q < 0)
                {
                    d = 1;
                    R.parseOk(false, -1);
                } else
                {
                    d = -1;
                    R.parseOk(true, -1);
                }
            }
            try
            {
                c.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        } else
        {
            d = 2;
            R.parseOk(false, -1);
        }
        return d;
    }

    private void i()
    {
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        int l2;
        int i3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l5;
        int i6;
        int j6;
        l5 = t * u;
        if (O == null || O.length < l5)
        {
            O = new byte[l5];
        }
        if (L == null)
        {
            L = new short[4096];
        }
        if (M == null)
        {
            M = new byte[4096];
        }
        if (N == null)
        {
            N = new byte[4097];
        }
        i6 = l();
        j6 = 1 << i6;
        l2 = j6 + 2;
        k1 = i6 + 1;
        l1 = (1 << k1) - 1;
        for (int i1 = 0; i1 < j6; i1++)
        {
            L[i1] = 0;
            M[i1] = (byte)i1;
        }

        l3 = 0;
        i2 = 0;
        i3 = 0;
        j2 = 0;
        k4 = 0;
        i4 = 0;
        k2 = 0;
        j1 = -1;
        j4 = 0;
_L11:
        if (k4 >= l5) goto _L2; else goto _L1
_L1:
        if (i2 != 0)
        {
            break MISSING_BLOCK_LABEL_666;
        }
        if (k2 >= k1) goto _L4; else goto _L3
_L3:
        int j3 = i4;
        if (i4 != 0) goto _L6; else goto _L5
_L5:
        j3 = m();
        if (j3 > 0) goto _L7; else goto _L2
_L2:
        for (; l3 < l5; l3++)
        {
            O[l3] = 0;
        }

        break; /* Loop/switch isn't completed */
_L7:
        j4 = 0;
_L6:
        j2 += (D[j4] & 0xff) << k2;
        k2 += 8;
        j4++;
        i4 = j3 - 1;
        continue; /* Loop/switch isn't completed */
_L4:
        int l4;
        j3 = j2 & l1;
        l4 = j2 >> k1;
        k2 -= k1;
        if (j3 > l2 || j3 == j6 + 1) goto _L2; else goto _L8
_L8:
        if (j3 == j6)
        {
            k1 = i6 + 1;
            l1 = (1 << k1) - 1;
            l2 = j6 + 2;
            j1 = -1;
            j2 = l4;
            continue; /* Loop/switch isn't completed */
        }
        if (j1 == -1)
        {
            N[i2] = M[j3];
            i2++;
            j1 = j3;
            i3 = j3;
            j2 = l4;
            continue; /* Loop/switch isn't completed */
        }
        int k5;
        if (j3 == l2)
        {
            byte abyte0[] = N;
            int j5 = i2 + 1;
            abyte0[i2] = (byte)i3;
            j2 = j1;
            i2 = j5;
        } else
        {
            j2 = j3;
        }
        while (j2 > j6) 
        {
            N[i2] = M[j2];
            j2 = L[j2];
            i2++;
        }
        k5 = M[j2] & 0xff;
        if (l2 >= 4096) goto _L2; else goto _L9
_L9:
        N[i2] = (byte)k5;
        L[l2] = (short)j1;
        M[l2] = (byte)k5;
        i3 = l2 + 1;
        j1 = k1;
        j2 = l1;
        if ((i3 & l1) == 0)
        {
            j1 = k1;
            j2 = l1;
            if (i3 < 4096)
            {
                j1 = k1 + 1;
                j2 = l1 + i3;
            }
        }
        l1 = l4;
        l2 = j2;
        j2 = k5;
        l4 = i2 + 1;
        k1 = i3;
        i2 = l2;
        l2 = j1;
        j1 = j3;
        i3 = l4;
_L12:
        k5 = i3 - 1;
        O[l3] = N[k5];
        k4++;
        l4 = l3 + 1;
        i3 = l2;
        j3 = l1;
        l3 = k5;
        l2 = k1;
        k1 = i3;
        l1 = i2;
        i2 = l3;
        i3 = j2;
        j2 = j3;
        l3 = l4;
        if (true) goto _L11; else goto _L10
_L10:
        return;
        int k3 = l1;
        l1 = i3;
        i3 = i2;
        i2 = j2;
        int i5 = l2;
        j2 = l1;
        l1 = i2;
        l2 = k1;
        i2 = k3;
        k1 = i5;
          goto _L12
    }

    private boolean j()
    {
        return d != 0;
    }

    private void k()
    {
        d = 0;
        Q = 0;
        P = null;
        h = null;
        i = null;
    }

    private int l()
    {
        int i1;
        try
        {
            i1 = c.read();
        }
        catch (Exception exception)
        {
            d = 1;
            return 0;
        }
        return i1;
    }

    private int m()
    {
        int i1;
        int j1;
        E = l();
        j1 = 0;
        i1 = 0;
        if (E <= 0) goto _L2; else goto _L1
_L1:
        if (i1 >= E) goto _L4; else goto _L3
_L3:
        j1 = c.read(D, i1, E - i1);
        if (j1 != -1) goto _L5; else goto _L4
_L4:
        j1 = i1;
        if (i1 < E)
        {
            d = 1;
            j1 = i1;
        }
_L2:
        return j1;
_L5:
        i1 += j1;
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
          goto _L4
    }

    private void n()
    {
        boolean flag = false;
        do
        {
            if (flag || j())
            {
                break;
            }
            switch (l())
            {
            default:
                d = 1;
                continue;

            case 0: // '\0'
                break;

            case 44: // ','
                q();
                continue;

            case 33: // '!'
                switch (l())
                {
                default:
                    v();
                    break;

                case 249: 
                    o();
                    break;

                case 255: 
                    m();
                    String s1 = "";
                    for (int i1 = 0; i1 < 11; i1++)
                    {
                        s1 = (new StringBuilder()).append(s1).append((char)D[i1]).toString();
                    }

                    if (s1.equals("NETSCAPE2.0"))
                    {
                        s();
                    } else
                    {
                        v();
                    }
                    break;
                }
                break;

            case 59: // ';'
                flag = true;
                break;
            }
        } while (true);
    }

    private void o()
    {
        boolean flag = true;
        l();
        int i1 = l();
        F = (i1 & 0x1c) >> 2;
        if (F == 0)
        {
            F = 1;
        }
        if ((i1 & 1) == 0)
        {
            flag = false;
        }
        H = flag;
        J = t() * 10;
        K = l();
        l();
    }

    private void p()
    {
        String s1 = "";
        for (int i1 = 0; i1 < 6; i1++)
        {
            s1 = (new StringBuilder()).append(s1).append((char)l()).toString();
        }

        if (!s1.startsWith("GIF"))
        {
            d = 1;
        } else
        {
            r();
            if (e && !j())
            {
                h = d(f);
                l = h[k];
                return;
            }
        }
    }

    private void q()
    {
        int j1 = 0;
        r = t();
        s = t();
        t = t();
        u = t();
        int i1 = l();
        boolean flag;
        if ((i1 & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        o = flag;
        if ((i1 & 0x40) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
        q = 2 << (i1 & 7);
        if (o)
        {
            i = d(q);
            j = i;
        } else
        {
            j = h;
            if (k == K)
            {
                l = 0;
            }
        }
        if (H)
        {
            i1 = j[K];
            j[K] = 0;
        } else
        {
            i1 = 0;
        }
        if (j == null)
        {
            d = 1;
        }
        if (!j())
        {
            i();
            v();
            if (!j())
            {
                Q = Q + 1;
                f();
                if (P == null)
                {
                    if (U)
                    {
                        String s1 = (new StringBuilder()).append(e()).append("0").toString();
                        s1 = (new StringBuilder()).append(T).append(File.separator).append(s1).toString();
                        P = new bnw(z, s1, J);
                    } else
                    {
                        P = new bnw(z, J);
                    }
                    B = P;
                } else
                {
                    bnw bnw1;
                    for (bnw1 = P; bnw1.c != null;)
                    {
                        bnw1 = bnw1.c;
                        j1++;
                    }

                    if (U)
                    {
                        String s2 = (new StringBuilder()).append(e()).append(String.valueOf(j1)).toString();
                        s2 = (new StringBuilder()).append(T).append(File.separator).append(s2).toString();
                        bnw1.c = new bnw(z, s2, J);
                    } else
                    {
                        bnw1.c = new bnw(z, J);
                    }
                }
                if (H)
                {
                    j[K] = i1;
                }
                I = H;
                u();
                R.parseOk(true, Q);
                return;
            }
        }
    }

    private void r()
    {
        a = t();
        b = t();
        int i1 = l();
        boolean flag;
        if ((i1 & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        e = flag;
        f = 2 << (i1 & 7);
        k = l();
        n = l();
    }

    private void s()
    {
        do
        {
            m();
            if (D[0] == 1)
            {
                g = D[1] & 0xff | (D[2] & 0xff) << 8;
            }
        } while (E > 0 && !j());
    }

    private int t()
    {
        return l() | l() << 8;
    }

    private void u()
    {
        G = F;
        v = r;
        w = s;
        x = t;
        y = u;
        if (U && A != null && !A.isRecycled())
        {
            A.recycle();
            A = null;
        }
        A = z;
        m = l;
        F = 0;
        H = false;
        J = 0;
        i = null;
    }

    private void v()
    {
        do
        {
            m();
        } while (E > 0 && !j());
    }

    public int a(int i1)
    {
        J = -1;
        if (i1 >= 0 && i1 < Q)
        {
            bnw bnw1 = b(i1);
            if (bnw1 != null)
            {
                J = bnw1.a;
            }
        }
        return J;
    }

    public void a()
    {
        bnw bnw1 = P;
        Object obj = bnw1;
        if (!U)
        {
            for (; bnw1 != null; bnw1 = P)
            {
                obj = bnw1.a();
                if (obj != null && !((Bitmap) (obj)).isRecycled())
                {
                    ((Bitmap) (obj)).recycle();
                }
                bnw1.a(null);
                P = P.c;
            }

        } else
        {
            for (; obj != null; obj = P)
            {
                ((bnw) (obj)).b();
                P = P.c;
            }

            boz.a(T, true);
        }
        if (c != null)
        {
            try
            {
                c.close();
            }
            catch (Exception exception) { }
            c = null;
        }
        S = null;
        P = null;
        d = 0;
        B = null;
    }

    public void a(InputStream inputstream)
    {
        c = inputstream;
    }

    public void a(boolean flag, Context context)
    {
        U = flag;
        try
        {
            if (U)
            {
                T = (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append(File.separator).append("gif_play_cache").append(File.separator).append(e()).toString();
                if (!boz.d(T))
                {
                    U = false;
                }
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            U = false;
        }
    }

    public void a(byte abyte0[])
    {
        S = abyte0;
    }

    public int b()
    {
        return Q;
    }

    public bnw b(int i1)
    {
        bnw bnw1 = P;
        for (int j1 = 0; bnw1 != null; j1++)
        {
            if (j1 == i1)
            {
                return bnw1;
            }
            bnw1 = bnw1.c;
        }

        return null;
    }

    public Bitmap c()
    {
        return c(0);
    }

    public Bitmap c(int i1)
    {
        Object obj = b(i1);
        if (obj == null)
        {
            obj = null;
        } else
        {
            Bitmap bitmap = ((bnw) (obj)).a();
            obj = bitmap;
            if (bitmap == null)
            {
                Log.e("lb", (new StringBuilder()).append("frame is null index =").append(String.valueOf(i1)).toString());
                return bitmap;
            }
        }
        return ((Bitmap) (obj));
    }

    public bnw d()
    {
        if (!C)
        {
            C = true;
            return P;
        }
        if (B == null)
        {
            return null;
        }
        if (d != 0) goto _L2; else goto _L1
_L1:
        if (B.c != null)
        {
            B = B.c;
        }
_L4:
        return B;
_L2:
        B = B.c;
        if (B == null)
        {
            B = P;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void run()
    {
        if (c == null) goto _L2; else goto _L1
_L1:
        h();
_L4:
        if (U && z != null && !z.isRecycled())
        {
            z.recycle();
            z = null;
        }
        return;
_L2:
        if (S != null)
        {
            g();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
