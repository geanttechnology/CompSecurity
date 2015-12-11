// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.util.Log;
import android.util.TimingLogger;
import android.view.WindowManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.tapjoy.internal:
//            eu, el, er, et, 
//            fh, ep, ek, fg, 
//            ff

class fl
{

    public static String a = "2.5-16";
    private static final String t = com/tapjoy/internal/fl.getSimpleName();
    private volatile AtomicBoolean A;
    private volatile eu B;
    private el C;
    private String D;
    private String E;
    String b;
    String c;
    String d;
    String e;
    int f;
    int g;
    int h;
    int i;
    String j;
    String k;
    String l;
    String m;
    int n;
    String o;
    String p;
    Location q;
    ArrayList r;
    fg s;
    private String u;
    private String v;
    private String w;
    private Context x;
    private String y;
    private TimingLogger z;

    fl()
    {
        b = null;
        c = null;
        d = null;
        e = null;
        f = 0;
        g = 0;
        h = 0;
        i = 0;
        j = null;
        u = null;
        v = null;
        w = null;
        k = null;
        l = null;
        m = null;
        n = 0;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        x = null;
        y = null;
        z = null;
        A = null;
        B = eu.b;
        C = new el();
        D = null;
        E = null;
    }

    final void a()
    {
        e = null;
        f = 0;
        g = 0;
        m = null;
        q = null;
        s = null;
    }

    final void a(Context context)
    {
        x = context;
    }

    final void a(Location location)
    {
        q = location;
    }

    final void a(el el1)
    {
        C = el1;
    }

    final void a(eu eu1)
    {
        B = eu1;
    }

    final void a(fg fg1)
    {
        s = fg1;
    }

    final void a(String s1)
    {
        b = s1;
    }

    final void a(AtomicBoolean atomicboolean)
    {
        A = atomicboolean;
    }

    final boolean a(String s1, String s2)
    {
        String s3;
label0:
        {
            if (s2 != null)
            {
                s3 = s2;
                if (!s2.isEmpty())
                {
                    break label0;
                }
            }
            s3 = "TrustDefenderMobileSDK";
        }
        k = (new StringBuilder("http://")).append(s3).toString();
        if (s1 != null && s1.length() > 0)
        {
            j = s1;
            if (s1.compareToIgnoreCase(k) == 0)
            {
                j = (new StringBuilder()).append(s1).append("mobile").toString();
            }
        } else
        {
            j = (new StringBuilder("http://")).append(s3).append("/mobile").toString();
        }
        return true;
    }

    final String b()
    {
        return b;
    }

    final boolean b(String s1)
    {
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "h.online-metrix.net";
        }
        try
        {
            new URL((new StringBuilder("https://")).append(s2).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Log.e(t, (new StringBuilder("Invalid hostname ")).append(s2).toString(), s1);
            return false;
        }
        p = s2;
        return true;
    }

    final eu c()
    {
        String s1 = t;
        (new StringBuilder("getStatus returns: ")).append(B.toString());
        return B;
    }

    final boolean c(String s1)
    {
        if (s1 == null || s1.length() != 8)
        {
            Log.e(t, "Invalid org_id");
            return false;
        } else
        {
            o = s1;
            return true;
        }
    }

    final fg d()
    {
        return s;
    }

    final String e()
    {
        return p;
    }

    final String f()
    {
        return o;
    }

    final boolean g()
    {
        n = 3097;
        return true;
    }

    final String h()
    {
        return (new StringBuilder("https://")).append(p).append("/fp/mobile/conf").toString();
    }

    final er i()
    {
        er er1 = new er();
        er1.a("org_id", o);
        er1.a("session_id", b);
        er1.a("os", "android");
        er1.a("osVersion", android.os.Build.VERSION.RELEASE);
        if (y != null && !y.isEmpty())
        {
            er1.a("api_key", y);
        }
        return er1;
    }

    final void j()
    {
        Object obj1 = null;
        String s1 = t;
        if ((n & 8) != 0)
        {
            et.a a1 = new et.a();
            if (et.a(a1))
            {
                g = a1.b;
                f = a1.a;
            }
            if (z != null)
            {
                z.addSplit("get time zone");
            }
        }
        if (e == null || c == null || d == null)
        {
            Object obj;
            boolean flag;
            if ((n & 0x200) != 0 && fh.a())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (e == null)
            {
                obj = fh.b(x);
                e = fh.b(((String) (obj)), flag);
            } else
            {
                obj = null;
            }
            if (z != null)
            {
                z.addSplit("cookie");
            }
            if (d == null)
            {
                obj1 = fh.a(x);
                if (A != null && A.get())
                {
                    throw new InterruptedException();
                }
                d = fh.a(((String) (obj1)), flag);
            }
            if (z != null)
            {
                z.addSplit("LSC");
            }
            if (u == null)
            {
                u = fh.c(x);
                if (z != null)
                {
                    z.addSplit("imei");
                }
            }
            if (c == null)
            {
                String s2 = ((String) (obj));
                if (obj == null)
                {
                    s2 = fh.b(x);
                }
                obj = obj1;
                if (obj1 == null)
                {
                    obj = fh.a(x);
                }
                if (A != null && A.get())
                {
                    throw new InterruptedException();
                }
                obj1 = x;
                c = fh.a(s2, ((String) (obj)), u, flag);
            }
            if (z != null)
            {
                z.addSplit("Flash");
            }
        }
        if (A != null && A.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        if ((n & 0x10) != 0 && (i == 0 || h == 0))
        {
            obj = new ep(((WindowManager)x.getSystemService("window")).getDefaultDisplay());
            h = ((ep) (obj)).a();
            i = ((ep) (obj)).b();
        }
        if (z != null)
        {
            z.addSplit("get screen dimensions");
        }
        if (A != null && A.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        m = et.a();
        if (z != null)
        {
            z.addSplit("get device state");
        }
        if (A != null && A.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        if (l == null)
        {
            l = et.a(x, x);
        }
        if (z != null)
        {
            z.addSplit("get device fingerprint");
        }
        if ((n & 0x800) != 0 && E == null)
        {
            E = ek.a(x);
            if (z != null)
            {
                z.addSplit("get self hash");
            }
        }
        if (w == null || v == null)
        {
            obj = new StringBuilder();
            v = et.a(((StringBuilder) (obj)));
            if (v != null)
            {
                w = ((StringBuilder) (obj)).toString();
            }
            obj = t;
            (new StringBuilder("Got ")).append(w).append(" fonts gives: ").append(v);
        }
        if (z != null)
        {
            z.addSplit("Get Fontlist");
        }
    }

    final Map k()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("User-Agent", D);
        return hashmap;
    }

    final Map l()
    {
        HashMap hashmap = new HashMap();
        if (D != null && !D.isEmpty())
        {
            String s1 = t;
            (new StringBuilder("Setting User-Agent to ")).append(D);
            hashmap.put("User-Agent", D);
        }
        if (e == null)
        {
            hashmap.put("Cookie", "thx_guid=");
        } else
        {
            hashmap.put("Cookie", (new StringBuilder("thx_guid=")).append(e).toString());
        }
        hashmap.put("Referer", k);
        hashmap.put("Content-Type", "application/x-www-form-urlencoded");
        return hashmap;
    }

    final er m()
    {
        Object obj;
        String s3;
        er er1;
        int k1;
        obj = et.a(x, s.c);
        k1 = ((List) (obj)).size();
        s3 = ff.a(((List) (obj)), ";");
        if (z != null)
        {
            z.addSplit("Check URLs");
        }
        obj = "";
        if ((s.a & 0x100) != 0)
        {
            String s1 = et.a(s.d);
            obj = s1;
            if (z != null)
            {
                z.addSplit("get URLs");
                obj = s1;
            }
        }
        er1 = new er();
        er1.a();
        er1.a("w", s.b);
        er1.a("c", String.valueOf(f));
        er1.a("z", String.valueOf(g));
        er1.a("f", (new StringBuilder()).append(h).append("x").append(i).toString());
        er1.b("lh", j);
        er1.b("dr", k);
        if (!C.b.equals("0"))
        {
            er1.b("p", C.a);
            er1.b("pl", C.b);
            er1.b("ph", C.d);
        }
        er1.a("hh", ff.b((new StringBuilder()).append(o).append(b).toString()));
        if (C.f > 0)
        {
            er1.a("mt", C.h);
            er1.a("mn", String.valueOf(C.f));
        }
        er1.b("mdf", l);
        er1.b("mds", m);
        er1.b("imei", u);
        if (q != null)
        {
            er1.a("tdlat", String.valueOf(q.getLatitude()));
            er1.a("tdlon", String.valueOf(q.getLongitude()));
            er1.a("tdlacc", String.valueOf(q.getAccuracy()));
        }
        if (r == null || r.size() <= 0) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        int i1;
        iterator = r.iterator();
        i1 = 0;
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
        int j1;
        String s4 = (String)iterator.next();
        StringBuilder stringbuilder = new StringBuilder("aca");
        j1 = i1 + 1;
        er1.b(stringbuilder.append(i1).toString(), s4);
        if (j1 < 5) goto _L4; else goto _L2
_L2:
        er1.a("ah", E);
        er1.a("la", (new StringBuilder()).append(s.b).append(d).toString());
        er1.a("lq", D);
        String s2 = Integer.toString((new Random()).nextInt(10000) + 10000);
        er1.a("nu", s2.substring(s2.length() - 4));
        er1.a("fc", (new StringBuilder()).append(s.b).append(c).toString());
        er1.a("ftsn", w);
        er1.b("fts", v);
        er1.b("v", android.os.Build.VERSION.RELEASE);
        er1.b("o", Build.BRAND);
        er1.b("mf", Build.MODEL);
        er1.b("l", Locale.getDefault().getLanguage());
        er1.a("fg", c);
        er1.a("ls", d);
        if (s.c.size() == 0)
        {
            s2 = "";
        } else
        {
            s2 = String.valueOf(k1);
        }
        er1.a("gr", s2);
        er1.a("grr", s3);
        er1.a("at", "agent_mobile");
        er1.a("av", a);
        er1.a("ex3", ((String) (obj)));
        obj = new er();
        ((er) (obj)).a("org_id", o);
        ((er) (obj)).a("session_id", b);
        if (z != null)
        {
            z.addSplit("params without xor");
        }
        s2 = er1.b();
        if (z != null)
        {
            z.addSplit("url encoding");
        }
        ((er) (obj)).a("ja", ff.a(s2, b));
        ((er) (obj)).a("h", "0").a("m", "2");
        if (z != null)
        {
            z.addSplit("Params xor'd");
        }
        return ((er) (obj));
_L4:
        i1 = j1;
        if (true) goto _L6; else goto _L5
_L5:
    }

}
