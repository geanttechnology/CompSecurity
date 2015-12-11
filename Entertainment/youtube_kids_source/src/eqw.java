// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eqw extends eug
{

    private boolean A;
    private efc B;
    private boolean C;
    private esl D;
    private boolean E;
    private efe F;
    private boolean G;
    private efj H;
    private int I;
    private boolean a;
    private int b;
    private boolean c;
    private eqx d;
    private boolean e;
    private eqv f;
    private boolean g;
    private equ h;
    private boolean i;
    private esy j;
    private boolean k;
    private erx l;
    private boolean m;
    private esa n;
    private boolean o;
    private eru p;
    private boolean q;
    private err r;
    private boolean s;
    private esr t;
    private boolean u;
    private esd v;
    private boolean w;
    private esq x;
    private boolean y;
    private esn z;

    public eqw()
    {
        b = 0;
        d = null;
        f = null;
        h = null;
        j = null;
        l = null;
        n = null;
        p = null;
        r = null;
        t = null;
        v = null;
        x = null;
        z = null;
        B = null;
        D = null;
        F = null;
        H = null;
        I = -1;
    }

    public final int a()
    {
        if (I < 0)
        {
            b();
        }
        return I;
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
                int j1 = eud1.f();
                a = true;
                b = j1;
                break;

            case 218335818: 
                eqx eqx1 = new eqx();
                eud1.a(eqx1);
                c = true;
                d = eqx1;
                break;

            case 233356442: 
                eqv eqv1 = new eqv();
                eud1.a(eqv1);
                e = true;
                f = eqv1;
                break;

            case 233461842: 
                equ equ1 = new equ();
                eud1.a(equ1);
                g = true;
                h = equ1;
                break;

            case 233860138: 
                esy esy1 = new esy();
                eud1.a(esy1);
                i = true;
                j = esy1;
                break;

            case 239048722: 
                erx erx1 = new erx();
                eud1.a(erx1);
                k = true;
                l = erx1;
                break;

            case 239325010: 
                esa esa1 = new esa();
                eud1.a(esa1);
                m = true;
                n = esa1;
                break;

            case 240271954: 
                eru eru1 = new eru();
                eud1.a(eru1);
                o = true;
                p = eru1;
                break;

            case 240752978: 
                err err1 = new err();
                eud1.a(err1);
                q = true;
                r = err1;
                break;

            case 241644514: 
                esr esr1 = new esr();
                eud1.a(esr1);
                s = true;
                t = esr1;
                break;

            case 267545042: 
                esd esd1 = new esd();
                eud1.a(esd1);
                u = true;
                v = esd1;
                break;

            case 272347874: 
                esq esq1 = new esq();
                eud1.a(esq1);
                w = true;
                x = esq1;
                break;

            case 282068714: 
                esn esn1 = new esn();
                eud1.a(esn1);
                y = true;
                z = esn1;
                break;

            case 305354922: 
                efc efc1 = new efc();
                eud1.a(efc1);
                A = true;
                B = efc1;
                break;

            case 314858394: 
                esl esl1 = new esl();
                eud1.a(esl1);
                C = true;
                D = esl1;
                break;

            case 345934042: 
                efe efe1 = new efe();
                eud1.a(efe1);
                E = true;
                F = efe1;
                break;

            case 375489818: 
                efj efj1 = new efj();
                eud1.a(efj1);
                G = true;
                H = efj1;
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
            eue1.b(0x1a07149, d);
        }
        if (e)
        {
            eue1.b(0x1bd1793, f);
        }
        if (g)
        {
            eue1.b(0x1bd4b0a, h);
        }
        if (i)
        {
            eue1.b(0x1be0d85, j);
        }
        if (k)
        {
            eue1.b(0x1c7f302, l);
        }
        if (m)
        {
            eue1.b(0x1c879ea, n);
        }
        if (o)
        {
            eue1.b(0x1ca484a, p);
        }
        if (q)
        {
            eue1.b(0x1cb332a, r);
        }
        if (s)
        {
            eue1.b(0x1cce67c, t);
        }
        if (u)
        {
            eue1.b(0x1fe4d3a, v);
        }
        if (w)
        {
            eue1.b(0x207765c, x);
        }
        if (y)
        {
            eue1.b(0x21a00dd, z);
        }
        if (A)
        {
            eue1.b(0x2466b15, B);
        }
        if (C)
        {
            eue1.b(0x2588b73, D);
        }
        if (E)
        {
            eue1.b(0x293d11b, F);
        }
        if (G)
        {
            eue1.b(0x2cc30a3, H);
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
            i1 = j1 + eue.d(0x1a07149, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(0x1bd1793, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(0x1bd4b0a, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(0x1be0d85, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(0x1c7f302, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(0x1c879ea, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(0x1ca484a, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.d(0x1cb332a, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.d(0x1cce67c, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.d(0x1fe4d3a, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.d(0x207765c, x);
        }
        j1 = i1;
        if (y)
        {
            j1 = i1 + eue.d(0x21a00dd, z);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.d(0x2466b15, B);
        }
        j1 = i1;
        if (C)
        {
            j1 = i1 + eue.d(0x2588b73, D);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(0x293d11b, F);
        }
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.d(0x2cc30a3, H);
        }
        I = j1;
        return j1;
    }
}
