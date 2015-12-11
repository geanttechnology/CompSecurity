// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.playhaven.android.util;

import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPath;
import java.util.List;
import net.minidev.json.JSONObject;

public class JsonUtil
{

    public JsonUtil()
    {
    }

    public static Double asDouble(String s, String s1)
    {
        s = asString(s, s1);
        if (s == null)
        {
            return null;
        } else
        {
            return Double.valueOf(s);
        }
    }

    public static int asInt(String s, String s1, int i)
    {
        s = asInteger(s, s1);
        if (s == null)
        {
            return i;
        } else
        {
            return s.intValue();
        }
    }

    public static int asInt(JSONObject jsonobject, String s, int i)
    {
        jsonobject = asInteger(jsonobject, s);
        if (jsonobject == null)
        {
            return i;
        } else
        {
            return jsonobject.intValue();
        }
    }

    public static Integer asInteger(String s, String s1)
    {
        s = asString(s, s1);
        if (s == null)
        {
            return null;
        } else
        {
            return Integer.valueOf(s);
        }
    }

    public static Integer asInteger(JSONObject jsonobject, String s)
    {
        jsonobject = asString(jsonobject, s);
        if (jsonobject == null)
        {
            return null;
        } else
        {
            return Integer.valueOf(jsonobject);
        }
    }

    public static Long asLong(String s, String s1)
    {
        s = asString(s, s1);
        if (s == null)
        {
            return null;
        } else
        {
            return Long.valueOf(s);
        }
    }

    public static String asString(String s, String s1)
    {
        s = ((String) (JsonPath.read(s, s1, new Filter[0])));
        if (s == null)
        {
            return null;
        } else
        {
            return s.toString();
        }
    }

    public static String asString(JSONObject jsonobject, String s)
    {
        return asString(jsonobject.toJSONString(), s);
    }

    public static Iterable forEach(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return null;
        } else
        {
            return new _cls1((List)JsonPath.read(s, s1, new Filter[0]));
        }
    }

    public static Object getPath(String s, String s1)
    {
        try
        {
            s = ((String) (JsonPath.read(s, s1, new Filter[0])));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static Object getPath(JSONObject jsonobject, String s)
    {
        if (jsonobject == null)
        {
            jsonobject = null;
        } else
        {
            jsonobject = jsonobject.toJSONString();
        }
        return getPath(((String) (jsonobject)), s);
    }

    public static boolean hasPath(String s, String s1)
    {
        boolean flag = false;
        try
        {
            s = ((String) (JsonPath.read(s, s1, new Filter[0])));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (s != null)
        {
            flag = true;
        }
        return flag;
    }

    // Unreferenced inner class com/playhaven/android/util/JsonUtil$JSONIterator
    /* block-local class not found */
    class JSONIterator {}


    /* member class not found */
    class _cls1 {}

}
