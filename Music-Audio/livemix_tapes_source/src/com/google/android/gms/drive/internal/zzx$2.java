// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzx, zzt, CreateFolderRequest, zzal

class lient extends f
{

    final MetadataChangeSet zzaiP;
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
        zzt1.zzqF().zza(new CreateFolderRequest(zzaiT.getDriveId(), zzaiP.zzqp()), new b(this));
    }

    lient(zzx zzx1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        zzaiT = zzx1;
        zzaiP = metadatachangeset;
        super(googleapiclient);
    }
}
