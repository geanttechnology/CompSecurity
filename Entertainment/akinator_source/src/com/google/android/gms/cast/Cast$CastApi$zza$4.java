// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.common.api.GoogleApiClient;

// Referenced classes of package com.google.android.gms.cast:
//            Cast, JoinOptions

class nt extends nt
{

    final String val$sessionId;
    final zza zzUR;
    final String zzUS;
    final JoinOptions zzUU;

    protected void zza(zze zze1)
        throws RemoteException
    {
        try
        {
            zze1.zza(zzUS, val$sessionId, zzUU, this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zze zze1)
        {
            zzba(2001);
        }
    }

    protected volatile void zza(com.google.android.gms.common.api.ssionId ssionid)
        throws RemoteException
    {
        zza((zze)ssionid);
    }

    nt(GoogleApiClient googleapiclient, String s, String s1, JoinOptions joinoptions)
    {
        zzUR = final_nt;
        zzUS = s;
        val$sessionId = s1;
        zzUU = joinoptions;
        super(googleapiclient);
    }
}
