// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.settings;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package io.fabric.sdk.android.services.settings:
//            SettingsJsonTransform, AnalyticsSettingsData, AppSettingsData, BetaSettingsData, 
//            SettingsJsonConstants, FeaturesSettingsData, AppIconSettingsData, PromptSettingsData, 
//            SessionSettingsData, SettingsData

class DefaultSettingsJsonTransform
    implements SettingsJsonTransform
{

    DefaultSettingsJsonTransform()
    {
    }

    private AnalyticsSettingsData buildAnalyticsSessionDataFrom(JSONObject jsonobject)
    {
        return new AnalyticsSettingsData(jsonobject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jsonobject.optInt("flush_interval_secs", 600), jsonobject.optInt("max_byte_size_per_file", 8000), jsonobject.optInt("max_file_count_per_send", 1), jsonobject.optInt("max_pending_send_file_count", 100), jsonobject.optBoolean("track_custom_events", true), jsonobject.optInt("sampling_rate", 1));
    }

    private AppSettingsData buildAppDataFrom(JSONObject jsonobject)
        throws JSONException
    {
        String s = jsonobject.getString("identifier");
        String s1 = jsonobject.getString("status");
        String s2 = jsonobject.getString("url");
        String s3 = jsonobject.getString("reports_url");
        boolean flag = jsonobject.optBoolean("update_required", false);
        Object obj = null;
        AppIconSettingsData appiconsettingsdata = obj;
        if (jsonobject.has("icon"))
        {
            appiconsettingsdata = obj;
            if (jsonobject.getJSONObject("icon").has("hash"))
            {
                appiconsettingsdata = buildIconDataFrom(jsonobject.getJSONObject("icon"));
            }
        }
        return new AppSettingsData(s, s1, s2, s3, flag, appiconsettingsdata);
    }

    private BetaSettingsData buildBetaSettingsDataFrom(JSONObject jsonobject)
        throws JSONException
    {
        return new BetaSettingsData(jsonobject.optString("update_endpoint", SettingsJsonConstants.BETA_UPDATE_ENDPOINT_DEFAULT), jsonobject.optInt("update_suspend_duration", 3600));
    }

    private FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jsonobject)
    {
        return new FeaturesSettingsData(jsonobject.optBoolean("prompt_enabled", false), jsonobject.optBoolean("collect_logged_exceptions", true), jsonobject.optBoolean("collect_reports", true), jsonobject.optBoolean("collect_analytics", false));
    }

    private AppIconSettingsData buildIconDataFrom(JSONObject jsonobject)
        throws JSONException
    {
        return new AppIconSettingsData(jsonobject.getString("hash"), jsonobject.getInt("width"), jsonobject.getInt("height"));
    }

    private PromptSettingsData buildPromptDataFrom(JSONObject jsonobject)
        throws JSONException
    {
        return new PromptSettingsData(jsonobject.optString("title", "Send Crash Report?"), jsonobject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jsonobject.optString("send_button_title", "Send"), jsonobject.optBoolean("show_cancel_button", true), jsonobject.optString("cancel_button_title", "Don't Send"), jsonobject.optBoolean("show_always_send_button", true), jsonobject.optString("always_send_button_title", "Always Send"));
    }

    private SessionSettingsData buildSessionDataFrom(JSONObject jsonobject)
        throws JSONException
    {
        return new SessionSettingsData(jsonobject.optInt("log_buffer_size", 64000), jsonobject.optInt("max_chained_exception_depth", 8), jsonobject.optInt("max_custom_exception_events", 64), jsonobject.optInt("max_custom_key_value_pairs", 64), jsonobject.optInt("identifier_mask", 255), jsonobject.optBoolean("send_session_without_crash", false));
    }

    private long getExpiresAtFrom(CurrentTimeProvider currenttimeprovider, long l, JSONObject jsonobject)
        throws JSONException
    {
        if (jsonobject.has("expires_at"))
        {
            return jsonobject.getLong("expires_at");
        } else
        {
            return currenttimeprovider.getCurrentTimeMillis() + 1000L * l;
        }
    }

    public SettingsData buildFromJson(CurrentTimeProvider currenttimeprovider, JSONObject jsonobject)
        throws JSONException
    {
        int i = jsonobject.optInt("settings_version", 0);
        int j = jsonobject.optInt("cache_duration", 3600);
        AppSettingsData appsettingsdata = buildAppDataFrom(jsonobject.getJSONObject("app"));
        SessionSettingsData sessionsettingsdata = buildSessionDataFrom(jsonobject.getJSONObject("session"));
        PromptSettingsData promptsettingsdata = buildPromptDataFrom(jsonobject.getJSONObject("prompt"));
        FeaturesSettingsData featuressettingsdata = buildFeaturesSessionDataFrom(jsonobject.getJSONObject("features"));
        AnalyticsSettingsData analyticssettingsdata = buildAnalyticsSessionDataFrom(jsonobject.getJSONObject("analytics"));
        BetaSettingsData betasettingsdata = buildBetaSettingsDataFrom(jsonobject.getJSONObject("beta"));
        return new SettingsData(getExpiresAtFrom(currenttimeprovider, j, jsonobject), appsettingsdata, sessionsettingsdata, promptsettingsdata, featuressettingsdata, analyticssettingsdata, betasettingsdata, i, j);
    }

    public JSONObject sanitizeTraceInfo(JSONObject jsonobject)
        throws JSONException
    {
        jsonobject = new JSONObject(jsonobject.toString());
        jsonobject.getJSONObject("features").remove("collect_analytics");
        jsonobject.remove("analytics");
        return jsonobject;
    }
}
