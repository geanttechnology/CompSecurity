// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.internal.zzo;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.internal:
//            zzko

class zzXW
    implements com.google.android.gms.cast.ageReceivedCallback
{

    final  zzXW;

    public void onMessageReceived(CastDevice castdevice, String s, String s1)
    {
        zzXW.XV.zzbK(s1);
    }

    agerClient(agerClient agerclient)
    {
        zzXW = agerclient;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzko$1

/* anonymous class */
    class zzko._cls1 extends zzko.zzc
    {

        final zzko zzXV;

        public void execute()
        {
            zzko.zzc(zzXV).setMessageReceivedCallbacks(zzko.zzb(zzXV), zzXV.getNamespace(), new zzko._cls1._cls1(this));
            zzko.zzd(zzXV);
            zzko.zze(zzXV);
            zzko.zza(zzXV, null, 1100, null, zzmG());
            return;
            Object obj;
            obj;
_L2:
            zzmG().zza(-1L, 8, null);
            return;
            obj;
            if (true) goto _L2; else goto _L1
_L1:
        }

            
            {
                zzXV = zzko1;
                super(zzko1, gamemanagerclient);
            }
    }

}
