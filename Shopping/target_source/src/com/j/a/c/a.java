// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.c;

import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import org.json.JSONArray;
import org.json.JSONException;

public class a extends JSONArray
{

    public a()
    {
    }

    public a(JSONArray jsonarray)
        throws JSONException
    {
        if (!(jsonarray instanceof JSONArray))
        {
            jsonarray = jsonarray.toString();
        } else
        {
            jsonarray = JSONArrayInstrumentation.toString((JSONArray)jsonarray);
        }
        super(jsonarray);
    }

    public a a(int i)
        throws JSONException
    {
        a a1 = new a();
        for (int j = 0; j < length(); j++)
        {
            if (j != i)
            {
                a1.put(opt(j));
            }
        }

        return a1;
    }

    public Boolean a(String s)
    {
        boolean flag;
        if (s != null && toString().contains(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }

    public JSONArray a()
        throws JSONException
    {
        return new JSONArray(toString());
    }
}
