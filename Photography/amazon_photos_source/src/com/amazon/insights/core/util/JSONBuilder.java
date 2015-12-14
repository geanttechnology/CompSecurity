// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.util;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.core.util:
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
        try
        {
            if (json != null)
            {
                return json.toString(4);
            }
        }
        catch (JSONException jsonexception)
        {
            return json.toString();
        }
        return "";
    }

    public JSONBuilder withAttribute(String s, Object obj)
    {
        if (obj instanceof JSONSerializable)
        {
            obj = ((JSONSerializable)obj).toJSONObject();
        }
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
