// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest.crash;

import com.newrelic.agent.android.harvest.type.HarvestableObject;
import com.newrelic.com.google.gson.JsonElement;
import com.newrelic.com.google.gson.JsonObject;
import com.newrelic.com.google.gson.JsonPrimitive;

public class ExceptionInfo extends HarvestableObject
{

    private String className;
    private String message;

    public ExceptionInfo()
    {
    }

    public ExceptionInfo(Throwable throwable)
    {
        if (throwable.getClass().getName().equalsIgnoreCase("com.newrelic.agent.android.unity.UnityException"))
        {
            className = throwable.toString();
        } else
        {
            className = throwable.getClass().getName();
        }
        if (throwable.getMessage() != null)
        {
            message = throwable.getMessage();
            return;
        } else
        {
            message = "";
            return;
        }
    }

    public static ExceptionInfo newFromJson(JsonObject jsonobject)
    {
        ExceptionInfo exceptioninfo = new ExceptionInfo();
        String s;
        if (jsonobject.has("name"))
        {
            s = jsonobject.get("name").getAsString();
        } else
        {
            s = "";
        }
        exceptioninfo.className = s;
        if (jsonobject.has("cause"))
        {
            jsonobject = jsonobject.get("cause").getAsString();
        } else
        {
            jsonobject = "";
        }
        exceptioninfo.message = jsonobject;
        return exceptioninfo;
    }

    public JsonObject asJsonObject()
    {
        JsonObject jsonobject = new JsonObject();
        String s;
        if (className != null)
        {
            s = className;
        } else
        {
            s = "";
        }
        jsonobject.add("name", new JsonPrimitive(s));
        if (message != null)
        {
            s = message;
        } else
        {
            s = "";
        }
        jsonobject.add("cause", new JsonPrimitive(s));
        return jsonobject;
    }

    public String getClassName()
    {
        return className;
    }

    public String getMessage()
    {
        return message;
    }
}
