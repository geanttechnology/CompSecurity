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

final class zzSe
    implements Runnable
{

    final ImageManager zzSc;
    private final zza zzSe;

    public void run()
    {
        zzb.zzbI("LoadImageRunnable must be executed on the main thread");
        Object obj = (eReceiver)ImageManager.zza(zzSc).get(zzSe);
        if (obj != null)
        {
            ImageManager.zza(zzSc).remove(zzSe);
            ((eReceiver) (obj)).zzc(zzSe);
        }
        eReceiver ereceiver1 = zzSe.zzSg;
        if (ereceiver1.zzSe == null)
        {
            zzSe.zza(com.google.android.gms.common.images.ImageManager.zzb(zzSc), ImageManager.zzc(zzSc), true);
            return;
        }
        obj = ImageManager.zza(zzSc, ereceiver1);
        if (obj != null)
        {
            zzSe.zza(com.google.android.gms.common.images.ImageManager.zzb(zzSc), ((android.graphics.Bitmap) (obj)), true);
            return;
        }
        obj = (Long)ImageManager.zzd(zzSc).get(ereceiver1.zzSc);
        if (obj != null)
        {
            if (SystemClock.elapsedRealtime() - ((Long) (obj)).longValue() < 0x36ee80L)
            {
                zzSe.zza(com.google.android.gms.common.images.ImageManager.zzb(zzSc), ImageManager.zzc(zzSc), true);
                return;
            }
            ImageManager.zzd(zzSc).remove(ereceiver1.zzSc);
        }
        zzSe.zza(com.google.android.gms.common.images.ImageManager.zzb(zzSc), ImageManager.zzc(zzSc));
        eReceiver ereceiver = (eReceiver)ImageManager.zze(zzSc).get(ereceiver1.zzSc);
        obj = ereceiver;
        if (ereceiver == null)
        {
            obj = new eReceiver(zzSc, ereceiver1.zzSc);
            ImageManager.zze(zzSc).put(ereceiver1.zzSc, obj);
        }
        ((eReceiver) (obj)).zzb(zzSe);
        if (!(zzSe instanceof zzSe))
        {
            ImageManager.zza(zzSc).put(zzSe, obj);
        }
        synchronized (ImageManager.zzlx())
        {
            if (!ImageManager.zzly().contains(ereceiver1.))
            {
                ImageManager.zzly().add(ereceiver1.);
                ((eReceiver) (obj)).zzlz();
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
        zzSc = imagemanager;
        super();
        zzSe = zza1;
    }
}
