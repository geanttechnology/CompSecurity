// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Evaluator

public static class ation extends ation
{

    boolean checkArguments()
    {
        return 1 == arguments.length();
    }

    boolean evaluateImpl()
        throws JSONException, eException
    {
        boolean flag = false;
        if (!evaluate(arguments.getJSONObject(0)))
        {
            flag = true;
        }
        return flag;
    }

    eException(JSONArray jsonarray, JSONObject jsonobject)
    {
        super(jsonarray, "not", jsonobject);
    }
}
