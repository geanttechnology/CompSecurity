// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bvd
    implements cpu
{

    List A;
    List B;
    List C;
    public List D;
    List E;
    List F;
    List G;
    List H;
    List I;
    List J;
    List K;
    public List L;
    public List M;
    public List N;
    List O;
    public List P;
    public Uri Q;
    public Uri R;
    public long S;
    public int T;
    public boolean U;
    public boolean V;
    public boolean W;
    public dtl X;
    public bry Y;
    public long Z;
    public final int a;
    boolean aa;
    boolean ab;
    public Uri ac;
    public buz ad;
    public buz ae;
    List af;
    public long ag;
    public List ah;
    public bup ai;
    public String aj;
    public List ak;
    private dyz al;
    public List b;
    public String c;
    public String d;
    public String e;
    public String f;
    public byte g[];
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    Uri m;
    public String n;
    public String o;
    public bvc p;
    public String q;
    public int r;
    public bww s;
    public bst t;
    public bwp u;
    public bsv v;
    public Uri w;
    List x;
    List y;
    List z;

    public bvd()
    {
        this(2);
    }

    public bvd(int i1)
    {
        a = i1;
        U = true;
        p = bvc.d;
        T = -1;
        ab = false;
    }

    public final buz a()
    {
        if (s == null && al != null && (al.b.length > 0 || al.c.length > 0))
        {
            s = (new bwy(new bwz[0])).a(al, j, (long)r * 1000L, ag, false);
        }
        if (s != null && s.a != null)
        {
            Iterator iterator = s.a.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                bwb bwb1 = (bwb)iterator.next();
                if (buz.a(bwb1.b()) && "modules".equals(bwb1.b().getFragment()))
                {
                    W = true;
                }
            } while (true);
        }
        if (t == null)
        {
            t = new bst();
        }
        if (u == null)
        {
            u = new bwp();
        }
        return new buz(b, j, c, d, e, f, g, h, i, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, U, S, T, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ah, ai, ak);
    }

    public final bvd a(Uri uri)
    {
        if (b == null)
        {
            b = new ArrayList();
        }
        b.add(uri);
        return this;
    }

    public final bvd a(bvg bvg)
    {
        if (B == null)
        {
            B = new ArrayList();
        }
        B.add(bvg);
        return this;
    }

    public final bvd a(dla dla1)
    {
        if (al == null)
        {
            al = new dyz();
        }
        if (bwd.l().contains(Integer.valueOf(dla1.b)))
        {
            al.b = (dla[])a.a(al.b, new dla[] {
                dla1
            });
            return this;
        } else
        {
            al.c = (dla[])a.a(al.c, new dla[] {
                dla1
            });
            return this;
        }
    }

    public final bvd b(Uri uri)
    {
        if (x == null)
        {
            x = new ArrayList();
        }
        x.add(uri);
        return this;
    }

    public final Object b()
    {
        return a();
    }

    public final bvd c(Uri uri)
    {
        if (y == null)
        {
            y = new ArrayList();
        }
        y.add(uri);
        return this;
    }

    public final bvd d(Uri uri)
    {
        if (z == null)
        {
            z = new ArrayList();
        }
        z.add(uri);
        return this;
    }

    public final bvd e(Uri uri)
    {
        if (A == null)
        {
            A = new ArrayList();
        }
        A.add(uri);
        return this;
    }

    public final bvd f(Uri uri)
    {
        if (C == null)
        {
            C = new ArrayList();
        }
        C.add(uri);
        return this;
    }

    public final bvd g(Uri uri)
    {
        if (E == null)
        {
            E = new ArrayList();
        }
        E.add(uri);
        return this;
    }

    public final bvd h(Uri uri)
    {
        if (F == null)
        {
            F = new ArrayList();
        }
        F.add(uri);
        return this;
    }

    public final bvd i(Uri uri)
    {
        if (G == null)
        {
            G = new ArrayList();
        }
        G.add(uri);
        return this;
    }

    public final bvd j(Uri uri)
    {
        if (H == null)
        {
            H = new ArrayList();
        }
        H.add(uri);
        return this;
    }

    public final bvd k(Uri uri)
    {
        if (I == null)
        {
            I = new ArrayList();
        }
        I.add(uri);
        return this;
    }

    public final bvd l(Uri uri)
    {
        if (J == null)
        {
            J = new ArrayList();
        }
        J.add(uri);
        return this;
    }

    public final bvd m(Uri uri)
    {
        if (K == null)
        {
            K = new ArrayList();
        }
        K.add(uri);
        return this;
    }

    public final bvd n(Uri uri)
    {
        if (O == null)
        {
            O = new ArrayList();
        }
        O.add(uri);
        return this;
    }
}
