// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.b;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{

    private final JSONObject eh;

    private a(JSONObject jsonobject)
    {
        eh = jsonobject;
    }

    private Object[] a(JSONArray jsonarray, Class class1)
    {
        Object obj;
        Object obj1;
        ArrayList arraylist;
        int i;
        try
        {
            arraylist = new ArrayList();
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            return null;
        }
        i = 0;
        if (i >= jsonarray.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = jsonarray.get(i);
        obj = obj1;
        if (class1 != com/sessionm/b/a)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        obj = obj1;
        if (obj1 instanceof JSONObject)
        {
            obj = w(obj1.toString());
        }
        arraylist.add(obj);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_12;
_L1:
        jsonarray = ((JSONArray) (arraylist.toArray((Object[])(Object[])Array.newInstance(class1, 0))));
        return jsonarray;
    }

    public static a aG()
    {
        return new a(new JSONObject());
    }

    public static a w(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = new a(new JSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = null;
        }
        return s;
    }

    public void a(Map map)
    {
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                put((String)entry.getKey(), entry.getValue());
            }
        }
    }

    public Object[] a(String s, Class class1)
    {
        try
        {
            s = ((String) (a(eh.getJSONArray(s), class1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public String[] aH()
    {
        return (String[])a(eh.names(), java/lang/String);
    }

    public JSONObject aI()
    {
        return eh;
    }

    public boolean getBoolean(String s)
    {
        return eh.optBoolean(s);
    }

    public int getInt(String s)
    {
        return eh.optInt(s);
    }

    public Integer getInteger(String s)
    {
        s = ((String) (eh.opt(s)));
        if (s instanceof Integer)
        {
            return (Integer)s;
        } else
        {
            return null;
        }
    }

    public long getLong(String s)
    {
        return eh.optLong(s);
    }

    public Object getObject(String s)
    {
        return eh.opt(s);
    }

    public String getString(String s)
    {
        return eh.optString(s, null);
    }

    public boolean has(String s)
    {
        return eh.has(s);
    }

    public boolean isNull(String s)
    {
        return eh.isNull(s);
    }

    public void put(String s, float f)
    {
        try
        {
            eh.put(s, f);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void put(String s, int i)
    {
        try
        {
            eh.put(s, i);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void put(String s, long l)
    {
        try
        {
            eh.put(s, l);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void put(String s, Object obj)
    {
        try
        {
            if (obj instanceof a)
            {
                eh.put(s, ((a)obj).aI());
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        eh.put(s, obj);
        return;
    }

    public void put(String s, String s1)
    {
        try
        {
            eh.put(s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void put(String s, boolean flag)
    {
        try
        {
            eh.put(s, flag);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public String toString()
    {
        return eh.toString();
    }

    public a x(String s)
    {
        try
        {
            s = new a(eh.getJSONObject(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public Long y(String s)
    {
        s = ((String) (eh.opt(s)));
        if (s instanceof Long)
        {
            return (Long)s;
        } else
        {
            return null;
        }
    }
}
