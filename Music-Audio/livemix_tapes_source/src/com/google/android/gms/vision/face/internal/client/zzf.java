// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

// Referenced classes of package com.google.android.gms.vision.face.internal.client:
//            zzd, FaceSettingsParcel, zzc

class zzf extends zzg
{

    private static zzf zzaVU;

    zzf()
    {
        super("com.google.android.gms.vision.client.DynamiteNativeFaceDetectorCreator");
    }

    static zzc zza(Context context, FaceSettingsParcel facesettingsparcel)
    {
        if (zzaVU == null)
        {
            zzaVU = new zzf();
        }
        return zzaVU.zzb(context, facesettingsparcel);
    }

    private zzc zzb(Context context, FaceSettingsParcel facesettingsparcel)
    {
        try
        {
            com.google.android.gms.dynamic.zzd zzd1 = zze.zzx(context);
            context = ((zzd)zzar(context)).zza(zzd1, facesettingsparcel);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("FaceDetectorHandle", "Could not create native face detector", context);
            return null;
        }
        return context;
    }

    protected Object zzd(IBinder ibinder)
    {
        return zzdO(ibinder);
    }

    protected zzd zzdO(IBinder ibinder)
    {
        return com.google.android.gms.vision.face.internal.client.zzd.zza.zzdN(ibinder);
    }
}
