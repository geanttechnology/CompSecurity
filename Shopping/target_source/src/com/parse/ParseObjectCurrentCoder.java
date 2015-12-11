// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObjectCoder, ParseImpreciseDateFormat, ParseObject, ParseDateFormat, 
//            ParseDecoder, ParseEncoder, ParseOperationSet

class ParseObjectCurrentCoder extends ParseObjectCoder
{

    private static final ParseObjectCurrentCoder INSTANCE = new ParseObjectCurrentCoder();
    private static final String KEY_CLASS_NAME = "classname";
    private static final String KEY_CREATED_AT = "createdAt";
    private static final String KEY_DATA = "data";
    private static final String KEY_OBJECT_ID = "objectId";
    private static final String KEY_OLD_CREATED_AT = "created_at";
    private static final String KEY_OLD_OBJECT_ID = "id";
    private static final String KEY_OLD_POINTERS = "pointers";
    private static final String KEY_OLD_UPDATED_AT = "updated_at";
    private static final String KEY_UPDATED_AT = "updatedAt";

    ParseObjectCurrentCoder()
    {
    }

    public static ParseObjectCurrentCoder get()
    {
        return INSTANCE;
    }

    public ParseObject.State.Init decode(ParseObject.State.Init init, JSONObject jsonobject, ParseDecoder parsedecoder)
    {
        Object obj;
        if (jsonobject.has("id"))
        {
            init.objectId(jsonobject.getString("id"));
        }
        if (!jsonobject.has("created_at"))
        {
            break MISSING_BLOCK_LABEL_55;
        }
        obj = jsonobject.getString("created_at");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        init.createdAt(ParseImpreciseDateFormat.getInstance().parse(((String) (obj))));
        if (!jsonobject.has("updated_at"))
        {
            break MISSING_BLOCK_LABEL_90;
        }
        obj = jsonobject.getString("updated_at");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_90;
        }
        init.updatedAt(ParseImpreciseDateFormat.getInstance().parse(((String) (obj))));
        if (jsonobject.has("pointers"))
        {
            obj = jsonobject.getJSONObject("pointers");
            String s1;
            JSONArray jsonarray;
            for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); init.put(s1, ParseObject.createWithoutData(jsonarray.optString(0), jsonarray.optString(1))))
            {
                s1 = (String)iterator.next();
                jsonarray = ((JSONObject) (obj)).getJSONArray(s1);
            }

        }
        try
        {
            jsonobject = jsonobject.optJSONObject("data");
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject.State.Init init)
        {
            throw new RuntimeException(init);
        }
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_323;
        }
        obj = jsonobject.keys();
_L3:
        String s;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_323;
        }
        s = (String)((Iterator) (obj)).next();
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
        init.put(s, parsedecoder.decode(jsonobject.get(s)));
          goto _L3
        return init;
    }

    public JSONObject encode(ParseObject.State state, ParseOperationSet parseoperationset, ParseEncoder parseencoder)
    {
        JSONObject jsonobject;
        if (parseoperationset != null)
        {
            throw new IllegalArgumentException("Parameter ParseOperationSet is not null");
        }
        parseoperationset = new JSONObject();
        jsonobject = new JSONObject();
        try
        {
            String s;
            for (Iterator iterator = state.keySet().iterator(); iterator.hasNext(); jsonobject.put(s, parseencoder.encode(state.get(s))))
            {
                s = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (ParseObject.State state)
        {
            throw new RuntimeException("could not serialize object to JSON");
        }
        if (state.createdAt() > 0L)
        {
            jsonobject.put("createdAt", ParseDateFormat.getInstance().format(new Date(state.createdAt())));
        }
        if (state.updatedAt() > 0L)
        {
            jsonobject.put("updatedAt", ParseDateFormat.getInstance().format(new Date(state.updatedAt())));
        }
        if (state.objectId() != null)
        {
            jsonobject.put("objectId", state.objectId());
        }
        parseoperationset.put("data", jsonobject);
        parseoperationset.put("classname", state.className());
        return parseoperationset;
    }

}
