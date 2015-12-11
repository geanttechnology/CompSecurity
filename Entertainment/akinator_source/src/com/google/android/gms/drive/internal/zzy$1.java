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
//            zzy, zzu, CreateFileRequest, zzam

class lient extends d
{

    final MetadataChangeSet zzald;
    final int zzale;
    final int zzalf;
    final ExecutionOptions zzalg;
    final zzy zzalh;

    protected volatile void zza(com.google.android.gms.common.api.b b)
        throws RemoteException
    {
        zza((zzu)b);
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzald.zzqW().setContext(zzu1.getContext());
        CreateFileRequest createfilerequest = new CreateFileRequest(zzalh.getDriveId(), zzald.zzqW(), zzale, zzalf, zzalg);
        zzu1.zzrm().zza(createfilerequest, new a(this));
    }

    lient(zzy zzy1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, int i, int j, ExecutionOptions executionoptions)
    {
        zzalh = zzy1;
        zzald = metadatachangeset;
        zzale = i;
        zzalf = j;
        zzalg = executionoptions;
        super(googleapiclient);
    }
}
