// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class pv
    implements cwv
{

    private final LinkedList A;
    private final LinkedList B;
    private final LinkedList C;
    private final List D;
    private final cnf E;
    private final bme F;
    private final bkn G;
    private final bje H;
    private final cpz I;
    private final crh J;
    private csg K;
    private boolean L;
    public final Uri a;
    public final Uri b;
    public final Uri c;
    public final long d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final int j;
    public final ctn k;
    public final boolean l;
    public final boolean m;
    public final qa n;
    public long o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public volatile boolean u;
    public int v;
    public String w;
    private final bmi x;
    private final LinkedList y;
    private final LinkedList z;

    pv(cpz cpz1, bmi bmi1, Uri uri, Uri uri1, Uri uri2, String s1, String s2, 
            int i1, boolean flag, boolean flag1, String s3, String s4, String s5, long l1, ctn ctn1, String s6, csg csg1, bkn bkn1, bje bje1, cnf cnf1, 
            List list, bme bme1, crh crh1)
    {
        I = (cpz)b.a(cpz1);
        x = bmi1;
        a = (Uri)b.a(uri);
        b = (Uri)b.a(uri1);
        c = (Uri)b.a(uri2);
        g = s1;
        f = s2;
        j = i1;
        l = flag;
        m = flag1;
        e = s3;
        h = s4;
        d = l1;
        k = ctn1;
        w = s6;
        K = csg1;
        G = bkn1;
        H = bje1;
        E = cnf1;
        D = list;
        i = s5;
        y = new LinkedList();
        z = new LinkedList();
        A = new LinkedList();
        B = new LinkedList();
        C = new LinkedList();
        p = 0;
        F = bme1;
        J = (crh)b.a(crh1);
        if (csg1 != null)
        {
            cpz1 = csg1.a;
        } else
        {
            cpz1 = null;
        }
        n = new qa(bkn1, cpz1, bmi1, d, s4);
    }

    pv(cpz cpz1, bmi bmi1, py py1, csg csg1, bkn bkn1, bje bje1, cnf cnf1, 
            List list, bme bme1, crh crh1)
    {
        this(cpz1, bmi1, py1.a, py1.b, py1.c, py1.h, py1.g, py1.k, py1.m, py1.n, py1.f, py1.i, py1.j, py1.d, py1.t, py1.u, csg1, bkn1, bje1, cnf1, list, bme1, crh1);
        o = py1.e;
        p = py1.l;
        q = py1.o;
        r = py1.q;
        s = py1.p;
        u = py1.r;
        v = py1.s;
    }

    private static String a(LinkedList linkedlist)
    {
        String s1 = TextUtils.join(",", linkedlist);
        linkedlist.clear();
        return s1;
    }

    private void a(Uri uri)
    {
        if (r)
        {
            uri = h;
            bmo.c((new StringBuilder(String.valueOf(uri).length() + 65)).append("Final ping for playback ").append(uri).append(" has already been sent - Ignoring request").toString());
            return;
        }
        if (!u)
        {
            Object obj = String.valueOf(uri);
            bmo.e((new StringBuilder(String.valueOf(obj).length() + 8)).append("Pinging ").append(((String) (obj))).toString());
            obj = I;
            obj = cpz.a("vss", 0x323467f);
            ((cqd) (obj)).a(uri);
            obj.d = true;
            I.a(((cqd) (obj)), new pw(this));
            return;
        } else
        {
            uri = h;
            bmo.e((new StringBuilder(String.valueOf(uri).length() + 41)).append("Playback ").append(uri).append(" is throttled - Ignoring request").toString());
            return;
        }
    }

    private static String b(long l1)
    {
        return String.format(Locale.US, "%.1f", new Object[] {
            Double.valueOf((double)l1 / 1000D)
        });
    }

    private void b(bnf bnf1)
    {
        String s1 = b(x.b() - d);
        bnf1.a("cpn", h).a("rt", s1).a("ns", "yt").a("docid", g).a("ver", "2").a("len", f);
        E.a(bnf1);
        boolean flag;
        if (e != null)
        {
            bnf1.a("el", "adunit");
            bnf1.a("adformat", e);
        } else
        {
            bnf1.a("el", "detailpage");
        }
        if (F != null)
        {
            bnf1.a("lact", String.valueOf(F.b()));
        }
        if (v > 0)
        {
            bnf1.a("fmt", v);
        } else
        {
            bmo.c("Warning: Sending VSS ping without a video format parameter.");
        }
        if (!TextUtils.isEmpty(i))
        {
            bnf1.a("list", i);
        }
        if (l)
        {
            bnf1.a("autoplay", "1");
        }
        if (m)
        {
            bnf1.a("splay", "1");
        }
        if (l && !TextUtils.isEmpty(i) && e == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            bnf1.a("autonav", "1");
        }
    }

    public final void a()
    {
        d();
        if (s)
        {
            b(false);
        }
    }

    public final void a(long l1)
    {
        d();
        o = l1;
        c();
    }

    public void a(bnf bnf1)
    {
        b(bnf1);
        bnf1.a("cmt", b(o)).a("conn", G.g()).a("vis", String.valueOf(K.a.g));
        if (j > 0)
        {
            bnf1.a("delay", j);
        }
        if (k != ctn.a)
        {
            bnf1.a("feature", k.b);
        }
        if (!TextUtils.equals(w, "-"))
        {
            bnf1.a("cc", w);
        }
        Pair pair;
        for (Iterator iterator = D.iterator(); iterator.hasNext(); bnf1.a((String)pair.first, (String)pair.second))
        {
            pair = (Pair)iterator.next();
        }

        a(bnf1.a.build());
    }

    public void a(boolean flag)
    {
        t = flag;
        n.c = flag;
    }

    public final void b()
    {
        H.b(this);
        if (L)
        {
            bmo.b("VSS2 client released unexpectedly", new Exception());
            a();
        }
        crh crh1 = J;
        qa qa1 = n;
        b.a(qa1);
        if (crh1.a.get(qa1.a()) == qa1)
        {
            crh1.a.remove(qa1.a());
        }
    }

    public void b(boolean flag)
    {
        bnf bnf1;
        bnf1 = bnf.a(c);
        b(bnf1);
        String s1;
        if (t)
        {
            s1 = "playing";
        } else
        {
            s1 = "paused";
        }
        bnf1.a("state", s1);
        if (!z.isEmpty()) goto _L2; else goto _L1
_L1:
        bnf1.a("st", b(o)).a("et", b(o)).a("conn", G.g()).a("vis", String.valueOf(K.a.g));
        if (!TextUtils.equals("-", w))
        {
            bnf1.a("cc", w);
        }
_L7:
        if (flag)
        {
            bnf1.a("final", "1");
        }
        a(bnf1.a.build());
        r = r | flag;
        return;
_L2:
        Iterator iterator;
        bnf1.a("st", a(y), ",:").a("et", a(z), ",:").a("conn", a(A), ",:").a("vis", a(B), ",:");
        iterator = C.iterator();
_L6:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        if (TextUtils.equals((String)iterator.next(), "-")) goto _L6; else goto _L5
_L5:
        boolean flag1 = true;
_L8:
        if (flag1)
        {
            bnf1.a("cc", a(C), ",:");
        } else
        {
            C.clear();
        }
        if (true) goto _L7; else goto _L4
_L4:
        flag1 = false;
          goto _L8
    }

    public void c()
    {
        if (t && !L)
        {
            L = true;
            y.add(b(o));
            A.add(String.valueOf(G.g()));
            B.add(String.valueOf(K.a.g));
            C.add(w);
        }
    }

    public void d()
    {
        if (L)
        {
            L = false;
            z.add(b(o));
        }
    }

    public void e()
    {
        q = true;
        a(bnf.a(b));
    }

    public final void f()
    {
        H.a(this);
        J.a(n);
    }

    public final void handleConnectivityChangedEvent(bjv bjv)
    {
        d();
        c();
    }

    public final void handlePlayerGeometryEvent(csg csg1)
    {
        n.a = csg1.a;
        if (K == null || K.a != csg1.a)
        {
            d();
            K = csg1;
            c();
        }
    }

    public final void handleSubtitleTrackChangedEvent(csz csz1)
    {
        if (!TextUtils.equals(w, csz1.a()))
        {
            w = csz1.a();
            d();
            c();
        }
    }
}
