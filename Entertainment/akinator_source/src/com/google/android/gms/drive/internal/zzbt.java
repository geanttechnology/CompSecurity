// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzd

public class zzbt extends zzd
{

    private final com.google.android.gms.internal.zzlb.zzb zzagy;

    public zzbt(com.google.android.gms.internal.zzlb.zzb zzb)
    {
        zzagy = zzb;
    }

    public void onSuccess()
        throws RemoteException
    {
        zzagy.zzp(Status.zzabb);
    }

    public void zzy(Status status)
        throws RemoteException
    {
        zzagy.zzp(status);
    }
}
