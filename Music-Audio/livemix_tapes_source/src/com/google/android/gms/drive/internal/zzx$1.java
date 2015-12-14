// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzx, zzt, CreateFileRequest, zzal

class lient extends d
{

    final MetadataChangeSet zzaiP;
    final int zzaiQ;
    final int zzaiR;
    final ExecutionOptions zzaiS;
    final zzx zzaiT;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzt)b);
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzaiP.zzqp().setContext(zzt1.getContext());
        CreateFileRequest createfilerequest = new CreateFileRequest(zzaiT.getDriveId(), zzaiP.zzqp(), zzaiQ, zzaiR, zzaiS);
        zzt1.zzqF().zza(createfilerequest, new a(this));
    }

    lient(zzx zzx1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, int i, int j, ExecutionOptions executionoptions)
    {
        zzaiT = zzx1;
        zzaiP = metadatachangeset;
        zzaiQ = i;
        zzaiR = j;
        zzaiS = executionoptions;
        super(googleapiclient);
    }
}
