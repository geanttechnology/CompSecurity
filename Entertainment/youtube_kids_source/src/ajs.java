// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.cast.CastDevice;

public final class ajs
    implements amd
{

    final akj a;
    final aku b;
    aju c;
    private final Context d;
    private final String e;
    private final chq f;
    private final boolean g;

    public ajs(Context context, akj akj1, String s1, aku aku1, chq chq, boolean flag)
    {
        d = context;
        a = akj1;
        e = s1;
        b = aku1;
        f = chq;
        g = flag;
        c = null;
    }

    public final void a()
    {
        if (a.d.d != amj.b)
        {
            return;
        }
        if (c != null && c.a())
        {
            aju aju1 = c;
            String s1 = String.valueOf("Cast command PLAY. State: ");
            String s2 = String.valueOf(aju1.h);
            aju1.a((new StringBuilder(String.valueOf(s1).length() + 0 + String.valueOf(s2).length())).append(s1).append(s2).toString());
            if (aju1.h != aki.c || !aju1.b.e())
            {
                aju1.b("does not support local controls");
                return;
            } else
            {
                aju1.b.h();
                return;
            }
        } else
        {
            a.a();
            return;
        }
    }

    public final void a(int i1)
    {
        if (b.d != amj.b)
        {
            return;
        }
        aku aku1 = b;
        long l1 = i1;
        aku1.a();
        aku1.a(l1);
        aku1.m = true;
        aku1.b.sendEmptyMessageDelayed(1, 2000L);
        if (c != null && c.a())
        {
            aju aju1 = c;
            long l2 = i1;
            String s1 = String.valueOf("Cast command SEEK TO. State: ");
            String s2 = String.valueOf(aju1.h);
            aju1.a((new StringBuilder(String.valueOf(s1).length() + 0 + String.valueOf(s2).length())).append(s1).append(s2).toString());
            if (aju1.h != aki.c || !aju1.b.e())
            {
                aju1.b("does not support local controls");
                return;
            } else
            {
                aju1.b.a(l2);
                return;
            }
        } else
        {
            a.a(i1);
            return;
        }
    }

    public final void a(int i1, int j1)
    {
        if (i() != amj.b)
        {
            return;
        }
        if (c != null && c.b())
        {
            c.a((float)i1 / 100F);
            return;
        } else
        {
            a.a(i1, j1);
            return;
        }
    }

    public final void a(alw alw)
    {
        a.a(alw);
    }

    public final void a(ame ame1, alw alw)
    {
        if (ame1.i())
        {
            b.a(amj.a);
            ame1 = ame1.d();
            Object obj = new ajt(this, ame1, alw);
            Context context = d;
            String s1 = e;
            chq chq = f;
            boolean flag = g;
            c = new aju(s1, ame1, ((akh) (obj)), new akc(context, chq), alw, chq, flag);
            alw = c;
            alw.a("connect");
            if (((aju) (alw)).h == aki.a)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            b.b(flag);
            alw.h = aki.b;
            obj = ((aju) (alw)).e.a;
            ame1 = String.valueOf(((CastDevice) (obj)).d);
            if (ame1.length() != 0)
            {
                ame1 = "Connect client ".concat(ame1);
            } else
            {
                ame1 = new String("Connect client ");
            }
            alw.a(ame1);
            ((aju) (alw)).b.a(((CastDevice) (obj)), new ajv(alw), new ajx(alw), new ajw(alw));
            return;
        } else
        {
            a.a(ame1, alw);
            return;
        }
    }

    public final void a(cxu cxu)
    {
        a.b(cxu);
    }

    public final void a(boolean flag)
    {
        if (c != null)
        {
            b.a(amj.d);
            boolean flag1 = a.u();
            aju aju1 = c;
            if (flag && flag1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            aju1.a(flag1);
            c = null;
        }
        a.a(flag);
    }

    public final boolean a(ame ame1)
    {
        return a.a(ame1);
    }

    public final void b()
    {
        if (a.d.d != amj.b)
        {
            return;
        }
        if (c != null && c.a())
        {
            aju aju1 = c;
            String s1 = String.valueOf("Cast command PAUSE. State: ");
            String s2 = String.valueOf(aju1.h);
            aju1.a((new StringBuilder(String.valueOf(s1).length() + 0 + String.valueOf(s2).length())).append(s1).append(s2).toString());
            if (aju1.h != aki.c || !aju1.b.e())
            {
                aju1.b("does not support local controls");
                return;
            } else
            {
                aju1.b.i();
                return;
            }
        } else
        {
            a.b();
            return;
        }
    }

    public final void b(int i1)
    {
        if (i() != amj.b)
        {
            return;
        }
        if (c != null && c.b())
        {
            c.a((float)i1 / 100F);
            return;
        } else
        {
            a.b(i1);
            return;
        }
    }

    public final void c()
    {
        a.c();
    }

    public final boolean d()
    {
        akj akj1 = a;
        return true;
    }

    public final void e()
    {
        a.e();
    }

    public final boolean f()
    {
        akj akj1 = a;
        return true;
    }

    public final void g()
    {
        a.g();
    }

    public final String h()
    {
        return a.h();
    }

    public final amj i()
    {
        return a.d.d;
    }

    public final alu j()
    {
        return a.j();
    }

    public final amn k()
    {
        return a.d.f;
    }

    public final amb l()
    {
        return a.d.g;
    }

    public final amb m()
    {
        return a.m();
    }

    public final ame n()
    {
        if (c != null)
        {
            return c.e;
        } else
        {
            return a.f;
        }
    }

    public final String o()
    {
        return a.o();
    }

    public final long p()
    {
        return a.p();
    }

    public final long q()
    {
        return a.q();
    }

    public final buz r()
    {
        return a.d.j;
    }

    public final void s()
    {
        a.s();
    }

    public final String t()
    {
        return a.t();
    }
}
