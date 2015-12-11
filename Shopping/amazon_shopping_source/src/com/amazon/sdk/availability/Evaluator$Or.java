// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Evaluator

public static class ration extends ration
{

    boolean checkArguments()
    {
        return 1 < arguments.length();
    }

    boolean evaluateImpl()
        throws JSONException, seException
    {
        boolean flag = false;
        int j = arguments.length();
        int i = 0;
        do
        {
label0:
            {
                boolean flag1 = flag;
                if (i < j)
                {
                    flag |= evaluate(arguments.getJSONObject(i));
                    if (!flag)
                    {
                        break label0;
                    }
                    flag1 = flag;
                }
                return flag1;
            }
            i++;
        } while (true);
    }

    seException(JSONArray jsonarray, JSONObject jsonobject)
    {
        super(jsonarray, "or", jsonobject);
    }
}
