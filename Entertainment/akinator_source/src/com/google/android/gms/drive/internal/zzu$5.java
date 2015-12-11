// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, CancelPendingActionsRequest, zzbt, zzam

class lient extends a
{

    final zzu zzakP;
    final List zzakQ;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzu1.zzrm().zza(new CancelPendingActionsRequest(zzakQ), new zzbt(this));
    }

    lient(zzu zzu1, GoogleApiClient googleapiclient, List list)
    {
        zzakP = zzu1;
        zzakQ = list;
        super(googleapiclient);
    }
}
