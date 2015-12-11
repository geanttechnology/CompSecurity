// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;

public final class aju
{

    final akh a;
    final akb b;
    final alw c;
    final String d;
    final alo e;
    final boolean f;
    String g;
    aki h;
    private final chq i;

    aju(String s, alo alo1, akh akh1, akb akb1, alw alw, chq chq1, boolean flag)
    {
        d = s;
        e = (alo)b.a(alo1);
        b.b(e.i());
        a = akh1;
        b = akb1;
        c = alw;
        i = chq1;
        f = flag;
        g = null;
        h = aki.a;
    }

    public final void a(double d1)
    {
        String s = String.valueOf("Cast command SET VOLUME. State: ");
        String s1 = String.valueOf(h);
        a((new StringBuilder(String.valueOf(s).length() + 0 + String.valueOf(s1).length())).append(s).append(s1).toString());
        if (h != aki.c || !b.b())
        {
            b("does not support local volume controls");
            return;
        } else
        {
            b.a(d1);
            return;
        }
    }

    void a(String s)
    {
        i.a(" CastRouteSession: %s", new Object[] {
            s
        });
    }

    public final void a(boolean flag)
    {
        a((new StringBuilder(46)).append("disconnect, should stop the application: ").append(flag).toString());
        h = aki.d;
        b.a();
        if (flag && b.b())
        {
            if (!TextUtils.isEmpty(g))
            {
                String s = String.valueOf(g);
                if (s.length() != 0)
                {
                    s = "Stop currently running application, sessionId: ".concat(s);
                } else
                {
                    s = new String("Stop currently running application, sessionId: ");
                }
                a(s);
                b.a(g);
            } else
            {
                a("Stop currently running application, session id is not known");
                b.a(null);
            }
        }
        a("remove remote media player");
        b.g();
        a("Disconnect client");
        if (b.b())
        {
            b.c();
            b.d();
        }
    }

    public final boolean a()
    {
        return h == aki.c && b.e();
    }

    void b(String s)
    {
        i.c(" CastRouteSession Error: %s", new Object[] {
            s
        });
    }

    public final boolean b()
    {
        return h == aki.c && b.b();
    }

    void c()
    {
        h = aki.d;
        b.a();
        b("cannot connect");
        a.a(alu.a, false);
    }
}
