// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.b;

// Referenced classes of package com.google.android.gms.d:
//            ds, dt, di

final class a
    implements Runnable
{

    final com.google.ads.uest.ErrorCode a;
    final ds b;

    public final void run()
    {
        try
        {
            ds.a(b).a(dt.a(a));
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    Code(ds ds1, com.google.ads.uest.ErrorCode errorcode)
    {
        b = ds1;
        a = errorcode;
        super();
    }
}
