// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package com.google.android.gms.internal:
//            zzbv, zzbx

public abstract class zzbu
{

    private final String zzue;
    private final Object zzuf;

    private zzbu(String s, Object obj)
    {
        zzue = s;
        zzuf = obj;
        zzp.zzbD().zza(this);
    }


    public static zzbu zzP(String s)
    {
        s = zzc(s, null);
        zzp.zzbD().zzb(s);
        return s;
    }

    public static zzbu zzQ(String s)
    {
        s = zzc(s, null);
        zzp.zzbD().zzc(s);
        return s;
    }

    public static zzbu zza(String s, int i)
    {
        return new zzbu(s, Integer.valueOf(i)) {

            public final Object zza(SharedPreferences sharedpreferences)
            {
                return zzc(sharedpreferences);
            }

            public final Integer zzc(SharedPreferences sharedpreferences)
            {
                return Integer.valueOf(sharedpreferences.getInt(getKey(), ((Integer)zzde()).intValue()));
            }

        };
    }

    public static zzbu zza(String s, Boolean boolean1)
    {
        return new zzbu(s, boolean1) {

            public final Object zza(SharedPreferences sharedpreferences)
            {
                return zzb(sharedpreferences);
            }

            public final Boolean zzb(SharedPreferences sharedpreferences)
            {
                return Boolean.valueOf(sharedpreferences.getBoolean(getKey(), ((Boolean)zzde()).booleanValue()));
            }

        };
    }

    public static zzbu zzb(String s, long l)
    {
        return new zzbu(s, Long.valueOf(l)) {

            public final Object zza(SharedPreferences sharedpreferences)
            {
                return zzd(sharedpreferences);
            }

            public final Long zzd(SharedPreferences sharedpreferences)
            {
                return Long.valueOf(sharedpreferences.getLong(getKey(), ((Long)zzde()).longValue()));
            }

        };
    }

    public static zzbu zzc(String s, String s1)
    {
        return new zzbu(s, s1) {

            public final Object zza(SharedPreferences sharedpreferences)
            {
                return zze(sharedpreferences);
            }

            public final String zze(SharedPreferences sharedpreferences)
            {
                return sharedpreferences.getString(getKey(), (String)zzde());
            }

        };
    }

    public Object get()
    {
        return zzp.zzbE().zzd(this);
    }

    public String getKey()
    {
        return zzue;
    }

    protected abstract Object zza(SharedPreferences sharedpreferences);

    public Object zzde()
    {
        return zzuf;
    }
}
