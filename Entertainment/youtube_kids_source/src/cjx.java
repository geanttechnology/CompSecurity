// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class cjx
    implements ckk
{

    static final SparseArray a;
    private final ckc A = new ckc(this);
    private final ckl B;
    private final String C;
    private final ckv D;
    final bkn b;
    private final Context c;
    private final AtomicReference d = new AtomicReference();
    private final ckb e = new ckb(this);
    private final Handler f;
    private final cka g;
    private volatile boolean h;
    private volatile boolean i;
    private volatile boolean j;
    private volatile boolean k;
    private volatile boolean l;
    private volatile boolean m;
    private volatile boolean n;
    private volatile boolean o;
    private bwb p;
    private bwb q;
    private String r;
    private cke s;
    private boolean t;
    private boolean u;
    private boolean v;
    private final cjy w = new cjy(this);
    private int x;
    private int y;
    private int z;

    public cjx(Context context, bmi bmi1, bkn bkn1, ckv ckv1, String s1, cka cka1)
    {
        c = (Context)b.a(context);
        b = (bkn)b.a(bkn1);
        D = (ckv)b.a(ckv1);
        C = (String)b.a(s1);
        g = (cka)b.a(cka1);
        e.start();
        f = new Handler(context.getMainLooper());
        A.start();
        B = new ckw(new cjd((bmi)b.a(bmi1)));
    }

    private void a(bwb bwb1)
    {
        b.a(s);
        v = false;
        i = true;
        h = false;
        u = true;
        q = bwb1;
        x = 0;
        b(bwb1);
    }

    private void a(bwb bwb1, int i1)
    {
        boolean flag1 = true;
        b.a(s);
        v = false;
        boolean flag;
        if (h && bwb1.equals(q))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        h = flag;
        i = false;
        q = bwb1;
        x = i1;
        if (bwb1.a.b == 93)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        u = flag;
        b(bwb1);
    }

    private static void a(cjv cjv1, cke cke1)
    {
        b.a(cjv1);
        b.a(cke1);
        if (cke1.d() != null)
        {
            cjv1.a(cke1.d());
        } else
        if (cke1.j())
        {
            cjv1.a(cke1.i());
            return;
        }
    }

    static void a(cjx cjx1)
    {
        bmo.a();
        cjx1.j = false;
        cjx1.k = false;
        cjx1.a(false);
        cjv cjv1 = (cjv)cjx1.d.getAndSet(null);
        if (cjv1 != null)
        {
            if (!cjx1.m && !cjx1.n)
            {
                cjx1.B.a(4);
            }
            cjv1.d();
        }
    }

    static void a(cjx cjx1, int i1)
    {
        cjv cjv1 = (cjv)cjx1.d.get();
        if (cjv1 != null && cjx1.a())
        {
            try
            {
                cjx1.B.b(i1);
                cjv1.a(i1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (cjx cjx1)
            {
                bmo.b("Error calling mediaPlayer", cjx1);
            }
            return;
        } else
        {
            cjx1.B.b(i1);
            cjx1.a(cjx1.q, i1);
            cjx1.B.c(i1);
            return;
        }
    }

    static void a(cjx cjx1, bwb bwb1)
    {
        cjx1.b(bwb1);
    }

    static void a(cjx cjx1, bwb bwb1, int i1)
    {
        cjx1.a(bwb1, i1);
    }

    static void a(cjx cjx1, cjv cjv1, Uri uri)
    {
        cjx1.d.set(cjv1);
        if (cjv1 != null && uri != null)
        {
            try
            {
                if (!cjx1.m && !cjx1.n)
                {
                    cjx1.B.a(0);
                }
                a(cjv1, cjx1.s);
                HashMap hashmap = new HashMap();
                hashmap.put("x-disconnect-at-highwatermark", "1");
                hashmap.put("User-Agent", cjx1.C);
                cjv1.a(cjx1.c, uri, hashmap);
                cjv1.a();
                cjx1.a(true);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (cjv cjv1)
            {
                bmo.b("Media Player error preparing video", cjv1);
                cjx1.B.a(new cnd("android.fw.prepare", 0, cjv1));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (cjv cjv1)
            {
                bmo.b("Media Player error preparing video", cjv1);
                cjx1.B.a(new cnd("android.fw.ise", 0, cjv1));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (cjx cjx1)
            {
                bmo.b("Error calling mediaPlayer", cjx1);
            }
            return;
        } else
        {
            cjv1 = String.valueOf(cjv1);
            uri = String.valueOf(uri);
            bmo.c((new StringBuilder(String.valueOf(cjv1).length() + 43 + String.valueOf(uri).length())).append("Media Player null pointer preparing video ").append(cjv1).append(" ").append(uri).toString());
            cjx1.B.a(new cnd("android.fw.npe", 0, new NullPointerException()));
            return;
        }
    }

    private void a(boolean flag)
    {
        if (l != flag)
        {
            l = flag;
            ckl ckl1 = B;
            byte byte0;
            if (l)
            {
                byte0 = 5;
            } else
            {
                byte0 = 6;
            }
            ckl1.a(byte0);
        }
    }

    private boolean a()
    {
        return j && (u || h);
    }

    static boolean a(cjx cjx1, boolean flag)
    {
        cjx1.t = flag;
        return flag;
    }

    static int b(cjx cjx1, int i1)
    {
        cjx1.y = i1;
        return i1;
    }

    static bwb b(cjx cjx1, bwb bwb1)
    {
        cjx1.p = null;
        return null;
    }

    private void b(bwb bwb1)
    {
        bmo.a();
        e.a();
        y = (int)bwb1.b;
        s.g();
        if (!t)
        {
            p = bwb1;
            s.k();
            return;
        }
        try
        {
            Object obj = g;
            boolean flag = i;
            obj = ((cka) (obj)).a();
            ((cjv) (obj)).b(3);
            ((cjv) (obj)).a(w);
            B.a(new cib());
            ckb ckb1 = e;
            bwb1 = bwb1.a(r);
            ckb1.a.sendMessage(Message.obtain(ckb1.a, 1, ((Object) (new Object[] {
                obj, bwb1
            }))));
            b(true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (bwb bwb1)
        {
            bmo.b("Factory failed to create a MediaPlayer for the stream");
        }
        B.a(new cnd("android.fw.create", 0, bwb1));
    }

    static void b(cjx cjx1)
    {
        cjv cjv1;
        cjx1.v = false;
        cjv1 = (cjv)cjx1.d.get();
        if (cjv1 == null)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        bmo.a();
        if (!cjx1.i) goto _L2; else goto _L1
_L1:
        if (!cjx1.k && cjx1.j)
        {
            cjv1.b();
            if (cjx1.s != null)
            {
                cjx1.s.a(500);
            }
            cjx1.k = true;
        }
        if (!cjx1.n && cjx1.j && cjx1.h)
        {
            cjx1.B.a(2);
        }
_L4:
        cjx1.n = false;
        return;
_L2:
        if (cjx1.a())
        {
            cjv1.b();
            if (cjx1.s != null)
            {
                cjx1.s.a(500);
            }
            cjx1.k = true;
            if (!cjx1.n)
            {
                cjx1.B.a(2);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        cjx1;
        bmo.b("Error calling mediaPlayer", cjx1);
    }

    static void b(cjx cjx1, boolean flag)
    {
        cjx1.b(false);
    }

    private void b(boolean flag)
    {
        if (s != null)
        {
            bmo.d((new StringBuilder(16)).append("stayAwake: ").append(flag).toString());
            s.b(flag);
        }
    }

    static int c(cjx cjx1, int i1)
    {
        cjx1.z = i1;
        return i1;
    }

    static void c(cjx cjx1)
    {
        cjv cjv1;
        cjx1.A.b();
        cjv1 = (cjv)cjx1.d.get();
        if (cjv1 == null || !cjx1.a())
        {
            break MISSING_BLOCK_LABEL_67;
        }
        bmo.a();
        cjv1.c();
        cjx1.k = false;
        cjx1.B.a(3);
        cjx1.a(false);
_L1:
        return;
        cjx1;
        bmo.b("Error calling mediaPlayer", cjx1);
        return;
        if (!cjx1.v)
        {
            cjx1.v = true;
            cjx1.B.a(3);
            return;
        }
          goto _L1
    }

    static void c(cjx cjx1, bwb bwb1)
    {
        cjx1.a(bwb1);
    }

    static boolean c(cjx cjx1, boolean flag)
    {
        cjx1.j = true;
        return true;
    }

    static int d(cjx cjx1, int i1)
    {
        cjx1.x = 0;
        return 0;
    }

    static bwb d(cjx cjx1)
    {
        return cjx1.p;
    }

    static boolean d(cjx cjx1, boolean flag)
    {
        cjx1.h = true;
        return true;
    }

    static cke e(cjx cjx1)
    {
        return cjx1.s;
    }

    static boolean e(cjx cjx1, boolean flag)
    {
        cjx1.m = flag;
        return flag;
    }

    static Context f(cjx cjx1)
    {
        return cjx1.c;
    }

    static void f(cjx cjx1, boolean flag)
    {
        cjx1.a(flag);
    }

    static Handler g(cjx cjx1)
    {
        return cjx1.f;
    }

    static boolean g(cjx cjx1, boolean flag)
    {
        cjx1.o = false;
        return false;
    }

    static boolean h(cjx cjx1)
    {
        return cjx1.h;
    }

    static boolean h(cjx cjx1, boolean flag)
    {
        cjx1.k = false;
        return false;
    }

    static boolean i(cjx cjx1)
    {
        return cjx1.a();
    }

    static boolean i(cjx cjx1, boolean flag)
    {
        cjx1.n = flag;
        return flag;
    }

    static boolean j(cjx cjx1)
    {
        return cjx1.i;
    }

    static int k(cjx cjx1)
    {
        return cjx1.x;
    }

    static boolean l(cjx cjx1)
    {
        return cjx1.m;
    }

    static boolean m(cjx cjx1)
    {
        return cjx1.n;
    }

    static ckl n(cjx cjx1)
    {
        return cjx1.B;
    }

    static boolean o(cjx cjx1)
    {
        return cjx1.v;
    }

    static int p(cjx cjx1)
    {
        return cjx1.z;
    }

    static boolean q(cjx cjx1)
    {
        return cjx1.k;
    }

    static boolean r(cjx cjx1)
    {
        return cjx1.l;
    }

    static boolean s(cjx cjx1)
    {
        return cjx1.o;
    }

    static boolean t(cjx cjx1)
    {
        return cjx1.j;
    }

    static ckc u(cjx cjx1)
    {
        return cjx1.A;
    }

    static bwb v(cjx cjx1)
    {
        return cjx1.q;
    }

    static AtomicReference w(cjx cjx1)
    {
        return cjx1.d;
    }

    public final cku a(bww bww1, bwp bwp, boolean flag)
    {
        if (flag)
        {
            throw new ckm();
        } else
        {
            return D.a(bwp, bww1, bwd.l(), Collections.emptySet(), false, true, false, false);
        }
    }

    public final void a(float f1)
    {
        cjv cjv1 = (cjv)d.get();
        if (cjv1 != null)
        {
            cjv1.a(f1, f1);
        }
    }

    public final void a(Handler handler)
    {
        B.a(handler);
    }

    public final void a(bww bww1, int i1, String s1, bwp bwp)
    {
        b.a(bww1);
        b.a(bwp);
        r = (String)b.a(s1);
        bwb bwb1;
        try
        {
            s1 = a(bww1, bwp, false);
        }
        // Misplaced declaration of an exception variable
        catch (bww bww1)
        {
            B.a(new cnd("fmt.noneavailable", 0, bww1));
            return;
        }
        bwp = ((cku) (s1)).a[0];
        bwb1 = ((cku) (s1)).c;
        B.a(bwp, bwp, bwb1, ((cku) (s1)).d, ((cku) (s1)).e, 0);
        B.a();
        if (bww1.g)
        {
            a(((bwb) (bwp)));
            return;
        } else
        {
            a(((bwb) (bwp)), i1);
            return;
        }
    }

    public final void a(cke cke1)
    {
        b.a(cke1);
        s = cke1;
        cke1.a(w);
        t = cke1.j();
        cjv cjv1 = (cjv)d.get();
        if (cjv1 != null)
        {
            a(cjv1, cke1);
        }
        if (k)
        {
            cke1.a(500);
        }
        b(k);
    }

    public final void a(String s1, Uri uri)
    {
    }

    public final bwb b()
    {
        return q;
    }

    public final void b(int i1)
    {
        if (!i && x != i1)
        {
            o = true;
            x = i1;
            ckb ckb1 = e;
            i1 = Math.max(0, Math.min(i1, y));
            ckb1.a.sendMessage(Message.obtain(ckb1.a, 4, i1, 0));
        }
    }

    public final bwb c()
    {
        return q;
    }

    public final void d()
    {
        e.a.sendEmptyMessage(2);
        b(true);
    }

    public final void e()
    {
        e.a.sendEmptyMessage(3);
        b(false);
    }

    public final void f()
    {
        A.b();
        e.a();
        b(false);
    }

    public final void g()
    {
        A.b();
        e.b();
    }

    public final int h()
    {
        cjv cjv1 = (cjv)d.get();
        if (cjv1 != null && j)
        {
            x = cjv1.e();
        }
        return x;
    }

    public final int i()
    {
        return y;
    }

    public final int j()
    {
        return (int)(((float)z / 100F) * (float)y);
    }

    public final boolean k()
    {
        return l;
    }

    public final boolean l()
    {
        return d.get() != null && k;
    }

    public final void m()
    {
        if (s != null)
        {
            s.g();
        }
    }

    public final void n()
    {
        if (s != null)
        {
            b(false);
            s.g();
            cjv cjv1 = (cjv)d.get();
            if (cjv1 != null)
            {
                cjv1.a(null);
                cjv1.a(null);
            }
            t = false;
            s.a(null);
            g();
            s = null;
        }
    }

    static 
    {
        SparseArray sparsearray = new SparseArray();
        a = sparsearray;
        sparsearray.put(-1002, "net.dns");
        a.put(-1003, "net.connect");
        a.put(-1004, "net.timeout");
        a.put(-1005, "net.closed");
        a.put(-1007, "fmt.decode");
        a.put(-1010, "fmt.unplayable");
        a.put(0x80000000, "net.timeout");
    }
}
