// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, zzt, CloseContentsAndUpdateMetadataRequest, zzbr, 
//            zzal

class lient extends a
{

    final zzu zzaiG;
    final MetadataChangeSet zzaiH;
    final ExecutionOptions zzaiI;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzaiH.zzqp().setContext(zzt1.getContext());
        zzt1.zzqF().zza(new CloseContentsAndUpdateMetadataRequest(zzu.zza(zzaiG).getDriveId(), zzaiH.zzqp(), zzu.zza(zzaiG).getRequestId(), zzu.zza(zzaiG).zzqf(), zzaiI), new zzbr(this));
    }

    lient(zzu zzu1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, ExecutionOptions executionoptions)
    {
        zzaiG = zzu1;
        zzaiH = metadatachangeset;
        zzaiI = executionoptions;
        super(googleapiclient);
    }
}
