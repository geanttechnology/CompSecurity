// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzd, zzs, OnDriveIdResponse, zzp, 
//            OnMetadataResponse

static class zzagy extends zzd
{

    private final com.google.android.gms.internal. zzagy;

    public void zza(OnDriveIdResponse ondriveidresponse)
        throws RemoteException
    {
        zzagy.zzp(new <init>(Status.zzabb, ondriveidresponse.getDriveId()));
    }

    public void zza(OnMetadataResponse onmetadataresponse)
        throws RemoteException
    {
        zzagy.zzp(new <init>(Status.zzabb, (new zzp(onmetadataresponse.zzrE())).getDriveId()));
    }

    public void zzy(Status status)
        throws RemoteException
    {
        zzagy.zzp(new <init>(status, null));
    }

    public taResponse(com.google.android.gms.internal. )
    {
        zzagy = ;
    }
}
