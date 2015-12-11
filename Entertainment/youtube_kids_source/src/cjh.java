// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public final class cjh
    implements ann, ckk, com.google.android.libraries.youtube.media.player.drm.WidevineHelper.Listener
{

    private static final cjk b = new cjk();
    private static final cjp c = new cjp();
    private aou A;
    private aou B;
    private boolean C;
    private bww D;
    private ara E;
    private int F;
    private int G;
    private float H;
    private boolean I;
    private String J;
    private bwp K;
    private are L;
    private boolean M;
    private bws N;
    private bwt O;
    private boolean P;
    private boolean Q;
    private cms R;
    private Future S;
    private Future T;
    final AtomicInteger a;
    private final cjk d;
    private final bkn e;
    private final bmh f;
    private final ExecutorService g;
    private final bjp h;
    private final atf i;
    private final arp j;
    private final clj k;
    private final ckl l;
    private final cjn m;
    private final aol n;
    private final anv o;
    private final ckv p;
    private final cjj q;
    private final Handler r;
    private final ass s;
    private final bjp t;
    private final bjp u;
    private final cnb v;
    private cke w;
    private anl x;
    private cml y;
    private cmf z;

    public cjh(bkn bkn1, bmh bmh1, ExecutorService executorservice, bjp bjp1, bmi bmi1, atf atf1, arp arp1, 
            ckv ckv1, clj clj1, cnb cnb1, ass ass, bjp bjp2, bjp bjp3)
    {
        this(bkn1, bmh1, executorservice, bjp1, bmi1, atf1, arp1, ckv1, clj1, cnb1, ass, bjp2, bjp3, b, c);
    }

    private cjh(bkn bkn1, bmh bmh1, ExecutorService executorservice, bjp bjp1, bmi bmi1, atf atf1, arp arp1, 
            ckv ckv1, clj clj1, cnb cnb1, ass ass, bjp bjp2, bjp bjp3, cjk cjk1, 
            cjp cjp1)
    {
        a = new AtomicInteger();
        e = (bkn)b.a(bkn1);
        f = (bmh)b.a(bmh1);
        g = (ExecutorService)b.a(executorservice);
        h = (bjp)b.a(bjp1);
        i = (atf)b.a(atf1);
        j = (arp)b.a(arp1);
        p = (ckv)b.a(ckv1);
        k = (clj)b.a(clj1);
        v = (cnb)b.a(cnb1);
        s = ass;
        t = bjp2;
        u = (bjp)b.a(bjp3);
        d = (cjk)b.a(cjk1);
        m = new cjn(this);
        n = new cjm(this);
        o = new cjl(this);
        l = new ckw(new cjd((bmi)b.a(bmi1)));
        q = new cjj(this);
        r = new Handler();
        H = 1.0F;
        L = cjp1.a(this);
        R = cms.a;
    }

    static int a(cjh cjh1, int i1)
    {
        cjh1.F = i1;
        return i1;
    }

    static bww a(cjh cjh1)
    {
        return cjh1.D;
    }

    private cku a(bww bww1, bwp bwp1, bws bws, boolean flag, boolean flag1)
    {
        Object obj;
        int i1;
label0:
        {
            if (bww1.g)
            {
                bmo.b("Live video not supported by adaptive DASH player.");
                throw new UnsupportedOperationException();
            }
            if (a.d == 0)
            {
                a.d = Runtime.getRuntime().availableProcessors();
            }
            int j1 = a.d;
            if (!v.b())
            {
                break label0;
            }
            float f1;
            float f2;
            Object obj1;
            Set set;
            boolean flag2;
            if (bwp1.a.b != null)
            {
                i1 = bwp1.a.b.t;
            } else
            {
                i1 = 0;
            }
            if (j1 < i1)
            {
                break label0;
            }
            f2 = f.a();
            if (bwp1.a.b != null)
            {
                f1 = bwp1.a.b.u;
            } else
            {
                f1 = 0.0F;
            }
            if (f2 < f1)
            {
                break label0;
            }
            obj = a(bww1, bwd.f());
            obj1 = a(bww1, bwd.g());
            if (obj.length == 0)
            {
                i1 = 1;
            } else
            {
                if (obj1.length == 0)
                {
                    break label0;
                }
                i1 = ((bwv) (obj[obj.length - 1])).a;
                int k1 = ((bwv) (obj1[obj1.length - 1])).a;
                if (i1 > k1)
                {
                    break label0;
                }
                obj = bwp1.q();
                if (((SparseIntArray) (obj)).indexOfKey(j1) < 0 || ((SparseIntArray) (obj)).get(j1) >= k1)
                {
                    i1 = 1;
                } else
                {
                    i1 = 0;
                }
            }
        }
_L1:
        if (i1 != 0)
        {
            obj = bwd.g();
        } else
        {
            obj = bwd.f();
        }
        if (bww1.i && !flag1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj1 = p;
        bww1 = bww1.c;
        set = bwd.k();
        flag2 = bwp1.b(bws);
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return ((ckv) (obj1)).a(bwp1, bww1, ((Set) (obj)), set, flag2, flag, true, flag1);
        i1 = 0;
          goto _L1
    }

    public static cnd a(ank ank1, int i1)
    {
        Throwable throwable = ank1.getCause();
        if (throwable instanceof ash)
        {
            int j1 = ((ash)throwable).b;
            if (j1 == 403)
            {
                return new cnd("staleconfig", i1);
            } else
            {
                return (new cnd("net.badstatus", i1, Integer.valueOf(j1))).b();
            }
        }
        if (throwable instanceof asg)
        {
            return new cnd("fmt.unparseable", i1, ((asg)throwable).b);
        }
        if (throwable instanceof asf)
        {
            arx arx1 = ((asf)throwable).a;
            ank1 = throwable;
            if (arx1 != null)
            {
                ank1 = throwable;
                if (arx1.a != null)
                {
                    ank1 = String.valueOf(arx1.a.getHost());
                    if (ank1.length() != 0)
                    {
                        ank1 = "shost.".concat(ank1);
                    } else
                    {
                        ank1 = new String("shost.");
                    }
                }
            }
            return (new cnd("net.closed", i1, ank1)).b();
        }
        if (throwable instanceof aop)
        {
            return new cnd("fmt.unparseable", i1, throwable);
        }
        if (throwable instanceof android.media.MediaCodec.CryptoException)
        {
            ank1 = (android.media.MediaCodec.CryptoException)throwable;
            int k1 = ank1.getErrorCode();
            ank1 = String.valueOf(ank1.getMessage());
            return new cnd("drm.keyerror", i1, (new StringBuilder(String.valueOf(ank1).length() + 12)).append(k1).append("-").append(ank1).toString());
        }
        if (throwable instanceof anz)
        {
            return (new cnd("android.exo.decoderinit", i1, ((anz)throwable).a)).b();
        }
        if (throwable instanceof aoz)
        {
            return (new cnd("android.exo.audioinit", i1, Integer.valueOf(((aoz)throwable).a))).b();
        }
        if (throwable instanceof apa)
        {
            return (new cnd("android.exo.audiowrite", i1, Integer.valueOf(((apa)throwable).a))).b();
        }
        if (throwable instanceof RuntimeException)
        {
            return (new cnd("android.exo", i1, throwable)).b();
        }
        if (throwable != null)
        {
            return new cnd("android.exo", i1, throwable);
        } else
        {
            return new cnd("android.exo", i1, ank1.getMessage());
        }
    }

    private void a(cku cku1)
    {
        boolean flag;
        if (x != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        if (K != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        b.a(cku1);
        if (K.b(N))
        {
            if (cku1.a.length > 1)
            {
                cks cks1 = cku1.f;
                cml cml1 = y;
                x.a(cml1, 1, new cmn(cks1.b, cks1.a));
            }
            if (cku1.b.length > 1)
            {
                cmf cmf1 = z;
                x.a(cmf1, 0, cku1.g);
            }
        }
    }

    private void a(cnd cnd1)
    {
        String s1 = cnd1.a;
        Object obj = cnd1.c;
        if (obj instanceof Throwable)
        {
            obj = (Throwable)obj;
        } else
        {
            s1 = String.valueOf(s1);
            obj = String.valueOf(obj);
            s1 = (new StringBuilder(String.valueOf(s1).length() + 2 + String.valueOf(obj).length())).append(s1).append(": ").append(((String) (obj))).toString();
            obj = null;
        }
        bmo.a(s1, ((Throwable) (obj)));
        l.a(cnd1);
        p();
    }

    private void a(String s1, Exception exception)
    {
        a(new cnd(s1, h(), exception));
    }

    private void a(boolean flag)
    {
        int i1 = 1;
        if (x != null && A != null && w != null && w.j() && !C)
        {
            y.a(x, w.a(), w.b());
            ckl ckl1;
            if (flag)
            {
                x.b(A, 1, w.i());
            } else
            {
                x.a(A, 1, w.i());
            }
            x.a(1, true);
            C = true;
        }
        ckl1 = l;
        if (w != null)
        {
            i1 = w.m();
        }
        ckl1.d(i1);
        w();
    }

    private void a(aou aaou[], int i1)
    {
        x.a(i1);
        a(H);
        a(false);
        x.a(aaou);
        if (M && A != null)
        {
            x.a(1, false);
        }
        l.a(1);
    }

    private aou[] a(aou aaou[])
    {
        B = null;
        A = null;
        if (aaou.length > 0)
        {
            B = aaou[0];
        }
        if (aaou.length > 1)
        {
            A = aaou[1];
        }
        return aaou;
    }

    private aou[] a(aqr aaqr[], aqr aaqr1[], String s1)
    {
        anh anh1 = new anh(new arq(K.e() << 10), null, null, K.a(), K.b(), K.c(), K.d());
        aou aaou[];
        Object obj;
        bwp bwp2;
        int i1;
        int j1;
        if (aaqr != null && aaqr.length > 0 && aaqr[0] != null)
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (j1 != 0)
        {
            i1 = 2;
        } else
        {
            i1 = 1;
        }
        aaou = new aou[i1];
        z = new cmf(s1);
        s1 = (art)h.b_();
        obj = new apu();
        bwp2 = K;
        if (bwp2.a.b != null)
        {
            i1 = bwp2.a.b.o;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            i1 = 1;
        }
        s1 = new cmc(s1, ((apr) (obj)), i1, r(), i, K.i(), false, 10, false, aaqr1);
        obj = K;
        if (((bwp) (obj)).a.b != null)
        {
            i1 = ((bwp) (obj)).a.b.C;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0)
        {
            i1 = 100;
        }
        aaou[0] = new ans(new apd(s1, anh1, i1 * K.e() << 10, true, r, q, a.get(), K.p()), E, true, r, o);
        if (j1 != 0)
        {
            int j2 = aaqr1[0].b.e;
            aaqr1 = v;
            Object obj1;
            atf atf1;
            bwp bwp3;
            boolean flag;
            boolean flag1;
            boolean flag2;
            boolean flag3;
            if (aaqr1.d() && ((cnb) (aaqr1)).a.getBoolean("medialib_diagnostic_cycling_format_evaluator_enabled", false))
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                aaqr1 = new cma();
            } else
            {
                aaqr1 = e;
                s1 = j;
                bwp bwp1 = K;
                float f1;
                int k1;
                int l1;
                int i2;
                if (bwp1.a.b != null)
                {
                    i1 = bwp1.a.b.c * 8;
                } else
                {
                    i1 = 0;
                }
                if (i1 != 0)
                {
                    j1 = i1;
                } else
                {
                    j1 = 0xc3500;
                }
                bwp1 = K;
                if (bwp1.a.b != null)
                {
                    i1 = bwp1.a.b.d;
                } else
                {
                    i1 = 0;
                }
                if (i1 != 0)
                {
                    k1 = i1;
                } else
                {
                    k1 = 10000;
                }
                bwp1 = K;
                if (bwp1.a.b != null)
                {
                    i1 = bwp1.a.b.e;
                } else
                {
                    i1 = 0;
                }
                if (i1 != 0)
                {
                    l1 = i1;
                } else
                {
                    l1 = 25000;
                }
                bwp1 = K;
                if (bwp1.a.b != null)
                {
                    i1 = bwp1.a.b.f;
                } else
                {
                    i1 = 0;
                }
                if (i1 == 0)
                {
                    i1 = 25000;
                }
                bwp1 = K;
                if (bwp1.a.b != null)
                {
                    f1 = bwp1.a.b.k;
                } else
                {
                    f1 = 0.0F;
                }
                if (f1 == 0.0F)
                {
                    f1 = 0.75F;
                }
                if (D.i)
                {
                    i2 = 480;
                } else
                {
                    i2 = 0x7fffffff;
                }
                bwp1 = K;
                if (bwp1.a.b != null)
                {
                    flag = bwp1.a.b.s;
                } else
                {
                    flag = false;
                }
                aaqr1 = new cmg(aaqr1, s1, j1, k1, l1, i1, f1, 144, i2, j2, flag);
            }
            y = aaqr1;
            flag1 = K.o();
            aaqr1 = (art)h.b_();
            s1 = y;
            obj1 = K;
            if (((bwp) (obj1)).a.b != null)
            {
                i1 = ((bwp) (obj1)).a.b.p;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0)
            {
                j1 = i1;
            } else
            {
                j1 = 1;
            }
            obj1 = r();
            atf1 = i;
            flag2 = K.i();
            flag3 = K.o();
            bwp3 = K;
            if (bwp3.a.b != null)
            {
                i1 = bwp3.a.b.I;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0)
            {
                i1 = 10;
            }
            bwp3 = K;
            if (bwp3.a.b != null)
            {
                flag = bwp3.a.b.J;
            } else
            {
                flag = false;
            }
            aaqr = new cmc(aaqr1, s1, j1, ((List) (obj1)), atf1, flag2, flag3, i1, flag, aaqr);
            aaqr1 = K;
            if (((bwp) (aaqr1)).a.b != null)
            {
                i1 = ((bwp) (aaqr1)).a.b.B;
            } else
            {
                i1 = 0;
            }
            if (i1 == 0)
            {
                i1 = 260;
            }
            aaou[1] = new cji(this, new apd(aaqr, anh1, i1 * K.e() << 10, true, r, q, a.get(), K.p()), E, true, 1, 5000L, new aos(((Float)u.b_()).floatValue(), true), r, n, 1, flag1);
        }
        return aaou;
    }

    private static aqr[] a(bwb abwb[], String s1, int i1)
    {
        int j1 = Math.min(abwb.length, i1);
        aqr aaqr[] = new aqr[j1];
        for (i1 = 0; i1 < j1; i1++)
        {
            aaqr[i1] = abwb[i1].b(s1);
        }

        return aaqr;
    }

    private bwv[] a(bww bww1, Set set)
    {
        try
        {
            bww1 = p.a(new bwp(), bww1.c, set, Collections.emptySet(), true, false, false, false).d;
        }
        // Misplaced declaration of an exception variable
        catch (bww bww1)
        {
            return ckv.b;
        }
        return bww1;
    }

    static int b(cjh cjh1, int i1)
    {
        cjh1.G = i1;
        return i1;
    }

    static boolean b(cjh cjh1)
    {
        return cjh1.M;
    }

    static ckl c(cjh cjh1)
    {
        return cjh1.l;
    }

    static boolean d(cjh cjh1)
    {
        return cjh1.C;
    }

    static void e(cjh cjh1)
    {
        cjh1.a(false);
    }

    static void f(cjh cjh1)
    {
        cjh1.a(true);
    }

    static int g(cjh cjh1)
    {
        return cjh1.F;
    }

    static int h(cjh cjh1)
    {
        return cjh1.G;
    }

    static cke i(cjh cjh1)
    {
        return cjh1.w;
    }

    static cml j(cjh cjh1)
    {
        return cjh1.y;
    }

    static anl k(cjh cjh1)
    {
        return cjh1.x;
    }

    static void l(cjh cjh1)
    {
        cjh1.y();
    }

    static bjp m(cjh cjh1)
    {
        return cjh1.h;
    }

    private void o()
    {
        if (S != null)
        {
            S.cancel(true);
            S = null;
        }
        if (T != null)
        {
            T.cancel(true);
            T = null;
        }
    }

    private void p()
    {
        A = null;
        B = null;
        D = null;
        cjj cjj1 = q;
        cjj1.a = null;
        cjj1.b = null;
        cjj1.c = null;
        o();
    }

    private boolean q()
    {
        if (x == null) goto _L2; else goto _L1
_L1:
        long l1;
        Object obj = K;
        dov adov[];
        are are1;
        dov dov1;
        int j1;
        boolean flag;
        if (((bwp) (obj)).a.b != null)
        {
            flag = ((bwp) (obj)).a.b.r;
        } else
        {
            flag = false;
        }
        if (flag && !D.i) goto _L2; else goto _L3
_L3:
        l1 = x.h();
        t();
_L12:
        Object obj1;
        int i1;
        if (x == null)
        {
            x = d.a(2, K.h(), 5000);
            if (l1 != 0L)
            {
                x.a(l1);
            }
            x.a(this);
        } else
        {
            x.e();
            u();
        }
        try
        {
            if (!D.i)
            {
                break MISSING_BLOCK_LABEL_251;
            }
            are1 = L;
            obj = D;
            b.b(((bww) (obj)).i);
            adov = ((bww) (obj)).d.f;
            j1 = adov.length;
        }
        catch (UnsupportedOperationException unsupportedoperationexception)
        {
            a("drm.missingapi", ((Exception) (null)));
            return false;
        }
        i1 = 0;
_L8:
        if (i1 >= j1) goto _L5; else goto _L4
_L4:
        dov1 = adov[i1];
        if (dov1.b != 4) goto _L7; else goto _L6
_L6:
        obj1 = Uri.parse(dov1.c);
_L9:
        obj1 = are1.a(((Uri) (obj1)), k, x.a(), r, J);
_L10:
        E = ((ara) (obj1));
        return true;
_L7:
        i1++;
          goto _L8
_L5:
        obj1 = null;
          goto _L9
        obj1 = null;
          goto _L10
_L2:
        l1 = 0L;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private List r()
    {
        ArrayList arraylist = new ArrayList();
        if (t != null)
        {
            arraylist.addAll((Collection)t.b_());
        }
        if (s != null)
        {
            arraylist.add(s);
        }
        return arraylist;
    }

    private void s()
    {
        if (x != null)
        {
            a(false);
            l.a(new cib());
            x.a(true);
        }
    }

    private void t()
    {
        if (x != null)
        {
            u();
            x.f();
            x = null;
        }
    }

    private void u()
    {
        if (x != null && A != null && w != null && w.j() && C)
        {
            x.a(A, 1, null);
        }
        C = false;
        w();
        l.d(1);
    }

    private void v()
    {
        boolean flag2;
        boolean flag1 = true;
        int i1 = x.b();
        flag2 = x.c();
        boolean flag;
        if (i1 == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i1 != 4 || !flag2 || !x.d())
        {
            flag1 = false;
        }
        if (Q != flag)
        {
            ckl ckl1 = l;
            byte byte0;
            if (flag)
            {
                byte0 = 5;
            } else
            {
                byte0 = 6;
            }
            ckl1.a(byte0);
            Q = flag;
        }
        if (P == flag1) goto _L2; else goto _L1
_L1:
        if (!flag1) goto _L4; else goto _L3
_L3:
        l.a(2);
_L6:
        P = flag1;
_L2:
        w();
        return;
_L4:
        if (!flag2)
        {
            l.a(3);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void w()
    {
        if (w != null)
        {
            boolean flag;
            if (C && l())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            bmo.d((new StringBuilder(16)).append("stayAwake: ").append(flag).toString());
            w.b(flag);
        }
    }

    private int x()
    {
        boolean flag1;
        boolean flag2;
        flag2 = true;
        if (D != null && D.i)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1 && R == cms.b)
        {
            return 5;
        }
        if (K == null) goto _L2; else goto _L1
_L1:
        bwt bwt1;
        bwp bwp1;
        bwp1 = K;
        bwt bwt2 = O;
        bwt1 = bwt2;
        if (bwt2 == null)
        {
            bwt1 = bwt.d;
        }
        bwr.b[bwt1.ordinal()];
        JVM INSTR tableswitch 1 3: default 108
    //                   1 239
    //                   2 239
    //                   3 245;
           goto _L3 _L4 _L4 _L5
_L3:
        boolean flag;
        boolean flag3;
        if (bwp1.a.b != null)
        {
            flag3 = bwp1.a.b.A;
        } else
        {
            flag3 = true;
        }
_L17:
        if (K == null) goto _L7; else goto _L6
_L6:
        bwp1 = K;
        bwt bwt3 = O;
        bwt1 = bwt3;
        if (bwt3 == null)
        {
            bwt1 = bwt.d;
        }
        flag = flag2;
        bwr.b[bwt1.ordinal()];
        JVM INSTR tableswitch 1 3: default 196
    //                   1 274
    //                   2 232
    //                   3 274;
           goto _L8 _L9 _L10 _L9
_L8:
        if (!flag1) goto _L12; else goto _L11
_L11:
        flag = flag2;
        if (bwp1.a.b == null) goto _L10; else goto _L13
_L13:
        if (bwp1.a.b.A) goto _L12; else goto _L14
_L14:
        flag = flag2;
_L10:
        if (flag3)
        {
            return 2;
        }
        break; /* Loop/switch isn't completed */
_L4:
        flag3 = false;
        continue; /* Loop/switch isn't completed */
_L5:
        flag3 = true;
        continue; /* Loop/switch isn't completed */
_L2:
        if (!flag1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L12:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L7:
        flag = flag1;
        if (true) goto _L10; else goto _L15
_L15:
        if (flag)
        {
            return 4;
        }
        return 3;
        if (true) goto _L17; else goto _L16
_L16:
    }

    private void y()
    {
        if (w != null)
        {
            w.a(null);
            u();
            w = null;
        }
    }

    public final cku a(bww bww1, bwp bwp1, boolean flag)
    {
        b.a(bww1);
        return a(bww1, bwp1, v.c(), flag, false);
    }

    public final void a()
    {
        v();
    }

    public final void a(float f1)
    {
        H = f1;
        if (x != null && B != null)
        {
            x.a(B, 1, Float.valueOf(f1));
        }
    }

    public final void a(int i1)
    {
        if (i1 == 4 || i1 == 5)
        {
            I = false;
        }
        if (i1 == 5)
        {
            l.a(7);
            P = false;
            Q = false;
            w();
            return;
        } else
        {
            v();
            return;
        }
    }

    public final void a(Handler handler)
    {
        l.a(handler);
    }

    public final void a(ank ank1)
    {
        if (ank1.getCause() instanceof clo)
        {
            return;
        } else
        {
            l.a(a(ank1, h()));
            return;
        }
    }

    public final void a(bww bww1, int i1, String s1, bwp bwp1)
    {
        int j1;
        j1 = 1;
        b.a(bww1);
        b.a(bwp1);
        if (x == null || D == null || !D.e.equals(bww1.e)) goto _L2; else goto _L1
_L1:
        b(i1);
        if (w != null)
        {
            w.a(0);
        }
        if (!l())
        {
            s();
        }
_L6:
        return;
_L2:
        p();
        D = bww1;
        J = s1;
        K = bwp1;
        N = v.c();
        bww1 = v;
        s1 = bwt.d;
        boolean flag;
        if (!((cnb) (bww1)).b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        O = (bwt)bww1.a("media_view_activation_type", bwt, s1, flag);
        L.a(K);
        a.incrementAndGet();
        F = 0;
        G = 0;
        I = false;
        if (w != null)
        {
            w.g();
        }
        M = M | D.c();
        try
        {
            s1 = a(D, K, N, M, L.c());
        }
        // Misplaced declaration of an exception variable
        catch (bww bww1)
        {
            a("fmt.noneavailable", ((Exception) (bww1)));
            return;
        }
        q.a = s1;
        if (w == null) goto _L4; else goto _L3
_L3:
        bww1 = D.a.iterator();
        do
        {
            if (!bww1.hasNext())
            {
                break MISSING_BLOCK_LABEL_462;
            }
        } while (((bwb)bww1.next()).a.t != 2);
        bww1 = cms.b;
_L7:
        R = bww1;
        w.b(x());
        bww1 = w.h();
        if (bww1 != null)
        {
            try
            {
                bww1.a(R);
            }
            // Misplaced declaration of an exception variable
            catch (bww bww1)
            {
                a("android.exo", ((Exception) (bww1)));
                return;
            }
        }
_L4:
        bwp1 = ((cku) (s1)).a;
        bww1 = ((cku) (s1)).b;
        l.a(0);
        if (K.b(N))
        {
            j1 = 0x7fffffff;
        }
        bwp1 = a(((bwb []) (bwp1)), J, j1);
        bww1 = a(((bwb []) (bww1)), J, j1);
        if (!q()) goto _L6; else goto _L5
_L5:
        a(a(a(((aqr []) (bwp1)), ((aqr []) (bww1)), ((cku) (s1)).g)), i1);
        a(((cku) (s1)));
        s();
        return;
        bww1 = cms.a;
          goto _L7
    }

    public final void a(cke cke1)
    {
        b.a(cke1);
        M = false;
        y();
        w = cke1;
        cke1.a(m);
        try
        {
            cke1.b(x());
        }
        // Misplaced declaration of an exception variable
        catch (cke cke1)
        {
            g();
            l.a(new cnd("android.exo", h(), cke1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (cke cke1)
        {
            g();
            l.a(new cnd("android.exo", h(), cke1));
            return;
        }
        a(false);
    }

    public final void a(String s1, Uri uri)
    {
        o();
        if (!M)
        {
            S = g.submit(new cjo(this, uri.buildUpon().appendQueryParameter("itag", "134").build()));
        }
        T = g.submit(new cjo(this, uri.buildUpon().appendQueryParameter("itag", "140").build()));
    }

    public final bwb b()
    {
        return q.b;
    }

    public final void b(int i1)
    {
        if (x != null)
        {
            l.b(i1);
            I = true;
            x.a(i1);
            l.c(i1);
        }
    }

    public final bwb c()
    {
        return q.c;
    }

    public final void d()
    {
        if (x != null && x.b() == 5 && !I)
        {
            x.a(0L);
        }
        s();
    }

    public final void e()
    {
        if (x != null)
        {
            x.a(false);
        }
    }

    public final void f()
    {
        if (x != null)
        {
            x.e();
            p();
            l.a(4);
        }
    }

    public final void g()
    {
        if (x != null)
        {
            x.e();
            t();
            p();
            l.a(4);
        }
    }

    public final int h()
    {
        if (x != null)
        {
            return (int)x.h();
        } else
        {
            return 0;
        }
    }

    public final int i()
    {
        if (x != null)
        {
            return (int)x.g();
        } else
        {
            return 0;
        }
    }

    public final int j()
    {
        if (x != null)
        {
            return (int)x.i();
        } else
        {
            return 0;
        }
    }

    public final boolean k()
    {
        return x != null && Q;
    }

    public final boolean l()
    {
        return x != null && (P || Q && x.c());
    }

    public final void m()
    {
        if (w != null)
        {
            w.g();
        }
    }

    public final void n()
    {
        M = true;
        if (x != null && A != null)
        {
            x.a(1, false);
        }
        y();
    }

    public final void onDrmError(Exception exception)
    {
        f();
        if (!(exception instanceof clo)) goto _L2; else goto _L1
_L1:
        Throwable throwable;
        cln cln1;
        int i1;
        exception = (clo)exception;
        i1 = h();
        cln1 = ((clo) (exception)).b;
        throwable = exception.getCause();
        if (cln1 == null) goto _L4; else goto _L3
_L3:
        exception = new cnd("drm.auth", i1, Integer.valueOf(cln1.a));
_L5:
        a(exception);
        return;
_L4:
        if (throwable instanceof mp)
        {
            mp mp1 = (mp)throwable;
            if (mp1.a != null)
            {
                exception = (new cnd("drm.net.badstatus", i1, Integer.valueOf(mp1.a.a))).b();
                continue; /* Loop/switch isn't completed */
            }
            if (throwable instanceof mo)
            {
                exception = (new cnd("drm.net.timeout", i1)).b();
                continue; /* Loop/switch isn't completed */
            }
            if (throwable instanceof mc)
            {
                exception = (new cnd("drm.net.connect", i1)).b();
                continue; /* Loop/switch isn't completed */
            }
        }
        exception = new cnd("drm", i1, exception);
        if (true) goto _L5; else goto _L2
_L2:
        a("drm", exception);
        return;
    }

    public final void onHdEntitlementReceived()
    {
        boolean flag;
        if (D == null || D.i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.b(flag);
        if (D == null)
        {
            return;
        }
        if (x != null && D != null && A != null) goto _L2; else goto _L1
_L1:
        q.a(3);
        return;
_L2:
        Object obj = a(D, K, N, M, L.c());
        q.a = ((cku) (obj));
        if (K.b(N))
        {
            a(((cku) (obj)));
        } else
        {
            Object obj1 = ((cku) (obj)).a[0];
            Object obj2 = ((cku) (obj)).b[0];
            if (!((bwb) (obj1)).equals(q.b))
            {
                obj1 = ((bwb) (obj1)).b(J);
                obj2 = ((bwb) (obj2)).b(J);
                if (q())
                {
                    obj = ((cku) (obj)).g;
                    aou aaou[] = a(a(new aqr[] {
                        obj1
                    }, new aqr[] {
                        obj2
                    }, ((String) (obj))));
                    l.b();
                    a(aaou, h());
                    s();
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        ckm ckm1;
        ckm1;
        if (true) goto _L1; else goto _L3
_L3:
    }

}
