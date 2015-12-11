// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.util;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.device.analytics.util:
//            JSONSerializable

public class JSONBuilder
    implements JSONSerializable
{

    private JSONObject json;

    public JSONBuilder(Object obj)
    {
        json = new JSONObject();
        if (obj != null)
        {
            withAttribute("class", obj.getClass().getName());
            withAttribute("hashCode", Integer.toHexString(obj.hashCode()));
        }
    }

    public JSONObject toJSONObject()
    {
        return json;
    }

    public String toString()
    {
        String s;
        try
        {
            s = json.toString(4);
        }
        catch (JSONException jsonexception)
        {
            return json.toString();
        }
        return s;
    }

    public JSONBuilder withAttribute(String s, Object obj)
    {
        if (obj == null)
        {
            return this;
        }
        if (!com/amazon/device/analytics/util/JSONSerializable.isAssignableFrom(obj.getClass()))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        json.putOpt(s, ((JSONSerializable)obj).toJSONObject());
        return this;
        try
        {
            json.putOpt(s, obj);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return this;
        }
        return this;
    }
}
