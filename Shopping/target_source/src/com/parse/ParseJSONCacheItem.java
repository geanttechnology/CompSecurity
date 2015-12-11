// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PointerOrLocalIdEncoder, ParseDigestUtils

class ParseJSONCacheItem
{

    private String hashValue;
    private JSONObject json;

    public ParseJSONCacheItem(Object obj)
        throws JSONException
    {
        json = new JSONObject();
        json.put("object", PointerOrLocalIdEncoder.get().encode(obj));
        obj = json;
        if (!(obj instanceof JSONObject))
        {
            obj = ((JSONObject) (obj)).toString();
        } else
        {
            obj = JSONObjectInstrumentation.toString((JSONObject)obj);
        }
        hashValue = ParseDigestUtils.md5(((String) (obj)));
    }

    public boolean equals(ParseJSONCacheItem parsejsoncacheitem)
    {
        return hashValue.equals(parsejsoncacheitem.getHashValue());
    }

    public String getHashValue()
    {
        return hashValue;
    }

    public Object getJSONObject()
    {
        Object obj;
        try
        {
            obj = json.get("object");
        }
        catch (JSONException jsonexception)
        {
            return null;
        }
        return obj;
    }
}
