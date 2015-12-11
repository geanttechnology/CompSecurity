// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.amazon.sdk.availability:
//            Evaluator, Logger

public static abstract class data
{

    protected final JSONArray arguments;
    protected final JSONObject data;
    private final String opName;

    public static data fromJson(JSONObject jsonobject, JSONObject jsonobject1)
        throws JSONException, tion
    {
        if (jsonobject == null)
        {
            throw new JSONException("expression may not be null");
        }
        Iterator iterator = jsonobject.keys();
        String s = (String)iterator.next();
        jsonobject = jsonobject.getJSONArray(s);
        Logger.v((new StringBuilder()).append("Node is ").append(s).toString());
        if (iterator.hasNext())
        {
            throw new tion("Syntax error in rules, current level has more than one outer object.");
        } else
        {
            return fromKeywordAndArgs(s, jsonobject, jsonobject1);
        }
    }

    public static fromKeywordAndArgs fromKeywordAndArgs(String s, JSONArray jsonarray, JSONObject jsonobject)
        throws tion
    {
        if ("and".equals(s))
        {
            return new (jsonarray, jsonobject);
        }
        if ("or".equals(s))
        {
            return new (jsonarray, jsonobject);
        }
        if ("not".equals(s))
        {
            return new (jsonarray, jsonobject);
        }
        if ("eq".equals(s))
        {
            return new (jsonarray, jsonobject);
        } else
        {
            throw new tion((new StringBuilder()).append("Unknown keyword ").append(s).append(" detected.").toString());
        }
    }

    abstract boolean checkArguments();

    boolean evaluate(JSONObject jsonobject)
        throws JSONException, tion
    {
        return fromJson(jsonobject, data).evaluateOp();
    }

    abstract boolean evaluateImpl()
        throws JSONException, tion;

    boolean evaluateOp()
        throws tion
    {
        if (!checkArguments())
        {
            throw new tion((new StringBuilder()).append("Incorrect number of arguments for ").append(opName).append("(").append(arguments.length()).append(")").toString());
        }
        StringBuilder stringbuilder;
        int i;
        boolean flag;
        try
        {
            flag = evaluateImpl();
            stringbuilder = new StringBuilder();
            stringbuilder.append("operation ").append(opName).append(" with arguments ");
        }
        catch (JSONException jsonexception)
        {
            throw new tion((new StringBuilder()).append("Could not get value for ").append(opName).append(" while evaluating.").toString(), jsonexception);
        }
        i = 0;
        if (i >= arguments.length())
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(arguments.get(i)).append(", ");
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_91;
_L1:
        stringbuilder.append(" returning ").append(flag);
        Logger.v(stringbuilder.toString());
        return flag;
    }

    protected tion(JSONArray jsonarray, String s, JSONObject jsonobject)
    {
        arguments = jsonarray;
        opName = s;
        data = jsonobject;
    }
}
