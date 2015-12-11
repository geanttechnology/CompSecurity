// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ewd extends eug
{

    private float A;
    private boolean B;
    private float C;
    private boolean D;
    private float E;
    private List F;
    private List G;
    private List H;
    private List I;
    private List J;
    private List K;
    private List L;
    private List M;
    private List N;
    private List O;
    private List P;
    private List Q;
    private int R;
    private boolean a;
    private float b;
    private boolean c;
    private float d;
    private List e;
    private boolean f;
    private float g;
    private boolean h;
    private float i;
    private boolean j;
    private float k;
    private boolean l;
    private float m;
    private boolean n;
    private float o;
    private boolean p;
    private float q;
    private boolean r;
    private float s;
    private boolean t;
    private float u;
    private boolean v;
    private float w;
    private boolean x;
    private float y;
    private boolean z;

    public ewd()
    {
        b = 0.0F;
        d = 0.0F;
        e = Collections.emptyList();
        g = 0.0F;
        i = 0.0F;
        k = 0.0F;
        m = 0.0F;
        o = 0.0F;
        q = 0.0F;
        s = 0.0F;
        u = 0.0F;
        w = 0.0F;
        y = 0.0F;
        A = 0.0F;
        C = 0.0F;
        E = 0.0F;
        F = Collections.emptyList();
        G = Collections.emptyList();
        H = Collections.emptyList();
        I = Collections.emptyList();
        J = Collections.emptyList();
        K = Collections.emptyList();
        L = Collections.emptyList();
        M = Collections.emptyList();
        N = Collections.emptyList();
        O = Collections.emptyList();
        P = Collections.emptyList();
        Q = Collections.emptyList();
        R = -1;
    }

    public final int a()
    {
        if (R < 0)
        {
            b();
        }
        return R;
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
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(Float.valueOf(f3));
                break;

            case 37: // '%'
                float f4 = eud1.c();
                f = true;
                g = f4;
                break;

            case 69: // 'E'
                float f5 = eud1.c();
                h = true;
                i = f5;
                break;

            case 77: // 'M'
                float f6 = eud1.c();
                j = true;
                k = f6;
                break;

            case 85: // 'U'
                float f7 = eud1.c();
                l = true;
                m = f7;
                break;

            case 93: // ']'
                float f8 = eud1.c();
                n = true;
                o = f8;
                break;

            case 101: // 'e'
                float f9 = eud1.c();
                p = true;
                q = f9;
                break;

            case 109: // 'm'
                float f10 = eud1.c();
                r = true;
                s = f10;
                break;

            case 117: // 'u'
                float f11 = eud1.c();
                t = true;
                u = f11;
                break;

            case 125: // '}'
                float f12 = eud1.c();
                v = true;
                w = f12;
                break;

            case 133: 
                float f13 = eud1.c();
                x = true;
                y = f13;
                break;

            case 141: 
                float f14 = eud1.c();
                z = true;
                A = f14;
                break;

            case 149: 
                float f15 = eud1.c();
                B = true;
                C = f15;
                break;

            case 152: 
                boolean flag = eud1.h();
                if (L.isEmpty())
                {
                    L = new ArrayList();
                }
                L.add(Boolean.valueOf(flag));
                break;

            case 160: 
                boolean flag1 = eud1.h();
                if (M.isEmpty())
                {
                    M = new ArrayList();
                }
                M.add(Boolean.valueOf(flag1));
                break;

            case 168: 
                boolean flag2 = eud1.h();
                if (N.isEmpty())
                {
                    N = new ArrayList();
                }
                N.add(Boolean.valueOf(flag2));
                break;

            case 176: 
                boolean flag3 = eud1.h();
                if (O.isEmpty())
                {
                    O = new ArrayList();
                }
                O.add(Boolean.valueOf(flag3));
                break;

            case 189: 
                float f16 = eud1.c();
                D = true;
                E = f16;
                break;

            case 192: 
                boolean flag4 = eud1.h();
                if (P.isEmpty())
                {
                    P = new ArrayList();
                }
                P.add(Boolean.valueOf(flag4));
                break;

            case 200: 
                boolean flag5 = eud1.h();
                if (Q.isEmpty())
                {
                    Q = new ArrayList();
                }
                Q.add(Boolean.valueOf(flag5));
                break;

            case 208: 
                boolean flag6 = eud1.h();
                if (F.isEmpty())
                {
                    F = new ArrayList();
                }
                F.add(Boolean.valueOf(flag6));
                break;

            case 216: 
                boolean flag7 = eud1.h();
                if (G.isEmpty())
                {
                    G = new ArrayList();
                }
                G.add(Boolean.valueOf(flag7));
                break;

            case 224: 
                boolean flag8 = eud1.h();
                if (H.isEmpty())
                {
                    H = new ArrayList();
                }
                H.add(Boolean.valueOf(flag8));
                break;

            case 232: 
                boolean flag9 = eud1.h();
                if (I.isEmpty())
                {
                    I = new ArrayList();
                }
                I.add(Boolean.valueOf(flag9));
                break;

            case 240: 
                boolean flag10 = eud1.h();
                if (J.isEmpty())
                {
                    J = new ArrayList();
                }
                J.add(Boolean.valueOf(flag10));
                break;

            case 248: 
                boolean flag11 = eud1.h();
                if (K.isEmpty())
                {
                    K = new ArrayList();
                }
                K.add(Boolean.valueOf(flag11));
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.a(3, ((Float)iterator.next()).floatValue())) { }
        if (f)
        {
            eue1.a(4, g);
        }
        if (h)
        {
            eue1.a(8, i);
        }
        if (j)
        {
            eue1.a(9, k);
        }
        if (l)
        {
            eue1.a(10, m);
        }
        if (n)
        {
            eue1.a(11, o);
        }
        if (p)
        {
            eue1.a(12, q);
        }
        if (r)
        {
            eue1.a(13, s);
        }
        if (t)
        {
            eue1.a(14, u);
        }
        if (v)
        {
            eue1.a(15, w);
        }
        if (x)
        {
            eue1.a(16, y);
        }
        if (z)
        {
            eue1.a(17, A);
        }
        if (B)
        {
            eue1.a(18, C);
        }
        for (Iterator iterator1 = L.iterator(); iterator1.hasNext(); eue1.a(19, ((Boolean)iterator1.next()).booleanValue())) { }
        for (Iterator iterator2 = M.iterator(); iterator2.hasNext(); eue1.a(20, ((Boolean)iterator2.next()).booleanValue())) { }
        for (Iterator iterator3 = N.iterator(); iterator3.hasNext(); eue1.a(21, ((Boolean)iterator3.next()).booleanValue())) { }
        for (Iterator iterator4 = O.iterator(); iterator4.hasNext(); eue1.a(22, ((Boolean)iterator4.next()).booleanValue())) { }
        if (D)
        {
            eue1.a(23, E);
        }
        for (Iterator iterator5 = P.iterator(); iterator5.hasNext(); eue1.a(24, ((Boolean)iterator5.next()).booleanValue())) { }
        for (Iterator iterator6 = Q.iterator(); iterator6.hasNext(); eue1.a(25, ((Boolean)iterator6.next()).booleanValue())) { }
        for (Iterator iterator7 = F.iterator(); iterator7.hasNext(); eue1.a(26, ((Boolean)iterator7.next()).booleanValue())) { }
        for (Iterator iterator8 = G.iterator(); iterator8.hasNext(); eue1.a(27, ((Boolean)iterator8.next()).booleanValue())) { }
        for (Iterator iterator9 = H.iterator(); iterator9.hasNext(); eue1.a(28, ((Boolean)iterator9.next()).booleanValue())) { }
        for (Iterator iterator10 = I.iterator(); iterator10.hasNext(); eue1.a(29, ((Boolean)iterator10.next()).booleanValue())) { }
        for (Iterator iterator11 = J.iterator(); iterator11.hasNext(); eue1.a(30, ((Boolean)iterator11.next()).booleanValue())) { }
        for (Iterator iterator12 = K.iterator(); iterator12.hasNext(); eue1.a(31, ((Boolean)iterator12.next()).booleanValue())) { }
    }

    public final int b()
    {
        int i1 = 0;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        }
        int j1 = i1;
        if (c)
        {
            j1 = i1 + eue.b(2, d);
        }
        j1 = j1 + e.size() * 4 + e.size() * 1;
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.b(4, g);
        }
        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.b(8, i);
        }
        i1 = j1;
        if (j)
        {
            i1 = j1 + eue.b(9, k);
        }
        j1 = i1;
        if (l)
        {
            j1 = i1 + eue.b(10, m);
        }
        i1 = j1;
        if (n)
        {
            i1 = j1 + eue.b(11, o);
        }
        j1 = i1;
        if (p)
        {
            j1 = i1 + eue.b(12, q);
        }
        i1 = j1;
        if (r)
        {
            i1 = j1 + eue.b(13, s);
        }
        j1 = i1;
        if (t)
        {
            j1 = i1 + eue.b(14, u);
        }
        i1 = j1;
        if (v)
        {
            i1 = j1 + eue.b(15, w);
        }
        j1 = i1;
        if (x)
        {
            j1 = i1 + eue.b(16, y);
        }
        i1 = j1;
        if (z)
        {
            i1 = j1 + eue.b(17, A);
        }
        j1 = i1;
        if (B)
        {
            j1 = i1 + eue.b(18, C);
        }
        j1 = j1 + L.size() * 1 + L.size() * 2 + M.size() * 1 + M.size() * 2 + N.size() * 1 + N.size() * 2 + O.size() * 1 + O.size() * 2;
        i1 = j1;
        if (D)
        {
            i1 = j1 + eue.b(23, E);
        }
        i1 = i1 + P.size() * 1 + P.size() * 2 + Q.size() * 1 + Q.size() * 2 + F.size() * 1 + F.size() * 2 + G.size() * 1 + G.size() * 2 + H.size() * 1 + H.size() * 2 + I.size() * 1 + I.size() * 2 + J.size() * 1 + J.size() * 2 + K.size() * 1 + K.size() * 2;
        R = i1;
        return i1;
    }
}
