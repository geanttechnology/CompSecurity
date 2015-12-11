// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Application;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class nc extends Application
    implements bht, cnv, sc
{

    public bgv a;
    public cnq b;
    public boolean c;
    private nd d;
    private bjt e;
    private boolean f;

    public nc()
    {
    }

    public nd a()
    {
        return d;
    }

    public abstract nd b();

    public final bgv c()
    {
        return a;
    }

    public final cnq d()
    {
        return b;
    }

    public cnq e()
    {
        return new cnq(this, a);
    }

    public void f()
    {
        bmo.a("?");
        d.s().a(a.i());
        Object obj = a.i().getString("version", null);
        String s = a.g(this);
        boolean flag;
        if (!s.equals(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c = flag;
        if (c)
        {
            a.i().edit().putString("version", s).remove("device_id").remove("device_key").apply();
        }
        new bju(getApplicationContext(), a.d());
        obj = a.j();
        ((blf) (obj)).c.schedule(new blh(((blf) (obj))), ((blf) (obj)).d.k(), TimeUnit.MILLISECONDS);
        a.d().a((bkx)a.d.b_());
    }

    public bmf g()
    {
        return a();
    }

    public final void onCreate()
    {
        SystemClock.elapsedRealtime();
        super.onCreate();
        if (!f)
        {
            f = true;
            bjr bjr1 = bjq.a();
            bjr1.a = new bjs(this);
            if (bjr1.a == null)
            {
                throw new IllegalStateException("contextModule must be set");
            }
            if (bjr1.b == null)
            {
                bjr1.b = new bcl();
            }
            e = new bjq(bjr1);
            a = new bgv(this, e);
            b = e();
            d = b();
            f();
        }
    }
}
