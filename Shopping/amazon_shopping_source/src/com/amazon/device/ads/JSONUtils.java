// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JSONUtils
{

    JSONUtils()
    {
    }

    protected static boolean getBooleanFromJSON(JSONObject jsonobject, String s, boolean flag)
    {
        return jsonobject.optBoolean(s, flag);
    }

    protected static int getIntegerFromJSON(JSONObject jsonobject, String s, int i)
    {
        return jsonobject.optInt(s, i);
    }

    protected static int getIntegerFromJSONArray(JSONArray jsonarray, int i, int j)
    {
        return jsonarray.optInt(i, j);
    }

    protected static JSONArray getJSONArrayFromJSON(JSONObject jsonobject, String s)
    {
        return jsonobject.optJSONArray(s);
    }

    protected static JSONObject getJSONObjectFromJSONArray(JSONArray jsonarray, int i)
    {
        try
        {
            jsonarray = jsonarray.getJSONObject(i);
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            return null;
        }
        return jsonarray;
    }

    protected static JSONObject getJSONObjectFromString(String s)
    {
        try
        {
            s = new JSONObject(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    protected static long getLongFromJSON(JSONObject jsonobject, String s, long l)
    {
        return jsonobject.optLong(s, l);
    }

    protected static String getStringFromJSON(JSONObject jsonobject, String s, String s1)
    {
        return jsonobject.optString(s, s1);
    }

    protected static void put(JSONObject jsonobject, String s, int i)
    {
        try
        {
            jsonobject.put(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    protected static void put(JSONObject jsonobject, String s, long l)
    {
        try
        {
            jsonobject.put(s, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }

    protected static void put(JSONObject jsonobject, String s, String s1)
    {
        if (s1 == null || s1.equals(""))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        jsonobject.put(s, s1);
        return;
        jsonobject;
    }
}
