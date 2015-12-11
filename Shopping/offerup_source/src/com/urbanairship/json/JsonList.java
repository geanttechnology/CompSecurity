// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.json;

import com.urbanairship.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONStringer;

// Referenced classes of package com.urbanairship.json:
//            JsonValue

public class JsonList
    implements Iterable
{

    private final List list;

    public JsonList(List list1)
    {
        if (list1 == null)
        {
            list1 = new ArrayList();
        } else
        {
            list1 = new ArrayList(list1);
        }
        list = list1;
    }

    public boolean contains(JsonValue jsonvalue)
    {
        return list.contains(jsonvalue);
    }

    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj instanceof JsonList)
        {
            return list.equals(((JsonList)obj).list);
        } else
        {
            return false;
        }
    }

    public JsonValue get(int i)
    {
        return (JsonValue)list.get(i);
    }

    public List getList()
    {
        return new ArrayList(list);
    }

    public int hashCode()
    {
        return list.hashCode();
    }

    public int indexOf(JsonValue jsonvalue)
    {
        return list.indexOf(jsonvalue);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public Iterator iterator()
    {
        return list.iterator();
    }

    public int lastIndexOf(JsonValue jsonvalue)
    {
        return list.indexOf(jsonvalue);
    }

    public int size()
    {
        return list.size();
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
            Logger.error("JsonList - Failed to create JSON String.", jsonexception);
            return "";
        }
        return ((String) (obj));
    }

    void write(JSONStringer jsonstringer)
    {
        jsonstringer.array();
        for (Iterator iterator1 = iterator(); iterator1.hasNext(); ((JsonValue)iterator1.next()).write(jsonstringer)) { }
        jsonstringer.endArray();
    }
}
