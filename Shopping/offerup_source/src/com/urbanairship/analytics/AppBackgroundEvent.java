// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.util.UAStringUtil;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            Event, Analytics

class AppBackgroundEvent extends Event
{

    static final String TYPE = "app_background";

    AppBackgroundEvent(long l)
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
            jsonobject.put("push_id", UAirship.shared().getAnalytics().getConversionSendId());
        }
        catch (JSONException jsonexception)
        {
            Logger.error("AppBackgroundEvent - Error constructing JSON data.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public final String getType()
    {
        return "app_background";
    }
}
