// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import com.parse.codec.digest.DigestUtils;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            PointerOrLocalIdEncodingStrategy, Parse

class ParseJSONCacheItem
{

    private String hashValue;
    private JSONObject json;

    public ParseJSONCacheItem(Object obj)
        throws JSONException
    {
        json = new JSONObject();
        json.put("object", Parse.encode(obj, PointerOrLocalIdEncodingStrategy.get()));
        hashValue = DigestUtils.md5Hex(json.toString());
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
