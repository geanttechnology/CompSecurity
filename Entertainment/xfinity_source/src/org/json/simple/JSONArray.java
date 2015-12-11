// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.json.simple:
//            JSONAware, JSONValue

public class JSONArray extends ArrayList
    implements List, JSONAware
{

    public JSONArray()
    {
    }

    public static String toJSONString(List list)
    {
        if (list == null)
        {
            return "null";
        }
        boolean flag = true;
        StringBuffer stringbuffer = new StringBuffer();
        list = list.iterator();
        stringbuffer.append('[');
        while (list.hasNext()) 
        {
            Object obj;
            if (flag)
            {
                flag = false;
            } else
            {
                stringbuffer.append(',');
            }
            obj = list.next();
            if (obj == null)
            {
                stringbuffer.append("null");
            } else
            {
                stringbuffer.append(JSONValue.toJSONString(obj));
            }
        }
        stringbuffer.append(']');
        return stringbuffer.toString();
    }

    public String toJSONString()
    {
        return toJSONString(((List) (this)));
    }

    public String toString()
    {
        return toJSONString();
    }
}
