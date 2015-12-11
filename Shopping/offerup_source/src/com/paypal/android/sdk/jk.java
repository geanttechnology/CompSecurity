// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            ki, kt, hl, gp, 
//            kb, gu, id, kz, 
//            lh, ju, fy, ji, 
//            hr, gq, gg, ii, 
//            gi, gn, lk, hn, 
//            kd, gh, jz, kg, 
//            gv, gw

public final class jk
    implements ki
{

    private static final List a = hl.a(new kt[] {
        kt.a("connection"), kt.a("host"), kt.a("keep-alive"), kt.a("proxy-connection"), kt.a("transfer-encoding")
    });
    private static final List b = hl.a(new kt[] {
        kt.a("connection"), kt.a("host"), kt.a("keep-alive"), kt.a("proxy-connection"), kt.a("te"), kt.a("transfer-encoding"), kt.a("encoding"), kt.a("upgrade")
    });
    private final ju c;
    private final hr d;
    private id e;

    public jk(ju ju1, hr hr1)
    {
        c = ju1;
        d = hr1;
    }

    private static boolean a(gp gp1, kt kt1)
    {
        if (gp1 == gp.c)
        {
            return a.contains(kt1);
        }
        if (gp1 == gp.d)
        {
            return b.contains(kt1);
        } else
        {
            throw new AssertionError(gp1);
        }
    }

    public final gw a(gu gu1)
    {
        return new kb(gu1.g(), kz.a(e.f()));
    }

    public final lh a(gq gq1, long l)
    {
        return e.g();
    }

    public final void a()
    {
        e.g().close();
    }

    public final void a(gq gq1)
    {
        hr hr1;
        ArrayList arraylist;
        Object obj;
        String s;
        boolean flag;
        if (e != null)
        {
            return;
        }
        c.b();
        flag = c.c();
        obj = ji.a(c.f().k());
        hr1 = d;
        gp gp1 = d.a;
        gg gg1 = gq1.e();
        arraylist = new ArrayList(gg1.a() + 10);
        arraylist.add(new ii(ii.b, gq1.d()));
        arraylist.add(new ii(ii.c, ji.a(gq1.a())));
        s = hl.a(gq1.a());
        int i;
        int k;
        if (gp.c == gp1)
        {
            arraylist.add(new ii(ii.g, ((String) (obj))));
            arraylist.add(new ii(ii.f, s));
        } else
        if (gp.d == gp1)
        {
            arraylist.add(new ii(ii.e, s));
        } else
        {
            throw new AssertionError();
        }
        arraylist.add(new ii(ii.d, gq1.a().c()));
        gq1 = new LinkedHashSet();
        k = gg1.a();
        i = 0;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_513;
        }
        obj = kt.a(gg1.a(i).toLowerCase(Locale.US));
        s = gg1.b(i);
        if (!a(gp1, ((kt) (obj))) && !((kt) (obj)).equals(ii.b) && !((kt) (obj)).equals(ii.c) && !((kt) (obj)).equals(ii.d) && !((kt) (obj)).equals(ii.e) && !((kt) (obj)).equals(ii.f) && !((kt) (obj)).equals(ii.g))
        {
            if (!gq1.add(obj))
            {
                break; /* Loop/switch isn't completed */
            }
            arraylist.add(new ii(((kt) (obj)), s));
        }
_L6:
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_221;
_L1:
        int j = 0;
_L4:
        if (j < arraylist.size())
        {
label0:
            {
                if (!((ii)arraylist.get(j)).h.equals(obj))
                {
                    break label0;
                }
                arraylist.set(j, new ii(((kt) (obj)), (new StringBuilder(((ii)arraylist.get(j)).i.a())).append('\0').append(s).toString()));
            }
        }
        continue; /* Loop/switch isn't completed */
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        e = hr1.a(arraylist, flag);
        e.e().a(c.a.b(), TimeUnit.MILLISECONDS);
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void a(ju ju1)
    {
        if (e != null)
        {
            e.a(hn.h);
        }
    }

    public final void a(kd kd1)
    {
        kd1.a(e.g());
    }

    public final gv b()
    {
        List list = e.d();
        gp gp1 = d.a;
        Object obj = null;
        String s = "HTTP/1.1";
        gh gh1 = new gh();
        gh1.b(jz.c, gp1.toString());
        int i1 = list.size();
        int i = 0;
        do
        {
            if (i >= i1)
            {
                break;
            }
            kt kt1 = ((ii)list.get(i)).h;
            String s2 = ((ii)list.get(i)).i.a();
            int j = 0;
            while (j < s2.length()) 
            {
                int l = s2.indexOf('\0', j);
                int k = l;
                if (l == -1)
                {
                    k = s2.length();
                }
                String s1 = s2.substring(j, k);
                if (kt1.equals(ii.a))
                {
                    obj = s1;
                } else
                if (kt1.equals(ii.g))
                {
                    s = s1;
                } else
                if (!a(gp1, kt1))
                {
                    gh1.a(kt1.a(), s1);
                }
                j = k + 1;
            }
            i++;
        } while (true);
        if (obj == null)
        {
            throw new ProtocolException("Expected ':status' header not present");
        } else
        {
            obj = kg.a((new StringBuilder()).append(s).append(" ").append(((String) (obj))).toString());
            return (new gv()).a(gp1).a(((kg) (obj)).b).a(((kg) (obj)).c).a(gh1.a());
        }
    }

    public final void c()
    {
    }

    public final boolean d()
    {
        return true;
    }

}
