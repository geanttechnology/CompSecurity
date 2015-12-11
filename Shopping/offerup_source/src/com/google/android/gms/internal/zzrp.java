// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

// Referenced classes of package com.google.android.gms.internal:
//            zzrk, zzri, zzrh

public class zzrp extends zzg
{

    private static zzrp zzbeB;

    protected zzrp()
    {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzrp zzEH()
    {
        if (zzbeB == null)
        {
            zzbeB = new zzrp();
        }
        return zzbeB;
    }

    public static zzrh zza(Activity activity, zzc zzc, WalletFragmentOptions walletfragmentoptions, zzri zzri)
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (i != 0)
        {
            throw new GooglePlayServicesNotAvailableException(i);
        }
        try
        {
            activity = ((zzrk)zzEH().zzas(activity)).zza(zze.zzy(activity), zzc, walletfragmentoptions, zzri);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new RuntimeException(activity);
        }
        return activity;
    }

    protected Object zzd(IBinder ibinder)
    {
        return zzec(ibinder);
    }

    protected zzrk zzec(IBinder ibinder)
    {
        return zzrk.zza.zzdY(ibinder);
    }
}
