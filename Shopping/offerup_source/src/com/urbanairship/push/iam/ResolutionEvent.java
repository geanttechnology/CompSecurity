// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.content.Context;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.analytics.Event;
import com.urbanairship.push.notifications.NotificationActionButton;
import com.urbanairship.util.DateUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessage

public class ResolutionEvent extends Event
{

    private static final String BUTTON_DESCRIPTION = "button_description";
    private static final String BUTTON_GROUP = "button_group";
    private static final String BUTTON_ID = "button_id";
    private static final String CONVERSION_SEND_ID = "conversion_send_id";
    private static final String DISPLAY_TIME = "display_time";
    private static final String EXPIRY = "expiry";
    private static final String ID = "id";
    private static final String REPLACEMENT_ID = "replacement_id";
    private static final String RESOLUTION = "resolution";
    private static final String RESOLUTION_BUTTON_CLICK = "button_click";
    private static final String RESOLUTION_DIRECT_OPEN = "direct_open";
    private static final String RESOLUTION_EXPIRED = "expired";
    private static final String RESOLUTION_MESSAGE_CLICK = "message_click";
    private static final String RESOLUTION_REPLACED = "replaced";
    private static final String RESOLUTION_TIMED_OUT = "timed_out";
    private static final String RESOLUTION_TYPE = "type";
    private static final String RESOLUTION_USER_DISMISSED = "user_dismissed";
    private static final String TYPE = "in_app_resolution";
    private final String id;
    private final Map resolutionData;

    private ResolutionEvent(String s, Map map)
    {
        id = s;
        resolutionData = map;
    }

    public static ResolutionEvent createButtonClickedResolutionEvent(Context context, InAppMessage inappmessage, NotificationActionButton notificationactionbutton, long l)
    {
        HashMap hashmap;
        hashmap = new HashMap();
        hashmap.put("type", "button_click");
        hashmap.put("button_id", notificationactionbutton.getId());
        hashmap.put("button_group", inappmessage.getButtonGroupId());
        hashmap.put("display_time", millisecondsToSecondsString(l));
        if (notificationactionbutton.getDescription() == null) goto _L2; else goto _L1
_L1:
        hashmap.put("button_description", notificationactionbutton.getDescription());
_L4:
        return new ResolutionEvent(inappmessage.getId(), hashmap);
_L2:
        if (notificationactionbutton.getLabel() > 0)
        {
            hashmap.put("button_description", context.getString(notificationactionbutton.getLabel()));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static ResolutionEvent createClickedResolutionEvent(InAppMessage inappmessage, long l)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", "message_click");
        hashmap.put("display_time", millisecondsToSecondsString(l));
        return new ResolutionEvent(inappmessage.getId(), hashmap);
    }

    public static ResolutionEvent createDirectOpenResolutionEvent(InAppMessage inappmessage)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", "direct_open");
        return new ResolutionEvent(inappmessage.getId(), hashmap);
    }

    public static ResolutionEvent createExpiredResolutionEvent(InAppMessage inappmessage)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", "expired");
        hashmap.put("expiry", DateUtils.createIso8601TimeStamp(inappmessage.getExpiry()));
        return new ResolutionEvent(inappmessage.getId(), hashmap);
    }

    public static ResolutionEvent createReplacedResolutionEvent(InAppMessage inappmessage, InAppMessage inappmessage1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", "replaced");
        hashmap.put("replacement_id", inappmessage1.getId());
        return new ResolutionEvent(inappmessage.getId(), hashmap);
    }

    public static ResolutionEvent createTimedOutResolutionEvent(InAppMessage inappmessage, long l)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", "timed_out");
        hashmap.put("display_time", millisecondsToSecondsString(l));
        return new ResolutionEvent(inappmessage.getId(), hashmap);
    }

    public static ResolutionEvent createUserDismissedResolutionEvent(InAppMessage inappmessage, long l)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("type", "user_dismissed");
        hashmap.put("display_time", millisecondsToSecondsString(l));
        return new ResolutionEvent(inappmessage.getId(), hashmap);
    }

    protected final JSONObject getEventData()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.putOpt("id", id);
            jsonobject.putOpt("resolution", new JSONObject(resolutionData));
            jsonobject.putOpt("conversion_send_id", UAirship.shared().getAnalytics().getConversionSendId());
        }
        catch (JSONException jsonexception)
        {
            Logger.error("ResolutionEvent - Error constructing JSON data.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public final String getType()
    {
        return "in_app_resolution";
    }
}
