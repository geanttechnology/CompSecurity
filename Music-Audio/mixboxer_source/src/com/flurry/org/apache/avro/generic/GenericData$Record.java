// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import java.util.List;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericRecord, GenericData

public static class values
    implements GenericRecord, Comparable
{

    private final Schema schema;
    private final Object values[];

    public int compareTo(values values1)
    {
        return GenericData.get().compare(this, values1, schema);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((compareTo)obj);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof compareTo))
            {
                return false;
            }
            obj = (compareTo)obj;
            if (!schema.getFullName().equals(((schema) (obj)).schema.getFullName()))
            {
                return false;
            }
            if (GenericData.get().compare(this, obj, schema, true) != 0)
            {
                return false;
            }
        }
        return true;
    }

    public Object get(int i)
    {
        return values[i];
    }

    public Object get(String s)
    {
        s = schema.getField(s);
        if (s == null)
        {
            return null;
        } else
        {
            return values[s.values()];
        }
    }

    public Schema getSchema()
    {
        return schema;
    }

    public int hashCode()
    {
        return GenericData.get().hashCode(this, schema);
    }

    public void put(int i, Object obj)
    {
        values[i] = obj;
    }

    public void put(String s, Object obj)
    {
        com.flurry.org.apache.avro..Record record = schema.getField(s);
        if (record == null)
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Not a valid schema field: ").append(s).toString());
        } else
        {
            values[record.values()] = obj;
            return;
        }
    }

    public String toString()
    {
        return GenericData.get().toString(this);
    }

    public (Schema schema1)
    {
        if (schema1 == null || !com.flurry.org.apache.avro..Record.Record(schema1.getType()))
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Not a record schema: ").append(schema1).toString());
        } else
        {
            schema = schema1;
            values = new Object[schema1.getFields().size()];
            return;
        }
    }

    public values(values values1, boolean flag)
    {
        schema = values1.schema;
        values = new Object[schema.getFields().size()];
        if (flag)
        {
            for (int i = 0; i < values.length; i++)
            {
                values[i] = GenericData.access$000().deepCopy(((com.flurry.org.apache.avro..deepCopy)schema.getFields().get(i)).(), values1.values[i]);
            }

        } else
        {
            System.arraycopy(((Object) (values1.values)), 0, ((Object) (values)), 0, values1.values.length);
        }
    }
}
