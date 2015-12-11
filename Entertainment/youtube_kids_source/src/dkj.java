// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class dkj extends eul
{

    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public djj F[];
    public boolean G;
    public boolean H;
    public int I;
    public boolean J;
    private boolean K;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public float i;
    public float j;
    public float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public float u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    public boolean z;

    public dkj()
    {
        a = false;
        b = false;
        c = 0;
        d = 0;
        e = 0;
        f = 0;
        g = 0;
        h = 0;
        i = 0.0F;
        j = 0.0F;
        k = 0.0F;
        l = 0;
        m = 0;
        n = 0;
        o = 0;
        p = 0;
        q = 0;
        r = false;
        s = false;
        t = 0;
        u = 0.0F;
        v = false;
        K = false;
        w = false;
        x = 0;
        y = false;
        z = false;
        A = false;
        B = 0;
        C = 0;
        D = false;
        E = 0;
        F = djj.a;
        G = false;
        H = false;
        I = 0;
        J = false;
    }

    public final int a()
    {
        int k1 = 0;
        int i1;
        int j1;
        if (a)
        {
            boolean flag = a;
            j1 = euj.b(1) + 1 + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (b)
        {
            boolean flag1 = b;
            i1 = j1 + (euj.b(2) + 1);
        }
        j1 = i1;
        if (c != 0)
        {
            j1 = i1 + euj.c(3, c);
        }
        i1 = j1;
        if (d != 0)
        {
            i1 = j1 + euj.c(4, d);
        }
        j1 = i1;
        if (e != 0)
        {
            j1 = i1 + euj.c(5, e);
        }
        i1 = j1;
        if (f != 0)
        {
            i1 = j1 + euj.c(6, f);
        }
        j1 = i1;
        if (g != 0)
        {
            j1 = i1 + euj.c(7, g);
        }
        i1 = j1;
        if (h != 0)
        {
            i1 = j1 + euj.c(8, h);
        }
        j1 = i1;
        if (i != 0.0F)
        {
            float f1 = i;
            j1 = i1 + (euj.b(9) + 4);
        }
        i1 = j1;
        if (j != 0.0F)
        {
            float f2 = j;
            i1 = j1 + (euj.b(10) + 4);
        }
        j1 = i1;
        if (k != 0.0F)
        {
            float f3 = k;
            j1 = i1 + (euj.b(11) + 4);
        }
        i1 = j1;
        if (l != 0)
        {
            i1 = j1 + euj.c(12, l);
        }
        j1 = i1;
        if (m != 0)
        {
            j1 = i1 + euj.c(13, m);
        }
        i1 = j1;
        if (n != 0)
        {
            i1 = j1 + euj.c(14, n);
        }
        j1 = i1;
        if (o != 0)
        {
            j1 = i1 + euj.c(15, o);
        }
        i1 = j1;
        if (p != 0)
        {
            i1 = j1 + euj.c(16, p);
        }
        j1 = i1;
        if (q != 0)
        {
            j1 = i1 + euj.c(17, q);
        }
        i1 = j1;
        if (r)
        {
            boolean flag2 = r;
            i1 = j1 + (euj.b(18) + 1);
        }
        j1 = i1;
        if (s)
        {
            boolean flag3 = s;
            j1 = i1 + (euj.b(19) + 1);
        }
        i1 = j1;
        if (t != 0)
        {
            i1 = j1 + euj.c(20, t);
        }
        j1 = i1;
        if (u != 0.0F)
        {
            float f4 = u;
            j1 = i1 + (euj.b(21) + 4);
        }
        i1 = j1;
        if (v)
        {
            boolean flag4 = v;
            i1 = j1 + (euj.b(22) + 1);
        }
        j1 = i1;
        if (K)
        {
            boolean flag5 = K;
            j1 = i1 + (euj.b(23) + 1);
        }
        i1 = j1;
        if (w)
        {
            boolean flag6 = w;
            i1 = j1 + (euj.b(24) + 1);
        }
        j1 = i1;
        if (x != 0)
        {
            j1 = i1 + euj.c(25, x);
        }
        i1 = j1;
        if (y)
        {
            boolean flag7 = y;
            i1 = j1 + (euj.b(26) + 1);
        }
        j1 = i1;
        if (z)
        {
            boolean flag8 = z;
            j1 = i1 + (euj.b(27) + 1);
        }
        i1 = j1;
        if (A)
        {
            boolean flag9 = A;
            i1 = j1 + (euj.b(28) + 1);
        }
        j1 = i1;
        if (B != 0)
        {
            j1 = i1 + euj.c(29, B);
        }
        i1 = j1;
        if (C != 0)
        {
            i1 = j1 + euj.c(30, C);
        }
        j1 = i1;
        if (D)
        {
            boolean flag10 = D;
            j1 = i1 + (euj.b(31) + 1);
        }
        i1 = j1;
        if (E != 0)
        {
            i1 = j1 + euj.c(32, E);
        }
        j1 = i1;
        if (F != null)
        {
            djj adjj[] = F;
            int l1 = adjj.length;
            do
            {
                j1 = i1;
                if (k1 >= l1)
                {
                    break;
                }
                djj djj1 = adjj[k1];
                j1 = i1;
                if (djj1 != null)
                {
                    j1 = i1 + euj.b(33, djj1);
                }
                k1++;
                i1 = j1;
            } while (true);
        }
        i1 = j1;
        if (G)
        {
            boolean flag11 = G;
            i1 = j1 + (euj.b(34) + 1);
        }
        j1 = i1;
        if (H)
        {
            boolean flag12 = H;
            j1 = i1 + (euj.b(35) + 1);
        }
        i1 = j1;
        if (I != 0)
        {
            i1 = j1 + euj.c(36, I);
        }
        j1 = i1;
        if (J)
        {
            boolean flag13 = J;
            j1 = i1 + (euj.b(37) + 1);
        }
        i1 = j1 + eup.a(O);
        P = i1;
        return i1;
    }

    public final eun a(eui eui1)
    {
        do
        {
            int i1 = eui1.a();
            switch (i1)
            {
            default:
                if (O == null)
                {
                    O = new ArrayList();
                }
                if (eup.a(O, eui1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                a = eui1.e();
                break;

            case 16: // '\020'
                b = eui1.e();
                break;

            case 24: // '\030'
                c = eui1.d();
                break;

            case 32: // ' '
                d = eui1.d();
                break;

            case 40: // '('
                e = eui1.d();
                break;

            case 48: // '0'
                f = eui1.d();
                break;

            case 56: // '8'
                g = eui1.d();
                break;

            case 64: // '@'
                h = eui1.d();
                break;

            case 77: // 'M'
                i = Float.intBitsToFloat(eui1.i());
                break;

            case 85: // 'U'
                j = Float.intBitsToFloat(eui1.i());
                break;

            case 93: // ']'
                k = Float.intBitsToFloat(eui1.i());
                break;

            case 96: // '`'
                l = eui1.d();
                break;

            case 104: // 'h'
                m = eui1.d();
                break;

            case 112: // 'p'
                n = eui1.d();
                break;

            case 120: // 'x'
                o = eui1.d();
                break;

            case 128: 
                p = eui1.d();
                break;

            case 136: 
                q = eui1.d();
                break;

            case 144: 
                r = eui1.e();
                break;

            case 152: 
                s = eui1.e();
                break;

            case 160: 
                t = eui1.d();
                break;

            case 173: 
                u = Float.intBitsToFloat(eui1.i());
                break;

            case 176: 
                v = eui1.e();
                break;

            case 184: 
                K = eui1.e();
                break;

            case 192: 
                w = eui1.e();
                break;

            case 200: 
                x = eui1.d();
                break;

            case 208: 
                y = eui1.e();
                break;

            case 216: 
                z = eui1.e();
                break;

            case 224: 
                A = eui1.e();
                break;

            case 232: 
                B = eui1.d();
                break;

            case 240: 
                C = eui1.d();
                break;

            case 248: 
                D = eui1.e();
                break;

            case 256: 
                E = eui1.d();
                break;

            case 266: 
                int k1 = eup.a(eui1, 266);
                djj adjj[];
                int j1;
                if (F == null)
                {
                    j1 = 0;
                } else
                {
                    j1 = F.length;
                }
                adjj = new djj[k1 + j1];
                if (F != null)
                {
                    System.arraycopy(F, 0, adjj, 0, j1);
                }
                for (F = adjj; j1 < F.length - 1; j1++)
                {
                    F[j1] = new djj();
                    eui1.a(F[j1]);
                    eui1.a();
                }

                F[j1] = new djj();
                eui1.a(F[j1]);
                break;

            case 272: 
                G = eui1.e();
                break;

            case 280: 
                H = eui1.e();
                break;

            case 288: 
                I = eui1.d();
                break;

            case 296: 
                J = eui1.e();
                break;
            }
        } while (true);
    }

    public final void a(euj euj1)
    {
        if (a)
        {
            euj1.a(1, a);
        }
        if (b)
        {
            euj1.a(2, b);
        }
        if (c != 0)
        {
            euj1.a(3, c);
        }
        if (d != 0)
        {
            euj1.a(4, d);
        }
        if (e != 0)
        {
            euj1.a(5, e);
        }
        if (f != 0)
        {
            euj1.a(6, f);
        }
        if (g != 0)
        {
            euj1.a(7, g);
        }
        if (h != 0)
        {
            euj1.a(8, h);
        }
        if (i != 0.0F)
        {
            euj1.a(9, i);
        }
        if (j != 0.0F)
        {
            euj1.a(10, j);
        }
        if (k != 0.0F)
        {
            euj1.a(11, k);
        }
        if (l != 0)
        {
            euj1.a(12, l);
        }
        if (m != 0)
        {
            euj1.a(13, m);
        }
        if (n != 0)
        {
            euj1.a(14, n);
        }
        if (o != 0)
        {
            euj1.a(15, o);
        }
        if (p != 0)
        {
            euj1.a(16, p);
        }
        if (q != 0)
        {
            euj1.a(17, q);
        }
        if (r)
        {
            euj1.a(18, r);
        }
        if (s)
        {
            euj1.a(19, s);
        }
        if (t != 0)
        {
            euj1.a(20, t);
        }
        if (u != 0.0F)
        {
            euj1.a(21, u);
        }
        if (v)
        {
            euj1.a(22, v);
        }
        if (K)
        {
            euj1.a(23, K);
        }
        if (w)
        {
            euj1.a(24, w);
        }
        if (x != 0)
        {
            euj1.a(25, x);
        }
        if (y)
        {
            euj1.a(26, y);
        }
        if (z)
        {
            euj1.a(27, z);
        }
        if (A)
        {
            euj1.a(28, A);
        }
        if (B != 0)
        {
            euj1.a(29, B);
        }
        if (C != 0)
        {
            euj1.a(30, C);
        }
        if (D)
        {
            euj1.a(31, D);
        }
        if (E != 0)
        {
            euj1.a(32, E);
        }
        if (F != null)
        {
            djj adjj[] = F;
            int j1 = adjj.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                djj djj1 = adjj[i1];
                if (djj1 != null)
                {
                    euj1.a(33, djj1);
                }
            }

        }
        if (G)
        {
            euj1.a(34, G);
        }
        if (H)
        {
            euj1.a(35, H);
        }
        if (I != 0)
        {
            euj1.a(36, I);
        }
        if (J)
        {
            euj1.a(37, J);
        }
        eup.a(O, euj1);
    }

    public final boolean equals(Object obj)
    {
        if (obj != this) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (!(obj instanceof dkj))
        {
            return false;
        }
        obj = (dkj)obj;
        if (a != ((dkj) (obj)).a || b != ((dkj) (obj)).b || c != ((dkj) (obj)).c || d != ((dkj) (obj)).d || e != ((dkj) (obj)).e || f != ((dkj) (obj)).f || g != ((dkj) (obj)).g || h != ((dkj) (obj)).h || i != ((dkj) (obj)).i || j != ((dkj) (obj)).j || k != ((dkj) (obj)).k || l != ((dkj) (obj)).l || m != ((dkj) (obj)).m || n != ((dkj) (obj)).n || o != ((dkj) (obj)).o || p != ((dkj) (obj)).p || q != ((dkj) (obj)).q || r != ((dkj) (obj)).r || s != ((dkj) (obj)).s || t != ((dkj) (obj)).t || u != ((dkj) (obj)).u || v != ((dkj) (obj)).v || K != ((dkj) (obj)).K || w != ((dkj) (obj)).w || x != ((dkj) (obj)).x || y != ((dkj) (obj)).y || z != ((dkj) (obj)).z || A != ((dkj) (obj)).A || B != ((dkj) (obj)).B || C != ((dkj) (obj)).C || D != ((dkj) (obj)).D || E != ((dkj) (obj)).E || !Arrays.equals(F, ((dkj) (obj)).F) || G != ((dkj) (obj)).G || H != ((dkj) (obj)).H || I != ((dkj) (obj)).I || J != ((dkj) (obj)).J)
        {
            break; /* Loop/switch isn't completed */
        }
        if (O != null) goto _L4; else goto _L3
_L3:
        if (((dkj) (obj)).O == null) goto _L1; else goto _L5
_L5:
        return false;
_L4:
        if (O.equals(((dkj) (obj)).O))
        {
            return true;
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public final int hashCode()
    {
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        boolean flag = false;
        boolean flag1 = true;
        int l3 = getClass().getName().hashCode();
        int j2;
        int k2;
        int l2;
        int i3;
        int j3;
        int k3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        int j5;
        int k5;
        int l5;
        int i6;
        int j6;
        int k6;
        int l6;
        int i7;
        int j7;
        int k7;
        int l7;
        int i8;
        int j8;
        int k8;
        int l8;
        if (a)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (b)
        {
            j1 = 1;
        } else
        {
            j1 = 2;
        }
        i4 = c;
        j4 = d;
        k4 = e;
        l4 = f;
        i5 = g;
        j5 = h;
        k5 = Float.floatToIntBits(i);
        l5 = Float.floatToIntBits(j);
        i6 = Float.floatToIntBits(k);
        j6 = l;
        k6 = m;
        l6 = n;
        i7 = o;
        j7 = p;
        k7 = q;
        if (r)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        if (s)
        {
            l1 = 1;
        } else
        {
            l1 = 2;
        }
        l7 = t;
        i8 = Float.floatToIntBits(u);
        if (v)
        {
            i2 = 1;
        } else
        {
            i2 = 2;
        }
        if (K)
        {
            j2 = 1;
        } else
        {
            j2 = 2;
        }
        if (w)
        {
            k2 = 1;
        } else
        {
            k2 = 2;
        }
        j8 = x;
        if (y)
        {
            l2 = 1;
        } else
        {
            l2 = 2;
        }
        if (z)
        {
            i3 = 1;
        } else
        {
            i3 = 2;
        }
        if (A)
        {
            j3 = 1;
        } else
        {
            j3 = 2;
        }
        k8 = B;
        l8 = C;
        if (D)
        {
            k3 = 1;
        } else
        {
            k3 = 2;
        }
        i1 = (k3 + (((j3 + (i3 + (l2 + ((k2 + (j2 + (i2 + (((l1 + (k1 + ((((((((((((((((j1 + (i1 + (l3 + 527) * 31) * 31) * 31 + i4) * 31 + j4) * 31 + k4) * 31 + l4) * 31 + i5) * 31 + j5) * 31 + k5) * 31 + l5) * 31 + i6) * 31 + j6) * 31 + k6) * 31 + l6) * 31 + i7) * 31 + j7) * 31 + k7) * 31) * 31) * 31 + l7) * 31 + i8) * 31) * 31) * 31) * 31 + j8) * 31) * 31) * 31) * 31 + k8) * 31 + l8) * 31) * 31 + E;
        if (F != null) goto _L2; else goto _L1
_L1:
        j1 = i1 * 31;
_L4:
        if (G)
        {
            i1 = 1;
        } else
        {
            i1 = 2;
        }
        if (H)
        {
            k1 = 1;
        } else
        {
            k1 = 2;
        }
        j2 = I;
        if (J)
        {
            l1 = ((flag1) ? 1 : 0);
        } else
        {
            l1 = 2;
        }
        if (O == null)
        {
            i2 = ((flag) ? 1 : 0);
        } else
        {
            i2 = O.hashCode();
        }
        return (((k1 + (i1 + j1 * 31) * 31) * 31 + j2) * 31 + l1) * 31 + i2;
_L2:
        k1 = 0;
_L5:
        j1 = i1;
        if (k1 >= F.length) goto _L4; else goto _L3
_L3:
        if (F[k1] == null)
        {
            j1 = 0;
        } else
        {
            j1 = F[k1].hashCode();
        }
        i1 = j1 + i1 * 31;
        k1++;
          goto _L5
    }
}
