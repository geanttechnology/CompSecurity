// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzaa, zzt, UpdateMetadataRequest, zzal

class ient extends d
{

    final MetadataChangeSet zzaiP;
    final zzaa zzajb;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzt));
    }

    protected void zza(zzt zzt1)
        throws RemoteException
    {
        zzaiP.zzqp().setContext(zzt1.getContext());
        zzt1.zzqF().zza(new UpdateMetadataRequest(zzajb.zzags, zzaiP.zzqp()), new b(this));
    }

    ient(zzaa zzaa1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        zzajb = zzaa1;
        zzaiP = metadatachangeset;
        super(zzaa1, googleapiclient, null);
    }
}
