// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import com.google.android.gms.ads.internal.c;
import java.util.List;

// Referenced classes of package com.google.android.gms.b:
//            u, v

public final class y
{

    public static final u A = com.google.android.gms.b.u.a("gads:enable_content_fetching", Boolean.valueOf(true));
    public static final u B = com.google.android.gms.b.u.a("gads:content_length_weight", 1);
    public static final u C = com.google.android.gms.b.u.a("gads:content_age_weight", 1);
    public static final u D = com.google.android.gms.b.u.a("gads:min_content_len", 11);
    public static final u E = com.google.android.gms.b.u.a("gads:fingerprint_number", 10);
    public static final u F = com.google.android.gms.b.u.a("gads:sleep_sec", 10);
    public static final u G = com.google.android.gms.b.u.a("gads:kitkat_interstitial_workaround:experiment_id");
    public static final u H = com.google.android.gms.b.u.a("gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    public static final u I = com.google.android.gms.b.u.a("gads:interstitial_follow_url", Boolean.valueOf(true));
    public static final u J = com.google.android.gms.b.u.a("gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    public static final u K = com.google.android.gms.b.u.a("gads:interstitial_follow_url:experiment_id");
    public static final u L = com.google.android.gms.b.u.a("gads:analytics_enabled", Boolean.valueOf(true));
    public static final u M = com.google.android.gms.b.u.a("gads:ad_key_enabled", Boolean.valueOf(false));
    public static final u N = com.google.android.gms.b.u.a("gads:webview_cache_version", 0);
    public static final u O = com.google.android.gms.b.u.b("gads:pan:experiment_id");
    public static final u P = com.google.android.gms.b.u.a("gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final u Q = com.google.android.gms.b.u.a("gads:ad_manager_creator:enabled", Boolean.valueOf(true));
    public static final u R = com.google.android.gms.b.u.a("gads:log:verbose_enabled", Boolean.valueOf(false));
    public static final u S = com.google.android.gms.b.u.a("gads:sdk_less_mediation:enabled", Boolean.valueOf(true));
    public static final u T = com.google.android.gms.b.u.a("gads:device_info_caching:enabled", Boolean.valueOf(true));
    public static final u U = com.google.android.gms.b.u.a("gads:device_info_caching_expiry_ms:expiry", 0x493e0L);
    public static final u V = com.google.android.gms.b.u.a("gads:gen204_signals:enabled", Boolean.valueOf(false));
    public static final u a = com.google.android.gms.b.u.a("gads:sdk_core_experiment_id");
    public static final u b = com.google.android.gms.b.u.a("gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final u c = com.google.android.gms.b.u.a("gads:request_builder:singleton_webview", Boolean.valueOf(false));
    public static final u d = com.google.android.gms.b.u.a("gads:request_builder:singleton_webview_experiment_id");
    public static final u e = com.google.android.gms.b.u.a("gads:sdk_crash_report_enabled", Boolean.valueOf(false));
    public static final u f = com.google.android.gms.b.u.a("gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
    public static final u g = com.google.android.gms.b.u.a("gads:block_autoclicks", Boolean.valueOf(false));
    public static final u h = com.google.android.gms.b.u.a("gads:block_autoclicks_experiment_id");
    public static final u i = com.google.android.gms.b.u.b("gads:prefetch:experiment_id");
    public static final u j = com.google.android.gms.b.u.a("gads:spam_app_context:experiment_id");
    public static final u k = com.google.android.gms.b.u.a("gads:spam_app_context:enabled", Boolean.valueOf(false));
    public static final u l = com.google.android.gms.b.u.a("gads:video_stream_cache:experiment_id");
    public static final u m = com.google.android.gms.b.u.a("gads:video_stream_cache:limit_count", 5);
    public static final u n = com.google.android.gms.b.u.a("gads:video_stream_cache:limit_space", 0x800000);
    public static final u o = com.google.android.gms.b.u.a("gads:video_stream_cache:limit_time_sec", 300L);
    public static final u p = com.google.android.gms.b.u.a("gads:video_stream_cache:notify_interval_millis", 1000L);
    public static final u q = com.google.android.gms.b.u.a("gads:video_stream_cache:connect_timeout_millis", 10000);
    public static final u r = com.google.android.gms.b.u.b("gads:spam_ad_id_decorator:experiment_id");
    public static final u s = com.google.android.gms.b.u.a("gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
    public static final u t = com.google.android.gms.b.u.a("gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    public static final u u = com.google.android.gms.b.u.a("gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    public static final u v = com.google.android.gms.b.u.a("gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    public static final u w = com.google.android.gms.b.u.a("gads:enabled_sdk_csi", Boolean.valueOf(false));
    public static final u x = com.google.android.gms.b.u.a("gads:sdk_csi_batch_size", 20);
    public static final u y = com.google.android.gms.b.u.a("gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    public static final u z = com.google.android.gms.b.u.a("gads:sdk_csi_write_to_file", Boolean.valueOf(false));

    public static List a()
    {
        return com.google.android.gms.ads.internal.c.h().a();
    }

}
