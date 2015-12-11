// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, RemoveEventListenerRequest, zzbt, zzam, 
//            zzae

class lient extends a
{

    final DriveId zzakL;
    final int zzakM;
    final zzae zzakO;
    final zzu zzakP;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzu1.zzrm().zza(new RemoveEventListenerRequest(zzakL, zzakM), zzakO, null, new zzbt(this));
    }

    lient(zzu zzu1, GoogleApiClient googleapiclient, DriveId driveid, int i, zzae zzae)
    {
        zzakP = zzu1;
        zzakL = driveid;
        zzakM = i;
        zzakO = zzae;
        super(googleapiclient);
    }
}
