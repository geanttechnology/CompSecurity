// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.mediation.NetworkExtras;

public final class SearchAdRequest
{

    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int zzKS;
    private final int zzKT;
    private final int zzKU;
    private final int zzKV;
    private final int zzKW;
    private final int zzKX;
    private final int zzKY;
    private final String zzKZ;
    private final int zzLa;
    private final String zzLb;
    private final int zzLc;
    private final int zzLd;
    private final String zzLe;
    private final zzy zznO;
    private final int zzwg;

    private SearchAdRequest(Builder builder)
    {
        zzKS = Builder.zza(builder);
        zzwg = Builder.zzb(builder);
        zzKT = Builder.zzc(builder);
        zzKU = Builder.zzd(builder);
        zzKV = Builder.zze(builder);
        zzKW = Builder.zzf(builder);
        zzKX = Builder.zzg(builder);
        zzKY = Builder.zzh(builder);
        zzKZ = Builder.zzi(builder);
        zzLa = Builder.zzj(builder);
        zzLb = Builder.zzk(builder);
        zzLc = Builder.zzl(builder);
        zzLd = Builder.zzm(builder);
        zzLe = Builder.zzn(builder);
        zznO = new zzy(Builder.zzo(builder), this);
    }


    public final int getAnchorTextColor()
    {
        return zzKS;
    }

    public final int getBackgroundColor()
    {
        return zzwg;
    }

    public final int getBackgroundGradientBottom()
    {
        return zzKT;
    }

    public final int getBackgroundGradientTop()
    {
        return zzKU;
    }

    public final int getBorderColor()
    {
        return zzKV;
    }

    public final int getBorderThickness()
    {
        return zzKW;
    }

    public final int getBorderType()
    {
        return zzKX;
    }

    public final int getCallButtonColor()
    {
        return zzKY;
    }

    public final String getCustomChannels()
    {
        return zzKZ;
    }

    public final Bundle getCustomEventExtrasBundle(Class class1)
    {
        return zznO.getCustomEventExtrasBundle(class1);
    }

    public final int getDescriptionTextColor()
    {
        return zzLa;
    }

    public final String getFontFace()
    {
        return zzLb;
    }

    public final int getHeaderTextColor()
    {
        return zzLc;
    }

    public final int getHeaderTextSize()
    {
        return zzLd;
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

    public final String getQuery()
    {
        return zzLe;
    }

    public final boolean isTestDevice(Context context)
    {
        return zznO.isTestDevice(context);
    }

    final zzy zzaF()
    {
        return zznO;
    }

    static 
    {
        DEVICE_ID_EMULATOR = zzy.DEVICE_ID_EMULATOR;
    }

    private class Builder
    {

        private int zzKS;
        private int zzKT;
        private int zzKU;
        private int zzKV;
        private int zzKW;
        private int zzKX;
        private int zzKY;
        private String zzKZ;
        private int zzLa;
        private String zzLb;
        private int zzLc;
        private int zzLd;
        private String zzLe;
        private final com.google.android.gms.ads.internal.client.zzy.zza zznP = new com.google.android.gms.ads.internal.client.zzy.zza();
        private int zzwg;

        static int zza(Builder builder)
        {
            return builder.zzKS;
        }

        static int zzb(Builder builder)
        {
            return builder.zzwg;
        }

        static int zzc(Builder builder)
        {
            return builder.zzKT;
        }

        static int zzd(Builder builder)
        {
            return builder.zzKU;
        }

        static int zze(Builder builder)
        {
            return builder.zzKV;
        }

        static int zzf(Builder builder)
        {
            return builder.zzKW;
        }

        static int zzg(Builder builder)
        {
            return builder.zzKX;
        }

        static int zzh(Builder builder)
        {
            return builder.zzKY;
        }

        static String zzi(Builder builder)
        {
            return builder.zzKZ;
        }

        static int zzj(Builder builder)
        {
            return builder.zzLa;
        }

        static String zzk(Builder builder)
        {
            return builder.zzLb;
        }

        static int zzl(Builder builder)
        {
            return builder.zzLc;
        }

        static int zzm(Builder builder)
        {
            return builder.zzLd;
        }

        static String zzn(Builder builder)
        {
            return builder.zzLe;
        }

        static com.google.android.gms.ads.internal.client.zzy.zza zzo(Builder builder)
        {
            return builder.zznP;
        }

        public final Builder addCustomEventExtrasBundle(Class class1, Bundle bundle)
        {
            zznP.zzb(class1, bundle);
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
            return this;
        }

        public final Builder addTestDevice(String s)
        {
            zznP.zzG(s);
            return this;
        }

        public final SearchAdRequest build()
        {
            return new SearchAdRequest(this);
        }

        public final Builder setAnchorTextColor(int i)
        {
            zzKS = i;
            return this;
        }

        public final Builder setBackgroundColor(int i)
        {
            zzwg = i;
            zzKT = Color.argb(0, 0, 0, 0);
            zzKU = Color.argb(0, 0, 0, 0);
            return this;
        }

        public final Builder setBackgroundGradient(int i, int j)
        {
            zzwg = Color.argb(0, 0, 0, 0);
            zzKT = j;
            zzKU = i;
            return this;
        }

        public final Builder setBorderColor(int i)
        {
            zzKV = i;
            return this;
        }

        public final Builder setBorderThickness(int i)
        {
            zzKW = i;
            return this;
        }

        public final Builder setBorderType(int i)
        {
            zzKX = i;
            return this;
        }

        public final Builder setCallButtonColor(int i)
        {
            zzKY = i;
            return this;
        }

        public final Builder setCustomChannels(String s)
        {
            zzKZ = s;
            return this;
        }

        public final Builder setDescriptionTextColor(int i)
        {
            zzLa = i;
            return this;
        }

        public final Builder setFontFace(String s)
        {
            zzLb = s;
            return this;
        }

        public final Builder setHeaderTextColor(int i)
        {
            zzLc = i;
            return this;
        }

        public final Builder setHeaderTextSize(int i)
        {
            zzLd = i;
            return this;
        }

        public final Builder setLocation(Location location)
        {
            zznP.zzb(location);
            return this;
        }

        public final Builder setQuery(String s)
        {
            zzLe = s;
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
            zzKX = 0;
        }
    }

}
