// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.c;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.bs;

// Referenced classes of package com.google.android.gms.ads.internal:
//            n, q

final class a
    implements Runnable
{

    final c a;
    final n b;

    public final void run()
    {
        try
        {
            b.c.s.a(a);
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    ats.c(n n1, c c)
    {
        b = n1;
        a = c;
        super();
    }
}
