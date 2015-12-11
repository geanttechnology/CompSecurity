// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import com.urbanairship.Logger;
import com.urbanairship.util.UAStringUtil;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            Event

public class PushArrivedEvent extends Event
{

    static final String TYPE = "push_arrived";
    private final String pushId;

    public PushArrivedEvent(String s)
    {
        pushId = s;
    }

    protected final JSONObject getEventData()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("push_id", pushId);
            jsonobject.put("connection_type", getConnectionType());
            String s = getConnectionSubType();
            if (!UAStringUtil.isEmpty(s))
            {
                jsonobject.put("connection_subtype", s);
            }
            jsonobject.put("carrier", getCarrier());
        }
        catch (JSONException jsonexception)
        {
            Logger.error("PushArrivedEvent - Error constructing JSON data.", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public final String getType()
    {
        return "push_arrived";
    }
}
