// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzv, zzu, OpenContentsRequest, zzbl, 
//            zzam

class lient extends b
{

    final zzv zzakU;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzu1.zzrm().zza(new OpenContentsRequest(zzakU.getDriveId(), 0x20000000, zzv.zza(zzakU).getRequestId()), new zzbl(this, null));
    }

    lient(zzv zzv1, GoogleApiClient googleapiclient)
    {
        zzakU = zzv1;
        super(googleapiclient);
    }
}
