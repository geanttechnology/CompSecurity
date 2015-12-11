// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class cd
{

    public static int a(JSONObject jsonobject, String s, int i)
    {
        if (jsonobject.isNull(s))
        {
            return i;
        } else
        {
            return jsonobject.optInt(s, i);
        }
    }

    public static long a(JSONObject jsonobject, String s, long l)
    {
        if (jsonobject.isNull(s))
        {
            return l;
        } else
        {
            return jsonobject.optLong(s, l);
        }
    }

    public static String a(JSONObject jsonobject, String s, String s1)
    {
        if (jsonobject.isNull(s))
        {
            return s1;
        } else
        {
            return jsonobject.optString(s, s1);
        }
    }

    public static JSONArray a(JSONObject jsonobject, String s)
    {
        if (jsonobject.isNull(s))
        {
            return null;
        } else
        {
            return jsonobject.optJSONArray(s);
        }
    }

    public static JSONObject a(String s)
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

    public static JSONObject a(JSONArray jsonarray, int i)
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

    public static boolean a(JSONObject jsonobject, String s, boolean flag)
    {
        if (jsonobject.isNull(s))
        {
            return flag;
        } else
        {
            return jsonobject.optBoolean(s, flag);
        }
    }

    public static void b(JSONObject jsonobject, String s, int i)
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

    public static void b(JSONObject jsonobject, String s, long l)
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

    public static void b(JSONObject jsonobject, String s, String s1)
    {
        if (s1 == null || s1.equals(""))
        {
            break MISSING_BLOCK_LABEL_20;
        }
        jsonobject.put(s, s1);
        return;
        jsonobject;
    }

    public static void b(JSONObject jsonobject, String s, boolean flag)
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
