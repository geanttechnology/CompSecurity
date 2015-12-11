// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;

// Referenced classes of package com.google.android.gms.common.internal:
//            l

protected final class e extends e
{

    public final IBinder e;
    final l f;

    protected void a(ConnectionResult connectionresult)
    {
        if (com.google.android.gms.common.internal.l.e(f) != null)
        {
            com.google.android.gms.common.internal.l.e(f).a(connectionresult);
        }
        f.a(connectionresult);
    }

    protected boolean a()
    {
        String s;
        try
        {
            s = e.getInterfaceDescriptor();
        }
        catch (RemoteException remoteexception)
        {
            Log.w("GmsClient", "service probably died");
            return false;
        }
        if (!f.e().equals(s))
        {
            Log.e("GmsClient", (new StringBuilder()).append("service descriptor mismatch: ").append(f.e()).append(" vs. ").append(s).toString());
        } else
        {
            android.os.IInterface iinterface = f.a(e);
            if (iinterface != null && l.a(f, 2, 3, iinterface))
            {
                Bundle bundle = f.c_();
                if (l.b(f) != null)
                {
                    l.b(f).a(bundle);
                }
                com.google.android.gms.common.e.c(l.f(f));
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
