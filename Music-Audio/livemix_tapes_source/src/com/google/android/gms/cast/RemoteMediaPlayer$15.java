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

    final RemoteMediaPlayer zzVb;
    final GoogleApiClient zzVc;
    final JSONObject zzVi;
    final int zzVs;
    final int zzVt;

    protected void zza(zze zze1)
    {
        boolean flag = false;
        zze1 = ((zze) (com.google.android.gms.cast.RemoteMediaPlayer.zze(zzVb)));
        zze1;
        JVM INSTR monitorenter ;
        int i = RemoteMediaPlayer.zza(zzVb, zzVs);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        zza(((com.google.android.gms.common.api.Result) (zzs(new Status(0)))));
        zze1;
        JVM INSTR monitorexit ;
        return;
        if (zzVt >= 0)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        zza(((com.google.android.gms.common.api.Result) (zzs(new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[] {
            Integer.valueOf(zzVt)
        }))))));
        zze1;
        JVM INSTR monitorexit ;
        return;
        Object obj;
        obj;
        zze1;
        JVM INSTR monitorexit ;
        throw obj;
        if (i != zzVt)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        zza(((com.google.android.gms.common.api.Result) (zzs(new Status(0)))));
        zze1;
        JVM INSTR monitorexit ;
        return;
        if (zzVt <= i) goto _L2; else goto _L1
_L1:
        i = zzVt + 1;
_L3:
        MediaQueueItem mediaqueueitem = zzVb.getMediaStatus().getQueueItem(i);
        i = ((flag) ? 1 : 0);
        if (mediaqueueitem == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        i = mediaqueueitem.getItemId();
        RemoteMediaPlayer.zzf(zzVb).zzb(zzVc);
        zzm zzm1 = RemoteMediaPlayer.zzg(zzVb);
        com.google.android.gms.cast.internal.zzo zzo = zzVC;
        int j = zzVs;
        JSONObject jsonobject = zzVi;
        zzm1.zza(zzo, new int[] {
            j
        }, i, jsonobject);
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
_L4:
        zze1;
        JVM INSTR monitorexit ;
        return;
_L2:
        i = zzVt;
          goto _L3
        zzm1;
        zza(((com.google.android.gms.common.api.Result) (zzs(new Status(2100)))));
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
          goto _L4
        zzm1;
        RemoteMediaPlayer.zzf(zzVb).zzb(null);
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
        zzVb = remotemediaplayer;
        zzVs = i;
        zzVt = j;
        zzVc = googleapiclient1;
        zzVi = jsonobject;
        super(googleapiclient);
    }
}
