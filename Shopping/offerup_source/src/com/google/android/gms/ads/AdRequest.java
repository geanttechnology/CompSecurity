// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Date;
import java.util.Set;

public final class AdRequest
{

    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    private final zzy zznO;

    private AdRequest(Builder builder)
    {
        zznO = new zzy(Builder.zza(builder));
    }

    AdRequest(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final Date getBirthday()
    {
        return zznO.getBirthday();
    }

    public final String getContentUrl()
    {
        return zznO.getContentUrl();
    }

    public final Bundle getCustomEventExtrasBundle(Class class1)
    {
        return zznO.getCustomEventExtrasBundle(class1);
    }

    public final int getGender()
    {
        return zznO.getGender();
    }

    public final Set getKeywords()
    {
        return zznO.getKeywords();
    }

    public final Location getLocation()
    {
        return zznO.getLocation();
    }

    public final NetworkExtras getNetworkExtras(Class class1)
    {
        return zznO.getNetworkExtras(class1);
    }

    public final Bundle getNetworkExtrasBundle(Class class1)
    {
        return zznO.getNetworkExtrasBundle(class1);
    }

    public final boolean isTestDevice(Context context)
    {
        return zznO.isTestDevice(context);
    }

    public final zzy zzaF()
    {
        return zznO;
    }

    static 
    {
        DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
    }

    private class Builder
    {

        private final com.google.android.gms.ads.internal.client.zzy.zza zznP = new com.google.android.gms.ads.internal.client.zzy.zza();

        static com.google.android.gms.ads.internal.client.zzy.zza zza(Builder builder)
        {
            return builder.zznP;
        }

        public final Builder addCustomEventExtrasBundle(Class class1, Bundle bundle)
        {
            zznP.zzb(class1, bundle);
            return this;
        }

        public final Builder addKeyword(String s)
        {
            zznP.zzF(s);
            return this;
        }

        public final Builder addNetworkExtras(NetworkExtras networkextras)
        {
            zznP.zza(networkextras);
            return this;
        }

        public final Builder addNetworkExtrasBundle(Class class1, Bundle bundle)
        {
            zznP.zza(class1, bundle);
            if (class1.equals(com/google/ads/mediation/admob/AdMobAdapter) && bundle.getBoolean("_emulatorLiveAds"))
            {
                zznP.zzH(AdRequest.DEVICE_ID_EMULATOR);
            }
            return this;
        }

        public final Builder addTestDevice(String s)
        {
            zznP.zzG(s);
            return this;
        }

        public final AdRequest build()
        {
            return new AdRequest(this, null);
        }

        public final Builder setBirthday(Date date)
        {
            zznP.zza(date);
            return this;
        }

        public final Builder setContentUrl(String s)
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
            zznP.zzI(s);
            return this;
        }

        public final Builder setGender(int i)
        {
            zznP.zzm(i);
            return this;
        }

        public final Builder setLocation(Location location)
        {
            zznP.zzb(location);
            return this;
        }

        public final Builder setRequestAgent(String s)
        {
            zznP.zzK(s);
            return this;
        }

        public final Builder tagForChildDirectedTreatment(boolean flag)
        {
            zznP.zzj(flag);
            return this;
        }

        public Builder()
        {
            zznP.zzG(AdRequest.DEVICE_ID_EMULATOR);
        }
    }

}
