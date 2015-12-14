// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.internal.zzo;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzkd

class zzWe
    implements com.google.android.gms.cast.ageReceivedCallback
{

    final  zzWe;

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        zzWe.Wd.zzbJ(s1);
    }

    agerClient(agerClient agerclient)
    {
        zzWe = agerclient;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzkd$1

/* anonymous class */
    class zzkd._cls1 extends zzkd.zzc
    {

        final zzkd zzWd;

        public void execute()
        {
            zzkd.zzc(zzWd).setMessageReceivedCallbacks(zzkd.zzb(zzWd), zzWd.getNamespace(), new zzkd._cls1._cls1(this));
            zzkd.zzd(zzWd);
            zzkd.zze(zzWd);
            zzkd.zza(zzWd, null, 1100, null, zzmk());
            return;
            Object obj;
            obj;
_L2:
            zzmk().zza(-1L, 8, null);
            return;
            obj;
            if (true) goto _L2; else goto _L1
_L1:
        }

            
            {
                zzWd = zzkd1;
                super(zzkd1, gamemanagerclient);
            }
    }

}
