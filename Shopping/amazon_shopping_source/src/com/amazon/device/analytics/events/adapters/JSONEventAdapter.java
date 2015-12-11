// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.events.adapters;

import com.amazon.device.analytics.events.Event;
import com.amazon.device.analytics.log.Logger;
import com.amazon.device.analytics.log.Logging;
import com.amazon.device.analytics.util.JSONBuilder;
import org.json.JSONObject;

public class JSONEventAdapter
{

    private static Logger logger = Logging.getLogger(com/amazon/device/analytics/events/adapters/JSONEventAdapter);

    public JSONEventAdapter()
    {
    }

    public String toString()
    {
        return (new JSONBuilder(this)).toString();
    }

    public JSONObject translateFromEvent(Event event)
    {
        if (event == null)
        {
            logger.i("The Event provided was null");
            event = null;
        } else
        {
            JSONObject jsonobject = event.toJSONObject();
            if (jsonobject.has("class"))
            {
                jsonobject.remove("class");
            }
            event = jsonobject;
            if (jsonobject.has("hashCode"))
            {
                jsonobject.remove("hashCode");
                return jsonobject;
            }
        }
        return event;
    }

}
