// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.common.internal:
//            l

protected final class e extends e
{

    public final IBinder e;
    final l f;

    protected final void a(ConnectionResult connectionresult)
    {
        if (l.e(f) != null)
        {
            l.e(f).a(connectionresult);
        }
        l.h();
    }

    protected final boolean a()
    {
        String s;
        try
        {
            s = e.getInterfaceDescriptor();
        }
        catch (RemoteException remoteexception)
        {
            return false;
        }
        if (!f.b().equals(s))
        {
            Log.e("GmsClient", (new StringBuilder("service descriptor mismatch: ")).append(f.b()).append(" vs. ").append(s).toString());
        } else
        {
            android.os.IInterface iinterface = f.a(e);
            if (iinterface != null && l.a(f, 2, 3, iinterface))
            {
                if (l.b(f) != null)
                {
                    l.b(f).a(null);
                }
                return true;
            }
        }
        return false;
    }

    public ult(l l1, int i, IBinder ibinder, Bundle bundle)
    {
        f = l1;
        super(l1, i, bundle);
        e = ibinder;
    }
}
