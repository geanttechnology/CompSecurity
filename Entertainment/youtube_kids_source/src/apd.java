// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public final class apd
    implements aor, asj
{

    final int a;
    final apm b;
    private final anq c;
    private final apn d;
    private final apc e;
    private final LinkedList f;
    private final List g;
    private final int h;
    private final boolean i;
    private final Handler j;
    private final int k;
    private int l;
    private long m;
    private long n;
    private long o;
    private long p;
    private boolean q;
    private asi r;
    private IOException s;
    private boolean t;
    private int u;
    private long v;
    private aon w;
    private volatile app x;

    public apd(apn apn1, anq anq1, int i1, boolean flag)
    {
        this(apn1, anq1, 0x500000, false, null, null, 0);
    }

    private apd(apn apn1, anq anq1, int i1, boolean flag, Handler handler, apm apm, int j1)
    {
        this(apn1, anq1, i1, flag, null, null, 0, 3);
    }

    public apd(apn apn1, anq anq1, int i1, boolean flag, Handler handler, apm apm, int j1, 
            int k1)
    {
        d = apn1;
        c = anq1;
        h = i1;
        i = flag;
        j = handler;
        b = apm;
        a = j1;
        k = k1;
        e = new apc();
        f = new LinkedList();
        g = Collections.unmodifiableList(f);
        l = 0;
    }

    private void a(long l1, long l2, long l3)
    {
        if (j != null && b != null)
        {
            j.post(new apl(this, l1, l2, l3));
        }
    }

    private void a(apv apv1)
    {
        long l1 = 0L;
        if (f.isEmpty() || apv1 == f.getFirst())
        {
            return;
        }
        long l3 = ((apv)f.getFirst()).f;
        long l2 = 0L;
        apv apv2;
        for (; !f.isEmpty() && apv1 != f.getFirst(); apv2.a())
        {
            apv2 = (apv)f.removeFirst();
            l2 += ((apb) (apv2)).e.c();
            l1 = apv2.g;
        }

        a(l3, l1, l2);
    }

    private void a(String s1, int i1, boolean flag, long l1, long l2, 
            long l3)
    {
        if (j != null && b != null)
        {
            j.post(new ape(this, s1, i1, flag, l1, l2, l3));
        }
    }

    private void c(long l1)
    {
        o = l1;
        if (r.c)
        {
            r.a();
            return;
        } else
        {
            a(((apv) (null)));
            h();
            i();
            return;
        }
    }

    private boolean c(int i1)
    {
        long l1 = 0L;
        if (f.size() <= i1)
        {
            return false;
        }
        long l3 = ((apv)f.getLast()).g;
        long l2 = 0L;
        apv apv1;
        for (; f.size() > i1; apv1.a())
        {
            apv1 = (apv)f.removeLast();
            l2 += ((apb) (apv1)).e.c();
            l1 = apv1.f;
        }

        if (j != null && b != null)
        {
            j.post(new apj(this, l1, l3, l2));
        }
        return true;
    }

    private void g()
    {
        if (s != null && (t || u > k))
        {
            throw s;
        } else
        {
            return;
        }
    }

    private void h()
    {
        e.b = null;
        s = null;
        u = 0;
        t = false;
    }

    private void i()
    {
        if (!t) goto _L2; else goto _L1
_L1:
        c.a(this, m, -1L, false, true);
_L4:
        return;
_L2:
        boolean flag1;
        long l2 = SystemClock.elapsedRealtime();
        long l1 = j();
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (r.c || flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1 && (e.b == null && l1 != -1L || l2 - p > 2000L))
        {
            p = l2;
            e.a = g.size();
            d.a(g, o, m, e);
            boolean flag2 = c(e.a);
            if (e.b == null)
            {
                l1 = -1L;
            } else
            if (flag2)
            {
                l1 = j();
            }
        }
        flag1 = c.a(this, m, l1, flag1, false);
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (l2 - v < Math.min(((long)u - 1L) * 1000L, 5000L)) goto _L4; else goto _L3
_L3:
        s = null;
        apb apb1 = e.b;
        if (!(apb1 instanceof apv))
        {
            e.a = g.size();
            d.a(g, o, m, e);
            c(e.a);
            if (e.b == apb1)
            {
                r.a(apb1, this);
                return;
            } else
            {
                apb1.a();
                k();
                return;
            }
        }
        if (apb1 == f.getFirst())
        {
            r.a(apb1, this);
            return;
        }
        apv apv1 = (apv)f.removeLast();
        if (apb1 == apv1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        a.b(flag1);
        e.a = g.size();
        d.a(g, o, m, e);
        f.add(apv1);
        if (e.b == apb1)
        {
            r.a(apb1, this);
            return;
        } else
        {
            c(e.a);
            h();
            k();
            return;
        }
        if (r.c || !flag1) goto _L4; else goto _L5
_L5:
        k();
        return;
    }

    private long j()
    {
        if (l())
        {
            return o;
        }
        apv apv1 = (apv)f.getLast();
        if (apv1.h == -1)
        {
            return -1L;
        } else
        {
            return apv1.g;
        }
    }

    private void k()
    {
        apb apb1 = e.b;
        if (apb1 == null)
        {
            return;
        }
        aro aro = c.b();
        boolean flag;
        if (apb1.e == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        apb1.e = new asn(apb1.c, apb1.d, aro);
        if (apb1 instanceof apv)
        {
            apv apv1 = (apv)apb1;
            if (l())
            {
                apv1.a(o, false);
                o = -1L;
            }
            f.add(apv1);
            a(apv1.a.a, apv1.b, false, apv1.f, apv1.g, ((apb) (apv1)).e.g());
        } else
        {
            a(apb1.a.a, apb1.b, true, -1L, -1L, apb1.e.g());
        }
        r.a(apb1, this);
    }

    private boolean l()
    {
        return o != -1L;
    }

    public final int a(int i1, long l1, aoo aoo1, aoq aoq1, boolean flag)
    {
        apv apv1;
        do
        {
            boolean flag1;
            if (l == 2)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a.b(flag1);
            if (i1 == 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            a.b(flag1);
            if (q)
            {
                q = false;
                return -5;
            }
            if (flag)
            {
                return -2;
            }
            m = l1;
            if (l())
            {
                g();
                aoo1 = d;
                return -2;
            }
            apv1 = (apv)f.getFirst();
            if (!((apb) (apv1)).e.i())
            {
                break;
            }
            if (f.size() > 1)
            {
                apv1 = (apv)f.removeFirst();
                long l2 = ((apb) (apv1)).e.c();
                apv1.a();
                a(apv1.f, apv1.g, l2);
                ((apv)f.getFirst()).g();
                flag = false;
            } else
            if (apv1.l())
            {
                return -1;
            } else
            {
                aoo1 = d;
                return -2;
            }
        } while (true);
        if (x == null || !x.equals(apv1.a))
        {
            String s1 = apv1.a.a;
            i1 = apv1.b;
            l1 = apv1.f;
            if (j != null && b != null)
            {
                j.post(new apk(this, s1, i1, l1));
            }
            x = apv1.a;
        }
        if (!apv1.h())
        {
            if (s != null)
            {
                throw s;
            } else
            {
                return -2;
            }
        }
        aon aon1 = apv1.j();
        if (aon1 != null)
        {
            aon aon2 = w;
            if (aon1 == aon2)
            {
                flag = true;
            } else
            if (aon2 == null)
            {
                flag = false;
            } else
            {
                flag = aon1.a(aon2, true);
            }
            if (!flag)
            {
                d.a(aon1);
                aoo1.a = aon1;
                aoo1.b = apv1.k();
                w = aon1;
                return -4;
            }
        }
        if (apv1.a(aoq1))
        {
            if (i && aoq1.e < n)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            aoq1.f = flag;
            return -3;
        } else
        {
            g();
            return -2;
        }
    }

    public final aot a(int i1)
    {
        boolean flag1 = true;
        boolean flag;
        if (l != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        if (i1 == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a.b(flag);
        return d.a();
    }

    public final void a(int i1, long l1)
    {
        boolean flag1 = true;
        boolean flag;
        if (l == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        if (i1 == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        a.b(flag);
        l = 2;
        d.b();
        c.a(this, h);
        x = null;
        w = null;
        m = l1;
        n = l1;
        c(l1);
    }

    public final void a(IOException ioexception)
    {
        s = ioexception;
        u = u + 1;
        v = SystemClock.elapsedRealtime();
        if (j != null && b != null)
        {
            j.post(new aph(this, ioexception));
        }
        d.a(e.b, ioexception);
        i();
    }

    public final boolean a()
    {
        String s1;
        boolean flag;
        if (l == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        s1 = String.valueOf(d.a().a);
        if (s1.length() != 0)
        {
            s1 = "Loader:".concat(s1);
        } else
        {
            s1 = new String("Loader:");
        }
        r = new asi(s1);
        l = 1;
        return true;
    }

    public final boolean a(long l1)
    {
        boolean flag;
        boolean flag2;
        boolean flag1 = false;
        flag2 = true;
        apn apn1;
        if (l == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        m = l1;
        apn1 = d;
        i();
        flag = flag1;
        if (l()) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (f.isEmpty()) goto _L2; else goto _L3
_L3:
        if (!((apv)f.getFirst()).i()) goto _L5; else goto _L4
_L4:
        flag = flag2;
_L2:
        if (!flag)
        {
            g();
        }
        return flag;
_L5:
        if (f.size() > 1)
        {
            flag = flag2;
            if (((apv)f.get(1)).i())
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = false;
        if (true) goto _L2; else goto _L6
_L6:
    }

    public final int b()
    {
        boolean flag;
        if (l != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        return 1;
    }

    public final void b(int i1)
    {
        apn apn1;
        LinkedList linkedlist;
        boolean flag;
        if (l == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        if (i1 == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        q = false;
        l = 1;
        apn1 = d;
        linkedlist = f;
        apn1.c();
        c.a(this);
        if (r.c)
        {
            r.a();
            return;
        } else
        {
            a(((apv) (null)));
            h();
            c.a();
            return;
        }
        Exception exception;
        exception;
        c.a(this);
        if (r.c)
        {
            r.a();
        } else
        {
            a(((apv) (null)));
            h();
            c.a();
        }
        throw exception;
    }

    public final void b(long l1)
    {
        Iterator iterator;
        boolean flag2;
        flag2 = true;
        boolean flag;
        if (l == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        m = l1;
        n = l1;
        if (o == l1)
        {
            return;
        }
        iterator = f.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        apv apv2 = (apv)iterator.next();
        if (l1 < apv2.f) goto _L2; else goto _L3
_L3:
        apv apv1;
        apv1 = apv2;
        if (apv2.l())
        {
            break MISSING_BLOCK_LABEL_110;
        }
        if (l1 >= apv2.g) goto _L5; else goto _L4
_L4:
        apv1 = apv2;
_L7:
        if (apv1 == null)
        {
            c(l1);
            q = true;
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        apv1 = null;
        if (true) goto _L7; else goto _L6
_L6:
        boolean flag3 = q;
        boolean flag1;
        if (apv1 == f.getFirst())
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        q = apv1.a(l1, flag1) | flag3;
        a(apv1);
        i();
        return;
    }

    public final long c()
    {
        boolean flag;
        if (l == 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        if (l())
        {
            return o;
        }
        apv apv1 = (apv)f.getLast();
        apb apb1 = e.b;
        if (apb1 != null && apv1 == apb1)
        {
            long l1 = ((apb) (apv1)).e.g();
            if (l1 != -1L)
            {
                long l2 = apv1.f;
                long l3 = apv1.g;
                long l4 = apv1.f;
                return (((apb) (apv1)).e.c() * (l3 - l4)) / l1 + l2;
            } else
            {
                return apv1.f;
            }
        }
        if (apv1.l())
        {
            return -3L;
        } else
        {
            return apv1.g;
        }
    }

    public final void d()
    {
        boolean flag;
        if (l != 2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        if (r != null)
        {
            asi asi1 = r;
            if (asi1.c)
            {
                asi1.a();
            }
            asi1.a.shutdown();
            r = null;
        }
        l = 0;
    }

    public final void e()
    {
        apb apb1;
        apb1 = e.b;
        long l1 = apb1.e.c();
        if (j != null && b != null)
        {
            j.post(new apf(this, l1));
        }
        apb1.b();
        if (!(apb1 instanceof apv))
        {
            apb1.a();
        }
        if (!t)
        {
            h();
        }
        i();
        return;
        Object obj;
        obj;
        s = ((IOException) (obj));
        u = u + 1;
        v = SystemClock.elapsedRealtime();
        t = true;
        if (j != null && b != null)
        {
            j.post(new api(this, ((IOException) (obj))));
        }
        if (!(apb1 instanceof apv))
        {
            apb1.a();
        }
        if (!t)
        {
            h();
        }
        i();
        return;
        obj;
        if (!(apb1 instanceof apv))
        {
            apb1.a();
        }
        if (!t)
        {
            h();
        }
        i();
        throw obj;
    }

    public final void f()
    {
        apb apb1 = e.b;
        long l1 = apb1.e.c();
        if (j != null && b != null)
        {
            j.post(new apg(this, l1));
        }
        if (!(apb1 instanceof apv))
        {
            apb1.a();
        }
        h();
        if (l == 2)
        {
            c(o);
            return;
        } else
        {
            a(((apv) (null)));
            c.a();
            return;
        }
    }
}
