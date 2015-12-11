// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;

// Referenced classes of package android.support.v7:
//            nj, nk, nm

public final class nn
{

    public static final nj A = nj.a("gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
    public static final nj B = nj.a("gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
    public static final nj C = nj.a("gads:sw_dynamite:enabled", Boolean.valueOf(true));
    public static final nj D = nj.a("gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    public static final nj E = nj.a("gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    public static final nj F = nj.a("gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    public static final nj G = nj.a("gads:enabled_sdk_csi", Boolean.valueOf(false));
    public static final nj H = nj.a("gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    public static final nj I = nj.a("gads:sdk_csi_write_to_file", Boolean.valueOf(false));
    public static final nj J = nj.a("gads:enable_content_fetching", Boolean.valueOf(true));
    public static final nj K = nj.a("gads:content_length_weight", 1);
    public static final nj L = nj.a("gads:content_age_weight", 1);
    public static final nj M = nj.a("gads:min_content_len", 11);
    public static final nj N = nj.a("gads:fingerprint_number", 10);
    public static final nj O = nj.a("gads:sleep_sec", 10);
    public static final nj P = nj.a("gad:app_index_enabled", Boolean.valueOf(true));
    public static final nj Q = nj.a("gads:kitkat_interstitial_workaround:experiment_id");
    public static final nj R = nj.a("gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    public static final nj S = nj.a("gads:interstitial_follow_url", Boolean.valueOf(true));
    public static final nj T = nj.a("gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    public static final nj U = nj.a("gads:interstitial_follow_url:experiment_id");
    public static final nj V = nj.a("gads:analytics_enabled", Boolean.valueOf(true));
    public static final nj W = nj.a("gads:ad_key_enabled", Boolean.valueOf(false));
    public static final nj X = nj.a("gads:webview_cache_version", 0);
    public static final nj Y = nj.b("gads:pan:experiment_id");
    public static final nj Z = nj.a("gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final nj a = nj.a("gads:sdk_core_experiment_id");
    public static final nj aa = nj.a("gads:ad_manager_creator:enabled", Boolean.valueOf(true));
    public static final nj ab = nj.a("gads:log:verbose_enabled", Boolean.valueOf(false));
    public static final nj ac = nj.a("gads:device_info_caching:enabled", Boolean.valueOf(true));
    public static final nj ad = nj.a("gads:device_info_caching_expiry_ms:expiry", 0x493e0L);
    public static final nj ae = nj.a("gads:gen204_signals:enabled", Boolean.valueOf(false));
    public static final nj af = nj.a("gads:webview:error_reporting_enabled", Boolean.valueOf(false));
    public static final nj ag = nj.a("gads:adid_reporting:enabled", Boolean.valueOf(false));
    public static final nj ah = nj.a("gads:request_pkg:enabled", Boolean.valueOf(true));
    public static final nj ai = nj.a("gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
    public static final nj aj = nj.a("gads:network:cache_prediction_duration_s", 300L);
    public static final nj b = nj.a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final nj c = nj.a("gads:request_builder:singleton_webview", Boolean.valueOf(false));
    public static final nj d = nj.a("gads:request_builder:singleton_webview_experiment_id");
    public static final nj e = nj.a("gads:sdk_use_dynamic_module", Boolean.valueOf(false));
    public static final nj f = nj.a("gads:sdk_use_dynamic_module_experiment_id");
    public static final nj g = nj.a("gads:sdk_crash_report_enabled", Boolean.valueOf(false));
    public static final nj h = nj.a("gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
    public static final nj i = nj.a("gads:block_autoclicks", Boolean.valueOf(false));
    public static final nj j = nj.a("gads:block_autoclicks_experiment_id");
    public static final nj k = nj.b("gads:prefetch:experiment_id");
    public static final nj l = nj.a("gads:spam_app_context:experiment_id");
    public static final nj m = nj.a("gads:spam_app_context:enabled", Boolean.valueOf(false));
    public static final nj n = nj.a("gads:video_stream_cache:experiment_id");
    public static final nj o = nj.a("gads:video_stream_cache:limit_count", 5);
    public static final nj p = nj.a("gads:video_stream_cache:limit_space", 0x800000);
    public static final nj q = nj.a("gads:video_stream_exo_cache:buffer_size", 0x800000);
    public static final nj r = nj.a("gads:video_stream_cache:limit_time_sec", 300L);
    public static final nj s = nj.a("gads:video_stream_cache:notify_interval_millis", 1000L);
    public static final nj t = nj.a("gads:video_stream_cache:connect_timeout_millis", 10000);
    public static final nj u = nj.a("gads:video:metric_reporting_enabled", Boolean.valueOf(false));
    public static final nj v = nj.a("gads:video:metric_frame_hash_times", "");
    public static final nj w = nj.a("gads:video:metric_frame_hash_time_leniency", 500L);
    public static final nj x = nj.b("gads:spam_ad_id_decorator:experiment_id");
    public static final nj y = nj.a("gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
    public static final nj z = nj.b("gads:looper_for_gms_client:experiment_id");

    public static List a()
    {
        return zzp.zzbF().a();
    }

    public static void a(Context context)
    {
        zzp.zzbG().a(context);
    }

}
