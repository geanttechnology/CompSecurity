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
//            zzv, zzu, CloseContentsAndUpdateMetadataRequest, zzbt, 
//            zzam

class lient extends a
{

    final zzv zzakU;
    final MetadataChangeSet zzakV;
    final ExecutionOptions zzakW;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzakV.zzqW().setContext(zzu1.getContext());
        zzu1.zzrm().zza(new CloseContentsAndUpdateMetadataRequest(zzv.zza(zzakU).getDriveId(), zzakV.zzqW(), zzv.zza(zzakU).getRequestId(), zzv.zza(zzakU).zzqM(), zzakW), new zzbt(this));
    }

    lient(zzv zzv1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, ExecutionOptions executionoptions)
    {
        zzakU = zzv1;
        zzakV = metadatachangeset;
        zzakW = executionoptions;
        super(googleapiclient);
    }
}
