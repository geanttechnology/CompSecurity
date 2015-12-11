// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.n;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.dj;
import com.google.android.gms.d.dk;
import com.google.android.gms.d.o;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            g

public final class f extends g
{

    private dj f;
    private dk g;
    private final n h;
    private g i;
    private boolean j;
    private Object k;

    private f(Context context, n n1, o o)
    {
        super(context, n1, null, o, null, null, null);
        j = false;
        k = new Object();
        h = n1;
    }

    public f(Context context, n n1, o o, dj dj1)
    {
        this(context, n1, o);
        f = dj1;
    }

    public f(Context context, n n1, o o, dk dk1)
    {
        this(context, n1, o);
        g = dk1;
    }

    public final void a()
    {
        w.b("recordImpression must be called on the main UI thread.");
        Object obj = k;
        obj;
        JVM INSTR monitorenter ;
        super.e = true;
        if (i == null) goto _L2; else goto _L1
_L1:
        i.a();
_L5:
        h.q();
        return;
_L2:
        if (f == null || f.k()) goto _L4; else goto _L3
_L3:
        f.i();
          goto _L5
        Object obj1;
        obj1;
        b.a(5);
          goto _L5
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
_L4:
        if (g == null || g.i()) goto _L5; else goto _L6
_L6:
        g.g();
          goto _L5
    }
}
