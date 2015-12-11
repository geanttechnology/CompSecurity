// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema, AvroRuntimeException

private static class n extends Schema
{

    private final Map indexByName = new HashMap();
    private final List types;

    public void addProp(String s, String s1)
    {
        throw new AvroRuntimeException((new StringBuilder()).append("Can't set properties on a union: ").append(this).toString());
    }

    int computeHash()
    {
        int i = super.computeHash();
        for (Iterator iterator = types.iterator(); iterator.hasNext();)
        {
            i += ((Schema)iterator.next()).computeHash();
        }

        return i;
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof types))
            {
                return false;
            }
            obj = (types)obj;
            if (!equalCachedHash(((Schema) (obj))) || !types.equals(((types) (obj)).types) || !props.((() (obj)).props))
            {
                return false;
            }
        }
        return true;
    }

    public Integer getIndexNamed(String s)
    {
        return (Integer)indexByName.get(s);
    }

    public List getTypes()
    {
        return types;
    }

    void toJson(types types1, JsonGenerator jsongenerator)
        throws IOException
    {
        jsongenerator.writeStartArray();
        for (Iterator iterator = types.iterator(); iterator.hasNext(); ((Schema)iterator.next()).toJson(types1, jsongenerator)) { }
        jsongenerator.writeEndArray();
    }

    public yList(yList ylist)
    {
        super(yList);
        types = ylist.lock();
        int i = 0;
        for (ylist = ylist.iterator(); ylist.hasNext();)
        {
            Object obj = (Schema)ylist.next();
            if (((Schema) (obj)).getType() == yList.iterator)
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Nested union: ").append(this).toString());
            }
            obj = ((Schema) (obj)).getFullName();
            if (obj == null)
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Nameless in union:").append(this).toString());
            }
            if (indexByName.put(obj, Integer.valueOf(i)) != null)
            {
                throw new AvroRuntimeException((new StringBuilder()).append("Duplicate in union:").append(((String) (obj))).toString());
            }
            i++;
        }

    }
}
