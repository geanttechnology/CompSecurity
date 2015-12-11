// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.c;

import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

public class d extends JSONObject
{

    public d(JSONObject jsonobject)
        throws JSONException
    {
        if (!(jsonobject instanceof JSONObject))
        {
            jsonobject = jsonobject.toString();
        } else
        {
            jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        }
        super(jsonobject);
    }

    public boolean a(String s)
    {
        return has(s) && !isNull(s);
    }

    public d b(String s)
        throws JSONException
    {
        return new d(getJSONObject(s));
    }
}
