// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzo;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzbv, zzbw

public final class zzbz
{

    public static final zzbv zztC = zzbv.zzO("gads:sdk_core_experiment_id");
    public static final zzbv zztD = zzbv.zzc("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final zzbv zztE = zzbv.zza("gads:request_builder:singleton_webview", Boolean.valueOf(false));
    public static final zzbv zztF = zzbv.zzO("gads:request_builder:singleton_webview_experiment_id");
    public static final zzbv zztG = zzbv.zza("gads:sdk_crash_report_enabled", Boolean.valueOf(false));
    public static final zzbv zztH = zzbv.zza("gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
    public static final zzbv zztI = zzbv.zza("gads:block_autoclicks", Boolean.valueOf(false));
    public static final zzbv zztJ = zzbv.zzO("gads:block_autoclicks_experiment_id");
    public static final zzbv zztK = zzbv.zzP("gads:prefetch:experiment_id");
    public static final zzbv zztL = zzbv.zzO("gads:spam_app_context:experiment_id");
    public static final zzbv zztM = zzbv.zza("gads:spam_app_context:enabled", Boolean.valueOf(false));
    public static final zzbv zztN = zzbv.zzO("gads:video_stream_cache:experiment_id");
    public static final zzbv zztO = zzbv.zza("gads:video_stream_cache:limit_count", 5);
    public static final zzbv zztP = zzbv.zza("gads:video_stream_cache:limit_space", 0x800000);
    public static final zzbv zztQ = zzbv.zzb("gads:video_stream_cache:limit_time_sec", 300L);
    public static final zzbv zztR = zzbv.zzb("gads:video_stream_cache:notify_interval_millis", 1000L);
    public static final zzbv zztS = zzbv.zza("gads:video_stream_cache:connect_timeout_millis", 10000);
    public static final zzbv zztT = zzbv.zzP("gads:spam_ad_id_decorator:experiment_id");
    public static final zzbv zztU = zzbv.zza("gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
    public static final zzbv zztV = zzbv.zzc("gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    public static final zzbv zztW = zzbv.zzc("gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    public static final zzbv zztX = zzbv.zzc("gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    public static final zzbv zztY = zzbv.zza("gads:enabled_sdk_csi", Boolean.valueOf(false));
    public static final zzbv zztZ = zzbv.zza("gads:sdk_csi_batch_size", 20);
    public static final zzbv zzua = zzbv.zzc("gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    public static final zzbv zzub = zzbv.zza("gads:sdk_csi_write_to_file", Boolean.valueOf(false));
    public static final zzbv zzuc = zzbv.zza("gads:enable_content_fetching", Boolean.valueOf(true));
    public static final zzbv zzud = zzbv.zza("gads:content_length_weight", 1);
    public static final zzbv zzue = zzbv.zza("gads:content_age_weight", 1);
    public static final zzbv zzuf = zzbv.zza("gads:min_content_len", 11);
    public static final zzbv zzug = zzbv.zza("gads:fingerprint_number", 10);
    public static final zzbv zzuh = zzbv.zza("gads:sleep_sec", 10);
    public static final zzbv zzui = zzbv.zzO("gads:kitkat_interstitial_workaround:experiment_id");
    public static final zzbv zzuj = zzbv.zza("gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    public static final zzbv zzuk = zzbv.zza("gads:interstitial_follow_url", Boolean.valueOf(true));
    public static final zzbv zzul = zzbv.zza("gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    public static final zzbv zzum = zzbv.zzO("gads:interstitial_follow_url:experiment_id");
    public static final zzbv zzun = zzbv.zza("gads:analytics_enabled", Boolean.valueOf(true));
    public static final zzbv zzuo = zzbv.zza("gads:ad_key_enabled", Boolean.valueOf(false));
    public static final zzbv zzup = zzbv.zza("gads:webview_cache_version", 0);
    public static final zzbv zzuq = zzbv.zzP("gads:pan:experiment_id");
    public static final zzbv zzur = zzbv.zzc("gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final zzbv zzus = zzbv.zza("gads:ad_manager_creator:enabled", Boolean.valueOf(true));
    public static final zzbv zzut = zzbv.zza("gads:log:verbose_enabled", Boolean.valueOf(false));
    public static final zzbv zzuu = zzbv.zza("gads:sdk_less_mediation:enabled", Boolean.valueOf(true));
    public static final zzbv zzuv = zzbv.zza("gads:device_info_caching:enabled", Boolean.valueOf(true));
    public static final zzbv zzuw = zzbv.zzb("gads:device_info_caching_expiry_ms:expiry", 0x493e0L);
    public static final zzbv zzux = zzbv.zza("gads:gen204_signals:enabled", Boolean.valueOf(false));

    public static List zzdb()
    {
        return zzo.zzbD().zzdb();
    }

}
