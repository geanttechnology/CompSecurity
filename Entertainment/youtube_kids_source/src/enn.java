// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class enn extends eug
{

    private boolean A;
    private ept B;
    private boolean C;
    private epg D;
    private boolean E;
    private epp F;
    private boolean G;
    private epc H;
    private boolean I;
    private eph J;
    private boolean K;
    private epe L;
    private boolean M;
    private epr N;
    private boolean O;
    private eqb P;
    private boolean Q;
    private eps R;
    private boolean S;
    private eoe T;
    private boolean U;
    private enw V;
    private boolean W;
    private eoh X;
    private boolean Y;
    private eof Z;
    private boolean a;
    private boolean aA;
    private eot aB;
    private boolean aC;
    private eom aD;
    private boolean aE;
    private epo aF;
    private boolean aG;
    private ens aH;
    private boolean aI;
    private epq aJ;
    private boolean aK;
    private epn aL;
    private boolean aM;
    private eok aN;
    private boolean aO;
    private eto aP;
    private int aQ;
    private boolean aa;
    private epv ab;
    private boolean ac;
    private eqa ad;
    private boolean ae;
    private env af;
    private boolean ag;
    private epw ah;
    private boolean ai;
    private epu aj;
    private boolean ak;
    private enn al;
    private boolean am;
    private eog an;
    private boolean ao;
    private enq ap;
    private boolean aq;
    private enx ar;
    private boolean as;
    private eoc at;
    private boolean au;
    private enr av;
    private boolean aw;
    private epy ax;
    private boolean ay;
    private epx az;
    private boolean b;
    private boolean c;
    private int d;
    private boolean e;
    private boolean f;
    private boolean g;
    private eno h;
    private boolean i;
    private eol j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean s;
    private epb t;
    private boolean u;
    private eos v;
    private boolean w;
    private eod x;
    private boolean y;
    private enp z;

    public enn()
    {
        b = false;
        d = 0;
        f = false;
        h = null;
        j = null;
        l = false;
        n = false;
        p = false;
        r = 0;
        t = null;
        v = null;
        x = null;
        z = null;
        B = null;
        D = null;
        F = null;
        H = null;
        J = null;
        L = null;
        N = null;
        P = null;
        R = null;
        T = null;
        V = null;
        X = null;
        Z = null;
        ab = null;
        ad = null;
        af = null;
        ah = null;
        aj = null;
        al = null;
        an = null;
        ap = null;
        ar = null;
        at = null;
        av = null;
        ax = null;
        az = null;
        aB = null;
        aD = null;
        aF = null;
        aH = null;
        aJ = null;
        aL = null;
        aN = null;
        aP = null;
        aQ = -1;
    }

    public final int a()
    {
        if (aQ < 0)
        {
            b();
        }
        return aQ;
    }

    public final enn a(epg epg1)
    {
        if (epg1 == null)
        {
            throw new NullPointerException();
        } else
        {
            C = true;
            D = epg1;
            return this;
        }
    }

    public final enn a(boolean flag)
    {
        a = true;
        b = flag;
        return this;
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
                a(eud1.h());
                break;

            case 24: // '\030'
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 34: // '"'
                eno eno1 = new eno();
                eud1.a(eno1);
                g = true;
                h = eno1;
                break;

            case 48: // '0'
                boolean flag = eud1.h();
                k = true;
                l = flag;
                break;

            case 56: // '8'
                boolean flag1 = eud1.h();
                m = true;
                n = flag1;
                break;

            case 64: // '@'
                boolean flag2 = eud1.h();
                o = true;
                p = flag2;
                break;

            case 72: // 'H'
                int k1 = eud1.f();
                q = true;
                r = k1;
                break;

            case 80: // 'P'
                boolean flag3 = eud1.h();
                e = true;
                f = flag3;
                break;

            case 90: // 'Z'
                eol eol1 = new eol();
                eud1.a(eol1);
                i = true;
                j = eol1;
                break;

            case 202523794: 
                epb epb1 = new epb();
                eud1.a(epb1);
                s = true;
                t = epb1;
                break;

            case 202525778: 
                eos eos1 = new eos();
                eud1.a(eos1);
                u = true;
                v = eos1;
                break;

            case 202633794: 
                eod eod1 = new eod();
                eud1.a(eod1);
                w = true;
                x = eod1;
                break;

            case 203290290: 
                enp enp1 = new enp();
                eud1.a(enp1);
                y = true;
                z = enp1;
                break;

            case 203395434: 
                ept ept1 = new ept();
                eud1.a(ept1);
                A = true;
                B = ept1;
                break;

            case 203466410: 
                epg epg1 = new epg();
                eud1.a(epg1);
                a(epg1);
                break;

            case 203466634: 
                epp epp1 = new epp();
                eud1.a(epp1);
                E = true;
                F = epp1;
                break;

            case 203469138: 
                epc epc1 = new epc();
                eud1.a(epc1);
                G = true;
                H = epc1;
                break;

            case 203472618: 
                eph eph1 = new eph();
                eud1.a(eph1);
                I = true;
                J = eph1;
                break;

            case 203506938: 
                epe epe1 = new epe();
                eud1.a(epe1);
                K = true;
                L = epe1;
                break;

            case 203528154: 
                epr epr1 = new epr();
                eud1.a(epr1);
                M = true;
                N = epr1;
                break;

            case 203617610: 
                eqb eqb1 = new eqb();
                eud1.a(eqb1);
                O = true;
                P = eqb1;
                break;

            case 203878930: 
                eps eps1 = new eps();
                eud1.a(eps1);
                Q = true;
                R = eps1;
                break;

            case 209502618: 
                eoe eoe1 = new eoe();
                eud1.a(eoe1);
                S = true;
                T = eoe1;
                break;

            case 210743810: 
                enw enw1 = new enw();
                eud1.a(enw1);
                U = true;
                V = enw1;
                break;

            case 226664378: 
                eoh eoh1 = new eoh();
                eud1.a(eoh1);
                W = true;
                X = eoh1;
                break;

            case 229207594: 
                eof eof1 = new eof();
                eud1.a(eof1);
                Y = true;
                Z = eof1;
                break;

            case 229674106: 
                epv epv1 = new epv();
                eud1.a(epv1);
                aa = true;
                ab = epv1;
                break;

            case 229739410: 
                eqa eqa1 = new eqa();
                eud1.a(eqa1);
                ac = true;
                ad = eqa1;
                break;

            case 231590122: 
                env env1 = new env();
                eud1.a(env1);
                ae = true;
                af = env1;
                break;

            case 273212650: 
                epw epw1 = new epw();
                eud1.a(epw1);
                ag = true;
                ah = epw1;
                break;

            case 288709786: 
                epu epu1 = new epu();
                eud1.a(epu1);
                ai = true;
                aj = epu1;
                break;

            case 300221818: 
                enn enn1 = new enn();
                eud1.a(enn1);
                ak = true;
                al = enn1;
                break;

            case 300385834: 
                eog eog1 = new eog();
                eud1.a(eog1);
                am = true;
                an = eog1;
                break;

            case 337113986: 
                enq enq1 = new enq();
                eud1.a(enq1);
                ao = true;
                ap = enq1;
                break;

            case 381187866: 
                enx enx1 = new enx();
                eud1.a(enx1);
                aq = true;
                ar = enx1;
                break;

            case 383455114: 
                eoc eoc1 = new eoc();
                eud1.a(eoc1);
                as = true;
                at = eoc1;
                break;

            case 385486466: 
                enr enr1 = new enr();
                eud1.a(enr1);
                au = true;
                av = enr1;
                break;

            case 393081074: 
                epy epy1 = new epy();
                eud1.a(epy1);
                aw = true;
                ax = epy1;
                break;

            case 396154650: 
                epx epx1 = new epx();
                eud1.a(epx1);
                ay = true;
                az = epx1;
                break;

            case 398855370: 
                eot eot1 = new eot();
                eud1.a(eot1);
                aA = true;
                aB = eot1;
                break;

            case 405148898: 
                eom eom1 = new eom();
                eud1.a(eom1);
                aC = true;
                aD = eom1;
                break;

            case 412973602: 
                epo epo1 = new epo();
                eud1.a(epo1);
                aE = true;
                aF = epo1;
                break;

            case 417346370: 
                ens ens1 = new ens();
                eud1.a(ens1);
                aG = true;
                aH = ens1;
                break;

            case 417505218: 
                epq epq1 = new epq();
                eud1.a(epq1);
                aI = true;
                aJ = epq1;
                break;

            case 420371810: 
                epn epn1 = new epn();
                eud1.a(epn1);
                aK = true;
                aL = epn1;
                break;

            case 427255098: 
                eok eok1 = new eok();
                eud1.a(eok1);
                aM = true;
                aN = eok1;
                break;

            case 452120058: 
                eto eto1 = new eto();
                eud1.a(eto1);
                aO = true;
                aP = eto1;
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
            eue1.a(3, d);
        }
        if (g)
        {
            eue1.b(4, h);
        }
        if (k)
        {
            eue1.a(6, l);
        }
        if (m)
        {
            eue1.a(7, n);
        }
        if (o)
        {
            eue1.a(8, p);
        }
        if (q)
        {
            eue1.a(9, r);
        }
        if (e)
        {
            eue1.a(10, f);
        }
        if (i)
        {
            eue1.b(11, j);
        }
        if (s)
        {
            eue1.b(0x1824892, t);
        }
        if (u)
        {
            eue1.b(0x182498a, v);
        }
        if (w)
        {
            eue1.b(0x1827e48, x);
        }
        if (y)
        {
            eue1.b(0x183bed6, z);
        }
        if (A)
        {
            eue1.b(0x183f22d, B);
        }
        if (C)
        {
            eue1.b(0x18414d5, D);
        }
        if (E)
        {
            eue1.b(0x18414f1, F);
        }
        if (G)
        {
            eue1.b(0x184162a, H);
        }
        if (I)
        {
            eue1.b(0x18417dd, J);
        }
        if (K)
        {
            eue1.b(0x184289f, L);
        }
        if (M)
        {
            eue1.b(0x18432fb, N);
        }
        if (O)
        {
            eue1.b(0x1845ea9, P);
        }
        if (Q)
        {
            eue1.b(0x184de42, R);
        }
        if (S)
        {
            eue1.b(0x18f9833, T);
        }
        if (U)
        {
            eue1.b(0x191f640, V);
        }
        if (W)
        {
            eue1.b(0x1b053f7, X);
        }
        if (Y)
        {
            eue1.b(0x1b52dc5, Z);
        }
        if (aa)
        {
            eue1.b(0x1b6118f, ab);
        }
        if (ac)
        {
            eue1.b(0x1b63172, ad);
        }
        if (ae)
        {
            eue1.b(0x1b9b91d, af);
        }
        if (ag)
        {
            eue1.b(0x2091c9d, ah);
        }
        if (ai)
        {
            eue1.b(0x226ab93, aj);
        }
        if (ak)
        {
            eue1.b(0x23ca0af, al);
        }
        if (am)
        {
            eue1.b(0x23cf0c5, an);
        }
        if (ao)
        {
            eue1.b(0x282fe70, ap);
        }
        if (aq)
        {
            eue1.b(0x2d70ee3, ar);
        }
        if (as)
        {
            eue1.b(0x2db61f1, at);
        }
        if (au)
        {
            eue1.b(0x2df41d0, av);
        }
        if (aw)
        {
            eue1.b(0x2edbe1e, ax);
        }
        if (ay)
        {
            eue1.b(0x2f39ae3, az);
        }
        if (aA)
        {
            eue1.b(0x2f8c199, aB);
        }
        if (aC)
        {
            eue1.b(0x304c29c, aD);
        }
        if (aE)
        {
            eue1.b(0x313af44, aF);
        }
        if (aG)
        {
            eue1.b(0x31c0668, aH);
        }
        if (aI)
        {
            eue1.b(0x31c53f8, aJ);
        }
        if (aK)
        {
            eue1.b(0x321cbac, aL);
        }
        if (aM)
        {
            eue1.b(0x32eeca7, aN);
        }
        if (aO)
        {
            eue1.b(0x35e59bf, aP);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(3, d);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.d(4, h);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(7, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.b(8, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.d(9, r);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(10, f);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(11, j);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.d(0x1824892, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.d(0x182498a, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.d(0x1827e48, x);
        }
        j1 = i1;
        if (y)
        {
            j1 = i1 + eue.d(0x183bed6, z);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.d(0x183f22d, B);
        }
        j1 = i1;
        if (C)
        {
            j1 = i1 + eue.d(0x18414d5, D);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(0x18414f1, F);
        }
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.d(0x184162a, H);
        }
        i1 = j1;
        if (I)
        {
            i1 = j1 + eue.d(0x18417dd, J);
        }
        j1 = i1;
        if (K)
        {
            j1 = i1 + eue.d(0x184289f, L);
        }
        i1 = j1;
        if (M)
        {
            i1 = j1 + eue.d(0x18432fb, N);
        }
        j1 = i1;
        if (O)
        {
            j1 = i1 + eue.d(0x1845ea9, P);
        }
        i1 = j1;
        if (Q)
        {
            i1 = j1 + eue.d(0x184de42, R);
        }
        j1 = i1;
        if (S)
        {
            j1 = i1 + eue.d(0x18f9833, T);
        }
        i1 = j1;
        if (U)
        {
            i1 = j1 + eue.d(0x191f640, V);
        }
        j1 = i1;
        if (W)
        {
            j1 = i1 + eue.d(0x1b053f7, X);
        }
        i1 = j1;
        if (Y)
        {
            i1 = j1 + eue.d(0x1b52dc5, Z);
        }
        j1 = i1;
        if (aa)
        {
            j1 = i1 + eue.d(0x1b6118f, ab);
        }
        i1 = j1;
        if (ac)
        {
            i1 = j1 + eue.d(0x1b63172, ad);
        }
        j1 = i1;
        if (ae)
        {
            j1 = i1 + eue.d(0x1b9b91d, af);
        }
        i1 = j1;
        if (ag)
        {
            i1 = j1 + eue.d(0x2091c9d, ah);
        }
        j1 = i1;
        if (ai)
        {
            j1 = i1 + eue.d(0x226ab93, aj);
        }
        i1 = j1;
        if (ak)
        {
            i1 = j1 + eue.d(0x23ca0af, al);
        }
        j1 = i1;
        if (am)
        {
            j1 = i1 + eue.d(0x23cf0c5, an);
        }
        i1 = j1;
        if (ao)
        {
            i1 = j1 + eue.d(0x282fe70, ap);
        }
        j1 = i1;
        if (aq)
        {
            j1 = i1 + eue.d(0x2d70ee3, ar);
        }
        i1 = j1;
        if (as)
        {
            i1 = j1 + eue.d(0x2db61f1, at);
        }
        j1 = i1;
        if (au)
        {
            j1 = i1 + eue.d(0x2df41d0, av);
        }
        i1 = j1;
        if (aw)
        {
            i1 = j1 + eue.d(0x2edbe1e, ax);
        }
        j1 = i1;
        if (ay)
        {
            j1 = i1 + eue.d(0x2f39ae3, az);
        }
        i1 = j1;
        if (aA)
        {
            i1 = j1 + eue.d(0x2f8c199, aB);
        }
        j1 = i1;
        if (aC)
        {
            j1 = i1 + eue.d(0x304c29c, aD);
        }
        i1 = j1;
        if (aE)
        {
            i1 = j1 + eue.d(0x313af44, aF);
        }
        j1 = i1;
        if (aG)
        {
            j1 = i1 + eue.d(0x31c0668, aH);
        }
        i1 = j1;
        if (aI)
        {
            i1 = j1 + eue.d(0x31c53f8, aJ);
        }
        j1 = i1;
        if (aK)
        {
            j1 = i1 + eue.d(0x321cbac, aL);
        }
        i1 = j1;
        if (aM)
        {
            i1 = j1 + eue.d(0x32eeca7, aN);
        }
        j1 = i1;
        if (aO)
        {
            j1 = i1 + eue.d(0x35e59bf, aP);
        }
        aQ = j1;
        return j1;
    }
}
