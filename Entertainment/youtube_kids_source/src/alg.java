// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;

public final class alg
    implements amq
{

    private final amd a;
    private final aku b;
    private final bmi c;
    private final chq d;
    private final Handler e = new alh(this);
    private final int f = 3;
    private int g;
    private long h;

    public alg(amd amd1, aku aku1, int i, bmi bmi1, chq chq1)
    {
        g = 0;
        h = 0L;
        a = (amd)b.a(amd1);
        b = (aku)b.a(aku1);
        c = (bmi)b.a(bmi1);
        d = (chq)b.a(chq1);
        b.a(true);
        b.a(true);
    }

    private void c(int i)
    {
        if (!d())
        {
            d.b("Remote control is not connected, cannot change volume");
            return;
        }
        e.removeMessages(0);
        g = g + i;
        long l = c.b() - h;
        if (l >= 200L)
        {
            c();
            return;
        } else
        {
            e.sendMessageDelayed(Message.obtain(e, 0), 200L - l);
            return;
        }
    }

    private boolean d()
    {
        return b.d == amj.b;
    }

    public final void a()
    {
        if (!d())
        {
            d.b("Remote control is not connected, cannot change volume");
            return;
        } else
        {
            c(f);
            return;
        }
    }

    public final void a(int i)
    {
        if (!d())
        {
            d.b("Remote control is not connected, cannot change volume");
            return;
        }
        e.removeMessages(1);
        long l = c.b() - h;
        if (l >= 200L)
        {
            b(i);
            return;
        } else
        {
            e.sendMessageDelayed(Message.obtain(e, 1, i, 0), 200L - l);
            return;
        }
    }

    public final void b()
    {
        if (!d())
        {
            d.b("Remote control is not connected, cannot change volume");
            return;
        } else
        {
            c(-f);
            return;
        }
    }

    void b(int i)
    {
        a.b(i);
        h = c.b();
    }

    void c()
    {
        if (g != 0)
        {
            int i = Math.min(100, Math.max(0, b.r + g));
            a.a(i, g);
            h = c.b();
            g = 0;
        }
    }

    public final void onMdxVolumeChangeEvent(amp amp)
    {
        g = 0;
    }
}
