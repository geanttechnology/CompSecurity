// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlr;

public final class zzk
{
    public static final class zza
    {

        private final Object zzOV;
        private final zzlr zzOW;
        private Object zzOX;

        static zza zzA(String s, int i)
        {
            return zzo(s, i, i);
        }

        static zza zzJ(String s, String s1)
        {
            return zzj(s, s1, s1);
        }

        static zza zzb(String s, long l, long l1)
        {
            return new zza(zzlr.zza(s, Long.valueOf(l1)), Long.valueOf(l));
        }

        static zza zzb(String s, boolean flag, boolean flag1)
        {
            return new zza(zzlr.zzg(s, flag1), Boolean.valueOf(flag));
        }

        static zza zzf(String s, long l)
        {
            return zzb(s, l, l);
        }

        static zza zzi(String s, boolean flag)
        {
            return zzb(s, flag, flag);
        }

        static zza zzj(String s, String s1, String s2)
        {
            return new zza(zzlr.zzu(s, s2), s1);
        }

        static zza zzo(String s, int i, int j)
        {
            return new zza(zzlr.zza(s, Integer.valueOf(j)), Integer.valueOf(i));
        }

        public Object get()
        {
            if (zzOX != null)
            {
                return zzOX;
            }
            if (zzd.zzaeK && zzlr.isInitialized())
            {
                return zzOW.zzop();
            } else
            {
                return zzOV;
            }
        }

        private zza(zzlr zzlr1, Object obj)
        {
            zzx.zzw(zzlr1);
            zzOW = zzlr1;
            zzOV = obj;
        }
    }


    public static zza zzaMA = zza.zzA("measurement.upload.retry_count", 6);
    public static zza zzaMB = zza.zzf("measurement.upload.retry_time", 0x90321000L);
    public static zza zzaMC = zza.zzf("measurement.service_client.idle_disconnect_millis", 5000L);
    public static zza zzaMn = zza.zzi("measurement.service_enabled", false);
    public static zza zzaMo = zza.zzi("measurement.service_client_enabled", true);
    public static zza zzaMp = zza.zzj("measurement.log_tag", "GMPM", "GMPM-SVC");
    public static zza zzaMq = zza.zzf("measurement.ad_id_cache_time", 10000L);
    public static zza zzaMr = zza.zzf("measurement.monitoring.sample_period_millis", 0x5265c00L);
    public static zza zzaMs = zza.zzA("measurement.upload.max_bundles", 100);
    public static zza zzaMt = zza.zzA("measurement.upload.max_batch_size", 0x10000);
    public static zza zzaMu = zza.zzJ("measurement.upload.url", "https://app-measurement.com/a");
    public static zza zzaMv = zza.zzf("measurement.upload.backoff_period", 0x2932e00L);
    public static zza zzaMw = zza.zzf("measurement.upload.interval", 0x36ee80L);
    public static zza zzaMx = zza.zzf("measurement.upload.stale_data_deletion_interval", 0x5265c00L);
    public static zza zzaMy = zza.zzf("measurement.upload.initial_upload_delay_time", 15000L);
    public static zza zzaMz = zza.zzf("measurement.upload.retry_time", 0x1b7740L);

}
