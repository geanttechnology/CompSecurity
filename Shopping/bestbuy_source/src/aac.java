// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gu;

public class aac extends abn
    implements acf
{

    private final wd a;
    private final aab b;
    private final gu c;
    private final Object d = new Object();
    private final Context e;
    private final Object f = new Object();
    private final abe g;
    private fj h;
    private boolean i;
    private vt j;
    private vv k;
    private vz l;

    public aac(Context context, abe abe1, gu gu1, wd wd, aab aab)
    {
        i = false;
        e = context;
        g = abe1;
        h = abe1.b;
        c = gu1;
        a = wd;
        b = aab;
        k = abe1.c;
    }

    static Object a(aac aac1)
    {
        return aac1.f;
    }

    private void a(fh fh1, long l1)
    {
        synchronized (d)
        {
            j = new vt(e, fh1, a, k);
        }
        l = j.a(l1, 60000L);
        switch (l.a)
        {
        default:
            throw new aad((new StringBuilder()).append("Unexpected mediation result: ").append(l.a).toString(), 0);

        case 1: // '\001'
            throw new aad("No fill from any mediation ad networks.", 3);

        case 0: // '\0'
            return;
        }
        fh1;
        obj;
        JVM INSTR monitorexit ;
        throw fh1;
    }

    static aab b(aac aac1)
    {
        return aac1.b;
    }

    private void b(long l1)
    {
        aca.a.post(new Runnable() {

            final aac a;

            public void run()
            {
label0:
                {
                    synchronized (aac.a(a))
                    {
                        if (aac.c(a).e == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                aac.d(a).f().a(a);
                if (aac.c(a).e != -3)
                {
                    break MISSING_BLOCK_LABEL_119;
                }
                acb.d((new StringBuilder()).append("Loading URL in WebView: ").append(aac.c(a).b).toString());
                aac.d(a).loadUrl(aac.c(a).b);
_L1:
                obj;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
                acb.d("Loading HTML in WebView.");
                aac.d(a).loadDataWithBaseURL(abq.a(aac.c(a).b), aac.c(a).c, "text/html", "UTF-8", null);
                  goto _L1
            }

            
            {
                a = aac.this;
                super();
            }
        });
        c(l1);
    }

    static fj c(aac aac1)
    {
        return aac1.h;
    }

    private void c(long l1)
    {
        do
        {
            if (!d(l1))
            {
                throw new aad("Timed out waiting for WebView to finish loading.", 2);
            }
        } while (!i);
    }

    static gu d(aac aac1)
    {
        return aac1.c;
    }

    private boolean d(long l1)
    {
        l1 = 60000L - (SystemClock.elapsedRealtime() - l1);
        if (l1 <= 0L)
        {
            return false;
        }
        try
        {
            f.wait(l1);
        }
        catch (InterruptedException interruptedexception)
        {
            throw new aad("Ad request cancelled.", -1);
        }
        return true;
    }

    public void a()
    {
        Object obj2 = f;
        obj2;
        JVM INSTR monitorenter ;
        Object obj;
        int i1;
        acb.a("AdRendererBackgroundTask started.");
        obj = g.a;
        i1 = g.e;
        long l1 = SystemClock.elapsedRealtime();
        if (!h.h) goto _L2; else goto _L1
_L1:
        a(((fh) (obj)), l1);
_L11:
        com.google.android.gms.internal.av av;
        gu gu1;
        java.util.List list;
        java.util.List list1;
        java.util.List list2;
        String s1;
        int j1;
        boolean flag;
        av = ((fh) (obj)).c;
        gu1 = c;
        list = h.d;
        list1 = h.f;
        list2 = h.j;
        j1 = h.l;
        l1 = h.k;
        s1 = ((fh) (obj)).i;
        flag = h.h;
        if (l == null) goto _L4; else goto _L3
_L3:
        obj = l.b;
_L18:
        Object obj1;
        if (l == null)
        {
            break MISSING_BLOCK_LABEL_449;
        }
        obj1 = l.c;
_L19:
        if (l == null) goto _L6; else goto _L5
_L5:
        String s = l.d;
_L16:
        vv vv = k;
        if (l == null) goto _L8; else goto _L7
_L7:
        vx vx = l.e;
_L17:
        obj = new abd(av, gu1, list, i1, list1, list2, j1, l1, s1, flag, ((vu) (obj)), ((wg) (obj1)), s, vv, vx, h.i, g.d, h.g, g.f, h.n, h.o, g.h, null);
        aca.a.post(new Runnable(((abd) (obj))) {

            final abd a;
            final aac b;

            public void run()
            {
                synchronized (aac.a(b))
                {
                    aac.b(b).a(a);
                }
                return;
                exception;
                obj3;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = aac.this;
                a = abd1;
                super();
            }
        });
        return;
_L2:
        if (!h.p) goto _L10; else goto _L9
_L9:
        a(l1);
          goto _L11
        obj1;
        i1 = ((aad) (obj1)).a();
        if (i1 != 3 && i1 != -1) goto _L13; else goto _L12
_L12:
        acb.c(((aad) (obj1)).getMessage());
_L14:
        if (h != null)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        h = new fj(i1);
_L15:
        aca.a.post(new Runnable() {

            final aac a;

            public void run()
            {
                a.b();
            }

            
            {
                a = aac.this;
                super();
            }
        });
          goto _L11
        obj;
        obj2;
        JVM INSTR monitorexit ;
        throw obj;
_L10:
        b(l1);
          goto _L11
_L13:
        acb.e(((aad) (obj1)).getMessage());
          goto _L14
        h = new fj(i1, h.k);
          goto _L15
_L6:
        s = oi.getName();
          goto _L16
_L8:
        vx = null;
          goto _L17
_L4:
        obj = null;
          goto _L18
        obj1 = null;
          goto _L19
    }

    protected void a(long l1)
    {
        Object obj = c.e();
        int i1;
        int j1;
        if (((ay) (obj)).e)
        {
            j1 = e.getResources().getDisplayMetrics().widthPixels;
            i1 = e.getResources().getDisplayMetrics().heightPixels;
        } else
        {
            j1 = ((ay) (obj)).g;
            i1 = ((ay) (obj)).d;
        }
        obj = new zy(this, c, j1, i1);
        aca.a.post(new Runnable(((zy) (obj))) {

            final zy a;
            final aac b;

            public void run()
            {
label0:
                {
                    synchronized (aac.a(b))
                    {
                        if (aac.c(b).e == -2)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                aac.d(b).f().a(b);
                a.a(aac.c(b));
                obj1;
                JVM INSTR monitorexit ;
                return;
                exception;
                obj1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            
            {
                b = aac.this;
                a = zy1;
                super();
            }
        });
        c(l1);
        if (((zy) (obj)).c())
        {
            acb.a("Ad-Network indicated no fill with passback URL.");
            throw new aad("AdNetwork sent passback url", 3);
        }
        if (!((zy) (obj)).d())
        {
            throw new aad("AdNetwork timed out", 2);
        } else
        {
            return;
        }
    }

    public void a(gu gu1)
    {
        synchronized (f)
        {
            acb.a("WebView finished loading.");
            i = true;
            f.notify();
        }
        return;
        exception;
        gu1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void b()
    {
        synchronized (d)
        {
            c.stopLoading();
            abq.a(c);
            if (j != null)
            {
                j.a();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
