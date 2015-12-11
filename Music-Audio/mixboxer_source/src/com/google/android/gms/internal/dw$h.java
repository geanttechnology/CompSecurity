// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.internal:
//            dw, dy, dx

protected final class pq extends pq
{

    final dw pl;
    public final Bundle pq;
    public final IBinder pr;
    public final int statusCode;

    protected void aL()
    {
    }

    protected void b(Boolean boolean1)
    {
        if (boolean1 == null)
        {
            return;
        }
        switch (statusCode)
        {
        default:
            if (pq != null)
            {
                boolean1 = (PendingIntent)pq.getParcelable("pendingIntent");
            } else
            {
                boolean1 = null;
            }
            if (dw.e(pl) != null)
            {
                dy.s(dw.f(pl)).b(pl.am(), dw.e(pl));
                dw.a(pl, null);
            }
            dw.a(pl, null);
            dw.a(pl).a(new ConnectionResult(statusCode, boolean1));
            return;

        case 0: // '\0'
            try
            {
                boolean1 = pr.getInterfaceDescriptor();
                if (pl.an().equals(boolean1))
                {
                    dw.a(pl, pl.p(pr));
                    if (dw.d(pl) != null)
                    {
                        dw.a(pl).bT();
                        return;
                    }
                }
            }
            // Misplaced declaration of an exception variable
            catch (Boolean boolean1) { }
            dy.s(dw.f(pl)).b(pl.am(), dw.e(pl));
            dw.a(pl, null);
            dw.a(pl, null);
            dw.a(pl).a(new ConnectionResult(8, null));
            return;

        case 10: // '\n'
            throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
        }
    }

    protected volatile void b(Object obj)
    {
        b((Boolean)obj);
    }

    public ionResult(dw dw1, int i, IBinder ibinder, Bundle bundle)
    {
        pl = dw1;
        super(dw1, Boolean.valueOf(true));
        statusCode = i;
        pr = ibinder;
        pq = bundle;
    }
}
