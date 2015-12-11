// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            zzp

class <init>
    implements Runnable
{

    final zzp zzaHK;

    public void run()
    {
        synchronized (zzp.zzb(zzaHK))
        {
            Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
            intent.setPackage("com.google.android.gms");
            intent.putStringArrayListExtra("PLACE_IDS", zzp.zzc(zzaHK));
            intent.putStringArrayListExtra("METHOD_NAMES", zzp.zzd(zzaHK));
            intent.putExtra("PACKAGE_NAME", zzp.zze(zzaHK).getPackageName());
            intent.putExtra("CLIENT_VERSION", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            zzp.zze(zzaHK).sendBroadcast(intent);
            zzp.zza(zzaHK, null);
            zzp.zzb(zzaHK, null);
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private (zzp zzp1)
    {
        zzaHK = zzp1;
        super();
    }

    zzaHK(zzp zzp1, zzaHK zzahk)
    {
        this(zzp1);
    }
}
