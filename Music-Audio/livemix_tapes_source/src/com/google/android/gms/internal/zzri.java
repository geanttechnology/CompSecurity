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
//            zzrd, zzrb, zzra

public class zzri extends zzg
{

    private static zzri zzaYt;

    protected zzri()
    {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzri zzCm()
    {
        if (zzaYt == null)
        {
            zzaYt = new zzri();
        }
        return zzaYt;
    }

    public static zzra zza(Activity activity, zzc zzc, WalletFragmentOptions walletfragmentoptions, zzrb zzrb)
        throws GooglePlayServicesNotAvailableException
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (i != 0)
        {
            throw new GooglePlayServicesNotAvailableException(i);
        }
        try
        {
            activity = ((zzrd)zzCm().zzar(activity)).zza(zze.zzx(activity), zzc, walletfragmentoptions, zzrb);
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
        return zzdW(ibinder);
    }

    protected zzrd zzdW(IBinder ibinder)
    {
        return zzrd.zza.zzdS(ibinder);
    }
}
