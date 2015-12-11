// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.json;

import com.urbanairship.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONStringer;

// Referenced classes of package com.urbanairship.json:
//            JsonValue

public class JsonMap
    implements Iterable
{

    private final Map map;

    public JsonMap(Map map1)
    {
        if (map1 == null)
        {
            map1 = new HashMap();
        } else
        {
            map1 = new HashMap(map1);
        }
        map = map1;
    }

    public boolean containsKey(String s)
    {
        return map.containsKey(s);
    }

    public boolean containsValue(JsonValue jsonvalue)
    {
        return map.containsValue(jsonvalue);
    }

    public Set entrySet()
    {
        return map.entrySet();
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof JsonMap)
        {
            return map.equals(((JsonMap)obj).map);
        } else
        {
            return false;
        }
    }

    public JsonValue get(String s)
    {
        return (JsonValue)map.get(s);
    }

    public Map getMap()
    {
        return new HashMap(map);
    }

    public int hashCode()
    {
        return map.hashCode();
    }

    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    public Iterator iterator()
    {
        return entrySet().iterator();
    }

    public Set keySet()
    {
        return map.keySet();
    }

    public JsonValue opt(String s)
    {
        s = get(s);
        if (s != null)
        {
            return s;
        } else
        {
            return JsonValue.NULL;
        }
    }

    public int size()
    {
        return map.size();
    }

    public String toString()
    {
        Object obj;
        try
        {
            obj = new JSONStringer();
            write(((JSONStringer) (obj)));
            obj = ((JSONStringer) (obj)).toString();
        }
        catch (JSONException jsonexception)
        {
            Logger.error("JsonMap - Failed to create JSON String.", jsonexception);
            return "";
        }
        return ((String) (obj));
    }

    public Collection values()
    {
        return new ArrayList(map.values());
    }

    void write(JSONStringer jsonstringer)
    {
        jsonstringer.object();
        java.util.Map.Entry entry;
        for (Iterator iterator1 = entrySet().iterator(); iterator1.hasNext(); ((JsonValue)entry.getValue()).write(jsonstringer))
        {
            entry = (java.util.Map.Entry)iterator1.next();
            jsonstringer.key((String)entry.getKey());
        }

        jsonstringer.endObject();
    }
}
