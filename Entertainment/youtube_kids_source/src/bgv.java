// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.telephony.TelephonyManager;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.client.HttpClient;

public final class bgv
{

    final bjt a;
    public final Context b;
    public final bmr c = new bgw(this);
    public final bmr d = new bhn(this);
    public final bmr e = new bho(this);
    public final bmr f = new bhq(this);
    public final bmr g = new bha(this);
    public final bmr h = new bhj(this);
    public final bmr i = new bhk(this);
    public final bmr j = new bhl(this);
    private final bmr k = new bhh(this);
    private final bmr l = new bhm(this);
    private final bmr m = new bhp(this);
    private final bmr n = new bhr(this);
    private final bmr o = new bhs(this);
    private final bmr p = new bgx(this);
    private final bmr q = new bgy(this);
    private final bmr r = new bgz(this);
    private final bmr s = new bhb(this);
    private final bmr t = new bhc(this);
    private final bmr u = new bhd(this);
    private final bmr v = new bhe(this);
    private final bmr w = new bhf(this);
    private final bmr x = new bhg(this);
    private final bmr y = new bhi(this);

    public bgv(Context context, bjt bjt1)
    {
        b = (Context)b.a(context);
        a = (bjt)b.a(bjt1);
    }

    static ExecutorService a(int i1, int j1, int k1)
    {
        return new ThreadPoolExecutor(i1, i1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new bmu(k1));
    }

    public final String a()
    {
        return (String)k.b_();
    }

    public final bmi b()
    {
        return (bmi)l.b_();
    }

    public final ExecutorService c()
    {
        return (ExecutorService)m.b_();
    }

    public final bje d()
    {
        return (bje)n.b_();
    }

    public final bml e()
    {
        return (bml)o.b_();
    }

    public final bmw f()
    {
        return (bmw)p.b_();
    }

    public final HttpClient g()
    {
        return (HttpClient)q.b_();
    }

    public final bkn h()
    {
        return (bkn)r.b_();
    }

    public final SharedPreferences i()
    {
        return (SharedPreferences)x.b_();
    }

    public final blf j()
    {
        return (blf)s.b_();
    }

    public final TelephonyManager k()
    {
        return (TelephonyManager)y.b_();
    }

    public final Handler l()
    {
        return (Handler)u.b_();
    }

    public final Executor m()
    {
        return (Executor)t.b_();
    }

    public final String n()
    {
        return (String)v.b_();
    }

    public final bmh o()
    {
        return (bmh)w.b_();
    }

    public final File p()
    {
        File file1 = b.getCacheDir();
        File file = file1;
        if (file1 == null)
        {
            file = b.getExternalCacheDir();
        }
        return file;
    }
}
