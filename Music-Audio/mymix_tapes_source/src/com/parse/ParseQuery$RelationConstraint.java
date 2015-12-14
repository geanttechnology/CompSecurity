// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseQuery, ParseObjectEncodingStrategy, ParseObject, ParseRelation

static class object
{

    private String key;
    private ParseObject object;

    public JSONObject encode(ParseObjectEncodingStrategy parseobjectencodingstrategy)
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("key", key);
            jsonobject.put("object", parseobjectencodingstrategy.encodeRelatedObject(object));
        }
        // Misplaced declaration of an exception variable
        catch (ParseObjectEncodingStrategy parseobjectencodingstrategy)
        {
            throw new RuntimeException(parseobjectencodingstrategy);
        }
        return jsonobject;
    }

    public String getKey()
    {
        return key;
    }

    public ParseObject getObject()
    {
        return object;
    }

    public ParseRelation getRelation()
    {
        return object.getRelation(key);
    }

    public (String s, ParseObject parseobject)
    {
        if (s == null || parseobject == null)
        {
            throw new IllegalArgumentException("Arguments must not be null.");
        } else
        {
            key = s;
            object = parseobject;
            return;
        }
    }
}
