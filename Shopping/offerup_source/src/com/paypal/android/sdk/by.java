// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            br, gm, az, ac, 
//            ck, bn, gn, bv, 
//            cj, gu, bk, bl, 
//            cc, ch, bm, gr, 
//            fq, hl, gs, gd, 
//            cb, gh, a, bz, 
//            ca, bt, ft, gg

public class by extends br
{

    private static final String a = com/paypal/android/sdk/by.getSimpleName();
    private static final gm b = gm.a("charset=utf-8");
    private final a c;
    private final String d;
    private final ck e;
    private final gn f;
    private final gn g;
    private final ac h;
    private final ScheduledExecutorService i = Executors.newSingleThreadScheduledExecutor();
    private final ConcurrentLinkedQueue j = new ConcurrentLinkedQueue();

    public by(a a1, String s, ac ac1, ck ck1, boolean flag, List list)
    {
        boolean flag1 = true;
        super();
        c = a1;
        d = s;
        h = ac1;
        e = ck1;
        boolean flag2 = az.d(s);
        if (flag2 && !flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag2)
        {
            flag1 = false;
        }
        f = bn.a(0x15f90, flag, flag1, ac1.b(), e.e());
        f.u().addAll(list);
        f.u().add(new bv());
        g = bn.a(0x15f90, false, false, ac1.b(), e.e());
        g.u().add(new bv());
    }

    static gn a(by by1)
    {
        return by1.g;
    }

    private static String a(String s, String s1)
    {
        String s2 = s;
        if (s1 != null)
        {
            s2 = s;
            if (!s.endsWith("/"))
            {
                s2 = (new StringBuilder()).append(s).append("/").toString();
            }
            s2 = (new StringBuilder()).append(s2).append(s1).toString();
        }
        return s2;
    }

    static void a(by by1, cj cj1, gu gu1, IOException ioexception)
    {
        (new StringBuilder()).append(cj1.n()).append(" failure.");
        if (gu1 != null)
        {
            Log.e("paypal.sdk", (new StringBuilder("request failure with http statusCode:")).append(gu1.c()).append(",exception:").append(gu1.e()).toString());
            a(cj1, gu1.c());
            if (cj1.q())
            {
                cj1.a(bk.a.toString(), (new StringBuilder()).append(gu1.c()).append(" http response received.  Response not parsable.").toString(), null);
            }
        } else
        if (ioexception != null)
        {
            cj1.a(new bl(bk.b, ioexception));
        } else
        {
            throw new RuntimeException("Both Response or Exception cannot be null");
        }
        Log.e("paypal.sdk", (new StringBuilder("request failed with server response:")).append(cj1.g()).toString());
        by1.e.a(cj1);
    }

    static void a(by by1, cj cj1, String s, gn gn1, ft ft)
    {
        a(cj1, s, gn1, ft);
    }

    private static void a(cj cj1, String s, gn gn1, ft ft)
    {
        switch (cc.a[cj1.h().b().ordinal()])
        {
        default:
            throw new RuntimeException((new StringBuilder()).append(cj1.h().b()).append(" not supported.").toString());

        case 1: // '\001'
            gn1.a((new gr()).a(a).a(a(s, cj1.f())).a(c(cj1)).a()).a(ft);
            return;

        case 2: // '\002'
            String s1 = cj1.f();
            gm gm2 = b;
            Object obj = hl.c;
            gm gm1 = gm2;
            if (gm2 != null)
            {
                java.nio.charset.Charset charset = gm2.a();
                obj = charset;
                gm1 = gm2;
                if (charset == null)
                {
                    obj = hl.c;
                    gm1 = gm.a((new StringBuilder()).append(gm2).append("; charset=utf-8").toString());
                }
            }
            obj = gs.a(gm1, s1.getBytes(((java.nio.charset.Charset) (obj))));
            gn1.a((new gr()).a(a).a(s).a("POST", ((gs) (obj))).a(c(cj1)).a()).a(ft);
            return;

        case 3: // '\003'
            gn1.a((new gr()).a(a).a(a(s, cj1.f())).a(c(cj1)).a("DELETE", gs.a(null, new byte[0])).a()).a(ft);
            return;
        }
    }

    private void a(gn gn1)
    {
        gn1.r().a().execute(new cb(gn1));
    }

    static String b()
    {
        return a;
    }

    static ConcurrentLinkedQueue b(by by1)
    {
        return by1.j;
    }

    static ck c(by by1)
    {
        return by1.e;
    }

    private static gg c(cj cj1)
    {
        gh gh1 = new gh();
        java.util.Map.Entry entry;
        for (cj1 = cj1.i().entrySet().iterator(); cj1.hasNext(); gh1.a((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)cj1.next();
        }

        return gh1.a();
    }

    static String d(by by1)
    {
        return by1.d;
    }

    static ac e(by by1)
    {
        return by1.h;
    }

    public final void a()
    {
        a(f);
        a(g);
    }

    public final boolean b(cj cj1)
    {
        String s;
        if (!c.a())
        {
            cj1.a(new bl(bk.b.toString()));
            return false;
        }
        cj.k();
        s = cj1.a(cj1.h());
label0:
        {
            if (cj1.a())
            {
                (new StringBuilder()).append(cj1.n()).append(" endpoint: ").append(s);
                (new StringBuilder()).append(cj1.n()).append(" request: ").append(cj1.f());
                j.offer(new bz(this, cj1, s));
                int k = (new Random()).nextInt(190) + 10;
                (new StringBuilder("Delaying tracking execution for ")).append(k).append(" seconds");
                i.schedule(new ca(this), k, TimeUnit.SECONDS);
                break label0;
            }
            try
            {
                (new StringBuilder()).append(cj1.n()).append(" endpoint: ").append(s);
                (new StringBuilder()).append(cj1.n()).append(" request: ").append(cj1.f());
                a(cj1, s, f, new bt(this, cj1, (byte)0));
            }
            catch (UnsupportedEncodingException unsupportedencodingexception)
            {
                Log.e(a, "encoding failure", unsupportedencodingexception);
                cj1.a(new bl(bk.d, unsupportedencodingexception));
                return false;
            }
            catch (IOException ioexception)
            {
                Log.e(a, "communication failure", ioexception);
                cj1.a(new bl(bk.b, ioexception));
                return false;
            }
        }
        return true;
    }

}
