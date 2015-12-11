// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.SystemClock;

public class cmh
{

    static final String a = cmh.getSimpleName();
    final cmk b = new cmk();
    ConnectivityManager c;
    private ciz d;
    private ciz e;

    public cmh(Context context)
    {
        d = ciz.c;
        e = ciz.c;
        c = (ConnectivityManager)context.getSystemService("connectivity");
    }

    public final void a(cio cio1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = cio1.f;
        obj = cio1.d;
        d = cio1.b;
        e = cio1.c;
        SystemClock.elapsedRealtime();
        cit cit1 = null;
        if (d != ciz.b) goto _L2; else goto _L1
_L1:
        cit1 = cio1.f.a;
_L4:
        cio1 = cit1.d();
        if (cio1[0] <= 0L)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        b.a(cio1[0], cio1[1]);
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (e != ciz.b) goto _L4; else goto _L3
_L3:
        cit1 = cio1.f.b;
          goto _L4
        cio1;
        throw cio1;
    }

}
