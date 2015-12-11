// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.minidev.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package net.minidev.json:
//            JSONAware, JSONAwareEx, JSONStreamAwareEx, JSONValue, 
//            JSONArray, JSONStyle

public class JSONObject extends HashMap
    implements JSONAware, JSONAwareEx, JSONStreamAwareEx
{

    private static final long serialVersionUID = 0xf9036888bc188444L;

    public JSONObject()
    {
    }

    public JSONObject(Map map)
    {
        super(map);
    }

    public static String escape(String s)
    {
        return JSONValue.escape(s);
    }

    protected static JSONArray merge(JSONArray jsonarray, Object obj)
    {
        if (obj == null)
        {
            return jsonarray;
        }
        if (jsonarray instanceof JSONArray)
        {
            return merge(jsonarray, (JSONArray)obj);
        } else
        {
            jsonarray.add(obj);
            return jsonarray;
        }
    }

    private static JSONArray merge(JSONArray jsonarray, JSONArray jsonarray1)
    {
        jsonarray.addAll(jsonarray1);
        return jsonarray;
    }

    protected static JSONObject merge(JSONObject jsonobject, Object obj)
    {
        if (obj == null)
        {
            return jsonobject;
        }
        if (obj instanceof JSONObject)
        {
            return merge(jsonobject, (JSONObject)obj);
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("JSON megre can not merge JSONObject with ").append(obj.getClass()).toString());
        }
    }

    private static JSONObject merge(JSONObject jsonobject, JSONObject jsonobject1)
    {
        if (jsonobject1 != null) goto _L2; else goto _L1
_L1:
        return jsonobject;
_L2:
label0:
        {
            Object obj;
            Object obj1;
label1:
            do
            {
                for (Iterator iterator = jsonobject.keySet().iterator(); iterator.hasNext();)
                {
                    String s = (String)iterator.next();
                    obj = jsonobject.get(s);
                    obj1 = jsonobject1.get(s);
                    if (obj1 != null)
                    {
                        if (obj instanceof JSONArray)
                        {
                            jsonobject.put(s, merge((JSONArray)obj, obj1));
                        } else
                        {
                            if (!(obj instanceof JSONObject))
                            {
                                continue label1;
                            }
                            jsonobject.put(s, merge((JSONObject)obj, obj1));
                        }
                    }
                }

                break label0;
            } while (obj.equals(obj1));
            throw new RuntimeException((new StringBuilder()).append("JSON megre can not merge ").append(obj.getClass()).append(" with ").append(obj1.getClass()).toString());
        }
        Iterator iterator1 = jsonobject1.keySet().iterator();
        while (iterator1.hasNext()) 
        {
            String s1 = (String)iterator1.next();
            if (!jsonobject.containsKey(s1))
            {
                jsonobject.put(s1, jsonobject1.get(s1));
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public static String toJSONString(Map map)
    {
        return toJSONString(map, JSONValue.COMPRESSION);
    }

    public static String toJSONString(Map map, JSONStyle jsonstyle)
    {
        StringBuilder stringbuilder = new StringBuilder();
        try
        {
            writeJSON(map, stringbuilder, jsonstyle);
        }
        // Misplaced declaration of an exception variable
        catch (Map map) { }
        return stringbuilder.toString();
    }

    public static void writeJSON(Map map, Appendable appendable)
        throws IOException
    {
        writeJSON(map, appendable, JSONValue.COMPRESSION);
    }

    public static void writeJSON(Map map, Appendable appendable, JSONStyle jsonstyle)
        throws IOException
    {
        if (map == null)
        {
            appendable.append("null");
            return;
        }
        boolean flag = true;
        appendable.append('{');
        map = map.entrySet().iterator();
        while (map.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            if (flag)
            {
                flag = false;
            } else
            {
                appendable.append(',');
            }
            writeJSONKV(entry.getKey().toString(), entry.getValue(), appendable, jsonstyle);
        }
        appendable.append('}');
    }

    public static void writeJSONKV(String s, Object obj, Appendable appendable, JSONStyle jsonstyle)
        throws IOException
    {
        if (s == null)
        {
            appendable.append("null");
        } else
        if (!jsonstyle.mustProtectKey(s))
        {
            appendable.append(s);
        } else
        {
            appendable.append('"');
            JSONValue.escape(s, appendable, jsonstyle);
            appendable.append('"');
        }
        appendable.append(':');
        if (obj instanceof String)
        {
            if (!jsonstyle.mustProtectValue((String)obj))
            {
                appendable.append((String)obj);
                return;
            } else
            {
                appendable.append('"');
                JSONValue.escape((String)obj, appendable, jsonstyle);
                appendable.append('"');
                return;
            }
        } else
        {
            JSONValue.writeJSONString(obj, appendable, jsonstyle);
            return;
        }
    }

    public void merge(Object obj)
    {
        merge(this, obj);
    }

    public String toJSONString()
    {
        return toJSONString(((Map) (this)), JSONValue.COMPRESSION);
    }

    public String toJSONString(JSONStyle jsonstyle)
    {
        return toJSONString(((Map) (this)), jsonstyle);
    }

    public String toString()
    {
        return toJSONString(this, JSONValue.COMPRESSION);
    }

    public String toString(JSONStyle jsonstyle)
    {
        return toJSONString(this, jsonstyle);
    }

    public void writeJSONString(Appendable appendable)
        throws IOException
    {
        writeJSON(this, appendable, JSONValue.COMPRESSION);
    }

    public void writeJSONString(Appendable appendable, JSONStyle jsonstyle)
        throws IOException
    {
        writeJSON(this, appendable, jsonstyle);
    }
}
