// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseDateFormat, ParseACL, ParseDecoder, ParseOperationSet, 
//            ParseFieldOperation, ParseEncoder

class ParseObjectCoder
{

    private static final ParseObjectCoder INSTANCE = new ParseObjectCoder();
    private static final String KEY_ACL = "ACL";
    private static final String KEY_CLASS_NAME = "className";
    private static final String KEY_CREATED_AT = "createdAt";
    private static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_UPDATED_AT = "updatedAt";

    ParseObjectCoder()
    {
    }

    public static ParseObjectCoder get()
    {
        return INSTANCE;
    }

    public ParseObject.State.Init decode(ParseObject.State.Init init, JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        Iterator iterator = jsonobject.keys();
_L3:
        String s;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_192;
            }
            s = (String)iterator.next();
        } while (s.equals("__type") || s.equals("className"));
        if (!s.equals("objectId")) goto _L2; else goto _L1
_L1:
        init.objectId(jsonobject.getString(s));
          goto _L3
_L2:
label0:
        {
            if (!s.equals("createdAt"))
            {
                break label0;
            }
            init.createdAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
label1:
        {
            if (!s.equals("updatedAt"))
            {
                break label1;
            }
            init.updatedAt(ParseDateFormat.getInstance().parse(jsonobject.getString(s)));
        }
          goto _L3
label2:
        {
            if (!s.equals("ACL"))
            {
                break label2;
            }
            init.put("ACL", ParseACL.createACLFromJSONObject(jsonobject.getJSONObject(s), parsedecoder));
        }
          goto _L3
        try
        {
            init.put(s, parsedecoder.decode(jsonobject.get(s)));
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject.State.Init init)
        {
            throw new RuntimeException(init);
        }
          goto _L3
        return init;
    }

    public JSONObject encode(ParseObject.State state, ParseOperationSet parseoperationset, ParseEncoder parseencoder)
    {
        JSONObject jsonobject;
        jsonobject = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = parseoperationset.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, parseencoder.encode((ParseFieldOperation)parseoperationset.get(s))))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (ParseObject.State state)
        {
            throw new RuntimeException("could not serialize object to JSON");
        }
        if (state.objectId() != null)
        {
            jsonobject.put("objectId", state.objectId());
        }
        return jsonobject;
    }

}
