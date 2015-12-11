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
import java.util.Locale;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.cast:
//            RemoteMediaPlayer, MediaStatus, MediaQueueItem

class  extends 
{

    final RemoteMediaPlayer zzWS;
    final GoogleApiClient zzWT;
    final JSONObject zzXa;
    final int zzXk;
    final int zzXl;

    protected void zza(zze zze1)
    {
        boolean flag = false;
        zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzWS)));
        zze1;
        JVM INSTR monitorenter ;
        int i = RemoteMediaPlayer.zza(zzWS, zzXk);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        zzb(zzp(new Status(0)));
        zze1;
        JVM INSTR monitorexit ;
        return;
        if (zzXl >= 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        zzb(zzp(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[] {
            Integer.valueOf(zzXl)
        }))));
        zze1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        zze1;
        JVM INSTR monitorexit ;
        throw obj;
        if (i != zzXl)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        zzb(zzp(new Status(0)));
        zze1;
        JVM INSTR monitorexit ;
        return;
        if (zzXl <= i) goto _L2; else goto _L1
_L1:
        i = zzXl + 1;
_L3:
        MediaQueueItem mediaqueueitem = zzWS.getMediaStatus().getQueueItem(i);
        i = ((flag) ? 1 : 0);
        if (mediaqueueitem == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        i = mediaqueueitem.getItemId();
        RemoteMediaPlayer.zzf(zzWS).zza(zzWT);
        zzm zzm1 = RemoteMediaPlayer.zzg(zzWS);
        com.google.android.gms.cast.internal.zzo zzo = zzXu;
        int j = zzXk;
        JSONObject jsonobject = zzXa;
        zzm1.zza(zzo, new int[] {
            j
        }, i, jsonobject);
        RemoteMediaPlayer.zzf(zzWS).zza(null);
_L4:
        zze1;
        JVM INSTR monitorexit ;
        return;
_L2:
        i = zzXl;
          goto _L3
        zzm1;
        zzb(zzp(new Status(2100)));
        RemoteMediaPlayer.zzf(zzWS).zza(null);
          goto _L4
        zzm1;
        RemoteMediaPlayer.zzf(zzWS).zza(null);
        throw zzm1;
          goto _L3
    }

    protected volatile void zza(com.google.android.gms.common.api.tatus tatus)
        throws RemoteException
    {
        zza((zze)tatus);
    }

    (RemoteMediaPlayer remotemediaplayer, GoogleApiClient googleapiclient, int i, int j, GoogleApiClient googleapiclient1, JSONObject jsonobject)
    {
        zzWS = remotemediaplayer;
        zzXk = i;
        zzXl = j;
        zzWT = googleapiclient1;
        zzXa = jsonobject;
        super(googleapiclient);
    }
}
