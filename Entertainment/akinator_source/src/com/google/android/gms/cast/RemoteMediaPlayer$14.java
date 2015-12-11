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

    final RemoteMediaPlayer zzWS;
    final GoogleApiClient zzWT;
    final JSONObject zzXa;
    final int zzXk;

    protected void zza(zze zze1)
    {
label0:
        {
            synchronized (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS))
            {
                if (RemoteMediaPlayer.zza(zzWS, zzXk) != -1)
                {
                    break label0;
                }
                zzb(zzp(new Status(0)));
            }
            return;
        }
        RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
        zzm zzm1 = RemoteMediaPlayer.zzg(zzWS);
        com.google.android.gms.cast.internal.zzo zzo = zzXu;
        int i = zzXk;
        JSONObject jsonobject = zzXa;
        zzm1.zza(zzo, new int[] {
            i
        }, jsonobject);
        RemoteMediaPlayer.zzf(zzWS).zza(null);
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
        zzb(zzp(new Status(2100)));
        RemoteMediaPlayer.zzf(zzWS).zza(null);
          goto _L1
        obj;
        RemoteMediaPlayer.zzf(zzWS).zza(null);
        throw obj;
    }

    protected volatile void zza(com.google.android.gms.common.api.> >)
        throws RemoteException
    {
        zza((zze)>);
    }

    (RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, int i, GoogleApiClient googleapiclient1, JSONObject jsonobject)
    {
        zzWS = remotemediaplayer;
        zzXk = i;
        zzWT = googleapiclient1;
        zzXa = jsonobject;
        super(googleapiclient);
    }
}
