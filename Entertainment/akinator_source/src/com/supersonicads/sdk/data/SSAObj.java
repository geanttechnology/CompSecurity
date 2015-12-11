// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SSAObj
{

    private JSONObject mJsonObject;

    public SSAObj()
    {
    }

    public SSAObj(String s)
    {
        setJsonObject(s);
    }

    private Object fromJson(Object obj)
        throws JSONException
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

    private JSONObject getJsonObject()
    {
        return mJsonObject;
    }

    private Map getMap(JSONObject jsonobject, String s)
        throws JSONException
    {
        return toMap(jsonobject.getJSONObject(s));
    }

    public static boolean isEmptyObject(JSONObject jsonobject)
    {
        return jsonobject.names() == null;
    }

    private void setJsonObject(String s)
    {
        try
        {
            mJsonObject = new JSONObject(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            mJsonObject = new JSONObject();
        }
    }

    public static Object toJSON(Object obj)
        throws JSONException
    {
        if (obj instanceof Map)
        {
            JSONObject jsonobject = new JSONObject();
            Map map = (Map)obj;
            Iterator iterator1 = map.keySet().iterator();
            do
            {
                obj = jsonobject;
                if (!iterator1.hasNext())
                {
                    break;
                }
                obj = iterator1.next();
                jsonobject.put(obj.toString(), toJSON(map.get(obj)));
            } while (true);
        } else
        if (obj instanceof Iterable)
        {
            JSONArray jsonarray = new JSONArray();
            Iterator iterator = ((Iterable)obj).iterator();
            do
            {
                obj = jsonarray;
                if (!iterator.hasNext())
                {
                    break;
                }
                jsonarray.put(iterator.next());
            } while (true);
        }
        return obj;
    }

    private Map toMap(JSONObject jsonobject)
        throws JSONException
    {
        HashMap hashmap = new HashMap();
        String s;
        for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); hashmap.put(s, fromJson(jsonobject.get(s))))
        {
            s = (String)iterator.next();
        }

        return hashmap;
    }

    public boolean containsKey(String s)
    {
        return getJsonObject().has(s);
    }

    public Object get(String s)
    {
        try
        {
            s = ((String) (getJsonObject().get(s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public boolean getBoolean(String s)
    {
        boolean flag;
        try
        {
            flag = mJsonObject.getBoolean(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    public String getString(String s)
    {
        try
        {
            s = mJsonObject.getString(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public boolean isNull(String s)
    {
        return getJsonObject().isNull(s);
    }

    public List toList(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(fromJson(jsonarray.get(i)));
        }

        return arraylist;
    }
}
