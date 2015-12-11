// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.images;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzb;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.google.android.gms.common.images:
//            ImageManager, zza

final class zzadT
    implements Runnable
{

    final ImageManager zzadR;
    private final zza zzadT;

    public final void run()
    {
        zzb.zzci("LoadImageRunnable must be executed on the main thread");
        Object obj = (eReceiver)ImageManager.zza(zzadR).get(zzadT);
        if (obj != null)
        {
            ImageManager.zza(zzadR).remove(zzadT);
            ((eReceiver) (obj)).zzc(zzadT);
        }
        eReceiver ereceiver1 = zzadT.zzadV;
        if (ereceiver1.zzadT == null)
        {
            zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), true);
            return;
        }
        obj = ImageManager.zza(zzadR, ereceiver1);
        if (obj != null)
        {
            zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ((android.graphics.Bitmap) (obj)), true);
            return;
        }
        obj = (Long)ImageManager.zzd(zzadR).get(ereceiver1.zzadR);
        if (obj != null)
        {
            if (SystemClock.elapsedRealtime() - ((Long) (obj)).longValue() < 0x36ee80L)
            {
                zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR), true);
                return;
            }
            ImageManager.zzd(zzadR).remove(ereceiver1.zzadR);
        }
        zzadT.zza(com.google.android.gms.common.images.ImageManager.zzb(zzadR), ImageManager.zzc(zzadR));
        eReceiver ereceiver = (eReceiver)ImageManager.zze(zzadR).get(ereceiver1.zzadR);
        obj = ereceiver;
        if (ereceiver == null)
        {
            obj = new eReceiver(zzadR, ereceiver1.zzadR);
            ImageManager.zze(zzadR).put(ereceiver1.zzadR, obj);
        }
        ((eReceiver) (obj)).zzb(zzadT);
        if (!(zzadT instanceof zzadT))
        {
            ImageManager.zza(zzadR).put(zzadT, obj);
        }
        synchronized (ImageManager.zzoC())
        {
            if (!ImageManager.zzoD().contains(ereceiver1.))
            {
                ImageManager.zzoD().add(ereceiver1.);
                ((eReceiver) (obj)).zzoE();
            }
        }
        return;
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public eReceiver(ImageManager imagemanager, zza zza1)
    {
        zzadR = imagemanager;
        super();
        zzadT = zza1;
    }
}
