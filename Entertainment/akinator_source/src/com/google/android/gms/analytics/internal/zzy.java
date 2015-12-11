// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlr;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzm, zzo

public final class zzy
{
    public static final class zza
    {

        private final Object zzOV;
        private final zzlr zzOW;
        private Object zzOX;

        static zza zza(String s, float f)
        {
            return zza(s, f, f);
        }

        static zza zza(String s, float f, float f1)
        {
            return new zza(zzlr.zza(s, Float.valueOf(f1)), Float.valueOf(f));
        }

        static zza zza(String s, int i, int j)
        {
            return new zza(zzlr.zza(s, Integer.valueOf(j)), Integer.valueOf(i));
        }

        static zza zza(String s, long l, long l1)
        {
            return new zza(zzlr.zza(s, Long.valueOf(l1)), Long.valueOf(l));
        }

        static zza zza(String s, boolean flag, boolean flag1)
        {
            return new zza(zzlr.zzg(s, flag1), Boolean.valueOf(flag));
        }

        static zza zzc(String s, long l)
        {
            return zza(s, l, l);
        }

        static zza zzd(String s, String s1, String s2)
        {
            return new zza(zzlr.zzu(s, s2), s1);
        }

        static zza zzd(String s, boolean flag)
        {
            return zza(s, flag, flag);
        }

        static zza zze(String s, int i)
        {
            return zza(s, i, i);
        }

        static zza zzn(String s, String s1)
        {
            return zzd(s, s1, s1);
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


    public static zza zzOA;
    public static zza zzOB = zza.zze("analytics.max_hits_per_request.k", 20);
    public static zza zzOC = zza.zze("analytics.max_hit_length.k", 8192);
    public static zza zzOD = zza.zze("analytics.max_post_length.k", 8192);
    public static zza zzOE = zza.zze("analytics.max_batch_post_length", 8192);
    public static zza zzOF = zza.zzn("analytics.fallback_responses.k", "404,502");
    public static zza zzOG = zza.zze("analytics.batch_retry_interval.seconds.k", 3600);
    public static zza zzOH = zza.zzc("analytics.service_monitor_interval", 0x5265c00L);
    public static zza zzOI = zza.zze("analytics.http_connection.connect_timeout_millis", 60000);
    public static zza zzOJ = zza.zze("analytics.http_connection.read_timeout_millis", 61000);
    public static zza zzOK = zza.zzc("analytics.campaigns.time_limit", 0x5265c00L);
    public static zza zzOL = zza.zzn("analytics.first_party_experiment_id", "");
    public static zza zzOM = zza.zze("analytics.first_party_experiment_variant", 0);
    public static zza zzON = com.google.android.gms.analytics.internal.zza.zzd("analytics.test.disable_receiver", false);
    public static zza zzOO = zza.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
    public static zza zzOP = zza.zzc("analytics.service_client.connect_timeout_millis", 5000L);
    public static zza zzOQ = zza.zzc("analytics.service_client.second_connect_delay_millis", 5000L);
    public static zza zzOR = zza.zzc("analytics.service_client.unexpected_reconnect_millis", 60000L);
    public static zza zzOS = zza.zzc("analytics.service_client.reconnect_throttle_millis", 0x1b7740L);
    public static zza zzOT = zza.zzc("analytics.monitoring.sample_period_millis", 0x5265c00L);
    public static zza zzOU = zza.zzc("analytics.initialization_warning_threshold", 5000L);
    public static zza zzOe = com.google.android.gms.analytics.internal.zza.zzd("analytics.service_enabled", false);
    public static zza zzOf = com.google.android.gms.analytics.internal.zza.zzd("analytics.service_client_enabled", true);
    public static zza zzOg = com.google.android.gms.analytics.internal.zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static zza zzOh = zza.zzc("analytics.max_tokens", 60L);
    public static zza zzOi = zza.zza("analytics.tokens_per_sec", 0.5F);
    public static zza zzOj = zza.zza("analytics.max_stored_hits", 2000, 20000);
    public static zza zzOk = zza.zze("analytics.max_stored_hits_per_app", 2000);
    public static zza zzOl = zza.zze("analytics.max_stored_properties_per_app", 100);
    public static zza zzOm = zza.zza("analytics.local_dispatch_millis", 0x1b7740L, 0x1d4c0L);
    public static zza zzOn = zza.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    public static zza zzOo = zza.zzc("analytics.min_local_dispatch_millis", 0x1d4c0L);
    public static zza zzOp = zza.zzc("analytics.max_local_dispatch_millis", 0x6ddd00L);
    public static zza zzOq = zza.zzc("analytics.dispatch_alarm_millis", 0x6ddd00L);
    public static zza zzOr = zza.zzc("analytics.max_dispatch_alarm_millis", 0x1ee6280L);
    public static zza zzOs = zza.zze("analytics.max_hits_per_dispatch", 20);
    public static zza zzOt = zza.zze("analytics.max_hits_per_batch", 20);
    public static zza zzOu = zza.zzn("analytics.insecure_host", "http://www.google-analytics.com");
    public static zza zzOv = zza.zzn("analytics.secure_host", "https://ssl.google-analytics.com");
    public static zza zzOw = zza.zzn("analytics.simple_endpoint", "/collect");
    public static zza zzOx = zza.zzn("analytics.batching_endpoint", "/batch");
    public static zza zzOy = zza.zze("analytics.max_get_length", 2036);
    public static zza zzOz;

    static 
    {
        zzOz = com.google.android.gms.analytics.internal.zza.zzd("analytics.batching_strategy.k", zzm.zzNJ.name(), zzm.zzNJ.name());
        zzOA = zza.zzn("analytics.compression_strategy.k", zzo.zzNQ.name());
    }
}
