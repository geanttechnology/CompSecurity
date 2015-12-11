// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;

public final class pf
    implements cmz, cwv
{

    public final String a;
    public final Context b;
    public final bmi c;
    final asa d;
    final asa e;
    public final cxe f;
    public long g;
    public boolean h;
    private long i;
    private volatile long j;
    private volatile int k;

    pf(Context context, bmi bmi1, asa asa1, asa asa2, cxe cxe1, String s)
    {
        g = -1L;
        h = false;
        b = context;
        c = bmi1;
        d = asa1;
        e = asa2;
        f = cxe1;
        a = s;
        i = bmi1.a() + 30000L;
    }

    private void a(boolean flag)
    {
        long l = c.a();
        if (j > 0L && (flag || l > i))
        {
            if (k > 2000)
            {
                Bundle bundle = new Bundle();
                bundle.putString("cpn", a);
                bundle.putString("bytes_transferred", Long.toString(j));
                bundle.putString("time_window_millis", Long.toString(k));
                if (k == 0)
                {
                    long l1 = j;
                    bmo.c((new StringBuilder(66)).append("bandwidthElapsed is zero.  bandwidthBytes is: ").append(l1).toString());
                } else
                {
                    long l2 = (j * 1000L) / (long)k;
                    f.a(b, null, Long.valueOf(l2), null, null, bundle);
                }
            }
            i = 30000L + l;
            j = 0L;
            k = 0;
        }
    }

    public final void a()
    {
        a(true);
        g = -1L;
    }

    public final void a(int l, long l1, long l2)
    {
        this;
        JVM INSTR monitorenter ;
        j = j + l1;
        k = k + l;
        a(false);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final void b()
    {
        d.b(this);
        e.b(this);
        a(true);
    }
}
