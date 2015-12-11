// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzab, zzu, UpdateMetadataRequest, zzam

class ient extends d
{

    final MetadataChangeSet zzald;
    final zzab zzalp;

    protected volatile void zza(com.google.android.gms.common.api. )
        throws RemoteException
    {
        zza((zzu));
    }

    protected void zza(zzu zzu1)
        throws RemoteException
    {
        zzald.zzqW().setContext(zzu1.getContext());
        zzu1.zzrm().zza(new UpdateMetadataRequest(zzalp.zzaiA, zzald.zzqW()), new b(this));
    }

    ient(zzab zzab1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        zzalp = zzab1;
        zzald = metadatachangeset;
        super(zzab1, googleapiclient, null);
    }
}
