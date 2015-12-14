// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzbu, zzbx, zzbv

public final class zzby
{

    public static final zzbu zzuA = zzbu.zza("gads:video_stream_exo_cache:buffer_size", 0x800000);
    public static final zzbu zzuB = zzbu.zzb("gads:video_stream_cache:limit_time_sec", 300L);
    public static final zzbu zzuC = zzbu.zzb("gads:video_stream_cache:notify_interval_millis", 1000L);
    public static final zzbu zzuD = zzbu.zza("gads:video_stream_cache:connect_timeout_millis", 10000);
    public static final zzbu zzuE = zzbu.zza("gads:video:metric_reporting_enabled", Boolean.valueOf(false));
    public static final zzbu zzuF = zzbu.zzc("gads:video:metric_frame_hash_times", "");
    public static final zzbu zzuG = zzbu.zzb("gads:video:metric_frame_hash_time_leniency", 500L);
    public static final zzbu zzuH = zzbu.zzQ("gads:spam_ad_id_decorator:experiment_id");
    public static final zzbu zzuI = zzbu.zza("gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
    public static final zzbu zzuJ = zzbu.zzQ("gads:looper_for_gms_client:experiment_id");
    public static final zzbu zzuK = zzbu.zza("gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
    public static final zzbu zzuL = zzbu.zza("gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
    public static final zzbu zzuM = zzbu.zza("gads:sw_dynamite:enabled", Boolean.valueOf(true));
    public static final zzbu zzuN = zzbu.zzc("gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    public static final zzbu zzuO = zzbu.zzc("gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    public static final zzbu zzuP = zzbu.zzc("gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    public static final zzbu zzuQ = zzbu.zza("gads:enabled_sdk_csi", Boolean.valueOf(false));
    public static final zzbu zzuR = zzbu.zzc("gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    public static final zzbu zzuS = zzbu.zza("gads:sdk_csi_write_to_file", Boolean.valueOf(false));
    public static final zzbu zzuT = zzbu.zza("gads:enable_content_fetching", Boolean.valueOf(true));
    public static final zzbu zzuU = zzbu.zza("gads:content_length_weight", 1);
    public static final zzbu zzuV = zzbu.zza("gads:content_age_weight", 1);
    public static final zzbu zzuW = zzbu.zza("gads:min_content_len", 11);
    public static final zzbu zzuX = zzbu.zza("gads:fingerprint_number", 10);
    public static final zzbu zzuY = zzbu.zza("gads:sleep_sec", 10);
    public static final zzbu zzuZ = zzbu.zza("gad:app_index_enabled", Boolean.valueOf(true));
    public static final zzbu zzuk = zzbu.zzP("gads:sdk_core_experiment_id");
    public static final zzbu zzul = zzbu.zzc("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final zzbu zzum = zzbu.zza("gads:request_builder:singleton_webview", Boolean.valueOf(false));
    public static final zzbu zzun = zzbu.zzP("gads:request_builder:singleton_webview_experiment_id");
    public static final zzbu zzuo = zzbu.zza("gads:sdk_use_dynamic_module", Boolean.valueOf(false));
    public static final zzbu zzup = zzbu.zzP("gads:sdk_use_dynamic_module_experiment_id");
    public static final zzbu zzuq = zzbu.zza("gads:sdk_crash_report_enabled", Boolean.valueOf(false));
    public static final zzbu zzur = zzbu.zza("gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
    public static final zzbu zzus = zzbu.zza("gads:block_autoclicks", Boolean.valueOf(false));
    public static final zzbu zzut = zzbu.zzP("gads:block_autoclicks_experiment_id");
    public static final zzbu zzuu = zzbu.zzQ("gads:prefetch:experiment_id");
    public static final zzbu zzuv = zzbu.zzP("gads:spam_app_context:experiment_id");
    public static final zzbu zzuw = zzbu.zza("gads:spam_app_context:enabled", Boolean.valueOf(false));
    public static final zzbu zzux = zzbu.zzP("gads:video_stream_cache:experiment_id");
    public static final zzbu zzuy = zzbu.zza("gads:video_stream_cache:limit_count", 5);
    public static final zzbu zzuz = zzbu.zza("gads:video_stream_cache:limit_space", 0x800000);
    public static final zzbu zzva = zzbu.zzP("gads:kitkat_interstitial_workaround:experiment_id");
    public static final zzbu zzvb = zzbu.zza("gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    public static final zzbu zzvc = zzbu.zza("gads:interstitial_follow_url", Boolean.valueOf(true));
    public static final zzbu zzvd = zzbu.zza("gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    public static final zzbu zzve = zzbu.zzP("gads:interstitial_follow_url:experiment_id");
    public static final zzbu zzvf = zzbu.zza("gads:analytics_enabled", Boolean.valueOf(true));
    public static final zzbu zzvg = zzbu.zza("gads:ad_key_enabled", Boolean.valueOf(false));
    public static final zzbu zzvh = zzbu.zza("gads:webview_cache_version", 0);
    public static final zzbu zzvi = zzbu.zzQ("gads:pan:experiment_id");
    public static final zzbu zzvj = zzbu.zzc("gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final zzbu zzvk = zzbu.zza("gads:ad_manager_creator:enabled", Boolean.valueOf(true));
    public static final zzbu zzvl = zzbu.zza("gads:log:verbose_enabled", Boolean.valueOf(false));
    public static final zzbu zzvm = zzbu.zza("gads:device_info_caching:enabled", Boolean.valueOf(true));
    public static final zzbu zzvn = zzbu.zzb("gads:device_info_caching_expiry_ms:expiry", 0x493e0L);
    public static final zzbu zzvo = zzbu.zza("gads:gen204_signals:enabled", Boolean.valueOf(false));
    public static final zzbu zzvp = zzbu.zza("gads:webview:error_reporting_enabled", Boolean.valueOf(false));
    public static final zzbu zzvq = zzbu.zza("gads:adid_reporting:enabled", Boolean.valueOf(false));
    public static final zzbu zzvr = zzbu.zza("gads:request_pkg:enabled", Boolean.valueOf(true));
    public static final zzbu zzvs = zzbu.zza("gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
    public static final zzbu zzvt = zzbu.zzb("gads:network:cache_prediction_duration_s", 300L);
    public static final zzbu zzvu = zzbu.zza("gads:mediation:dynamite_first", Boolean.valueOf(true));
    public static final zzbu zzvv = zzbu.zzb("gads:ad_loader:timeout_ms", 60000L);
    public static final zzbu zzvw = zzbu.zzb("gads:rendering:timeout_ms", 60000L);
    public static final zzbu zzvx = zzbu.zza("gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
    public static final zzbu zzvy = zzbu.zza("gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
    public static final zzbu zzvz = zzbu.zza("gads:support_screen_shot", Boolean.valueOf(true));

    public static void initialize(Context context)
    {
        zzp.zzbE().initialize(context);
    }

    public static List zzdf()
    {
        return zzp.zzbD().zzdf();
    }

}
