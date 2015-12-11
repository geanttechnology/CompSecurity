// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class cmc
    implements apn
{

    private final aot a;
    private final art b;
    private final apr c;
    private final apt d;
    private final int e;
    private final int f;
    private final int g;
    private final HashMap h;
    private final HashMap i;
    private final app j[];
    private app k[];
    private final List l;
    private final atf m;
    private long n;
    private boolean o;
    private boolean p;
    private final boolean q;
    private int r;
    private boolean s;

    public transient cmc(art art, apr apr1, int i1, List list, atf atf1, boolean flag, boolean flag1, 
            int j1, boolean flag2, aqr aaqr[])
    {
        b = art;
        g = i1;
        r = j1;
        s = flag2;
        k = new app[aaqr.length];
        j = k;
        h = new HashMap();
        i = new HashMap();
        d = new apt();
        c = apr1;
        o = flag1;
        int k1 = 0;
        j1 = 0;
        for (i1 = 0; i1 < aaqr.length; i1++)
        {
            k[i1] = aaqr[i1].b;
            k1 = Math.max(k[i1].c, k1);
            j1 = Math.max(k[i1].d, j1);
            h.put(k[i1].a, aaqr[i1]);
        }

        e = k1;
        f = j1;
        Arrays.sort(k, new apq());
        a = new aot(aaqr[0].b.b, aaqr[0].c * 1000L);
        l = list;
        m = atf1;
        q = flag;
    }

    public transient cmc(art art, apr apr1, List list, atf atf1, boolean flag, boolean flag1, aqr aaqr[])
    {
        this(art, apr1, 1, list, atf1, flag, false, 10, false, aaqr);
    }

    static long a(apw apw1, aqp aqp1, int i1)
    {
        long l2 = apw1.a().d[i1];
        long l1 = l2;
        if (apw1.b())
        {
            apw1 = aqp1.a();
            l1 = ((aqo) (apw1)).a;
            l1 = l2 + (((aqo) (apw1)).b + l1);
        }
        return l1;
    }

    private apw a(aqp aqp1)
    {
        app app1 = aqp1.b;
        apw apw1 = (apw)i.get(app1.a);
        aqp1 = apw1;
        if (apw1 == null)
        {
            if (app1.b.startsWith("video/webm"))
            {
                aqp1 = new aqh();
            } else
            {
                aqp1 = new apz();
            }
            i.put(app1.a, aqp1);
        }
        return aqp1;
    }

    public final aot a()
    {
        return a;
    }

    public final void a(aon aon1)
    {
        if (!o && a.a.startsWith("video"))
        {
            int i1 = e;
            int j1 = f;
            aon1.i = i1;
            aon1.j = j1;
            if (aon1.l != null)
            {
                aon1.a(aon1.l);
            }
        }
    }

    public final void a(apb apb1, Exception exception)
    {
        int i1 = 0;
        if (((exception instanceof ash) || (exception instanceof asg) || (exception.getCause() instanceof asr)) && q && k.length >= 2 && apb1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        exception = new app[k.length - 1];
        int k1;
        for (int j1 = 0; i1 < k.length; j1 = k1)
        {
            k1 = j1;
            if (!k[i1].a.equals(apb1.a.a))
            {
                if (j1 >= k.length - 1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                exception[j1] = k[i1];
                k1 = j1 + 1;
            }
            i1++;
        }

        k = exception;
        n = m.a() + 60000L;
        d.c = null;
        return;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(List list, long l1, long l2, apc apc1)
    {
        Object obj1;
        if (n > 0L && m.a() >= n)
        {
            n = 0L;
            k = j;
        }
        d.a = list.size();
        if (d.c == null || !p)
        {
            c.a(list, l2, k, d);
        }
        obj1 = d.c;
        apc1.a = d.a;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        apc1.b = null;
_L13:
        return;
_L2:
        int j1 = 0;
_L5:
        Object obj;
        app app1;
        Object obj2;
        if (j1 >= k.length || k.length <= 1)
        {
            break MISSING_BLOCK_LABEL_1000;
        }
        app1 = k[j1];
        if (!s && ((app) (obj1)).a.equals(app1.a))
        {
            break MISSING_BLOCK_LABEL_1000;
        }
        obj = (aqr)h.get(app1.a);
        obj2 = a(((aqp) (obj))).a();
        if (obj2 == null) goto _L4; else goto _L3
_L3:
        int i1;
label0:
        {
            if (list.isEmpty())
            {
                int k1 = Arrays.binarySearch(((apx) (obj2)).f, l1);
                i1 = k1;
                if (k1 < 0)
                {
                    i1 = -k1 - 2;
                }
            } else
            {
                i1 = ((apv)list.get(apc1.a - 1)).h;
            }
            if (i1 != -1)
            {
                break label0;
            }
            j1++;
        }
          goto _L5
        int k2 = Math.min(r, ((apx) (obj2)).b - i1);
        long l3 = a(a(((aqp) (obj))), ((aqp) (obj)), i1);
        l2 = 0L;
        for (int i2 = i1; i2 <= (k2 + i1) - 1; i2++)
        {
            l2 += ((apx) (obj2)).c[i2];
        }

        obj = new arx(((aqr) (obj)).e, l3, l2, ((aqr) (obj)).b());
_L14:
        obj2 = l.iterator();
_L9:
        if (!((Iterator) (obj2)).hasNext()) goto _L7; else goto _L6
_L6:
        if (!((ass)((Iterator) (obj2)).next()).b(((arx) (obj)).f, ((arx) (obj)).d, ((arx) (obj)).e)) goto _L9; else goto _L8
_L8:
        i1 = 1;
_L15:
        if (i1 == 0) goto _L11; else goto _L10
_L10:
        obj = app1;
_L16:
        if (apc1.a == list.size() && apc1.b != null && apc1.b.a.a.equals(((app) (obj)).a)) goto _L13; else goto _L12
_L4:
        aqo aqo1 = ((aqp) (obj)).d.a(((aqr) (obj)).g);
        obj = new arx(aqo1.a(), aqo1.a, aqo1.b, ((aqr) (obj)).b());
          goto _L14
_L7:
        i1 = 0;
          goto _L15
_L11:
        j1++;
          goto _L5
_L12:
        obj = (aqr)h.get(((app) (obj)).a);
        if (a(((aqp) (obj))).c() != null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            list = b;
            i1 = d.b;
            obj1 = ((aqp) (obj)).d.a(((aqr) (obj)).g);
            list = new cmd(list, new arx(((aqo) (obj1)).a(), ((aqo) (obj1)).a, ((aqo) (obj1)).b, ((aqr) (obj)).b()), i1, (apw)i.get(((aqr) (obj)).b.a), ((aqr) (obj)));
            p = true;
            apc1.b = list;
            return;
        }
        if (list.isEmpty())
        {
            j1 = Arrays.binarySearch(a(((aqp) (obj))).a().f, l1);
            i1 = j1;
            if (j1 < 0)
            {
                i1 = -j1 - 2;
            }
        } else
        {
            i1 = ((apv)list.get(apc1.a - 1)).h;
        }
        if (i1 == -1)
        {
            apc1.b = null;
            return;
        }
        int j2 = d.b;
        list = a(((aqp) (obj))).a();
        int i3 = (Math.min(g, ((apx) (list)).b - i1) + i1) - 1;
        long l4;
        long l5;
        if (i3 == ((apx) (list)).b - 1)
        {
            j1 = -1;
        } else
        {
            j1 = i3 + 1;
        }
        l4 = ((apx) (list)).f[i1];
        if (j1 == -1)
        {
            l1 = ((apx) (list)).f[i3] + ((apx) (list)).e[i3];
        } else
        {
            l1 = ((apx) (list)).f[j1];
        }
        l5 = a(a(((aqp) (obj))), ((aqp) (obj)), i1);
        l2 = 0L;
        for (; i1 <= i3; i1++)
        {
            l2 += ((apx) (list)).c[i1];
        }

        list = new arx(((aqr) (obj)).e, l5, l2, ((aqr) (obj)).b());
        list = new apo(b, list, ((aqr) (obj)).b, j2, l4, l1, j1, a(((aqp) (obj))), false, 0L);
        p = false;
        apc1.b = list;
        return;
        obj = obj1;
          goto _L16
    }

    public final void b()
    {
        apr apr1 = c;
    }

    public final void c()
    {
        apr apr1 = c;
    }
}
