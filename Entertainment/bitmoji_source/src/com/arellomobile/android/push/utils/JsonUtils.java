// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils
{

    public JsonUtils()
    {
    }

    public static JSONArray arrayToJson(Object obj)
        throws JSONException
    {
        if (!obj.getClass().isArray())
        {
            throw new JSONException((new StringBuilder()).append("Not a primitive data: ").append(obj.getClass()).toString());
        }
        int j = Array.getLength(obj);
        JSONArray jsonarray = new JSONArray();
        for (int i = 0; i < j; i++)
        {
            jsonarray.put(wrap(Array.get(obj, i)));
        }

        return jsonarray;
    }

    public static JSONArray collectionToJson(Collection collection)
    {
        JSONArray jsonarray = new JSONArray();
        if (collection != null)
        {
            for (collection = collection.iterator(); collection.hasNext(); jsonarray.put(wrap(collection.next()))) { }
        }
        return jsonarray;
    }

    public static JSONObject mapToJson(Map map)
    {
        JSONObject jsonobject = new JSONObject();
        if (map == null)
        {
            return new JSONObject();
        }
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            String s = (String)entry.getKey();
            if (s == null)
            {
                throw new NullPointerException("key == null");
            }
            try
            {
                jsonobject.put(s, wrap(entry.getValue()));
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
            }
        }

        return jsonobject;
    }

    private static Object wrap(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Object obj1 = null;
_L4:
        return obj1;
_L2:
        obj1 = obj;
        if (obj instanceof JSONArray) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        if (obj instanceof JSONObject) goto _L4; else goto _L5
_L5:
        if (obj instanceof Collection)
        {
            return collectionToJson((Collection)obj);
        }
        if (obj.getClass().isArray())
        {
            return arrayToJson(obj);
        }
        if (obj instanceof Map)
        {
            return mapToJson((Map)obj);
        }
        obj1 = obj;
        if (obj instanceof Boolean) goto _L4; else goto _L6
_L6:
        obj1 = obj;
        if (obj instanceof Byte) goto _L4; else goto _L7
_L7:
        obj1 = obj;
        if (obj instanceof Character) goto _L4; else goto _L8
_L8:
        obj1 = obj;
        if (obj instanceof Double) goto _L4; else goto _L9
_L9:
        obj1 = obj;
        if (obj instanceof Float) goto _L4; else goto _L10
_L10:
        obj1 = obj;
        if (obj instanceof Integer) goto _L4; else goto _L11
_L11:
        obj1 = obj;
        if (obj instanceof Long) goto _L4; else goto _L12
_L12:
        obj1 = obj;
        if (obj instanceof Short) goto _L4; else goto _L13
_L13:
        obj1 = obj;
        if (obj instanceof String) goto _L4; else goto _L14
_L14:
        if (!obj.getClass().getPackage().getName().startsWith("java."))
        {
            break MISSING_BLOCK_LABEL_178;
        }
        obj = obj.toString();
        return obj;
        obj;
        return null;
    }
}
