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

    public static boolean getBooleanFromJSON(JSONObject jsonobject, String s, boolean flag)
    {
        if (jsonobject.isNull(s))
        {
            return flag;
        } else
        {
            return jsonobject.optBoolean(s, flag);
        }
    }

    public static int getIntegerFromJSON(JSONObject jsonobject, String s, int i)
    {
        if (jsonobject.isNull(s))
        {
            return i;
        } else
        {
            return jsonobject.optInt(s, i);
        }
    }

    public static int getIntegerFromJSONArray(JSONArray jsonarray, int i, int j)
    {
        if (jsonarray.isNull(i))
        {
            return j;
        } else
        {
            return jsonarray.optInt(i, j);
        }
    }

    public static JSONArray getJSONArrayFromJSON(JSONObject jsonobject, String s)
    {
        if (jsonobject.isNull(s))
        {
            return null;
        } else
        {
            return jsonobject.optJSONArray(s);
        }
    }

    public static JSONObject getJSONObjectFromJSONArray(JSONArray jsonarray, int i)
    {
        if (jsonarray.isNull(i))
        {
            return null;
        }
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

    public static JSONObject getJSONObjectFromString(String s)
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

    public static long getLongFromJSON(JSONObject jsonobject, String s, long l)
    {
        if (jsonobject.isNull(s))
        {
            return l;
        } else
        {
            return jsonobject.optLong(s, l);
        }
    }

    public static String getStringFromJSON(JSONObject jsonobject, String s, String s1)
    {
        if (jsonobject.isNull(s))
        {
            return s1;
        } else
        {
            return jsonobject.optString(s, s1);
        }
    }

    public static void put(JSONObject jsonobject, String s, int i)
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

    public static void put(JSONObject jsonobject, String s, long l)
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

    public static void put(JSONObject jsonobject, String s, String s1)
    {
        if (s1 == null || s1.equals(""))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        jsonobject.put(s, s1);
        return;
        jsonobject;
    }

    public static void put(JSONObject jsonobject, String s, boolean flag)
    {
        try
        {
            jsonobject.put(s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            return;
        }
    }
}
