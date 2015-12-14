// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseDecoder, ParseACL, ParseFieldOperation, ParseSetOperation, 
//            ParseObjectEncodingStrategy

class ParseOperationSet extends HashMap
{

    private static final String REST_KEY_IS_SAVE_EVENTUALLY = "__isSaveEventually";
    private static final String REST_KEY_UUID = "__uuid";
    private static final long serialVersionUID = 1L;
    private boolean isSaveEventually;
    private String uuid;

    public ParseOperationSet()
    {
        isSaveEventually = false;
        uuid = UUID.randomUUID().toString();
    }

    private ParseOperationSet(String s)
    {
        isSaveEventually = false;
        uuid = s;
    }

    public static ParseOperationSet fromRest(JSONObject jsonobject, ParseDecoder parsedecoder)
        throws JSONException
    {
        Iterator iterator = jsonobject.keys();
        String as[] = new String[jsonobject.length()];
        for (int i = 0; iterator.hasNext(); i++)
        {
            as[i] = (String)iterator.next();
        }

        JSONObject jsonobject1 = new JSONObject(jsonobject, as);
        jsonobject = (String)jsonobject1.remove("__uuid");
        Iterator iterator1;
        boolean flag;
        if (jsonobject == null)
        {
            jsonobject = new ParseOperationSet();
        } else
        {
            jsonobject = new ParseOperationSet(jsonobject);
        }
        flag = jsonobject1.optBoolean("__isSaveEventually");
        jsonobject1.remove("__isSaveEventually");
        jsonobject.setIsSaveEventually(flag);
        iterator1 = jsonobject1.keys();
        while (iterator1.hasNext()) 
        {
            String s = (String)iterator1.next();
            Object obj = parsedecoder.decode(jsonobject1.get(s));
            if (s.equals("ACL"))
            {
                obj = ParseACL.createACLFromJSONObject(jsonobject1.getJSONObject(s), parsedecoder);
            }
            if (obj instanceof ParseFieldOperation)
            {
                obj = (ParseFieldOperation)obj;
            } else
            {
                obj = new ParseSetOperation(obj);
            }
            jsonobject.put(s, obj);
        }
        return jsonobject;
    }

    public String getUUID()
    {
        return uuid;
    }

    public boolean isSaveEventually()
    {
        return isSaveEventually;
    }

    public void mergeFrom(ParseOperationSet parseoperationset)
    {
        ParseFieldOperation parsefieldoperation;
        String s;
        for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext(); put(s, parsefieldoperation))
        {
            s = (String)iterator.next();
            parsefieldoperation = (ParseFieldOperation)parseoperationset.get(s);
            ParseFieldOperation parsefieldoperation1 = (ParseFieldOperation)get(s);
            if (parsefieldoperation1 != null)
            {
                parsefieldoperation = parsefieldoperation1.mergeWithPrevious(parsefieldoperation);
            }
        }

    }

    public void setIsSaveEventually(boolean flag)
    {
        isSaveEventually = flag;
    }

    public JSONObject toRest(ParseObjectEncodingStrategy parseobjectencodingstrategy)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        String s;
        for (Iterator iterator = keySet().iterator(); iterator.hasNext(); jsonobject.put(s, ((ParseFieldOperation)get(s)).encode(parseobjectencodingstrategy)))
        {
            s = (String)iterator.next();
        }

        jsonobject.put("__uuid", uuid);
        if (isSaveEventually)
        {
            jsonobject.put("__isSaveEventually", true);
        }
        return jsonobject;
    }
}
