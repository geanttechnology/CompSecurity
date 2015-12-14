// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.a;

import com.inmobi.commons.core.utilities.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends com.inmobi.commons.core.configs.a
{

    private static final String a = com/inmobi/commons/core/a/a.getSimpleName();
    private JSONObject b;

    public a()
    {
        try
        {
            b = f();
            return;
        }
        catch (Exception exception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error in default telemetry config");
        }
    }

    private JSONObject f()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("enabled", false);
        jsonobject.put("samplingFactor", 0);
        jsonobject.put("metricEnabled", false);
        return jsonobject;
    }

    public String a()
    {
        return "crashReporting";
    }

    public void a(JSONObject jsonobject)
    {
        try
        {
            super.a(jsonobject);
            b = jsonobject.getJSONObject("telemetry");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error parsing Crash Config ").append(jsonobject.toString()).toString());
        }
    }

    public JSONObject b()
    {
        JSONObject jsonobject;
        try
        {
            jsonobject = super.b();
            jsonobject.put("telemetry", b);
        }
        catch (JSONException jsonexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, (new StringBuilder()).append("Error parsing Crash Config ").append(jsonexception.toString()).toString());
            return null;
        }
        return jsonobject;
    }

    public boolean c()
    {
        return true;
    }

    public com.inmobi.commons.core.configs.a d()
    {
        return new a();
    }

    public JSONObject e()
    {
        return b;
    }

}
