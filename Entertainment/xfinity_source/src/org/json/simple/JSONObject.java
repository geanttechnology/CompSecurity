// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.simple;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.json.simple:
//            JSONAware, JSONValue

public class JSONObject extends HashMap
    implements Map, JSONAware
{

    public JSONObject()
    {
    }

    private static String toJSONString(String s, Object obj, StringBuffer stringbuffer)
    {
        stringbuffer.append('"');
        if (s == null)
        {
            stringbuffer.append("null");
        } else
        {
            JSONValue.escape(s, stringbuffer);
        }
        stringbuffer.append('"').append(':');
        stringbuffer.append(JSONValue.toJSONString(obj));
        return stringbuffer.toString();
    }

    public static String toJSONString(Map map)
    {
        if (map == null)
        {
            return "null";
        }
        StringBuffer stringbuffer = new StringBuffer();
        boolean flag = true;
        map = map.entrySet().iterator();
        stringbuffer.append('{');
        while (map.hasNext()) 
        {
            java.util.Map.Entry entry;
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuffer.append(',');
            }
            entry = (java.util.Map.Entry)map.next();
            toJSONString(String.valueOf(entry.getKey()), entry.getValue(), stringbuffer);
        }
        stringbuffer.append('}');
        return stringbuffer.toString();
    }

    public String toJSONString()
    {
        return toJSONString(((Map) (this)));
    }

    public String toString()
    {
        return toJSONString();
    }
}
