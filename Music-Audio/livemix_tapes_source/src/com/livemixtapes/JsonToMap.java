// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonToMap
{

    public JsonToMap()
    {
    }

    public static HashMap convert(JSONObject jsonobject)
    {
        HashMap hashmap = new HashMap();
        if (jsonobject != JSONObject.NULL)
        {
            try
            {
                jsonobject = toMap(jsonobject);
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                return hashmap;
            }
            return jsonobject;
        } else
        {
            return null;
        }
    }

    public static List toList(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        i = 0;
_L2:
        Object obj;
        Object obj1;
        if (i >= jsonarray.length())
        {
            return arraylist;
        }
        obj1 = jsonarray.get(i);
        if (!obj1.equals(JSONObject.NULL))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = null;
_L3:
        arraylist.add(obj);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj1 instanceof JSONArray)
        {
            obj = toList((JSONArray)obj1);
        } else
        {
            obj = obj1;
            if (obj1 instanceof JSONObject)
            {
                obj = toMap((JSONObject)obj1);
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private static HashMap toMap(JSONObject jsonobject)
        throws JSONException
    {
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = jsonobject.keys();
_L2:
        Object obj;
        Object obj1;
        String s;
        if (!iterator.hasNext())
        {
            return hashmap;
        }
        s = (String)iterator.next();
        obj1 = jsonobject.get(s);
        if (!obj1.equals(JSONObject.NULL))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = null;
_L3:
        hashmap.put(s, obj);
        if (true) goto _L2; else goto _L1
_L1:
        if (obj1 instanceof JSONArray)
        {
            obj = toList((JSONArray)obj1);
        } else
        {
            obj = obj1;
            if (obj1 instanceof JSONObject)
            {
                obj = toMap((JSONObject)obj1);
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }
}
