// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseEncoder, ParseObject

class PointerOrLocalIdEncoder extends ParseEncoder
{

    private static final PointerOrLocalIdEncoder INSTANCE = new PointerOrLocalIdEncoder();

    PointerOrLocalIdEncoder()
    {
    }

    public static PointerOrLocalIdEncoder get()
    {
        return INSTANCE;
    }

    public JSONObject encodeRelatedObject(ParseObject parseobject)
    {
        JSONObject jsonobject = new JSONObject();
        if (parseobject.getObjectId() == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        jsonobject.put("__type", "Pointer");
        jsonobject.put("className", parseobject.getClassName());
        jsonobject.put("objectId", parseobject.getObjectId());
        return jsonobject;
        try
        {
            jsonobject.put("__type", "Pointer");
            jsonobject.put("className", parseobject.getClassName());
            jsonobject.put("localId", parseobject.getOrCreateLocalId());
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            throw new RuntimeException(parseobject);
        }
        return jsonobject;
    }

}
