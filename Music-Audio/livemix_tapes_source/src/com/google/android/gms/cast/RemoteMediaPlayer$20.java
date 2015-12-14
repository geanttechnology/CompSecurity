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

class  extends 
{

    final RemoteMediaPlayer zzVb;
    final GoogleApiClient zzVc;
    final JSONObject zzVi;
    final double zzVw;

    protected void zza(zze zze1)
    {
        zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
        zze1;
        JVM INSTR monitorenter ;
        RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
        RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVw, zzVi);
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
        zze1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
_L2:
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
        obj;
          goto _L2
        obj;
          goto _L2
    }

    protected volatile void zza(com.google.android.gms.common.api.> >)
        throws RemoteException
    {
        zza((zze)>);
    }

    (RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, GoogleApiClient googleapiclient1, double d, JSONObject jsonobject)
    {
        zzVb = remotemediaplayer;
        zzVc = googleapiclient1;
        zzVw = d;
        zzVi = jsonobject;
        super(googleapiclient);
    }
}
