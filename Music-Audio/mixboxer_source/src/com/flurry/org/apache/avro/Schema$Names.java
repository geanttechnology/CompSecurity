// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema, SchemaParseException

static class space extends LinkedHashMap
{

    private String space;

    public void add(Schema schema)
    {
        put(((chema)schema).name, schema);
    }

    public boolean contains(Schema schema)
    {
        return get(((chema)schema).name) != null;
    }

    public Schema get(Object obj)
    {
        if (obj instanceof String)
        {
            chema.name name = (chema.name)Schema.PRIMITIVES.get((String)obj);
            if (name != null)
            {
                return Schema.create(name);
            }
            obj = new init>((String)obj, space);
        } else
        {
            obj = (space)obj;
        }
        return (Schema)super.get(obj);
    }

    public volatile Object get(Object obj)
    {
        return get(obj);
    }

    public Schema put(get get1, Schema schema)
    {
        if (containsKey(get1))
        {
            throw new SchemaParseException((new StringBuilder()).append("Can't redefine: ").append(get1).toString());
        } else
        {
            return (Schema)super.put(get1, schema);
        }
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((put)obj, (Schema)obj1);
    }

    public String space()
    {
        return space;
    }

    public void space(String s)
    {
        space = s;
    }



/*
    static String access$1102(ception ception, String s)
    {
        ception.space = s;
        return s;
    }

*/

    public space()
    {
    }

    public space(String s)
    {
        space = s;
    }
}
