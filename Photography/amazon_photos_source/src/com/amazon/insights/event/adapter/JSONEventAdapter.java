// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.event.adapter;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.JSONBuilder;
import com.amazon.insights.event.InternalEvent;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.event.adapter:
//            EventAdapter

public class JSONEventAdapter
    implements EventAdapter
{

    private static Logger logger = Logger.getLogger(com/amazon/insights/event/adapter/JSONEventAdapter);

    public JSONEventAdapter()
    {
    }

    public String toString()
    {
        return (new JSONBuilder(this)).toString();
    }

    public volatile Object translateFromEvent(InternalEvent internalevent)
    {
        return translateFromEvent(internalevent);
    }

    public JSONObject translateFromEvent(InternalEvent internalevent)
    {
        if (internalevent == null)
        {
            logger.i("The Event provided was null");
            internalevent = null;
        } else
        {
            JSONObject jsonobject = internalevent.toJSONObject();
            if (jsonobject.has("class"))
            {
                jsonobject.remove("class");
            }
            internalevent = jsonobject;
            if (jsonobject.has("hashCode"))
            {
                jsonobject.remove("hashCode");
                return jsonobject;
            }
        }
        return internalevent;
    }

}
