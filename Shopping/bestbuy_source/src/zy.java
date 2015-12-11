// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.internal.fj;
import com.google.android.gms.internal.gu;

public class zy
    implements Runnable
{

    protected final gu a;
    protected boolean b;
    protected boolean c;
    private final Handler d;
    private final long e;
    private long f;
    private acf g;
    private final int h;
    private final int i;

    public zy(acf acf1, gu gu1, int j, int k)
    {
        this(acf1, gu1, j, k, 200L, 50L);
    }

    public zy(acf acf1, gu gu1, int j, int k, long l, long l1)
    {
        e = l;
        f = l1;
        d = new Handler(Looper.getMainLooper());
        a = gu1;
        g = acf1;
        b = false;
        c = false;
        h = k;
        i = j;
    }

    static int a(zy zy1)
    {
        return zy1.i;
    }

    static int b(zy zy1)
    {
        return zy1.h;
    }

    static long c(zy zy1)
    {
        long l = zy1.f - 1L;
        zy1.f = l;
        return l;
    }

    static long d(zy zy1)
    {
        return zy1.f;
    }

    static acf e(zy zy1)
    {
        return zy1.g;
    }

    static long f(zy zy1)
    {
        return zy1.e;
    }

    static Handler g(zy zy1)
    {
        return zy1.d;
    }

    public void a()
    {
        d.postDelayed(this, e);
    }

    public void a(fj fj1)
    {
        a(fj1, new acj(this, a, fj1.q));
    }

    public void a(fj fj1, acj acj1)
    {
        a.setWebViewClient(acj1);
        gu gu1 = a;
        if (TextUtils.isEmpty(fj1.b))
        {
            acj1 = null;
        } else
        {
            acj1 = abq.a(fj1.b);
        }
        gu1.loadDataWithBaseURL(acj1, fj1.c, "text/html", "UTF-8", null);
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        b = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean c()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean d()
    {
        return c;
    }

    public void run()
    {
        if (a == null || c())
        {
            g.a(a);
            return;
        } else
        {
            (new zz(this, a)).execute(new Void[0]);
            return;
        }
    }
}
