// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.analytics.Event;
import com.urbanairship.util.UAStringUtil;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.push.iam:
//            InAppMessage

public class DisplayEvent extends Event
{

    private static final String CONVERSION_SEND_ID = "conversion_send_id";
    private static final String ID = "id";
    private static final String TYPE = "in_app_display";
    private final String id;

    public DisplayEvent(InAppMessage inappmessage)
    {
        id = inappmessage.getId();
    }

    protected final JSONObject getEventData()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.putOpt("id", id);
            jsonobject.putOpt("conversion_send_id", UAirship.shared().getAnalytics().getConversionSendId());
        }
        catch (JSONException jsonexception)
        {
            Logger.error("DisplayEvent - Error constructing JSON data.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public final String getType()
    {
        return "in_app_display";
    }

    public boolean isValid()
    {
        return !UAStringUtil.isEmpty(id);
    }
}
