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
//            RemoteMediaPlayer, MediaQueueItem

class t extends b
{

    final RemoteMediaPlayer zzWS;
    final GoogleApiClient zzWT;
    final JSONObject zzXa;
    final MediaQueueItem zzXb[];
    final int zzXc;

    protected void zza(zze zze1)
    {
        zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
        zze1;
        JVM INSTR monitorenter ;
        RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
        RemoteMediaPlayer.zzg(zzWS).zza(zzXu, zzXb, zzXc, 0, -1, -1L, zzXa);
        RemoteMediaPlayer.zzf(zzWS).zza(null);
_L1:
        zze1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        zzb(zzp(new Status(2100)));
        RemoteMediaPlayer.zzf(zzWS).zza(null);
          goto _L1
        obj;
        zze1;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        RemoteMediaPlayer.zzf(zzWS).zza(null);
        throw obj;
    }

    protected volatile void zza(com.google.android.gms.common.api.t> t>)
        throws RemoteException
    {
        zza((zze)t>);
    }

    t(RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, GoogleApiClient googleapiclient1, MediaQueueItem amediaqueueitem[], int i, JSONObject jsonobject)
    {
        zzWS = remotemediaplayer;
        zzWT = googleapiclient1;
        zzXb = amediaqueueitem;
        zzXc = i;
        zzXa = jsonobject;
        super(googleapiclient);
    }
}
