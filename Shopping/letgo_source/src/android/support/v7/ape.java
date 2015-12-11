// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            app, ams, aoy, aow, 
//            apg, aov, apj, api, 
//            aoz, apo, apn

class ape
    implements app
{

    ape()
    {
    }

    private long a(ams ams1, long l, JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.has("expires_at"))
        {
            return jsonobject.getLong("expires_at");
        } else
        {
            return ams1.a() + 1000L * l;
        }
    }

    private aoy a(JSONObject jsonobject)
        throws JSONException
    {
        String s = jsonobject.getString("identifier");
        String s1 = jsonobject.getString("status");
        String s2 = jsonobject.getString("url");
        String s3 = jsonobject.getString("reports_url");
        boolean flag = jsonobject.optBoolean("update_required", false);
        Object obj = null;
        aow aow1 = obj;
        if (jsonobject.has("icon"))
        {
            aow1 = obj;
            if (jsonobject.getJSONObject("icon").has("hash"))
            {
                aow1 = b(jsonobject.getJSONObject("icon"));
            }
        }
        return new aoy(s, s1, s2, s3, flag, aow1);
    }

    private aow b(JSONObject jsonobject)
        throws JSONException
    {
        return new aow(jsonobject.getString("hash"), jsonobject.getInt("width"), jsonobject.getInt("height"));
    }

    private apg c(JSONObject jsonobject)
    {
        return new apg(jsonobject.optBoolean("prompt_enabled", false), jsonobject.optBoolean("collect_logged_exceptions", true), jsonobject.optBoolean("collect_reports", true), jsonobject.optBoolean("collect_analytics", false));
    }

    private aov d(JSONObject jsonobject)
    {
        return new aov(jsonobject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jsonobject.optInt("flush_interval_secs", 600), jsonobject.optInt("max_byte_size_per_file", 8000), jsonobject.optInt("max_file_count_per_send", 1), jsonobject.optInt("max_pending_send_file_count", 100), jsonobject.optBoolean("track_custom_events", true), jsonobject.optBoolean("track_predefined_events", true), jsonobject.optInt("sampling_rate", 1));
    }

    private apj e(JSONObject jsonobject)
        throws JSONException
    {
        return new apj(jsonobject.optInt("log_buffer_size", 64000), jsonobject.optInt("max_chained_exception_depth", 8), jsonobject.optInt("max_custom_exception_events", 64), jsonobject.optInt("max_custom_key_value_pairs", 64), jsonobject.optInt("identifier_mask", 255), jsonobject.optBoolean("send_session_without_crash", false));
    }

    private api f(JSONObject jsonobject)
        throws JSONException
    {
        return new api(jsonobject.optString("title", "Send Crash Report?"), jsonobject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jsonobject.optString("send_button_title", "Send"), jsonobject.optBoolean("show_cancel_button", true), jsonobject.optString("cancel_button_title", "Don't Send"), jsonobject.optBoolean("show_always_send_button", true), jsonobject.optString("always_send_button_title", "Always Send"));
    }

    private aoz g(JSONObject jsonobject)
        throws JSONException
    {
        return new aoz(jsonobject.optString("update_endpoint", apo.a), jsonobject.optInt("update_suspend_duration", 3600));
    }

    public apn a(ams ams1, JSONObject jsonobject)
        throws JSONException
    {
        int i = jsonobject.optInt("settings_version", 0);
        int j = jsonobject.optInt("cache_duration", 3600);
        aoy aoy1 = a(jsonobject.getJSONObject("app"));
        apj apj1 = e(jsonobject.getJSONObject("session"));
        api api1 = f(jsonobject.getJSONObject("prompt"));
        apg apg1 = c(jsonobject.getJSONObject("features"));
        aov aov1 = d(jsonobject.getJSONObject("analytics"));
        aoz aoz1 = g(jsonobject.getJSONObject("beta"));
        return new apn(a(ams1, j, jsonobject), aoy1, apj1, api1, apg1, aov1, aoz1, i, j);
    }
}
