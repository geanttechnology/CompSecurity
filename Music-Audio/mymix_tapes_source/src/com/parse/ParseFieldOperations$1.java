// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseFieldOperations, ParseFieldOperation, ParseDecoder

static final class rseFieldOperationFactory
    implements rseFieldOperationFactory
{

    public ParseFieldOperation decode(JSONObject jsonobject, ParseDecoder parsedecoder)
        throws JSONException
    {
        Object obj = null;
        JSONArray jsonarray = jsonobject.getJSONArray("ops");
        int i = 0;
        jsonobject = obj;
        for (; i < jsonarray.length(); i++)
        {
            jsonobject = ParseFieldOperations.decode(jsonarray.getJSONObject(i), parsedecoder).mergeWithPrevious(jsonobject);
        }

        return jsonobject;
    }

    rseFieldOperationFactory()
    {
    }
}
