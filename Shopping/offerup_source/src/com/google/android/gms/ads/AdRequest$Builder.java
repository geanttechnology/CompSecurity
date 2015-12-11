// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.common.internal.zzx;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest

public final class D_EMULATOR
{

    private final com.google.android.gms.ads.internal.client. zznP = new com.google.android.gms.ads.internal.client.();

    static com.google.android.gms.ads.internal.client. zza(D_EMULATOR d_emulator)
    {
        return d_emulator.zznP;
    }

    public final zznP addCustomEventExtrasBundle(Class class1, Bundle bundle)
    {
        zznP.(class1, bundle);
        return this;
    }

    public final y.zza.zzb addKeyword(String s)
    {
        zznP.(s);
        return this;
    }

    public final xtras addNetworkExtras(NetworkExtras networkextras)
    {
        zznP.(networkextras);
        return this;
    }

    public final xtras addNetworkExtrasBundle(Class class1, Bundle bundle)
    {
        zznP.(class1, bundle);
        if (class1.equals(com/google/ads/mediation/admob/AdMobAdapter) && bundle.getBoolean("_emulatorLiveAds"))
        {
            zznP.(AdRequest.DEVICE_ID_EMULATOR);
        }
        return this;
    }

    public final D_EMULATOR addTestDevice(String s)
    {
        zznP.(s);
        return this;
    }

    public final AdRequest build()
    {
        return new AdRequest(this, null);
    }

    public final y.zza.zzG setBirthday(Date date)
    {
        zznP.(date);
        return this;
    }

    public final y.zza.zza setContentUrl(String s)
    {
        zzx.zzb(s, "Content URL must be non-null.");
        zzx.zzh(s, "Content URL must be non-empty.");
        boolean flag;
        if (s.length() <= 512)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Content URL must not exceed %d in length.  Provided length was %d.", new Object[] {
            Integer.valueOf(512), Integer.valueOf(s.length())
        });
        zznP.(s);
        return this;
    }

    public final y.zza.zzI setGender(int i)
    {
        zznP.(i);
        return this;
    }

    public final y.zza.zzm setLocation(Location location)
    {
        zznP.(location);
        return this;
    }

    public final y.zza.zzb setRequestAgent(String s)
    {
        zznP.(s);
        return this;
    }

    public final y.zza.zzK tagForChildDirectedTreatment(boolean flag)
    {
        zznP.(flag);
        return this;
    }

    public xtras()
    {
        zznP.(AdRequest.DEVICE_ID_EMULATOR);
    }
}
