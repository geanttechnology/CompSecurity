// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.simple;

import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import myobfuscated.f.m;

// Referenced classes of package org.json.simple:
//            a, b

public class JSONObject extends HashMap
    implements Map, a, b
{

    private static final long serialVersionUID = 0xf9036888bc188444L;

    public JSONObject()
    {
    }

    public static String escape(String s)
    {
        return m.j(s);
    }

    private static String toJSONString(String s, Object obj, StringBuffer stringbuffer)
    {
        stringbuffer.append('"');
        if (s == null)
        {
            stringbuffer.append("null");
        } else
        {
            m.a(s, stringbuffer);
        }
        stringbuffer.append('"').append(':');
        stringbuffer.append(m.a(obj));
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

    public static String toString(String s, Object obj)
    {
        StringBuffer stringbuffer = new StringBuffer();
        toJSONString(s, obj, stringbuffer);
        return stringbuffer.toString();
    }

    public static void writeJSONString(Map map, Writer writer)
    {
        if (map == null)
        {
            writer.write("null");
            return;
        }
        boolean flag = true;
        map = map.entrySet().iterator();
        writer.write(123);
        while (map.hasNext()) 
        {
            java.util.Map.Entry entry;
            if (flag)
            {
                flag = false;
            } else
            {
                writer.write(44);
            }
            entry = (java.util.Map.Entry)map.next();
            writer.write(34);
            writer.write(escape(String.valueOf(entry.getKey())));
            writer.write(34);
            writer.write(58);
            m.a(entry.getValue(), writer);
        }
        writer.write(125);
    }

    public String toJSONString()
    {
        return toJSONString(((Map) (this)));
    }

    public String toString()
    {
        return toJSONString();
    }

    public void writeJSONString(Writer writer)
    {
        writeJSONString(((Map) (this)), writer);
    }
}
