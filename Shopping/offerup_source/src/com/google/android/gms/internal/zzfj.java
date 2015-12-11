// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

// Referenced classes of package com.google.android.gms.internal:
//            zzfl, zzfk

public final class zzfj extends zzg
{

    private static final zzfj zzCp = new zzfj();

    private zzfj()
    {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public static zzfk zzb(Activity activity)
    {
        try
        {
            if (zzc(activity))
            {
                com.google.android.gms.ads.internal.util.client.zzb.zzaF("Using AdOverlay from the client jar.");
                return new zzd(activity);
            }
            activity = zzCp.zzd(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzaH(activity.getMessage());
            return null;
        }
        return activity;
    }

    private static boolean zzc(Activity activity)
    {
        activity = activity.getIntent();
        if (!activity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar"))
        {
            throw new zza("Ad overlay requires the useClientJar flag in intent extras.");
        } else
        {
            return activity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
    }

    private zzfk zzd(Activity activity)
    {
        try
        {
            com.google.android.gms.dynamic.zzd zzd1 = zze.zzy(activity);
            activity = zzfk.zza.zzL(((zzfl)zzas(activity)).zze(zzd1));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not create remote AdOverlay.", activity);
            return null;
        }
        return activity;
    }

    protected final zzfl zzK(IBinder ibinder)
    {
        return zzfl.zza.zzM(ibinder);
    }

    protected final Object zzd(IBinder ibinder)
    {
        return zzK(ibinder);
    }


    private class zza extends Exception
    {

        public zza(String s)
        {
            super(s);
        }
    }

}
