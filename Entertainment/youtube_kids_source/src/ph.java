// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ph
    implements cwv, Observer
{

    public final long a;
    public final pi b;
    public final pp c;
    public po d;
    public int e;
    public int f;
    public String g;
    public int h;
    public String i;
    public int j;
    public long k;
    public boolean l;
    private final bmi m;
    private final bje n;
    private final bkn o;
    private final bmh p;
    private final asa q;
    private final asa r;
    private final pi s;
    private final cna t;
    private final pl u;
    private final clv v;
    private final pk w;
    private final czk x;
    private long y;

    private ph(bje bje1, bmi bmi1, cpz cpz, bkn bkn, bmh bmh, asa asa1, asa asa2, 
            cna cna1, clv clv1, long l1, long l2, long l3, czk czk1, Uri uri, long l4, boolean flag)
    {
        e = -1;
        n = bje1;
        m = bmi1;
        o = bkn;
        p = bmh;
        q = asa1;
        r = asa2;
        b = new pi(this);
        s = new pi(this);
        t = cna1;
        u = new pl(l1, l2, l3);
        v = clv1;
        w = new pk();
        x = czk1;
        bje1 = new pj(this);
        c = new pp(cpz, uri, new pq[] {
            new pn(this), bje1, u, w
        });
        if (l4 < 0L)
        {
            a = bmi1.b();
            cpz = c;
            bkn = String.valueOf(po.d);
            cpz.a("vps", (new StringBuilder(String.valueOf(bkn).length() + 6)).append("0.000:").append(bkn).toString());
            d = po.d;
        } else
        {
            a = l4;
            d = po.e;
        }
        l = flag;
        y = bmi1.b() + 30000L;
        bmi1 = bje1.b();
        if (bmi1 != null)
        {
            ((pj) (bje1)).a.c.a("bat", bmi1);
        }
    }

    public ph(bje bje1, bmi bmi1, cpz cpz, bkn bkn, bmh bmh, asa asa1, asa asa2, 
            cna cna1, clv clv1, long l1, long l2, long l3, czk czk1, Uri uri, long l4, boolean flag, byte byte0)
    {
        this(bje1, bmi1, cpz, bkn, bmh, asa1, asa2, cna1, clv1, l1, l2, l3, czk1, uri, l4, flag);
    }

    public static int a(ph ph1, int i1)
    {
        ph1.f = i1;
        return i1;
    }

    static Uri a(Uri uri, String s1, String s2, boolean flag, String s3, cnf cnf1)
    {
        uri = bnf.a(uri);
        uri.a("event", "streamingstats").a("cpn", s1).a("ns", "yt").a("docid", s2);
        if (flag)
        {
            uri.a("live", "live");
        }
        if (!TextUtils.isEmpty(s3))
        {
            uri.a("adformat", s3);
        }
        cnf1.a(uri);
        return ((bnf) (uri)).a.build();
    }

    static bmh a(ph ph1)
    {
        return ph1.p;
    }

    public static String a(long l1)
    {
        return String.format(Locale.US, "%.3f", new Object[] {
            Float.valueOf((float)l1 / 1000F)
        });
    }

    static String a(ph ph1, long l1)
    {
        return a(l1);
    }

    public static String a(ph ph1, String s1)
    {
        ph1.g = s1;
        return s1;
    }

    static void a(ph ph1, boolean flag)
    {
        ph1.a(false);
    }

    public static int b(ph ph1, int i1)
    {
        ph1.h = i1;
        return i1;
    }

    public static String b(ph ph1, String s1)
    {
        ph1.i = s1;
        return s1;
    }

    static pp b(ph ph1)
    {
        return ph1.c;
    }

    static String c(ph ph1)
    {
        return ph1.e();
    }

    static int d(ph ph1)
    {
        return ph1.f;
    }

    static bkn e(ph ph1)
    {
        return ph1.o;
    }

    public final void a()
    {
        a(po.c);
        a(true);
        c.a();
        l = true;
    }

    public void a(po po1)
    {
        if (d.equals(po1))
        {
            return;
        } else
        {
            pp pp1 = c;
            String s1 = e();
            String s2 = String.valueOf(po1);
            pp1.a("vps", (new StringBuilder(String.valueOf(s1).length() + 1 + String.valueOf(s2).length())).append(s1).append(":").append(s2).toString());
            d = po1;
            return;
        }
    }

    public void a(boolean flag)
    {
        long l1 = m.b();
        if (flag || l1 > y)
        {
            String s1 = e();
            b.a("bwm", s1);
            s.a("obwm", s1);
            pl pl1 = u;
            pp pp2 = c;
            if (pl1.a > 0L)
            {
                long l2 = pl1.a;
                pp2.a("cache_bytes", (new StringBuilder(String.valueOf(s1).length() + 21)).append(s1).append(":").append(l2).toString());
                pl1.a = 0L;
            }
            if (j > 0)
            {
                pp pp1 = c;
                int i1 = j;
                pp1.a("df", (new StringBuilder(String.valueOf(s1).length() + 12)).append(s1).append(":").append(i1).toString());
                j = 0;
            }
            y = l1 + 30000L;
        }
    }

    public final void b()
    {
        x.deleteObserver(this);
        q.b(b);
        r.b(s);
        Object obj = t;
        Object obj1 = u;
        ((cna) (obj)).a.remove(obj1);
        obj = v;
        obj1 = w;
        ((clv) (obj)).a.remove(obj1);
        a(true);
        if (d != po.d)
        {
            bmo.b("QoE client released unexpectedly", new Exception());
            a(po.d);
        }
        c.a();
        n.b(this);
    }

    public final void c()
    {
        a(po.d);
        if (!l)
        {
            c.a();
        }
    }

    public final void d()
    {
        q.a(b);
        r.a(s);
        Object obj = t;
        Object obj1 = u;
        ((cna) (obj)).a.add(obj1);
        obj = v;
        obj1 = w;
        ((clv) (obj)).a.add(obj1);
        n.a(this);
        x.addObserver(this);
    }

    public String e()
    {
        return a(m.b() - a);
    }

    public final void handleUserReportedPlaybackEvent$4419627c(cm cm1)
    {
        pp pp1 = c;
        String s1 = e();
        String s2 = String.valueOf(cm1.i());
        cm1 = a(cm1.j());
        pp1.a("error", (new StringBuilder(String.valueOf(s1).length() + 2 + String.valueOf(s2).length() + String.valueOf(cm1).length())).append(s1).append(":").append(s2).append(":").append(cm1).toString());
        c.a();
    }

    public final void update(Observable observable, Object obj)
    {
        if (observable instanceof czk)
        {
            c.a("qoealert", "1");
        }
    }
}
