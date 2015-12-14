// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer

class t extends b
{

    final RemoteMediaPlayer zzVb;
    final GoogleApiClient zzVc;
    final JSONObject zzVi;

    protected void zza(zze zze1)
    {
        zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
        zze1;
        JVM INSTR monitorenter ;
        RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
        RemoteMediaPlayer.zzg(zzVb).zza(zzVC, 0, null, -1, null, zzVi);
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
        zze1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        zza(((com.google.android.gms.common.api.Result) (zzs(new Status(2100)))));
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
          goto _L1
        obj;
        zze1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
        throw obj;
    }

    protected volatile void zza(com.google.android.gms.common.api.t> t>)
        throws RemoteException
    {
        zza((zze)t>);
    }

    t(RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, GoogleApiClient googleapiclient1, JSONObject jsonobject)
    {
        zzVb = remotemediaplayer;
        zzVc = googleapiclient1;
        zzVi = jsonobject;
        super(googleapiclient);
    }
}
