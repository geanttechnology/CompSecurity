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
//            by

class bw
{

    public static final by A = a("ad_refresh_seconds", Long.valueOf(120L));
    public static final by B = a("mrec_ad_refresh_enabled", Boolean.valueOf(true));
    public static final by C = a("mrec_ad_refresh_seconds", Long.valueOf(120L));
    public static final by D = a("leader_ad_refresh_enabled", Boolean.valueOf(true));
    public static final by E = a("leader_ad_refresh_seconds", Long.valueOf(120L));
    public static final by F = a("plugin_version", "");
    public static final by G = a("ad_preload_enabled", Boolean.valueOf(true));
    public static final by H = a("ad_resource_caching_enabled", Boolean.valueOf(true));
    public static final by I = a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");
    public static final by J = a("ad_auto_preload_sizes", "BANNER,INTER");
    public static final by K = a("ad_auto_preload_incent", Boolean.valueOf(true));
    public static final by L = a("session_expiration_time", Long.valueOf(300L));
    public static final by M = a("track_installed_apps", Boolean.valueOf(true));
    public static final by N = a("is_tracking_enabled", Boolean.valueOf(true));
    public static final by O = a("force_back_button_enabled_always", Boolean.valueOf(false));
    public static final by P = a("is_first_install", "unknown");
    public static final by Q = a("countdown_direction", "right_to_left");
    public static final by R = a("countdown_color", "#C8FFFFFF");
    public static final by S = a("countdown_height", Integer.valueOf(2));
    public static final by T = a("close_fade_in_time", Integer.valueOf(400));
    public static final by U = a("draw_countdown_text", Boolean.valueOf(true));
    public static final by V = a("draw_countdown_bar", Boolean.valueOf(true));
    public static final by W = a("show_close_on_exit", Boolean.valueOf(true));
    public static final by X = a("text_incent_prompt_title", "Earn a Reward");
    public static final by Y = a("text_incent_prompt_body", "Would you like to watch a video for a reward?");
    public static final by Z = a("text_incent_prompt_yes_option", "Watch Now");
    public static final by a = a("is_disabled", Boolean.valueOf(false));
    public static final by aA = a("cache_cleanup_enabled", Boolean.valueOf(false));
    public static final by aB = a("cache_file_ttl_seconds", Long.valueOf(0x15180L));
    public static final by aC = a("cache_max_size_mb", Integer.valueOf(-1));
    public static final by aD = a("preload_merge_init_tasks_incent", Boolean.valueOf(true));
    public static final by aE = a("preload_merge_init_tasks_inter", Boolean.valueOf(false));
    public static final by aF = a("submit_postback_timeout", Integer.valueOf(10000));
    public static final by aG = a("submit_postback_retries", Integer.valueOf(10));
    public static final by aH = a("widget_imp_tracking_delay", Integer.valueOf(2000));
    public static final by aI = a("draw_countdown_clock", Boolean.valueOf(true));
    public static final by aJ = a("countdown_clock_size", Integer.valueOf(32));
    public static final by aK = a("countdown_clock_stroke_size", Integer.valueOf(4));
    public static final by aL = a("countdown_clock_text_size", Integer.valueOf(28));
    public static final by aM = a("ad_auto_preload_native", Boolean.valueOf(true));
    public static final by aN = a("widget_fail_on_slot_count_diff", Boolean.valueOf(true));
    public static final by aO = a("video_zero_length_as_computed", Boolean.valueOf(false));
    public static final by aP = a("video_countdown_clock_margin", Integer.valueOf(10));
    public static final by aQ = a("video_countdown_clock_gravity", Integer.valueOf(83));
    public static final by aR = a("preload_capacity_widget", Integer.valueOf(1));
    public static final by aS = a("widget_latch_timeout_ms", Integer.valueOf(500));
    public static final by aT = a("android_gc_on_widget_detach", Boolean.valueOf(true));
    public static final by aU = a("lhs_close_button_video", Boolean.valueOf(false));
    public static final by aV = a("lhs_close_button_graphic", Boolean.valueOf(false));
    public static final by aW = a("lhs_skip_button", Boolean.valueOf(true));
    public static final by aX = a("countdown_toggleable", Boolean.valueOf(false));
    public static final by aY = a("native_batch_precache_count", Integer.valueOf(1));
    public static final by aZ = a("mute_controls_enabled", Boolean.valueOf(false));
    public static final by aa = a("text_incent_prompt_no_option", "No Thanks");
    public static final by ab = a("text_incent_completion_title", "Video Reward");
    public static final by ac = a("text_incent_completion_body_success", "You have earned a reward!");
    public static final by ad = a("text_incent_completion_body_quota_exceeded", "You have already earned the maximum reward for today.");
    public static final by ae = a("text_incent_completion_body_reward_rejected", "Your reward was rejected.");
    public static final by af = a("text_incent_completion_body_network_failure", "We were unable to contact the rewards server. Please try again later.");
    public static final by ag = a("text_incent_completion_close_option", "Okay");
    public static final by ah = a("show_incent_prepopup", Boolean.valueOf(true));
    public static final by ai = a("show_incent_postpopup", Boolean.valueOf(true));
    public static final by aj = a("preload_capacity_banner", Integer.valueOf(1));
    public static final by ak = a("preload_capacity_mrec", Integer.valueOf(1));
    public static final by al = a("preload_capacity_inter", Integer.valueOf(1));
    public static final by am = a("preload_capacity_leader", Integer.valueOf(1));
    public static final by an = a("preload_capacity_incent", Integer.valueOf(2));
    public static final by ao = a("dismiss_video_on_error", Boolean.valueOf(true));
    public static final by ap = a("precache_delimiters", ")]',");
    public static final by aq = a("close_button_size_graphic", Integer.valueOf(27));
    public static final by ar = a("close_button_size_video", Integer.valueOf(30));
    public static final by as = a("close_button_top_margin_graphic", Integer.valueOf(10));
    public static final by at = a("close_button_right_margin_graphic", Integer.valueOf(10));
    public static final by au = a("close_button_top_margin_video", Integer.valueOf(8));
    public static final by av = a("close_button_right_margin_video", Integer.valueOf(4));
    public static final by aw = a("force_back_button_enabled_poststitial", Boolean.valueOf(false));
    public static final by ax = a("force_back_button_enabled_close_button", Boolean.valueOf(false));
    public static final by ay = a("close_button_touch_area", Integer.valueOf(0));
    public static final by az = a("is_video_skippable", Boolean.valueOf(false));
    public static final by b = a("honor_publisher_settings", Boolean.valueOf(true));
    public static final by ba = a("allow_user_muting", Boolean.valueOf(true));
    public static final by bb = a("mute_button_size", Integer.valueOf(32));
    public static final by bc = a("mute_button_margin", Integer.valueOf(10));
    public static final by bd = a("mute_button_gravity", Integer.valueOf(85));
    public static final by be = a("qq", Boolean.valueOf(false));
    public static final by bf = a("hw_accelerate_webviews", Boolean.valueOf(false));
    public static final by bg = a("mute_videos", Boolean.valueOf(false));
    public static final by bh = a("event_tracking_endpoint", "http://rt.applovin.com/pix");
    public static final by bi = a("top_level_events", "landing,checkout,iap");
    public static final by bj = a("events_enabled", Boolean.valueOf(true));
    public static final by bk = a("force_ssl", Boolean.valueOf(false));
    public static final by bl = a("postback_service_max_queue_size", Integer.valueOf(100));
    public static final by bm = a("max_postback_attempts", Integer.valueOf(3));
    public static final by bn = a("click_overlay_enabled", Boolean.valueOf(false));
    public static final by bo = a("click_overlay_color", "#66000000");
    public static final by bp = a("click_tracking_retry_count", Integer.valueOf(3));
    public static final by bq = a("click_tracking_retry_delay", Integer.valueOf(2000));
    public static final by br = a("click_tracking_timeout", Integer.valueOf(10000));
    public static final by bs = a("android_click_spinner_size", Integer.valueOf(50));
    public static final by bt = a("android_click_spinner_style", Integer.valueOf(0x103001d));
    public static final by bu = a("android_dismiss_inters_on_click", Boolean.valueOf(false));
    public static final by bv = a("android_require_external_storage_permission", Boolean.valueOf(true));
    private static final List bw = Arrays.asList(new Class[] {
        java/lang/Boolean, java/lang/Float, java/lang/Integer, java/lang/Long, java/lang/String
    });
    private static final List bx = new ArrayList();
    public static final by c = a("device_id", "");
    public static final by d = a("publisher_id", "");
    public static final by e = a("device_token", "");
    public static final by f = a("init_retry_count", Integer.valueOf(1));
    public static final by g = a("submit_data_retry_count", Integer.valueOf(1));
    public static final by h = a("vr_retry_count", Integer.valueOf(1));
    public static final by i = a("fetch_ad_retry_count", Integer.valueOf(1));
    public static final by j = a("is_verbose_logging", Boolean.valueOf(false));
    public static final by k = a("api_endpoint", "http://d.applovin.com/");
    public static final by l = a("adserver_endpoint", "http://a.applovin.com/");
    public static final by m = a("next_device_init", Long.valueOf(0L));
    public static final by n = a("get_retry_delay", Long.valueOf(10000L));
    public static final by o = a("max_apps_to_send", Integer.valueOf(100));
    public static final by p = a("is_app_list_shared", Boolean.valueOf(true));
    public static final by q = a("next_app_list_update", Long.valueOf(0L));
    public static final by r = a("hash_algorithm", "SHA-1");
    public static final by s = a("short_hash_size", Integer.valueOf(16));
    public static final by t = a("http_connection_timeout", Integer.valueOf(30000));
    public static final by u = a("fetch_ad_connection_timeout", Integer.valueOf(30000));
    public static final by v = a("http_socket_timeout", Integer.valueOf(20000));
    public static final by w = a("error_save_count", Integer.valueOf(15));
    public static final by x = a("ad_session_minutes", Integer.valueOf(60));
    public static final by y = a("ad_request_parameters", "");
    public static final by z = a("ad_refresh_enabled", Boolean.valueOf(true));

    private static by a(String s1, Object obj)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("No default value specified");
        }
        if (!bw.contains(obj.getClass()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unsupported value type: ").append(obj.getClass()).toString());
        } else
        {
            s1 = new by(s1, obj, null);
            bx.add(s1);
            return s1;
        }
    }

    public static Collection a()
    {
        return Collections.unmodifiableList(bx);
    }

    public static int b()
    {
        return bx.size();
    }

}
