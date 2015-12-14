// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.Bitmap;
import com.crashlytics.android.Crashlytics;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class axz extends Thread
{

    private Bitmap A;
    private aya B;
    private boolean C;
    private byte D[];
    private int E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private int J;
    private short K[];
    private byte L[];
    private byte M[];
    private byte N[];
    private aya O;
    private int P;
    private axy Q;
    private byte R[];
    private boolean S;
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

    public axz(InputStream inputstream, axy axy1)
    {
        g = 1;
        B = null;
        C = false;
        D = new byte[256];
        E = 0;
        F = 0;
        G = 0;
        H = false;
        I = 0;
        Q = null;
        R = null;
        S = false;
        c = inputstream;
        Q = axy1;
    }

    public axz(byte abyte0[], axy axy1)
    {
        g = 1;
        B = null;
        C = false;
        D = new byte[256];
        E = 0;
        F = 0;
        G = 0;
        H = false;
        I = 0;
        Q = null;
        R = null;
        S = false;
        R = abyte0;
        Q = axy1;
    }

    private int[] c(int i1)
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
            Crashlytics.logException(exception);
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

    private void e()
    {
        int i3 = 0;
        int ai[] = new int[a * b];
        if (G > 0)
        {
            if (G == 3)
            {
                int i1 = P - 2;
                int i2;
                int k2;
                if (i1 > 0)
                {
                    A = a(i1 - 1);
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
                k3 = N[j2];
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
        z = Bitmap.createBitmap(ai, a, b, android.graphics.Bitmap.Config.ARGB_4444);
        return;
        j1 = l1;
        k1 = j2;
        if (true) goto _L10; else goto _L9
_L9:
        if (true) goto _L4; else goto _L11
_L11:
    }

    private int f()
    {
        c = new ByteArrayInputStream(R);
        R = null;
        return g();
    }

    private int g()
    {
        j();
        if (c != null)
        {
            o();
            if (!i())
            {
                m();
                if (P < 0)
                {
                    d = 1;
                    Q.parseOk(false, -1);
                } else
                {
                    d = -1;
                    Q.parseOk(true, -1);
                }
            }
            try
            {
                c.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                Crashlytics.logException(exception);
            }
        } else
        {
            d = 2;
            Q.parseOk(false, -1);
        }
        return d;
    }

    private void h()
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
        if (N == null || N.length < l5)
        {
            N = new byte[l5];
        }
        if (K == null)
        {
            K = new short[4096];
        }
        if (L == null)
        {
            L = new byte[4096];
        }
        if (M == null)
        {
            M = new byte[4097];
        }
        i6 = k();
        j6 = 1 << i6;
        l2 = j6 + 2;
        k1 = i6 + 1;
        l1 = (1 << k1) - 1;
        for (int i1 = 0; i1 < j6; i1++)
        {
            K[i1] = 0;
            L[i1] = (byte)i1;
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
        j3 = l();
        if (j3 > 0) goto _L7; else goto _L2
_L2:
        for (; l3 < l5; l3++)
        {
            N[l3] = 0;
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
            M[i2] = L[j3];
            i2++;
            j1 = j3;
            i3 = j3;
            j2 = l4;
            continue; /* Loop/switch isn't completed */
        }
        int k5;
        if (j3 == l2)
        {
            byte abyte0[] = M;
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
            M[i2] = L[j2];
            j2 = K[j2];
            i2++;
        }
        k5 = L[j2] & 0xff;
        if (l2 >= 4096) goto _L2; else goto _L9
_L9:
        M[i2] = (byte)k5;
        K[l2] = (short)j1;
        L[l2] = (byte)k5;
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
        N[l3] = M[k5];
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

    private boolean i()
    {
        return d != 0;
    }

    private void j()
    {
        d = 0;
        P = 0;
        O = null;
        h = null;
        i = null;
    }

    private int k()
    {
        int i1;
        try
        {
            i1 = c.read();
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
            d = 1;
            return 0;
        }
        return i1;
    }

    private int l()
    {
        int i1;
        int j1;
        E = k();
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
        Crashlytics.logException(exception);
          goto _L4
    }

    private void m()
    {
        boolean flag = false;
        do
        {
            if (flag || i())
            {
                break;
            }
            switch (k())
            {
            default:
                d = 1;
                continue;

            case 0: // '\0'
                break;

            case 44: // ','
                p();
                continue;

            case 33: // '!'
                switch (k())
                {
                default:
                    u();
                    break;

                case 249: 
                    n();
                    break;

                case 255: 
                    l();
                    String s1 = "";
                    for (int i1 = 0; i1 < 11; i1++)
                    {
                        s1 = (new StringBuilder()).append(s1).append((char)D[i1]).toString();
                    }

                    if (s1.equals("NETSCAPE2.0"))
                    {
                        r();
                    } else
                    {
                        u();
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

    private void n()
    {
        boolean flag = true;
        k();
        int i1 = k();
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
        I = s() * 10;
        J = k();
        k();
    }

    private void o()
    {
        String s1 = "";
        for (int i1 = 0; i1 < 6; i1++)
        {
            s1 = (new StringBuilder()).append(s1).append((char)k()).toString();
        }

        if (!s1.startsWith("GIF"))
        {
            d = 1;
        } else
        {
            q();
            if (e && !i())
            {
                h = c(f);
                l = h[k];
                return;
            }
        }
    }

    private void p()
    {
        int i1;
        i1 = 0;
        r = s();
        s = s();
        t = s();
        u = s();
        int j1 = k();
        boolean flag;
        if ((j1 & 0x80) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        o = flag;
        if ((j1 & 0x40) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        p = flag;
        q = 2 << (j1 & 7);
        if (!o) goto _L2; else goto _L1
_L1:
        i = c(q);
        j = i;
_L7:
        if (H)
        {
            i1 = j[J];
            j[J] = 0;
        }
        if (j == null)
        {
            d = 1;
        }
        if (!i()) goto _L4; else goto _L3
_L3:
        return;
_L2:
        j = h;
        if (k == J)
        {
            l = 0;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        h();
        u();
        if (i()) goto _L3; else goto _L5
_L5:
        P = P + 1;
        z = Bitmap.createBitmap(a, b, android.graphics.Bitmap.Config.ARGB_4444);
        e();
        if (O == null)
        {
            O = new aya(z, I);
            B = O;
        } else
        {
            aya aya1;
            for (aya1 = O; aya1.c != null; aya1 = aya1.c) { }
            aya1.c = new aya(z, I);
        }
        if (H)
        {
            j[J] = i1;
        }
        t();
        Q.parseOk(true, P);
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void q()
    {
        a = s();
        b = s();
        int i1 = k();
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
        k = k();
        n = k();
    }

    private void r()
    {
        do
        {
            l();
            if (D[0] == 1)
            {
                g = D[1] & 0xff | (D[2] & 0xff) << 8;
            }
        } while (E > 0 && !i());
    }

    private int s()
    {
        return k() | k() << 8;
    }

    private void t()
    {
        G = F;
        v = r;
        w = s;
        x = t;
        y = u;
        A = z;
        m = l;
        F = 0;
        H = false;
        I = 0;
        i = null;
    }

    private void u()
    {
        do
        {
            l();
        } while (E > 0 && !i());
    }

    public Bitmap a(int i1)
    {
        aya aya1 = b(i1);
        if (aya1 == null)
        {
            return null;
        } else
        {
            return aya1.a;
        }
    }

    public void a()
    {
        for (aya aya1 = O; aya1 != null; aya1 = O)
        {
            aya1.a = null;
            O = O.c;
        }

        if (c != null)
        {
            try
            {
                c.close();
            }
            catch (Exception exception)
            {
                Crashlytics.logException(exception);
            }
            c = null;
        }
        R = null;
    }

    public void a(boolean flag)
    {
        S = flag;
    }

    public int b()
    {
        return P;
    }

    public aya b(int i1)
    {
        aya aya1 = O;
        for (int j1 = 0; aya1 != null; j1++)
        {
            if (j1 == i1)
            {
                return aya1;
            }
            aya1 = aya1.c;
        }

        return null;
    }

    public Bitmap c()
    {
        return a(0);
    }

    public aya d()
    {
        if (!C)
        {
            C = true;
            return O;
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
        if (B == null && !S)
        {
            B = O;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void run()
    {
        if (c != null)
        {
            g();
        } else
        if (R != null)
        {
            f();
            return;
        }
    }
}
