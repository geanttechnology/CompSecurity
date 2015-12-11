// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzy, zzu, CreateFolderRequest, zzam

class lient extends f
{

    final MetadataChangeSet zzald;
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
        zzu1.zzrm().zza(new CreateFolderRequest(zzalh.getDriveId(), zzald.zzqW()), new b(this));
    }

    lient(zzy zzy1, GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        zzalh = zzy1;
        zzald = metadatachangeset;
        super(googleapiclient);
    }
}
