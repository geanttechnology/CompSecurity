// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

final class JsonHelper
{

    JsonHelper()
    {
    }

    private static Object fromJson(Object obj)
    {
        Object obj1;
        if (obj == JSONObject.NULL)
        {
            obj1 = null;
        } else
        {
            if (obj instanceof JSONObject)
            {
                return toMap((JSONObject)obj);
            }
            obj1 = obj;
            if (obj instanceof JSONArray)
            {
                return toList((JSONArray)obj);
            }
        }
        return obj1;
    }

    static Map getMap(JSONObject jsonobject, String s)
    {
        return toMap(jsonobject.getJSONObject(s));
    }

    static boolean getSafeBooleanFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map instanceof Boolean)
        {
            return ((Boolean)map).booleanValue();
        }
        if (map instanceof Integer)
        {
            return ((Integer)map).intValue() != 0;
        }
        if (map instanceof String)
        {
            return ((String)map).equalsIgnoreCase("true");
        } else
        {
            return false;
        }
    }

    static int getSafeIntegerFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map == null)
        {
            return 0;
        }
        int i;
        if (map instanceof Integer)
        {
            i = ((Integer)map).intValue();
        } else
        if (map instanceof String)
        {
            i = Integer.parseInt((String)map);
        } else
        {
            i = 0;
        }
        return i;
    }

    static List getSafeListFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map == null)
        {
            return null;
        }
        if (map instanceof List)
        {
            map = (List)map;
        } else
        {
            map = null;
        }
        return map;
    }

    static Map getSafeMapFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map == null)
        {
            return null;
        }
        if (map instanceof Map)
        {
            map = (Map)map;
        } else
        {
            map = null;
        }
        return map;
    }

    static String getSafeStringFromMap(Map map, String s)
    {
        map = ((Map) (map.get(s)));
        if (map == null)
        {
            return null;
        }
        if (map instanceof Integer)
        {
            map = Integer.toString(((Integer)map).intValue());
        } else
        if (map instanceof String)
        {
            map = (String)map;
        } else
        {
            map = null;
        }
        return map;
    }

    static String getSafeStringFromValue(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof Integer)
        {
            obj = Integer.toString(((Integer)obj).intValue());
        } else
        if (obj instanceof String)
        {
            obj = (String)obj;
        } else
        {
            obj = null;
        }
        return ((String) (obj));
    }

    static boolean isEmptyObject(JSONObject jsonobject)
    {
        return jsonobject.names() == null;
    }

    static Object toJSON(Object obj)
    {
        Object obj1;
        if (obj instanceof Map)
        {
            obj1 = new JSONObject();
            obj = (Map)obj;
            Object obj2;
            for (Iterator iterator = ((Map) (obj)).keySet().iterator(); iterator.hasNext(); ((JSONObject) (obj1)).put(obj2.toString(), toJSON(((Map) (obj)).get(obj2))))
            {
                obj2 = iterator.next();
            }

        } else
        {
            obj1 = obj;
            if (obj instanceof Iterable)
            {
                JSONArray jsonarray = new JSONArray();
                for (obj = ((Iterable)obj).iterator(); ((Iterator) (obj)).hasNext(); jsonarray.put(toJSON(((Iterator) (obj)).next()))) { }
                return jsonarray;
            }
        }
        return obj1;
    }

    static List toList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(fromJson(jsonarray.get(i)));
        }

        return arraylist;
    }

    static Map toMap(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, fromJson(jsonobject.get(s))))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }
}
