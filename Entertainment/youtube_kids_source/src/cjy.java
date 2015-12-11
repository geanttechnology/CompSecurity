// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;

final class cjy
    implements cjw, ckg
{

    final cjx a;

    cjy(cjx cjx1)
    {
        a = cjx1;
        super();
    }

    private void b(cjv cjv1)
    {
        if (cjx.i(a))
        {
            if (!cjx.j(a) && cjx.k(a) != 0)
            {
                cjv1.a(cjx.k(a));
            }
            if (!cjx.l(a) && !cjx.m(a))
            {
                cjx.n(a).a(1);
            }
            cjx.e(a, false);
            if (!cjx.j(a) || cjx.h(a))
            {
                cjx.f(a, false);
            }
            if (!cjx.o(a))
            {
                a.d();
            }
        }
    }

    public final void a()
    {
        bmo.a();
        cjx.a(a, true);
        if (cjx.d(a) != null)
        {
            cjx.a(a, cjx.d(a));
            cjx.b(a, null);
        }
    }

    public final void a(int i)
    {
        int j;
label0:
        {
            j = i;
            if (i <= 90)
            {
                break label0;
            }
            if (cjx.p(a) != i)
            {
                j = i;
                if (cjx.p(a) != 100)
                {
                    break label0;
                }
            }
            j = 100;
        }
        cjx.c(a, j);
    }

    public final void a(cjv cjv1)
    {
        bmo.a();
        cjx.c(a, true);
        cjx.b(a, cjv1.f());
        b(cjv1);
    }

    public final void a(cjv cjv1, int i, int j)
    {
        bmo.a();
        if (i > 0 && j > 0)
        {
            if (cjx.f(a).getMainLooper().getThread() == Thread.currentThread())
            {
                cjx.e(a).a(i, j);
            } else
            {
                cjx.g(a).post(new cjz(this, i, j));
            }
            if (!cjx.h(a))
            {
                cjx.d(a, true);
                b(cjv1);
                return;
            }
        }
    }

    public final boolean a(int i, int j)
    {
        Object obj;
        boolean flag;
        if (!cjx.t(a))
        {
            cjx.e(a, true);
            cjx.i(a, false);
            bmo.c((new StringBuilder(70)).append("MediaPlayer error during prepare [what=").append(i).append(", extra=").append(j).append("]").toString());
        } else
        {
            cjx.e(a, false);
            cjx.i(a, true);
            bmo.c((new StringBuilder(71)).append("MediaPlayer error during playback [what=").append(i).append(", extra=").append(j).append("]").toString());
        }
        obj = a;
        if (i == 1 && (j == -1004 || j == 0x80000000) && !((cjx) (obj)).b.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = new cnd("net.nomobiledata", ((cjx) (obj)).h());
        } else
        if (i == 1 && cjx.a.indexOfKey(j) >= 0)
        {
            obj = new cnd((String)cjx.a.get(j), ((cjx) (obj)).h(), (new StringBuilder(12)).append("e").append(j).toString());
        } else
        {
            obj = new cnd("android.fw", ((cjx) (obj)).h(), (new StringBuilder(24)).append("w").append(i).append("e").append(j).toString());
        }
        if (!((cnd) (obj)).a())
        {
            if (cjx.u(a).d < 3)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (j != 0)
            {
                cjx.u(a).a();
                if (i == 100)
                {
                    cjx.e(a).k();
                }
                cjx.n(a).a(((cnd) (obj)));
                if (cjx.j(a))
                {
                    cjx.c(a, cjx.v(a));
                } else
                {
                    cjx.a(a, cjx.v(a), cjx.k(a));
                }
                obj = cjx.u(a);
                obj.c = cjx.k(a);
                ((ckc) (obj)).b.removeCallbacksAndMessages(null);
                ((ckc) (obj)).b.postDelayed(((ckc) (obj)).a, 1000L);
                return true;
            }
        }
        bmo.c("Reporting MediaPlayer error");
        cjx.u(a).b();
        cjx.e(a, false);
        cjx.i(a, false);
        a.f();
        cjx.n(a).a(((cnd) (obj)).b());
        return true;
    }

    public final void b()
    {
        bmo.a();
    }

    public final boolean b(int i, int j)
    {
        String s = String.valueOf(Integer.toHexString(i));
        String s2 = String.valueOf(Integer.toHexString(j));
        bmo.d((new StringBuilder(String.valueOf(s).length() + 19 + String.valueOf(s2).length())).append("media player info ").append(s).append(" ").append(s2).toString());
        switch (i)
        {
        default:
            return false;

        case 701: 
            String s1 = String.valueOf(cjx.v(a));
            bmo.d((new StringBuilder(String.valueOf(s1).length() + 20)).append("Buffering data from ").append(s1).toString());
            cjx.f(a, true);
            return false;

        case 702: 
            cjx.f(a, false);
            break;
        }
        return false;
    }

    public final void c()
    {
        bmo.a();
        a.g();
        cjx.b(a, false);
        cjx.e(a).g();
        cjx.a(a, false);
    }

    public final void d()
    {
        bmo.a();
        cjx.d(a, 0);
        cjx.h(a, false);
        cjx.n(a).a(7);
        cjx.b(a, false);
    }

    public final void e()
    {
        cjx.n(a).c(cjx.k(a));
        if (cjx.q(a) && !cjx.r(a) && cjx.s(a))
        {
            cjx.g(a, false);
            cjx.n(a).a(2);
        }
    }
}
