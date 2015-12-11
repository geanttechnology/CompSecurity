// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class evm extends eug
{

    private boolean A;
    private evp B;
    private boolean C;
    private evn D;
    private boolean E;
    private evq F;
    private boolean G;
    private int H;
    private boolean I;
    private ewa J;
    private boolean K;
    private evy L;
    private boolean M;
    private int N;
    private boolean O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private int T;
    private boolean U;
    private evs V;
    private boolean W;
    private evj X;
    private boolean Y;
    private evu Z;
    private boolean a;
    private boolean aa;
    private evr ab;
    private boolean ac;
    private evk ad;
    private boolean ae;
    private int af;
    private boolean ag;
    private String ah;
    private boolean ai;
    private String aj;
    private boolean ak;
    private String al;
    private int am;
    private long b;
    private boolean c;
    private int d;
    private boolean e;
    private String f;
    private boolean g;
    private evz h;
    private boolean i;
    private int j;
    private boolean k;
    private evx l;
    private boolean m;
    private evi n;
    private boolean o;
    private evt p;
    private boolean q;
    private evl r;
    private boolean s;
    private evg t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private boolean y;
    private evo z;

    public evm()
    {
        b = 0L;
        d = 0;
        f = "";
        h = null;
        j = 0;
        l = null;
        n = null;
        p = null;
        r = null;
        t = null;
        v = 1;
        x = 1;
        z = null;
        B = null;
        D = null;
        F = null;
        H = 1;
        J = null;
        L = null;
        N = 0;
        P = 0;
        R = false;
        T = 0;
        V = null;
        X = null;
        Z = null;
        ab = null;
        ad = null;
        af = 1;
        ah = "";
        aj = "";
        al = "";
        am = -1;
    }

    public final int a()
    {
        if (am < 0)
        {
            b();
        }
        return am;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                long l3 = eud1.d();
                a = true;
                b = l3;
                break;

            case 16: // '\020'
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;

            case 34: // '"'
                evz evz1 = new evz();
                eud1.a(evz1);
                g = true;
                h = evz1;
                break;

            case 40: // '('
                int k1 = eud1.f();
                i = true;
                j = k1;
                break;

            case 50: // '2'
                evx evx1 = new evx();
                eud1.a(evx1);
                k = true;
                l = evx1;
                break;

            case 58: // ':'
                evi evi1 = new evi();
                eud1.a(evi1);
                m = true;
                n = evi1;
                break;

            case 66: // 'B'
                evl evl1 = new evl();
                eud1.a(evl1);
                q = true;
                r = evl1;
                break;

            case 74: // 'J'
                evg evg1 = new evg();
                eud1.a(evg1);
                s = true;
                t = evg1;
                break;

            case 80: // 'P'
                int l1 = eud1.f();
                u = true;
                v = l1;
                break;

            case 88: // 'X'
                int i2 = eud1.f();
                w = true;
                x = i2;
                break;

            case 98: // 'b'
                evo evo1 = new evo();
                eud1.a(evo1);
                y = true;
                z = evo1;
                break;

            case 104: // 'h'
                int j2 = eud1.f();
                G = true;
                H = j2;
                break;

            case 114: // 'r'
                ewa ewa1 = new ewa();
                eud1.a(ewa1);
                I = true;
                J = ewa1;
                break;

            case 122: // 'z'
                evy evy1 = new evy();
                eud1.a(evy1);
                K = true;
                L = evy1;
                break;

            case 128: 
                int k2 = eud1.f();
                M = true;
                N = k2;
                break;

            case 136: 
                int l2 = eud1.f();
                O = true;
                P = l2;
                break;

            case 144: 
                boolean flag = eud1.h();
                Q = true;
                R = flag;
                break;

            case 152: 
                int i3 = eud1.f();
                S = true;
                T = i3;
                break;

            case 162: 
                evs evs1 = new evs();
                eud1.a(evs1);
                U = true;
                V = evs1;
                break;

            case 170: 
                evj evj1 = new evj();
                eud1.a(evj1);
                W = true;
                X = evj1;
                break;

            case 178: 
                evu evu1 = new evu();
                eud1.a(evu1);
                Y = true;
                Z = evu1;
                break;

            case 186: 
                evr evr1 = new evr();
                eud1.a(evr1);
                aa = true;
                ab = evr1;
                break;

            case 194: 
                evp evp1 = new evp();
                eud1.a(evp1);
                A = true;
                B = evp1;
                break;

            case 202: 
                evn evn1 = new evn();
                eud1.a(evn1);
                C = true;
                D = evn1;
                break;

            case 210: 
                evq evq1 = new evq();
                eud1.a(evq1);
                E = true;
                F = evq1;
                break;

            case 218: 
                evk evk1 = new evk();
                eud1.a(evk1);
                ac = true;
                ad = evk1;
                break;

            case 226: 
                evt evt1 = new evt();
                eud1.a(evt1);
                o = true;
                p = evt1;
                break;

            case 232: 
                int j3 = eud1.f();
                ae = true;
                af = j3;
                break;

            case 242: 
                String s2 = eud1.i();
                ag = true;
                ah = s2;
                break;

            case 250: 
                String s3 = eud1.i();
                ai = true;
                aj = s3;
                break;

            case 258: 
                String s4 = eud1.i();
                ak = true;
                al = s4;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (c)
        {
            eue1.a(2, d);
        }
        if (e)
        {
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.b(4, h);
        }
        if (i)
        {
            eue1.a(5, j);
        }
        if (k)
        {
            eue1.b(6, l);
        }
        if (m)
        {
            eue1.b(7, n);
        }
        if (q)
        {
            eue1.b(8, r);
        }
        if (s)
        {
            eue1.b(9, t);
        }
        if (u)
        {
            eue1.a(10, v);
        }
        if (w)
        {
            eue1.a(11, x);
        }
        if (y)
        {
            eue1.b(12, z);
        }
        if (G)
        {
            eue1.a(13, H);
        }
        if (I)
        {
            eue1.b(14, J);
        }
        if (K)
        {
            eue1.b(15, L);
        }
        if (M)
        {
            eue1.a(16, N);
        }
        if (O)
        {
            eue1.a(17, P);
        }
        if (Q)
        {
            eue1.a(18, R);
        }
        if (S)
        {
            eue1.a(19, T);
        }
        if (U)
        {
            eue1.b(20, V);
        }
        if (W)
        {
            eue1.b(21, X);
        }
        if (Y)
        {
            eue1.b(22, Z);
        }
        if (aa)
        {
            eue1.b(23, ab);
        }
        if (A)
        {
            eue1.b(24, B);
        }
        if (C)
        {
            eue1.b(25, D);
        }
        if (E)
        {
            eue1.b(26, F);
        }
        if (ac)
        {
            eue1.b(27, ad);
        }
        if (o)
        {
            eue1.b(28, p);
        }
        if (ae)
        {
            eue1.a(29, af);
        }
        if (ag)
        {
            eue1.a(30, ah);
        }
        if (ai)
        {
            eue1.a(31, aj);
        }
        if (ak)
        {
            eue1.a(32, al);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(7, n);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.d(8, r);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.d(9, t);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.d(10, v);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.d(11, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.d(12, z);
        }
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.d(13, H);
        }
        i1 = j1;
        if (I)
        {
            i1 = j1 + eue.d(14, J);
        }
        j1 = i1;
        if (K)
        {
            j1 = i1 + eue.d(15, L);
        }
        i1 = j1;
        if (M)
        {
            i1 = j1 + eue.d(16, N);
        }
        j1 = i1;
        if (O)
        {
            j1 = i1 + eue.d(17, P);
        }
        i1 = j1;
        if (Q)
        {
            i1 = j1 + eue.b(18, R);
        }
        j1 = i1;
        if (S)
        {
            j1 = i1 + eue.d(19, T);
        }
        i1 = j1;
        if (U)
        {
            i1 = j1 + eue.d(20, V);
        }
        j1 = i1;
        if (W)
        {
            j1 = i1 + eue.d(21, X);
        }
        i1 = j1;
        if (Y)
        {
            i1 = j1 + eue.d(22, Z);
        }
        j1 = i1;
        if (aa)
        {
            j1 = i1 + eue.d(23, ab);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.d(24, B);
        }
        j1 = i1;
        if (C)
        {
            j1 = i1 + eue.d(25, D);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(26, F);
        }
        j1 = i1;
        if (ac)
        {
            j1 = i1 + eue.d(27, ad);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(28, p);
        }
        j1 = i1;
        if (ae)
        {
            j1 = i1 + eue.d(29, af);
        }
        i1 = j1;
        if (ag)
        {
            i1 = j1 + eue.b(30, ah);
        }
        j1 = i1;
        if (ai)
        {
            j1 = i1 + eue.b(31, aj);
        }
        i1 = j1;
        if (ak)
        {
            i1 = j1 + eue.b(32, al);
        }
        am = i1;
        return i1;
    }
}
