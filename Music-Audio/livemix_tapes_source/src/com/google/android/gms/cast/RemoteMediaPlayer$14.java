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
    final int zzVs;

    protected void zza(zze zze1)
    {
label0:
        {
            synchronized (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb))
            {
                if (RemoteMediaPlayer.zza(zzVb, zzVs) != -1)
                {
                    break label0;
                }
                zza(((com.google.android.gms.common.api.Result) (zzs(new Status(0)))));
            }
            return;
        }
        RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
        RemoteMediaPlayer.zzg(zzVb).zza(zzVC, zzVs, null, 0, null, zzVi);
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L1:
        zze1;
        JVM INSTR monitorexit ;
        return;
        exception;
        zze1;
        JVM INSTR monitorexit ;
        throw exception;
        Object obj;
        obj;
        zza(((com.google.android.gms.common.api.Result) (zzs(new Status(2100)))));
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
          goto _L1
        obj;
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
        throw obj;
    }

    protected volatile void zza(com.google.android.gms.common.api.> >)
        throws RemoteException
    {
        zza((zze)>);
    }

    (RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, int i, GoogleApiClient googleapiclient1, JSONObject jsonobject)
    {
        zzVb = remotemediaplayer;
        zzVs = i;
        zzVc = googleapiclient1;
        zzVi = jsonobject;
        super(googleapiclient);
    }
}
