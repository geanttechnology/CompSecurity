// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Evaluator, Logger, StringUtil

public static class ration extends ration
{

    private String evaluateValue(JSONObject jsonobject, JSONObject jsonobject1)
        throws seException
    {
        String s = (String)jsonobject.keys().next();
        Logger.v((new StringBuilder()).append("Value Node is ").append(s).toString());
        if ("fetchKey".equals(s) || "metadataKey".equals(s))
        {
            jsonobject = jsonobject.optString(s);
            if (StringUtil.isEmpty(jsonobject))
            {
                throw new seException("Syntax error, empty keyname for fetchKey");
            } else
            {
                jsonobject = jsonobject1.optString(jsonobject);
                Logger.v((new StringBuilder()).append("Value Operation fetchKey returning ").append(jsonobject).toString());
                return jsonobject;
            }
        }
        if ("constant".equals(s))
        {
            jsonobject = jsonobject.optString(s);
            Logger.v((new StringBuilder()).append("Value Operation constant returning ").append(jsonobject).toString());
            return jsonobject;
        } else
        {
            throw new seException((new StringBuilder()).append("Syntax error, unknown value statement ").append(s).toString());
        }
    }

    boolean checkArguments()
    {
        return 1 < arguments.length();
    }

    boolean evaluateImpl()
        throws JSONException, seException
    {
        boolean flag = true;
        String s = evaluateValue(arguments.getJSONObject(0), data);
        int j = arguments.length();
        int i = 1;
        do
        {
label0:
            {
                boolean flag1 = flag;
                if (i < j)
                {
                    flag &= s.equals(evaluateValue(arguments.getJSONObject(i), data));
                    if (flag)
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
        super(jsonarray, "eq", jsonobject);
    }
}
