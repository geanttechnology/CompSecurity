// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.content.pm.PackageInfo;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushManager;
import com.urbanairship.util.UAStringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            Event, Analytics

class AppForegroundEvent extends Event
{

    static final String NOTIFICATION_TYPES_KEY = "notification_types";
    static final String TYPE = "app_foreground";

    AppForegroundEvent(long l)
    {
        super(l);
    }

    protected final JSONObject getEventData()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("connection_type", getConnectionType());
            String s = getConnectionSubType();
            if (!UAStringUtil.isEmpty(s))
            {
                jsonobject.put("connection_subtype", s);
            }
            jsonobject.put("carrier", getCarrier());
            jsonobject.put("time_zone", getTimezone());
            jsonobject.put("daylight_savings", isDaylightSavingsTime());
            jsonobject.put("notification_types", new JSONArray(getNotificationTypes()));
            jsonobject.put("os_version", android.os.Build.VERSION.RELEASE);
            jsonobject.put("lib_version", UAirship.getVersion());
            jsonobject.put("package_version", UAirship.getPackageInfo().versionName);
            jsonobject.put("push_id", UAirship.shared().getAnalytics().getConversionSendId());
            jsonobject.put("last_send_id", UAirship.shared().getPushManager().getLastReceivedSendId());
        }
        catch (JSONException jsonexception)
        {
            Logger.error("AppForegroundEvent - Error constructing JSON data.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public final String getType()
    {
        return "app_foreground";
    }
}
