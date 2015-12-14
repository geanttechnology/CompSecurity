// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class i
{

    public final String a;
    public final Map b;
    public final int c;
    public final double d;
    public final int e;
    public final String f;

    i(String s, Map map, int j, double d1, int k, String s1)
    {
        a = s;
        if (map != null)
        {
            s = Collections.unmodifiableMap(map);
        } else
        {
            s = null;
        }
        b = s;
        c = j;
        d = d1;
        e = k;
        f = s1;
    }

    static i a(JSONObject jsonobject)
    {
        if (jsonobject.isNull("key"))
        {
            return null;
        }
        String s = jsonobject.getString("key");
        if (s.isEmpty())
        {
            return null;
        }
        double d1;
        String s1;
        int j;
        int k;
        j = jsonobject.optInt("count");
        d1 = jsonobject.optDouble("sum", 0.0D);
        k = jsonobject.optInt("timestamp");
        s1 = jsonobject.optString("tz");
        if (jsonobject.isNull("segmentation")) goto _L2; else goto _L1
_L1:
        HashMap hashmap;
        JSONObject jsonobject1;
        Iterator iterator;
        jsonobject1 = jsonobject.getJSONObject("segmentation");
        hashmap = new HashMap(jsonobject1.length());
        iterator = jsonobject1.keys();
_L4:
        jsonobject = hashmap;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        jsonobject = (String)iterator.next();
        if (!jsonobject1.isNull(jsonobject))
        {
            hashmap.put(jsonobject, jsonobject1.getString(jsonobject));
        }
        if (true) goto _L4; else goto _L3
_L2:
        jsonobject = null;
_L3:
        try
        {
            jsonobject = new i(s, jsonobject, j, d1, k, s1);
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.e("CountlyEvent", "Got exception converting JSON to an Event", jsonobject);
            return null;
        }
        return jsonobject;
    }

    JSONObject a()
    {
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("key", a);
            jsonobject.put("count", c);
            jsonobject.put("timestamp", e);
            jsonobject.put("tz", f);
            if (b != null)
            {
                jsonobject.put("segmentation", new JSONObject(b));
            }
            jsonobject.put("sum", d);
        }
        catch (JSONException jsonexception)
        {
            Log.e("CountlyEvent", "Got exception converting an Event to JSON", jsonexception);
            return jsonobject;
        }
        return jsonobject;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof i))
        {
            obj = (i)obj;
            if ((a != null ? a.equals(((i) (obj)).a) : ((i) (obj)).a == null) && e == ((i) (obj)).e && (b != null ? b.equals(((i) (obj)).b) : ((i) (obj)).b == null))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        int l = 1;
        int j;
        int k;
        if (a != null)
        {
            j = a.hashCode();
        } else
        {
            j = 1;
        }
        if (b != null)
        {
            k = b.hashCode();
        } else
        {
            k = 1;
        }
        if (e != 0)
        {
            l = e;
        }
        return j ^ k ^ l;
    }
}
