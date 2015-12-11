// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eux extends eug
{

    private int A;
    private boolean a;
    private float b;
    private boolean c;
    private float d;
    private boolean e;
    private float f;
    private boolean g;
    private float h;
    private boolean i;
    private float j;
    private boolean k;
    private float l;
    private boolean m;
    private float n;
    private boolean o;
    private float p;
    private boolean q;
    private float r;
    private boolean s;
    private float t;
    private boolean u;
    private float v;
    private boolean w;
    private float x;
    private boolean y;
    private float z;

    public eux()
    {
        b = 0.0F;
        d = 0.0F;
        f = 0.0F;
        h = 0.0F;
        j = 0.0F;
        l = 0.0F;
        n = 0.0F;
        p = 0.0F;
        r = 0.0F;
        t = 0.0F;
        v = 0.0F;
        x = 0.0F;
        z = 0.0F;
        A = -1;
    }

    public final int a()
    {
        if (A < 0)
        {
            b();
        }
        return A;
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

            case 13: // '\r'
                float f1 = eud1.c();
                a = true;
                b = f1;
                break;

            case 21: // '\025'
                float f2 = eud1.c();
                c = true;
                d = f2;
                break;

            case 29: // '\035'
                float f3 = eud1.c();
                e = true;
                f = f3;
                break;

            case 37: // '%'
                float f4 = eud1.c();
                g = true;
                h = f4;
                break;

            case 45: // '-'
                float f5 = eud1.c();
                i = true;
                j = f5;
                break;

            case 53: // '5'
                float f6 = eud1.c();
                k = true;
                l = f6;
                break;

            case 61: // '='
                float f7 = eud1.c();
                m = true;
                n = f7;
                break;

            case 69: // 'E'
                float f8 = eud1.c();
                o = true;
                p = f8;
                break;

            case 77: // 'M'
                float f9 = eud1.c();
                q = true;
                r = f9;
                break;

            case 85: // 'U'
                float f10 = eud1.c();
                s = true;
                t = f10;
                break;

            case 93: // ']'
                float f11 = eud1.c();
                u = true;
                v = f11;
                break;

            case 101: // 'e'
                float f12 = eud1.c();
                w = true;
                x = f12;
                break;

            case 109: // 'm'
                float f13 = eud1.c();
                y = true;
                z = f13;
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
            eue1.a(4, h);
        }
        if (i)
        {
            eue1.a(5, j);
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
        if (s)
        {
            eue1.a(10, t);
        }
        if (u)
        {
            eue1.a(11, v);
        }
        if (w)
        {
            eue1.a(12, x);
        }
        if (y)
        {
            eue1.a(13, z);
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
            i1 = j1 + eue.b(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(5, j);
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
            j1 = i1 + eue.b(9, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(10, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.b(11, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.b(12, x);
        }
        j1 = i1;
        if (y)
        {
            j1 = i1 + eue.b(13, z);
        }
        A = j1;
        return j1;
    }
}
