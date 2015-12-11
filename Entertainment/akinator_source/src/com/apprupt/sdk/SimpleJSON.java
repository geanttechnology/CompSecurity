// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.apprupt.sdk:
//            Logger

public class SimpleJSON
{

    public final JSONObject json;
    private JSONException lastError;

    public SimpleJSON()
    {
        this(new JSONObject());
    }

    public SimpleJSON(String s)
    {
        lastError = null;
        JSONObject jsonobject = new JSONObject(s);
        s = jsonobject;
_L2:
        json = s;
        return;
        JSONException jsonexception;
        jsonexception;
        JSONObject jsonobject1 = new JSONObject();
        lastError = jsonexception;
        Logger.get().e(jsonexception, new Object[] {
            "Cannot parse json", s
        });
        s = jsonobject1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public SimpleJSON(JSONObject jsonobject)
    {
        lastError = null;
        json = jsonobject;
    }

    private Object get(String s, Class class1, Object obj)
    {
        if (!json.has(s)) goto _L2; else goto _L1
_L1:
        Object obj1;
        boolean flag;
        try
        {
            obj1 = json.get(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = ((String) (obj));
            continue; /* Loop/switch isn't completed */
        }
        if (class1 == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        if (class1.isInstance(obj1))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        s = ((String) (obj));
        if (!class1.equals(org/json/JSONObject))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        flag = com/apprupt/sdk/SimpleJSON.isInstance(obj1);
        s = ((String) (obj));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        s = ((String) (obj1));
_L4:
        if (s != null && s.equals(JSONObject.NULL))
        {
            return null;
        }
        if (s instanceof JSONObject)
        {
            return new SimpleJSON((JSONObject)s);
        } else
        {
            return s;
        }
_L2:
        s = ((String) (obj));
        if (true) goto _L4; else goto _L3
_L3:
    }

    public SimpleJSON accumulate(String s, Object obj)
    {
        try
        {
            json.accumulate(s, obj);
        }
        catch (JSONException jsonexception)
        {
            Logger.get().e(jsonexception, new Object[] {
                "Invalid value passed to JSON.accumulate", s, obj
            });
            return this;
        }
        return this;
    }

    public Object get(String s)
    {
        return get(s, null, null);
    }

    public Object get(String s, Object obj)
    {
        return get(s, null, obj);
    }

    public boolean getBoolean(String s)
    {
        return getBoolean(s, false);
    }

    public boolean getBoolean(String s, boolean flag)
    {
        s = ((String) (get(s, java/lang/Boolean, Boolean.valueOf(false))));
        if (s == null)
        {
            return false;
        } else
        {
            return ((Boolean)s).booleanValue();
        }
    }

    public double getDouble(String s)
    {
        return getNumber(s).doubleValue();
    }

    public double getDouble(String s, Number number)
    {
        return getNumber(s, number).doubleValue();
    }

    public int getInt(String s)
    {
        return getNumber(s).intValue();
    }

    public int getInt(String s, Number number)
    {
        return getNumber(s, number).intValue();
    }

    public JSONArray getJSONArray(String s)
    {
        return (JSONArray)get(s, org/json/JSONArray, new JSONArray());
    }

    public JSONArray getJSONArray(String s, Class class1)
    {
        return getJSONArray(s, class1, null);
    }

    public JSONArray getJSONArray(String s, Class class1, JSONArray jsonarray)
    {
        JSONArray jsonarray1;
        jsonarray1 = new JSONArray();
        jsonarray = (JSONArray)get(s, org/json/JSONArray, jsonarray);
        s = class1;
        if (class1 != null)
        {
            s = class1;
            if (class1.equals(com/apprupt/sdk/SimpleJSON))
            {
                s = org/json/JSONObject;
            }
        }
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        int i;
        if (s == null || s.equals(java/lang/Object))
        {
            return jsonarray;
        }
        i = 0;
_L7:
        if (i >= jsonarray.length()) goto _L2; else goto _L3
_L3:
        class1 = ((Class) (jsonarray.get(i)));
        if (class1 == null) goto _L5; else goto _L4
_L4:
        if (s.isInstance(class1) && (!s.equals(org/json/JSONObject) || !com/apprupt/sdk/SimpleJSON.isInstance(class1)))
        {
            try
            {
                jsonarray1.put(class1);
            }
            // Misplaced declaration of an exception variable
            catch (Class class1)
            {
                Logger.get().e(class1, new Object[] {
                    "Cannot get item from array", Integer.valueOf(i)
                });
            }
        }
          goto _L5
_L2:
        return jsonarray1;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public JSONArray getJSONArray(String s, JSONArray jsonarray)
    {
        return (JSONArray)get(s, org/json/JSONArray, jsonarray);
    }

    public SimpleJSON getJSONObject(String s)
    {
        return (SimpleJSON)get(s, org/json/JSONObject, null);
    }

    public SimpleJSON getJSONObject(String s, SimpleJSON simplejson)
    {
        return (SimpleJSON)get(s, org/json/JSONObject, simplejson);
    }

    public SimpleJSON getJSONObject(String s, String s1)
    {
        s = (JSONObject)get(s, org/json/JSONObject, s1);
        if (s == null)
        {
            return null;
        } else
        {
            return new SimpleJSON(s);
        }
    }

    public SimpleJSON getJSONObject(String s, JSONObject jsonobject)
    {
        return (SimpleJSON)get(s, org/json/JSONObject, jsonobject);
    }

    public long getLong(String s)
    {
        return getNumber(s).longValue();
    }

    public long getLong(String s, Number number)
    {
        return getNumber(s, number).longValue();
    }

    public Number getNumber(String s)
    {
        return getNumber(s, ((Number) (Integer.valueOf(0))));
    }

    public Number getNumber(String s, Number number)
    {
        s = ((String) (get(s, java/lang/Number, number)));
        if (s == null)
        {
            return number;
        } else
        {
            return (Number)s;
        }
    }

    public String getString(String s)
    {
        return getString(s, null);
    }

    public String getString(String s, String s1)
    {
        return (String)get(s, java/lang/String, s1);
    }

    public List getStringsList(String s)
    {
        return getStringsList(s, null);
    }

    public List getStringsList(String s, List list)
    {
        s = getJSONArray(s, java/lang/String);
        if (s == null)
        {
            return list;
        }
        list = new ArrayList();
        int i = 0;
        while (i < s.length()) 
        {
            try
            {
                list.add(s.getString(i));
            }
            catch (JSONException jsonexception) { }
            i++;
        }
        return list;
    }

    public boolean has(String s)
    {
        return json.has(s);
    }

    public boolean isNull(String s)
    {
        return json.isNull(s);
    }

    public Iterator keys()
    {
        return json.keys();
    }

    public int lenght()
    {
        return json.length();
    }

    public JSONArray names()
    {
        return json.names();
    }

    public SimpleJSON put(String s, Object obj)
    {
        try
        {
            json.put(s, obj);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.get().e(s, new Object[] {
                "put(key, object) failed"
            });
            return this;
        }
        return this;
    }

    public Object remove(String s)
    {
        return json.remove(s);
    }

    public JSONArray toJSONArray(JSONArray jsonarray)
    {
        try
        {
            jsonarray = json.toJSONArray(jsonarray);
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            Logger.get().e(jsonarray, new Object[] {
                "toJSONArray failed"
            });
            return new JSONArray();
        }
        return jsonarray;
    }

    public String toString()
    {
        return json.toString();
    }

    public String toString(int i)
    {
        String s;
        try
        {
            s = json.toString(i);
        }
        catch (JSONException jsonexception)
        {
            Logger.get().e(jsonexception, new Object[] {
                "toString(int) failed"
            });
            return toString();
        }
        return s;
    }
}
