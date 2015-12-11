// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.purchase.zze;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzg;

// Referenced classes of package com.google.android.gms.internal:
//            zzfu, zzft

public final class zzfy extends zzg
{

    private static final zzfy zzDb = new zzfy();

    private zzfy()
    {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    private static boolean zzc(Activity activity)
        throws zza
    {
        activity = activity.getIntent();
    /* block-local class not found */
    class zza {}

        if (!activity.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar"))
        {
            throw new zza("InAppPurchaseManager requires the useClientJar flag in intent extras.");
        } else
        {
            return activity.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
        }
    }

    public static zzft zze(Activity activity)
    {
        try
        {
            if (zzc(activity))
            {
                zzb.zzaF("Using AdOverlay from the client jar.");
                return new zze(activity);
            }
            activity = zzDb.zzf(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            zzb.zzaH(activity.getMessage());
            return null;
        }
        return activity;
    }

    private zzft zzf(Activity activity)
    {
        try
        {
            com.google.android.gms.dynamic.zzd zzd1 = com.google.android.gms.dynamic.zze.zzy(activity);
            activity = zzft.zza.zzQ(((zzfu)zzas(activity)).zzf(zzd1));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            zzb.zzd("Could not create remote InAppPurchaseManager.", activity);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            zzb.zzd("Could not create remote InAppPurchaseManager.", activity);
            return null;
        }
        return activity;
    }

    protected zzfu zzU(IBinder ibinder)
    {
        return zzfu.zza.zzR(ibinder);
    }

    protected Object zzd(IBinder ibinder)
    {
        return zzU(ibinder);
    }

}
