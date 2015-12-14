// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import org.json.JSONObject;

class bxe
    implements bxr
{

    bxe()
    {
    }

    private long a(btx btx1, long l, JSONObject jsonobject)
    {
        if (jsonobject.has("expires_at"))
        {
            return jsonobject.getLong("expires_at");
        } else
        {
            return btx1.a() + 1000L * l;
        }
    }

    private bwy a(JSONObject jsonobject)
    {
        String s = jsonobject.getString("identifier");
        String s1 = jsonobject.getString("status");
        String s2 = jsonobject.getString("url");
        String s3 = jsonobject.getString("reports_url");
        boolean flag = jsonobject.optBoolean("update_required", false);
        Object obj = null;
        bww bww1 = obj;
        if (jsonobject.has("icon"))
        {
            bww1 = obj;
            if (jsonobject.getJSONObject("icon").has("hash"))
            {
                bww1 = b(jsonobject.getJSONObject("icon"));
            }
        }
        return new bwy(s, s1, s2, s3, flag, bww1);
    }

    private bww b(JSONObject jsonobject)
    {
        return new bww(jsonobject.getString("hash"), jsonobject.getInt("width"), jsonobject.getInt("height"));
    }

    private bxg c(JSONObject jsonobject)
    {
        return new bxg(jsonobject.optBoolean("prompt_enabled", false), jsonobject.optBoolean("collect_logged_exceptions", true), jsonobject.optBoolean("collect_reports", true), jsonobject.optBoolean("collect_analytics", false));
    }

    private bwv d(JSONObject jsonobject)
    {
        return new bwv(jsonobject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jsonobject.optInt("flush_interval_secs", 600), jsonobject.optInt("max_byte_size_per_file", 8000), jsonobject.optInt("max_file_count_per_send", 1), jsonobject.optInt("max_pending_send_file_count", 100), jsonobject.optBoolean("track_custom_events", true), jsonobject.optBoolean("track_predefined_events", true), jsonobject.optInt("sampling_rate", 1));
    }

    private bxj e(JSONObject jsonobject)
    {
        return new bxj(jsonobject.optInt("log_buffer_size", 64000), jsonobject.optInt("max_chained_exception_depth", 8), jsonobject.optInt("max_custom_exception_events", 64), jsonobject.optInt("max_custom_key_value_pairs", 64), jsonobject.optInt("identifier_mask", 255), jsonobject.optBoolean("send_session_without_crash", false));
    }

    private bxi f(JSONObject jsonobject)
    {
        return new bxi(jsonobject.optString("title", "Send Crash Report?"), jsonobject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jsonobject.optString("send_button_title", "Send"), jsonobject.optBoolean("show_cancel_button", true), jsonobject.optString("cancel_button_title", "Don't Send"), jsonobject.optBoolean("show_always_send_button", true), jsonobject.optString("always_send_button_title", "Always Send"));
    }

    private bwz g(JSONObject jsonobject)
    {
        return new bwz(jsonobject.optString("update_endpoint", bxq.a), jsonobject.optInt("update_suspend_duration", 3600));
    }

    public bxp a(btx btx1, JSONObject jsonobject)
    {
        int i = jsonobject.optInt("settings_version", 0);
        int j = jsonobject.optInt("cache_duration", 3600);
        bwy bwy1 = a(jsonobject.getJSONObject("app"));
        bxj bxj1 = e(jsonobject.getJSONObject("session"));
        bxi bxi1 = f(jsonobject.getJSONObject("prompt"));
        bxg bxg1 = c(jsonobject.getJSONObject("features"));
        bwv bwv1 = d(jsonobject.getJSONObject("analytics"));
        bwz bwz1 = g(jsonobject.getJSONObject("beta"));
        return new bxp(a(btx1, j, jsonobject), bwy1, bxj1, bxi1, bxg1, bwv1, bwz1, i, j);
    }
}
