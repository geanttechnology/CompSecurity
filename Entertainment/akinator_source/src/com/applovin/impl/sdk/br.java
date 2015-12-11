// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.applovin.impl.sdk:
//            bt

class br
{

    public static final bt A = a("ad_refresh_seconds", Long.valueOf(120L));
    public static final bt B = a("mrec_ad_refresh_enabled", Boolean.valueOf(true));
    public static final bt C = a("mrec_ad_refresh_seconds", Long.valueOf(120L));
    public static final bt D = a("leader_ad_refresh_enabled", Boolean.valueOf(true));
    public static final bt E = a("leader_ad_refresh_seconds", Long.valueOf(120L));
    public static final bt F = a("plugin_version", "");
    public static final bt G = a("ad_preload_enabled", Boolean.valueOf(true));
    public static final bt H = a("ad_resource_caching_enabled", Boolean.valueOf(true));
    public static final bt I = a("resource_cache_prefix", "http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");
    public static final bt J = a("ad_auto_preload_sizes", "BANNER,INTER");
    public static final bt K = a("ad_auto_preload_incent", Boolean.valueOf(true));
    public static final bt L = a("session_expiration_time", Long.valueOf(300L));
    public static final bt M = a("track_installed_apps", Boolean.valueOf(true));
    public static final bt N = a("is_tracking_enabled", Boolean.valueOf(true));
    public static final bt O = a("force_back_button_enabled_always", Boolean.valueOf(false));
    public static final bt P = a("is_first_install", "unknown");
    public static final bt Q = a("countdown_direction", "right_to_left");
    public static final bt R = a("countdown_color", "#C8FFFFFF");
    public static final bt S = a("countdown_height", Integer.valueOf(2));
    public static final bt T = a("close_fade_in_time", Integer.valueOf(400));
    public static final bt U = a("draw_countdown_text", Boolean.valueOf(true));
    public static final bt V = a("draw_countdown_bar", Boolean.valueOf(true));
    public static final bt W = a("show_close_on_exit", Boolean.valueOf(true));
    public static final bt X = a("text_incent_prompt_title", "Earn a Reward");
    public static final bt Y = a("text_incent_prompt_body", "Would you like to watch a video for a reward?");
    public static final bt Z = a("text_incent_prompt_yes_option", "Watch Now");
    public static final bt a = a("is_disabled", Boolean.valueOf(false));
    public static final bt aA = a("cache_cleanup_enabled", Boolean.valueOf(false));
    public static final bt aB = a("cache_file_ttl_seconds", Long.valueOf(0x15180L));
    public static final bt aC = a("cache_max_size_mb", Integer.valueOf(-1));
    public static final bt aD = a("preload_merge_init_tasks_incent", Boolean.valueOf(true));
    public static final bt aE = a("preload_merge_init_tasks_inter", Boolean.valueOf(false));
    public static final bt aF = a("submit_postback_timeout", Integer.valueOf(10000));
    public static final bt aG = a("submit_postback_retries", Integer.valueOf(10));
    public static final bt aH = a("widget_imp_tracking_delay", Integer.valueOf(2000));
    public static final bt aI = a("draw_countdown_clock", Boolean.valueOf(true));
    public static final bt aJ = a("countdown_clock_size", Integer.valueOf(32));
    public static final bt aK = a("countdown_clock_stroke_size", Integer.valueOf(4));
    public static final bt aL = a("countdown_clock_text_size", Integer.valueOf(28));
    public static final bt aM = a("ad_auto_preload_native", Boolean.valueOf(true));
    public static final bt aN = a("widget_fail_on_slot_count_diff", Boolean.valueOf(true));
    public static final bt aO = a("video_zero_length_as_computed", Boolean.valueOf(false));
    public static final bt aP = a("video_countdown_clock_margin", Integer.valueOf(10));
    public static final bt aQ = a("video_countdown_clock_gravity", Integer.valueOf(83));
    public static final bt aR = a("preload_capacity_widget", Integer.valueOf(1));
    public static final bt aS = a("widget_latch_timeout_ms", Integer.valueOf(500));
    public static final bt aT = a("android_gc_on_widget_detach", Boolean.valueOf(true));
    public static final bt aU = a("lhs_close_button_video", Boolean.valueOf(false));
    public static final bt aV = a("lhs_close_button_graphic", Boolean.valueOf(false));
    public static final bt aW = a("lhs_skip_button", Boolean.valueOf(true));
    public static final bt aX = a("countdown_toggleable", Boolean.valueOf(false));
    public static final bt aY = a("native_batch_precache_count", Integer.valueOf(1));
    public static final bt aZ = a("qq", Boolean.valueOf(false));
    public static final bt aa = a("text_incent_prompt_no_option", "No Thanks");
    public static final bt ab = a("text_incent_completion_title", "Video Reward");
    public static final bt ac = a("text_incent_completion_body_success", "You have earned a reward!");
    public static final bt ad = a("text_incent_completion_body_quota_exceeded", "You have already earned the maximum reward for today.");
    public static final bt ae = a("text_incent_completion_body_reward_rejected", "Your reward was rejected.");
    public static final bt af = a("text_incent_completion_body_network_failure", "We were unable to contact the rewards server. Please try again later.");
    public static final bt ag = a("text_incent_completion_close_option", "Okay");
    public static final bt ah = a("show_incent_prepopup", Boolean.valueOf(true));
    public static final bt ai = a("show_incent_postpopup", Boolean.valueOf(true));
    public static final bt aj = a("preload_capacity_banner", Integer.valueOf(1));
    public static final bt ak = a("preload_capacity_mrec", Integer.valueOf(1));
    public static final bt al = a("preload_capacity_inter", Integer.valueOf(1));
    public static final bt am = a("preload_capacity_leader", Integer.valueOf(1));
    public static final bt an = a("preload_capacity_incent", Integer.valueOf(2));
    public static final bt ao = a("dismiss_video_on_error", Boolean.valueOf(true));
    public static final bt ap = a("precache_delimiters", ")]',");
    public static final bt aq = a("close_button_size_graphic", Integer.valueOf(27));
    public static final bt ar = a("close_button_size_video", Integer.valueOf(30));
    public static final bt as = a("close_button_top_margin_graphic", Integer.valueOf(10));
    public static final bt at = a("close_button_right_margin_graphic", Integer.valueOf(10));
    public static final bt au = a("close_button_top_margin_video", Integer.valueOf(8));
    public static final bt av = a("close_button_right_margin_video", Integer.valueOf(4));
    public static final bt aw = a("force_back_button_enabled_poststitial", Boolean.valueOf(false));
    public static final bt ax = a("force_back_button_enabled_close_button", Boolean.valueOf(false));
    public static final bt ay = a("close_button_touch_area", Integer.valueOf(0));
    public static final bt az = a("is_video_skippable", Boolean.valueOf(false));
    public static final bt b = a("honor_publisher_settings", Boolean.valueOf(true));
    private static final List ba = Arrays.asList(new Class[] {
        java/lang/Boolean, java/lang/Float, java/lang/Integer, java/lang/Long, java/lang/String
    });
    private static final List bb = new ArrayList();
    public static final bt c = a("device_id", "");
    public static final bt d = a("publisher_id", "");
    public static final bt e = a("device_token", "");
    public static final bt f = a("init_retry_count", Integer.valueOf(1));
    public static final bt g = a("submit_data_retry_count", Integer.valueOf(1));
    public static final bt h = a("vr_retry_count", Integer.valueOf(1));
    public static final bt i = a("fetch_ad_retry_count", Integer.valueOf(1));
    public static final bt j = a("is_verbose_logging", Boolean.valueOf(false));
    public static final bt k = a("api_endpoint", "http://d.applovin.com/");
    public static final bt l = a("adserver_endpoint", "http://a.applovin.com/");
    public static final bt m = a("next_device_init", Long.valueOf(0L));
    public static final bt n = a("get_retry_delay", Long.valueOf(10000L));
    public static final bt o = a("max_apps_to_send", Integer.valueOf(100));
    public static final bt p = a("is_app_list_shared", Boolean.valueOf(true));
    public static final bt q = a("next_app_list_update", Long.valueOf(0L));
    public static final bt r = a("hash_algorithm", "SHA-1");
    public static final bt s = a("short_hash_size", Integer.valueOf(16));
    public static final bt t = a("http_connection_timeout", Integer.valueOf(30000));
    public static final bt u = a("fetch_ad_connection_timeout", Integer.valueOf(30000));
    public static final bt v = a("http_socket_timeout", Integer.valueOf(20000));
    public static final bt w = a("error_save_count", Integer.valueOf(15));
    public static final bt x = a("ad_session_minutes", Integer.valueOf(60));
    public static final bt y = a("ad_request_parameters", "");
    public static final bt z = a("ad_refresh_enabled", Boolean.valueOf(true));

    private static bt a(String s1, Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("No default value specified");
        }
        if (!ba.contains(obj.getClass()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported value type: ").append(obj.getClass()).toString());
        } else
        {
            s1 = new bt(s1, obj, null);
            bb.add(s1);
            return s1;
        }
    }

    public static Collection a()
    {
        return Collections.unmodifiableList(bb);
    }

    public static int b()
    {
        return bb.size();
    }

}
